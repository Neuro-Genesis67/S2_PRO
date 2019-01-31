package opgave_5_Trees;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DrawTrees extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("DrawTrees");
		Pane pane = new Pane();

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private void plantTree() {

	}

	private void drawTree(double x0, double y0, double len, double angle) {

	}

}

// Opgave 5I denne opgave skal du lave et JavaFX-program der tegner er træ som
// følger:
// Bemærk, at der er kun behov for at tegne streger. Hent inspiration i
// Workshop-noten fra 1. semester
// til hvordan man tegner streger i et vindue.Den rekursive drawTree-metode har
// følgende signatur:
// private void drawTree(doublex0, doubley0, doublelen, doubleangle)
// De første to parametre er start-position for en streg, tredje parameter er
// længden, og sidste parameter er vinklen mod jorden.
// Man starter tegningen ved fx at kalde drawTree(300, 350, 100, 90),
// dvs. at man tegner enstregfra punktet(300,350) med længde 100 i en vinkel på
// 90 grader fra jordenog op.
// Rekursionstrinet går ud på at tegne to nye streger med begyndelse hvor den
// oprindelige streg slutter.
// De to nye streger skal være kortere (fx 75% og 68%) end den forrige,
// og tegnes med vinkler der er forskudt til hver side af den forrige vinkel. k
// De to streger der kommer efter den første streg er på billedetforskudt med
// vinklerne 30 og -50grader.
// Hvad kunne termineringsreglen for denne rekursion være?Hint:En oplagtmåde at
// beregne slutkoordinater for en streg på,
// givet en vinkel angle, er følgende:doublex1= x0+ len*
// Math.cos(Math.toRadians(angle));
// doubley1= y0-len* Math.sin(Math.toRadians(angle));
// Ekstra opgaver, hvis du er blevet færdig med resten:
// Indfør blade på træet, når terminerings-kriteriet bliver nået.
// Indfør skiftende farver på grenene, efter antal rekursioner.
