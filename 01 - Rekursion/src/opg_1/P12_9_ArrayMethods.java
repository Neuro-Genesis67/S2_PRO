package opg_1;

public class P12_9_ArrayMethods {

	public int getSumOfList(int[] arr) {

		return getSumOfListHelper(arr, 0);
	}

	public int getSumOfListHelper(int[] arr, int i) {

		if (i == arr.length - 1) {
			return arr[i];
		}

		return arr[i] + getSumOfListHelper(arr, i + 1);
	}

}
