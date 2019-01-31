package opgave_3;

import java.util.NoSuchElementException;

import opgave_1.Stack;

public class DropOutStackArray<T> implements Stack<T> {

	T[] stack;
	int pos = 0;
	int size;
	boolean wrapped;
	T removed;

	public DropOutStackArray(int size) {
		stack = (T[]) new Object[size];
		pos = 0;
		wrapped = false;
		this.size = size;
	}

	public int getPos() {
		return this.pos;
	}

	@Override
	public void push(T element) { // 0 1 2 3 then 4 1 2 3
		if (pos == stack.length) { // ^ ^
			stack[0] = element;
			pos = 1;
			wrapped = true;
		} else {
			stack[pos++] = element; // ++pos tæller pos op før vores expression køres.
		}
	}

	@Override
	public T pop() {
		if (pos == 0 && stack[size - 1] == null) {
			System.out.println("exception");
			throw new NoSuchElementException();
		} else if (pos == 0) {
			pos = size - 1;
			removed = stack[pos];
			stack[pos] = null;
		} else if (stack[pos - 1] != null) {
			removed = stack[pos - 1];
			stack[pos - 1] = null;
			if (pos == 0) {
				pos = stack.length;
			} else {
				pos--;
			}
		}

		return removed;
	}

	@Override
	public T peek() {
		T obj = stack[pos - 1];
		return obj;
	}

	@Override
	public boolean isEmpty() {
		for (T t : stack) {
			if (t != null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int size() {
		int count = 0;
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] != null) {
				count++;
			}
		}
		return count;
	}

	@Override
	public String toString() {
		String res = "[\n";
		for (T t : stack) {
			if (t == null) {
				res += "- | ";
			} else {
				res = res + t + " | ";
			}
		}
		return res + "\n]";
	}
}
