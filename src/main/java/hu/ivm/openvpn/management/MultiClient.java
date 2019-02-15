/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ivm.openvpn.management;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gergely.asztalos
 */
public class MultiClient {
	
	private Map<String, Client> clientMap = new HashMap<>();
	
	public void addClient(String name, String address, int port, ClientListener listener) throws UnknownHostException {
		Client client = new Client(name, InetAddress.getByName(address), port, listener);
		clientMap.put(name, client);
	}
	
	public void start() {
		for(Map.Entry<String, Client> entry : clientMap.entrySet()) {
			entry.getValue().start();
		}
	}
	
}
