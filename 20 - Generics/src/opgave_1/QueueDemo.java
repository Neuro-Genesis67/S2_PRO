package opgave_1;

public class QueueDemo {
	public static void main(String[] args) {
		QueueI q = new CircularArrayQueue();
		q.enqueue("Tom");
		q.enqueue("Diana");
		q.enqueue("Harry");
		q.enqueue("Thomas");
		q.enqueue("Bob");
		q.enqueue("Brian");
		System.out.println("Adding 6 items to the queue...");
		System.out.println("Tom\n" + "Diana\n" + "Harry\n" + "Thomas\n" + "Bob\n" + "Brian");
		System.out.println("Queue size: " + q.size() + "\n");

		System.out.println("First item in the queue: " + q.getFront());
		System.out.println("Is the queue empty: " + q.isEmpty());

		System.out.println("\nNow dequeueing and printing every removed item: ");
		while (!q.isEmpty()) {
			System.out.println(q.dequeue());
		}

		System.out.println("\nIs the queue empty: " + q.isEmpty() + "\nQueue size: " + q.size()
				+ "\nThank you, and have a great day");

	}
}
