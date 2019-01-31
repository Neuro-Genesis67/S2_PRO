package opgave_2;

public class RemoveTests {

	public static void main(String[] args) {
		HashSetChaining names = new HashSetChaining(13);
		names.add("Harry");
		names.add("Sue");
		names.add("Nina");
		names.add("Susannah");
		names.add("Larry");
		names.add("Eve");
		names.add("Sarah");
		names.add("Adam");
		names.add("Tony");
		names.add("Katherine");
		names.add("Juliet");
		names.add("Romeo");
		System.out.println(names);

		// Test removing 1/3:
		// System.out.println("Contains Romeo: " + names.contains("Romeo"));
		// System.out.println("Removing Romeo: " + names.remove("Romeo"));
		// System.out.println("Contains Romeo: " + names.contains("Romeo") + "\n");
		// System.out.println(names);

		// Test removing 2/3:
		// System.out.println("Contains Sarah: " + names.contains("Sarah"));
		// System.out.println("Removing Sarah: " + names.remove("Sarah"));
		// System.out.println("Contains Sarah: " + names.contains("Sarah") + "\n");
		// System.out.println(names);

		// Test removing 3/3
		// System.out.println("Contains Harry: " + names.contains("Harry"));
		// System.out.println("Removing Harry: " + names.remove("Harry"));
		// System.out.println("Contains Harry: " + names.contains("Harry") + "\n");
		// System.out.println(names);

		// Test removing 1/1:
		// System.out.println("Contains Juliet: " + names.contains("Juliet"));
		// System.out.println("Removing Juliet: " + names.remove("Juliet"));
		// System.out.println("Contains Juliet: " + names.contains("Juliet") + "\n");
		// System.out.println(names);

		// Test removing 1/0:
		// System.out.println("Contains Mel gibson: " + names.contains("Mel gibson"));
		// System.out.println("Removing Mel gibson: " + names.remove("Mel gibson"));
		// System.out.println("Contains Mel gibson: " + names.contains("Mel gibson") +
		// "\n");
		// System.out.println(names);
	}

}
