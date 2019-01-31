package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination {

	private double antalEnheder;
	private static int antalDosis;

	private ArrayList<LocalDate> dageGivet = new ArrayList<>();

	/**
	 * Registrerer at der er givet en dosis paa dagen givesDen Returnerer true hvis
	 * givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
	 * Retrurner false ellers og datoen givesDen ignoreres
	 *
	 * @param givesDen
	 * @return
	 */

	public PN(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel, double antalEnheder) {
		super(startDen, slutDen, patient, laegemiddel);
		this.antalEnheder = antalEnheder;
		this.setPatient(patient);
	}

	public boolean givDosis(LocalDate givesDen) {
		dageGivet.add(givesDen);
		antalDosis++;
		return true;
	}

	@Override

	public double doegnDosis() {
		if (dageGivet.isEmpty()) {
			return 0.0;
		} else {
			LocalDate førsteGang = dageGivet.get(0);
			LocalDate sidsteGang = dageGivet.get(dageGivet.size() - 1);
			int dage = (int) ChronoUnit.DAYS.between(førsteGang, sidsteGang) + 1;
			return (antalEnheder * dageGivet.size()) / dage;
		}
	}

	@Override
	public double samletDosis() {
		return antalEnheder * dageGivet.size();
	}

	/**
	 * Returnerer antal gange ordinationen er anvendt
	 *
	 * @return
	 */
	public int getAntalGangeGivet() {
		return antalDosis;
	}

	public double getAntalEnheder() {
		return antalEnheder;
	}

	@Override
	public String getType() {
		return "PN";
	}

	public ArrayList<LocalDate> getDageGivet() {
		return dageGivet;
	}

}
