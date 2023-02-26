package hu.ivm.openvpn.management.command;

import hu.ivm.openvpn.configuration.StrBuilder;
import hu.ivm.openvpn.management.Client;

/**
 *
 * @author gergely.asztalos
 */
public class StatusCommand extends AbstractCommand {

	public StatusCommand() {
	}

	public StatusCommand(Client client) {
		super(client);
	}

	@Override
	public void toString(StrBuilder sb) {
		sb.append("status").append("\n");
	}
	
}
