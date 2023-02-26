package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.AsbtractScriptConfigurationOption;
import hu.ivm.openvpn.configuration.ConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class LearnAddress extends AsbtractScriptConfigurationOption {

    public LearnAddress(Path scriptPath, String script) {
        super("learn-address", scriptPath, script);
    }

}
