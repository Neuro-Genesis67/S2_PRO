package opgave_4_StackQueue;

import java.util.EmptyStackException;

public class StackQueue<T> implements Stack<T> {

	ArrayQueue<T> in = new ArrayQueue<>();
	ArrayQueue<T> out = new ArrayQueue<>();
	int size = 0;

	@Override
	public void push(T element) {
		in.enqueue(element);
		size++;
	}

	@Override
	public T pop() {

		if (in.isEmpty() && out.isEmpty())
			throw new EmptyStackException();

		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.enqueue(in.dequeue());
			}
		}
		size--;
		return out.dequeue();
	}

	@Override
	public T peek() {

		T item = pop();
		push(item);

		return item;
	}

	@Override
	public boolean isEmpty() {
		if (in.isEmpty() && out.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		int i = 0;
		int j = 0;
		T item;
		ArrayQueue<T> temp = new ArrayQueue<>();
		String result = "[ ";

		while (!out.isEmpty()) {
			i++;
			item = out.dequeue();
			temp.enqueue(item);
			if (i == 1) {
				result += item;
			} else {
				result += " - " + item;
			}
		}

		while (!temp.isEmpty()) {
			out.enqueue(temp.dequeue());
		}

		while (!in.isEmpty()) {
			j++;
			item = in.dequeue();
			temp.enqueue(item);
			if (j == 1) {
				result += item;
			} else {
				result += " - " + item;
			}

		}

		while (!temp.isEmpty()) {
			in.enqueue(temp.dequeue());
		}

		return result + " ]";

	}

}
