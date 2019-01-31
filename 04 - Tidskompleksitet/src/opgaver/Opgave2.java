package opgaver;

public class Opgave2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Hvad er størrelsesordenen af tidskompleksiteten for nedenstående metode?
	public int method1(int n) {
		int result = 0;
		for (int i = 0; i < n; i++) { // O(2n) aka. O(n) - den er lineær
			for (int j = 1; j < n; j = j * 2) { // O(1) - Den tager stort set altid lige lang tid, uafhængigt af hvad n
												// er. (j = j * 2) - exponentiel iteration
				result++;
			}
		}
		return result;
	}
	// O(n)
}
