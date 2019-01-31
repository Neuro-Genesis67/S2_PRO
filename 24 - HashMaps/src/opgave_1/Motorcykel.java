package opgave_1;

public class Motorcykel {

	private String registreringsNummer;
	private String mærke;
	private String model;
	private String farve;

	public Motorcykel(String registeringsNummer, String mærke, String model, String farve) {
		this.registreringsNummer = registeringsNummer;
		this.mærke = mærke;
		this.model = model;
		this.farve = farve;
	}

	public String getRegistreringsNummer() {
		return registreringsNummer;
	}

	public void setRegistreringsNummer(String registreringsNummer) {
		this.registreringsNummer = registreringsNummer;
	}

	public String getMærke() {
		return mærke;
	}

	public void setMærke(String mærke) {
		this.mærke = mærke;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFarve() {
		return farve;
	}

	public void setFarve(String farve) {
		this.farve = farve;
	}

	@Override
	public boolean equals(Object obj) {
		Motorcykel mc = (Motorcykel) obj;
		System.out.println("equals method returns: " + this.registreringsNummer.equals(mc.registreringsNummer)
				+ this.mærke.equals(mc.mærke));
		if (this.registreringsNummer.equals(mc.registreringsNummer) && this.mærke.equals(mc.mærke)) {
			return true;
		}
		return false;

	}

	@Override
	public int hashCode() {
		System.out.println(this.registreringsNummer.hashCode() / this.mærke.hashCode());
		return this.registreringsNummer.hashCode() / 205 * this.mærke.hashCode();
	}

	@Override
	public String toString() {
		return "\nReg: " + registreringsNummer + " | Mærke: " + mærke + " | Model: " + model + " | Farve: " + farve;
	}
}
