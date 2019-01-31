package gui.Administration;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Produktgruppe;
import model.Sampakning;

class OpretProduktWindow extends Stage {
	private Controller controller = Controller.getInstance();
	private Produktgruppe produktgruppe;
	private TextField txfNavn, txfBeskrivelse, txfPris, txfPant;
	private Label lblPris;
	private Label lblPant;
	private RadioButton rbProdukt;
	private RadioButton rbUdlejning;
	private RadioButton rbSampak;
	private Button btnOpret;
	private VBox vbLeft4;
	private VBox vbRight;
	private Sampakning currSampak;

	OpretProduktWindow(Produktgruppe produktgruppe) {
		GridPane pane = new GridPane();
		Scene scene = new Scene(pane);
		this.produktgruppe = produktgruppe;

		initContent(pane);
		this.setMaximized(true);
		this.setScene(scene);
		this.setTitle("Opret produkt");
	}

	private void initContent(GridPane pane) {
		// pane.setGridLinesVisible(true);
		pane.setHgap(80);
		pane.setVgap(50);
		this.setMaximized(true);

		// Labels & TextFields
		Label lblOverskrift = new Label("Opret produkt");
		Label lblNavn = new Label("Navn: ");
		Label lblBeskrivelse = new Label("Beskrivelse: ");
		lblPris = new Label("Standardpris: ");
		lblPant = new Label("Pantbeløb: ");

		lblOverskrift.setPrefSize(600, 50);
		lblOverskrift.setStyle("-fx-font-size: 2.7em ;");
		lblNavn.setPrefSize(200, 50);
		lblNavn.setStyle("-fx-font-size: 2.5em ;");
		lblBeskrivelse.setPrefSize(200, 50);
		lblBeskrivelse.setStyle("-fx-font-size: 2.5em ;");
		lblPris.setPrefSize(200, 50);
		lblPris.setStyle("-fx-font-size: 2.5em ;");
		lblPant.setPrefSize(200, 50);
		lblPant.setStyle("-fx-font-size: 2.5em ;");

		txfNavn = new TextField();
		txfBeskrivelse = new TextField();
		txfPris = new TextField();
		txfPant = new TextField();

		txfNavn.setPrefSize(500, 50);
		txfNavn.setStyle("-fx-font-size: 2.5em ;");
		txfBeskrivelse.setPrefSize(500, 50);
		txfBeskrivelse.setStyle("-fx-font-size: 2.5em ;");
		txfPris.setPrefSize(500, 50);
		txfPris.setStyle("-fx-font-size: 2.5em ;");
		txfPant.setPrefSize(500, 50);
		txfPant.setStyle("-fx-font-size: 2.5em ;");

		// ComboBoxes
		ToggleGroup toggleGroup = new ToggleGroup();
		rbProdukt = new RadioButton("Opret produkt");
		rbUdlejning = new RadioButton("Opret Udlejningsprodukt");
		rbSampak = new RadioButton("Opret sampak");

		rbProdukt.setToggleGroup(toggleGroup);
		rbUdlejning.setToggleGroup(toggleGroup);
		rbSampak.setToggleGroup(toggleGroup);

		rbProdukt.setPrefSize(600, 65);
		rbProdukt.setFont(Font.font("Cambria", 35));
		rbUdlejning.setPrefSize(600, 65);
		rbUdlejning.setFont(Font.font("Cambria", 35));
		rbSampak.setPrefSize(600, 65);
		rbSampak.setFont(Font.font("Cambria", 35));


		if (produktgruppe == controller.getUdlejningsgruppe()) {
			rbProdukt.setDisable(true);
			rbSampak.setDisable(true);
			rbUdlejning.setSelected(true);
		} else if (produktgruppe == controller.getSampakninggruppe()) {
			rbProdukt.setDisable(true);
			rbUdlejning.setDisable(true);
			rbSampak.setSelected(true);
		} else {
			rbProdukt.setSelected(true);
			rbUdlejning.setDisable(true);
			rbSampak.setDisable(true);
		}

		toggleGroup.selectedToggleProperty().addListener(e -> choiceAction());

		// Boxes
		VBox vbTop = new VBox();
		VBox vbLeft = new VBox();
		VBox vbLeft1 = new VBox();
		VBox vbLeft2 = new VBox();
		VBox vbLeft3 = new VBox();
		vbLeft4 = new VBox();
		vbRight = new VBox();

		vbLeft.setSpacing(50);
		vbRight.setSpacing(110);

		vbTop.setAlignment(Pos.TOP_CENTER);
		vbLeft.setAlignment(Pos.CENTER_LEFT);
		vbRight.setAlignment(Pos.CENTER_RIGHT);

		vbTop.getChildren().add(rbProdukt);
		vbTop.getChildren().add(rbUdlejning);
		vbTop.getChildren().add(rbSampak);
		vbLeft.getChildren().add(vbLeft1);
		vbLeft1.getChildren().add(lblNavn);
		vbLeft1.getChildren().add(txfNavn);
		vbLeft.getChildren().add(vbLeft2);
		vbLeft2.getChildren().add(lblBeskrivelse);
		vbLeft2.getChildren().add(txfBeskrivelse);
		vbLeft.getChildren().add(vbLeft3);
		vbLeft.getChildren().add(vbLeft4);
		vbLeft3.getChildren().add(lblPris);
		vbLeft3.getChildren().add(txfPris);

		pane.setAlignment(Pos.CENTER);
		pane.add(vbTop, 1, 0);
		pane.add(vbLeft, 1, 1);
		pane.add(vbRight, 2, 1);

		// Creating and styling buttons
		btnOpret = new Button("Opret");
		Button btnAnnuller = new Button("Annuller");

		btnOpret.setPrefSize(300, 150);
		btnOpret.setStyle("-fx-font-size: 2.5em ;");
		btnAnnuller.setPrefSize(300, 150);
		btnAnnuller.setStyle("-fx-font-size: 2.5em ;");

		// Buttons

		// button størrelse, font m.m.
		vbRight.getChildren().add(btnOpret);
		vbRight.getChildren().add(btnAnnuller);

		pane.setAlignment(Pos.CENTER);

		btnAnnuller.setOnAction(event -> tilbageAction());

		this.choiceAction();

	}

