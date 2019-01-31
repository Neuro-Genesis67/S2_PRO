package opgave_3;

public class SortedLinkedListTest {

	public static void main(String[] args) {
		// SortedLinkedList sl = new SortedLinkedList();
		// System.out.println("Adding bjarne");
		// sl.addElement("Bjarne");
		// System.out.println(sl.toString() + " = " + sl.countElements() +
		// "Element.\n");
		// System.out.println("Adding Anders");
		// sl.addElement("Anders");
		// System.out.println(sl.toString() + " = " + sl.countElements() +
		// "Elements.\n");
		// System.out.println("Adding Peter");
		// sl.addElement("Peter");
		// System.out.println(sl.toString() + " = " + sl.countElements() +
		// "Elements.\n");
		// System.out.println("Adding Grethe");
		// sl.addElement("Grethe");
		// System.out.println(sl.toString() + " = " + sl.countElements() +
		// "Elements.\n");
		// System.out.println("Adding Abel");
		// sl.addElement("Abel");
		// System.out.println(sl.toString() + " = " + sl.countElements() +
		// "Elements.\n");
		// System.out.println("Adding Xare");
		// sl.addElement("Xare");
		// System.out.println(sl.toString() + " = " + sl.countElements() +
		// "Elements.\n");
		// System.out.println("Adding Xara");
		// sl.addElement("Xara");
		// System.out.println(sl.toString() + " = " + sl.countElements() +
		// "Elements.\n\n");
		// System.out.println("_________________________________________________________\n\n");
		// System.out.println(sl.toString());
		// System.out.println("Removing Abel: " + sl.removeElement("Abel") + "\n");
		// System.out.println(sl.toString());
		// System.out.println("Removing Pedro: " + sl.removeElement("Pedro") + "\n");
		// System.out.println(sl.toString());
		// System.out.println("Removing Grethe: " + sl.removeElement("Grethe") + "\n");
		// System.out.println(sl.toString());
		//
		// sl.addElement("Abe");
		// System.out.println(sl.toString());
		// sl.addElement("Abernes konge");
		// System.out.println(sl.toString());
		// sl.addElement("Aberne");
		// System.out.println(sl.toString());
		// sl.addElement("Aben");
		// System.out.println(sl.toString());
		// sl.addElement("Aber");
		// System.out.println(sl.toString());

		// For some reason this doesn't work:
		// System.out.println("This the house that funk built, groove armada style");
		// System.out.println("Adding bjarne");
		// sl.addElement("Bjarne");
		// System.out.println(sl.toString() + " = " + sl.countElements() + "
		// Elements.\n");
		// System.out.println("Adding Peter");
		// sl.addElement("Peter");
		// System.out.println(sl.toString() + " = " + sl.countElements() + "
		// Elements.\n");
		// System.out.println("Adding Grethe");
		// sl.addElement("Grethe");
		// System.out.println(sl.toString() + " = " + sl.countElements() + "
		// Elements.\n");
		// System.out.println("Adding Abel");
		// sl.addElement("Abel");
		// System.out.println(sl.toString() + " = " + sl.countElements() + "
		// Elements.\n");
		// System.out.println("Adding Xara");
		// sl.addElement("Xara");
		// System.out.println(sl.toString() + " = " + sl.countElements() + "
		// Elements.\n\n");
		// System.out.println("_________________________________________________________\n\n");
		// System.out.println(sl.toString());
		// System.out.println("Removing Abel: " + sl.removeElement("Abel") + "\n");
		// System.out.println(sl.toString());
		// System.out.println("Removing Grethe: " + sl.removeElement("Grethe") + "\n");
		// System.out.println(sl.toString() + "\n\n\n\nNow testing with monkeys: ");
		// sl.addElement("Abe");
		// System.out.println(sl.toString());
		// sl.addElement("Abernes konge");
		// System.out.println(sl.toString());
		// sl.addElement("Aberne");
		// System.out.println(sl.toString());
		// sl.addElement("Aben");
		// System.out.println(sl.toString());
		// sl.addElement("Aber");
		// System.out.println(sl.toString());

		// Test addAll method
		SortedLinkedList sl1 = new SortedLinkedList();
		sl1.addElement("En kop");
		sl1.addElement("En kage");
		sl1.addElement("En kronhjort");
		sl1.addElement("En hage");
		System.out.println("List 1: " + sl1.toString());

		SortedLinkedList sl2 = new SortedLinkedList();
		sl2.addElement("Et rensdyr");
		sl2.addElement("En gaffel");
		sl2.addElement("Et udspring");
		sl2.addElement("En karaffel");
		System.out.println("List 2: " + sl2.toString());
		sl1.addAll(sl2);
		System.out.println("\nList 1 after using addAll with list 2 as parameter: \n" + sl1.toString());

	}

}
