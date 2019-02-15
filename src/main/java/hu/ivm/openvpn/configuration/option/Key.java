package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

import java.nio.file.Path;

public class Key extends AsbtractConfigurationOption {
    private Path keyPath;

    public Key(Path keyPath) {
        this.keyPath = keyPath;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("key", keyPath.toString());
    }
}
