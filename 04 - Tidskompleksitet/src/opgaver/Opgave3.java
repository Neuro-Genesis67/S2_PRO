package opgaver;

public class Opgave3 {

	public static void main(String[] args) {
		Opgave3 c = new Opgave3();

		int[] array = { 5, 10, 5, 6, 4, 9, 8 };
		// result = {5.0, 7.5, 6.667, 6.5, 6.0, 6.5, 6.714}

		for (Double d : c.prefixAverage(array)) {
			System.out.print(d + " - ");

		}

	}

	public static double[] prefixAverage(int[] arr) {

		double sum = 0;
		double[] pfxArr = new double[arr.length];

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i]; // sum = sum + arr[i] (5), (5 + 10), (5 + 10 + 5)
			pfxArr[i] = sum / (i + 1); // +1 for at ramme det rigtige sted i array'et

		}
		return pfxArr;
	}

}
