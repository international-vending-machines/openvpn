package hu.ivm.openvpn.configuration.builder.packetfilter;

import hu.ivm.openvpn.configuration.StrBuilder;

/**
 *
 * @author gergely.asztalos
 */
public class Client {

	private String clientCommonName;
	private boolean include = false;

	public Client(String clientCommonName) {
		this.clientCommonName = clientCommonName;
	}

	public Client(String clientCommonName, boolean include) {
		this.clientCommonName = clientCommonName;
		this.include = include;
	}


	public boolean isInclude() {
		return include;
	}

	public void setInclude(boolean include) {
		this.include = include;
	}

	@Override
	public String toString() {
		StrBuilder sb = new StrBuilder();
		sb.append(include ? "+" : "-").append(clientCommonName).append("\n");
		return sb.toString();
	}

	public String getClientCommonName() {
		return clientCommonName;
	}

	public void setClientCommonName(String clientCommonName) {
		this.clientCommonName = clientCommonName;
	}
	
	
	
}
