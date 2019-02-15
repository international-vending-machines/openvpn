package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class Topology extends AsbtractConfigurationOption {
    private TopologyType type;

    public Topology(TopologyType type) {
        this.type = type;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("topology", type.getText());
    }
}
