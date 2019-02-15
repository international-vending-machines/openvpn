package hu.ivm.openvpn.configuration.option;

public enum ProtoType {
    UDP("udp"),
    TCP_SERVER("tcp-server"),
    TCP_CLIENT("tcp-client");

    private final String text;

    ProtoType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
