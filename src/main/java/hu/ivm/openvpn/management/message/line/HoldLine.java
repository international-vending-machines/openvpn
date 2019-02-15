package hu.ivm.openvpn.management.message.line;

import hu.ivm.openvpn.annotation.ManagementMessageLine;
import hu.ivm.openvpn.management.Client;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ManagementMessageLine(types = {"HOLD"})
@Getter
@Setter
@ToString
public class HoldLine implements Line<HoldLine> {

	private static Pattern pattern = Pattern.compile("^>HOLD:(.*)$");

	private String message;

	@Override
	public HoldLine parse(Client client, String line) {
		Matcher matcher = pattern.matcher(line);
		if(matcher.matches()) {
			HoldLine holdLine = new HoldLine();
			holdLine.setMessage(matcher.group(1));
			return holdLine;
		}
		return null;
	}
	
}
