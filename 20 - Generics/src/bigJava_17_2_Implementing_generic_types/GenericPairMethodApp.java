package bigJava_17_2_Implementing_generic_types;

public class GenericPairMethodApp {

	public static void main(String[] args) {
		String[] names = { "Tom", "Diana", "Harry" };
		GenericPairMethod<String, Integer> result = firstContaining(names, "a");
		System.out.println("First in the list: " + result.getFirst());
		System.out.println("Expected: Diana");
		System.out.println("Index of result: " + result.getSecond());
		System.out.println("Expected: 1");
	}

	// Sets the first in the list, to the entity in the list, that contains the
	// letter "a".
	public static GenericPairMethod<String, Integer> firstContaining(String[] sArr, String string) {
		for (int i = 0; i < sArr.length; i++) {
			if (sArr[i].contains(string)) {
				return new GenericPairMethod<String, Integer>(sArr[i], i);
			}
		}
		return new GenericPairMethod<String, Integer>(null, -1);
	}

}
