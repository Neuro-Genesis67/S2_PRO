package exercises;

import java.util.LinkedList;

import opgave_1.Stack;

public class LinkListStack<T> implements Stack<T> {

	LinkedList<T> li = new LinkedList<>();

	@Override
	public void push(T data) {
		li.addFirst(data);
	}

	@Override
	public T pop() {
		if (!li.isEmpty()) {
			return li.removeFirst();
		} else {
			return null;
		}
	}

	public void displayStack() {
		System.out.println(li.toString());
	}

	@Override
	public T peek() {
		return li.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return li.isEmpty();
	}

	@Override
	public int size() {
		return li.size();
	}

	public static void main(String[] arguments) {
		LinkListStack<String> stack = new LinkListStack<>();
		stack.push("Test");
		stack.displayStack();
	}
}
