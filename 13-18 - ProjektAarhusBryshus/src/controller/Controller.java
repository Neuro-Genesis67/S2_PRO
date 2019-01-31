package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Controller {
	private static Controller controllerInstance;
	private final Storage storage = Storage.getInstance();

	private Controller() {
	}

	public static Controller getInstance() {
		if (controllerInstance == null) {
			controllerInstance = new Controller();
		}
		return controllerInstance;
	}

	public Prisliste getStandardPrisliste() {
		return storage.getStandardPrisliste();
	}

	public Prisliste getFredagsbarPrisliste() {
		return storage.getFredagsbarPrisliste();
	}

	public ObservableList<Prisliste> getPrislister() {
		return storage.getPrislister();
	}

	public ObservableList<Produktgruppe> getProduktgrupper() {
		return storage.getProduktgrupper();
	}

	public ObservableList<Produkt> getProdukter(Produktgruppe produktgruppe) {
		return produktgruppe.getProdukter();
	}

	public ArrayList<Produkt> getProdukter(Prisliste prisliste) {
		ArrayList<Produkt> produkter = new ArrayList<>();
		for (Listepris lp : getListepriser(prisliste)) {
			produkter.add(lp.getProdukt());
		}

		return produkter;
	}

	public ObservableList<Listepris> getListepriser(Prisliste prisliste) {
		return prisliste.getListepriser();
	}

	public Produktgruppe opretProduktgruppe(String navn, String beskrivelse) {
		Produktgruppe produktgruppe = new Produktgruppe(navn, beskrivelse);
		storage.addProduktgruppe(produktgruppe);
		return produktgruppe;
	}

	public void removeProduktgruppe(Produktgruppe produktgruppe) {
		storage.removeProduktgruppe(produktgruppe);
	}

	public Produkt opretProdukt(Produktgruppe produktgruppe, String navn, String beskrivelse, String prisString) {
		try {
			if (navn.isEmpty() || beskrivelse.isEmpty()) {
				throw new IllegalArgumentException("Kontroller at navn og beskrivlse er udfyldt");
			}
			double pris = Double.parseDouble(prisString);
			return produktgruppe.createProdukt(navn, beskrivelse, pris);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Kontroller at prisen er et tal.");
		}
	}

	public Prisliste opretPrisliste(String navn, String beskrivelse) {
		Prisliste prisliste = new Prisliste(navn, beskrivelse);
		storage.addPrisliste(prisliste);
		return prisliste;
	}

	public void removePrisliste(Prisliste prisliste) {
		storage.removePrisliste(prisliste);
	}

	public Listepris opretListepris(Produkt produkt, String prisString, Prisliste prisliste) {
		try {
			double pris = Double.parseDouble(prisString);
			return prisliste.createListepris(produkt, pris);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Kontroller venligst at prisen er et tal.");
		}
	}

	public Listepris opretListepris(Produkt produkt, String prisString, int antalKlip, Prisliste prisliste) {
		Listepris lp = opretListepris(produkt, prisString, prisliste);
		lp.setKlippekortPris(antalKlip);
		return lp;
	}

	public void opretStandardPris(Produkt produkt, double pris) {
		getStandardPrisliste().createListepris(produkt, pris);
	}

	public void removeListepris(Listepris listepris, Prisliste prisliste) {
		prisliste.removeListepris(listepris);
	}

	public Produktgruppe getUdlejningsgruppe() {
		return storage.getUdlejningsgruppe();
	}

	public Udlejning confirmUdlejning() {
		return new Udlejning();
	}

	public void confirmUdlejning(Udlejning udlejning, LocalDate udlejningsdato, LocalDate afleveringsdato,
								 String beskrivelse) {
		udlejning.setUdlejningsDato(udlejningsdato);
		udlejning.setAfleveringsDato(afleveringsdato);
		udlejning.setBeskrivelse(beskrivelse);
	}

	public void removeUdlejning(Udlejning udlejning) {
		storage.removeUdlejning(udlejning);
	}

	public void opretUdlejningsprodukt(String navn, String beskrivelse, String pantString, String prisString) {
		try {
			if (navn.isEmpty() || beskrivelse.isEmpty()) {
				throw new IllegalArgumentException("Kontroller at navn og beskrivlse er udfyldt");
			}
			double pant = Double.parseDouble(pantString);
			double pris = Double.parseDouble(prisString);
			storage.getUdlejningsgruppe().createUdlejningsprodukt(navn, beskrivelse, pant, pris);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Kontroller at panten er et tal.");
		}

	}

	public void setSampakningProdukter(Sampakning sampakning, ObservableList<Produkt> produkter) {
		sampakning.setProdukter(produkter);
	}

	public void bekraeftSampakning(Sampakning sampak, String navn, String beskrivelse, String prisString) {
		sampak.setNavn(navn);
		sampak.setBeskrivelse(beskrivelse);
		setStandardPris(sampak, prisString);
	}

	public Sampakning opretSampakning(String navn, String beskrivelse) {
		if (navn.isEmpty() || beskrivelse.isEmpty()) {
			throw new IllegalArgumentException("Kontroller at navn og beskrivlse er udfyldt");
		}
		return getSampakninggruppe().createSampakning(navn, beskrivelse, 1);
	}

	public Produktgruppe getSampakninggruppe() {
		return storage.getSampakninggruppe();
	}

	public ObservableList<Produkt> getSampakprodukter(Sampakning sampak) {
		return sampak.getProdukter();
	}

	public Sampakning getBackup(Sampakning sampak) {
		// Bruges når vi redigerer sampakninger, for at beholde den originale produktliste
		Sampakning backup = new Sampakning(sampak.getNavn(), sampak.getBeskrivelse());
		backup.setProdukter(sampak.getProdukter());
		return backup;
	}

	public void removeSalgslinie(Salg salg, Salgslinie salgslinie) {
		salg.removeSalgslinie(salgslinie);
	}

	public Salgslinie opretSalgslinie(Salg salg, String antalString, Listepris listepris) {
		try {
			int antal = Integer.parseInt(antalString);

			// kaster en IllegalArgumentException hvis antal er <1
			return salg.createSalgslinie(antal, listepris);

		} catch (NumberFormatException e) {
			throw new NumberFormatException("Kontroller venligst indtastningen i feltet Antal");
		} catch (NullPointerException e) {
			throw new NullPointerException("Venligst vælg en vare fra menuen til venstre");
		}
	}

	public void opretSalgslinie(Salg salg, String antalString, Listepris listepris, String samletPrisString,
								String rabatString) {
		double rabat = 0;
		double pris = 0;
		// verificer rabat
		if (!rabatString.equals("0")) {
			try {
				rabat = Double.parseDouble(rabatString);
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Kontroller venligst indtastningen i rabatfeltet.");
			}
		}

		if (!samletPrisString.isEmpty()) {
			try {
				pris = Double.parseDouble(samletPrisString);
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Kontroller venligst indtastningen i prisfeltet");
			}
		}

		// opret linje
		Salgslinie sl = opretSalgslinie(salg, antalString, listepris);

		// tilføj rabat

		if (!samletPrisString.isEmpty()) {
			setAktuelPris(sl, pris);
		}
		if (samletPrisString.isEmpty() && !rabatString.equals("0")) {
			givRabat(sl, rabat);
		}

	}

	private void givRabat(Salgslinie salgslinie, double rabat) {
		salgslinie.rabatProcent(rabat);

	}

	// bruges til at overskrive en salgslinies samlede pris i salgsvinduet
	private void setAktuelPris(Salgslinie sl, double pris) {
		sl.setAktuelPris(pris);
	}

	public double getSamletPris(Salg salg) {
		return salg.beregnSamletPris();
	}

	public int getSamletKlip(Salg salg) {
		return salg.getSamletAntalKlip();
	}

	public double getSamletRabat(Salg salg) {
		return salg.getSamletRabat();
	}

	public ObservableList<Salgslinie> getSalgslinier(Salg salg) {
		return salg.getSalgslinier();
	}

	public ArrayList<Listepris> getUdlejningspriser() {
		// TODO: Vurdér om den her metode ikke bare skal tage alt fra prislisten i
		// stedet for at krydstjekke produktgruppen.

		Produktgruppe udlejninger = storage.getUdlejningsgruppe();
		Prisliste udlejningspris = storage.getUdlejningPrisliste();

		ArrayList<Listepris> udlejningspriser = new ArrayList<>();

		for (Listepris lp : udlejningspris.getListepriser()) {
			if (udlejninger.getProdukter().contains(lp.getProdukt())) {
				udlejningspriser.add(lp);
			}
		}
		return udlejningspriser;
	}

	// Returnerer alle salgslinier osv til at skrive ud.
	public String getSalgsinformation(Salg salg) {
		return salg.getSalgsinformation();
	}

	public void registrerSalg(Salg salg, Betalingsmetode bm) {
		salg.setBetalingsmetode(bm);
		if (salg instanceof Udlejning) {
			storage.addUdlejning((Udlejning) salg);
			((Udlejning) salg).setPantBetalt(true);
		} else {
			storage.addSalg(salg);
		}
	}

	public Salg createSalg() {
		return new Salg();
	}

	public void setStandardPris(Produkt produkt, String prisString) {
		try {
			double pris = Double.parseDouble(prisString);
			Prisliste stp = getStandardPrisliste();

			for (Listepris lp : stp.getListepriser()) {
				if (lp.getProdukt().equals(produkt)) {
					lp.setPris(pris);
					return;
				}
			}
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Kontroller venligst at prisen er et tal");
		}
	}

	public double getStandardPris(Produkt produkt) {
		Prisliste stp = getStandardPrisliste();

		for (Listepris lp : stp.getListepriser()) {
			if (lp.getProdukt().equals(produkt)) {
				return lp.getPris();
			}
		}
		return 0;
	}

	// rediger produkt, mangler måske gruppeændringer for produkt
	public void redigerProdukt(Produkt produkt, String navn, String beskrivelse, String prisString, String pantString,
							   Produktgruppe gammelProduktgruppe, Produktgruppe nyProduktgruppe) {

		if (gammelProduktgruppe.getNavn().equals("Udlejning")) {
			gammelProduktgruppe.removeProdukt(produkt);
			opretUdlejningsprodukt(navn, beskrivelse, pantString, prisString);
		} else {
			gammelProduktgruppe.removeProdukt(produkt);
			opretProdukt(nyProduktgruppe, navn, beskrivelse, prisString);
		}
	}

	private ArrayList<Salg> getDagssalgHelper() {
		ArrayList<Salg> dagssalg = new ArrayList<>();

		// listen er sorteret med det ældste salg på position 0
		ArrayList<Salg> salgList = storage.getSalgList();

		// vi starter oppefra da listen er sorteret, så list.size()-1 må være det seneste salg.
		boolean oldSale = false;
		for (int i = salgList.size(); i > 0 && !oldSale; i--) {
			if (salgList.get(i - 1).getDato().equals(LocalDate.now())) {
				dagssalg.add(salgList.get(i - 1));
			} else {
				// Når vi finder et salg som ikke er i dag, må vi være i fortiden.
				oldSale = true;
			}
		}
		return dagssalg;
	}

	@SuppressWarnings("StringConcatenationInsideStringBufferAppend")
	public String getDagssalg() {
		ArrayList<Salg> dagssalg = getDagssalgHelper();

		/*
		 * et map til at holde styr på hvor mange genstande af en listepris er solgt og
		 * et til at holde styr på meget de har tjent på forskellige listepriser samlet
		 */
		HashMap<Listepris, Integer> salgsmap = new HashMap<>();
		HashMap<Listepris, Double> prisMap = new HashMap<>();

		// dette map holder styr på antallet af varer der er solgt med betalingsmetoden klippekort
		HashMap<Listepris, Integer> salgKlipMap = new HashMap<>();

		// holder styr på hvilke listepriser der er solgt i dag
		HashSet<Listepris> solgteLps = new HashSet<>();

		for (Salg s : dagssalg) {
			if (s.getBetalingsmetode() == Betalingsmetode.KLIPPEKORT) {
				for (Salgslinie sl : s.getSalgslinier()) {
					// løber alle salgslinier igennem og inkrementerer antallet af solgte varer i et map
					Listepris lp = sl.getListepris();
					solgteLps.add(lp);
					int antal = salgKlipMap.getOrDefault(lp, 0);
					salgKlipMap.put(lp, antal + sl.getAntal());
				}
			} else {
				for (Salgslinie sl : s.getSalgslinier()) {
					Listepris lp = sl.getListepris();
					solgteLps.add(lp);

					// ser om listeprisen findes i mappet, ellers er det solgt 0 gange
					int antal = salgsmap.getOrDefault(lp, 0);

					// samme, bare med samlet pris
					double totalpris = prisMap.getOrDefault(lp, 0d);

					salgsmap.put(lp, antal + sl.getAntal());
					prisMap.put(lp, totalpris + sl.getAktuelPris());
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Listepris lp : solgteLps) {
			if (salgsmap.containsKey(lp)) {
				sb.append(lp.getProdukt() + ", antal: " + salgsmap.get(lp));
				sb.append("\n\t" + "Samlet salg: " + prisMap.get(lp) + "\n");
			}
			if (salgKlipMap.containsKey(lp)) {
				sb.append(lp.getProdukt() + ", antal: " + salgKlipMap.get(lp));
				sb.append("\n\t" + "Samlet klip: " + salgKlipMap.get(lp) * lp.getKlippekortPris() + "\n");
			}
			sb.append("\n");
		}

		String output = sb.toString();
		if (output.isEmpty()) {
			return "Der har ikke været nogle salg i dag.";
		}
		return output;
	}

	public String forbrugteKlip(LocalDate start, LocalDate slut) {
		int antalKlip = 0;

		for (Salg s : storage.getSalgList()) {
			if (s.getDato().compareTo(start) >= 0 && s.getDato().compareTo(slut) <= 0) {
				if (s.getBetalingsmetode() == Betalingsmetode.KLIPPEKORT) {
					antalKlip += s.getSamletAntalKlip();
				}
			}
		}

		return "Der er forbrugt " + antalKlip + " klip i perioden";
	}

	public Klippekort createKlippekort(String navn, String beskrivese, int antalKlip) {
		return new Klippekort(navn, beskrivese, antalKlip);
	}

	public String solgteKlippekort(LocalDate start, LocalDate slut) {
		if (start.compareTo(slut) > 0) {
			throw new IllegalArgumentException("Start dato skal være større end slut dato");
		}
		int antalKlip = 0;
		int antalKort = 0;

		for (Salg s : storage.getSalgList()) {
			if (s.getDato().compareTo(start) >= 0 && s.getDato().compareTo(slut) <= 0) {
				for (Salgslinie sl : s.getSalgslinier()) {
					Produkt produkt = sl.getListepris().getProdukt();
					if (produkt instanceof Klippekort) {
						antalKort += sl.getAntal();
						antalKlip += ((Klippekort) produkt).getKlip() * sl.getAntal();
					}
				}
			}
		}


		return "Der er solgt " + antalKort + " klippekort i perioden." +
				"\n\tSamlet antal klip: " + antalKlip;
	}

	public ObservableList<Udlejning> getAktiveUdlejninger() {
		ObservableList<Udlejning> udlejninger = FXCollections.observableArrayList();
		for (Udlejning u : storage.getUdlejninger()) {
			if (!u.isOrdreAfsluttet()) {
				udlejninger.add(u);
			}
		}

		return udlejninger;
	}

	public boolean getPantBetalt(Udlejning udlejning) {
		return udlejning.getPantBetalt();
	}

	public double getSamletPant(Udlejning udlejning) {
		return udlejning.getSamletPant();
	}

	public void afslutUdlejning(Udlejning udlejning, Betalingsmetode betalingsMetode) {
		udlejning.setBetalingsmetode(betalingsMetode);
		udlejning.setOrdreAfsluttet(true);
	}

	public void cancelSampak(Sampakning currSampak) {
		getSampakninggruppe().removeProdukt(currSampak);
	}
}
