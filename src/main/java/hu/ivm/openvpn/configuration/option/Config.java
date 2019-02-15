package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationBuilder;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Config extends AsbtractConfigurationOption {
    private final Path configPath;
    private final ConfigurationBuilder configurationBuilder;

    public Config(Path configPath, ConfigurationBuilder configurationBuilder) {
        this.configPath = configPath;
        this.configurationBuilder = configurationBuilder;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("config", configPath.toString());

        try {
            FileOutputStream os = null;
            os = new FileOutputStream(configPath.toFile());
            IOUtils.write(configurationBuilder.toString(), os, StandardCharsets.UTF_8);
            os.flush();
            os.close();
        } catch (Exception e) {
            throw new RuntimeException(null, e);
        }

    }
}
