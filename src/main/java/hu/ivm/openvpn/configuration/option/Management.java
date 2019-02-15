package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class Management extends AsbtractConfigurationOption {
    private final String address;
    private final int port;

    public Management(String address, int port) {
        this.address = address;
        this.port = port;
    }


    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("management", address, Integer.toString(port));
    }
}
