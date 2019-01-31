package notes;

import java.util.Arrays;

public class TomHashFunctions {

	String[] arr;

	public static void main(String[] args) {
		TomHashFunctions hashFunctions = new TomHashFunctions(30);

		String[] simpleElements = { "1", "3", "5", "6", "15", "17", "18", "20", "28", "21", "24", "9", "12" };

		hashFunctions.simpleInsert(simpleElements, hashFunctions.arr);
		System.out.println(hashFunctions);

		// HashFunctions advancedObject = new HashFunctions(30);
		// String[] advancedElements = { "231", "582", "185", "172", "11", "14", "1",
		// "2", "4", "62", "162", "827", "72" };
		//
		// advancedObject.advancedInsert(advancedObject.arr, advancedElements);
	}

	TomHashFunctions(int arrSize) {
		arr = new String[arrSize];
		Arrays.fill(arr, "-1");
	}

	public void simpleInsert(String[] newElements, String[] arr) {

		for (int n = 0; n < newElements.length; n++) {
			String element = newElements[n];
			arr[Integer.parseInt(element)] = element;
		}

	}

	// public void advancedInsert(String[] arr, String[] newElements) {
	//
	// }
	@Override
	public String toString() {

		String result = "";
		result = "\n-------------------------------------------------------------------------------------------------------------------------\n";
		for (int n = 0; n < this.arr.length; n++) {
			// if (this.arr[n] == "-1") {
			// result += "| _ ";
			// } else {
			result += "| " + this.arr[n] + " ";
			// }
		}
		result = "\n-------------------------------------------------------------------------------------------------------------------------\n";

		return result;
	}

}
