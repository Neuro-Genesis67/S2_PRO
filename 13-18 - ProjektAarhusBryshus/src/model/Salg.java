package model;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Salg {

	private LocalDate dato;
	private Betalingsmetode betalingsmetode;
	private ObservableList<Salgslinie> salgslinier = FXCollections.observableArrayList();

	public Salg() {
		this.dato = LocalDate.now();
	}

	public Salg(LocalDate dato) {
		this.dato = dato;
	}

	public Salgslinie createSalgslinie(int antal, Listepris listepris) throws IllegalArgumentException {
		if (antal < 1) {
			throw new IllegalArgumentException("Antallet skal være større end nul");
		}
		Salgslinie salgslinie = new Salgslinie(antal, listepris);
		this.salgslinier.add(salgslinie);
		return salgslinie;
	}

	public LocalDate getDato() {
		return dato;
	}

	public void removeSalgslinie(Salgslinie salgslinie) {
		salgslinier.remove(salgslinie);
	}

	public Betalingsmetode getBetalingsmetode() {
		return betalingsmetode;
	}

	public void setBetalingsmetode(Betalingsmetode betalingsmetode) {
		this.betalingsmetode = betalingsmetode;
	}

	public double beregnSamletPris() {
		double samletPris = 0;
		for (Salgslinie s : salgslinier) {
			samletPris += s.getAktuelPris();
		}
		return samletPris;
	}

	public int getSamletAntalKlip() {
		int antalKlip = 0;
		for (Salgslinie s : salgslinier) {

			// Tilføjer kun klippekortprisen hvis den findes.
			// Hvis der er en vare uden klippekortpris, returneres den samlede som -1
			// da den ikke kan betales med klip.
			if (s.getAntalKlip() > 0) {
				antalKlip += s.getAntalKlip();
			} else {
				return 0;
			}
		}
		return antalKlip;
	}

	public double getSamletRabat() {
		double samletRabat = 0d;
		for (Salgslinie s : salgslinier) {
			// hent den originale pris * antal, minus den aktuelle pris = rabat
			samletRabat += (s.getListepris().getPris() * s.getAntal()) - s.getAktuelPris();
		}
		return samletRabat;
	}

	public ObservableList<Salgslinie> getSalgslinier() {
		return salgslinier;
	}

	@Override
	public String toString() {
		return this.dato + ", beløb: " + this.beregnSamletPris();
	}

	public String getSalgsinformation() {
		StringBuilder sb = new StringBuilder();
		boolean printKlip = getSamletAntalKlip() > 0;

		sb.append("Ordrebeskrivelse: ");
		for (Salgslinie s : salgslinier) {
			sb.append("\n\t").append(s);
			if (printKlip) {
				sb.append(" (" + s.getAntalKlip() + " klip)");
			}

		}
		return sb.toString();
	}
}
