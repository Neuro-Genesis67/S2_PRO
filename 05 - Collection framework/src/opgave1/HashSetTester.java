package opgave1;

import java.util.HashSet;
import java.util.Set;

public class HashSetTester {

	public static void main(String[] args) {

		// 1
		Set<Integer> hs = new HashSet<>();
		hs.add(1);
		hs.add(2);
		hs.add(3);
		hs.add(4);
		hs.add(5);
		hs.add(6);

		// 2
		// L�g m�rke til at 34 optr�der to gange, et
		// HashSet kan ikke indeholde den samme v�rdi to gange, dette bliver ignoreret
		// af s�ttet.
		hs.add(34);
		hs.add(12);
		hs.add(23);
		hs.add(45);
		hs.add(67);
		hs.add(34);
		hs.add(98);

		// 3
		System.out.println(hs);

		// 4
		hs.add(23); // Her sker der ingenting da hashsettet allerede indeholder 23.

		// 5
		System.out.println(hs);

		// 6
		hs.remove(67); // 67 bliver fjernet successfuldt fra hashsettet

		// 7
		System.out.println(hs);

		// 8
		System.out.println("Does it containt 23? " + hs.contains(23));
		// 9
		System.out.println("HashSet size: " + hs.size());
	}

}
