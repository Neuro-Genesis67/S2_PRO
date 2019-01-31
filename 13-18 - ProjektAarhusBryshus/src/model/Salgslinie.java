package model;

public class Salgslinie {

	private int antal;
	private Listepris listepris;
	private double aktuelPris;
	private int antalKlip;

	public Salgslinie(int antal, Listepris listepris) {
		this.antal = antal;
		this.listepris = listepris;
		this.aktuelPris = listepris.getPris() * antal;
		this.antalKlip = listepris.getKlippekortPris() * antal;
	}

	public int getAntal() {
		return antal;
	}

	public Listepris getListepris() {
		return listepris;
	}

	public double getAktuelPris() {
		return aktuelPris;
	}

	// Returnerer et negativt tal hvis der ikke er en pris
	public int getAntalKlip() {
		return antalKlip;

	}

	public void setAktuelPris(double aktuelPris) {
		this.aktuelPris = aktuelPris;
	}

	public void rabatProcent(double pct) {
		aktuelPris = ((listepris.getPris() * antal) * (100 - pct) / 100);
	}

	@Override
	public String toString() {
		return antal + " " + listepris.getProdukt().getNavn() + ", " + aktuelPris + "kr.";
	}
}
