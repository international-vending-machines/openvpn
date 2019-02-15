package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.ConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationBuilder;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class Push extends AsbtractConfigurationOption {
    private ConfigurationOption configurationOption;

    public Push(ConfigurationOption configurationOption) {
        this.configurationOption = configurationOption;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        ConfigurationOptionBuilder configurationOptionBuilder = new ConfigurationOptionBuilder(ConfigurationBuilder.MODE_PUSH);
        configurationOption.toString(configurationOptionBuilder);
        builder.appendOption("push", configurationOptionBuilder.toString());
    }
}
