package model;

public class Klippekort extends Produkt {

	private int klip;

	public Klippekort(String navn, String beskrivelse, int klip) {
		super(navn, beskrivelse);
		this.klip = klip;
	}

	public int getKlip() {
		return klip;
	}
}
