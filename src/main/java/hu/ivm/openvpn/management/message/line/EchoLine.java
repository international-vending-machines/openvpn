package hu.ivm.openvpn.management.message.line;

import hu.ivm.openvpn.annotation.ManagementMessageLine;
import hu.ivm.openvpn.management.Client;

@ManagementMessageLine(types = {"ECHO"})
public class EchoLine implements Line<EchoLine> {

	@Override
	public EchoLine parse(Client client, String line) {
		throw new UnsupportedOperationException();
	}
	
}
