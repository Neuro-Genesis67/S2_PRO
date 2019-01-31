package opg_1;

public class P12_8_ArrayMethods {

	public int getLargestInArray(int[] arr) {

		return getLargestInArrayHelper(arr, 0);
	}

	public int getLargestInArrayHelper(int[] arr, int i) {

		if (i == arr.length - 1) {
			return arr[i];
		}

		return Integer.max(getLargestInArrayHelper(arr, i + 1), arr[i]);
	}

}
