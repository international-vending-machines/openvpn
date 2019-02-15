package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class TlsServer extends AsbtractConfigurationOption {
    public TlsServer() {
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("tls-server");
    }
}
