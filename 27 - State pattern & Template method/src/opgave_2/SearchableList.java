package opgave_2;

import java.util.List;

public class SearchableList<E extends Comparable<E>> extends SearchPattern<E> {
	private List<E> list;
	int i = 0;

	public SearchableList(List<E> list) {
		this.list = list;
	}

	@Override
	protected void init() {
		i = 0;
	}

	@Override
	protected boolean isEmpty() {
		if (i > list.size() - 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected E select() {
		return list.get(i);
	}

	@Override
	protected void split(E m) {
		i++;
	}
}
