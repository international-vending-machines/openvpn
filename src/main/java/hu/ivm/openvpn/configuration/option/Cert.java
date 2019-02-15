package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

import java.nio.file.Path;

public class Cert extends AsbtractConfigurationOption {
    private Path certPath;

    public Cert(Path certPath) {
        this.certPath = certPath;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("cert", certPath.toString());
    }
}
