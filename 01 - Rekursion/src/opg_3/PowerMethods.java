package opg_3;

public class PowerMethods {

	public int power(int n, int p) {

		if (p == 1) {
			return n;
		}

		return n * power(n, p - 1);
	}

}
