package opgave_3;

import java.util.ArrayList;

public class Person<T extends Comparable<T>> implements Comparable<Person<T>> {

	private T navn;
	private ArrayList<Node> personList = new ArrayList<>();

	class Node {
		private T navn;
	}

	public Person(T navn) {
		this.navn = navn;
	}

	@Override
	public String toString() {
		return "" + this.navn;
	}

	public T getNavn() {
		return navn;
	}

	public void setNavn(T navn) {
		this.navn = navn;
	}

	public ArrayList<Node> getPersonList() {
		return personList;
	}

	public void setPersonList(ArrayList<Node> personList) {
		this.personList = personList;
	}

	@Override
	public int compareTo(Person<T> o) {
		if (getNavn().compareTo(o.getNavn()) < 1) {
			return -1;
		} else if (getNavn().compareTo(o.getNavn()) > 1) {
			return 1;
		}
		return 0;
	}

}
