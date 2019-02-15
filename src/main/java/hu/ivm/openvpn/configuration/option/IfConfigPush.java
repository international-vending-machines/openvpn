/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

import java.net.InetAddress;

/**
 *
 * @author gergely.asztalos
 */
public class IfConfigPush extends AsbtractConfigurationOption {
	
	private InetAddress ip;
	private InetAddress mask;

	public IfConfigPush(InetAddress ip, InetAddress mask) {
		this.ip = ip;
		this.mask = mask;
	}

	@Override
	public void toString(ConfigurationOptionBuilder builder) {
		builder.appendOption("ifconfig-push", ip.getHostAddress(), mask.getHostAddress());
	}
}
