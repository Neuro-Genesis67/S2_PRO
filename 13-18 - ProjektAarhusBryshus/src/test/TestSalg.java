package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Betalingsmetode;
import model.Listepris;
import model.Prisliste;
import model.Produkt;
import model.Produktgruppe;
import model.Salg;
import model.Salgslinie;

public class TestSalg {

	private Salg salg;
	private Listepris listepris;

	@Before
	public void setUp() {
		Produktgruppe produktgruppe = new Produktgruppe("Flasker", "De er lavet af glas");
		Produkt produkt = produktgruppe.createProdukt("Øl", "Den smager", 10);
		Prisliste pl = new Prisliste("testliste", "beskrivelse");
		listepris = pl.createListepris(produkt, 20);
		salg = new Salg();
	}

	@Test
	public void testGetDato() {
		assertEquals(LocalDate.now(), salg.getDato());
	}

	@Test
	public void testCreateSalgslinieNegativetAntal() {
		try {
			salg.createSalgslinie(0, listepris);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			assertEquals(e.getMessage(), "Antallet skal være større end nul");
		}
	}

	@Test
	public void testCreateSalgslinieNotNull() {
		Salgslinie salgslinie = salg.createSalgslinie(1, listepris);
		assertNotNull(salgslinie);
	}

	@Test
	public void testRemoveSalgslinie() {
		Salgslinie s1 = salg.createSalgslinie(1, listepris);
		salg.removeSalgslinie(s1);
		assertFalse(salg.getSalgslinier().contains(s1));

	}

	@Test
	public void testSetBetalingsmetode() {
		salg.setBetalingsmetode(Betalingsmetode.DANKORT);
		assertEquals(Betalingsmetode.DANKORT, salg.getBetalingsmetode());
	}

	@Test
	public void testGetBetalingsmetode() {
		salg.setBetalingsmetode(Betalingsmetode.DANKORT);
		assertEquals(Betalingsmetode.DANKORT, salg.getBetalingsmetode());
	}

	@Test
	public void testBeregnSamletPris1() {
		salg.createSalgslinie(1, listepris);
		assertEquals(20, salg.beregnSamletPris(), 0.001);
	}

	@Test
	public void testBeregnSamletPris2() {
		try {
			listepris.setPris(0);
			salg.createSalgslinie(1, listepris);
		} catch (IllegalArgumentException e) {
			assertEquals("Prisen skal være større end nul", e.getMessage());
		}
	}

	@Test
	public void testBeregnSamletPris3() {
		try {
			listepris.setPris(-1);
			salg.createSalgslinie(1, listepris);
		} catch (IllegalArgumentException e) {
			assertEquals("Prisen skal være større end nul", e.getMessage());
		}
	}

	@Test
	public void testGetSamletAntalKlip1() {
		listepris.setKlippekortPris(1);
		salg.createSalgslinie(3, listepris);
		assertEquals(3, salg.getSamletAntalKlip());
	}

	@Test
	public void testGetSamletAntalKlip2() {
		listepris.setKlippekortPris(2);
		salg.createSalgslinie(3, listepris);
		assertEquals(6, salg.getSamletAntalKlip());
	}

	@Test
	public void testGetSamletAntalKlip3() {
		salg.createSalgslinie(3, listepris);
		assertEquals(0, salg.getSamletAntalKlip());
	}

	@Test
	public void testGetSamletRabat1() {
		listepris.setPris(36);
		Salgslinie s1 = salg.createSalgslinie(1, listepris);
		s1.rabatProcent(15);
		assertEquals(5.4, salg.getSamletRabat(), 0.001);
	}

	@Test
	public void testGetSamletRabat2() {
		listepris.setPris(36);
		Salgslinie s1 = salg.createSalgslinie(1, listepris);
		s1.rabatProcent(0);
		assertEquals(0, salg.getSamletRabat(), 0.001);
	}

	@Test
	public void testGetSamletRabat3() {
		listepris.setPris(36);
		Salgslinie s1 = salg.createSalgslinie(1, listepris);
		s1.rabatProcent(-10);
		assertEquals(-3.6, salg.getSamletRabat(), 0.001);
	}

	@Test
	public void testGetSalgsLinier() {
		ObservableList<Salgslinie> sler = FXCollections.observableArrayList();
		Salgslinie s1 = salg.createSalgslinie(1, listepris);
		sler.add(s1);
		assertEquals(sler, salg.getSalgslinier());
	}

	@Test
	public void testGetSalgsinformation1() {
		salg.createSalgslinie(1, listepris);
		assertEquals("Ordrebeskrivelse: " + "\n\t1 Øl, 20.0kr.", salg.getSalgsinformation());
	}

	@Test
	public void testToString1() {
		salg.createSalgslinie(2, listepris);
		assertEquals(LocalDate.now() + ", beløb: " + 40.0, salg.toString());
	}

}
