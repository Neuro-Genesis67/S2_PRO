package opgave_2; //Jonas har brugt contains og remove

/**
 * This class implements a hash set using an array and linear probing to handle
 * collisions.
 */
public class HashSetLinearProbing {
	private Object[] arr;
	private int itemsInList;

	/**
	 * Constructs a hash table.
	 * 
	 * @param bucketsLength
	 *            the length of the buckets array
	 */
	public HashSetLinearProbing(int size) {
		arr = new Object[size];
		itemsInList = 0;
	}

	/**
	 * Tests for set membership.
	 * 
	 * @param obj
	 *            an object
	 * @return true if x is an element of this set
	 */
	public boolean contains(Object obj) { // Untested
		int pos = hashValue(obj);

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[pos] != null && arr[pos].equals(obj)) {
				return true;
			}
			pos = (pos + 1) % arr.length;
		}

		return false;
	}

	/**
	 * Adds an element to this set.
	 * 
	 * @param obj
	 *            an object
	 * @return true if obj is a new object, false if obj was already in the set
	 */
	public boolean add(Object obj) {

		if ((double) itemsInList / arr.length > 0.75) {
			rehash();
		}

		int pos = hashValue(obj);

		if (this.contains(obj)) {
			return false;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[pos] == null) {
				arr[pos] = obj;
				itemsInList++;
				return true;
			}
			pos = (pos + 1) % arr.length;
		}

		return false;
	}

	private void rehash() {

		Object[] oldArr = arr;
		arr = new Object[arr.length * 2];
		itemsInList = 0;

		for (int i = 0; i < oldArr.length; i++) {
			Object o = oldArr[i];
			if (o != null) {
				this.add(o);
			}
		}

	}

	/**
	 * Removes an object from this set.
	 * 
	 * @param x
	 *            an object
	 * @return true if x was removed from this set, false if x was not an element of
	 *         this set
	 */
	public boolean remove(Object obj) {
		int pos = hashValue(obj);

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[pos].equals(obj)) {
				arr[pos] = null;
				return true;
			}
			pos = (pos + 1) % arr.length;
		}

		return false;
	}

	/**
	 * Gets the number of elements in this set.
	 * 
	 * @return the number of elements
	 */
	public int getNumberOfItems() {
		return itemsInList;
	}

	private int hashValue(Object obj) {
		int h = obj.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % arr.length;
		return h;
	}

	public int getSize() {
		return arr.length;
	}

	@Override
	public String toString() {
		String result = "[ ";
		for (Object o : arr) {
			if (o != null) {
				result += o + " ";
			}
		}
		return result + "]";

	}

}
