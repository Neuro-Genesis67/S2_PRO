package templatePracticeInternet;

public class Smilla extends Internet {
	@Override
	void InitialResponse() {
		System.out.println("Smilla realizes that there's something terribly wrong; she is unable to send a snap");
	}

	@Override
	void Action() {
		System.out.println("Smilla calls loudly from her room: \"Moooooooom, the internet isn't working!");
	}

	@Override
	void Hook() {
		System.out.println("Smilla is smart, so she knows that someone else will take care of the problem.");
	}
}
