package opgave_3;

public class Person {

	String firstName = "";

	public Person(String firstName) {
		this.firstName = firstName;

	}

	@Override
	public String toString() {
		return firstName;
	}
}
