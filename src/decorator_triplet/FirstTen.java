package decorator_triplet;

import interfaces.InterfaceNumber;
import decorator.DecoratorNumber;

public class FirstTen extends DecoratorNumber {
	boolean masculine;

	public FirstTen(InterfaceNumber c, boolean masculine) {
		super(c);
		this.masculine = masculine;
	}

	@Override
	public String getNumberInWords() {
		return addToString();
	}

	private String addToString() {
		String str = null;
		char[] charArray = getValue().toCharArray();
		if (getValue().length() >= 1) {
			switch (charArray[charArray.length - 1]) {
			case '1':
				str = masculine ? "один" : "одна";
				break;
			case '2':
				str = masculine ? "два" : "две";
				break;
			case '3':
				str = "три";
				break;
			case '4':
				str = "четыре";
				break;
			case '5':
				str = "пять";
				break;
			case '6':
				str = "шесть";
				break;
			case '7':
				str = "семь";
				break;
			case '8':
				str = "восемь";
				break;
			case '9':
				str = "девять";
				break;
			case '0':
				str = "";
				break;
			default:
				break;
			}
		}
		return str;
	}

	@Override
	public String getValue() {
		return super.getValue();
	}
}
