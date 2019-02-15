package hu.ivm.openvpn.management.message.line;

import hu.ivm.openvpn.annotation.ManagementMessageLine;
import hu.ivm.openvpn.management.Client;

@ManagementMessageLine(types = {"NEED-OK"})
public class NeedOkLine implements Line<NeedOkLine> {

	@Override
	public NeedOkLine parse(Client client, String line) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
