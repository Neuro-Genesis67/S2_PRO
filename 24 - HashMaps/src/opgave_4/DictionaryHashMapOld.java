package opgave_4;

public class DictionaryHashMapOld<K, V> implements Dictionary<K, V> {

	private java.util.Map<K, V>[] arr;
	private int N = 10;
	private int itemsInList = 0;

	/**
	 * HashingMap constructor comment.
	 */
	@SuppressWarnings("unchecked")
	public DictionaryHashMapOld() {
		arr = new java.util.HashMap[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new java.util.HashMap<K, V>();
		}
	}

	@Override
	public V get(K key) {
		int i = key.hashCode() % N;
		java.util.Map<K, V> map = arr[i];
		return map.get(key);
	}

	@Override
	public boolean isEmpty() {
		boolean empty = true;
		int i = 0;
		while (empty && i < N) {
			empty = (arr[i]).isEmpty();
			i++;
		}
		return empty;
	}

	@Override
	public V put(K key, V value) {
		int i = key.hashCode() % N;
		java.util.Map<K, V> map = arr[i];
		if (map == null) {
		}

		return null;
	}

	@Override
	public V remove(K key) {
		// TODO
		return null;
	}

	@Override
	public int size() {
		return itemsInList;
	}

}
