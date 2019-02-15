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
public class PushRouteGateway extends AsbtractConfigurationOption {

	private InetAddress gw;
	
	public PushRouteGateway(InetAddress gw) {
		this.gw = gw;
	}

	@Override
	public void toString(ConfigurationOptionBuilder builder) {
		builder.appendOption("push", "route-gateway '"+ gw.getHostAddress() + "'");
	}
	
	
	
}
