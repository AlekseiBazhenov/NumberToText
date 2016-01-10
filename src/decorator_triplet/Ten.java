package decorator_triplet;

import interfaces.InterfaceNumber;
import decorator.DecoratorNumber;

public class Ten extends DecoratorNumber {

	public Ten(InterfaceNumber c) {
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
		if (getValue().length() >= 2) {
			switch (charArray[charArray.length - 2]) {
			case '1':
				str = "";
			case '2':
				str = "��������";
				break;
			case '3':
				str = "��������";
				break;
			case '4':
				str = "�����";
				break;
			case '5':
				str = "���������";
				break;
			case '6':
				str = "����������";
				break;
			case '7':
				str = "���������";
				break;
			case '8':
				str = "�����������";
				break;
			case '9':
				str = "���������";
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