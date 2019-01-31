package gumBallMachine;

import java.util.Scanner;

public class MainApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		GumballMachine gm = new GumballMachine(10);
		System.out.println("Welcome to the gumballMachine X722GB-2");
		System.out.println("The gumball machine has " + gm.gumballs + " gumballs\n");
		System.out.println("Controls:\n1 - Insert quarter\n2 - Eject quarter\n3 - Turn lever\n");

		while (gm.gumballs != 0) {
			int s = sc.nextInt();
			boolean done = false;
			while (!done) {
				if (s == 1) {
					gm.insertQuarter();
					done = true;
				} else if (s == 2) {
					gm.ejectQuarter();
					done = true;
				} else if (s == 3) {
					gm.turnCrank();
					done = true;

				} else {
					System.out.println("Wrong input, try again: ");
					s = sc.nextInt();
				}
			}
		}
	}

}
