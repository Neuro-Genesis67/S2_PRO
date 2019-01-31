package test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import model.Produkt;
import model.Produktgruppe;
import model.Udlejningsprodukt;

public class TestProduktgruppe {

	private Produktgruppe pg;

	@Before
	public void setUp() {
		pg = new Produktgruppe("Produkter", "Beskrivelse");
	}

	@Test
	public void testCreateProduktTC01() {
		try {
			pg.createProdukt("Øl Bajer", "på flaske", -1);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Prisen skal være større end nul.", e.getMessage());
		}
	}

	@Test
	public void testCreateProduktTC02() {
		try {
			pg.createProdukt("Øl Bajer", "på flaske", 0);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Prisen skal være større end nul.", e.getMessage());
		}
	}

	@Test
	public void testCreateProduktTC03() {
		Produkt p = pg.createProdukt("Øl Bajer", "på flaske", 1);
		assertTrue(pg.getProdukter().contains(p));
	}

	@Test
	public void testCreateUdlejningsproduktTC01() {
		try {
			pg.createUdlejningsprodukt("Fadølsanlæg", "Det er bare godt", 1, 0);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Prisen skal være større end nul.", e.getMessage());
		}
	}

	@Test
	public void testCreateUdlejningsproduktTC02() {
		try {
			pg.createUdlejningsprodukt("Fadølsanlæg", "Det er bare godt", 1, 0);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Prisen skal være større end nul.", e.getMessage());
		}
	}

	@Test
	public void testCreateUdlejningsproduktTC03() {
		Udlejningsprodukt up = pg.createUdlejningsprodukt("Fadølsanlæg", "Det er bare godt", 1, 1);
		assertTrue(pg.getProdukter().contains(up));
	}

	@Test
	public void testCreateUdlejningsproduktTC04() {
		try {
			pg.createUdlejningsprodukt("Fadølsanlæg", "Det er bare godt", -1, 1);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Panten må ikke være under nul", e.getMessage());
		}
	}

	@Test
	public void testCreateUdlejningsproduktTC05() {
		Udlejningsprodukt up = pg.createUdlejningsprodukt("Fadølsanlæg", "Det er bare godt", 0, 1);
		assertTrue(pg.getProdukter().contains(up));
	}

}
