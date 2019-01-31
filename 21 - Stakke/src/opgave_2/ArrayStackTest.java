package opgave_2;

import opgave_1.ArrayStack;

public class ArrayStackTest {

	public static void main(String[] args) {
		// Opgave 2
		/*
		 * Lav en metode der anvender din ArrayStack fra forrige opgave til at afgøre,
		 * om en String indeholder parenteser, der passer sammen. De parenteser der kan
		 * genkendes, er følgende: (), {}, []. Gyldig: (3+{5{99{*}}[23[{67}67]]})
		 * Ugyldig: (}){
		 */

		ArrayStack<Character> as = new ArrayStack<>();
		String s1 = "(abd+{stk2[22aber]cirkus}42kæder(2{3[4]}))"; // True
		String s2 = "({(][)})"; // False
		String s3 = "a(23{*++{{x2}*a2}[2gs]sda}14)"; // True
		String s4 = "{[()]}(You pervert)"; // True
		String s5 = "{[()]}}"; // False
		String s6 = "{([])}"; // True
		System.out.println("Result: " + as.checkParenteses(s1) + "\n");
		System.out.println("Result: " + as.checkParenteses(s2) + "\n");
		System.out.println("Result: " + as.checkParenteses(s3) + "\n");
		System.out.println("Result: " + as.checkParenteses(s4) + "\n");
		System.out.println("Result: " + as.checkParenteses(s5) + "\n");
		System.out.println("Result: " + as.checkParenteses(s6) + "\n");
	}

}
