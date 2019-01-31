package opg_3;

public class MainApp {

	public static void main(String[] args) {
		PowerMethods pm = new PowerMethods();

		System.out.println(pm.power(5, 4));
		System.out.println(pm.power(1, 1));
		System.out.println(pm.power(0, 1));

	}

	// public int power(int n, int p) {
	//
	// if (p == 0) { //Er der et matematisk problem her?
	// return
	// }
	// if (p == 1) {
	// return n;
	// }
	// }

}
