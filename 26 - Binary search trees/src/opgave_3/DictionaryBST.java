package opgave_3;

public class DictionaryBST<K extends Comparable<K>, V> implements Dictionary<K, V> {
	private Node root;
	private int itemsInList;

	public DictionaryBST() {
		root = null;
		itemsInList = 0;
	}

	@Override
	public V get(K key) {
		return find(key).value;
	}

	private Node find(K key) {
		Node current = root;
		boolean found = false;
		while (!found && current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		if (found) {
			return current;
		} else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	@Override
	public V put(K key, V value) {
		Node newNode = new Node(key, value);
		V returnValue = null;

		if (find(key) != null) {
			returnValue = find(key).value;
		}

		if (root == null) {
			root = newNode;
			itemsInList++;
			return newNode.value;

		} else {
			root.addNode(newNode);
		}

		return returnValue;
	}

	@Override
	public V remove(K key) {
		Node focus = root;
		Node parent = null;
		V toReturn = null;
		boolean found = false;
		while (!found && focus != null) {
			int d = focus.key.compareTo(key);
			if (d == 0) {
				found = true;
				toReturn = focus.value;
			} else {
				parent = focus;
				if (d > 0) {
					focus = focus.left;
				} else {
					focus = focus.right;
				}
			}
		}

		if (found) {
			// toBeRemoved contains obj
			// If one of the children is empty, use the other
			if (focus.left == null || focus.right == null) {
				Node newChild;
				if (focus.left == null) {
					newChild = focus.right;
				} else {
					newChild = focus.left;
				}

				if (parent == null) // Found in root
				{
					root = newChild;
				} else if (parent.left == focus) {
					parent.left = newChild;
				} else {
					parent.right = newChild;
				}

			} else {
				// Neither subtree is empty
				// Find smallest element of the right subtree
				Node smallestParent = focus;
				Node smallest = focus.right;
				while (smallest.left != null) {
					smallestParent = smallest;
					smallest = smallest.left;
				}

				// smallest contains smallest child in right subtree
				// Move contents, unlink child
				focus.key = smallest.key;
				focus.value = smallest.value;
				if (smallestParent == focus) {
					smallestParent.right = smallest.right;
				} else {
					smallestParent.left = smallest.right;
				}
			}
		}
		itemsInList--;
		return toReturn;
	}

	@Override
	public int size() {
		return itemsInList;
	}

	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}

		/**
		 * Inserts a new node as a descendant of this node.
		 *
		 * @param newNode
		 *            the node to insert
		 */
		private void addNode(Node newNode) {

			int c = newNode.key.compareTo(this.key);

			if (c == 0) {
				this.value = newNode.value;

			} else if (c < 0) {
				if (left == null) {
					left = newNode;
					itemsInList++;
				} else {
					left.addNode(newNode);
				}
			} else {
				if (right == null) {
					right = newNode;
					itemsInList++;
				} else {
					right.addNode(newNode);
				}
			}

		}

	}
}
