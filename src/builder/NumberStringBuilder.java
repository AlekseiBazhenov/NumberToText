package builder;

import decorator.Billion;
import decorator.DecoratorTriplet;
import decorator.Hundred;
import decorator.Million;
import decorator.Thousand;
import digits.Triplet;
import enums.Range;

public class NumberStringBuilder {

	private NumberStringBuilder() {

	}

	private static NumberStringBuilder numberStringBuilder;

	public static NumberStringBuilder getBuilder() {
		if (numberStringBuilder == null) {
			numberStringBuilder = new NumberStringBuilder();
		}
		return numberStringBuilder;
	}

	private DecoratorTriplet decorator;

	public String buildString(String value, Range range) {
		switch (range) {
		case HUNDRED:
			decorator = new Hundred(new Triplet(value));
			break;
		case THOUSAND:
			decorator = new Thousand(new Hundred(new Triplet(value)));
			break;
		case MILLION:
			decorator = new Million(new Thousand(new Hundred(new Triplet(value))));
			break;
		case BILLION:
			decorator = new Billion(new Million(new Thousand(new Hundred(new Triplet(value)))));
			break;
		default:
			break;
		}
		return decorator.getTripletInWords();
	}

}
