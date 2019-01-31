package opgave_1;

public class SortedLinkedList {

	private Node first;

	class Node {
		private String data;
		private Node next;

		public Node(String data) {
			this.data = data;
		}
	}

	public SortedLinkedList() {
		first = null;
	}

	/**
	 * Tilføjer et element til listen, så listen fortsat er sorteret i henhold til
	 * den naturlige ordning på elementerne.
	 * 
	 * @param data
	 *            det der indsættes
	 */
	public void addElement(String data) {
		Node newNode = new Node(data);
		newNode.next = null; // is this necessary?
		if (first == null) {
			first = newNode;
		} else if (newNode.data.compareTo(first.data) < 0) {
			newNode.next = first;
			first = newNode;
		} else {
			Node prevNode = first; // Anders
			Node nextNode = first.next; // Bjarne
			boolean done = false;
			while (newNode.data.compareTo(nextNode.data) > 0) {
				if (nextNode.next == null) {
					nextNode.next = newNode;
					done = true;
				} else {
					prevNode = nextNode;
					nextNode = nextNode.next;
				}
			}
			if (!done) {
				newNode.next = nextNode;
				prevNode.next = newNode;
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
	public boolean removeElement(String element) {

		Boolean found = false;
		boolean end = false;
		Node curr = first;
		Node prev = curr;
		while (!found && !end) {

			if (first.data == element) {
				first = first.next;
				found = true;
			}

			while (curr.next != null && curr.data != element) {
				prev = curr;
				curr = curr.next;

			}
			if (curr.data == element) {
				prev.next = curr.next;
				found = true;
			} else {
				found = false;
				end = true;
			}

		}
		return found;
	}

	/**
	 * Returnerer antallet af elementer i listen.
	 */
	public int countElements() {
		Node current = first;
		int count = 1;
		if (first == null) {
			count = 0;
		}
		while (current.next != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	@Override
	public String toString() {
		String result = "";
		Node current = first;
		while (current.next != null) {
			result += "[ " + current.data + " ] - ";
			current = current.next;
		}
		result += "[ " + current.data + " ]";
		return result;
	}
}
