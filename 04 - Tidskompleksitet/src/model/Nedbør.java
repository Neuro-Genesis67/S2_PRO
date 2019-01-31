package model;

import opgaver.Opgave3;

public class Nedbør extends Opgave3 {
	private int[] nedbørPrUge = { // 52 uger i alt
			20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13, 15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78,
			0, 0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18, 19, 21, 32, 24, 13 };

	/**
	 * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien, hvis
	 * man ønsker den minimale nedbørsmængde i de tre uger
	 */
	public int bedsteTreFerieUger() {

		int previous = Integer.MAX_VALUE;
		int current = 0;
		int weekNumber = 0;

		for (int i = 0; i < nedbørPrUge.length - 2; i++) {
			current = nedbørPrUge[i] + nedbørPrUge[i + 1] + nedbørPrUge[i + 2];

			if (current < previous) {
				previous = current;
				weekNumber = i;
			}

		}
		return weekNumber;

	}

	/**
	 * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien, hvis
	 * man ønsker den minimale nedbørsmængde i det antal uger, der er angivet i
	 * parameteren
	 * 
	 * @param antal
	 *            antal uger man gerne vil holde ferie
	 */
	public int bedsteFerieUgerStart(int antal) {

		int previous = Integer.MAX_VALUE;
		int current = 0;
		int weekNumber = 0;
		int sum = 0;

		for (int i = 0; i < nedbørPrUge.length - antal; i++) {
			for (int j = 0; j < antal; j++) {
				sum += nedbørPrUge[i + j];
			}
			current = sum;
			sum = 0;

			if (current < previous) {
				previous = current;
				weekNumber = i;
			}

		}
		return weekNumber;

	}

	//
	// /**
	// * Returnerer ugenummeret på den første uge hvor nedbøren har været
	// præcis
	// * den samme flest uger i træk
	// */
	public int mestEnsNedbør() {

		// Max value s�ttes, da jeg ikke �nsker at have en variabel som allerede findes
		// i listen. Sandsynligheden her er meget lille.
		int previous = Integer.MAX_VALUE;
		int current = Integer.MAX_VALUE;
		int sum = 0;
		int tempSum = 0;

		for (int i = 1; i < nedbørPrUge.length; i++) {
			previous = nedbørPrUge[i - 1];
			current = nedbørPrUge[i];
			if (previous == current) {
				tempSum++;
			} else if (tempSum > sum) {
				sum = tempSum;
				tempSum = 0;
			}

		}
		return sum; // Not sure if right
	}
}
