/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ivm.openvpn.management.command;

import hu.ivm.openvpn.configuration.StrBuilder;
import hu.ivm.openvpn.management.Client;

/**
 *
 * @author gergely.asztalos
 */
public class HelpCommand extends AbstractCommand {

	public HelpCommand() {
	}

	public HelpCommand(Client client) {
		super(client);
	}

	@Override
	public void toString(StrBuilder sb) {
		sb.append("help").append("\n");
	}
	
}
