package opgave_3;

import queues.CircularArrayQueue;

public class ThreadQueueDequeue extends Thread {

	boolean done = false;
	int i = 0;
	CircularArrayQueue<Integer> cq = new CircularArrayQueue<>();

	@Override
	public void run() {

		try {

			System.out.println("Enqueueing 12 times: \n");
			while (!done && i < 12) {
				sleep(300);
				cq.enqueue(i + 1);
				System.out.println(cq);
				i++;
			}
			// sleep(2000);
			System.out.println("\nDequeueing 12 times...");
			// sleep(2000);

			while (i >= 0) {
				System.out.println(cq);
				cq.dequeue();
				sleep(300);
				i--;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
