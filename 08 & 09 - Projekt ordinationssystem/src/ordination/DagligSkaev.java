package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

	private ArrayList<Dosis> doser = new ArrayList<>();

	public DagligSkaev(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
			LocalTime[] klokkeSlet, double[] antalEnheder) {
		super(startDen, slutDen, patient, laegemiddel);
		for (int i = 0; i < klokkeSlet.length; i++) {
			doser.add(opretDosis(klokkeSlet[i], antalEnheder[i]));
		}

	}

	public Dosis opretDosis(LocalTime klokkeSlet, double antal) {

		Dosis dosis = new Dosis(klokkeSlet, antal);

		return dosis;

	}

	@Override
	public double samletDosis() {
		return doegnDosis() * antalDage();
	}

	@Override
	public double doegnDosis() {

		double samledeDoser = 0.0;

		for (Dosis d : doser) {
			samledeDoser += d.getAntal();

		}

		return samledeDoser;
	}

	@Override
	public String getType() {

		return "Daglig skæv";
	}

	public ArrayList<Dosis> getDoser() {
		return doser;
	}

	public void addDosis(Dosis dosis) {
		doser.add(dosis);
	}

}
