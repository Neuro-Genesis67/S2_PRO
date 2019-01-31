package templatePracticeInternet;

public class MainApp {

	public static void main(String[] args) {
		Selma selma = new Selma();
		Smilla smilla = new Smilla();
		Amalie amalie = new Amalie();
		Tom tom = new Tom();

		selma.TurnOffInternet();
		System.out.println();
		smilla.TurnOffInternet();
		System.out.println();
		amalie.TurnOffInternet();
		System.out.println();
		tom.TurnOffInternet();

	}

}
