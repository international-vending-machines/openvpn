package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class DuplicateCn extends AsbtractConfigurationOption {
    public DuplicateCn() {
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("duplicate-cn");
    }
}
