package opgave_2;

public interface Deque<T> {

	public void addFirst(T data);

	public void addLast(T data);

	public T removeFirst();

	public T removeLast();

	public T getFirst();

	public T getLast();

	public int size();

	public boolean isEmpty();

	// addFirst(e) Indsætter element e forrest i køen
	// addLast(e) Indsætter element e bagest i køen
	// removeFirst() Fjerner og returnerer elementet forrest i køen
	// removeLast() Fjerner og returnerer elementet bagest i køen
	// getFirst() Returnerer element forrest i køen
	// getLast() Returnerer element bagerst i køen
	// size() Returnerer størrelsen af køen
	// isEmpty() Tester om køen er tom og returnerer true eller false
}
