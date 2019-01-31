package bigJava_17_4_Constraining_Type_Parameters;

import java.util.ArrayList;

public class Constraining_Type_Parameters {

	/*
	 * We can constrain the type of the elements, requiring that the type implement
	 * the Measurable type. In Java, this is achieved by adding the clause
	 * "extends Measurable" after the type parameter: (Line 12)
	 */
	public static <E extends Measurable> double average(ArrayList<E> objects) {

		if (objects.size() == 0) {
			return 0;
		}
		double sum = 0;
		for (E obj : objects) {
			sum += obj.getMeasure();
		}
		return sum / objects.size();
	}

	/*
	 * Note the call obj.getMeasure(). The variable obj has type E, and E is a
	 * subntype of Measurable. Therefore, we know that it is legal to apply the
	 * getMeasure method to obj.
	 */

	/*
	 * For example, String inmplements Comparable<String>. You can compare strings
	 * with other strings, but not iwth objects of different classes. If the
	 * arrayList has elemnts of type E, then we want to require the E implements
	 * Comparable<E>. Here's the method:
	 */

	// Oh, and btw. "E" could be anything, but we like to use good form.
	public static <E extends Comparable<E>> E min(ArrayList<E> objects) {

		E smallest = objects.get(0);
		for (int i = 1; i < objects.size(); i++) {
			E obj = objects.get(i);
			if (obj.compareTo(smallest) < 0) {
				smallest = obj;
			}
		}
		return smallest;

	}

}
