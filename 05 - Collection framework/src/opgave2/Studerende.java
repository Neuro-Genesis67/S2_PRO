package opgave2;

import java.util.ArrayList;
import java.util.List;

public class Studerende {

	private int studieNr;
	private String navn;
	private List<Integer> karakterer = new ArrayList<>();

	public Studerende(int studieNr, String navn, List karakterer) {
		this.studieNr = studieNr;
		this.navn = navn;
		this.karakterer = karakterer;
	}

	public int getStudieNr() {
		return this.studieNr;
	}

	public String getNavn() {
		return this.navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void addKarakter(int karakter) {
		karakterer.add(karakter);
	}

	public List<Integer> getKarakterer() {
		return karakterer;
	}

	public String toString() {
		return "\n" + "Navn: " + this.navn + "\n" + "StudieNr: " + this.studieNr + "\n";
	}
}
