package hu.ivm.openvpn.configuration.builder.packetfilter;

import hu.ivm.openvpn.configuration.StrBuilder;

/**
 *
 * @author gergely.asztalos
 */
public class Subnet {
	
	private String subnet;
	private boolean include = false;

	public Subnet(String subnet) {
		this.subnet = subnet;
	}

	public Subnet(String subnet, boolean include) {
		this.subnet = subnet;
		this.include = include;
	}

	public String getSubnet() {
		return subnet;
	}

	public void setSubnet(String subnet) {
		this.subnet = subnet;
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
		sb.append(include ? "+" : "-").append(subnet).append("\n");
		return sb.toString();
	}
	
}
