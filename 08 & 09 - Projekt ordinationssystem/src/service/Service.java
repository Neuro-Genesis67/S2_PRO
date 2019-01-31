package service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import ordination.DagligFast;
import ordination.DagligSkaev;
import ordination.Laegemiddel;
import ordination.Ordination;
import ordination.PN;
import ordination.Patient;
import storage.Storage;

public class Service {
	private Storage storage;
	private static Service service;

	private Service() {
		storage = new Storage();
	}

	public static Service getService() {
		if (service == null) {
			service = new Service();
		}
		return service;
	}

	public static Service getTestService() {
		return new Service();
	}

	/**
	 * Hvis startDato er efter slutDato kastes en IllegalArgumentException og
	 * ordinationen oprettes ikke Pre: startDen, slutDen, patient og laegemiddel er
	 * ikke null
	 *
	 * @return opretter og returnerer en PN ordination.
	 */
	public PN opretPNOrdination(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
			double antal) {
		if (getService().checkStartFoerSlut(startDen, slutDen) && antal > 0.0) {
			PN pn = new PN(startDen, slutDen, patient, laegemiddel, antal);
			patient.addOrdination(pn);
			return pn;
		} else {
			throw new IllegalArgumentException("startdato er efter slutdato");
		}
	}

	/**
	 * Opretter og returnerer en DagligFast ordination. Hvis startDato er efter
	 * slutDato kastes en IllegalArgumentException og ordinationen oprettes ikke
	 * Pre: startDen, slutDen, patient og laegemiddel er ikke null
	 */
	public DagligFast opretDagligFastOrdination(LocalDate startDen, LocalDate slutDen, Patient patient,
			Laegemiddel laegemiddel, double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
		if (patient == null || laegemiddel == null) {
			throw new IllegalArgumentException("Patient og Lægemiddel skal være valgt");
		}
		if (morgenAntal < 0 || middagAntal < 0 || aftenAntal < 0 || natAntal < 0) {
			throw new IllegalArgumentException("Skal være positiv");
		} else if (morgenAntal == 0 && middagAntal == 0 && aftenAntal == 0 && natAntal == 0) {
			throw new IllegalArgumentException("Der skal minimum gives 1 stk.");
		} else {
			if (getService().checkStartFoerSlut(startDen, slutDen)) {
				DagligFast df = new DagligFast(startDen, slutDen, patient, laegemiddel, morgenAntal, middagAntal,
						aftenAntal, natAntal);
				patient.addOrdination(df);
				return df;
			} else {
				throw new IllegalArgumentException("startdato er efter slutdato");
			}
		}

	}

	/**
	 * Opretter og returnerer en DagligSkæv ordination. Hvis startDato er efter
	 * slutDato kastes en IllegalArgumentException og ordinationen oprettes ikke.
	 * Hvis antallet af elementer i klokkeSlet og antalEnheder er forskellige kastes
	 * også en IllegalArgumentException.
	 *
	 * Pre: startDen, slutDen, patient og laegemiddel er ikke null
	 */
	public DagligSkaev opretDagligSkaevOrdination(LocalDate startDen, LocalDate slutDen, Patient patient,
			Laegemiddel laegemiddel, LocalTime[] klokkeSlet, double[] antalEnheder) {
		if (patient == null || laegemiddel == null) {
			throw new IllegalArgumentException("Patient og lægemiddel skal være valgt");
		} else {
			if (getService().checkStartFoerSlut(startDen, slutDen) && klokkeSlet.length == antalEnheder.length) {
				DagligSkaev ds = new DagligSkaev(startDen, slutDen, patient, laegemiddel, klokkeSlet, antalEnheder);
				patient.addOrdination(ds);
				return ds;
			} else {
				throw new IllegalArgumentException("Antallet af elementer i klokkeSlet og antalEnheder er forskellig"
						+ " eller startdato er efter slutdato");
			}
		}
	}

	/**
	 * En dato for hvornår ordinationen anvendes tilføjes ordinationen. Hvis datoen
	 * ikke er indenfor ordinationens gyldighedsperiode kastes en
	 * IllegalArgumentException Pre: ordination og dato er ikke null
	 */
	public void ordinationPNAnvendt(PN ordination, LocalDate dato) {
		if (ordination == null) {
			throw new IllegalArgumentException("Ordination skal være udflydt");
		} else {
			if (dato.isAfter(ordination.getStartDen().minusDays(1))
					&& dato.isBefore(ordination.getSlutDen().plusDays(1))) {
				ordination.givDosis(dato);
			} else {
				throw new IllegalArgumentException("Ikke indenfor gyldighedsperiode");
			}
		}
	}

