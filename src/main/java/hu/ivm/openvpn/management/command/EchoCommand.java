package hu.ivm.openvpn.management.command;

import hu.ivm.openvpn.configuration.StrBuilder;
import hu.ivm.openvpn.management.Client;

/**
 *
 * @author gergely.asztalos
 */
public class EchoCommand extends AbstractCommand {
	
	private boolean on = false;
	
	private boolean print = false;

	public EchoCommand() {
	}

	public EchoCommand(Client client) {
		super(client);
	}	

	@Override
	public void toString(StrBuilder sb) {
		sb.append("echo").space().append(on ? "on" : "off").ifTrue(print && on, 2).space().append("all").append("\n");
	}
	
	public EchoCommand on(boolean on) {
		this.on = true;
		return this;
	}	
	
	public EchoCommand on() {
		return on(true);
	}
	
	public EchoCommand off() {
		return on(false);
	}
	
	public EchoCommand printOn(boolean print) {
		this.print = print;
		return this;
	}
		
	public EchoCommand printOn() {
		return printOn(false);
	}
	
	public EchoCommand printOff() {
		return printOn(true);
	}

	public boolean isOn() {
		return on;
	}

	public boolean isPrint() {
		return print;
	}
	
}
