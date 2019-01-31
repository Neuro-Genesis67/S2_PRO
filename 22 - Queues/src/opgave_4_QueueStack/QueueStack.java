package opgave_4_QueueStack;

import java.util.NoSuchElementException;

public class QueueStack<T> implements Queue<T> {

	ArrayStack<T> in = new ArrayStack<>();
	ArrayStack<T> out = new ArrayStack<>();

	public QueueStack() {
	}

	@Override
	public void enqueue(T data) {

		in.push(data);
	}

	@Override
	public T dequeue() {

		if (out.isEmpty()) {

			while (!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		return out.pop();
	}

	// public void mergeStacks() {
	//
	// while (!in.isEmpty()) {
	// out.push(in.pop());
	// }
	// }

	@Override
	public boolean isEmpty() {

		if (in.isEmpty() && out.isEmpty()) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public T getFront() {

		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T item = dequeue();
		enqueue(item);
		return item;
	}

	@Override
	public int size() {
		return in.size() + out.size();
	}

	@Override
	public String toString() {

		T item;
		String result = "[ ";
		int i = 0;

		while (!in.isEmpty()) {
			out.push(in.pop());
		}

		while (!out.isEmpty()) {
			i++;
			if (i == 1) {
				item = dequeue();
				result += item;
				enqueue(item);

			} else {
				item = dequeue();
				result += " - " + item;
				enqueue(item);
			}

		}
		return result + " ]";
	}

}
