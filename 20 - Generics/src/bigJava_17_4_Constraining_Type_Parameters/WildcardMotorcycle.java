package bigJava_17_4_Constraining_Type_Parameters;

public class WildcardMotorcycle {

	private String name;
	private int cc;
	private String difficulty;

	public WildcardMotorcycle(String name, int cc, String difficulty) {
		this.name = name;
		this.cc = cc;
		this.difficulty = difficulty;
	}

	@Override
	public String toString() {
		return "Bike: " + this.name + "\nCc: " + cc + "\nSuited for: " + difficulty;
	}
}
