package practice;

import java.util.Stack;

public class HandlingStacksTest {

	public static void main(String[] args) {

		// When you print a stack, you use pop to get the items in the stack. Pop also
		// removes the items from the stack, therefore I need to back them up, during
		// the removal process.
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		printStackWithBackup(stack);
		System.out.println();
		printStackWithBackup(stack);

	}

	public static void printStackWithBackup(Stack<Integer> stack) {

		Stack<Integer> backup = new Stack<>();
		while (!stack.isEmpty()) {
			int i = stack.pop(); // Skal den castes?
			System.out.println(i);
			backup.push(i);

		}

		while (!backup.isEmpty()) {
			stack.push(backup.pop());
		}

	}

}
