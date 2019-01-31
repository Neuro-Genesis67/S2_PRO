package templatePracticeInternet;

public abstract class Internet {

	public void TurnOffInternet() {
		InternetTurnsOff();
		InitialResponse();
		Action();
		Hook();
	}

	void InternetTurnsOff() {
		System.out.println("The internet has suddenly powered down...");
	}

	abstract void InitialResponse();

	abstract void Action();

	void Hook() {

	}

}
