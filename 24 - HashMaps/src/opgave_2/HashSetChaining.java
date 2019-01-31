package opgave_2;

/**
 * This class implements a hash set using separate chaining.
 */
public class HashSetChaining {
	private Node[] arr;
	private int itemsInList;

	private class Node {
		public Object data;
		public Node next;

		public Node(Object data) {
			this.data = data;
		}
	}

	/**
	 * Constructs a hash table.
	 * 
	 * @param bucketsLength
	 *            the length of the buckets array
	 */
	public HashSetChaining(int size) {
		arr = new Node[size];
		size = 0;
	}

	/**
	 * Tests for set membership.
	 * 
	 * @param obj
	 *            an object
	 * @return true if x is an element of this set
	 */
	public boolean contains(Object obj) {
		int h = hashValue(obj);
		Node tempNode = arr[h];
		boolean found = false;
		while (!found && tempNode != null) {
			if (tempNode.data.equals(obj)) {
				found = true;
			} else {
				tempNode = tempNode.next;
			}
		}
		return found;
	}

	/**
	 * Adds an element to this set.
	 * 
	 * @param data
	 *            an object
	 * @return true if x is a new object, false if x was already in the set
	 */
	public boolean add(Object data) {
		if ((double) itemsInList / arr.length > 0.75) {
			rehash();
		}

		int pos = hashValue(data);

		Node node = arr[pos];
		boolean duplicate = false;

		while (!duplicate && node != null) {
			if (node.data.equals(data)) {
				duplicate = true;
			} else {
				node = node.next;
			}
		}

		if (!duplicate) {
			node = new Node(data);
			node.next = arr[pos];
			arr[pos] = node;
			itemsInList++;
		}
		return false;
	}

	private void rehash() {
		Node[] oldArr = arr;
		arr = new Node[arr.length * 2];
		itemsInList = 0;

		for (int i = 0; i < oldArr.length; i++) {
			Node node = oldArr[i];
			while (node != null) {
				add(node.data);
				node = node.next;
			}
		}

	}

	/**
	 * Removes an object from this set.
	 * 
	 * @param x
	 *            an object
	 * @return true if x was removed from this set, false if x was not an element of
	 *         this set
	 */
	public boolean remove(Object data) {

		int pos = hashValue(data);

		Node node = arr[pos];
		Node prev = node;

		while (!node.data.equals(data) && node.next != null) {
			prev = node;
			node = node.next;
		}

		if (node.data.equals(data)) {
			prev.next = null;
			itemsInList--;
			return true;
		}

		return false;

	}

	private int hashValue(Object obj) {
		int h = obj.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % arr.length;
		return h;
	}

	/**
	 * Gets the number of elements in this set.
	 * 
	 * @return the number of elements
	 */
	public int getNumberOfItemsInList() {
		return itemsInList;
	}

	public int getSize() {
		return arr.length;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			Node temp = arr[i];
			if (temp != null) {
				result += i + "\t";
				while (temp != null) {
					result += temp.data + " (h:" + hashValue(temp.data) + ")\t";
					temp = temp.next;
				}
				result += "\n";
			}
		}
		return result;
	}

}
