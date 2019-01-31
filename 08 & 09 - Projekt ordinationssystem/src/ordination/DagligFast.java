package ordination;

// Alexander

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {

	private Dosis[] doser = new Dosis[4];

	public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
			double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
		super(startDen, slutDen, patient, laegemiddel);
		doser[0] = opretDosis(LocalTime.of(8, 0), morgenAntal);
		doser[1] = opretDosis(LocalTime.of(12, 0), middagAntal);
		doser[2] = opretDosis(LocalTime.of(18, 0), aftenAntal);
		doser[3] = opretDosis(LocalTime.of(21, 0), natAntal);
	}

	public Dosis opretDosis(LocalTime klokkeSlet, double antal) {
		Dosis dosis = new Dosis(klokkeSlet, antal);
		return dosis;

	}

	@Override
	public double samletDosis() {
		return (doser[0].getAntal() + doser[1].getAntal() + doser[2].getAntal() + doser[3].getAntal()) * antalDage();
	}

	@Override
	public double doegnDosis() {
		return samletDosis() / antalDage();

	}

	@Override
	public String getType() {
		return "Daglig Fast";
	}

	public Dosis[] getDoser() {
		return doser;
	}



}
