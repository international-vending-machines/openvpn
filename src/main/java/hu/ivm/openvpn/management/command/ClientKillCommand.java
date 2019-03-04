package hu.ivm.openvpn.management.command;

import hu.ivm.openvpn.configuration.StrBuilder;
import hu.ivm.openvpn.management.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientKillCommand extends AbstractCommand {

    private int clientID = 0;

    public ClientKillCommand() {
    }

    public ClientKillCommand(Client client) {
        super(client);
    }

    @Override
    public void toString(StrBuilder sb) {
        sb.append("client-kill").space().append(clientID).append("\n");
    }
}
