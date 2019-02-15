package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class Verb extends AsbtractConfigurationOption {
    private int verb;

    public Verb(int verb) {

        this.verb = verb;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("verb", Integer.toString(verb));
    }
}
