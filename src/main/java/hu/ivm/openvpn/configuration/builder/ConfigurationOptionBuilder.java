package hu.ivm.openvpn.configuration.builder;

import hu.ivm.openvpn.configuration.StrBuilder;
import org.apache.commons.lang3.StringUtils;

public class ConfigurationOptionBuilder extends StrBuilder {

    private int mode = ConfigurationBuilder.MODE_CONFIGURATION_FILE;

    public ConfigurationOptionBuilder(int mode) {
        this.mode = mode;
    }

    public void appendOption(String option, String ... args) {
        switch (mode) {
            case ConfigurationBuilder.MODE_COMMAND_LINE:
                append("--").append(option);
                if(args.length > 0) {
                    space();
                    appendArgs(args);
                }
                space();
                break;
            case ConfigurationBuilder.MODE_CONFIGURATION_FILE:
            case ConfigurationBuilder.MODE_PUSH:
                append(option);
                if(args.length > 0) {
                    space();
                    appendArgs(args);
                }
                if(mode != ConfigurationBuilder.MODE_PUSH) {
                    appendNewLine();
                }
                break;
        }
    }

    public ConfigurationOptionBuilder appendArgs(String ... args) {

        for(String arg : args) {
            String quote = "";
            String _arg = arg;
            if(StringUtils.containsAny(_arg, " \"")) {
                quote = "\"";
            }

            if(!quote.equals("")) {
                _arg = _arg.replace(quote, "\\" + quote);
                append(quote).append(_arg).append(quote);
            } else {
                append(_arg);
            }

            space();
        }

        return this;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
