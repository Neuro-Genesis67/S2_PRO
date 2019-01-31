package opgave_2;

import java.util.ArrayList;

public class GenericDictionary<K, V> implements Dictionary<K, V> {

	private K key;
	private V value;
	ArrayList<Node> nodeList = new ArrayList<>();

	class Node {
		public K key;
		public V value;
	}

	public GenericDictionary() {
	}

	@Override
	public V get(K key) {
		for (Node n : nodeList) {
			if (n.key.equals(key)) {
				return n.value;
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (nodeList.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public V put(K key, V value) {

		if (key == null || value == null) {
			System.out.println("Key or value can't be null");
			return null;
		}

		for (Node n : nodeList) {
			if (n.key.equals(key)) {
				n.value = value;
				return n.value;

			}
		}
		Node n = new Node(); // Kunne evt. laves som: Node n = new Node(Key, Value);
		n.key = key;
		n.value = value;
		nodeList.add(n);
		return null;
	}

	@Override
	public V remove(K key) {
		for (Node n : nodeList) {
			if (n.key.equals(key)) {
				nodeList.remove(n);
				return n.value;
			}
		}
		return null;
	}

	@Override
	public int size() {
		int count = 0;
		for (Node n : nodeList) {
			count++;
		}
		return count; // Evt. return nodesList.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--- Contents of list: ---\n \n");
		for (Node n : nodeList) {
			sb.append("Key: " + n.key + "\nValue: " + n.value + "\n\n");
		}
		sb.append("-------------------------\n");
		String result = sb.toString();

		return result;
	}

}
