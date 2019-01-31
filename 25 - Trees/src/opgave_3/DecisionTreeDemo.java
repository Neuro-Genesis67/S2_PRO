package opgave_3;

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

		System.out.println(t1_1.sumOfTree());
		// System.out.println(t1_1.size());

		// BinaryTree<String> tiger = new BinaryTree<String>("It ia a tiger.");
		// BinaryTree<String> zebra = new BinaryTree<String>("It is a zebra.");
		// BinaryTree<String> canivore = new BinaryTree<String>("Is it a carnivore?",
		// tiger, zebra);
		//
		// BinaryTree<String> pig = new BinaryTree<String>("It is a pig.");
		// BinaryTree<String> stripes = new BinaryTree<String>("Does it have stripes?",
		// canivore, pig);
		//
		// System.out.println("Size of stripes tree: " + stripes.size());
		//
		// BinaryTree<String> penguin = new BinaryTree<String>("It is a penguin.");
		// BinaryTree<String> ostrich = new BinaryTree<String>("It is an ostrich.");
		// BinaryTree<String> swim = new BinaryTree<String>("Does it swim?", penguin,
		// ostrich);
		//
		// BinaryTree<String> eagle = new BinaryTree<String>("It is an eagle.");
		// BinaryTree<String> fly = new BinaryTree<String>("Does it fly?", eagle, swim);
		//
		// BinaryTree<String> questionTree = new BinaryTree<String>("Is it a mammal?",
		// stripes, fly);

		// questionTree.inorder();

		// ---------------------45-----------------
		// -------22-------------------77----------
		// --11---------30--------------------90---
		// -----15---25---------------- --88-------

	}
}
