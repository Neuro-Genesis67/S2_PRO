package opgave_3;

public class DropOutStackTest {

	public static void main(String[] args) {
		DropOutStackArray<Integer> stack = new DropOutStackArray<>(4);
		// Pop when: (pos == 0)
		// stack.push(1);
		// stack.push(2);
		// stack.push(3);
		// stack.push(4);
		// stack.push(5);
		// stack.push(6);
		// System.out.println(stack + " POS:" + stack.getPos());
		// stack.pop();
		// System.out.println(stack + " POS:" + stack.getPos());
		// stack.pop();
		// System.out.println(stack + " POS:" + stack.getPos());
		// stack.pop();
		// System.out.println(stack + " POS:" + stack.getPos());

		// -------------NoSuchElementException is expected-------------
		// Pop when: (pos == 0 && stack[size - 1] == null)
		// stack.push(1);
		// System.out.println("push: 1 " + stack + " POS: " + stack.getPos());
		// stack.pop();
		// System.out.println("Popped once: " + stack + " POS: " + stack.getPos());
		// stack.pop();

		// -------------Peek test-------------
		// System.out.println("Pushing 15... ");
		// stack.push(15);
		// System.out.println("Peeking stack: " + stack.peek());

		// Is empty, size & getPos test
		// stack.push(15);
		// System.out.println("Contents of the stack: " + stack);
		// System.out.println("\nStack size: " + stack.size() + "\nIs the stack empty: "
		// + stack.isEmpty());
		// System.out.println("Pointer position: " + stack.getPos());
		// System.out.println("Popping once: " + stack.pop());
		// System.out.println("Current stack: \n" + stack + "\nStack size: " +
		// stack.size() + "\nIs the stack empty: "
		// + stack.isEmpty());

	}

}
