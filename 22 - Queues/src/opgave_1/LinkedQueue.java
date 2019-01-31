package opgave_1;

public class LinkedQueue<T> implements Queue<T> {

	Node first;
	Node last;
	int size;

	class Node {
		private T data;
		private Node next;

		Node(T element) {
			this.data = element;
		}

		// @Override
		// public String toString() {
		// return "" + this.data;
		// }
	}

	public LinkedQueue() {
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void enqueue(T element) {
		Node newNode = new Node(element);

		if (isEmpty()) {
			first = newNode;
			last = newNode;
			size++;
		} else {
			last.next = newNode;
			last = newNode;
			size++;
		}

	}

	@Override
	public T dequeue() {
		Node newNode = first;

		if (isEmpty()) {
			first = null;
			last = null;
			size = 0;
			return null;
		} else if (first.next == null) {
			first = null;
			last = null;
			size = 0;
			return newNode.data;
		} else {
			first = first.next;
			size--;
			return newNode.data;
		}

	}

	@Override
	public T getFront() {
		if (!isEmpty()) {
			return first.data;
		} else {
			return null;
		}
	}

	@Override
	public int size() {
		return size;

	}

	@Override
	public String toString() {
		String res = "[ ";
		Node node = first;

		if (isEmpty()) {
			return "Queue is empty";
		} else {

			while (node.next != null) {
				res += node.data + " | ";
				node = node.next;
			}
		}

		return res += node.data + " ]";
	}

}
