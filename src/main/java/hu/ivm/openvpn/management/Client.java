package hu.ivm.openvpn.management;

import com.sun.nio.sctp.IllegalReceiveException;
import hu.ivm.openvpn.annotation.ManagementMessageLine;
import hu.ivm.openvpn.management.message.line.LineError;
import hu.ivm.openvpn.management.message.ClientMessage;
import hu.ivm.openvpn.management.message.HoldMessage;
import hu.ivm.openvpn.management.message.InfoMessage;
import hu.ivm.openvpn.management.message.line.InfoLine;
import hu.ivm.openvpn.management.message.line.Line;
import hu.ivm.openvpn.management.command.Command;
import hu.ivm.openvpn.management.message.line.ClientLine;
import hu.ivm.openvpn.management.message.line.HoldLine;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.matchprocessor.ClassAnnotationMatchProcessor;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gergely.asztalos
 */
public class Client {

	private static final Logger LOGGER = LogManager.getLogger(Client.class);
	private final String name;

	private String host = "127.0.0.1";
	private Integer port = 9999;
	private Socket socket = null;

	private BufferedReader socketReader;
	private Writer socketWriter;

	private ClientListener clientListener;
	
	private String logPrefix() {
		return "["+name+"]";
	}

	public void addOutgoingCommand(Command command) {
		outgoingCommandQueue.add(command);
	}

	private class InboundThread extends Thread {

		@Override
		public void run() {
			try {
				while (true) {
					boolean connected = false;
					
					log("Wait for management interface...");
					while(!connected) {
						connected = connect();
						if(!connected) {
							Thread.sleep(2000);
						}
					}
					
					if (connected) {
						while (!socket.isClosed()) {
							try {
								waitForMessageLine();

								Line line = inboundMessageLineQueue.poll();

								if (line == null) {
									continue;
								}

								if (line instanceof ClientLine && EnumUtils.isValidEnum(ClientMessage.Type.class, ((ClientLine) line).getType().name())) {
									ClientLine clientLine = (ClientLine) line;

									ClientMessage message = new ClientMessage(Client.this, clientLine);
									if(clientLine.isEnd()) {
										clientListener.clientMessage(message, Client.this);
									} else {
										while(true) {
											waitForMessageLine();

											line = inboundMessageLineQueue.peek();

											if (line instanceof ClientLine && ((ClientLine) line).is(ClientLine.Type.ENV)) {
												ClientLine clientLineEnv = (ClientLine) line;
												if (clientLineEnv.isEnd()) {
													Client.this.logDebug(message);
													clientListener.clientMessage(message, Client.this);
													inboundMessageLineQueue.poll();
													break;
												} else {
													if(clientLineEnv.getEnv() != null) {
														message.addEnv(clientLineEnv.getEnv());
													} else {
														LOGGER.error("Env is null: " + clientLineEnv.toString());
													}
												}

												inboundMessageLineQueue.poll();
											} else {
												throw new IllegalReceiveException("ClientLine(ENV) required, received: " + line.toString());
											}
										}
									}
								} else if (line instanceof InfoLine) {
									InfoMessage message = new InfoMessage(Client.this, (InfoLine) line);
									clientListener.infoMessage(message, Client.this);
								} else if (line instanceof HoldLine) {
									HoldMessage message = new HoldMessage(Client.this, (HoldLine) line );
									clientListener.holdMessage(message, Client.this);
								} else if (line instanceof LineError) {
									logError(line);
								} else {
									throw new UnsupportedOperationException(line.toString());
								}
							} catch (Exception ex) {
								log(ex);
							}
						}
						
						if(!socket.isClosed()) {
							logWarn("Disconnected.");
						}
					}

					
				}

			} catch (InterruptedException ex) {
				log(ex);
			}
		}
	}

	private LinkedBlockingDeque<Command> outgoingCommandQueue = new LinkedBlockingDeque<>();

	private class OutgoingThread extends Thread {

		@Override
		public void run() {
			try {
				while (true) {
					if (socket == null || !socket.isConnected() || socketWriter == null) {
						Thread.sleep(1000);
						continue;
					}
					
					Command command = outgoingCommandQueue.take();
					try {
						logDebug("< " + command.toString());
						socketWriter.write(command.toString());
						socketWriter.flush();
					} catch (Exception e) {
						outgoingCommandQueue.putFirst(command);
					}
				}
			} catch (InterruptedException ex) {
				log(ex);
			}

		}

	}

