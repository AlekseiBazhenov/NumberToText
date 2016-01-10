package decorator_triplet;

import interfaces.InterfaceNumber;
import decorator.DecoratorNumber;

public class Hundred extends DecoratorNumber {

	public Hundred(InterfaceNumber c) {
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
		if (getValue().length() == 3) {
			switch (charArray[charArray.length - 3]) {
			case '1':
				str = "сто";
				break;
			case '2':
				str = "двести";
				break;
			case '3':
				str = "триста";
				break;
			case '4':
				str = "четыреста";
				break;
			case '5':
				str = "пятьсот";
				break;
			case '6':
				str = "шестьсот";
				break;
			case '7':
				str = "семьсот";
				break;
			case '8':
				str = "восемьсот";
				break;
			case '9':
				str = "девятьсот";
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
