package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class PersistKey extends AsbtractConfigurationOption {
    public PersistKey() {
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("persist-key");
    }
}
