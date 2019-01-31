package test;

import controller.Controller;
import model.Betalingsmetode;
import model.Klippekort;
import model.Listepris;
import model.Prisliste;
import model.Produkt;
import model.Produktgruppe;
import model.Salg;
import model.Salgslinie;
import storage.Storage;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

@SuppressWarnings("unused")
public class TestController {

	private Controller controller = Controller.getInstance();
	private Prisliste pl;
	private Produkt p1;
	private Produktgruppe pg;
	private Storage storage = Storage.getInstance();

	@Before
	public void setUp() {
		storage.resetStorage();
		pl = new Prisliste("testliste", "beskriv");
		pg = new Produktgruppe("testgruppe", "beskriv");

	}

	@Test
	public void testGetProdukterWithPrislisteTC01() {
		p1 = pg.createProdukt("fadøl", "beskriv", 50);
		Produkt p2 = pg.createProdukt("flaskeøl", "beskriv", 32);
		Listepris lp1 = pl.createListepris(p1, 50);
		Listepris lp2 = pl.createListepris(p2, 32);
		ArrayList<Produkt> resList = new ArrayList<>();
		resList.add(p1);
		resList.add(p2);
		assertEquals(resList, controller.getProdukter(pl));
	}

	@Test
	public void testGetProdukterWithPrislisteTC02() {
		ArrayList<Produkt> resList = new ArrayList<>();
		assertEquals(resList, controller.getProdukter(pl));
	}

	@Test
	public void testOpretListeprisTC01() {
		try {
			p1 = pg.createProdukt("fadøl", "beskriv", 50);
			controller.opretListepris(p1, "test", pl);
			fail();
		} catch (NumberFormatException e) {
			assertEquals("Kontroller venligst at prisen er et tal.", e.getMessage());
		}
	}

	@Test
	public void testOpretListeprisTC02() {
		p1 = pg.createProdukt("fadøl", "beskriv", 50);
		Listepris lp = controller.opretListepris(p1, "100", pl);
		assertTrue(pl.getListepriser().contains(lp));
		assertEquals(100d, lp.getPris());
	}

	@Test
	public void testOpretListeprisTC03() {
		try {
			p1 = pg.createProdukt("fadøl", "beskriv", 50);
			controller.opretListepris(p1, "", pl);
			fail();
		} catch (NumberFormatException e) {
			assertEquals("Kontroller venligst at prisen er et tal.", e.getMessage());
		}
	}

	@Test
	public void testGetDagssalg1() {
		Salg salg1 = new Salg(LocalDate.parse("2018-01-01"));
		controller.registrerSalg(salg1, Betalingsmetode.DANKORT);
		Salg salg2 = new Salg(LocalDate.now());
		controller.registrerSalg(salg2, Betalingsmetode.DANKORT);
		Salg salg3 = new Salg(LocalDate.now());
		controller.registrerSalg(salg3, Betalingsmetode.DANKORT);
		pg = controller.opretProduktgruppe("testgruppe", "beskrivelse");
		Produkt p1 = controller.opretProdukt(pg, "Flaskeøl", "beskrivelse", "50");
		Produkt p2 = controller.opretProdukt(pg, "Fadøl", "beskrivelse", "30");
		Prisliste pl = controller.opretPrisliste("Fredagsbar", "beskrivelse");
		Listepris lp1 = controller.opretListepris(p1, "25", pl);
		Listepris lp2 = controller.opretListepris(p2, "25", 1, pl);

		Salgslinie s1 = controller.opretSalgslinie(salg1, "3", lp1);
		Salgslinie s2 = controller.opretSalgslinie(salg2, "2", lp1);
		Salgslinie s3 = controller.opretSalgslinie(salg2, "1", lp2);
		Salgslinie s4 = controller.opretSalgslinie(salg3, "2", lp2);

		assertEquals("Fadøl, antal: 3\n\tSamlet salg: 75.0\n\nFlaskeøl, antal: 2\n\tSamlet salg: 50.0\n\n"
				, controller.getDagssalg());
	}

	@Test
	public void testGetDagssalg2() {
		assertEquals("Der har ikke været nogle salg i dag.", controller.getDagssalg());
	}

	@Test
	public void testGetDagssalg3() {
		Produktgruppe pg = controller.opretProduktgruppe("testgruppe", "beskrivelse");
		Produkt p1 = controller.opretProdukt(pg, "Flaskeøl", "beskrivelse", "50");
		Prisliste pl = controller.opretPrisliste("Fredagsbar", "beskrivelse");
		Listepris lp1 = controller.opretListepris(p1, "25", pl);
		Salg salg1 = new Salg(LocalDate.parse("2018-01-01"));
		controller.registrerSalg(salg1, Betalingsmetode.DANKORT);
		Salgslinie s1 = controller.opretSalgslinie(salg1, "3", lp1);
		assertEquals("Der har ikke været nogle salg i dag.", controller.getDagssalg());
	}

