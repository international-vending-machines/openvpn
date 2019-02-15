package hu.ivm.openvpn.management.message.line;

import hu.ivm.openvpn.annotation.ManagementMessageLine;
import hu.ivm.openvpn.management.Client;
import hu.ivm.openvpn.management.message.ClientMessage;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ManagementMessageLine(types = {"CLIENT"})
public class ClientLine implements Line<ClientLine> {
	
	public enum Type {
		CONNECT,
		REAUTH,
		ESTABLISHED,
		DISCONNECT,
		ADDRESS,
		ENV;
	}
	
	private static Pattern pattern = Pattern.compile("^>CLIENT:(CONNECT|REAUTH|ESTABLISHED|DISCONNECT|ADDRESS|ENV)(,([^,]*)|)(,([^,]*)|)(,([^,]*)|)(,([^,]*)|)$");
	
	private int clientID = 0;
	private int keyID = 0;
	
	private Type type = null;
	
	private String address = null;
	
	private Map.Entry<ClientMessage.Env,Object> env = null;
	
	private boolean end = false;
	
	private boolean primaryAddress = false;

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getKeyID() {
		return keyID;
	}

	public void setKeyID(int keyID) {
		this.keyID = keyID;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public ClientLine parse(Client client, String line) {
		Matcher matcher = pattern.matcher(line);
		if(matcher.matches() && EnumUtils.isValidEnum(Type.class, matcher.group(1))) {
			type = EnumUtils.getEnum(Type.class, matcher.group(1));			
			ClientLine cl = new ClientLine();
			cl.setType(type);
			switch (type) {
				case CONNECT:
				case REAUTH:
					cl.setClientID(Integer.valueOf(matcher.group(3)));
					cl.setKeyID(Integer.valueOf(matcher.group(5)));
					break;
				case ESTABLISHED:
					cl.setClientID(Integer.valueOf(matcher.group(3)));
					break;
				case DISCONNECT:
					cl.setClientID(Integer.valueOf(matcher.group(3)));
					break;
				case ADDRESS:
					cl.setClientID(Integer.valueOf(matcher.group(3)));
					cl.setAddress(matcher.group(5));
					cl.setPrimaryAddress("1".equals(matcher.group(7)));
					cl.setEnd(true);
					break;
				case ENV:
					String group = matcher.group(3);
					if("END".equals(group)) {
						cl.setEnd(true);
					} else {
						String[] split = StringUtils.split(group, "=", 2);
						ClientMessage.Env env = ClientMessage.Env.valueByKey(split[0]);
						if(env != null) {
							cl.setEnv(env, split[1]);
						} else {
							client.logError("Unknown env: " + split[0]);
						}
					}	break;					
				default:
					throw new UnsupportedOperationException("Unsupported type: " + type);
			}
			return cl;
		}
		return null;
	}

	public Map.Entry<ClientMessage.Env, Object> getEnv() {
		return env;
	}

	public void setEnv(Map.Entry<ClientMessage.Env, Object> env) {
		this.env = env;
	}
	
	public void setEnv(ClientMessage.Env key, Object value) {
		setEnv(new HashMap.SimpleEntry<>(key, value));
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public boolean isPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(boolean primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	
	public boolean is(Type type) {
		if(type == null) return false;
		return type.equals(this.type);
	}

	@Override
	public String toString() {
		return "ClientLine{" +
				"clientID=" + clientID +
				", keyID=" + keyID +
				", type=" + type +
				", address='" + address + '\'' +
				", env=" + env +
				", end=" + end +
				", primaryAddress=" + primaryAddress +
				'}';
	}
}
