package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class RenegSec extends AsbtractConfigurationOption {
    private int sec;

    public RenegSec(int sec) {
        this.sec = sec;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("reneg-sec", Integer.toString(sec));
    }
}
