package decorator;

import interfaces.InterfaceTriplet;

public class DecoratorTriplet implements InterfaceTriplet {

	protected final int HUNDRED_INDEX = 0;
	protected final int THOUSAND_INDEX = 1;
	protected final int MILLION_INDEX = 2;
	protected final int BILLION_INDEX = 3;

	protected String triplet;

	protected InterfaceTriplet component;

	public DecoratorTriplet(InterfaceTriplet c) {
		component = c;
	}

	@Override
	public String getTripletInWords() {
		return component.getTripletInWords();
	}

	@Override
	public String getValue() {
		return component.getValue();
	}

	@Override
	public String getTripletName() {
		return component.getTripletName();
	}
}
