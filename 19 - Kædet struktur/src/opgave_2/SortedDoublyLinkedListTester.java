package opgave_2;

public class SortedDoublyLinkedListTester {

	public static void main(String[] args) {
		SortedDoublyLinkedList sl = new SortedDoublyLinkedList();

		// Testing removeFirst & removeLast:

		// If 0 elements in list:
		// System.out.println("If 0 elements in list: ");
		// System.out.println("RemoveFirst: " + sl.removeFirst());
		// System.out.println("RemoveLast: " + sl.removeFirst() + "\n\n\n");

		// If 1 element in list:
		// System.out.println("If 1 element in list: ");
		// sl.addElement("Abel");
		// System.out.println("Before: " + sl.toString());
		// System.out.println("RemoveFirst: " + sl.removeFirst());
		// System.out.println("After: " + sl.toString());
		// System.out.println("If 1 element in list: ");
		// sl.addElement("Abel");
		// System.out.println("Before: " + sl.toString());
		// System.out.println("RemoveLast: " + sl.removeLast());
		// System.out.println("After: " + sl.toString() + "\n\n\n");

		// If two elements in list:
		// System.out.println("If two elements in list: ");
		// sl.addElement("Abel");
		// sl.addElement("Bjarne");
		// System.out.println("Before: " + sl.toString());
		// System.out.println("RemoveFirst: " + sl.removeFirst());
		// System.out.println("After: " + sl.toString());
		// System.out.println("If two elements in list: ");
		// sl.addElement("Abel");
		// sl.addElement("Bjarne");
		// System.out.println("Before: " + sl.toString());
		// System.out.println("RemoveLast: " + sl.removeLast());
		// System.out.println("After: " + sl.toString());
		// System.out.println(sl.toString());
		// sl.removeFirst();
		// System.out.println(sl.toString());
		// problemz right herez

		// Testing addElement

		// System.out.println(sl.toString() + "\n" + "Elements in list: " +
		// sl.countElements() + "\n");
		// System.out.println("Adding Anders...");
		// sl.addElement("Anders");
		// System.out.println(sl.toString() + "\n" + "Elements in list: " +
		// sl.countElements() + "\n");
		// System.out.println("Adding bjarne...");
		// sl.addElement("Bjarne");
		// System.out.println(sl.toString() + "\n" + "Elements in list: " +
		// sl.countElements() + "\n");
		// System.out.println("Adding Peter...");
		// sl.addElement("Peter");
		// System.out.println(sl.toString() + "\n" + "Elements in list: " +
		// sl.countElements() + "\n");
		// System.out.println("Adding Grethe...");
		// sl.addElement("Grethe");
		// System.out.println(sl.toString() + "\n" + "Elements in list: " +
		// sl.countElements() + "\n");
		// System.out.println("Adding Abel...");
		// sl.addElement("Abel");
		// System.out.println(sl.toString() + "\n" + "Elements in list: " +
		// sl.countElements() + "\n");
		// System.out.println("Adding Xare...");
		// sl.addElement("Xare");
		// System.out.println(sl.toString() + "\n" + "Elements in list: " +
		// sl.countElements() + "\n");
		// System.out.println("Adding Xara...");
		// sl.addElement("Xara");
		// System.out.println(sl.toString() + "\n" + "Elements in list: " +
		// sl.countElements() + "\n");
		// System.out.println("Adding Aage...");
		// sl.addElement("Aage");
		// System.out.println(sl.toString() + "\n" + "Elements in list: " +
		// sl.countElements() + "\n");
		// System.out.println("_________________________________________________________\n\n");
		// System.out.println(sl.toString());
		// System.out.println("Removing Abel: " + sl.removeElement("Abel") + "\n");
		// System.out.println(sl.toString());
		// System.out.println("Removing Pedro: " + sl.removeElement("Pedro") + "\n");
		// System.out.println(sl.toString());
		// System.out.println("Removing Grethe: " + sl.removeElement("Grethe") + "\n");
		// System.out.println(sl.toString());

		// Testing removeElement

		// System.out.println("0 elements in list: " + sl.removeElement("Bjarne") +
		// "\n\n");

		sl.addElement("Bjarne");
		System.out.println("Adding Bjarne to list: " + sl.toString());
		System.out.println("1 element in list - Correct input: " + sl.removeElement("Bjarne"));
		System.out.println(sl.toString());
	}

}
