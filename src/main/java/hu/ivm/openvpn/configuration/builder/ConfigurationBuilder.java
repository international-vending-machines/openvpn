package hu.ivm.openvpn.configuration.builder;

import hu.ivm.openvpn.configuration.option.AuthUserPassVerifyMethod;
import hu.ivm.openvpn.configuration.option.ProtoType;
import hu.ivm.openvpn.configuration.option.TopologyType;

import java.nio.file.Path;


public interface ConfigurationBuilder extends PushBuilder<ConfigurationBuilder> {

    public final static int MODE_COMMAND_LINE = 1;

    public final static int MODE_CONFIGURATION_FILE = 2;

    public final static int MODE_PUSH = 3;

    ConfigurationBuilder modeServer();

    ConfigurationBuilder tlsServer();

    ConfigurationBuilder port(int port);

    ConfigurationBuilder proto(ProtoType type);

    ConfigurationBuilder dev(String dev);

    ConfigurationBuilder topology(TopologyType topologyType);

    ConfigurationBuilder ca(Path caPath);

    ConfigurationBuilder cert(Path certPath);

    ConfigurationBuilder key(Path keyPath);

    ConfigurationBuilder dh(Path dhPath);

    ConfigurationBuilder clientCertNotRequired();

    ConfigurationBuilder scriptSecurity(int level);

    ConfigurationBuilder usernameAsCommonName();

    ConfigurationBuilder authUserPassVerify(String command, AuthUserPassVerifyMethod method);

    ConfigurationBuilder tmpDir(Path tmpDir);

    ConfigurationBuilder clientConnect(String command);

    ConfigurationBuilder clientDisconnect(String command);

    ConfigurationBuilder clientToClient();

    ConfigurationBuilder up(Path upScriptPath, String upScript);

    ConfigurationBuilder tcpQueueLimit(int limit);

    ConfigurationBuilder txQueueLen(int len);

    ConfigurationBuilder keepAlive(int interval, int timeout);

    ConfigurationBuilder compLzo();

    ConfigurationBuilder persistKey();

    ConfigurationBuilder persistTun();

    ConfigurationBuilder verb(int verb);

    ConfigurationBuilder mute(int mute);

    ConfigurationBuilder renegSec(int sec);

    ConfigurationBuilder duplicateCn();

    ConfigurationBuilder log(Path logPath);

    ConfigurationBuilder logAppend(Path logPath);

    ConfigurationBuilder writePid(Path pidPath);

    ConfigurationBuilder management(String address, int port);

    ConfigurationBuilder managementClientPf();

    ConfigurationBuilder managementClientAuth();

    ConfigurationBuilder status(Path statusFile, int interval);

    ConfigurationBuilder config(Path configPath, ConfigurationBuilder configurationBuilder);

    ConfigurationBuilder suppressTimestamps();

    ConfigurationBuilder ping(int intervalSec);

    ConfigurationBuilder pingRestart(int afterSec);

    ConfigurationBuilder managementHold();

    ConfigurationBuilder pushPeerInfo();

    ConfigurationBuilder learnAddress(Path upScriptPath, String upScript);

    ConfigurationBuilder bcastBuffers(int size);

}
