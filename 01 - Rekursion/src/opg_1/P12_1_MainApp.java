package opg_1;

public class P12_1_MainApp {

	public static void main(String[] args) {

		P12_1_Rectangle r1 = new P12_1_Rectangle(15, 3);
		P12_1_Rectangle r2 = new P12_1_Rectangle(12, 2);
		P12_1_Rectangle r3 = new P12_1_Rectangle(1, 3);
		P12_1_Rectangle r4 = new P12_1_Rectangle(1, 1);
		P12_1_Rectangle r5 = new P12_1_Rectangle(0, 3);
		P12_1_Rectangle r6 = new P12_1_Rectangle(-2, 3);
		System.out.println("Expected 45: " + r1.getArea());
		System.out.println("Expected 24: " + r2.getArea());
		System.out.println("Expected 3: " + r3.getArea());
		System.out.println("Expected 1: " + r4.getArea());
		System.out.println("Expected 0: " + r5.getArea());
		System.out.println("Expected 0: " + r6.getArea());
	}

}
