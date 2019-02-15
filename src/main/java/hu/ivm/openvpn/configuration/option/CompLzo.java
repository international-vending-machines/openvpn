package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class CompLzo extends AsbtractConfigurationOption {
    public CompLzo() {
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("comp-lzo");
    }
}
