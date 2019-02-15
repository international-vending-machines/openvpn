package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class UsernameAsCommonName extends AsbtractConfigurationOption {
    public UsernameAsCommonName() {
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("username-as-common-name");
    }
}
