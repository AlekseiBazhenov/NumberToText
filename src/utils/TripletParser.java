package utils;

import decorator.DecoratorNumber;
import decorator_triplet.FirstTen;
import decorator_triplet.Hundred;
import decorator_triplet.SecondTen;
import decorator_triplet.Ten;
import digits.Number;

public class TripletParser {

	private TripletParser() {

	}

	private static TripletParser parser;

	public static TripletParser getParser() {
		if (parser == null) {
			parser = new TripletParser();
		}
		return parser;
	}

	public String parse(String value, boolean masculine) {
		char[] chars = value.toCharArray();
		int length = value.length();

		DecoratorNumber decoratorNumber = null;

		if (length == 3 && chars[length - 2] == '1') {
			decoratorNumber = new Hundred(new SecondTen(new Number(value)));
		} else if (length == 3) {
			decoratorNumber = new Hundred(new Ten(new FirstTen(new Number(value), masculine)));
		} else if (length == 2 && chars[length - 2] == '1') {
			decoratorNumber = new SecondTen(new Number(value));
		} else if (length == 2) {
			decoratorNumber = new Ten(new FirstTen(new Number(value), masculine));
		} else if (length == 1) {
			decoratorNumber = new FirstTen(new Number(value), masculine);
		}
		return decoratorNumber.getNumberInWords();
	}
}
