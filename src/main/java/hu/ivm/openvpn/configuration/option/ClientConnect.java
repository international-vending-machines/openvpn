package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class ClientConnect extends AsbtractConfigurationOption {
    private String command;

    public ClientConnect(String command) {
        this.command = command;
    }


    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("client-connect", command);
    }
}
