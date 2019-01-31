package opg4;

import java.util.ArrayList;
import java.util.Collections;

public class MainApp {

	public static void main(String[] args) {

		NameComparator namComp = new NameComparator();
		NumberComparator numComp = new NumberComparator();

		// List of name comparator objects
		Customer a3 = new Customer("Paul Phoenix", 3, namComp);
		Customer a8 = new Customer("Kuma", 8, namComp);
		Customer a2 = new Customer("Claudio Forel", 2, namComp);
		Customer a4 = new Customer("Josie Rizal", 4, namComp);
		Customer a1 = new Customer("Ling Xiaoyu", 1, namComp);
		Customer a10 = new Customer("Devil Jin", 10, namComp);
		Customer a6 = new Customer("Jin Kazama", 6, namComp);
		Customer a5 = new Customer("Nina Williams", 5, namComp);
		Customer a7 = new Customer("Bob", 7, namComp);
		Customer a9 = new Customer("Akuma", 9, namComp);

		ArrayList<Customer> arrName = new ArrayList<>();
		arrName.add(a1);
		arrName.add(a2);
		arrName.add(a3);
		arrName.add(a4);
		arrName.add(a5);
		arrName.add(a6);
		arrName.add(a7);
		arrName.add(a8);
		arrName.add(a9);
		arrName.add(a10);

		System.out
				.println("\n\n\n\n\n\n\n\"---------------------------NOW SORTING WITH NAMES--------------------------- "
						+ "\n\n\n\n\n\n\n\n");
		System.out.println("\n" + "Unsorted list: " + arrName.toString());
		Collections.sort(arrName);
		System.out.println("\n" + "Sorted list: " + arrName.toString());

		// Changing the comparator to numComp on all objects in the list
		for (Customer c : arrName) {
			c.setComparator(numComp);
		}

		System.out.println(
				"\n\n\n\n\n\n\n\"---------------------------NOW SORTING WITH NUMBERS--------------------------- "
						+ "\n\n\n\n\n\n\n\n");
		Collections.reverse(arrName);
		System.out.println("\n" + "Unsorted list: " + arrName.toString());
		Collections.sort(arrName);
		System.out.println("\n" + "Sorted list: " + arrName.toString());

	}

}
