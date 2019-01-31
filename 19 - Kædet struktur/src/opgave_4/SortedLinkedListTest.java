package opgave_4;

public class SortedLinkedListTest {

	public static void main(String[] args) {
		// Test addAll method
		SortedLinkedList sl1 = new SortedLinkedList();
		sl1.addElement("En kop");
		sl1.addElement("En kage");
		sl1.addElement("En kronhjort");
		sl1.addElement("En hage");
		System.out.println("List 1: " + sl1.toString());
		System.out.println("Elements in list 1: " + sl1.countElements());
		System.out.println("(Recursive) Elements in list 1: " + sl1.recCountElements(sl1.first) + "\n");

		SortedLinkedList sl2 = new SortedLinkedList();
		sl2.addElement("Et rensdyr");
		sl2.addElement("En gaffel");
		sl2.addElement("Et udspring");
		sl2.addElement("En karaffel");
		System.out.println("List 2: " + sl2.toString());
		System.out.println("Elements in list 2: " + sl2.countElements());
		System.out.println("(Recursive) Elements in list 1: " + sl2.recCountElements(sl2.first) + "\n");

		sl1.addAll(sl2);
		System.out.println("\nList 1 after using addAll with list 2 as parameter: \n" + sl1.toString());
		System.out.println("Elements in list 1: " + sl1.countElements());
		System.out.println("(Recursive) Elements in list 1: " + sl1.recCountElements(sl1.first));

	}

}
