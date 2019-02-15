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
public abstract class AbstractCommand implements Command {
	
	protected Client client;

	public AbstractCommand() {
	}
	
	public AbstractCommand(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		StrBuilder sb = new StrBuilder();
		toString(sb);
		return sb.toString();
	}
	
	public void send() {
		this.client.addOutgoingCommand(this);
	}
	
}
