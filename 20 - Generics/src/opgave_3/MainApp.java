package opgave_3;

import java.util.ArrayList;
import java.util.Collections;

public class MainApp {

	public static void main(String[] args) {

		// Navn n1 = new Navn("Ling", "Xiaoyu");
		// Navn n2 = new Navn("Lei", "Wulong");
		// Navn n3 = new Navn("Master", "Raven");
		// Navn n4 = new Navn("Anna", "Williams");
		// Navn n5 = new Navn("Nina", "Williamsen");
		// Navn n6 = new Navn("Nina", "Williams");
		Navn n1 = new Navn("Ling", "Xiaoyu");
		Navn n2 = new Navn("Lei", "Wulong");
		Navn n3 = new Navn("Master", "Raven");
		Navn n4 = new Navn("Anna", "Williams");
		Navn n5 = new Navn("Nina", "Williamsen");
		Navn n6 = new Navn("Nina", "Williams");
		Person<Navn> pn1 = new Person(n1);
		Person<Navn> pn2 = new Person(n2);
		Person<Navn> pn3 = new Person(n3);
		Person<Navn> pn4 = new Person(n4);
		Person<Navn> pn5 = new Person(n5);
		Person<Navn> pn6 = new Person(n6);

		Person<String> ps1 = new Person("Ling Xiaoyu");
		Person<String> ps2 = new Person("Lei Wulong");
		Person<String> ps3 = new Person("Master Raven");
		Person<String> ps4 = new Person("Anna Williams");
		Person<String> ps5 = new Person("Nina Williamsen");
		Person<String> ps6 = new Person("Nina Williams");
		// Opgave 3 - Afprøv Person klassen med String og Navn som typeparameter.
		// Hvis der er noget der ikke giver mening for dig,
		// så tager du det måske for bogstaveligt. Prøv at se på det lidt mere simpelt.

		// With Navn objects:
		ArrayList<Person<Navn>> listNavn = new ArrayList<>();
		listNavn.add(pn1);
		listNavn.add(pn2);
		listNavn.add(pn3);
		listNavn.add(pn4);
		listNavn.add(pn5);
		listNavn.add(pn6);
		System.out.println("List of Person objects with Navn as type parameter: ");
		System.out.println("Unsorted: " + listNavn.toString());
		listNavn.sort(null);
		System.out.println("sorted: " + listNavn.toString() + "\n\n");

		// With String objects:
		ArrayList<Person<String>> listString = new ArrayList<>();
		listString.add(ps1);
		listString.add(ps2);
		listString.add(ps3);
		listString.add(ps4);
		listString.add(ps5);
		listString.add(ps6);
		System.out.println("List of Person objects with String as type parameter: ");
		System.out.println("Unsorted: " + listString.toString());
		Collections.sort(listString);
		System.out.println("Sorted: " + listString.toString());

	}

}
