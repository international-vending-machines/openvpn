package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.ConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class BcastBuffers implements ConfigurationOption {
    private int size;

    public BcastBuffers(int size) {
        this.size = size;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("bcast-buffers", Integer.toString(size));
    }
}
