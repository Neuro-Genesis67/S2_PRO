package opgave_2;

public class MainApp {

	public static void main(String[] args) {

		Food f1 = new Food(" Sweet potato");
		Food f2 = new Food(" Roasted porcupine babies penetrated with a wooden stick for easier handling");
		Food f3 = new Food(" Mc'Donalds");
		Food f4 = new Food(" White rice and bread");
		SexPosition s1 = new SexPosition("69");
		SexPosition s2 = new SexPosition("Reverse cowgirl");
		SexPosition s3 = new SexPosition("Brute");
		SexPosition s4 = new SexPosition("X marks the spot");

		GenericDictionary<Integer, Food> foodtionary = new GenericDictionary<>();
		foodtionary.put(1, f1);
		foodtionary.put(2, f2);
		foodtionary.put(3, f3);
		foodtionary.put(4, f4);

		System.out.println("Contents of food dictionary: \n" + foodtionary.toString() + "\n\n");
		System.out.println("Items in dictionary: " + foodtionary.size() + "\n\n");
		System.out.println("Removing item 2 (It was too harsh): " + foodtionary.remove(2));
		System.out.println("Items in dictionary: " + foodtionary.size() + "\n\n");
		System.out.println("Is the catalog empty?: " + foodtionary.isEmpty() + "\n\n");
		System.out.println("Removing the rest of the items: " + foodtionary.remove(1) + "," + foodtionary.remove(3)
				+ "," + foodtionary.remove(4) + "\n\n");
		System.out.println("Getting index 3: " + foodtionary.get(3));

		System.out.println("Items in dictionary: " + foodtionary.size() + "\n\n");
		System.out.println("Is the catalog empty?: " + foodtionary.isEmpty());

		GenericDictionary<Integer, SexPosition> sextionary = new GenericDictionary<>();
		sextionary.put(1, s1);
		sextionary.put(2, s2);
		sextionary.put(3, s3);
		sextionary.put(4, s4);
		System.out.println("Contents of sex dictionary: \n" + sextionary.toString() + "\n\n");

	}

}
