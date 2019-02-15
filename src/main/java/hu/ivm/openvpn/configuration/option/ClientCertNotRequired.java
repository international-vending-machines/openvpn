package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class ClientCertNotRequired extends AsbtractConfigurationOption {
    public ClientCertNotRequired() {
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("client-cert-not-required");
    }
}
