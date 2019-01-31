package bucky;

public class _19_Generic_Return_Types_ {

	public static void main(String[] args) {

		System.out.println(maxOfThreeThings(5, 1, 8));
		System.out.println(maxOfThreeThings("Benzin", "Asparges", "Xylofonkongen"));
		System.out.println(maxOfThreeThings(5.2, 17.7, 17.6));

	}

	public static <T extends Comparable<T>> T maxOfThreeThings(T a, T b, T c) {
		T generic = a;

		if (b.compareTo(a) > 0) {
			generic = b;
		}

		if (c.compareTo(generic) > 0) {
			generic = c;
		}
		return generic;
	}

}

// <T extends Comparable<T>>
// This means: Anything that utilizes the comparable interface.
// It means that whatever you put into the method,
// has to use comparable, otherwise it won't work.
// T is the "Generic object".
// The T that stands alone, is the return type of the method:
// public static <T extends Comparable<T>> T maxOfThreeThings(T a, T b, T c) {
// ^

// https://www.youtube.com/watch?v=QB5pQT45zvg