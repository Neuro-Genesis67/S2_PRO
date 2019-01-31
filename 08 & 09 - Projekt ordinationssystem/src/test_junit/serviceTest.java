package test_junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import ordination.DagligFast;
import ordination.DagligSkaev;
import ordination.Laegemiddel;
import ordination.PN;
import ordination.Patient;
import service.Service;

public class serviceTest {
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

	// - opretPnOrdination
	@Test
	public void tc1() {
		PN pn = Service.getService().opretPNOrdination(LocalDate.of(2000, 01, 05), LocalDate.of(2000, 01, 10), p1, l1,
				5.0);

		assertNotNull(pn);
		assertEquals(5.0, pn.getAntalEnheder(), 0.0);
		assertEquals(l1, pn.getLaegemiddel());
		assertEquals(p1, pn.getPatient());
		assertEquals(LocalDate.of(2000, 01, 05), pn.getStartDen());
		assertEquals(LocalDate.of(2000, 01, 10), pn.getSlutDen());
	}

	// - opretPnOrdination
	@Test(expected = IllegalArgumentException.class)
	public void tc2() {
		PN pn = Service.getService().opretPNOrdination(LocalDate.of(2000, 02, 01), LocalDate.of(2000, 01, 01), p1, l1,
				5.0);

		assertNotNull(pn);
		assertEquals(5.0, pn.getAntalEnheder(), 0.0);
		assertEquals(l1, pn.getLaegemiddel());
		assertEquals(p1, pn.getPatient());
		assertEquals(LocalDate.of(2000, 02, 01), pn.getStartDen());
		assertEquals(LocalDate.of(2000, 01, 01), pn.getSlutDen());
	}

	// - opretPnOrdination
	@Test(expected = IllegalArgumentException.class)
	public void tc3() {
		PN pn = Service.getService().opretPNOrdination(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 02, 01), p1, l1,
				0.0);

