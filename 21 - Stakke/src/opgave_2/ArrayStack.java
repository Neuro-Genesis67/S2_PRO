package opgave_2;

import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {

	T[] stack;
	int top = 0;

	// { ( [ ] ) } = input
	// 1 2 3 2 1 0 = top
	// 0 1 2 3 4 5 = index

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
			T removed = stack[top--]; // --pos = tæller pos ned før metoden køres
			stack[top] = null; // pos-- tæller pos ned efter metoden er kørt (stadig usikker)
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

	public static boolean checkParenteses(String s) {
		ArrayStack<Character> stack = new ArrayStack<>();
		Character c;

		try {
			for (int i = 0; i < s.length(); i++) {
				switch (s.charAt(i)) {
				case '(':
					System.out.println("Engage push: (");
					stack.push('(');
					break;
				case '[':
					System.out.println("Engage push: [");
					stack.push('[');
					break;
				case '{':
					System.out.println("Engage push: {");
					stack.push('{');
					break;
				case ')':
					System.out.println("Engage pop: )");
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						return false;
					}
					break;
				case ']':
					System.out.println("Engage pop: ]");
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						return false;
					}
					break;
				case '}':
					System.out.println("Engage pop: }");
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						return false;
					}
					break;
				default:
					break;
				}
			}
		} catch (EmptyStackException e) {
			return false;
		}
		return stack.isEmpty();
	}

	@Override
	public String toString() {
		String res = "";
		for (T t : stack) {
			if (t == null) {
			} else {
				res = res + t + "\n";
			}
		}
		return res;
	}

}
