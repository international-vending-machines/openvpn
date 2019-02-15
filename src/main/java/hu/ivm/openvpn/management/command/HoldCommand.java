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
public class HoldCommand extends AbstractCommand {
	
	public enum Argument {
		SHOW,
		ON,
		OFF,
		RELEASE;
	}
	
	private Argument argument = Argument.SHOW;

	public HoldCommand() {
		super();
	}

	public HoldCommand(Client client) {
		super(client);
	}

	@Override
	public void toString(StrBuilder sb) {
		if(is(Argument.SHOW)) {
			sb.append("hold").append("\n\r");
		} else if(is(Argument.ON)) {
			sb.append("hold").space().append("on").append("\n\r");
		} else if(is(Argument.OFF)) {
			sb.append("hold").space().append("off").append("\n\r");
		} else if(is(Argument.RELEASE)) {
			sb.append("hold").space().append("release").append("\n\r");
		}
	}

	public boolean is(Argument argument) {
		if(argument == null) return false;
		return argument.equals(this.argument);
	}
	
	public HoldCommand on() {
		argument = Argument.ON;
		return this;
	}

	public HoldCommand off() {
		argument = Argument.OFF;
		return this;
	}

	public HoldCommand release() {
		argument = Argument.RELEASE;
		return this;
	}

	public HoldCommand show() {
		argument = Argument.SHOW;
		return this;
	}
	
}