	private InboundThread inboundThread = new InboundThread();
	private OutgoingThread outgoingThread = new OutgoingThread();

	private Map<String, Line> lineParserMap = new HashMap<>();

	public Client(String name, InetAddress address, int port, ClientListener managementListener) {
		this.name = name;
		this.clientListener = managementListener;

		ScanResult sr = new FastClasspathScanner("!!")
				.matchClassesWithAnnotation(ManagementMessageLine.class, new ClassAnnotationMatchProcessor() {
					@Override
					public void processMatch(Class<?> type) {
						ManagementMessageLine annotation = type.getAnnotation(ManagementMessageLine.class);
						if (annotation != null) {
							try {
								for(String _type : annotation.types()) {
									lineParserMap.put(_type, (Line) type.newInstance());
								}
							} catch (InstantiationException | IllegalAccessException ex) {
								log(ex);
							}
						}
					}
				}).scan();

	}

	public boolean connect() {

		try {
			this.socket = new Socket(); //host, port);
			SocketAddress sockaddr = new InetSocketAddress(host, port);
			this.socket.connect(sockaddr);
			socketReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			socketWriter = new OutputStreamWriter(this.socket.getOutputStream());
			outgoingCommandQueue.clear();
			inboundMessageLineQueue.clear();
			log("Connected.");
		} catch (IOException ex) {
			if(ex instanceof ConnectException) {
				log("ConnectException: " + ex.getMessage());				
			} else {
				log(ex);
			}
			return false;
		}
		return this.socket.isConnected();
	}

	public void start() {
		inboundThread.start();
		outgoingThread.start();
	}

	public enum PatternMatch {
		UNMATCHED,
		CONNECT,
		ENV;
	}

	public class PatternMatchObject {

		private PatternMatch pattendMatch;
		private Matcher matcher;

		public PatternMatchObject(PatternMatch pattendMatch) {
			this.pattendMatch = pattendMatch;
		}

	}

	private Pattern pConnect = Pattern.compile("^>CLIENT:(CONNECT|REAUTH),([0-9]+),([0-9]+)$");

	private Line lastInput = null;

	private BlockingQueue<Line> inboundMessageLineQueue = new LinkedBlockingQueue<>();

	public void waitForMessageLine() throws IOException {
		if (inboundMessageLineQueue.size() > 0) {
			return;
		}

		String line = socketReader.readLine();
		
		if(line == null) {
			socket.close();
			return;
		}

		logDebug("> " + line);

		if (line.startsWith(">")) {
			String[] split = StringUtils.split(line.substring(1), ":", 2);
			Line lineParser = lineParserMap.get(split[0]);

			Line lineInstance = null;

			if (lineParser != null) {
				try {
					lineInstance = lineParser.parse(this, line);
				} catch (Exception e) {
					log("Error while parse: " + line, e);
					lineInstance = new LineError(LineError.Type.EXCEPTION, line);
				}
				if (lineInstance == null) {
					lineInstance = new LineError(LineError.Type.NOT_PARSABLE, line);
				}
				
			} else {
				lineInstance = new LineError(LineError.Type.NO_PARSER, line);
			}

			inboundMessageLineQueue.add(lineInstance);
		}
	}
	
	public void log(Object msg, Throwable e) {
		LOGGER.error(logPrefix() + " " + StringEscapeUtils.ESCAPE_JAVA.translate(String.valueOf(msg)), e);
	}	
	
	public void log(Throwable e) {
		LOGGER.error(logPrefix() + " " + e.getMessage() + ":", e);
	}
	
	public void logError(Object msg) {
		LOGGER.error(logPrefix() + " " + StringEscapeUtils.ESCAPE_JAVA.translate(String.valueOf(msg)));
	}

	public void logWarn(Object msg) {
		LOGGER.warn(logPrefix() + " " + StringEscapeUtils.ESCAPE_JAVA.translate(String.valueOf(msg)));
	}

	public void log(Object msg) {
		LOGGER.info(logPrefix() + " " + StringEscapeUtils.ESCAPE_JAVA.translate(String.valueOf(msg)));
	}

	public void logDebug(Object msg) {
		LOGGER.debug(logPrefix() + " " + StringEscapeUtils.ESCAPE_JAVA.translate(String.valueOf(msg)));
	}

	public String getName() {
		return name;
	}
}
