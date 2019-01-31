package opgave_2;

public class Test {

	public static void main(String[] args) {
		DoublyLinkedQueue<String> queue = new DoublyLinkedQueue<>();

		queue.addFirst("aF 3");
		queue.addFirst("aF 2");
		queue.addFirst("aF 1");
		System.out.println("addFirst - 3 Strings: \n" + queue.toString() + "\n");

		queue.addLast("aL 22");
		queue.addFirst("aF 21");
		queue.addLast("aL 23");
		queue.addFirst("aF 20");
		System.out.println("addLast + addFirst - 4 strings: \n" + queue.toString() + "\n");

		System.out.println("getFirst: " + queue.getFirst());
		System.out.println("getLast:  " + queue.getLast() + "\n");

		System.out.println("removeFirst: " + queue.removeFirst());
		System.out.println("removeLast: " + queue.removeLast());
		System.out.println("removeFirst: " + queue.removeFirst());
		System.out.println("removeLast: " + queue.removeLast());
		System.out.println(queue + "\n");

		System.out.println("getFirst: " + queue.getFirst());
		System.out.println("getLast:  " + queue.getLast());
		System.out.println("size: " + queue.size());
		System.out.println("is list empty: " + queue.isEmpty());
		System.out.println(queue + "\n");

		System.out.println("removeFirst: " + queue.removeFirst());
		System.out.println("removeFirst: " + queue.removeFirst());
		System.out.println("removeFirst: " + queue.removeFirst());
		System.out.println(queue);
		System.out.println("size: " + queue.size() + "\n");
		System.out.println("removeFirst (NoSuchElementException)");
		queue.removeFirst();

	}

}
