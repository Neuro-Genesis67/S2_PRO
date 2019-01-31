package tree;

/**
 * A binary tree in which each node has two children.
 */
public class BinaryTree<E> {
	private Node root;
	private static int nodesInTree = 0;
	private static int sum = 0;

	private class Node {
		public E data;
		public Node left;
		public Node right;
	}

	/**
	 * Constructs an empty tree.
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Constructs a tree with one node and no children.
	 * 
	 * @param rootData
	 *            the data for the root
	 */
	public BinaryTree(E rootData) {
		root = new Node();
		root.data = rootData;
		root.left = null;
		root.right = null;
	}

	/**
	 * Constructs a binary tree.
	 * 
	 * @param rootData
	 *            the data for the root
	 * @param left
	 *            the left subtree
	 * @param right
	 *            the right subtree
	 */
	public BinaryTree(E rootData, BinaryTree<E> left, BinaryTree<E> right) {
		root = new Node();
		root.data = rootData;
		if (left != null) {
			root.left = left.root;
		}
		if (right != null) {
			root.right = right.root;
		}
	}

	public int countElements(E element) {
		return countElementsHelper(root, element);

	}

	public int countElementsHelper(Node node, E data) {
		if (node != null && node.data.equals(data)) {
			return 1 + countElementsHelper(node.left, data) + countElementsHelper(node.right, data);

		} else if (node == null) {
			return 0;

		} else {
			return countElementsHelper(node.left, data) + countElementsHelper(node.right, data);
		}
	}

	public int value() {
		return value(root);
	}

	private int value(Node node) {
		if (node.left == null && node.right == null) {
			return Integer.parseInt((String) node.data);
		} else if (node.data == "+") {
			return value(node.left) + value(node.right);
		}
		return value(node.left) * value(node.right);
	}

	/**
	 * Checks whether this tree is empty.
	 * 
	 * @return true if this tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Gets the data at the root of this tree.
	 * 
	 * @return the root data
	 */
	public E data() {
		return root.data;
	}

	/**
	 * Gets the left subtree of this tree.
	 * 
	 * @return the left child of the root
	 */
	public BinaryTree<E> left() {
		BinaryTree<E> result = new BinaryTree<E>();
		result.root = root.left;
		return result;
	}

	/**
	 * Gets the right subtree of this tree.
	 * 
	 * @return the right child of the root
	 */
	public BinaryTree<E> right() {
		BinaryTree<E> result = new BinaryTree<E>();
		result.root = root.right;
		return result;

	}

	/**
	 *
	 * @param rootData
	 *            the new data for the root
	 * @return the data previous in the root
	 */
	public E replace(E rootData) {
		Node old = new Node();
		old.data = root.data;
		root.data = rootData;
		return old.data;
	}

	/**
	 * The size of the tree
	 * 
	 * @return the number of nodes in the tree
	 */
	public int size() {
		return size(root);
	}

	// Private recursive helper method
	private int size(Node groot) {

		if (groot == null) {
			return 0;
		}

		return 1 + size(groot.left) + size(groot.right);
	}

	public int sumOfTree() {
		sum = sumOfTreeHelper(root);
		if (nodesInTree == 0) {
			return 0;
		}
		return sumOfTreeHelper(root) / size(root);
	}

	private int sumOfTreeHelper(Node groot) {

		if (groot == null) {
			return 0;
		} else {
			nodesInTree++;
		}

		return (Integer) groot.data + sumOfTreeHelper(groot.left) + sumOfTreeHelper(groot.right);

	}

	public void inOrderTraverseTree() {
		inOrderTraverseTreeHelper(root);
	}

	private void inOrderTraverseTreeHelper(Node node) {

		if (node != null) {
			inOrderTraverseTreeHelper(node.left);

			System.out.println(node.data);

			inOrderTraverseTreeHelper(node.right);
		}
	}
}
