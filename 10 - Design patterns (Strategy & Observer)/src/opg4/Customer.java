package opg4;

import java.util.Comparator;

public class Customer implements Comparable<Customer> {

	private String name;
	private int number;
	private Comparator<Customer> comparator;

	public Customer(String name, int number, Comparator<Customer> comparator) {
		this.name = name;
		this.number = number;
		this.comparator = comparator;
	}

	public Comparator<Customer> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<Customer> comparator) {
		this.comparator = comparator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String toString() {
		return "\n" + "Name: " + this.name + "\nNumber: " + this.number + "\n";
	}

	@Override
	public int compareTo(Customer customer) {
		return comparator.compare(this, customer);

	}
}
