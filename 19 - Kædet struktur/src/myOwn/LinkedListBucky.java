package myOwn;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListBucky {

	public static void main(String[] args) {
		// String[] things = { "apples", "noob", "pwnge", "bacon", "goATS" };
		// List<String> list1 = new LinkedList<String>();
		//
		// for (String x : things) {
		// list1.add(x);
		// }
		//
		// String[] things2 = { "sausage", "bacon", "goats", "harrypotter" };
		// List<String> list2 = new LinkedList<String>();
		//
		// for (String y : things2) {
		// list2.add(y);
		// }
		//
		// list1.addAll(list2);
		// list2 = null; // to free up memory
		//
		// printMe(list1);
		// removeStuff(list1, 2, 5); // Removes everything from list1
		// // from 2 til 4.
		// printMe(list1);
		// reverseMeWhile(list1);
		// reverseMeFor(list1);

		String[] DHRT = { "D", "H", "R", "T" };
		List<String> DHRTlist = new LinkedList<String>();

		for (String s : DHRT) {
			DHRTlist.add(s);
		}

		int index = 1;
		System.out.println("The list: " + DHRTlist);
		System.out.println("          [0, 1, 2, 3]");

		ListIterator<String> iter = DHRTlist.listIterator(index);
		String temp = iter.next();
		System.out.println("Index " + index + " = " + temp);

		// DoublyLinkedList dl = new DoublyLinkedList();
	}

	private static void printMe(List<String> list) {
		for (String b : list) {
			System.out.printf("%s ", b);
		}
		System.out.println();

	}

	private static void removeStuff(List<String> list, int from, int to) {
		list.subList(from, to).clear();
		// sub = substitue (82% sure about this)
	}

	private static void reverseMeWhile(List<String> list) {
		ListIterator<String> iterator = list.listIterator(list.size());

		while (iterator.hasPrevious()) {
			System.out.printf("%s ", iterator.previous());
		}

	}

	private static void reverseMeFor(List<String> list) {

		for (String s : list) {
			System.out.printf("%s " + s);
		}
		System.out.println("Action completed");
	}

}
