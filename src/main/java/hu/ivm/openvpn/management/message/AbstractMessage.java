package hu.ivm.openvpn.management.message;

import hu.ivm.openvpn.management.Client;

/**
 *
 * @author gergely.asztalos
 */
public abstract class AbstractMessage implements Message {
	
	protected Client client;
	
	public AbstractMessage(Client client) {
		this.client = client;
	}
	
}