	private void choiceAction() {
		if (rbProdukt.isSelected()) {
			if (vbLeft4.getChildren().contains(lblPant) && vbLeft4.getChildren().contains(txfPant)) {
				vbLeft4.getChildren().remove(lblPant);
				vbLeft4.getChildren().remove(txfPant);
			}

			btnOpret.setOnAction(event -> opretProduktAction(produktgruppe, txfNavn.getText(), txfBeskrivelse.getText(),
					txfPris.getText()));

			btnOpret.setText("Opret");
			lblPris.setText("Standardpris: ");

		} else if (rbUdlejning.isSelected()) {
			btnOpret.setText("Opret");

			if (!vbLeft4.getChildren().contains(lblPant) && !vbLeft4.getChildren().contains(txfPant)) {
				vbLeft4.getChildren().add(lblPant);
				vbLeft4.getChildren().add(txfPant);
			}
			btnOpret.setOnAction(e -> opretUdlejningsproduktAction(txfNavn.getText(), txfBeskrivelse.getText(),
					txfPant.getText(), txfPris.getText()));

		} else if (rbSampak.isSelected()) {
			if (vbLeft4.getChildren().contains(lblPant) && vbLeft4.getChildren().contains(txfPant)) {
				vbLeft4.getChildren().remove(lblPant);
				vbLeft4.getChildren().remove(txfPant);
			}
			Button btnBekraeft = new Button("Bekræft");
			vbRight.getChildren().add(btnBekraeft);
			btnBekraeft.setPrefSize(300, 150);
			btnBekraeft.setStyle("-fx-font-size: 2.5em ;");
			vbRight.setSpacing(50);

			btnOpret.setText("Tilføj produkter \ntil sampak");

			btnOpret.setOnAction(e -> opretSampakningAction(txfNavn.getText(), txfBeskrivelse.getText()));
			btnBekraeft.setOnAction(e -> actionBekraeftSampak(txfNavn.getText(), txfBeskrivelse.getText(), txfPris.getText()));

		}
	}

	private void tilbageAction() {
		if (currSampak != null) {
			controller.cancelSampak(currSampak);
		}
		close();
	}

	private void opretProduktAction(Produktgruppe produktgruppe, String navn, String beskrivelse, String pris) {
		try {
			controller.opretProdukt(produktgruppe, navn, beskrivelse, pris);
			close();

		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl i prisen");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl i information");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	private void opretUdlejningsproduktAction(String navn, String beskrivelse, String pant, String pris) {
		try {
			controller.opretUdlejningsprodukt(navn, beskrivelse, pant, pris);
			close();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl i panten");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl i information");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	private void opretSampakningAction(String navn, String beskrivelse) {
		try {
			if (currSampak == null) {
				currSampak = controller.opretSampakning(navn, beskrivelse);
			}

			TilføjProdukterTilSampakningWindow tilfoejProdukterTilSampakningWindow = new TilføjProdukterTilSampakningWindow(
					currSampak);

			tilfoejProdukterTilSampakningWindow.showAndWait();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl i pris");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl i information");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	private void actionBekraeftSampak(String navn, String beskrivelse, String prisString) {
		try {
			if (currSampak == null) {
				currSampak = controller.opretSampakning(navn, beskrivelse);
			}
			controller.bekraeftSampakning(currSampak, navn, beskrivelse, prisString);
			close();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl i prisen");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl i information");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}

	}
}
