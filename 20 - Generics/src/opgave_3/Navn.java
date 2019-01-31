package opgave_3;

public class Navn implements Comparable<Navn> {

	private String fornavn;
	private String efternavn;

	public Navn(String fnavn, String eNavn) {
		this.fornavn = fnavn;
		this.efternavn = eNavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEfternavn() {
		return efternavn;
	}

	@Override
	public String toString() {
		return fornavn + " " + efternavn;
	}

	@Override
	public int compareTo(Navn o) {
		if (getFornavn().compareTo(o.getFornavn()) > 0) {
			return 1;
		} else if (getFornavn().compareTo(o.getFornavn()) < 0) {
			return -1;
		} else {

			if (getEfternavn().compareTo(o.getEfternavn()) > 0) {
				return 1;
			} else if (getEfternavn().compareTo(o.getEfternavn()) > 0) {
				return -1;
			} else {
				return 0;
			}
		}

	}
}