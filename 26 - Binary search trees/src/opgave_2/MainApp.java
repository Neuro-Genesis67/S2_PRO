package opgave_2;

public class MainApp {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.add(45);
		bst.add(22);
		bst.add(77);
		bst.add(11);
		bst.add(30);
		bst.add(90);
		bst.add(15);
		bst.add(25);
		bst.add(88);
		System.out.println("findMax(); = " + bst.findMax());
		bst.print();
		System.out.println("removeMin(); = " + bst.removeMin());
		bst.print();
		System.out.println("removeMin(); = " + bst.removeMin());
		bst.print();
		System.out.println("removeMin(); = " + bst.removeMin());
		bst.print();
		System.out.println("removeMin(); = " + bst.removeMin());
		bst.print();
		System.out.println("removeMin(); = " + bst.removeMin());
		bst.print();
		System.out.println("removeMin(); = " + bst.removeMin());
		bst.print();
		System.out.println("removeMin(); = " + bst.removeMin());
		bst.print();
		System.out.println("removeMin(); = " + bst.removeMin());
		bst.print();
		System.out.println("removeMin(); = " + bst.removeMin());
		bst.print();
	}

}
