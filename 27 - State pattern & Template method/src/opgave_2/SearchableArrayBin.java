package opgave_2;

public class SearchableArrayBin<E extends Comparable<E>> extends SearchPattern<E> {

	E[] list;
	int left;
	int middle;
	int right;
	int i;

	public SearchableArrayBin(E[] list) {
		this.list = list;
	}

	@Override
	protected void init() {
		left = 0;
		middle = -1;
		right = list.length - 1;
		i = 0;
	}

	@Override
	protected boolean isEmpty() {
		if (i > list.length - 1) {
			return true;
		}
		return false;
	}

	@Override
	protected E select() {
		return list[i];
	}

	@Override
	protected void split(E m) {
		if (select().compareTo(m) > 0) {
			right = middle - 1;
		} else {
			left = middle + 1;
		}

	}

}
