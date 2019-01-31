package test_junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import ordination.DagligSkaev;
import ordination.Laegemiddel;
import ordination.Patient;
import service.Service;

public class DagligSkaevTest {

	Patient p;
	Laegemiddel l;

	@Before
	public void SetUp() {

		p = Service.getService().opretPatient("121256-0512", "Jane Jensen", 63.4);
		l = Service.getService().opretLaegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");

	}

	@Test
	public void TC1_DagligSkaev_opretDosis() {

		// Forventes oprettet uden fejl.

		double[] antalEnheder = { 5.0, 5.0 };
		LocalTime[] tidspunkter = { LocalTime.of(12, 00), LocalTime.of(18, 00) };

		DagligSkaev ds = new DagligSkaev(LocalDate.parse("2018-09-10"), LocalDate.parse("2018-09-13"), p, l,
				tidspunkter, antalEnheder);

		assertNotNull(ds);
		assertEquals(10, ds.doegnDosis(), 0.0);
		assertEquals(l, ds.getLaegemiddel());
		assertEquals(p, ds.getPatient());
		assertEquals(LocalDate.of(2018, 9, 10), ds.getStartDen());
		assertEquals(LocalDate.of(2018, 9, 13), ds.getSlutDen());

	}

	@Test(expected = DateTimeException.class)
	public void TC2_DagligSkaev_opretDosis() {

		// Ugyldigt tidspunkt: fejl ved oprettelse forventes.

		double[] antalEnheder = { 5.0, 5.0, 5.0 };
		LocalTime[] tidspunkter = { LocalTime.of(12, 00), LocalTime.of(18, 00), LocalTime.of(25, 00) };

		DagligSkaev ds = new DagligSkaev(LocalDate.parse("2018-09-10"), LocalDate.parse("2018-09-13"), p, l,
				tidspunkter, antalEnheder);
		assertNotNull(ds);
		assertEquals(l, ds.getLaegemiddel());
		assertEquals(p, ds.getPatient());
		assertEquals(LocalDate.of(2018, 9, 10), ds.getStartDen());
		assertEquals(LocalDate.of(2018, 9, 13), ds.getSlutDen());
	}

	@Test
	public void TC1_DagligSkaev_samletDosis() {

		// Forventet resultat: 40

		double[] antalEnheder = { 5.0, 5.0 };
		LocalTime[] tidspunkter = { LocalTime.of(12, 00), LocalTime.of(18, 00) };

		DagligSkaev ds = new DagligSkaev(LocalDate.parse("2018-09-10"), LocalDate.parse("2018-09-13"), p, l,
				tidspunkter, antalEnheder);

		assertEquals(40, ds.samletDosis(), 0.001);
		assertNotNull(ds);
		assertEquals(l, ds.getLaegemiddel());
		assertEquals(p, ds.getPatient());
		assertEquals(LocalDate.of(2018, 9, 10), ds.getStartDen());
		assertEquals(LocalDate.of(2018, 9, 13), ds.getSlutDen());
	}

	@Test
	public void TC2_DagligSkaev_samletDosis() {

		// Forventet resultat: 10

		double[] antalEnheder = { 5.0, 5.0 };
		LocalTime[] tidspunkter = { LocalTime.of(12, 00), LocalTime.of(18, 00) };

		DagligSkaev ds = new DagligSkaev(LocalDate.parse("2018-09-10"), LocalDate.parse("2018-09-10"), p, l,
				tidspunkter, antalEnheder);

		assertEquals(10, ds.samletDosis(), 0.001);

		assertNotNull(ds);
		assertEquals(l, ds.getLaegemiddel());
		assertEquals(p, ds.getPatient());
		assertEquals(LocalDate.of(2018, 9, 10), ds.getStartDen());
		assertEquals(LocalDate.of(2018, 9, 10), ds.getSlutDen());
	}

	@Test
	public void TC1_DagligSkaev_doegnDosis() {

		// Forventet resultat: 10

		double[] antalEnheder = { 5.0, 5.0 };
		LocalTime[] tidspunkter = { LocalTime.of(12, 00), LocalTime.of(18, 00) };

		DagligSkaev ds = new DagligSkaev(LocalDate.parse("2018-09-10"), LocalDate.parse("2018-09-13"), p, l,
				tidspunkter, antalEnheder);

		assertEquals(10, ds.doegnDosis(), 0.001);

		assertNotNull(ds);
		assertEquals(l, ds.getLaegemiddel());
		assertEquals(p, ds.getPatient());
		assertEquals(LocalDate.of(2018, 9, 10), ds.getStartDen());
		assertEquals(LocalDate.of(2018, 9, 13), ds.getSlutDen());
	}

	@Test
	public void TC2_DagligSkaev_doegnDosis() {

		// Forventet resultat: 10

		double[] antalEnheder = { 5.0, 5.0 };
		LocalTime[] tidspunkter = { LocalTime.of(12, 00), LocalTime.of(18, 00) };

		DagligSkaev ds = new DagligSkaev(LocalDate.parse("2018-09-10"), LocalDate.parse("2018-09-10"), p, l,
				tidspunkter, antalEnheder);

		assertEquals(10, ds.samletDosis(), 0.001);

		assertNotNull(ds);
		assertEquals(l, ds.getLaegemiddel());
		assertEquals(p, ds.getPatient());
		assertEquals(LocalDate.of(2018, 9, 10), ds.getStartDen());
		assertEquals(LocalDate.of(2018, 9, 10), ds.getSlutDen());
	}

	@Test
	public void TC1_DagligSkaev_getType() {

		// Forventet resultat: "Daglig skæv"

		double[] antalEnheder = { 5.0, 5.0 };
		LocalTime[] tidspunkter = { LocalTime.of(12, 00), LocalTime.of(18, 00) };

		DagligSkaev ds = new DagligSkaev(LocalDate.parse("2018-09-10"), LocalDate.parse("2018-09-13"), p, l,
				tidspunkter, antalEnheder);
		assertEquals("Daglig skæv", ds.getType());

		assertNotNull(ds);
		assertEquals(l, ds.getLaegemiddel());
		assertEquals(p, ds.getPatient());
		assertEquals(LocalDate.of(2018, 9, 10), ds.getStartDen());
		assertEquals(LocalDate.of(2018, 9, 13), ds.getSlutDen());

	}
}
