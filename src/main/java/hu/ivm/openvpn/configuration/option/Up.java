package hu.ivm.openvpn.configuration.option;

import hu.ivm.openvpn.configuration.AsbtractConfigurationOption;
import hu.ivm.openvpn.configuration.builder.ConfigurationOptionBuilder;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class Up extends AsbtractConfigurationOption {
    private final Path upScriptPath;
    private final String upScript;

    public Up(Path upScriptPath, String upScript) {

        this.upScriptPath = upScriptPath;
        this.upScript = upScript;
    }

    @Override
    public void toString(ConfigurationOptionBuilder builder) {
        builder.appendOption("up", upScriptPath.toString());

        try {
            FileOutputStream os = new FileOutputStream(upScriptPath.toFile());
            IOUtils.write(upScript, os, StandardCharsets.UTF_8);
            os.flush();
            os.close();

            Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(upScriptPath);
            posixFilePermissions.add(PosixFilePermission.OWNER_EXECUTE);
            posixFilePermissions.add(PosixFilePermission.GROUP_EXECUTE);
            posixFilePermissions.add(PosixFilePermission.OTHERS_EXECUTE);
            Files.setPosixFilePermissions(upScriptPath, posixFilePermissions);
        } catch (Exception e) {
            throw new RuntimeException(null, e);
        }
    }
}
