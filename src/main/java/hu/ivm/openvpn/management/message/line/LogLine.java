package hu.ivm.openvpn.management.message.line;

import hu.ivm.openvpn.annotation.ManagementMessageLine;
import hu.ivm.openvpn.management.Client;

@ManagementMessageLine(types = {"LOG"})
public class LogLine implements Line<LogLine> {

	@Override
	public LogLine parse(Client client, String line) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
