package hu.ivm.openvpn.management.message.line;

import hu.ivm.openvpn.annotation.ManagementMessageLine;
import hu.ivm.openvpn.management.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ManagementMessageLine(types = {"BYTECOUNT","BYTECOUNT_CLI"})
public class BytecountLine implements Line<BytecountLine> {

	private Pattern pattern = Pattern.compile("^>(BYTECOUNT|BYTECOUNT_CLI):(,([^,]*)|)(,([^,]*)|)(,([^,]*)|)$");
	
	private boolean client;
	
	private int clientID = 0;

	private Long bytesIn = 0L;
	
	private Long bytesOut = 0L;
	
	@Override
	public BytecountLine parse(Client client, String line) {
		Matcher matcher = pattern.matcher(line);
		if(matcher.matches()) {
			String type = matcher.group(1);
			if("BYTECOUNT".equals(type)) {
				BytecountLine bytecountLine = new BytecountLine();
				bytecountLine.client = false;
				bytecountLine.bytesIn = Long.valueOf(matcher.group(3));
				bytecountLine.bytesOut = Long.valueOf(matcher.group(5));
				return bytecountLine;
			} else if ("BYTECOUNT_CLI".equals(type)) {
				BytecountLine bytecountLine = new BytecountLine();
				bytecountLine.client = true;
				bytecountLine.clientID = Integer.valueOf(matcher.group(3));
				bytecountLine.bytesIn = Long.valueOf(matcher.group(5));
				bytecountLine.bytesOut = Long.valueOf(matcher.group(7));
				return bytecountLine;
			}
		}
		return null;
	}

	public Long getBytesIn() {
		return bytesIn;
	}

	public void setBytesIn(Long bytesIn) {
		this.bytesIn = bytesIn;
	}

	public Long getBytesOut() {
		return bytesOut;
	}

	public void setBytesOut(Long bytesOut) {
		this.bytesOut = bytesOut;
	}
	
	
	
}