	/**
	 * Den anbefalede dosis for den pågældende patient (der skal tages hensyn til
	 * patientens vægt). Det er en forskellig enheds faktor der skal anvendes, og
	 * den er afhængig af patientens vægt. Pre: patient og lægemiddel er ikke null
	 */
	public double anbefaletDosisPrDoegn(Patient patient, Laegemiddel laegemiddel) {
		double result;
		if (patient.getVaegt() < 25) {
			result = patient.getVaegt() * laegemiddel.getEnhedPrKgPrDoegnLet();
		} else if (patient.getVaegt() > 120) {
			result = patient.getVaegt() * laegemiddel.getEnhedPrKgPrDoegnTung();
		} else {
			result = patient.getVaegt() * laegemiddel.getEnhedPrKgPrDoegnNormal();
		}
		return result;
	}

	/**
	 * For et givent vægtinterval og et givent lægemiddel, hentes antallet af
	 * ordinationer. Pre: laegemiddel er ikke null
	 */
	public int antalOrdinationerPrVægtPrLægemiddel(double vægtStart, double vægtSlut, Laegemiddel laegemiddel) {
		int result = 0;

		for (Patient p : storage.getAllPatienter()) {
			for (Ordination o : p.getOrdinationer()) {
				if (o.getLaegemiddel().equals(laegemiddel)) {
					if (p.getVaegt() >= vægtStart && p.getVaegt() <= vægtSlut) {
						result++;
					}
				}
			}
		}
		return result;

	}

	public List<Patient> getAllPatienter() {
		return storage.getAllPatienter();
	}

	public List<Laegemiddel> getAllLaegemidler() {
		return storage.getAllLaegemidler();
	}

	/**
	 * Metode der kan bruges til at checke at en startDato ligger før en slutDato.
	 *
	 * @return true hvis startDato er før slutDato, false ellers.
	 */
	private boolean checkStartFoerSlut(LocalDate startDato, LocalDate slutDato) {
		boolean result = true;
		if (slutDato.compareTo(startDato) < 0) {
			result = false;
		}
		return result;
	}

	public Patient opretPatient(String cpr, String navn, double vaegt) {
		Patient p = new Patient(cpr, navn, vaegt);
		storage.addPatient(p);
		return p;
	}

	public Laegemiddel opretLaegemiddel(String navn, double enhedPrKgPrDoegnLet, double enhedPrKgPrDoegnNormal,
			double enhedPrKgPrDoegnTung, String enhed) {
		Laegemiddel lm = new Laegemiddel(navn, enhedPrKgPrDoegnLet, enhedPrKgPrDoegnNormal, enhedPrKgPrDoegnTung,
				enhed);
		storage.addLaegemiddel(lm);
		return lm;
	}

	public void createSomeObjects() {
		opretPatient("121256-0512", "Jane Jensen", 63.4);
		opretPatient("070985-1153", "Finn Madsen", 83.2);
		opretPatient("050972-1233", "Hans Jørgensen", 89.4);
		opretPatient("011064-1522", "Ulla Nielsen", 59.9);
		opretPatient("090149-2529", "Ib Hansen", 87.7);

		opretLaegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
		opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
		opretLaegemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk");
		opretLaegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");

		opretPNOrdination(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 12, 12), storage.getAllPatienter().get(0),
				storage.getAllLaegemidler().get(1), 123);

		opretPNOrdination(LocalDate.of(2015, 2, 12), LocalDate.of(2015, 2, 14), storage.getAllPatienter().get(0),
				storage.getAllLaegemidler().get(0), 3);

		opretPNOrdination(LocalDate.of(2015, 1, 20), LocalDate.of(2015, 1, 25), storage.getAllPatienter().get(3),
				storage.getAllLaegemidler().get(2), 5);

		opretPNOrdination(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 1, 12), storage.getAllPatienter().get(0),
				storage.getAllLaegemidler().get(1), 123);

		opretDagligFastOrdination(LocalDate.of(2015, 1, 10), LocalDate.of(2015, 1, 12),
				storage.getAllPatienter().get(1), storage.getAllLaegemidler().get(1), 2, 1, 1, 1);

		LocalTime[] kl = { LocalTime.of(12, 0), LocalTime.of(12, 40), LocalTime.of(16, 0), LocalTime.of(18, 45) };
		double[] an = { 0.5, 1, 2.5, 3 };

		opretDagligSkaevOrdination(LocalDate.of(2015, 1, 23), LocalDate.of(2015, 1, 24),
				storage.getAllPatienter().get(1), storage.getAllLaegemidler().get(2), kl, an);
	}

}
