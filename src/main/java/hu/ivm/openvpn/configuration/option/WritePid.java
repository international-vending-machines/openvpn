package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

import java.nio.file.Path;

public class WritePid extends AsbtractConfigurationOption {

    private Path pidPath;

    public WritePid(Path pidPath) {
        this.pidPath = pidPath;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("writepid", pidPath.toString());
    }
}
