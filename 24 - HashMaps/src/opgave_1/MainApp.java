package opgave_1;

import java.util.HashSet;

public class MainApp {

	public static void main(String[] args) {
		HashSet<Motorcykel> MCSet = new HashSet<>();
		Motorcykel mc01 = new Motorcykel("AB 42 529", "Suzuki  ", "GS 500 F  ", "Sort/Hvid");
		Motorcykel mc02 = new Motorcykel("OK 85 281", "Suzuki  ", "SV 650    ", "Rød/Sort");
		Motorcykel mc03 = new Motorcykel("JG 88 223", "Suzuki  ", "GSX 650   ", "Pink/White/Green");
		Motorcykel mc04 = new Motorcykel("OA 99 222", "Suzuki  ", "Bandit 650", "Silver/Grey");
		Motorcykel mc05 = new Motorcykel("OS 28 842", "Honda   ", "CBR 500 RA", "Purple");
		Motorcykel mc06 = new Motorcykel("WJ 92 415", "Kawasaki", "Ninja 300 ", "Black/Green");
		Motorcykel mc07 = new Motorcykel("KG 85 525", "Yamaha  ", "YZF-R3    ", "Black/Yellow/Green/orange");
		Motorcykel mc08 = new Motorcykel("KG 85 525", "Yamaha  ", "YZF-R3    ", "Black/Yellow/Green/orange");
		Motorcykel mc09 = new Motorcykel("KG 85 525", "Yamaha  ", "YZF-R3    ", "Black/Yellow/Green/orange");
		Motorcykel mc10 = new Motorcykel("IG 52 152", "Honda   ", "CBF 600   ", "Orange");
		Motorcykel mc11 = new Motorcykel("UX 42 847", "Yamaha  ", "MT-07     ", "Yellow/Black");
		Motorcykel mc12 = new Motorcykel("KK 86 100", "Honda   ", "NC 700 SA ", "Pearly white/Matte Black");
		MCSet.add(mc01);
		MCSet.add(mc02);
		MCSet.add(mc03);
		MCSet.add(mc04);
		MCSet.add(mc05);
		MCSet.add(mc06);
		MCSet.add(mc07);
		MCSet.add(mc08);
		MCSet.add(mc09);
		MCSet.add(mc10);
		MCSet.add(mc11);
		MCSet.add(mc12);

		System.out.println("Contents of MCSet: \n" + MCSet);
		System.out.println(
				"\nHvad gælder der for de objekter man kan opbevare i et HashSet: \n-De indsættes ikke i nogen bestemt orden.");
		System.out.println(
				"\nHvad sker der, når man indsætter to bil-objekter, der har præcis de samme attributter, i det samme HashSet: \n-Når man indsætter et objekt i sættet, bliver objektets attributter opdateret.");

	}

}
