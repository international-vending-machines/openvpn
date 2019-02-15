package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class ScriptSecurity extends AsbtractConfigurationOption {
    private int level;

    public ScriptSecurity(int level) {
        this.level = level;
    }


    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("script-security", Integer.toString(level));
    }
}
