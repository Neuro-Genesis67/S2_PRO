package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Prisliste {

	private String navn;
	private ObservableList<Listepris> listepriser;

	public Prisliste(String navn, String beskrivelse) {
		this.navn = navn;
		listepriser = FXCollections.observableArrayList();
	}

	public ObservableList<Listepris> getListepriser() {
		return listepriser;
	}

	@SuppressWarnings("ConstantConditions")
	public Listepris createListepris(Produkt produkt, double pris) {
		if (produkt == null) {
			throw new IllegalArgumentException("Produktet er ikke oprettet (null)");
		}
		if (pris <= 0) {
			throw new IllegalArgumentException("Prisen skal være større end nul.");
		}
		Listepris listepris = new Listepris(produkt, pris);
		this.listepriser.add(listepris);
		return listepris;
	}

	public void removeListepris(Listepris listepris) {
		listepriser.remove(listepris);
	}

	@Override
	public String toString() {
		return this.navn;
	}
}
