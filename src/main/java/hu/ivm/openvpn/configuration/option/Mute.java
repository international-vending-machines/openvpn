package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class Mute extends AsbtractConfigurationOption {
    private int mute;

    public Mute(int mute) {
        this.mute = mute;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("mute", Integer.toString(mute));
    }
}
