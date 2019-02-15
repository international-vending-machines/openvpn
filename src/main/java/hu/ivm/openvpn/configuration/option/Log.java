package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

import java.nio.file.Path;

public class Log extends AsbtractConfigurationOption {
    private Path logPath;

    public Log(Path logPath) {
        this.logPath = logPath;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("log", logPath.toString());
    }
}