		assertNotNull(pn);
		assertEquals(0.0, pn.getAntalEnheder(), 0.0);
		assertEquals(l1, pn.getLaegemiddel());
		assertEquals(p1, pn.getPatient());
		assertEquals(LocalDate.of(2000, 01, 01), pn.getStartDen());
		assertEquals(LocalDate.of(2000, 02, 01), pn.getSlutDen());
	}

	// --------------------------------------------------------------------------------------

	
	//Opret daglig fast
	@Test(expected = IllegalArgumentException.class)
	public void tc4() {
		DagligFast df = Service.getService().opretDagligFastOrdination(LocalDate.of(2000, 02, 01),
				LocalDate.of(2000, 01, 01), p1, l1, 2, 2, 2, 2);

		assertNotNull(df);
		assertEquals(8.0, df.doegnDosis(), 0.0);
		assertEquals(l1, df.getLaegemiddel());
		assertEquals(p1, df.getPatient());
		assertEquals(LocalDate.of(2000, 01, 01), df.getStartDen());
		assertEquals(LocalDate.of(2000, 02, 01), df.getSlutDen());
	}

	@Test
	public void tc5() {
		DagligFast df = Service.getService().opretDagligFastOrdination(LocalDate.of(2000, 01, 01),
				LocalDate.of(2000, 02, 01), p1, l1, 2, 2, 2, 2);

		assertNotNull(df);
		assertEquals(8.0, df.doegnDosis(), 0.0);
		assertEquals(l1, df.getLaegemiddel());
		assertEquals(p1, df.getPatient());
		assertEquals(LocalDate.of(2000, 01, 01), df.getStartDen());
		assertEquals(LocalDate.of(2000, 02, 01), df.getSlutDen());
	}

	@Test
	public void tc6() {
		DagligFast df = Service.getService().opretDagligFastOrdination(LocalDate.of(2000, 01, 01),
				LocalDate.of(2000, 02, 01), p1, l1, 2, 0, 2, 0);

		assertNotNull(df);
		assertEquals(4.0, df.doegnDosis(), 0.0);
		assertEquals(l1, df.getLaegemiddel());
		assertEquals(p1, df.getPatient());
		assertEquals(LocalDate.of(2000, 01, 01), df.getStartDen());
		assertEquals(LocalDate.of(2000, 02, 01), df.getSlutDen());
	}

	// --------------------------------------------------------------------------------------

	@Test(expected = IllegalArgumentException.class)
	public void tc7() {
		LocalTime[] tidspunkter = { LocalTime.of(10, 00), LocalTime.of(12, 00), LocalTime.of(14, 00),
				LocalTime.of(16, 00) };
		double[] enheder1 = { 2, 2, 2, 2 };

		
		DagligSkaev ds = Service.getService().opretDagligSkaevOrdination(LocalDate.of(2000, 02, 01),
				LocalDate.of(2000, 01, 01), p1, l1, tidspunkter, enheder1);

		assertNotNull(ds);
		assertEquals(8.0, ds.doegnDosis(), 0.0);
		assertEquals(l1, ds.getLaegemiddel());
		assertEquals(p1, ds.getPatient());
		assertEquals(LocalDate.of(2000, 02, 01), ds.getStartDen());
		assertEquals(LocalDate.of(2000, 01, 01), ds.getSlutDen());
	}
	
	@Test
	public void tc8() {
		LocalTime[] tidspunkter = { LocalTime.of(10, 00), LocalTime.of(12, 00), LocalTime.of(14, 00),
				LocalTime.of(16, 00) };
		double[] enheder1 = { 2, 2, 2, 2 };

		
		DagligSkaev ds = Service.getService().opretDagligSkaevOrdination(LocalDate.of(2000, 01, 01),
				LocalDate.of(2000, 02, 01), p1, l1, tidspunkter, enheder1);

		assertNotNull(ds);
		assertEquals(8.0, ds.doegnDosis(), 0.0);
		assertEquals(l1, ds.getLaegemiddel());
		assertEquals(p1, ds.getPatient());
		assertEquals(LocalDate.of(2000, 01, 01), ds.getStartDen());
		assertEquals(LocalDate.of(2000, 02, 01), ds.getSlutDen());
	}
	
	@Test
	public void tc9() {
		LocalTime[] tidspunkter = { LocalTime.of(10, 00), LocalTime.of(12, 00), LocalTime.of(14, 00),
				LocalTime.of(16, 00) };
		double[] enheder1 = { 2, 0, 2, 0};

		
		DagligSkaev ds = Service.getService().opretDagligSkaevOrdination(LocalDate.of(2000, 01, 01),
				LocalDate.of(2000, 02, 01), p1, l1, tidspunkter, enheder1);

		assertNotNull(ds);
		assertEquals(4.0, ds.doegnDosis(), 0.0);
		assertEquals(l1, ds.getLaegemiddel());
		assertEquals(p1, ds.getPatient());
		assertEquals(LocalDate.of(2000, 01, 01), ds.getStartDen());
		assertEquals(LocalDate.of(2000, 02, 01), ds.getSlutDen());
	}

	// --------------------------------------------------------------------------------------

	// Test af metode anbefaletDosisPrDoegn
	@Test
	public void tc10() {
		double anbefaletDosis = Service.getService().anbefaletDosisPrDoegn(p1, l1);
		assertEquals(95.1, anbefaletDosis,0.0);
	}
	
	@Test
	public void tc11() {

		double anbefaletDosis = Service.getService().anbefaletDosisPrDoegn(p2, l1);
		assertEquals(260, anbefaletDosis,0.0);
	}
	
	@Test
	public void tc12() {

		double anbefaletDosis = Service.getService().anbefaletDosisPrDoegn(p3, l1);
		assertEquals(124.8, anbefaletDosis,0.0001);
	}
	
	// --------------------------------------------------------------------------------------

	// Test af metode antalOrdinationerPrvaegtPrLaegemiddel
	
	@Test
	public void tc13() {
		double antalOrdinationer = Service.getService().antalOrdinationerPrVægtPrLægemiddel(70, 90, l1);
		assertEquals(1,antalOrdinationer, 0.0001);
	}
	
	@Test
	public void tc14() {
		double antalOrdinationer = Service.getService().antalOrdinationerPrVægtPrLægemiddel(60, 150, l1);
		assertEquals(3,antalOrdinationer, 0.0);
	}
	
	// --------------------------------------------------------------------------------------

	// Test af metode ordinationPNanvendt
	
	@Test
	public void tc15() {
	
		Service.getService().ordinationPNAnvendt(pn, LocalDate.of(2000, 01, 15));
		Service.getService().ordinationPNAnvendt(pn, LocalDate.of(2000, 01, 16));
		Service.getService().ordinationPNAnvendt(pn, LocalDate.of(2000, 01, 17));
		Service.getService().ordinationPNAnvendt(pn, LocalDate.of(2000, 01, 18));

		assertEquals( LocalDate.of(2000, 01, 15), pn.getDageGivet().get(0));
		assertEquals( LocalDate.of(2000, 01, 16), pn.getDageGivet().get(1));
		assertEquals( LocalDate.of(2000, 01, 17), pn.getDageGivet().get(2));
		assertEquals( LocalDate.of(2000, 01, 18), pn.getDageGivet().get(3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tc16() {
		
		Service.getService().ordinationPNAnvendt(pn, LocalDate.of(2000, 03, 15));
	

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tc17() {
		
		Service.getService().ordinationPNAnvendt(pn, LocalDate.of(1999, 05, 15));
	

	}
}
