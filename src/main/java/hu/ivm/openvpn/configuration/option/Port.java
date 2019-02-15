package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class Port extends AsbtractConfigurationOption {
    private int port;

    public Port(int port) {
        this.port = port;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("port", Integer.toString(port));
    }
}
