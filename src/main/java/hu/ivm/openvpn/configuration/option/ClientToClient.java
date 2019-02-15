package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class ClientToClient extends AsbtractConfigurationOption {
    public ClientToClient() {
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("client-to-client");
    }
}
