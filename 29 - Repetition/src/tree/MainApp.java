package tree;

public class MainApp {

	public static void main(String[] args) {

		BinaryTree<String> three2 = new BinaryTree<>("7");
		BinaryTree<String> three3 = new BinaryTree<>("3");
		BinaryTree<String> three4 = new BinaryTree<>("8");

		BinaryTree<String> four1 = new BinaryTree<>("2");
		BinaryTree<String> four2 = new BinaryTree<>("4");

		BinaryTree<String> three1 = new BinaryTree<>("+", four1, four2);
		BinaryTree<String> two2 = new BinaryTree<>("+", three3, three4);
		BinaryTree<String> two1 = new BinaryTree<>("*", three1, three2);
		BinaryTree<String> one = new BinaryTree<>("+", two1, two2);

		System.out.println("Count elements: " + one.countElements("+") + "\n");
		System.out.println("value(): " + one.value() + "\n\ninOrderTraverseTree(): ");
		one.inOrderTraverseTree();
	}

}
