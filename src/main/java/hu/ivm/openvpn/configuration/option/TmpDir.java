package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;

import java.nio.file.Path;

public class TmpDir extends AsbtractConfigurationOption {
    private Path tmpDir;

    public TmpDir(Path tmpDir) {
        this.tmpDir = tmpDir;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("tmp-dir", tmpDir.toString());
    }
}
