package templatePracticeCake;

public abstract class Cake {

	final void bakeCake() {
		addIngredients();
		whipCream();
		makeFrosting();
		presentCake();
		hook();
	}

	void whipCream() {
		System.out.println("Whipping cream...");
	}

	void presentCake() {
		System.out.println("The finished result is lovely huh");
	}

	abstract void addIngredients();

	abstract void makeFrosting();

	void hook() {

	}
}