	@Test
	public void testGetDagssalg4() {
		Produktgruppe pg = controller.opretProduktgruppe("testgruppe", "beskrivelse");
		Produkt p1 = controller.opretProdukt(pg, "Flaskeøl", "beskrivelse", "50");
		Produkt p2 = controller.opretProdukt(pg, "Fadøl", "beskrivelse", "30");
		Prisliste pl = controller.opretPrisliste("Fredagsbar", "beskrivelse");
		Listepris lp1 = controller.opretListepris(p1, "25", pl);
		Listepris lp2 = controller.opretListepris(p2, "25", 1, pl);
		Salg salg1 = new Salg(LocalDate.parse("2018-01-01"));
		controller.registrerSalg(salg1, Betalingsmetode.DANKORT);
		Salg salg3 = new Salg(LocalDate.now());
		controller.registrerSalg(salg3, Betalingsmetode.KLIPPEKORT);
		Salgslinie s1 = controller.opretSalgslinie(salg1, "3", lp1);
		Salgslinie s4 = controller.opretSalgslinie(salg3, "2", lp2);

		assertEquals("Fadøl, antal: 2\n\tSamlet klip: 2\n\n"
				, controller.getDagssalg());
	}

	@Test
	public void testGetDagssalg5() {
		Produktgruppe pg = controller.opretProduktgruppe("testgruppe", "beskrivelse");
		Produkt p1 = controller.opretProdukt(pg, "Flaskeøl", "beskrivelse", "50");
		Produkt p2 = controller.opretProdukt(pg, "Fadøl", "beskrivelse", "30");
		Prisliste pl = controller.opretPrisliste("Fredagsbar", "beskrivelse");
		Listepris lp1 = controller.opretListepris(p1, "25", pl);
		Listepris lp2 = controller.opretListepris(p2, "25", 1, pl);
		Salg salg2 = new Salg(LocalDate.now());
		controller.registrerSalg(salg2, Betalingsmetode.DANKORT);
		Salg salg3 = new Salg(LocalDate.now());
		controller.registrerSalg(salg3, Betalingsmetode.KLIPPEKORT);
		Salgslinie s2 = controller.opretSalgslinie(salg2, "2", lp1);
		Salgslinie s3 = controller.opretSalgslinie(salg2, "1", lp2);
		Salgslinie s4 = controller.opretSalgslinie(salg3, "2", lp2);

		assertEquals("Flaskeøl, antal: 2\n\t" +
				"Samlet salg: 50.0\n\n" +
				"Fadøl, antal: 1\n\t" +
				"Samlet salg: 25.0\n" +
				"Fadøl, antal: 2\n\t" +
				"Samlet klip: 2\n\n", controller.getDagssalg());
	}


	@Test
	public void testSetStandardpris1() {
		p1 = pg.createProdukt("p1", "beskrivelse", 36);
		controller.setStandardPris(p1, "20");
		Listepris lp = controller.getStandardPrisliste().getListepriser().get(0);
		// i vores setup bliver storage nulstillet, derfor ved jeg der kun er et produkt i standardprislisten
		assertEquals(20.0, lp.getPris());
	}

	@Test
	public void testSetStandardpris2() {
		try {
			p1 = pg.createProdukt("p1", "beskrivelse", 36);
			controller.setStandardPris(p1, "Den er dyr");
			fail();
		} catch (NumberFormatException e) {
			assertEquals("Kontroller venligst at prisen er et tal", e.getMessage());
		}
	}

	@Test
	public void testSolgteKlippekort1() {
		Klippekort k1 = controller.createKlippekort("klip", "beskrivese", 4);
		Prisliste pl = controller.opretPrisliste("Fredagsbar", "beskrivelse");
		Listepris lp1 = controller.opretListepris(k1, "100", pl);
		Salg salg1 = new Salg(LocalDate.parse("2018-01-01"));
		controller.registrerSalg(salg1, Betalingsmetode.KLIPPEKORT);
		Salgslinie s1 = controller.opretSalgslinie(salg1, "1", lp1);

		assertEquals("Der er solgt " + "1" + " klippekort i perioden." +
				"\n\tSamlet antal klip: " + "4", controller.solgteKlippekort(LocalDate.parse("2017-12-31"), LocalDate.parse("2018-01-02")));
	}

	@Test
	public void testSolgteKlippekort2() {
		assertEquals("Der er solgt " + "0" + " klippekort i perioden." +
				"\n\tSamlet antal klip: " + "0", controller.solgteKlippekort(LocalDate.parse("2018-01-01"), LocalDate.parse("2018-01-01")));
	}

	@Test
	public void testSolgteKlippekort3() {
		try {
			controller.solgteKlippekort(LocalDate.parse("2018-01-31"), LocalDate.parse("2018-01-01"));
		} catch (IllegalArgumentException e) {
			assertEquals("Start dato skal være større end slut dato", e.getMessage());
		}
	}


}
