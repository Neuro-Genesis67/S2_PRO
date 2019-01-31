package opgave_4;

import java.util.HashSet;
import java.util.Set;

public class SetOperationsApp {

	public static void main(String[] args) {

		SetOperations specOps = new SetOperations();

		Set<Integer> s1 = new HashSet<Integer>();
		Set<Integer> s2 = new HashSet<Integer>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(5);
		s1.add(6);
		s1.add(7);
		s1.add(8);

		s2.add(4);
		s2.add(5);
		s2.add(6);
		s2.add(7);
		s2.add(8);
		s2.add(9);
		s2.add(10);
		s2.add(11);
		System.out.println("S1: " + s1);
		System.out.println("S2: " + s2 + "\n");

		System.out.println("Union s1, s2: " + specOps.union(s1, s2));
		System.out.println("Union s2, s1: " + specOps.union(s2, s1));
		System.out.println("Differens s1, s2: " + specOps.differens(s1, s2) + " = What does s1 have, that s2 hasn't");
		System.out.println("Differens s2, s1: " + specOps.differens(s2, s1) + " = What does s2 have, that s1 hasn't");
		System.out.println("Intersection s1, s2: " + specOps.intesection(s1, s2));
		System.out.println("Intersection s2, s1: " + specOps.intesection(s2, s1));

	}

}
