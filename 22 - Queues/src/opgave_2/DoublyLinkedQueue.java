package opgave_2;

import java.util.NoSuchElementException;

public class DoublyLinkedQueue<T> implements Deque<T> {

	Node first;
	Node last;
	int listSize = 0;

	class Node {

		Node next;
		Node prev;
		T data;

		public Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "" + this.data;
		}

	}

	@Override
	public void addFirst(T data) {
		Node newNode = new Node(data);

		if (first == null) {
			first = newNode;
			last = newNode;
			listSize++;

		} else {
			newNode.next = first;
			first.prev = newNode;
			first = newNode;
			listSize++;
		}

	}

	@Override
	public void addLast(T data) {
		Node newNode = new Node(data);

		if (last == null) {
			first = newNode;
			last = newNode;
			listSize++;

		} else {
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
			listSize++;
		}
	}

	@Override
	public T removeFirst() {
		Node old = first;

		if (listSize == 0) {
			throw new NoSuchElementException();
		}

		if (first == null) {
			return null;
		}

		else if (first.next == null) {
			first = null;
			listSize--;

		} else {
			first = first.next;
			listSize--;
		}

		return old.data;
	}

	@Override
	public T removeLast() {
		Node old = last;

		if (listSize == 0) {
			throw new NoSuchElementException();
		}

		else if (last.prev == first) {
			System.out.println("ELSE IF 1");
			last = first;
			first.next = null; // Test if line works
			listSize--;
		}

		else if (last == first) {
			System.out.println("ELSE IF 2");
			first = last = null; // Does this format work?
			listSize--;
		}

		else {
			last.prev.next = null;
			last = last.prev;
			listSize--;
		}

		return old.data;
	}

	@Override
	public T getFirst() {
		if (listSize == 0) {
			throw new NoSuchElementException();
		}

		return first.data;
	}

	@Override
	public T getLast() {
		if (listSize == 0) {
			throw new NoSuchElementException();
		}
		return last.data;
	}

	@Override
	public int size() {
		return listSize;
	}

	@Override
	public boolean isEmpty() {
		if (listSize == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {

		if (first == null) {
			return "Can't print list. No data in list";
		}

		String result = "[ " + first.data;
		Node iter = first;

		while (iter.next != null) {
			result += " | " + iter.next;
			iter = iter.next;
		}
		return result + " ]";
	}

}
