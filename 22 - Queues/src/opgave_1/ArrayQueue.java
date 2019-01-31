package opgave_1;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {

	T[] queue;
	T frontObject;
	int tail;

	public ArrayQueue() {
		queue = (T[]) new Object[10];
		frontObject = queue[0];
		tail = 0;
	}

	/**
	 * Adds an element to the tail of this queue.
	 * 
	 * @param newElement
	 *            the element to add
	 */
	@Override
	public void enqueue(T element) {
		if (tail == queue.length) {
			extendQueue();
		}
		queue[tail] = element;
		tail++;
	}

	/*
	 * Expands the length of the queue.
	 */
	public void extendQueue() {
		@SuppressWarnings("unchecked")
		T[] newArr = (T[]) new Object[queue.length * 2];
		for (int i = 0; i < queue.length; i++) {
			newArr[i] = queue[i];

		}
		queue = newArr;
	}

	/**
	 * Removes an element from the head of this queue.
	 * 
	 * @return the removed element
	 */
	@Override
	public T dequeue() {
		T element = queue[0]; // Extracting the front of the queue
		for (int i = 1; i < queue.length; i++) {
			queue[i - 1] = queue[i];
		}
		tail--; // Dobbelt tjek senere
		return element;
	}

	/**
	 * Returns the head of this queue. The queue is unchanged.
	 * 
	 * @return the head element
	 */
	@Override
	public T getFront() {
		if (frontObject == null) {
			throw new NoSuchElementException();
		}
		return frontObject;
	}

	/**
	 * The number of elements on the queue.
	 * 
	 * @return the number of elements in the queue
	 */
	@Override
	public int size() {
		return queue.length;
	}

	/*
	 * Checks whether this queue is empty.
	 * 
	 * @return true if the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		if (tail == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String res = "[\n";
		for (T t : queue) {
			if (t == null) {

			} else {

				res += t + "\n";
			}
		}
		return res + "]";
	}

}
