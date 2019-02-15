package hu.ivm.openvpn.management.message.line;

import hu.ivm.openvpn.management.Client;

public class UnknownLine implements Line<UnknownLine> {

	@Override
	public UnknownLine parse(Client client, String line) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
