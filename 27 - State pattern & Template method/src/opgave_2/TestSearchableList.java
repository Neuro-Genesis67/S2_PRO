package opgave_2;

import java.util.ArrayList;
import java.util.List;

public class TestSearchableList {

	public static void main(String[] args) {
		// Oprette en liste og indsætte følgende Strings i listen: ”Holme”, ”Skåde”,
		// ”Viby”, ”Beder”,
		// ”Stautrup”, ”Engdal”, ”Forældreskolen” og ”Malling”

		List<String> list = new ArrayList<>();
		list.add("Holme");
		list.add("Skåde");
		list.add("Viby");
		list.add("Beder");
		list.add("Stautrup");
		list.add("Engdal");
		list.add("Forældreskolen");
		list.add("Malling");

		// Søge efter en skole der findes i listen (”Malling”) og udskrive resultatet
		SearchableList sl = new SearchableList<>(list);
		System.out.println("SearchableList\n");

		System.out.println("Is Malling in the list: " + sl.search("Malling"));
		System.out.println("Is Riisskov in the list: " + sl.search("Riisskov"));

	}

}
