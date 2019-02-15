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
public class BytecountCommand extends AbstractCommand {
	
	private int interval = 0;

	@Override
	public void toString(StrBuilder sb) {
		sb.append("bytecount").space().append(interval).append("\n");
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	
	
}
