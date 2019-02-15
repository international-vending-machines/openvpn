package hu.ivm.openvpn.configuration.option;

public enum ModeType {
    P2P("p2p"),
    SERVER("server");

    private String text;

    ModeType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
