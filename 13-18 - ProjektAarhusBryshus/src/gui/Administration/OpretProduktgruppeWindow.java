package gui.Administration;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class OpretProduktgruppeWindow extends Stage {
	private Controller controller = Controller.getInstance();
	// private Produktgruppe produktgruppe;
	private TextField txfNavn, txfBeskrivelse;

	OpretProduktgruppeWindow() {
		GridPane pane = new GridPane();
		Scene scene = new Scene(pane);

		initContent(pane);
		this.setMaximized(true);
		this.setScene(scene);
		this.setTitle("Opret produktgruppe				");
	}

	private void initContent(GridPane pane) {
		pane.setHgap(80);
		pane.setVgap(50);

		// Creating Labels & TextFields

		Label lblOverskrift = new Label("Opret produktgruppe");
		Label lblNavn = new Label("Navn: ");
		Label lblBeskrivelse = new Label("Beskrivelse: ");
		txfNavn = new TextField();
		txfBeskrivelse = new TextField();

		// Styling Labels & TextFields

		lblOverskrift.setPrefSize(600, 50);
		lblOverskrift.setStyle("-fx-font-size: 2.7em ;");
		lblNavn.setPrefSize(200, 50);
		lblNavn.setStyle("-fx-font-size: 2.5em ;");
		lblBeskrivelse.setPrefSize(200, 50);
		lblBeskrivelse.setStyle("-fx-font-size: 2.5em ;");
		txfNavn.setPrefSize(500, 50);
		txfNavn.setStyle("-fx-font-size: 2.5em ;");
		txfBeskrivelse.setPrefSize(500, 50);
		txfBeskrivelse.setStyle("-fx-font-size: 2.5em ;");

		// Creating and styling buttons
		Button btnOpret = new Button("Opret");
		Button btnAnnuller = new Button("Annuller");
		btnOpret.setPrefSize(300, 150);
		btnAnnuller.setPrefSize(300, 150);
		btnOpret.setStyle("-fx-font-size: 2.5em ;");
		btnAnnuller.setStyle("-fx-font-size: 2.5em ;");

		// Creating, adding and filling VBoxes
		VBox vbTop = new VBox();
		VBox vbLeft = new VBox();
		VBox vbLeft1 = new VBox();
		VBox vbLeft2 = new VBox();
		VBox vbRight = new VBox();

		vbTop.setAlignment(Pos.TOP_CENTER);
		vbLeft.setAlignment(Pos.CENTER_LEFT);
		vbRight.setAlignment(Pos.BOTTOM_RIGHT);

		vbLeft.setSpacing(80);
		vbRight.setSpacing(50);

		pane.setAlignment(Pos.CENTER);
		pane.add(vbTop, 1, 0);
		pane.add(vbLeft, 1, 1);
		pane.add(vbRight, 2, 1);

		vbTop.getChildren().add(lblOverskrift);

		vbLeft.getChildren().add(vbLeft1);
		vbLeft.getChildren().add(vbLeft2);

		vbLeft1.getChildren().add(lblNavn);
		vbLeft1.getChildren().add(txfNavn);
		vbLeft2.getChildren().add(lblBeskrivelse);
		vbLeft2.getChildren().add(txfBeskrivelse);

		vbRight.getChildren().add(btnOpret);
		vbRight.getChildren().add(btnAnnuller);

		btnAnnuller.setOnAction(event -> annullerAction());
		btnOpret.setOnAction(event -> opretAction(txfNavn.getText(), txfBeskrivelse.getText()));
	}

	private void annullerAction() {
		close();
	}

	private void opretAction(String navn, String beskrivelse) {
		controller.opretProduktgruppe(navn, beskrivelse);
		close();
	}
}
