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
import model.Produkt;
import model.Produktgruppe;
import model.Sampakning;

class RedigerProduktWindow extends Stage {
	private Controller controller = Controller.getInstance();
	private Produkt produkt;
	private TextField txfNavn, txfBeskrivelse, txfPris, txfPant;
	private ListView<Produktgruppe> lvwProduktgruppe = new ListView<>();
	private ListView<Produkt> lvwProdukt = new ListView<>();
	private Produktgruppe gammelProduktgruppe;
	private Sampakning sampakBackup;

	RedigerProduktWindow(Produkt produkt, Produktgruppe produktgruppe) {
		this.gammelProduktgruppe = produktgruppe;
		GridPane pane = new GridPane();
		Scene scene = new Scene(pane);
		this.produkt = produkt;
		if (produkt instanceof Sampakning) {
			this.sampakBackup = controller.getBackup((Sampakning) produkt);
		}

		initContent(pane);
		this.setMaximized(true);
		this.setScene(scene);
		this.setTitle("Rediger produkt");

	}

	private void initContent(GridPane pane) {
		pane.setHgap(80);
		pane.setVgap(50);

		// Labels & TextFields
		Label lblOverskrift = new Label("Rediger produkt");
		Label lblTopLeft = new Label();
		Label lblNavn = new Label("Navn: ");
		Label lblBeskrivelse = new Label("Beskrivelse: ");
		Label lblPris = new Label("Standardpris: ");
		Label lblPant = new Label("Pantpris: ");

		lblOverskrift.setPrefSize(600, 50);
		lblOverskrift.setStyle("-fx-font-size: 2.7em ;");
		lblTopLeft.setPrefSize(400, 50);
		lblTopLeft.setFont(Font.font("Cambria", 35));
		lblNavn.setPrefSize(200, 50);
		lblNavn.setStyle("-fx-font-size: 2.5em ;");
		lblBeskrivelse.setPrefSize(200, 50);
		lblBeskrivelse.setStyle("-fx-font-size: 2.5em ;");
		lblPris.setPrefSize(200, 50);
		lblPris.setStyle("-fx-font-size: 2.5em ;");
		lblPant.setPrefSize(200, 50);
		lblPant.setStyle("-fx-font-size: 2.5em ;");

		txfNavn = new TextField(produkt.getNavn());
		txfBeskrivelse = new TextField(produkt.getBeskrivelse());
		txfPris = new TextField(String.valueOf(controller.getStandardPris(produkt)));
		txfPant = new TextField();

		txfNavn.setPrefSize(500, 50);
		txfNavn.setStyle("-fx-font-size: 2.5em ;");
		txfBeskrivelse.setPrefSize(500, 50);
		txfBeskrivelse.setStyle("-fx-font-size: 2.5em ;");
		txfPris.setPrefSize(500, 50);
		txfPris.setStyle("-fx-font-size: 2.5em ;");
		txfPant.setPrefSize(500, 50);
		txfPant.setStyle("-fx-font-size: 2.5em ;");


		// Button
		Button btnOpret = new Button("Bekræft\nændringer");
		Button btnAnnuller = new Button("Annuller");

		btnOpret.setPrefSize(300, 150);
		btnOpret.setStyle("-fx-font-size: 2.5em ;");
		btnAnnuller.setPrefSize(300, 150);
		btnAnnuller.setStyle("-fx-font-size: 2.5em ;");

		// Boxes
		VBox vbTop = new VBox();
		VBox vbLeft = new VBox();
		VBox vbCenter = new VBox();
		VBox vbCenter1 = new VBox();
		VBox vbCenter2 = new VBox();
		VBox vbCenter3 = new VBox();
		VBox vbRight = new VBox();
		VBox vbPant = new VBox();

		vbCenter.setSpacing(50);
		vbLeft.setSpacing(10);
		vbRight.setSpacing(110);

		vbTop.setAlignment(Pos.TOP_CENTER);
		vbCenter.setAlignment(Pos.CENTER_LEFT);
		vbRight.setAlignment(Pos.CENTER_RIGHT);

		vbTop.getChildren().add(lblOverskrift);
		vbLeft.getChildren().add(lblTopLeft);

		// ListView
		if (produkt instanceof Sampakning) {
			lblTopLeft.setText("Produkter i sampakningen:");
			lvwProdukt.setItems(controller.getSampakprodukter((Sampakning) produkt));
			lvwProdukt.setPrefSize(400, 700);
			lvwProdukt.setFixedCellSize(50);
			lvwProdukt.setStyle("-fx-font-size: 2.0em ;");
			vbLeft.getChildren().add(lvwProdukt);
			btnOpret.setOnAction(e -> actionBekraeftSampak());
		} else {
			lblTopLeft.setText("Vælg ny produktgruppe:");
			lvwProduktgruppe.getItems().addAll(controller.getProduktgrupper());
			lvwProduktgruppe.getItems().remove(controller.getSampakninggruppe());
			lvwProduktgruppe.setPrefSize(400, 700);
			lvwProduktgruppe.setFixedCellSize(50);
			lvwProduktgruppe.setStyle("-fx-font-size: 2.0em ;");
			lvwProduktgruppe.getSelectionModel().select(gammelProduktgruppe);
			btnOpret.setOnAction(event -> bekræftAction(produkt, txfNavn.getText(), txfBeskrivelse.getText(),
					txfPris.getText(), txfPant.getText(), gammelProduktgruppe,
					lvwProduktgruppe.getSelectionModel().getSelectedItem()));

			vbLeft.getChildren().add(lvwProduktgruppe);
		}

		vbCenter.getChildren().add(vbCenter1);
		vbCenter1.getChildren().add(lblNavn);
		vbCenter1.getChildren().add(txfNavn);
		vbCenter.getChildren().add(vbCenter2);
		vbCenter2.getChildren().add(lblBeskrivelse);
		vbCenter2.getChildren().add(txfBeskrivelse);
		vbCenter.getChildren().add(vbCenter3);
		vbCenter3.getChildren().add(lblPris);
		vbCenter3.getChildren().add(txfPris);
		if (gammelProduktgruppe.getNavn().equals("Udlejning")) {
			lblOverskrift.setText("Rediger udlejningsprodukt");
			lvwProduktgruppe.setDisable(true);
			vbCenter.getChildren().add(vbPant);
			vbPant.getChildren().add(lblPant);
			vbPant.getChildren().add(txfPant);
		}

		vbRight.getChildren().add(btnOpret);
		if (produkt instanceof Sampakning) {
			Button btnTilfoejProdukter = new Button("Vælg produkter");
			btnTilfoejProdukter.setPrefSize(300, 150);
			btnTilfoejProdukter.setStyle("-fx-font-size: 2.5em ;");
			vbRight.setSpacing(50);
			vbRight.getChildren().add(btnTilfoejProdukter);
			btnTilfoejProdukter.setOnAction(e -> actionVaelgProdukter());
		}
		vbRight.getChildren().add(btnAnnuller);

		pane.setAlignment(Pos.CENTER);
		pane.add(vbTop, 1, 0);
		pane.add(vbLeft, 0, 1);
		pane.add(vbCenter, 1, 1);
		pane.add(vbRight, 2, 1);

		// Labels & TextFields

		pane.setAlignment(Pos.CENTER);

		btnAnnuller.setOnAction(event -> AnnullerAction());

	}

