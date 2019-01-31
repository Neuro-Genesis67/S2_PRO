package queues;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * An implementation of a queue as a circular array.
 */
public class CircularArrayQueue<T> implements Queue<T> {
	private T[] list;
	private int size;
	private int head;
	private int tail;

	/**
	 * Constructs an empty queue.
	 */
	public CircularArrayQueue() {
		final int INITIAL_SIZE = 10;
		list = (T[]) new Object[INITIAL_SIZE];
		size = 0;
		head = 0;
		tail = 0;
	}

	public void setRandomInListAsFirst() {
		T[] tempList = (T[]) new Object[size]; // New list
		int i = 1;

		Random r = new Random();

		T pick = list[r.nextInt(size - 0) + 0]; // The chosen object

		if (size == 0) {
			throw new NoSuchElementException();

		} else if (size == 1) {
			// Do nothing

		} else {

			tempList[0] = pick;

			for (T t : list) {
				if (t == pick) {

				} else if (i < size) {
					tempList[i] = t;
					i++;
				}

			}
			list = tempList;

		}
	}

	public T spisHam(int index) {
		T spistePerson = list[index];
		list[index] = null;
		size--;
		// System.out.println(size);
		while (index < size - 1) {
			list[index] = list[index + 1];
			index++;
		}

		return spistePerson;

	}

	/**
	 * Checks whether this queue is empty.
	 *
	 * @return true if this queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Adds an element to the tail of this queue.
	 *
	 * @param newElement
	 *            the element to add
	 */
	@Override
	public void enqueue(T newElement) {
		growIfNecessary();
		size++;
		list[tail] = newElement;
		tail = (tail + 1) % list.length; // List size 10: 9+1 % 10 = 0 | 10+1 % 10 = 1.
	}

	/**
	 * Removes an element from the head of this queue.
	 *
	 * @return the removed element
	 */
	@Override
	public T dequeue() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		T removed = list[head];
		list[head] = null;
		head = (head + 1) % list.length;
		size--;
		return removed;
	}

	public int getRandomIndex() {
		int result;
		if (size == 0)
			throw new NoSuchElementException();
		result = (int) (Math.random() * size + 1);
		return result;
	}

	/**
	 * Grows the element array if the current size equals the capacity.
	 */
	private void growIfNecessary() {
		if (size == list.length) {
			T[] newElements = (T[]) new Object[2 * list.length];
			for (int i = 0; i < list.length; i++) {
				newElements[i] = list[(head + i) % list.length];
			}
			list = newElements;
			head = 0;
			tail = size;
		}
	}

	@Override
	public T getFront() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return list[head];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		String result = "[ ";
		int iter = 0;

		if (isEmpty())
			return "List is empty";

		for (T t : list) {
			if (iter == 0 && t != null) {
				result += t;
			} else if (iter == 0 && t == null) {

			}

			else if (t == null) {

			}

			else {
				result += " | " + t;
			}
			iter++;
		}

		return result + " ]";
	}

}
