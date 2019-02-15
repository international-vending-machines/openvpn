package hu.ivm.openvpn.management.command;

import hu.ivm.openvpn.configuration.StrBuilder;
import hu.ivm.openvpn.management.Client;

/**
 *
 * @author gergely.asztalos
 */
public class ExitCommand extends AbstractCommand {

	public ExitCommand() {
	}

	public ExitCommand(Client client) {
		super(client);
	}

	@Override
	public void toString(StrBuilder sb) {
		sb.append("exit").append("\n");
	}
	
}
