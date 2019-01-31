package opgaver;

//Skriv en rekursiv metode, der tæller antallet af elementer med værdien 0 i en List<Integer>
//objekter. Anvend del, løs og kombiner skabelonen.

import java.util.ArrayList;

public class opg2 {

	public static void main(String[] args) {
		opg2 c = new opg2();
		ArrayList<Integer> list = new ArrayList<>();
		c.addListInts(list);

	}

	private void addListInts(ArrayList<Integer> list) {
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(0);
		list.add(1);
		list.add(8);
		list.add(1);
		list.add(43);
		list.add(0);
		list.add(81);
		list.add(1);
		list.add(0);
		list.add(0);
		list.add(24);
		list.add(1);
		list.add(4);
		list.add(0);
		list.add(2);
		list.add(0);
		list.add(5);
	}

}

// public int ZeroesInArrayList (ArrayList<Integer> list, int start, int end) {
// int countZeroes = 0;
//
// if (list.get(index) == 0) {
// return 0;
// } else {
// int middle = (start + end) / 2;
// int sum1 = ZeroesInArrayList(list, start, middle);
// int sum2 = ZeroesInArrayList(list, middle +1, end);
// }
// if (sum1 == 0) {
// countZeroes++;
// } if (sum2)
//

// Samme som opg. 1 ca.
// }
