package hu.ivm.openvpn.management.command;

import hu.ivm.openvpn.configuration.StrBuilder;
import hu.ivm.openvpn.configuration.builder.PacketFilterBuilder;
import hu.ivm.openvpn.management.Client;

/**
 *
 * @author gergely.asztalos
 */
public class ClientPacketFilterCommand extends AbstractCommand {

	private int clientID = 0;
	
	private PacketFilterBuilder packetFilterBuilder = new PacketFilterBuilder();

	public ClientPacketFilterCommand() {
	}

	public ClientPacketFilterCommand(Client client) {
		super(client);
	}
	
	@Override
	public void toString(StrBuilder sb) {
		sb.append("client-pf").space().append(clientID).append("\n")
				.append(packetFilterBuilder.toString())
				.append("END").append("\n");
	}
	
	public PacketFilterBuilder packetFilterBuilder() {
		return this.packetFilterBuilder;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	
	
	
}
