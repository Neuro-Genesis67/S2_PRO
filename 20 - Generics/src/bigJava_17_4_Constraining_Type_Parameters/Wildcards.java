package bigJava_17_4_Constraining_Type_Parameters;

import java.util.ArrayList;
import java.util.List;

public class Wildcards {

	public static void main(String[] args) {

		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(3);
		intList.add(2);
		intList.add(5);
		intList.add(3);
		intList.add(6);

		List<String> stringList = new ArrayList<>();
		stringList.add("Start");
		stringList.add("Den der kommer efter start");
		stringList.add("Så kommer den her");
		stringList.add("Så så man lige mig");
		stringList.add("Det går sku da strygende");
		stringList.add("Hooold for satan.");

		WildcardMotorcycle mc1 = new WildcardMotorcycle("Honda CBS 500 RA", 300, "Beginner");
		WildcardMotorcycle mc2 = new WildcardMotorcycle("Suzuki something", 500, "Intermediate");
		WildcardMotorcycle mc3 = new WildcardMotorcycle("Kawazaki coolColor", 1000, "Expert");

		List<WildcardMotorcycle> mcList = new ArrayList<>();
		mcList.add(mc1);
		mcList.add(mc2);
		mcList.add(mc3);

		printList(intList);
		printList(stringList);
		printList(mcList);

	}

	public static void printList(List<?> list) {

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();

	}

}
