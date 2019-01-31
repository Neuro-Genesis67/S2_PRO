package model;

public class Listepris {

	private Produkt produkt;
	private double pris;
	private int klippekortPris = -1;

	Listepris(Produkt produkt, double pris) {
		this.produkt = produkt;
		this.pris = pris;
	}

	public Produkt getProdukt() {
		return produkt;
	}

	public double getPris() {
		return pris;
	}

	public int getKlippekortPris() {
		return klippekortPris;
	}

	public void setPris(double pris) {
		if (pris <= 0) {
			throw new IllegalArgumentException("Prisen skal være større end nul");
		}

		this.pris = pris;
	}

	public void setKlippekortPris(int antal) {
		if (antal <= 0 || antal > 4) {
			throw new IllegalArgumentException("Antallet skal være mellem 1 og 4");
		}
		this.klippekortPris = antal;
	}

	@Override
	public String toString() {

		if (this.getProdukt() instanceof Udlejningsprodukt) {
			return this.produkt.toString() + ", " + pris;
		}
		if (klippekortPris > 0) {
			return this.produkt.getNavn() + ", " + pris + ", (" + klippekortPris + " klip)";
		} else {
			return this.produkt.getNavn() + ", " + pris;
		}
	}

}
