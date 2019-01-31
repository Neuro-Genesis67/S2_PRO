package opgave_3;

public class MainApp {

	public static void main(String[] args) {
		HashSetLinearProbing hp = new HashSetLinearProbing(10);
		hp.add(14);
		hp.add(22);
		hp.add(95);
		hp.add(10);
		hp.add(46);
		hp.add(5);
		hp.add(61);
		hp.add(7);
		hp.add(8);
		hp.add(3);
		System.out.println("Adding 10 ints to set...\n" + hp);
		System.out.println("Contains 3: " + hp.contains(3));
		System.out.println("Contains 46: " + hp.contains(46));
		hp.remove(3);
		hp.remove(10);
		hp.remove(61);
		hp.remove(8);
		hp.remove(5);
		System.out.println("\nRemoving 5 ints from set...\n" + hp);
		System.out.println("Contains 3: " + hp.contains(3));
		System.out.println("Contains 46: " + hp.contains(46));
	}

}
