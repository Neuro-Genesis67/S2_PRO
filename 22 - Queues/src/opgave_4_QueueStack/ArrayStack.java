package opgave_4_QueueStack;

import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {

	T[] stack;
	int top = 0;

	public ArrayStack() {
		stack = (T[]) new Object[10];
		top = 0;
	}

	private void extendStack() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[stack.length * 2];
		for (int i = 0; i < stack.length; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}

	@Override
	public void push(T element) {
		if (top == stack.length) {
			extendStack();
		}
		stack[top] = element;
		top++;
	}

	@Override
	public T pop() {
		if (top == 0) {
			throw new EmptyStackException();
		} else {
			top--;
			T removed = stack[top];
			stack[top] = null;
			return removed;
		}
	}

	@Override
	public T peek() {
		if (top == 0) {
			throw new EmptyStackException();
		}
		return stack[top - 1];
	}

	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	@Override
	public int size() {
		return top;
	}

	@Override
	public String toString() {
		int i = 0;
		String res = "[ ";

		for (T t : stack) {
			i++;

			if (t == null) {
				res += "";
			} else if (i == 1) {
				res += t;
			} else {
				res += " | " + t;
			}
		}
		return res + " ]";
	}

}
