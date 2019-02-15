package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class PersistTun extends AsbtractConfigurationOption {
    public PersistTun() {
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("persist-tun");
    }
}
