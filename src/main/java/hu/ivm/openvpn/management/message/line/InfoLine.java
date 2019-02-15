package hu.ivm.openvpn.management.message.line;

import hu.ivm.openvpn.annotation.ManagementMessageLine;
import hu.ivm.openvpn.management.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ManagementMessageLine(types = {"INFO"})
public class InfoLine implements Line<InfoLine> {

	private Pattern pattern = Pattern.compile("^>INFO:(.*)$");
	
	private String info = null;
	
	@Override
	public InfoLine parse(Client client, String line) {
		Matcher matcher = pattern.matcher(line);
		if(matcher.matches()) {
			InfoLine infoLine = new InfoLine();
			infoLine.setInfo(matcher.group(1));
			return infoLine;
		}
		return null;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
