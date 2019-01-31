package bigJava_17_2_Implementing_generic_types;

public class GenericPairMethod<T, S> {

	private T first;
	private S second;
	// Types^

	public GenericPairMethod(T firstElement, S secondElement) {
		first = firstElement;
		second = secondElement;

	}

	public T getFirst() {
		return this.first;
	}

	public S getSecond() {
		return this.second;
	}

}
