package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class KeepAlive extends AsbtractConfigurationOption {
    private int interval;
    private int timeout;

    public KeepAlive(int interval, int timeout) {
        this.interval = interval;
        this.timeout = timeout;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("keepalive", Integer.toString(interval), Integer.toString(timeout));
    }
}
