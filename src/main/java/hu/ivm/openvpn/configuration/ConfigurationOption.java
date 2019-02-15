/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ivm.openvpn.configuration;

import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

/**
 *
 * @author gergely.asztalos
 */
public interface ConfigurationOption {

    void toString(ConfigurationOptionBuilder builder);
	
}
