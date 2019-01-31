package practice;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PolishCalculator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack<Integer> results = new Stack<Integer>();
		boolean done = false;
		ArrayList<Integer> intList = new ArrayList<>();
		ArrayList<Character> charList = new ArrayList<>();

		// _________________________________________________________________________________________
		// Fun: Make a complete string of a regular calculation, and convert it into a
		// polish calculation: 3+5*7 = 35+7* Total = 38

		// System.out.println("Type in your calculation here: ");
		// String s = in.nextLine();
		//
		// for (int i = 0; i < s.length() - 1; i++) {
		// if (s.substring(i, i + 1).matches("[+-*/]")) {
		// System.out.println("Yaaaaay");
		// } else {
		// System.out.println("Boooh");
		// }
		// }
		// _________________________________________________________________________________________
		System.out.println(
				"Type in your full calculation here. \nRemember to write operators after the numbers, so that 3+4*5 becomes 345+*");
		while (!done) {
			String input = in.nextLine();
			if (input.equals("+")) {
				results.push(results.pop() + results.pop());
			} else if (input.equals("-")) {
				results.push(results.pop() - results.pop());
			} else if (input.equals("*") || results.equals("x")) {
				results.push(results.pop() * results.pop());
			} else if (input.equals("/")) {
				results.push(results.pop() / results.pop());
			} else if (input.equals("q") || input.equals("Q")) {
				done = true;
			} else {
				results.push(Integer.parseInt(input));
			}
			System.out.println(results);
		}
	}

}
