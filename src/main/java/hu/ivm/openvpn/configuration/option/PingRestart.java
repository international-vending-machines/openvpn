package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.ConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class PingRestart implements ConfigurationOption {
    private int afterSec;

    public PingRestart(int afterSec) {
        this.afterSec = afterSec;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("ping-restart", String.valueOf(afterSec));
    }
}
