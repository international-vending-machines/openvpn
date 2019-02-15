package hu.ivm.openvpn.configuration.option;

public enum AuthUserPassVerifyMethod {
    VIA_FILE("via-file"),
    VIA_ENV("via-file");


    private String text;

    AuthUserPassVerifyMethod(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
