package opgave_4_StackQueue;

public class MainApp {

	public static void main(String[] args) {
		StackQueue<Integer> s = new StackQueue<>();
		System.out.println(s);
		System.out.println("Size: " + s.size());
		System.out.println("isEmpty: " + s.isEmpty() + "\n");
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		s.push(10);
		s.push(11);
		s.push(12);
		s.push(13);
		s.push(14);
		System.out.println(s);
		System.out.println("Size: " + s.size());
		System.out.println("isEmpty: " + s.isEmpty() + "\n");
		System.out.println("Pop: " + s.pop());
		System.out.println("Pop: " + s.pop());
		System.out.println("Pop: " + s.pop());
		System.out.println("Pop: " + s.pop());
		System.out.println("Pop: " + s.pop());
		System.out.println("Pop: " + s.pop());
		System.out.println("Pop: " + s.pop());
		System.out.println("\n" + s);
		System.out.println("Size: " + s.size());
		System.out.println("Peek: " + s.peek() + "\n");
		System.out.println("Pop: " + s.pop());
		System.out.println("Pop: " + s.pop());

		System.out.println("Pop: " + s.pop());
		System.out.println("Pop: " + s.pop());
		System.out.println("Pop: " + s.pop());
		System.out.println("Pop: " + s.pop());
		System.out.println("Pop: " + s.pop());
		System.out.println(s);
		System.out.println("isEmpty: " + s.isEmpty() + "\n");

	}

}
