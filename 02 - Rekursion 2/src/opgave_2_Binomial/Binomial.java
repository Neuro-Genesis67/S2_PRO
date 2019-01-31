package opgave_2_Binomial;

public class Binomial {

	public static void main(String[] args) {
		Binomial b = new Binomial();
		System.out.println(b.binomial(3, 20));

	}

	public int binomial(int m, int n) {

		if (m == 0 || m == n) {
			return 1;
		}

		return binomial(m, n - 1) + binomial(m - 1, n - 1);

	}

}

// Hvis man skal købe en pizza med tre forskellige slags "fyld", og der er 20
// forskellige slags "fyld" at vælge imellem, kan man vælge 1140 forskellige
// pizzaer.
