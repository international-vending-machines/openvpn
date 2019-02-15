package hu.ivm.openvpn.configuration.builder.packetfilter;

import hu.ivm.openvpn.configuration.StrBuilder;
import java.util.ArrayList;

/**
 *
 * @author gergely.asztalos
 */
public class Section<T> extends ArrayList<T> {
	
	private boolean accept = false;
	
	private String name;

	public Section(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		StrBuilder sb = new StrBuilder();
		sb.append("[").append(name).space().append(accept ? "ACCEPT" : "DROP").append("]").append("\n");
		for(T t : this) {
			sb.append(t.toString());
		}
		return sb.toString();
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
