package hu.ivm.openvpn.management.message;

import hu.ivm.openvpn.management.Client;
import hu.ivm.openvpn.management.message.line.InfoLine;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoMessage extends AbstractMessage implements Message {

    private String message;

    public InfoMessage(Client client, InfoLine line) {
        super(client);
        this.message = line.getInfo();
    }
}
