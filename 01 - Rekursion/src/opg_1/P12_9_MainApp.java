package opg_1;

public class P12_9_MainApp {

	public static void main(String[] args) {
		P12_9_ArrayMethods am = new P12_9_ArrayMethods();
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] arr2 = { 5, 7, 8, 8, 9, 8, 4, 11, 6, 9 };
		int[] arr3 = { 0, 0, 0, 1, 0, 0, 0 };

		System.out.println("arr1: (45) = " + am.getSumOfList(arr1));
		System.out.println("arr2: (75) = " + am.getSumOfList(arr2));
		System.out.println("arr3:  (1) = " + am.getSumOfList(arr3));

	}

}
