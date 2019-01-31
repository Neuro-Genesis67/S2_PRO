package model;

import java.time.LocalDate;

public class Udlejning extends Salg {

	private LocalDate udlejningsDato, afleveringsDato;
	private String beskrivelse;
	private boolean pantBetalt;
	private boolean ordreAfsluttet;

	public boolean isOrdreAfsluttet() {
		return ordreAfsluttet;
	}

	public Udlejning() {
		super();
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public Boolean getPantBetalt() {
		return pantBetalt;
	}

	public void setPantBetalt(Boolean pantBetalt) {
		this.pantBetalt = pantBetalt;
	}

	public void setUdlejningsDato(LocalDate udlejningsDato) {
		this.udlejningsDato = udlejningsDato;
	}

	public void setAfleveringsDato(LocalDate afleveringsDato) {
		this.afleveringsDato = afleveringsDato;
	}

	public void setOrdreAfsluttet(boolean afsluttet) {
		this.ordreAfsluttet = afsluttet;
	}

	public double getSamletPant() {
		double pant = 0;
		for (Salgslinie sl : this.getSalgslinier()) {
			if (sl.getListepris().getProdukt() instanceof Udlejningsprodukt) {
				Udlejningsprodukt udlProdukt = (Udlejningsprodukt) sl.getListepris().getProdukt();
				pant += udlProdukt.getPant() * sl.getAntal();
			}
		}

		return pant;
	}

	@Override
	public String toString() {
		return this.udlejningsDato + ", beløb: " + this.beregnSamletPris();

	}

	@Override
	public String getSalgsinformation() {
		return super.getSalgsinformation() +
				"\n\n" +
				"Udlejningsdato:\t" + udlejningsDato +
				"\nAfleveringsdato:\t" + afleveringsDato +
				"\n\nDetaljer: " + beskrivelse;
	}
}
