package test;

import model.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSalgslinie {
	private Produktgruppe produktgruppe = new Produktgruppe("Merchandise", "beskrivelse");
	private Produkt produkt = produktgruppe.createProdukt("Polo", "Størrelse Medium", 100);
	private Prisliste pl = new Prisliste("testliste", "beskrivelse");
	private Listepris listepris = pl.createListepris(produkt, 100);
	private Salgslinie sl;

	@Before
	public void setUp() {
		Salg salg = new Salg();
		sl = salg.createSalgslinie(1, listepris);
		assertEquals(100d, sl.getAktuelPris());
	}

	@Test
	public void testRabatProcentTC01() {
		assertEquals(100d, sl.getAktuelPris());
		sl.rabatProcent(-25);
		assertEquals(125d, sl.getAktuelPris());
	}

	@Test
	public void testRabatProcentTC02() {
		assertEquals(100d, sl.getAktuelPris());
		sl.rabatProcent(0);
		assertEquals(100d, sl.getAktuelPris());
	}

	@Test
	public void testRabatProcentTC03() {
		assertEquals(100d, sl.getAktuelPris());
		sl.rabatProcent(50);
		assertEquals(50d, sl.getAktuelPris());
	}
}
