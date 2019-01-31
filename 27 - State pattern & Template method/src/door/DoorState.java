package door;

public abstract class DoorState {
	public void timeout() {
		throw new UnsupportedOperationException();
	}

	public void complete() {
		throw new UnsupportedOperationException();
	}

	public void click() {
		throw new UnsupportedOperationException();
	}
}
