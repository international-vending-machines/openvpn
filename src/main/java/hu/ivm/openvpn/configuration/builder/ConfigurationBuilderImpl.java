package hu.ivm.openvpn.configuration.builder;

import hu.ivm.openvpn.configuration.ConfigurationOption;
import hu.ivm.openvpn.configuration.option.*;

import java.net.InetAddress;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author gergely.asztalos
 */
public class ConfigurationBuilderImpl extends ArrayList<ConfigurationOption> implements ConfigurationBuilder  {

	private int mode = MODE_CONFIGURATION_FILE;

	public ConfigurationBuilderImpl(int mode) {
		this.mode = mode;
	}

	public boolean isCommandLine() {
		return mode == MODE_COMMAND_LINE;
	}

	public boolean isConfigurationFile() {
		return mode == MODE_CONFIGURATION_FILE;
	}
	
	@Override
	public ConfigurationBuilder ifConfigPush(InetAddress ip, InetAddress mask) {
		add(new IfConfigPush(ip, mask));
		return this;
	}

	@Override
	public ConfigurationBuilder pushRouteGateway(InetAddress gw) {
		add(new PushRouteGateway(gw));
		return this;
	}

	@Override
	public ConfigurationBuilder ping(int intervalSec) {
		add(new Ping(intervalSec));
		return this;
	}

	@Override
	public ConfigurationBuilder pingRestart(int afterSec) {
		add(new PingRestart(afterSec));
		return this;
	}

	@Override
	public ConfigurationBuilder managementHold() {
		add(new ManagementHold());
		return this;
	}

	@Override
	public ConfigurationBuilder pushPeerInfo() {
		add(new PushPeerInfo());
		return this;
	}

	@Override
	public ConfigurationBuilder pushPing(int intervalSec) {
		add(new Push(new Ping(intervalSec)));
		return this;
	}

	@Override
	public ConfigurationBuilder pushPingRestart(int afterSec) {
		add(new Push(new PingRestart(afterSec)));
		return this;
	}

	@Override
	public ConfigurationBuilder push(ConfigurationOption configurationOption) {
		add(new Push(configurationOption));
		return this;
	}

	@Override
	public String toString() {
		ConfigurationOptionBuilder sb = new ConfigurationOptionBuilder(mode);
		for(ConfigurationOption cl : this) {
			cl.toString(sb);
		}
		return sb.toString();
	}


	@Override
	public ConfigurationBuilder modeServer() {
		add(new Mode(ModeType.SERVER));
		return this;
	}

	@Override
	public ConfigurationBuilder tlsServer() {
		add(new TlsServer());
		return this;
	}

	@Override
	public ConfigurationBuilder port(int port) {
		add(new Port(port));
		return this;
	}

	@Override
	public ConfigurationBuilder proto(ProtoType type) {
		add(new Proto(type));
		return this;
	}

	@Override
	public ConfigurationBuilder dev(String dev) {
		add(new Dev(dev));
		return this;
	}

	@Override
	public ConfigurationBuilder topology(TopologyType type) {
		add(new Topology(type));
		return this;
	}

	@Override
	public ConfigurationBuilder ca(Path caPath) {
		add(new Ca(caPath));
		return this;
	}

	@Override
	public ConfigurationBuilder cert(Path certPath) {
		add(new Cert(certPath));
		return this;
	}

	@Override
	public ConfigurationBuilder key(Path keyPath) {
		add(new Key(keyPath));
		return this;
	}

	@Override
	public ConfigurationBuilder dh(Path dhPath) {
		add(new Dh(dhPath));
		return this;
	}

	@Override
	public ConfigurationBuilder clientCertNotRequired() {
		add(new ClientCertNotRequired());
		return this;
	}

	@Override
	public ConfigurationBuilder scriptSecurity(int level) {
		add(new ScriptSecurity(level));
		return this;
	}

	@Override
	public ConfigurationBuilder usernameAsCommonName() {
		add(new UsernameAsCommonName());
		return this;
	}

	@Override
	public ConfigurationBuilder authUserPassVerify(String command, AuthUserPassVerifyMethod method) {
		add(new AuthUserPassVerify(command, method));
		return this;
	}

	@Override
	public ConfigurationBuilder tmpDir(Path tmpDir) {
		add(new TmpDir(tmpDir));
		return this;
	}

	@Override
	public ConfigurationBuilder clientConnect(String command) {
		add(new ClientConnect(command));
		return this;
	}

	@Override
	public ConfigurationBuilder clientDisconnect(String command) {
		add(new ClientDisconnect(command));
		return this;
	}

	@Override
	public ConfigurationBuilder clientToClient() {
		add(new ClientToClient());
		return this;
	}

	@Override
	public ConfigurationBuilder up(Path upScriptPath, String upScript) {
		add(new Up(upScriptPath, upScript));
		return this;
	}

	@Override
	public ConfigurationBuilder tcpQueueLimit(int limit) {
		add(new TcpQueueLimit(limit));
		return this;
	}

	@Override
	public ConfigurationBuilder txQueueLen(int len) {
		add(new TxQueueLen(len));
		return this;
	}

	@Override
	public ConfigurationBuilder keepAlive(int interval, int timeout) {
		add(new KeepAlive(interval, timeout));
		return this;
	}

	@Override
	public ConfigurationBuilder compLzo() {
		add(new CompLzo());
		return this;
	}

	@Override
	public ConfigurationBuilder persistKey() {
		add(new PersistKey());
		return this;
	}

	@Override
	public ConfigurationBuilder persistTun() {
		add(new PersistTun());
		return this;
	}

	@Override
	public ConfigurationBuilder verb(int verb) {
		add(new Verb(verb));
		return this;
	}

	@Override
	public ConfigurationBuilder mute(int mute) {
		add(new Mute(mute));
		return this;
	}

	@Override
	public ConfigurationBuilder renegSec(int sec) {
		add(new RenegSec(sec));
		return this;
	}

	@Override
	public ConfigurationBuilder duplicateCn() {
		add(new DuplicateCn());
		return this;
	}

	@Override
	public ConfigurationBuilder log(Path logPath) {
		add(new Log(logPath));
		return this;
	}

	@Override
	public ConfigurationBuilder logAppend(Path logPath) {
		add(new LogAppend(logPath));
		return this;
	}

	@Override
	public ConfigurationBuilder writePid(Path pidPath) {
		add(new WritePid(pidPath));
		return this;
	}

	@Override
	public ConfigurationBuilder management(String address, int port) {
		add(new Management(address, port));
		return this;
	}

	@Override
	public ConfigurationBuilder managementClientPf() {
		add(new ManagementClientPf());
		return this;
	}

	@Override
	public ConfigurationBuilder managementClientAuth() {
		add(new ManagementClientAuth());
		return this;
	}

	@Override
	public ConfigurationBuilder status(Path statusPath, int interval) {
		add(new Status(statusPath, interval));
		return this;
	}

	@Override
	public ConfigurationBuilder config(Path configPath, ConfigurationBuilder configurationBuilder) {
		add(new Config(configPath, configurationBuilder));
		return this;
	}

	@Override
	public ConfigurationBuilder suppressTimestamps() {
		add(new SuppressTimestamps());
		return this;
	}

	@Override
	public ConfigurationBuilder learnAddress(Path upScriptPath, String upScript) {
		add(new LearnAddress(upScriptPath, upScript));
		return this;
	}

	@Override
	public ConfigurationBuilder bcastBuffers(int size) {
		add(new BcastBuffers(size));
		return this;
	}
}
