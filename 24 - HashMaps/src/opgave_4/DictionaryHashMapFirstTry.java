package opgave_4;

public class DictionaryHashMapFirstTry<T, V> implements Dictionary {
	// lav til generic

	private java.util.Map<T, V>[] tabel;
	private int N = 10;
	int size;

	/**
	 * HashingMap constructor comment.
	 */
	public DictionaryHashMapFirstTry() {
		tabel = new java.util.HashMap[N];
		for (int i = 0; i < N; i++) {
			tabel[i] = new java.util.HashMap<T, V>();
		}
	}

	@Override
	public V get(Object key) {
		int i = key.hashCode() % N;
		java.util.Map<T, V> map = tabel[i];
		return map.get(key);
	}

	@Override
	public boolean isEmpty() {
		boolean empty = true;
		int i = 0;
		while (empty && i < N) {
			empty = (tabel[i]).isEmpty();
			i++;
		}
		// kunne evt. spørge om size var 0.
		return empty;
	}

	@Override
	public V put(T key, V value) {
		int i = key.hashCode() % N;
		tabel[i].put(key, value);
		V oldvalue = tabel[i];
		if (oldvalue == null) {
			size++;
		}
		return oldvalue;
	}

	@Override
	public Object remove(Object key) {
		// nøjagtigt det samme som put
		return null;
	}

	@Override
	public int size() {
		// TODO
		return 0;
	}

}
