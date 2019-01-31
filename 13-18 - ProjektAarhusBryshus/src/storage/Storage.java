package storage;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Betalingsmetode;
import model.Klippekort;
import model.Listepris;
import model.Prisliste;
import model.Produkt;
import model.Produktgruppe;
import model.Salg;
import model.Salgslinie;
import model.Sampakning;
import model.Udlejning;

@SuppressWarnings("unused")
public class Storage {

	private static Storage storageInstance;
	private ObservableList<Prisliste> prislister = FXCollections.observableArrayList();
	private ObservableList<Produktgruppe> produktgrupper = FXCollections.observableArrayList();
	private ObservableList<Udlejning> udlejninger = FXCollections.observableArrayList();
	private ArrayList<Salg> salgList = new ArrayList<>();

	private Prisliste standardPrisliste = new Prisliste("Standard Prislisten",
			"Viser standardprisen alle produkter har");
	private Prisliste udlejningPrisliste = new Prisliste("Udlejning Prislisten",
			"Viser udlejningsprisen for specielle produkter");
	private Prisliste fredagsbarPrisliste;
	private Produktgruppe udlejningProduktgruppe;
	private Produktgruppe sampakninggruppe;

	private Storage() {

	}

	public static Storage getInstance() {
		if (storageInstance == null) {
			storageInstance = new Storage();
		}
		return storageInstance;
	}

	public Prisliste getStandardPrisliste() {
		return standardPrisliste;
	}

	public Prisliste getFredagsbarPrisliste() {
		return fredagsbarPrisliste;
	}

	public Prisliste getUdlejningPrisliste() {
		return udlejningPrisliste;
	}

	public ObservableList<Prisliste> getPrislister() {
		return prislister;
	}

	public ObservableList<Produktgruppe> getProduktgrupper() {
		return produktgrupper;
	}

	public ObservableList<Udlejning> getUdlejninger() {
		return udlejninger;
	}

	public void addUdlejning(Udlejning udlejning) {
		udlejninger.add(udlejning);
	}

	public void addSalg(Salg salg) {
		salgList.add(salg);
	}

	public ArrayList<Salg> getSalgList() {
		return new ArrayList<>(salgList);
	}

	public void removeUdlejning(Udlejning udlejning) {
		udlejninger.remove(udlejning);
	}

	public void addProduktgruppe(Produktgruppe produktgruppe) {
		produktgrupper.add(produktgruppe);
	}

	public void removeProduktgruppe(Produktgruppe produktgruppe) {
		produktgrupper.remove(produktgruppe);
	}

	public void addPrisliste(Prisliste prisliste) {
		prislister.add(prisliste);
	}

	public void removePrisliste(Prisliste prisliste) {
		prislister.remove(prisliste);
	}

	public Produktgruppe getUdlejningsgruppe() {
		return udlejningProduktgruppe;
	}

	public Produktgruppe getSampakninggruppe() {
		return sampakninggruppe;
	}

	public void resetStorage() {
		prislister.clear();
		produktgrupper.clear();
		udlejninger.clear();
		salgList.clear();
		standardPrisliste = new Prisliste("Standard Prislisten", "Viser standardprisen alle produkter har");
		udlejningPrisliste = new Prisliste("Udlejning Prislisten", "Viser udlejningsprisen for specielle produkter");
	}

	// ------------------------------------------------------------------------------------

