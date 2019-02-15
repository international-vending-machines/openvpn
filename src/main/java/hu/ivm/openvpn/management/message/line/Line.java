/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ivm.openvpn.management.message.line;

import hu.ivm.openvpn.management.Client;

/**
 *
 * @author gergely.asztalos
 */
public interface Line<E extends Line> {
	
	public E parse(Client client, String line);
	
}
