package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

import java.nio.file.Path;

public class Ca extends AsbtractConfigurationOption {
    private Path caPath;

    public Ca(Path caPath) {
        this.caPath = caPath;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("ca", caPath.toString());
    }
}
