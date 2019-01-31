package ur;

public class ObserverAnalogtUr implements Observer {

	public ObserverAnalogtUr(Subject o) {
		o.registerObserver(this);
	}

	public void update(Subject o) {
		int g = ((Ur) o).getTid();
		System.out.println("Analogt " + g);
	}
}
