package bigJava_17_5_Bounds;

public class Pair {

	private Object first;
	private Object second;

	public Pair(Object firstElement, Object secondElement) {
		first = firstElement;
		second = secondElement;

	}

	public Object getFirst() {
		return first;
	}

	public Object getSecond() {
		return second;
	}

	/*
	 * As you can see, the type parameters T and S have been replaced by Object. The
	 * result is an ordinary class. The same process is applied to generic methods.
	 * Consider this method:
	 */

	// public static <E extends Measurable> E min(E[] eArr) {
	// E smallest = eArr[0];
	// for (int i = 1; i < eArr.length; i++) {
	// E obj = eArr[i];
	// if (obj.getMeasure() < smallest.getMeasure()) {
	// smallest = obj;
	// }
	// }
	// return smallest;
	// }
	//
	// /*
	// * When erasing the type parameter, it is replaced with its bound, the
	// * Measurable interface:
	// */
	// public static Measurable min(Measurable[] mArr) {
	//
	// Measurable smallest = mArr[0];
	// for (int i = 1; i < mArr.length; i++) {
	// Measurable obj = mArr[i];
	// if (obj.getMeasure() < smallest.getMeasure()) {
	// smallest = obj;
	// }
	// }
	// return smallest;
	//
	// }

	/*
	 * knowing about type erasure helps you understand the limitations of Java
	 * generics. For example, you cannot construct new objects of a generic type The
	 * following method, which tries to fill an array with copies of default
	 * objects, would be wrong:
	 */
	// public static <E> void fillWithDefaults(E[] a) {
	// for (int i = 0; i < a.length; i++) {
	// a[i] = new E(); // Error (TOM - Of course you can't create something of
	// unknown origin)
	// }
	// }
	//
	// /*
	// * To see why this is a problem, carry out the type erasure process, as if you
	// * were the compiler:
	// */
	//
	// public static void fillWithDefaults(Object[] a) {
	// for (int i = 0; i < a.length; i++) {
	// a[i] = new Object(); // Not useful (Still can't do it lol)
	// }
	// }

}
