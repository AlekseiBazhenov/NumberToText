package digits;

import interfaces.InterfaceTriplet;

public class Triplet implements InterfaceTriplet {

	private String value;

	@Override
	public String getTripletInWords() {
		return "";
	}

	public Triplet(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getTripletName() {
		return "";
	}
}
