package builder;

import utils.OctalConverter;
import utils.NumberUtils;
import digits.EnteredNumber;
import enums.Range;
import interfaces.ObserverInput;

public class ConvertWrapper implements ObserverInput {

	private EnteredNumber inputNumber;

	public ConvertWrapper(EnteredNumber inputNumber) {
		this.inputNumber = inputNumber;
		inputNumber.registerObserverInput(this);
	}

	@Override
	public void update(String value) {
		getConvertedString(value);
	}

	private void getConvertedString(String value) {
		NumberStringBuilder numberStringBuilder = NumberStringBuilder
				.getBuilder();
		Range range = NumberUtils.getUtils().getRange(value.length());

		String decimal = numberStringBuilder.buildString(value, range);
		String octal = numberStringBuilder.buildString(OctalConverter
				.getConverter().convertToOctal(value), range);
		sendToUI(decimal, octal);
	}

	private void sendToUI(String decimal, String octal) {
		inputNumber.setValue(decimal, octal);
	}
}
