package opgave_1;

public class LinkedQueueTest {

	public static void main(String[] args) {
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		System.out.println("Enqueueing 7 Integers: \n" + queue.toString());
		System.out.println("First item in list: " + queue.getFront() + "\n");
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		System.out.println("Dequeueing 3 times: \n" + queue.toString());
		System.out.println("First item in list: " + queue.getFront());
		System.out.println("Is the queue empty: " + queue.isEmpty() + "\n");

		System.out.println("Dequeueing 4 times: ");
		System.out.println(queue.dequeue() + " was dequeued.");
		System.out.println(queue.dequeue() + " was dequeued.");
		System.out.println(queue.dequeue() + " was dequeued.");
		System.out.println(queue.dequeue() + " was dequeued.");
		System.out.println(queue.toString());

	}

}
