package hu.ivm.openvpn.configuration;

import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SystemUtils;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class AsbtractScriptConfigurationOption extends AsbtractConfigurationOption {

    private final String option;
    private final Path scriptPath;
    private final String script;

    public AsbtractScriptConfigurationOption(String option, Path scriptPath, String script) {
        this.option = option;
        this.scriptPath = scriptPath;
        this.script = script;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption(option, scriptPath.toString());

        try {
            FileOutputStream os = new FileOutputStream(scriptPath.toFile());
            IOUtils.write(script, os, StandardCharsets.UTF_8);
            os.flush();
            os.close();

            if(!SystemUtils.IS_OS_WINDOWS) {
                Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(scriptPath);
                posixFilePermissions.add(PosixFilePermission.OWNER_EXECUTE);
                posixFilePermissions.add(PosixFilePermission.GROUP_EXECUTE);
                posixFilePermissions.add(PosixFilePermission.OTHERS_EXECUTE);
                Files.setPosixFilePermissions(scriptPath, posixFilePermissions);
            }
        } catch (Exception e) {
            throw new RuntimeException(null, e);
        }
    }

}
