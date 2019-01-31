package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Sampakning extends Produkt {

	private ObservableList<Produkt> produkter = FXCollections.observableArrayList();

	public Sampakning(String navn, String beskrivelse) {
		super(navn, beskrivelse);
	}

	public ObservableList<Produkt> getProdukter() {
		return produkter;
	}

	public void setProdukter(ObservableList<Produkt> produkterInput) {
		this.produkter.setAll(produkterInput);
	}

	@Override
	public String toString() {
		return this.getNavn() + ", " + produkter;
	}

}
