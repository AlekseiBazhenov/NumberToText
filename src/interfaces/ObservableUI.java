package interfaces;

public interface ObservableUI {
	void registerObserverUpdateUI(ObserverUpdateUI o);

	void removeObserverUpdateUI(ObserverUpdateUI o);

	void notifyObserversUI();
}
