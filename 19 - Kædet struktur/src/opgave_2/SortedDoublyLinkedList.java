package opgave_2;

public class SortedDoublyLinkedList {

	private class Node {
		public String data;
		public Node next;
		public Node previous;
	}

	private Node first;
	private Node last;

	/**
	 * Laver en tom sorteret doubly linked list.
	 */
	public SortedDoublyLinkedList() {
		Node sentinelFirst = new Node();
		Node sentinelLast = new Node();
		sentinelFirst.previous = null;
		sentinelFirst.next = sentinelLast;
		sentinelLast.previous = sentinelFirst;
		sentinelLast.next = null;
		this.first = sentinelFirst;
		this.last = sentinelLast;
	}

	/**
	 * Tilføjer et element til listen, så listen fortsat er sorteret i henhold til
	 * den naturlige ordning på elementerne.
	 * 
	 * @param element
	 *            det der indsættes
	 */
	public void addElement(String element) {
		Node newNode = new Node();
		newNode.data = element;

		if (first.next == last) {
			first.next = newNode;
			last.previous = newNode;
		} else if (newNode.data.compareTo(first.next.data) < 0) {
			newNode.next = first.next;
			first.next = newNode;
			// last.previous = newNode.next;
		} else {
			Node curr = first.next;
			Node prev = curr;
			while (curr.next != null && newNode.data.compareTo(curr.data) >= 0) {
				prev = curr;
				curr = curr.next;
			}
			if (newNode.data.compareTo(curr.data) < 0) {
				prev.next = newNode;
				newNode.previous = prev;
				newNode.next = curr;
				curr.previous = newNode;
			} else {
				curr.next = newNode;
				newNode.previous = curr;
				last.previous = newNode;
			}
		}

	}

	/**
	 * Fjerner et element fra listen.
	 * 
	 * @param element
	 *            det element der fjernes
	 * @return true hvis elementet blev fjernet, men ellers false.
	 */
	public boolean removeElement(String element) { // Not working
		boolean found = false;
		if (first.next == last) {
			found = false;
		} else {

			Node curr = first;
			Node prev = curr;

			while (!found && curr.next != null) {
				prev = curr;
				curr = first.next;

				if (curr.data.equals(element)) {
					prev.next = curr.next;
					curr.previous = prev; // Sure this works?
					found = true;
				}
			}
		}
		return found;

	}

	public String removeFirst() { // Might not work right
		String result = "";

		if (first.next == last) {
			result += "List is empty, nothing to remove.";
			// System.out.println("1");
		} else if (first.next == last.previous) {
			result += first.next.data;
			first.next = last;
			last.previous = first;
			// System.out.println("2");
		} else {
			result = first.next.data;
			first.next = first.next.next;
			// System.out.println("3");
		}
		return result;
	}

	public String removeLast() { // Doesn't work right
		String result = "";

		// Hvis listen er tom
		if (first.next == last) {
			result += "List is empty, nothing to remove.";
			// System.out.println("1");
		}
		// Hvis der kun er en i listen
		else if (first.next == last.previous) {
			result += first.next.data;
			first.next = last;
			last.previous = first;
			// System.out.println("2");
		}
		// Hvis der er flere end 1 i listen.
		else {
			result += last.previous.data;
			last.previous = last.previous.previous;
			last.previous.previous.next = null;
			// System.out.println("3");
		}
		return result;
	}

	public int countElements() {
		Node curr = first.next;
		int count = 1;
		if (first.next == last) {
			count = 0;
		}
		while (curr.next != null) {
			curr = curr.next;
			count++;
		}
		return count;

	}

	@Override
	public String toString() { // probably works, but might not
		Boolean done = false;

		String result = "";
		if (first.next == last) {
			result = "Nothing in list";

		} else {

			Node curr = first.next;
			System.out.println("hejsa");
			System.out.println(curr == null);
			if (curr.next == null) {

				while (!done) { // Når Curr.next kaldes, så er curr.next allerede null, og kaldet resulterer i
								// en null pointer exception
					result += "[ " + curr.data + " ] - ";
					curr = curr.next;
					System.out.println("Am i stuck?");
				}
			}

			System.out.println("hej");

			System.out.println(curr == null);
			result += "[ " + curr.data + " ]";

		}
		return result;
	}
}