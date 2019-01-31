package templatePracticeCake;

public class MainApp {

	public static void main(String[] args) {
		CheeseCake ck = new CheeseCake();
		DreamCake dk = new DreamCake();
		ck.bakeCake();
		System.out.println();
		dk.bakeCake();
	}

}
