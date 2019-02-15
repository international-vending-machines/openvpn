package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class TcpQueueLimit extends AsbtractConfigurationOption {
    private int limit;

    public TcpQueueLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("tcp-queue-limit", Integer.toString(limit));
    }
}
