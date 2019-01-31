package bigJava_17_3_Generic_methods;

import java.util.ArrayList;

public class ArrayUtil {

	public static void main(String[] args) {
		String[] sArr = { "Benny", "Brændte", "Sine", "Bukser", "Åh nej", "Det var ikk så godt" };
		Integer[] iArr = { 1, 2, 3, 4, 6, 5 };

		System.out.println("String array: ");
		print(sArr);
		System.out.println();
		System.out.println("\nInt array: ");
		print(iArr);

	}

	/**
	 * Prints all elements in an array.
	 * 
	 * @param arr
	 *            the array to print
	 */
	public static <T> void print(T[] arr) {
		for (T t : arr) {
			System.out.print(t + " ");
		}
	}

	// public static void print(String[] sArr) {
	// for (String s : sArr) {
	// System.out.println(s + " ");
	// }
	// System.out.println();
	// }

	public static <E> String toString(ArrayList<E> eArrList) {
		String result = "";
		for (E e : eArrList) {
			result += e + " ";
		}
		return result;
	}

	// in order to turn the method into a generic method, replace String with a type
	// variable, say E, to denote the element type of the array. Add a type
	// parameter list, enclosed in angle brackets, between the modifiers (public
	// static) and the return type(void):

	// Isn't this the same as in the top of this class? (I'm a nice person, I don't
	// judge).

	// public static <E> void print(E[] eArr) {
	// for (E e : eArr) {
	// System.out.println(e + " ");
	// }
	// System.out.println();
	// }

}
