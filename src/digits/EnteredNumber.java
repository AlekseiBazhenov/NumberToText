package digits;

import java.util.ArrayList;
import java.util.List;

import interfaces.ObservableInput;
import interfaces.ObservableUI;
import interfaces.ObserverInput;
import interfaces.ObserverUpdateUI;

public class EnteredNumber implements ObservableInput, ObservableUI {

	private List<ObserverInput> observersInput;
	private List<ObserverUpdateUI> observersUpdateUI;
	private String value;
	private String decimal;
	private String octal;

	public EnteredNumber() {
		observersInput = new ArrayList<ObserverInput>();
		observersUpdateUI = new ArrayList<ObserverUpdateUI>();
	}

	public EnteredNumber(String value) {
		this.value = value;
	}

	@Override
	public void registerObserverInput(ObserverInput o) {
		observersInput.add(o);
	}

	@Override
	public void removeObserverInput(ObserverInput o) {
		observersInput.remove(o);
	}

	@Override
	public void notifyParseObservers() {
		for (ObserverInput observer : observersInput) {
			observer.update(value);
		}
	}

	public void setValue(String value) {
		this.value = value;
		notifyParseObservers();
	};

	@Override
	public void registerObserverUpdateUI(ObserverUpdateUI o) {
		observersUpdateUI.add(o);
	}

	@Override
	public void removeObserverUpdateUI(ObserverUpdateUI o) {
		observersUpdateUI.remove(o);
	}

	@Override
	public void notifyObserversUI() {
		for (ObserverUpdateUI observer : observersUpdateUI) {
			observer.updateUI(decimal, octal);
		}
	};

	public void setValue(String decimal, String octal) {
		this.decimal = decimal;
		this.octal = octal;
		notifyObserversUI();
	}
}
