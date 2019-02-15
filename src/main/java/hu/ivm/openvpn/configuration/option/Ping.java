package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.ConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class Ping implements ConfigurationOption {
    private int intervalSec;

    public Ping(int intervalSec) {
        this.intervalSec = intervalSec;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("ping", String.valueOf(intervalSec));
    }
}
