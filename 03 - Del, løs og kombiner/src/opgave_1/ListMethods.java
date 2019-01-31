package opgave_1;

import java.util.ArrayList;

public class ListMethods {

	public int sumOfList(ArrayList<Integer> list) {
		return sumOfListHelper(list, 0, list.size() - 1);
	}

	private int sumOfListHelper(ArrayList<Integer> list, int start, int end) {
		if (start == end) {
			return list.get(start);

		} else {
			int middle = (start + end) / 2;
			int part1 = sumOfListHelper(list, start, middle); // 0 - 2
			int part2 = sumOfListHelper(list, middle + 1, end); // 3 - 5

			if (part1 > part2) {
				return part1;
			} else {
				return part2;
			}
		}
	}
}

// 0 - 5
