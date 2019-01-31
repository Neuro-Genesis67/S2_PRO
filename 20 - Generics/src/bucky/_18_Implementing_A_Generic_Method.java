package bucky;

public class _18_Implementing_A_Generic_Method {

	public static void main(String[] args) {

		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Character[] CharArray = { 'b', 'u', 'c', 'k', 'y' };

		aGenericPrintMethod(intArray);
		aGenericPrintMethod(CharArray);

	}

	public static <T> void aGenericPrintMethod(T[] gArray) {
		for (T t : gArray) {
			System.out.printf("%s ", t);
		}
		System.out.println();
	}

}
