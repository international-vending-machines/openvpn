package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

import java.nio.file.Path;

public class Status extends AsbtractConfigurationOption {
    private final Path statusPath;
    private final int interval;

    public Status(Path statusPath, int interval) {
        this.statusPath = statusPath;
        this.interval = interval;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("status", statusPath.toString(), Integer.toString(interval));
    }
}
