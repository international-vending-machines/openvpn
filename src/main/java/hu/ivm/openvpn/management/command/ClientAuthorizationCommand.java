/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ivm.openvpn.management.command;

import hu.ivm.openvpn.configuration.StrBuilder;
import hu.ivm.openvpn.configuration.builder.ConfigurationBuilder;
import hu.ivm.openvpn.configuration.builder.ConfigurationBuilderImpl;
import hu.ivm.openvpn.configuration.builder.PushBuilder;
import hu.ivm.openvpn.management.Client;

/**
 *
 * @author gergely.asztalos
 */
public class ClientAuthorizationCommand extends AbstractCommand implements Command {

	public enum Authorize {
		AUTH,
		DENY;
	}
	
	private int clientID = 0;
		
	private int keyID = 0;
	
	private Authorize auth = Authorize.DENY;
	
	private PushBuilder<? extends PushBuilder> pushBuilder = new ConfigurationBuilderImpl(ConfigurationBuilder.MODE_CONFIGURATION_FILE);
	
	private String reasonText;
	
	private String clientReasonText;

	public ClientAuthorizationCommand() {
	}

	public ClientAuthorizationCommand(Client client) {
		super(client);
	}

	
	@Override
	public void toString(StrBuilder sb) {
		if(is(Authorize.AUTH)) {
			sb.append("client-auth").ifTrue(isNullText()).append("-nt").space().append(clientID).space().append(keyID).append("\n");
			if(!isNullText()) {
				sb.append(pushBuilder.toString()).append("END").append("\n");
			}			
		} else if(is(Authorize.DENY)) {
			sb.append("client-deny").space().append(clientID).space().append(keyID).space()
					.appendQuote(reasonText).space().appendQuote(clientReasonText).append("\n\r");
		}
	}
	
	public boolean is(Authorize authorize) {
		if(authorize == null) return false;
		return authorize.equals(auth);
	}
	
	public boolean isNullText() {
		return pushBuilder.isEmpty();
	}	
		
	public PushBuilder pushBuilder() {
		return this.pushBuilder;
	}
	
	public ClientAuthorizationCommand auth(Authorize auth) {
		this.auth = auth;
		return this;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getKeyID() {
		return keyID;
	}

	public void setKeyID(int keyID) {
		this.keyID = keyID;
	}

	public String getReasonText() {
		return reasonText;
	}

	public void setReasonText(String reasonText) {
		this.reasonText = reasonText;
	}

	public String getClientReasonText() {
		return clientReasonText;
	}

	public void setClientReasonText(String clientReasonText) {
		this.clientReasonText = clientReasonText;
	}
	
	
	
}
