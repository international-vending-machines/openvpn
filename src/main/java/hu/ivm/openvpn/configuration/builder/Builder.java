package hu.ivm.openvpn.configuration.builder;

public class Builder {

    public static ConfigurationBuilder configuration(int mode) {
        return new ConfigurationBuilderImpl(mode);
    }
}
