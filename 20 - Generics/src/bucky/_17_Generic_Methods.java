package bucky;

public class _17_Generic_Methods {

	public static void main(String[] args) {

		Integer[] intArray = { 1, 2, 3, 4, };
		Character[] CharArray = { 'b', 'u', 'c', 'y' };

		aGenericPrintMethod(intArray);
		aGenericPrintMethod(CharArray);

	}

	public static void aGenericPrintMethod(Integer[] intArray) {
		for (Integer i : intArray) {
			System.out.printf("%s ", i);
		}
		System.out.println();
	}

	public static void aGenericPrintMethod(Character[] CharArray) {
		for (Character c : CharArray) {
			System.out.printf("%s ", c);
		}
		System.out.println();
	}

}
