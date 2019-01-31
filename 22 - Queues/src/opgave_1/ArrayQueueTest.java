package opgave_1;

public class ArrayQueueTest {

	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		System.out.println("Enqueueing 7 Integers: \n" + queue.toString() + "\n");
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		System.out.println("Dequeueing 3 times: \n" + queue.toString());
		System.out.println("Is the queue empty: " + queue.isEmpty() + "\n");

		System.out.println("Dequeueing 4 times: \n" + queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.toString());
		System.out.println("Is the queue empty: " + queue.isEmpty() + "\n");
		System.out.println("Testing extendQueue - Default size is 10: ");
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		queue.enqueue(11);
		System.out.println(queue.toString() + "Success criteria: 11 Integers in queue");

	}

}
