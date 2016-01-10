package decorator_triplet;

import interfaces.InterfaceNumber;
import decorator.DecoratorNumber;

public class SecondTen extends DecoratorNumber {

	public SecondTen(InterfaceNumber c) {
		super(c);
	}

	@Override
	public String getNumberInWords() {
		return String.format("%1$s %2$s", addToString(),
				super.getNumberInWords());
	}

	private String addToString() {
		String str = null;
		char[] charArray = getValue().toCharArray();
		if (getValue().length() >= 1) {
			switch (charArray[charArray.length - 1]) {
			case '0':
				str = "десять";
				break;
			case '1':
				str = "одиннадцать";
				break;
			case '2':
				str = "двенадцать";
				break;
			case '3':
				str = "тринадцать";
				break;
			case '4':
				str = "четырнадцать";
				break;
			case '5':
				str = "пятнадцать";
				break;
			case '6':
				str = "шестнадцать";
				break;
			case '7':
				str = "семнадцать";
				break;
			case '8':
				str = "восемнадцать";
				break;
			case '9':
				str = "девятнадцать";
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
