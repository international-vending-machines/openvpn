package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class Dev extends AsbtractConfigurationOption {
    private String dev;

    public Dev(String dev) {
        this.dev = dev;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("dev", dev);
    }
}
