package decorator;

import utils.NumberUtils;
import utils.TripletParser;
import interfaces.InterfaceTriplet;

public class Thousand extends DecoratorTriplet {

	public Thousand(InterfaceTriplet c) {
		super(c);
	}

	@Override
	public String getTripletInWords() {
		triplet = NumberUtils.getUtils().getTriplet(getValue(), THOUSAND_INDEX);
		return String.format("%1$s %2$s %3$s",
				TripletParser.getParser().parse(triplet, getMasculine()),
				getTripletName(), super.getTripletInWords());
	}

	@Override
	public String getValue() {
		return super.getValue();
	}

	@Override
	public String getTripletName() {
		int i = getTripletInt();
		if (i == 1) {
			return "тыс€ча";
		} else if (i > 1 && i <= 4) {
			return "тыс€чи";
		} else {
			return "тыс€ч";
		}
	}

	private boolean getMasculine() {
		int i = getTripletInt();
		if (i <= 2) {
			return false;
		}
		return true;
	}

	private int getTripletInt() {
		char[] value = triplet.toCharArray();
		return Character.getNumericValue(value[value.length - 1]);
	}
}
