package model;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import storage.Storage;

public class Produktgruppe {
	private String navn;
	private ObservableList<Produkt> produkter = FXCollections.observableArrayList();

	public Produktgruppe(String navn, String beskrivelse) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public ObservableList<Produkt> getProdukter() {
		return produkter;
	}

	public Produkt createProdukt(String navn, String beskrivelse, double pris) {
		Produkt produkt = new Produkt(navn, beskrivelse);
		this.produkter.add(produkt);
		Controller.getInstance().opretStandardPris(produkt, pris);
		return produkt;
	}

	public Udlejningsprodukt createUdlejningsprodukt(String navn, String beskrivelse, double pant, double pris) {

		if (pant < 0) {
			throw new IllegalArgumentException("Panten må ikke være under nul");
		}

		Udlejningsprodukt produkt = new Udlejningsprodukt(navn, beskrivelse, pant);
		this.produkter.add(produkt);
		Storage.getInstance().getUdlejningPrisliste().createListepris(produkt, pris);
		return produkt;
	}

	public Sampakning createSampakning(String navn, String beskrivelse, double pris) {
		Sampakning produkt = new Sampakning(navn, beskrivelse);
		this.produkter.add(produkt);
		Controller.getInstance().opretStandardPris(produkt, pris);
		return produkt;
	}

	public void removeProdukt(Produkt produkt) {
		this.produkter.remove(produkt);
	}

	public void addProdukt(Produkt produkt) {
		if (!this.produkter.contains(produkt)) {
			produkter.add(produkt);
		}
	}

	@Override
	public String toString() {
		return this.navn;
	}
}
