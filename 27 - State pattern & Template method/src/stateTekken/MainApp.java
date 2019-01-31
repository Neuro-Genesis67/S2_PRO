package stateTekken;

public class MainApp {

	public static void main(String[] args) {

		Fighter alisa = new Fighter("Alisa", 100);
		Fighter nina = new Fighter("Nina", 100);
		Match m = new Match(alisa, nina);
		m.startMatch();

	}

}
