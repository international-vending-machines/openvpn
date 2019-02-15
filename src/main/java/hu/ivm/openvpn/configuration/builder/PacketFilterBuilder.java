package hu.ivm.openvpn.configuration.builder;

import hu.ivm.openvpn.configuration.builder.packetfilter.Client;
import hu.ivm.openvpn.configuration.builder.packetfilter.Section;
import hu.ivm.openvpn.configuration.builder.packetfilter.Subnet;
import org.apache.commons.text.TextStringBuilder;


/**
 *
 * @author gergely.asztalos
 */
public class PacketFilterBuilder {
	
	private final Section<Client> clients = new Section<>("CLIENTS");
	
	private final Section<Subnet> subnets = new Section<>("SUBNETS");

	@Override
	public String toString() {
		TextStringBuilder sb = new TextStringBuilder();
		sb.append(clients.toString());
		sb.append(subnets.toString());
		sb.append("[END]").append("\n");
		return sb.toString();
	}
	
	public PacketFilterBuilder policyAccept() {
		return policy(true);
	}
	
	public PacketFilterBuilder policy(boolean accept) {
		clients.setAccept(accept);
		subnets.setAccept(accept);
		return this;
	}	
	
	public PacketFilterBuilder policyDrop() {
		return policy(false);
	}

	public PacketFilterBuilder policyClientsAccept() {
		return policyClients(true);
	}	

	public PacketFilterBuilder policyClients(boolean accept) {
		clients.setAccept(accept);
		return this;
	}
	
	public PacketFilterBuilder policyClientsDrop() {
		return policyClients(false);
	}
	
	public PacketFilterBuilder policySubnetsAccept() {
		return policySubnets(true);
	}	

	public PacketFilterBuilder policySubnets(boolean accept) {
		subnets.setAccept(accept);
		return this;
	}
	
	public PacketFilterBuilder policySubnetsDrop() {
		return policySubnets(false);
	}	
	
	public PacketFilterBuilder includeSubnet(String subnet) {
		subnets.add(new Subnet(subnet, true));
		return this;
	}
	
	public PacketFilterBuilder includeClient(String subnet) {
		clients.add(new Client(subnet, true));
		return this;
	}
	
	public PacketFilterBuilder exludeSubnet(String subnet) {
		subnets.add(new Subnet(subnet, false));
		return this;
	}
	
	public PacketFilterBuilder exludeClient(String subnet) {
		clients.add(new Client(subnet, false));
		return this;
	}
}