	public void initContent() {
		Produkt produkt;

		prislister.add(standardPrisliste);
		fredagsbarPrisliste = new Prisliste("Fredagsbar", "beskrivelse");
		prislister.add(fredagsbarPrisliste);

		Controller controller = Controller.getInstance();

		// Opretter produktgrupper.
		sampakninggruppe = controller.opretProduktgruppe("Sampakning", "Indeholder f.eks. gaveæsker");
		Produktgruppe flaskeøl = controller.opretProduktgruppe("Flaskeøl", "beskrivelse");

		produkt = flaskeøl.createProdukt("Klosterbryg", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);

		produkt = flaskeøl.createProdukt("Sweet Georgia Brown", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);
		produkt = flaskeøl.createProdukt("Extra Pilsner", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);
		produkt = flaskeøl.createProdukt("Celebration", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);
		produkt = flaskeøl.createProdukt("Blondie", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);
		produkt = flaskeøl.createProdukt("Forårsbryg", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);
		produkt = flaskeøl.createProdukt("Indian Pale Ale", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);
		produkt = flaskeøl.createProdukt("Julebryg", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);
		produkt = flaskeøl.createProdukt("Juletønden", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);
		produkt = flaskeøl.createProdukt("Old Strong Ale", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);
		produkt = flaskeøl.createProdukt("Fregatten Jylland", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);
		produkt = flaskeøl.createProdukt("Imperial Stout", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);
		produkt = flaskeøl.createProdukt("Tribute", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);
		produkt = flaskeøl.createProdukt("Black Monster", "Flaskeøl", 36);
		controller.opretListepris(produkt, "50", 2, fredagsbarPrisliste);

		Produktgruppe fadøl = controller.opretProduktgruppe("Fadøl", "Beskrivelse");
		produkt = fadøl.createProdukt("Klosterbryg", "Fadøl", 30);
		controller.opretListepris(produkt, "30", 1, fredagsbarPrisliste);
		produkt = fadøl.createProdukt("Jazz Classic", "Fadøl", 30);
		controller.opretListepris(produkt, "30", 1, fredagsbarPrisliste);
		produkt = fadøl.createProdukt("Extra Pilsner", "Fadøl", 30);
		controller.opretListepris(produkt, "30", 1, fredagsbarPrisliste);
		produkt = fadøl.createProdukt("Celebration", "Fadøl", 30);
		controller.opretListepris(produkt, "30", 1, fredagsbarPrisliste);
		produkt = fadøl.createProdukt("Blondie", "Fadøl", 30);
		controller.opretListepris(produkt, "30", 1, fredagsbarPrisliste);
		produkt = fadøl.createProdukt("Forårsbryg", "Fadøl", 30);
		controller.opretListepris(produkt, "30", 1, fredagsbarPrisliste);
		produkt = fadøl.createProdukt("India Pale Ale", "Fadøl", 30);
		controller.opretListepris(produkt, "30", 1, fredagsbarPrisliste);
		produkt = fadøl.createProdukt("Julebryg", "Fadøl", 30);
		controller.opretListepris(produkt, "30", 1, fredagsbarPrisliste);
		produkt = fadøl.createProdukt("Imperial Stout", "Fadøl", 30);
		controller.opretListepris(produkt, "30", 1, fredagsbarPrisliste);
		produkt = fadøl.createProdukt("Special", "Fadøl", 30);
		controller.opretListepris(produkt, "30", 1, fredagsbarPrisliste);

		Produktgruppe snacks = controller.opretProduktgruppe("Snacks", "Beskrivelse");
		produkt = snacks.createProdukt("Æblebrus", "Snack", 30);
		controller.opretListepris(produkt, "15", 1, fredagsbarPrisliste);
		produkt = snacks.createProdukt("Chips", "Snack", 30);
		controller.opretListepris(produkt, "10", 1, fredagsbarPrisliste);
		produkt = snacks.createProdukt("Peanuts", "Snack", 30);
		controller.opretListepris(produkt, "10", 1, fredagsbarPrisliste);
		produkt = snacks.createProdukt("Cola", "Snack", 30);
		controller.opretListepris(produkt, "15", 1, fredagsbarPrisliste);
		produkt = snacks.createProdukt("Nikoline", "Snack", 30);
		controller.opretListepris(produkt, "15", 1, fredagsbarPrisliste);
		produkt = snacks.createProdukt("7-Up", "Snack", 30);
		controller.opretListepris(produkt, "15", 1, fredagsbarPrisliste);
		produkt = snacks.createProdukt("Vand", "Snack", 30);
		controller.opretListepris(produkt, "10", 1, fredagsbarPrisliste);

		Produktgruppe spiritus = controller.opretProduktgruppe("Spiritus", "Beskrivelse");
		produkt = spiritus.createProdukt("Spirit of Aarhus", "Spiritus", 300);
		fredagsbarPrisliste.createListepris(produkt, 30);
		produkt = spiritus.createProdukt("SOA med pind", "Spiritus", 350);
		fredagsbarPrisliste.createListepris(produkt, 30);
		produkt = spiritus.createProdukt("Whisky", "Spiritus", 500);
		fredagsbarPrisliste.createListepris(produkt, 30);
		produkt = spiritus.createProdukt("Liquor of Aarhus", "Spiritus", 175);
		fredagsbarPrisliste.createListepris(produkt, 30);

		udlejningProduktgruppe = controller.opretProduktgruppe("Udlejning", "Beskrivelse");
		udlejningProduktgruppe.createUdlejningsprodukt("Klosterbryg", "Fustage - 20 liter", 200, 775);
		udlejningProduktgruppe.createUdlejningsprodukt("Jazz Classic", "Fustage - 25 liter", 200, 625);
		udlejningProduktgruppe.createUdlejningsprodukt("Extra Pilsner", "Fustage - 25 liter", 200, 575);
		udlejningProduktgruppe.createUdlejningsprodukt("Celebration", "Fustage - 20 liter", 200, 775);
		udlejningProduktgruppe.createUdlejningsprodukt("Blondie", "Fustage - 25 liter", 200, 700);
		udlejningProduktgruppe.createUdlejningsprodukt("Forårsbryg", "Fustage - 20 liter", 200, 775);
		udlejningProduktgruppe.createUdlejningsprodukt("India Pale Ale", "Fustage - 20 liter", 200, 775);
		udlejningProduktgruppe.createUdlejningsprodukt("Julebryg", "Fustage - 20 liter", 200, 775);
		udlejningProduktgruppe.createUdlejningsprodukt("Imperial Stout", "Fustage - 20 liter", 200, 775);
		udlejningProduktgruppe.createUdlejningsprodukt("Fustage pant", "Fustage pant", 200, 200);

		udlejningProduktgruppe.createUdlejningsprodukt("1-hane", "Anlæg", 0, 250);
		udlejningProduktgruppe.createUdlejningsprodukt("2-haner", "Anlæg", 0, 400);
		udlejningProduktgruppe.createUdlejningsprodukt("Bar med flere haner", "Anlæg", 0, 500);
		udlejningProduktgruppe.createUdlejningsprodukt("Levering", "Anlæg", 0, 500);
		udlejningProduktgruppe.createUdlejningsprodukt("Krus", "Anlæg", 0, 60);
		udlejningProduktgruppe.createUdlejningsprodukt("Kulsyre - 4kg.", "Kulsyre", 1000, 999);
		udlejningProduktgruppe.createUdlejningsprodukt("Kulsyre - 10kg.", "Kulsyre", 1000, 999);

		Produktgruppe merchandise = controller.opretProduktgruppe("Merchandise", "Beskrivelse");
		merchandise.createProdukt("Malt - 25kg.", "Sæk", 300);
		produkt = merchandise.createProdukt("T-shirt", "T-Shirt", 70);
		fredagsbarPrisliste.createListepris(produkt, 70);
		produkt = merchandise.createProdukt("Polo", "Polo", 100);
		fredagsbarPrisliste.createListepris(produkt, 100);
		produkt = merchandise.createProdukt("Cap", "Cap", 30);
		fredagsbarPrisliste.createListepris(produkt, 30);
		merchandise.createProdukt("Glas", "Uanset størrelse", 15);
		produkt = merchandise.createProdukt("Gaveæske: 2 øl + 2 glas", "Gaveæske", 100);
		fredagsbarPrisliste.createListepris(produkt, 100);
		produkt = merchandise.createProdukt("Gaveæske: 4 øl", "Gaveæske", 130);
		fredagsbarPrisliste.createListepris(produkt, 130);
		produkt = merchandise.createProdukt("Gavekurv: 6 øl + 2 glas", "Gavekurv", 250);
		fredagsbarPrisliste.createListepris(produkt, 250);
		produkt = merchandise.createProdukt("Trækasse: 6 øl", "Trækasse", 240);
		fredagsbarPrisliste.createListepris(produkt, 240);
		produkt = merchandise.createProdukt("Trækasse: 6 øl + 6 glas", "Trækasse", 290);
		fredagsbarPrisliste.createListepris(produkt, 290);
		produkt = merchandise.createProdukt("Trækasse: 12 øl", "Trækasse", 390);
		fredagsbarPrisliste.createListepris(produkt, 390);
		produkt = merchandise.createProdukt("Papkasse: 12 øl", "Papkasse", 360);
		fredagsbarPrisliste.createListepris(produkt, 360);
		merchandise.createProdukt("Rundvisning", "Pr. person, pr. dag.", 100);

		Produktgruppe klippekort = controller.opretProduktgruppe("Klippekort", "Til salg i fredagsbaren");
		Klippekort k = controller.createKlippekort("Klippekort (4 klip)", "Bruges til at købe ting i fredagsbaren", 4);
		klippekort.addProdukt(k);
		Listepris lpKlip = controller.opretListepris(k, "100", fredagsbarPrisliste);


		// Tidligere salg (Tidligst den 2018-11-01)
		Produkt p1 = flaskeøl.createProdukt("Aaløl", "beskrivelse", 36);
		Produkt p2 = flaskeøl.createProdukt("Danse-Vand", "beskrivelse", 36);
		Produkt p3 = flaskeøl.createProdukt("Powerbajer", "beskrivelse", 299);
		Produkt p4 = flaskeøl.createProdukt("Billy Sprøit", "beskrivelse", 22);

		Sampakning sp1 = sampakninggruppe.createSampakning("Aal-Special", "seks dejlige Aaløl, til dig der ikke kan lade hver", 180);
		ObservableList<Produkt> sp1Pro = FXCollections.observableArrayList();
		for (int i = 0; i < 6; i++) {
			sp1Pro.add(p1);
		}
		sp1.setProdukter(sp1Pro);

		Sampakning sp2 = sampakninggruppe.createSampakning("Rigmands Filur", "Til dig der bare har for mange penge", 1200);
		ObservableList<Produkt> sp2Pro = FXCollections.observableArrayList();
		for (int i = 0; i < 4; i++) {
			sp2Pro.add(p3);
		}
		sp2.setProdukter(sp2Pro);

		Sampakning sp3 = sampakninggruppe.createSampakning("Alt-Godt-Fra-Havet", "brygget på saltvand og tjære", 200);
		ObservableList<Produkt> sp3Pro = FXCollections.observableArrayList();
		sp3Pro.add(p1);
		sp3Pro.add(p2);
		sp3Pro.add(p3);
		sp3Pro.add(p4);
		sp3.setProdukter(sp3Pro);

		Listepris lp1 = controller.opretListepris(p1, "50", 1, fredagsbarPrisliste);
		Listepris lp2 = controller.opretListepris(p2, "50", 1, fredagsbarPrisliste);
		controller.opretListepris(p3, "50", 1, fredagsbarPrisliste);
		controller.opretListepris(p4, "50", 1, fredagsbarPrisliste);

		Salg salg1 = new Salg(LocalDate.parse("2018-10-02"));
		controller.registrerSalg(salg1, Betalingsmetode.KLIPPEKORT);
		salg1.createSalgslinie(3, lp1);

		Salg salg2 = new Salg(LocalDate.parse("2018-11-01"));
		controller.registrerSalg(salg2, Betalingsmetode.DANKORT);
		Salgslinie sl2 = salg2.createSalgslinie(6, lp2);

		Salg salg3 = new Salg(LocalDate.parse("2018-11-02"));
		controller.registrerSalg(salg3, Betalingsmetode.KLIPPEKORT);
		Salgslinie sl3 = salg3.createSalgslinie(1, lp1);
		Salgslinie sl4 = salg3.createSalgslinie(2, lp2);

		Salg salg4 = new Salg(LocalDate.parse("2018-11-02"));
		controller.registrerSalg(salg4, Betalingsmetode.DANKORT);
		Salgslinie sl5 = salg4.createSalgslinie(3, lp1);
		Salgslinie sl6 = salg4.createSalgslinie(3, lp2);

		Salg salg5 = new Salg(LocalDate.parse("2018-11-02"));
		controller.registrerSalg(salg5, Betalingsmetode.DANKORT);
		Salgslinie sl7 = salg5.createSalgslinie(3, lpKlip);

		Salg salg6 = new Salg(LocalDate.now());
		controller.registrerSalg(salg6, Betalingsmetode.KLIPPEKORT);
		Salgslinie sl8 = salg6.createSalgslinie(2, lp2);

		Salg salg7 = new Salg(LocalDate.now());
		controller.registrerSalg(salg7, Betalingsmetode.KONTANT);
		Salgslinie sl9 = salg7.createSalgslinie(5, lp1);

		Udlejning ud1 = new Udlejning();
		Salgslinie us1 = ud1.createSalgslinie(2, udlejningPrisliste.getListepriser().get(2));
		controller.confirmUdlejning(ud1, LocalDate.parse("2018-11-08"), LocalDate.parse("2018-11-10"), "Udlejet til Bent Jensen, tlf 12 34 56 78");
		controller.registrerSalg(ud1, Betalingsmetode.REGNING);

		Udlejning ud2 = new Udlejning();
		Salgslinie us2 = ud2.createSalgslinie(3, udlejningPrisliste.getListepriser().get(1));
		controller.confirmUdlejning(ud2, LocalDate.parse("2018-11-09"), LocalDate.parse("2018-11-12"), "Udlejet til Johnny Smart, adresse: Festvej 69");
		controller.registrerSalg(ud2, Betalingsmetode.REGNING);

		Udlejning ud3 = new Udlejning();
		Salgslinie us3 = ud3.createSalgslinie(3, udlejningPrisliste.getListepriser().get(4));
		controller.confirmUdlejning(ud3, LocalDate.parse("2018-11-16"), LocalDate.parse("2018-11-18"), "Udlejet til hr og fru Weissmarch, tlf 0 0 0 5");
		controller.registrerSalg(ud3, Betalingsmetode.REGNING);

		Udlejning ud4 = new Udlejning();
		Salgslinie us4 = ud4.createSalgslinie(6, udlejningPrisliste.getListepriser().get(3));
		controller.confirmUdlejning(ud4, LocalDate.parse("2018-11-23"), LocalDate.parse("2018-11-25"), "Udlejet til min fætter, han bor ved det store sving");
		controller.registrerSalg(ud4, Betalingsmetode.REGNING);
	}

}
