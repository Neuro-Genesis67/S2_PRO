package opgave_2;

public class MainApp {

	public static void main(String[] args) {
		MainApp ct = new MainApp();
		ct.testChaining();
		// ct.testLinear();
	}

	private void testLinear() {
		HashSetLinearProbing hp = new HashSetLinearProbing(5);
		hp.add(5);
		hp.add(12);
		hp.add(19);
		hp.add(26);
		System.out.println("After inserting 4 ints: \n" + "Size: " + hp.getSize() + "\n" + hp + "\n");
		hp.add(35);
		hp.add(36);
		hp.add(37);
		System.out.println("After inserting 3 more ints: \n" + "Size: " + hp.getSize() + "\n" + hp + "\n");
		hp.add(33);
		hp.add(34);
		hp.add(42);
		hp.add(43);
		hp.add(44);
		hp.add(45);
		hp.add(38);
		System.out.println("After inserting 7 more ints: \n" + "Size: " + hp.getSize() + "\n" + hp + "\n");
		hp.remove(5);
		hp.remove(12);
		System.out.println("After removing 2 more ints: \n" + "Size: " + hp.getSize() + "\n" + hp + "\n");

	}

	private void testChaining() {
		HashSetChaining hc = new HashSetChaining(5);
		hc.add(5);
		hc.add(12);
		hc.add(19);
		hc.add(26);
		System.out.println("After inserting 4 ints: \n" + "Size: " + hc.getSize() + "\n" + hc);
		hc.add(35);
		hc.add(36);
		hc.add(37);
		System.out.println("After inserting 3 more ints: \n" + "Size: " + hc.getSize() + "\n" + hc);
		hc.add(33);
		hc.add(34);
		hc.add(42);
		hc.add(43);
		hc.add(44);
		hc.add(45);
		hc.add(38);
		System.out.println("After inserting 7 more ints: \n" + "Size: " + hc.getSize() + "\n" + hc);
		hc.remove(5);
		hc.remove(12);
		System.out.println("After removing 2 more ints: \n" + "Size: " + hc.getSize() + "\n" + hc);
	}
}
