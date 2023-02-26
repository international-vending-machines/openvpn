/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ivm.openvpn.configuration.builder;

import hu.ivm.openvpn.configuration.ConfigurationOption;

import java.net.InetAddress;
import java.util.List;

/**
 *
 * @author gergely.asztalos
 */
/*
echo "ifconfig-push ${CLIENT_IP_ADDRESS} ${CLIENT_IP_MASK}" >> $CFG
echo 'push "route-gateway '${NETWORK_IP_ADDRESS}'"' >> $CFG

*/
public interface PushBuilder<E extends PushBuilder> extends List<ConfigurationOption> {
	
	E ifConfigPush(InetAddress ip, InetAddress mask);
	
	E pushRouteGateway(InetAddress gw);

	E pushPing(int intervalSec);

	E pushPingRestart(int afterSec);

	E push(ConfigurationOption configurationOption);
	
}
