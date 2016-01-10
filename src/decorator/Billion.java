package decorator;

import interfaces.InterfaceTriplet;
import utils.NumberUtils;
import utils.TripletParser;

public class Billion extends DecoratorTriplet {

	public Billion(InterfaceTriplet c) {
		super(c);
	}

	@Override
	public String getTripletInWords() {
		triplet = NumberUtils.getUtils().getTriplet(getValue(), BILLION_INDEX);
		return String.format("%1$s %2$s %3$s",
				TripletParser.getParser().parse(triplet, true),
				getTripletName(), super.getTripletInWords());
	}

	@Override
	public String getValue() {
		return super.getValue();
	}

	@Override
	public String getTripletName() {
		char[] value = triplet.toCharArray();
		int tripletInt = Character.getNumericValue(value[value.length - 1]);
		if (tripletInt == 1) {
			return "миллиард";
		} else if (tripletInt > 1 && tripletInt <= 4) {
			return "миллиарда";
		} else {
			return "миллиардов";
		}
	}
}
