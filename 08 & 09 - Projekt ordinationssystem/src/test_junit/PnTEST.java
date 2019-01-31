package test_junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ordination.Laegemiddel;
import ordination.PN;
import ordination.Patient;
import service.Service;

public class PnTEST {

	Patient p1, p2, p3;
	Laegemiddel l1, l2;
	PN pn, pn2;

	@Before
	public void setUp() throws Exception {

		p1 = Service.getService().opretPatient("121256-0512", "Jane Jensen", 63.4);
		p2 = Service.getService().opretPatient("050972-1233", "Hans Jørgensen", 130);
		p3 = Service.getService().opretPatient("070985-1153", "Finn Madsen", 83.2);

		l1 = Service.getService().opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
		l2 = Service.getService().opretLaegemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk");

		pn = Service.getService().opretPNOrdination(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 02, 01), p1, l1,
				5.0);
		pn2 = Service.getService().opretPNOrdination(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 02, 01), p2, l1,
				5.0);
		pn2 = Service.getService().opretPNOrdination(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 02, 01), p3, l1,
				5.0);
	}

	@Test
	// givDosis()
	public void tc1() {
		PN pn = new PN(LocalDate.of(2018, 9, 10), LocalDate.of(2018, 9, 13), p1, l1, 5);
		assertTrue(pn.givDosis(LocalDate.of(2018, 9, 1)));
	}

	@Test
	// doegnDosis()
	public void tc2() {
		PN pn = new PN(LocalDate.of(2018, 9, 10), LocalDate.of(2018, 9, 13), p1, l1, 5);
		pn.givDosis(LocalDate.of(2018, 9, 11));
		pn.givDosis(LocalDate.of(2018, 9, 13));
		assertEquals(3.33, pn.doegnDosis(), 0.01);
	}

	@Test
	// doegnDosis()
	public void tc3() {
		PN pn = new PN(LocalDate.of(2018, 9, 10), LocalDate.of(2018, 9, 10), p1, l1, 5);
		pn.givDosis(LocalDate.of(2018, 9, 10));
		assertEquals(5, pn.doegnDosis(), 0.01);
	}

	// ------- samletDosis()-------

	@Test
	// samletDosis()
	public void tc4() {
		PN pn = new PN(LocalDate.of(2018, 9, 10), LocalDate.of(2018, 9, 13), p1, l1, 5);
		pn.givDosis(LocalDate.of(2018, 9, 11));
		pn.givDosis(LocalDate.of(2018, 9, 13));
		assertEquals(10, pn.samletDosis(), 0.01);
	}

	@Test
	// smaletDosis()
	public void tc5() {
		PN pn = new PN(LocalDate.of(2018, 9, 10), LocalDate.of(2018, 9, 10), p1, l1, 5);
		pn.givDosis(LocalDate.of(2018, 9, 10));
		assertEquals(5, pn.samletDosis(), 0.01);
	}

}
