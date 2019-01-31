package opg_1;

public class P12_8_MainApp {

	public static void main(String[] args) {

		P12_8_ArrayMethods am = new P12_8_ArrayMethods();
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] arr2 = { 2, 1, 4, 3, 6, 5, 8, 7, 9 };
		int[] arr3 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		System.out.println("arr1: " + am.getLargestInArray(arr1));
		System.out.println("arr2: " + am.getLargestInArray(arr2));
		System.out.println("arr3: " + am.getLargestInArray(arr3));
		System.out.println("Listerne indeholder det samme i forskellige rækkefølger for at teste metoden for fejl");
	}

}
