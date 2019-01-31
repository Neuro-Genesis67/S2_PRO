package dictionary;

import java.util.ArrayList;

public class GenericDictionary<K, V> implements DictionaryI<K, V> {

	class Node {
		public K key;
		public V value;
	}

	private K key;
	private V value;
	private ArrayList<Node> nodes = new ArrayList<>();

	public GenericDictionary() {
	}

	@Override
	public V get(K key) {
		for (Node n : nodes) {
			if (n.key.equals(key)) {
				return n.value;
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	// List is empty = Insert new node with user-specified method parameters
	// Same key
	@Override
	public V put(K key, V value) {
		for (Node n : nodes) {
			if (n.key.equals(key)) {
				V old = n.value;
				n.value = value;
				return old;
			}
		}
		Node newNode = new Node();
		newNode.key = key;
		newNode.value = value;
		nodes.add(newNode);
		return null;
	}

	@Override
	public V remove(K key) {
		for (Node n : nodes) {
			if (n.key.equals(key)) {
				nodes.remove(n);
				return n.value;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return nodes.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Node n : nodes) {
			sb.append(" " + n.key + ":" + n.value);
		}
		sb.append(".");
		String result = sb.toString();
		return result;
	}

}
