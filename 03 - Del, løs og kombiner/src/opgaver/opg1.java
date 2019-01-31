package opgaver;

import java.util.ArrayList;

public class opg1 {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(8);
		list.add(10);
		list.add(2);
		list.add(10);
		list.add(20);
		list.add(25);
		list.add(15);
		// 100 total
		int sum = sumOfList(list);
		System.out.println(sum);

	}

	public static int sumOfList(ArrayList<Integer> list) {
		return sumOfListHelper(list, 0, list.size() - 1);
	}

	private static int sumOfListHelper(ArrayList<Integer> list, int start, int end) {
		if (start == end) {
			return list.get(start);

		} else {
			int middle = (start + end) / 2;
			int part1 = sumOfListHelper(list, start, middle);
			int part2 = sumOfListHelper(list, middle + 1, end);

			if (part1 > part2) {
				return part1;
			} else {
				return part2;
			}
		}
	}

	// opg1 c = new opg1();
	// ArrayList<Integer> list = new ArrayList<>();
	// c.addListInts(list);
	//
	// System.out.println(c.sumOfIntArrayList(list, 0, list.size() - 1));
	//
	// // System.out.println(list.size());
	// }
	//
	// public int sumOfIntArrayList(ArrayList<Integer> list, int start, int end) {
	//
	// if (start == end) {
	// return list.get(start);
	// } else {
	// // Split the list into two lists:
	// int middle = (start + end) / 2;
	// int max1 = sumOfIntArrayList(list, start, middle);
	// int max2 = sumOfIntArrayList(list, middle + 1, end);
	//
	// // finding the biggest value of the selected regions in the ArrayList<>()
	// if (max1 > max2) {
	// return max1;
	// } else {
	// return max2;
	// }
	// }
	// // Return sum1 + sum2;
	//
	// }
	//
	// private void addListInts(ArrayList<Integer> list) {
	// list.add(5);
	// list.add(1);
	// list.add(2);
	// list.add(0);
	// list.add(1);
	// list.add(8);
	// list.add(1);
	// list.add(43);
	// list.add(0);
	// list.add(81);
	// list.add(1);
	// list.add(0);
	// list.add(0);
	// list.add(24);
	// list.add(1);
	// list.add(4);
	// list.add(0);
	// list.add(2);
	// list.add(0);
	// list.add(5);
	// }

}
