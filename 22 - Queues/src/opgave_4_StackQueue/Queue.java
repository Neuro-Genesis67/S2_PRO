package opgave_4_StackQueue;

public interface Queue<T> {

	/*
	 * Tests if the queue is empty.
	 */
	public boolean isEmpty();

	/*
	 * Adds an element to the tail of the queue.
	 */
	public void enqueue(T element);

	/*
	 * Removes and returns an element from the front of the queue.
	 */
	public T dequeue();

	/*
	 * Returns the element in the front of the queue without removing it.
	 */
	public T getFront();

	/*
	 * Returns the number of elements in the queue.
	 */
	public int size();
}
