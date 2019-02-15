/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ivm.openvpn.management;

import hu.ivm.openvpn.management.message.*;

/**
 *
 * @author gergely.asztalos
 */
public interface ClientListener {

	public void bytecountMessage(BytecountMessage message, Client client);

	public void bytecountCliMessage(BytecountClientMessage message, Client client);
	
	public void clientMessage(ClientMessage message, Client client);
	
	public void echoMessage(EchoMessage message, Client client);
	
	public void fatalMessage(FatalMessage message, Client client);
	
	public void holdMessage(HoldMessage message, Client client);
	
	public void infoMessage(InfoMessage message, Client client);
	
	public void needOkMessage(NeedOkMessage message, Client client);
	
	public void needStrMessage(NeedStrMessage message, Client client);
	
	public void passwordMessage(PasswordMessage message, Client client);
	
	public void stateMessage(StateMessage message, Client client);
	
	
}
