package opgave_2;

import java.util.NoSuchElementException;

/**
 * This class implements a binary search tree whose nodes hold objects that
 * implement the Comparable interface.
 */
public class BinarySearchTree<E extends Comparable<E>> {
	private Node root;

	/**
	 * Constructs an empty tree.
	 */
	public BinarySearchTree() {
		root = null;
	}

	// ____________________________________________________

	/**
	 * Returnerer det største element i det binære søgetræ.
	 **/
	public E findMax() {
		if (root == null) {
			throw new NoSuchElementException();
		}

		return findMax(root);
	}

	public E findMax(Node temp) {

		if (temp.right == null && temp.left == null) {
			return temp.data;

		} else if (temp.right != null) {
			return findMax(temp.right);

		} else {
			return temp.data;
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public E removeMin() {
		return removeMin(root);
	}

	/**
	 * Fjerner knuden med det mindste element i det binære søgetræ og returnerer
	 * værdien af dette.
	 **/
	public E removeMin(Node temp) {
		Node parent = temp;

		if (temp.right == null && temp.left == null) {
			root = null;
			return temp.data;
		}

		if (temp.left == null && temp.right != null) {
			root = temp.right;
			return parent.data;
		}

		while (temp.left != null) {
			parent = temp;
			temp = temp.left;
		}

		if (temp.right == null) {
			parent.left = null;
			return temp.data;
		} else {
			parent.left = temp.right;
			return temp.data;
		}

	}

	// ____________________________________________________

	/**
	 * Inserts a new node into the tree.
	 * 
	 * @param obj
	 *            the object to insert
	 */
	public void add(E obj) {
		Node newNode = new Node();
		newNode.data = obj;
		newNode.left = null;
		newNode.right = null;
		if (root == null) {
			root = newNode;
		} else {
			root.addNode(newNode);
		}
	}

	/**
	 * Tries to find an object in the tree.
	 * 
	 * @param obj
	 *            the object to find
	 * @return true if the object is contained in the tree
	 */
	public boolean find(E obj) {
		Node current = root;
		boolean found = false;
		while (current != null && found == false) {
			int d = current.data.compareTo(obj);
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return found;
	}

	/**
	 * Tries to remove an object from the tree. Does nothing if the object is not
	 * contained in the tree.
	 * 
	 * @param obj
	 *            the object to remove
	 */
	public void remove(E obj) {
		// Find node to be removed
		Node toBeRemoved = root;
		Node parent = null;
		boolean found = false;
		while (!found && toBeRemoved != null) {
			int d = toBeRemoved.data.compareTo(obj);
			if (d == 0) {
				found = true;
			} else {
				parent = toBeRemoved;
				if (d > 0) {
					toBeRemoved = toBeRemoved.left;
				} else {
					toBeRemoved = toBeRemoved.right;
				}
			}
		}

		if (found) {
			// toBeRemoved contains obj
			// If one of the children is empty, use the other
			if (toBeRemoved.left == null || toBeRemoved.right == null) {
				Node newChild;
				if (toBeRemoved.left == null) {
					newChild = toBeRemoved.right;
				} else {
					newChild = toBeRemoved.left;
				}

				if (parent == null) {
					// Found in root
					root = newChild;
				} else if (parent.left == toBeRemoved) {
					parent.left = newChild;
				} else {
					parent.right = newChild;
				}

			} else {
				// Neither subtree is empty
				// Find smallest element of the right subtree
				Node smallestParent = toBeRemoved;
				Node smallest = toBeRemoved.right;
				while (smallest.left != null) {
					smallestParent = smallest;
					smallest = smallest.left;
				}

				// Smallest contains smallest child in right subtree
				// Move contents, unlink child
				toBeRemoved.data = smallest.data;
				if (smallestParent == toBeRemoved) {
					smallestParent.right = smallest.right;
				} else {
					smallestParent.left = smallest.right;
				}
			}
		}
	}

	/**
	 * Prints the contents of the tree in sorted order.
	 */
	public void print() {
		print(root);
		System.out.println();
	}

	/**
	 * Prints a node and all of its descendants in sorted order.
	 * 
	 * @param parent
	 *            the root of the subtree to print
	 */
	private void print(Node parent) {
		if (parent != null) {
			print(parent.left);
			System.out.print(parent.data + " ");
			print(parent.right);
		}
	}

	/**
	 * A node of a tree stores a data item and references to the left and right
	 * child nodes.
	 */
	private class Node {
		private E data;
		private Node left;
		private Node right;

		/**
		 * Inserts a new node as a descendant of this node.
		 * 
		 * @param newNode
		 *            the node to insert
		 */
		private void addNode(Node newNode) {
			int comp = newNode.data.compareTo(data);
			if (comp < 0) {
				if (left == null) {
					left = newNode;
				} else {
					left.addNode(newNode);
				}
			} else if (comp > 0) {
				if (right == null) {
					right = newNode;
				} else {
					right.addNode(newNode);
				}
			}
		}

		public void add(E obj) {
			Node newNode = new Node();
			newNode.data = obj;
			newNode.left = null;
			newNode.right = null;
			if (root == null) {
				root = newNode;
			} else {
				root.addNode(newNode);
			}
		}
	}
}