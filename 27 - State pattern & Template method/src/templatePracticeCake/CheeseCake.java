package templatePracticeCake;

public class CheeseCake extends Cake {

	@Override
	void addIngredients() {
		System.out.println("Adding ingredients: CreamCheese, sugar, flour, and mascarpone...");

	}

	@Override
	void makeFrosting() {
		System.out
				.println("Making frosting: Melting houseblaze, adding food coloring, adding blended frozen berries...");

	}

	@Override
	void hook() {
		System.out.println("I'm a hooker!");
	}

}
