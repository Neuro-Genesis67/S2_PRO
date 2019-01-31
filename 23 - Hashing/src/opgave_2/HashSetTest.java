package opgave_2;

import opgave_3.HashSetLinearProbing;

/**
 * This program demonstrates the hash set class.
 */
public class HashSetTest {
	public static void main(String[] args) {
		testHashSetChaining();
		// testHashSetLinearProbing();
	}

	public static void testHashSetChaining() {
		HashSetChaining names = new HashSetChaining(13);
		names.add("Harry");
		names.add("Sue");
		names.add("Nina");
		names.add("Susannah");
		names.add("Larry");
		names.add("Eve");
		names.add("Sarah");
		names.add("Adam");
		names.add("Tony");
		names.add("Katherine");
		names.add("Juliet");
		names.add("Romeo");
		System.out.println("Chained hashset after inserting 12 names: " + names);

		System.out.println("Set size: " + names.size());
		System.out.println("Does the set contain \"Romeo\": " + names.contains("Romeo"));
		System.out.println("Removing \"Romeo\"...\n");
		names.remove("Romeo");

		System.out.println("Chained hashset after removing Romeo: \n" + names);

		System.out.println("Does the set contain \"Romeo\": " + names.contains("Romeo"));
		System.out.println("Does the set contain \"Nina\": " + names.contains("Nina"));
		System.out.println("Removing \"Nina\"...");
		names.remove("Nina");
		System.out.println("Does the set contain \"Nina\": " + names.contains("Nina") + "\n");

		System.out.println("Set size is now: " + names.size());
		System.out.println(names);
	}

	public static void testHashSetLinearProbing() {
		HashSetLinearProbing names = new HashSetLinearProbing(13);

		names.add("Harry");
		names.add("Sue");
		names.add("Nina");
		names.add("Susannah");
		names.add("Larry");
		names.add("Eve");
		names.add("Sarah");
		names.add("Adam");
		names.add("Tony");
		names.add("Katherine");
		names.add("Juliet");
		names.add("Romeo");

		System.out.println(names);

		System.out.println("Size: " + names.getNumberOfItems());
		System.out.println("Contains Romeo: " + names.contains("Romeo"));

		names.remove("Romeo");
		System.out.println("Removed Romeo. Contains Romeo: " + names.contains("Romeo"));
		names.remove("Nina");
		System.out.println("Removed Nina. Contains Nina: " + names.contains("Nina"));
		System.out.println(names.getNumberOfItems());
		System.out.println();
		System.out.println(names);
	}
}
