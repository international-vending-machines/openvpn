package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class TxQueueLen extends AsbtractConfigurationOption {
    private int len;

    public TxQueueLen(int len) {
        this.len = len;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("txqueuelen", Integer.toString(len));
    }
}
