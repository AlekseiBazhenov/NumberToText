package decorator;

import interfaces.InterfaceNumber;

public abstract class DecoratorNumber implements InterfaceNumber {

	protected InterfaceNumber component;

	public DecoratorNumber(InterfaceNumber c) {
		component = c;
	}

	@Override
	public String getNumberInWords() {
		return component.getNumberInWords();
	}

	@Override
	public String getValue() {
		return component.getValue();
	}
}
