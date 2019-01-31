package opgave_2;

/**
 * A binary tree in which each node has two children.
 */
public class BinaryTree<E> {
	private Node root;

	private class Node {
		public E data;
		public Node left;
		public Node right;
	}

	public int getHeight() {
		return getHeightHelper(root);
	}

	private int getHeightHelper(Node groot) {

		if (groot == null) {
			return 0;
		}
		return 1 + Math.max(getHeightHelper(groot.left), getHeightHelper(groot.right));
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
	private int size(Node root) {
		int count = 0;

		if (root == null) {
			return 0;
		}

		return 1 + size(root.left) + size(root.right);
	}

	public void inOrderTraversal() {
		inOrderHelper(root);
	}

	public void inOrderHelper(Node groot) {

		if (groot != null) {

			inOrderHelper(groot.left);

			System.out.print(groot.data + " | ");

			inOrderHelper(groot.right);

		}

	}

	public void preorderTraversal() {
		preorderHelper(root);
	}

	public void preorderHelper(Node groot) {

		if (groot != null) {

			System.out.print(groot.data + " | ");

			preorderHelper(groot.left);

			preorderHelper(groot.right);

		}

	}

	public void postOrderTraversal() {

		postOrderHelper(root);
	}

	public void postOrderHelper(Node groot) {

		if (groot != null) {

			postOrderHelper(groot.left);

			postOrderHelper(groot.right);

			System.out.print(groot.data + " | ");
		}

	}

}
