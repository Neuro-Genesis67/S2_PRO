package test;

import model.Listepris;
import model.Prisliste;
import model.Produkt;
import model.Produktgruppe;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class TestPrisliste {

	private Prisliste pl;
	private Produkt p;

	@Before
	public void setUp() {
		pl = new Prisliste("Prisliste", "beskrivelse");

		// Produktgruppen er nødvendig, da alle produkter skal oprettes herigennem. Den er testet i TestProdukgruppe.
		Produktgruppe pg = new Produktgruppe("testgruppe", "til test");
		p = pg.createProdukt("øl", "på flaske", 1);

	}

	@Test
	public void testCreateListeprisTC01() {
		try {
			pl.createListepris(p, -1);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Prisen skal være større end nul.", e.getMessage());
		}
	}

	@Test
	public void testCreateListeprisTC02() {
		try {
			pl.createListepris(p, 0);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Prisen skal være større end nul.", e.getMessage());
		}
	}

	@Test
	public void testCreateListeprisTC03() {
		Listepris lp = pl.createListepris(p, 1);
		assertTrue(pl.getListepriser().contains(lp));
	}

	@Test
	public void testCreateListeprisTC04() {
		try {
			pl.createListepris(null, 1);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Produktet er ikke oprettet (null)", e.getMessage());
		}
	}
}
