package decorator;

import utils.NumberUtils;
import utils.TripletParser;
import interfaces.InterfaceTriplet;

public class Hundred extends DecoratorTriplet {

	public Hundred(InterfaceTriplet c) {
		super(c);
	}

	@Override
	public String getTripletInWords() {
		triplet = NumberUtils.getUtils().getTriplet(getValue(), HUNDRED_INDEX);
		return TripletParser.getParser().parse(triplet, true);
	}

	@Override
	public String getValue() {
		return super.getValue();
	}
}
