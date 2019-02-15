package hu.ivm.openvpn.management.message;

import hu.ivm.openvpn.management.Client;
import hu.ivm.openvpn.management.command.HoldCommand;
import hu.ivm.openvpn.management.message.line.HoldLine;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HoldMessage extends AbstractMessage implements Message {

    private String message;

    public HoldMessage(Client client, HoldLine line) {
        super(client);
        this.message = line.getMessage();
    }

    public HoldCommand toHoldCommand() {
        HoldCommand holdCommand = new HoldCommand(this.client);

        return holdCommand;
    }
}
