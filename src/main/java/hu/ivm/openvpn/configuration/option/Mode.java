package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class Mode extends AsbtractConfigurationOption {

    private ModeType type;

    public Mode(ModeType type) {
        this.type = type;
    }


    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("mode", type.getText());
    }
}
