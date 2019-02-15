package hu.ivm.openvpn.management.message.line;

import hu.ivm.openvpn.annotation.ManagementMessageLine;
import hu.ivm.openvpn.management.Client;

@ManagementMessageLine(types = {"STATE"})
public class StateLine implements Line<StateLine> {

	@Override
	public StateLine parse(Client client, String line) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
