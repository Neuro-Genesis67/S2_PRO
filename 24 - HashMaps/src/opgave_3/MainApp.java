package opgave_3;

public class MainApp {

	public static void main(String[] args) {
		DictionaryLinked<String, Motorcykel> mcList = new DictionaryLinked<>();
		Motorcykel mc01 = new Motorcykel("AB 42 529", "Suzuki  ", "GS 500 F  ", "Sort/Hvid");
		Motorcykel mc02 = new Motorcykel("OK 85 281", "Suzuki  ", "SV 650    ", "Rød/Sort");
		Motorcykel mc03 = new Motorcykel("JG 88 223", "Suzuki  ", "GSX 650   ", "Pink/White/Green");
		Motorcykel mc04 = new Motorcykel("OA 99 222", "Suzuki  ", "Bandit 650", "Silver/Grey");
		Motorcykel mc05 = new Motorcykel("OS 28 842", "Honda   ", "CBR 500 RA", "Purple");
		Motorcykel mc06 = new Motorcykel("WJ 92 415", "Kawasaki", "Ninja 300 ", "Black/Green");
		Motorcykel mc07 = new Motorcykel("KG 85 525", "Yamaha  ", "YZF-R3    ", "Black/Yellow/Green/orange");
		Motorcykel mc08 = new Motorcykel("KG 85 525", "Yamaha  ", "YZF-R3    ", "DUPLICATE ENTRY UPDATED");
		Motorcykel mc10 = new Motorcykel("IG 52 152", "Honda   ", "CBF 600   ", "Orange");
		Motorcykel mc11 = new Motorcykel("UX 42 847", "Yamaha  ", "MT-07     ", "Yellow/Black");
		Motorcykel mc12 = new Motorcykel("KK 86 100", "Honda   ", "NC 700 SA ", "Pearly white/Matte Black");
		mcList.put("AB 42 529", mc01);
		mcList.put("OK 85 281", mc02);
		mcList.put("JG 88 223", mc03);
		mcList.put("OA 99 222", mc04);
		mcList.put("OS 28 842", mc05);
		mcList.put("KG 85 525", mc07);
		System.out.println("List before adding duplicate key: " + mcList);
		mcList.put("KG 85 525", mc08);
		System.out.println("List after adding duplicate key: " + mcList);
		mcList.remove("KG 85 525");
		System.out.println("List after removing YZF-R3...(6/6)\n" + mcList);
		mcList.remove("OK 85 281");
		System.out.println("List after removing SV 650...(2/5)\n" + mcList);
		mcList.remove("AB 42 529");
		System.out.println("List after removing GS 500 F...(1/4)\n" + mcList);
		mcList.put("AB 42 529", mc01);
		System.out.println("List after re-adding the entry that was just removed: " + mcList);

	}

}
