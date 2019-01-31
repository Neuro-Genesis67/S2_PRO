package opgave_1;

public class SortedLinkedListTest {

	public static void main(String[] args) {
		SortedLinkedList sl = new SortedLinkedList();
		System.out.println("Adding bjarne");
		sl.addElement("Bjarne");
		System.out.println(sl.toString() + " = " + sl.countElements() + "Element.\n");
		System.out.println("Adding Anders");
		sl.addElement("Anders");
		System.out.println(sl.toString() + " = " + sl.countElements() + "Elements.\n");
		System.out.println("Adding Peter");
		sl.addElement("Peter");
		System.out.println(sl.toString() + " = " + sl.countElements() + "Elements.\n");
		System.out.println("Adding Grethe");
		sl.addElement("Grethe");
		System.out.println(sl.toString() + " = " + sl.countElements() + "Elements.\n");
		System.out.println("Adding Abel");
		sl.addElement("Abel");
		System.out.println(sl.toString() + " = " + sl.countElements() + "Elements.\n");
		System.out.println("Adding Xare");
		sl.addElement("Xare");
		System.out.println(sl.toString() + " = " + sl.countElements() + "Elements.\n");
		System.out.println("Adding Xara");
		sl.addElement("Xara");
		System.out.println(sl.toString() + " = " + sl.countElements() + "Elements.\n\n");
		System.out.println("_________________________________________________________\n\n");
		System.out.println(sl.toString());
		System.out.println("Removing Abel: " + sl.removeElement("Abel") + "\n");
		System.out.println(sl.toString());
		System.out.println("Removing Pedro: " + sl.removeElement("Pedro") + "\n");
		System.out.println(sl.toString());
		System.out.println("Removing Grethe: " + sl.removeElement("Grethe") + "\n");
		System.out.println(sl.toString());

		sl.addElement("Abe");
		System.out.println(sl.toString());
		sl.addElement("Abernes konge");
		System.out.println(sl.toString());
		sl.addElement("Aberne");
		System.out.println(sl.toString());
		sl.addElement("Aben");
		System.out.println(sl.toString());
		sl.addElement("Aber");
		System.out.println(sl.toString());

	}

}
