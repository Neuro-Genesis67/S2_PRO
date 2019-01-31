package model;

public class Udlejningsprodukt extends Produkt {

	private double pant;

	public Udlejningsprodukt(String navn, String beskrivelse, double pant) {
		super(navn, beskrivelse);
		this.pant = pant;
	}

	public double getPant() {
		return pant;
	}

	@Override
	public String toString() {
		return super.toString() + ", pant: " + this.pant + "kr.";
	}
}
