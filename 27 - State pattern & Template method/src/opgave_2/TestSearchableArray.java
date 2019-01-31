package opgave_2;

public class TestSearchableArray {

	public static void main(String[] args) {
		// Oprette en liste og indsætte følgende Strings i listen: ”Holme”, ”Skåde”,
		// ”Viby”, ”Beder”,
		// ”Stautrup”, ”Engdal”, ”Forældreskolen” og ”Malling”
		String[] list = { "Holme", "Skåde", "Viby", "Beder", "Stautrup", "Engdal", "Forældreskolen", "Malling" };
		SearchableArray<String> sa = new SearchableArray<>(list);
		System.out.println("SearchableArray\n");

		System.out.println("Is Malling in the list: " + sa.search("Malling"));
		System.out.println("Is Riisskov in the list: " + sa.search("Riisskov"));

	}

}
