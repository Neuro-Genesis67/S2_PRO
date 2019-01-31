package opgave2;

import java.util.ArrayList;

public class Skole {
	private String navn;
	private ArrayList<Studerende> arrStud = new ArrayList<>();

	public Skole(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return this.navn;
	}

	public void addStuderende(Studerende studerende) {
		arrStud.add(studerende);
	}

	public void removeStuderende(Studerende studerende) {
		arrStud.remove(studerende);
	}

	public double gennemsnit() {

		double gennemsnit = 0;
		int count = 0;

		for (Studerende s : arrStud) {
			for (Integer k : s.getKarakterer()) {
				gennemsnit += k;
				count++;
			}
		}
		return gennemsnit / count;
	}

	public Studerende findStuderende(int studieNr) {

		for (Studerende s : arrStud) {
			if (s.getStudieNr() == studieNr) {
				return s;
			}

		}
		return null;
	}

	@Override
	public String toString() {
		return "Skole: " + this.navn + "\n" + "Elever: " + "\n" + arrStud;
	}

}
