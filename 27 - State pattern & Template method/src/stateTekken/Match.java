package stateTekken;

import java.util.Random;
import java.util.Scanner;

public class Match {

	Scanner sc = new Scanner(System.in);
	Fighter f1;
	Fighter f2;

	public Match(Fighter f1, Fighter f2) {
		this.f1 = f1;
		this.f2 = f2;
		f1.setOpponent(f2);
		f2.setOpponent(f1);
	}

	public void startMatch() {
		System.out.println("The match is starting");
		System.out.println(f1.getName() + " vs. " + f2.getName() + "\n");
		System.out.println("Controls: \n1 = lightAttack\n2 = heavyAttack\n3 = Block\n4 = Recover\n");
		decideWhoStarts();

		while (f1.health > 0 && f2.health > 0) {
			if (f1.turn == true) {
				move(f1);
			}

			if (f2.turn == true && f2.health > 0) {
				move(f2);
			}

		}

		if (f1.health < 0) {
			System.out.println("\n" + f2.getName() + " won the fight with " + f2.getHealth() + " health left.");
		} else {
			System.out.println("\n" + f1.getName() + " won the fight with " + f1.getHealth() + " health left.");
		}
	}

	public void decideWhoStarts() {
		Random r = new Random();
		int i = r.nextInt(2);

		if (i == 1) {
			f1.turn = true;
			System.out.println("||| " + f1.getName() + " starts the round |||\n");
		} else {
			f2.turn = true;
			System.out.println("||| " + f2.getName() + " starts the round |||\n");
		}
	}

	public void move(Fighter f) {
		if (f.getState().equals(f.recovering)) {
			System.out.println(f.getHealth() + " " + f.getName() + " needs to recover, press 4 to recover");
		} else {
			System.out.println(f.getHealth() + " " + f.getName() + "'s turn:");

		}

		int s = sc.nextInt();
		boolean done = false;
		while (!done) {
			if (s == 1) {
				f.lightAttack();
				done = true;
			} else if (s == 2) {
				f.heavyAttack();
				done = true;
			} else if (s == 3) {
				f.block();
				done = true;
			} else if (s == 4) {
				f.recover();
				done = true;
			} else {
				System.out.println("Wrong input, try again: ");
				s = sc.nextInt();
			}
		}
	}

}
