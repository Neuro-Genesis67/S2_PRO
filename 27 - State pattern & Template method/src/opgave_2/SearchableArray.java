package opgave_2;

public class SearchableArray<E extends Comparable<E>> extends SearchPattern<E> {

	private E[] list;
	int i = 0;

	public SearchableArray(E[] list) {
		this.list = list;
	}

	@Override
	protected void init() {
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
		i++;

	}

}
