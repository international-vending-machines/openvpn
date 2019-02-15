package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class Proto extends AsbtractConfigurationOption {
    private ProtoType type;

    public Proto(ProtoType type) {
        this.type = type;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("proto", type.getText());
    }
}
