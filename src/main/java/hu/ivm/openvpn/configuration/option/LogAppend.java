package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

import java.nio.file.Path;

public class LogAppend extends AsbtractConfigurationOption {
    private Path logPath;

    public LogAppend(Path logPath) {
        this.logPath = logPath;
    }


    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("log-append", logPath.toString());
    }
}
