package opgave_2;

/**
 * This program demonstrates a decision tree for an animal guessing game.
 */
public class DecisionTreeDemo {
	public static void main(String[] args) {

		BinaryTree<Integer> t1_4 = new BinaryTree<>(15);
		BinaryTree<Integer> t2_4 = new BinaryTree<>(25);
		BinaryTree<Integer> t3_4 = new BinaryTree<>(88);

		BinaryTree<Integer> t1_3 = new BinaryTree<>(11, null, t1_4);
		BinaryTree<Integer> t2_3 = new BinaryTree<>(30, t2_4, null);
		BinaryTree<Integer> t3_3 = new BinaryTree<>(90, t3_4, null);

		BinaryTree<Integer> t1_2 = new BinaryTree<>(22, t1_3, t2_3);
		BinaryTree<Integer> t2_2 = new BinaryTree<>(77, null, t3_3);

		BinaryTree<Integer> t1_1 = new BinaryTree<>(45, t1_2, t2_2);

		System.out.println("Height of tree: " + t1_1.getHeight() + "\n");
		System.out.println("in order traversal: ");
		t1_1.inOrderTraversal();

		System.out.println("\n\nPreorder traversal: ");
		t1_1.preorderTraversal();

		System.out.println("\n\nPostorder traversal: ");
		t1_1.postOrderTraversal();

		// ---------------------45-----------------
		// -------22-------------------77----------
		// --11---------30--------------------90---
		// -----15---25-------------------88-------

	}
}
