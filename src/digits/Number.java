package digits;

import interfaces.InterfaceNumber;

public class Number implements InterfaceNumber {

	private String value;

	@Override
	public String getNumberInWords() {
		return "";
	}

	public Number(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

}
