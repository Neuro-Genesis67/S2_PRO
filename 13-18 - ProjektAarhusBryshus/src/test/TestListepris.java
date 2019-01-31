package test;

import model.Listepris;
import model.Prisliste;
import model.Produkt;
import model.Produktgruppe;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class TestListepris {

	private Listepris lp;

	@Before
	public void setUp() {
		Produktgruppe pg = new Produktgruppe("Testgruppe", "beskrivelse");
		Produkt p = pg.createProdukt("testprodukt", "beskrivelse", 1);
		Prisliste pl = new Prisliste("testliste", "beskrivelse");
		lp = pl.createListepris(p, 50d);
	}

	@Test
	public void testSetKlippeKortPrisTC01() {
		try {
			lp.setKlippekortPris(0);
		} catch (IllegalArgumentException e) {
			assertEquals("Antallet skal være mellem 1 og 4", e.getMessage());
		}
	}

	@Test
	public void testSetKlippeKortPrisTC02() {
		lp.setKlippekortPris(1);
		assertEquals(1, lp.getKlippekortPris());
	}

	@Test
	public void testSetKlippeKortPrisTC03() {
		lp.setKlippekortPris(2);
		assertEquals(2, lp.getKlippekortPris());
	}

	@Test
	public void testSetKlippeKortPrisTC04() {
		lp.setKlippekortPris(4);
		assertEquals(4, lp.getKlippekortPris());
	}

	@Test
	public void testSetKlippeKortPrisTC05() {
		try {
			lp.setKlippekortPris(6);
		} catch (IllegalArgumentException e) {
			assertEquals("Antallet skal være mellem 1 og 4", e.getMessage());
		}
	}


}
