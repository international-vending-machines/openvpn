/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ivm.openvpn.management.command;

import hu.ivm.openvpn.configuration.StrBuilder;

/**
 *
 * @author gergely.asztalos
 */
public interface Command {
	
	public void toString(StrBuilder sb);
}
