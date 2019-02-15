package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class SuppressTimestamps extends AsbtractConfigurationOption {
    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("suppress-timestamps");
    }
}
