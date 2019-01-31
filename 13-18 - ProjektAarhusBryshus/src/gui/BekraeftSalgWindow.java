package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Betalingsmetode;
import model.Salg;
import model.Udlejning;

public class BekraeftSalgWindow extends Stage {

	private Salg currSalg;
	private Controller controller = Controller.getInstance();
	private Boolean orderConfirmed = false;
	private ToggleGroup tgBetalingsmetoder;

	public BekraeftSalgWindow(Salg salg) {
		this.currSalg = salg;
		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane);
		gridPane.setPadding(new Insets(10));
		this.setMaximized(true);
		this.setScene(scene);
		this.initGridpane(gridPane);
		this.setTitle("Bekræft venligst oprettelsen");
	}

	private void initGridpane(GridPane pane) {
		pane.setVgap(50);
		pane.setHgap(50);
		pane.setAlignment(Pos.CENTER);

		// Salgstype
		String salgstype = "Salg";
		if (currSalg instanceof Udlejning) {
			salgstype = "Udlejning";
		}

		// Label
		Label lblsamletPris = new Label("Samlet pris: " + controller.getSamletPris(currSalg));
		Label lblSalgstype = new Label("Salgstype: " + salgstype);
		Label lblOrdre = new Label(controller.getSalgsinformation(currSalg));
		Label lblKlip = new Label();

		lblsamletPris.setPrefSize(600, 35);
		lblsamletPris.setFont(Font.font("Cambria", 30));
		lblSalgstype.setPrefSize(600, 35);
		lblSalgstype.setFont(Font.font("Cambria", 30));
		lblOrdre.setPrefWidth(600);
		lblOrdre.setFont(Font.font("Cambria", 30));
		lblKlip.setPrefSize(300, 35);
		lblKlip.setFont(Font.font("Cambria", 30));

		// Button
		Button btnConfirm = new Button("Bekræft");
		Button btnAnnuller = new Button("Annuller");

		btnConfirm.setOnAction(e -> actionConfirm(tgBetalingsmetoder));
		btnAnnuller.setOnAction(e -> actionAnnuller());
		btnConfirm.setStyle("-fx-font-size: 2.5em ;");
		btnConfirm.setPrefSize(250, 70);
		btnAnnuller.setStyle("-fx-font-size: 2.5em ;");
		btnAnnuller.setPrefSize(250, 70);

		// RadioButton
		tgBetalingsmetoder = new ToggleGroup();
		RadioButton rbDankort = new RadioButton("Dankort");
		RadioButton rbKontant = new RadioButton("Kontant");
		RadioButton rbRegning = new RadioButton("Regning");
		RadioButton rbMobilePay = new RadioButton("MobilePay");
		RadioButton rbKlippekort = new RadioButton("Klippekort");
		rbDankort.setToggleGroup(tgBetalingsmetoder);
		rbKontant.setToggleGroup(tgBetalingsmetoder);
		rbRegning.setToggleGroup(tgBetalingsmetoder);
		rbMobilePay.setToggleGroup(tgBetalingsmetoder);
		rbKlippekort.setToggleGroup(tgBetalingsmetoder);

		rbDankort.setPrefSize(250, 65);
		rbDankort.setFont(Font.font("Cambria", 30));
		rbKontant.setPrefSize(250, 65);
		rbKontant.setFont(Font.font("Cambria", 30));
		rbRegning.setPrefSize(250, 65);
		rbRegning.setFont(Font.font("Cambria", 30));
		rbMobilePay.setPrefSize(250, 65);
		rbMobilePay.setFont(Font.font("Cambria", 30));
		rbKlippekort.setPrefSize(250, 65);
		rbKlippekort.setFont(Font.font("Cambria", 30));

		// Box
		VBox vbCenter = new VBox();
		HBox hbBekraeftAnnuller = new HBox();
		VBox vbRadioButton = new VBox();

		vbCenter.getChildren().add(lblSalgstype);
		vbCenter.getChildren().add(lblOrdre);

		if (currSalg instanceof Udlejning && !((Udlejning) currSalg).getPantBetalt()) {
			Udlejning udlejning = (Udlejning) currSalg;
			Label lblPant = new Label("Pant at betale: " + controller.getSamletPant(udlejning));
			vbCenter.getChildren().add(lblsamletPris);

			lblPant.setFont(Font.font("Cambria", 35));
			lblPant.setPrefSize(600, 35);
			lblPant.setStyle("-fx-font-weight: bold");
			vbCenter.getChildren().add(lblPant);

		} else {
			vbRadioButton.getChildren().add(rbDankort);
			vbRadioButton.getChildren().add(rbKontant);
			vbRadioButton.getChildren().add(rbRegning);
			vbRadioButton.getChildren().add(rbMobilePay);

			// Hvis salg understøtter klippekort, tilføj klippekort-knap
			if (controller.getSamletKlip(currSalg) > 0) {
				vbRadioButton.getChildren().add(rbKlippekort);
			}

			lblsamletPris.setStyle("-fx-font-weight: bold");

			pane.add(vbRadioButton, 1, 0);

			if (currSalg instanceof Udlejning) {
				Label lblPant = new Label("Pant betalt: " + controller.getSamletPant((Udlejning) currSalg));
				lblPant.setFont(Font.font("Cambria", 30));
				lblPant.setPrefSize(600, 35);
				vbCenter.getChildren().add(lblPant);
				lblsamletPris.setText("Samlet pris: " + (controller.getSamletPris(currSalg) - controller.getSamletPant((Udlejning) currSalg)));
			}

			lblsamletPris.setFont(Font.font("Cambria", 35));
			lblsamletPris.setStyle("-fx-font-weight: bold");
			vbCenter.getChildren().add(lblsamletPris);
		}

		hbBekraeftAnnuller.getChildren().add(btnConfirm);
		hbBekraeftAnnuller.getChildren().add(btnAnnuller);

		vbCenter.setAlignment(Pos.CENTER);
		vbCenter.setSpacing(20);
		hbBekraeftAnnuller.setSpacing(50);
		pane.add(vbCenter, 0, 0);
		pane.add(hbBekraeftAnnuller, 0, 3);

		if (controller.getSamletKlip(currSalg) > 0) {
			String klip = ("Antal klip: " + controller.getSamletKlip(currSalg));
			lblKlip.setText(klip);
		}
	}

	private void actionConfirm(ToggleGroup tg) {
		if (currSalg instanceof Udlejning) {
			Udlejning udlejning = (Udlejning) currSalg;
			if (controller.getPantBetalt(udlejning)) {
				confirmUdlejning(tg);

			} else {
				startUdlejning();
			}
		} else {
			confirmSalg(tg);
		}
	}

	private void startUdlejning() {
		orderConfirmed = true;
		controller.registrerSalg(currSalg, null);
		close();
	}

	private void confirmUdlejning(ToggleGroup tg) {
		try {
			orderConfirmed = true;
			RadioButton rb = (RadioButton) tg.getSelectedToggle();
			Betalingsmetode betalingsmetode = getBetalingsmetode(rb);

			controller.afslutUdlejning((Udlejning) currSalg, betalingsmetode);
			close();

		} catch (NullPointerException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Vælg betalingsmetode");
			alert.setContentText("Ingen betalingsmetode er valgt.");
			alert.showAndWait();
		}
	}

	private Betalingsmetode getBetalingsmetode(RadioButton rb) {
		switch (rb.getText()) {
			case "Dankort":
				return Betalingsmetode.DANKORT;
			case "Kontant":
				return Betalingsmetode.KONTANT;
			case "Regning":
				return Betalingsmetode.REGNING;
			case "MobilePay":
				return Betalingsmetode.MOBILEPAY;
			case "Klippekort":
				return Betalingsmetode.KLIPPEKORT;
			default:
				return null;
		}
	}

	private void confirmSalg(ToggleGroup tg) {
		try {
			orderConfirmed = true;
			RadioButton rb = (RadioButton) tg.getSelectedToggle();
			Betalingsmetode betalingsmetode = getBetalingsmetode(rb);

			controller.registrerSalg(currSalg, betalingsmetode);
			close();

		} catch (NullPointerException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Vælg betalingsmetode");
			alert.setContentText("Ingen betalingsmetode er valgt.");
			alert.showAndWait();
		}
	}

	private void actionAnnuller() {
		orderConfirmed = false;
		close();
	}

	public Boolean getOrderConfirmed() {
		return orderConfirmed;
	}

}
