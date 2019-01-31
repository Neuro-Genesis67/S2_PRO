package practice;

import java.util.HashMap;
import java.util.TreeMap;

public class Practice {

	public static void main(String[] args) {
		TreeMap<Integer, String> tree = new TreeMap<>();
		HashMap<Integer, String> hash = new HashMap<>();

		tree.put(4, "Guess he was immortalized");
		tree.put(1, "Monkey apeman");
		tree.put(1, "Abe Lincler");
		tree.put(7, "7 is the string this time, why?, because it's a nice sequence");
		tree.put(25, "asd");
		tree.put(35, "dsa");
		tree.put(45, "Xavier");

		hash.put(4, "Guess he was immortalized");
		hash.put(1, "Abe Lincoln");
		hash.put(1, "Monkey apeman");
		hash.put(7, "7 is the string this time, why?, because it's a nice sequence");

		for (Integer key : tree.keySet()) {
			System.out.println("Key: " + key);
			System.out.println("Value: " + tree.get(key) + "");
		}
		System.out.println(
				"\nHere we see that a TreeMap is automatically sorted \nAlso when you use the put method, it overrides what's already in that key location\n");

		for (Integer key : hash.keySet()) {
			System.out.println("Key: " + key);
			System.out.println("Value: " + hash.get(key) + "");
		}
		System.out.println(
				"\nHere we see that a HashMap is automatically sorted \nAlso when you use the put method, it overrides what's already in that key location\n");

		System.out.println("LowerKey 25: " + tree.lowerKey(25));
		System.out.println("HigherKey 25: " + tree.higherKey(25));
		System.out.println("FloorKey 25: " + tree.floorKey(25));
		System.out.println("CeilingKey 25: " + tree.ceilingKey(25));
		System.out.println("FloorKey 26: " + tree.floorKey(26));
		System.out.println("CeilingKey 26: " + tree.ceilingKey(26));
		System.out.println("FloorKey 24: " + tree.floorKey(24));
		System.out.println("CeilingKey 24: " + tree.ceilingKey(24));

	}

}
