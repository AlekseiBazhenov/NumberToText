package interfaces;

public interface ObservableInput {
	void registerObserverInput(ObserverInput o);

	void removeObserverInput(ObserverInput o);

	void notifyParseObservers();
}
