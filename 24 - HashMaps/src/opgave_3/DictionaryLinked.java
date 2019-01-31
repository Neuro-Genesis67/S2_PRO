package opgave_3;

//ingen rehash i den her
public class DictionaryLinked<T, V> implements Dictionary<T, V> {
	private Node start;
	private int itemsInList;

	private class Node {
		Node next;
		T key;
		V data;

		public Node(T key, V value) {
			this.key = key;
			this.data = value;
		}

		public Node() {

		}
	}

	public DictionaryLinked() {
		start = new Node(); // Sentinel
		itemsInList = 0;
	}

	@Override
	public V get(T key) {

		Node node = start.next;
		boolean found = false;

		if (node == null) {
			return null;

		} else if (node.next == null) {
			if (node.key == key) {
				return node.data;
			} else {
				return null;
			}

		} else {
			while (!found) {

				if (node.key == key) {
					return node.data;
				} else {
					if (node.next == null) {
						return null;
					}
				}
				node = node.next;
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return itemsInList == 0;
	}

	@Override
	public V put(T key, V value) { // Test after removing something & remember to increase "size"
		Node newNode = new Node(key, value);
		Node next = start.next;

		// Hvis listen er tom
		if (next == null) {
			start.next = newNode;
			itemsInList++;
			return null;
		}
		while (next.next != null && !next.key.equals(newNode.key)) {
			// System.out.println("|next = next.next|");
			next = next.next;
		}
		if (next.key.equals(newNode.key)) {
			// System.out.println("|Key is found|");
			V oldValue = next.data;
			next.data = newNode.data;
			return oldValue;
		} else {
			// System.out.println("|next.next = newNode|");
			next.next = newNode;
			itemsInList++;
			return null;
		}
	}

	// * Fjerner (nøgle, værdi)-parret med nøglen key fra dictionary'en og value
	// * returneres. Hvis key ikke findes, returneres null.
	@Override
	public V remove(T key) {
		Node next = start.next;
		Node prev = next;

		if (next == null) {
			System.out.println("Expected: IllegalStateException()");
			throw new IllegalStateException();
		}

		while (next.next != null && next.key != key) {
			// System.out.println("Next != null && key not found");
			prev = next;
			next = next.next;
		}
		if (next.key == key && next.next == null) {
			// System.out.println("Key found and no more nodes in list");
			prev.next = null;
			itemsInList--;
			return next.data;
		} else if (next.key == key && next.next != null) {

			if (next == start.next) {
				// System.out.println("Key is first in list and && more nodes in list");
				start.next = next.next;
				itemsInList--;
				return next.data;
			} else {
				// System.out.println("Key found and && more nodes in list");
				prev.next = next.next;
				itemsInList--;
				return prev.data;
			}
		}
		// System.out.println("Returning null");
		return null;
	}

	@Override
	public int size() {
		return itemsInList;
	}

	@Override
	public String toString() {
		String result = "\n";
		Node next = start.next;
		if (next == null) {
			return "Nothing in list";
		} else {
			while (next.next != null) {
				result += "[ Key: " + next.key + " - Value: " + next.data + " ]\n";
				next = next.next;
			}
		}
		result += "[ Key: " + next.key + " - Value: " + next.data + " ]\n";
		return result;
	}

}
