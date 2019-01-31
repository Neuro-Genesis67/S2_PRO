// Not tested yet
package test_junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ordination.DagligFast;
import ordination.Laegemiddel;
import ordination.Patient;
import service.Service;

public class DagligFastTest {
	Patient p;
	Laegemiddel l;

	@Before
	public void SetUp() {

		p = Service.getService().opretPatient("121256-0512", "Jane Jensen", 63.4);
		l = Service.getService().opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");

	}

	@Test
	public void TC1_Daglig_samletDosis() {

		// enheder != null - Forventet resultat = 56
		DagligFast df = new DagligFast(LocalDate.parse("2018-09-10"), LocalDate.parse("2018-09-13"), p, l, 2, 3, 4, 5);
		assertEquals(56, df.samletDosis(), 0.001);

		assertNotNull(df);
		assertEquals(l, df.getLaegemiddel());
		assertEquals(p, df.getPatient());
		assertEquals(LocalDate.of(2018, 9, 10), df.getStartDen());
		assertEquals(LocalDate.of(2018, 9, 13), df.getSlutDen());

	}

	@Test
	public void TC2_Daglig_samletDosis() {

		// enheder != null - Forventet resultat = 8
		DagligFast df = new DagligFast(LocalDate.parse("2018-09-10"), LocalDate.parse("2018-09-10"), p, l, 2, 2, 2, 2);
		assertEquals(8, df.samletDosis(), 0.001);

		assertNotNull(df);
		assertEquals(l, df.getLaegemiddel());
		assertEquals(p, df.getPatient());
		assertEquals(LocalDate.of(2018, 9, 10), df.getStartDen());
		assertEquals(LocalDate.of(2018, 9, 10), df.getSlutDen());

	}

	@Test
	public void TC1_Daglig_doegnDosis() {

		// enheder != null - Forventet resultat = 14
		DagligFast df = new DagligFast(LocalDate.parse("2018-09-10"), LocalDate.parse("2018-09-10"), p, l, 2, 3, 4, 5);
		assertEquals(14, df.doegnDosis(), 0.001);

		assertNotNull(df);
		assertEquals(l, df.getLaegemiddel());
		assertEquals(p, df.getPatient());
		assertEquals(LocalDate.of(2018, 9, 10), df.getStartDen());
		assertEquals(LocalDate.of(2018, 9, 10), df.getSlutDen());

	}

	@Test
	public void TC2_Daglig_doesgnDosis() {

		// // enheder != null - Forventet resultat = 8
		DagligFast df = new DagligFast(LocalDate.parse("2018-09-10"), LocalDate.parse("2018-09-10"), p, l, 2, 2, 2, 2);
		assertEquals(8, df.doegnDosis(), 0.001);

		assertNotNull(df);
		assertEquals(l, df.getLaegemiddel());
		assertEquals(p, df.getPatient());
		assertEquals(LocalDate.of(2018, 9, 10), df.getStartDen());
		assertEquals(LocalDate.of(2018, 9, 10), df.getSlutDen());
	}

}
