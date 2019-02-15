package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

public class AuthUserPassVerify extends AsbtractConfigurationOption {
    private final String command;
    private final AuthUserPassVerifyMethod method;

    public AuthUserPassVerify(String command, AuthUserPassVerifyMethod method) {
        this.command = command;
        this.method = method;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("auth-user-pass-verify", command, method.getText());
    }
}
