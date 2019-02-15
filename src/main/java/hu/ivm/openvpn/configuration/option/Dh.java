package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

import java.nio.file.Path;

public class Dh extends AsbtractConfigurationOption {
    private Path dhPath;

    public Dh(Path dhPath) {
        this.dhPath = dhPath;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("dh", dhPath.toString());
    }
}