	private void actionVaelgProdukter() {
		TilføjProdukterTilSampakningWindow window = new TilføjProdukterTilSampakningWindow((Sampakning) produkt);
		window.showAndWait();
	}

	private void AnnullerAction() {
		if (produkt instanceof Sampakning) {
			((Sampakning) produkt).setProdukter(controller.getSampakprodukter(sampakBackup));
		}
		close();
	}

	// den redigere dem, men listen bliver ikke opdateret i ProduktPane
	private void bekræftAction(Produkt produkt, String navn, String beskrivelse, String pris, String pant,
							   Produktgruppe gammelProduktgruppe, Produktgruppe nyProduktgruppe) {

		try {
			if (txfNavn.getText() != null && txfBeskrivelse.getText() != null && txfPris.getText() != null) {
				controller.redigerProdukt(produkt, navn, beskrivelse, pris, pant, gammelProduktgruppe, nyProduktgruppe);
				close();
			} else {
				Alert alert = new Alert(AlertType.ERROR, "Der skal udfyldes navn og beskrivelse.");
				alert.setHeaderText("Manglende information");
				alert.showAndWait();
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl i prisen");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	private void actionBekraeftSampak() {
		try {
			Sampakning sampak = (Sampakning) produkt;
			controller.bekraeftSampakning(sampak, txfNavn.getText(), txfBeskrivelse.getText(), txfPris.getText());
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
