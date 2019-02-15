package hu.ivm.openvpn.management.command;

import hu.ivm.openvpn.configuration.StrBuilder;
import hu.ivm.openvpn.management.Client;

/**
 *
 * @author gergely.asztalos
 */
public class QuitCommand extends AbstractCommand {

	public QuitCommand() {
	}

	public QuitCommand(Client client) {
		super(client);
	}

	@Override
	public void toString(StrBuilder sb) {
		sb.append("quit").append("\n");
	}
	
}
