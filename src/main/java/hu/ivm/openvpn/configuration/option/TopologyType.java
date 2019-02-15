package hu.ivm.openvpn.configuration.option;

public enum TopologyType {
    NET30("net30"),
    P2P("p2p"),
    SUBNET("subnet");

    private String text;

    TopologyType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
