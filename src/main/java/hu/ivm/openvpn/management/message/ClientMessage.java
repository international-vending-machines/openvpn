/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ivm.openvpn.management.message;

import hu.ivm.openvpn.management.Client;
import hu.ivm.openvpn.management.command.ClientAuthorizationCommand;
import hu.ivm.openvpn.management.command.ClientPacketFilterCommand;
import hu.ivm.openvpn.management.message.line.ClientLine;
import org.apache.commons.lang3.EnumUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author gergely.asztalos
 */
public class ClientMessage extends AbstractMessage implements Message {
	
	public enum Env {
		N_CLIENTS("n_clients"),
		UNTRUSTED_PORT("untrusted_port"),
		UNTRUSTED_IP("untrusted_ip"),
		PASSWORD("password"),
		USERNAME("username"),
		REMOTE_PORT_1("remote_port_1"),
		LOCAL_PORT_1("local_port_1"),
		PROTO_1("proto_1"),
		DAEMON_PID("daemon_pid"),
		DAEMON_START_TIME("daemon_start_time"),
		DAEMON_LOG_REDIRECT("daemon_log_redirect"),
		DAEMON("daemon"),
		VERB("verb"),
		CONFIG("config"),
		SCRIPT_CONTEXT("script_context"),
		TUN_MTU("tun_mtu"),
		LINK_MTU("link_mtu"),
		DEV("dev"),
		DEV_TYPE("dev_type"),
		SCRIPT_TYPE("script_type"),
		REDIRECT_GATEWAY("redirect_gateway"),
		IFCONFIG_POOL_NETMASK("ifconfig_pool_netmask"),
		IFCONFIG_POOL_REMOTE_IP("ifconfig_pool_remote_ip"),
		TIME_UNIX("time_unix"),
		TIME_ASCII("time_ascii"),
		TRUSTED_PORT("trusted_port"),
		TRUSTED_IP("trusted_ip"),
		COMMON_NAME("common_name"),
		IV_TCPNL("IV_TCPNL"),
		IV_COMP_STUBv2("IV_COMP_STUBv2"),
		IV_COMP_STUB("IV_COMP_STUB"),
		IV_LZO("IV_LZO"),
		IV_LZ4v2("IV_LZ4v2"),
		IV_LZ4("IV_LZ4"),
		IV_NCP("IV_NCP"),
		IV_PROTO("IV_PROTO"),
		IV_PLAT("IV_PLAT"),
		IV_VER("IV_VER"),
		TIME_DURATION("time_duration"),
		BYTES_SENT("bytes_sent"),
		BYTES_RECEIVED("bytes_received");
		
		private String key;
		
		Env(String key) {
			this.key = key;
		}
		
		public static Env valueByKey(String key) {
			for(Env env : values()) {
				if(env.getKey().equals(key)) {
					return env;
				}
			}
			return null;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
		
		
	}

	public ClientMessage(Client client, ClientLine clientLine) throws IllegalArgumentException {
		super(client);
		if(clientLine.getType() == null) {
			throw new IllegalArgumentException("ClientLine type cannot be null!");
		}
		if(!EnumUtils.isValidEnum(Type.class, clientLine.getType().name())) {
			throw new IllegalArgumentException(clientLine.getType().name() + " type is not allowed here!");
		}
		this.type = Type.valueOf(clientLine.getType().name());
		this.clientID = clientLine.getClientID();
		this.keyID = clientLine.getKeyID();
	}
	
	public enum Type {
		CONNECT,
		REAUTH,
		ESTABLISHED,
		DISCONNECT;
	}
	
	private Type type;
	
	private int clientID = 0;
		
	private int keyID = 0;
	
	private final Map<Env,Object> envMap = new LinkedHashMap<>();

	
	public void addEnv(Env name, Object value) {
		envMap.put(name, value);
	}
	
	public void addEnv(Map.Entry<Env,Object> entry) {
		envMap.put(entry.getKey(), entry.getValue());
	}
	
	public Map<Env,Object> getEnv() {
		return this.envMap;
	}

	public boolean isConnect() {
		return Type.CONNECT.equals(type);
	}

	public boolean isReauth() {
		return Type.REAUTH.equals(type);
	}

	public boolean isDisconnect() {
		return Type.DISCONNECT.equals(type);
	}

	public boolean isEstablished() {
		return Type.ESTABLISHED.equals(type);
	}

	public ClientAuthorizationCommand toClientAuthorization() {
		ClientAuthorizationCommand cac = new ClientAuthorizationCommand(this.client);
		cac.setClientID(getClientID());
		cac.setKeyID(getKeyID());
		return cac;
	}
	
	public ClientPacketFilterCommand toClientPacketFilter() {
		ClientPacketFilterCommand cpfc = new ClientPacketFilterCommand(this.client);
		cpfc.setClientID(getClientID());
		return cpfc;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getKeyID() {
		return keyID;
	}

	public void setKeyID(int keyID) {
		this.keyID = keyID;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ClientMessage{" + "type=" + type + ", clientID=" + clientID + ", keyID=" + keyID + ", envMap=" + envMap + '}';
	}
	
}
