package hu.ivm.openvpn.management.message.line;

import hu.ivm.openvpn.management.Client;
import lombok.ToString;

@ToString
public class LineError implements Line<LineError> {

	public enum Type {
		NOT_PARSABLE,
		NO_PARSER,
		EXCEPTION;
	}
	
	private Type type;
	private String line;

	public LineError(Type type, String line) {
		this.type = type;
		this.line = line;
	}
	
	@Override
	public LineError parse(Client client, String line) {
		throw new UnsupportedOperationException();
	}
	
}
