package gui;

import java.util.ArrayList;
import java.util.HashSet;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Listepris;
import model.Prisliste;
import model.Produkt;
import model.Produktgruppe;
import model.Salg;
import model.Salgslinie;

class SalgWindow extends Stage {

	private Label lblTotalPrisFelt;
	private Label lblRabatBeløbFelt;
	private Label lblKlippekortFelt;
	private Button btnAntal1;
	private Button btnAntal2;
	private Button btnAntal3;
	private TextField txfRabatprocent, txfAntal, txfVælgPris;
	private ComboBox<Prisliste> cbPrisliste;
	private ComboBox<Produktgruppe> cbProduktgruppe;
	private ListView<Listepris> lvwVarer = new ListView<>();
	private ListView<Salgslinie> lvwKurv;
	private ObservableList<Listepris> visteProdukter = FXCollections.observableArrayList();
	private ObservableList<Produktgruppe> visteProduktgrupper = FXCollections.observableArrayList();
	private ArrayList<Listepris> tempProdukt = new ArrayList<>();
	private HashSet<Produktgruppe> tempProduktgruppe = new HashSet<>();
	private Controller controller = Controller.getInstance();
	private Salg currSalg;

	SalgWindow() {
		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane);
		currSalg = controller.createSalg();
		this.setScene(scene);
		this.initGridpane(gridPane);
		this.setTitle("Salg");
	}

	private void initGridpane(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setVgap(20);
		pane.setHgap(50);
		pane.setAlignment(Pos.CENTER);
		this.setMaximized(true);

		// Label

		Label lblPrisliste = new Label("Prisliste: ");
		Label lblProduktgruppe = new Label("Produktgruppe: ");
		Label lblProdukter = new Label("Produkter");
		Label lblAntal = new Label("Antal");
		Label lblRabat = new Label("Rabat");
		Label lblVælgPris = new Label("Angiv egen pris:");
		Label lblKurv = new Label("Kurv");
		Label lblTotalpris = new Label("				  Totalpris:");
		Label lblRabatbeløb = new Label("				  Rabatbeløb:");
		Label lblKlippekort = new Label("				  Antal klip: ");
		lblTotalPrisFelt = new Label("");
		lblRabatBeløbFelt = new Label("");
		lblKlippekortFelt = new Label("");

		lblPrisliste.setPrefSize(200, 35);
		lblPrisliste.setFont(Font.font("Cambria", 28));
		lblProduktgruppe.setPrefSize(200, 35);
		lblProduktgruppe.setFont(Font.font("Cambria", 28));
		lblProdukter.setPrefSize(300, 35);
		lblProdukter.setFont(Font.font("Cambria", 20));
		lblAntal.setPrefSize(300, 35);
		lblAntal.setFont(Font.font("Cambria", 20));
		lblRabat.setPrefSize(300, 35);
		lblRabat.setFont(Font.font("Cambria", 20));
		lblVælgPris.setPrefSize(300, 35);
		lblVælgPris.setFont(Font.font("Cambria", 20));
		lblKurv.setPrefSize(300, 35);
		lblKurv.setFont(Font.font("Cambria", 20));
		lblTotalpris.setPrefSize(180, 35);
		lblTotalpris.setFont(Font.font("Cambria", 20));
		lblRabatbeløb.setPrefSize(180, 35);
		lblRabatbeløb.setFont(Font.font("Cambria", 20));
		lblKlippekort.setPrefSize(180, 35);
		lblKlippekort.setFont(Font.font("Cambria", 20));
		lblTotalPrisFelt.setPrefSize(80, 35);
		lblTotalPrisFelt.setFont(Font.font("Cambria", 20));
		lblRabatBeløbFelt.setPrefSize(80, 35);
		lblRabatBeløbFelt.setFont(Font.font("Cambria", 20));
		lblKlippekortFelt.setPrefSize(180, 35);
		lblKlippekortFelt.setFont(Font.font("Cambria", 20));

		// TextField
		txfRabatprocent = new TextField();
		txfAntal = new TextField();
		txfVælgPris = new TextField();

		txfRabatprocent.setPrefSize(150, 25);
		txfRabatprocent.setStyle("-fx-font-size: 2.0em ;");
		txfRabatprocent.setText("0%");
		txfVælgPris.setPrefSize(150, 25);
		txfVælgPris.setStyle("-fx-font-size: 2.0em ;");
		txfAntal.setPrefSize(150, 25);
		txfAntal.setStyle("-fx-font-size: 2.0em ;");
		txfAntal.setText("1");

		// Combobox
		cbPrisliste = new ComboBox<>();
		cbProduktgruppe = new ComboBox<>();

		cbPrisliste.setItems(controller.getPrislister());


		cbProduktgruppe.setItems(visteProduktgrupper);
		cbProduktgruppe.setPromptText("													 ");
		ChangeListener<Prisliste> listenerPrisliste = (ov, oldProdukt, newProdukt) -> this.selectedPrislisteChanged();
		ChangeListener<Produktgruppe> listenerProduktgruppe = (ov, oldProdukt, newProdukt) -> this
				.selectedProduktgruppeChanged();
		cbPrisliste.getSelectionModel().selectedItemProperty().addListener(listenerPrisliste);
		cbProduktgruppe.getSelectionModel().selectedItemProperty().addListener(listenerProduktgruppe);

		cbPrisliste.setPrefSize(300, 35);
		cbPrisliste.setStyle("-fx-font-size: 2.0em ;");
		cbPrisliste.getSelectionModel().selectFirst();
		cbProduktgruppe.setPrefSize(300, 35);
		cbProduktgruppe.setStyle("-fx-font-size: 2.0em ;");

		// ListView
		lvwVarer = new ListView<>();
		lvwKurv = new ListView<>();

		lvwVarer.setPrefSize(500, 450);
		lvwVarer.setFixedCellSize(50);
		lvwVarer.setStyle("-fx-font-size: 2.0em ;");
		lvwKurv.setPrefSize(500, 450);
		lvwKurv.setFixedCellSize(50);
		lvwKurv.setStyle("-fx-font-size: 2.0em ;");

		lvwVarer.setItems(visteProdukter);
		lvwKurv.setItems(controller.getSalgslinier(currSalg));

		// Button
		btnAntal1 = new Button("1");
		btnAntal2 = new Button("2");
		btnAntal3 = new Button("3");
		Button btnRabat0 = new Button("0%");
		Button btnRabat1 = new Button("10%");
		Button btnRabat2 = new Button("20%");
		Button btnRabat3 = new Button("25%");
		Button btnRabat4 = new Button("50%");
		Button btnRabat5 = new Button("100%");
		Button btnTilføj = new Button("Tilføj til kurv");
		Button btnFjern = new Button("Fjern fra kurv");
		Button btnBetal = new Button("Gå til betaling");

		btnAntal1.setStyle("-fx-font-size: 2.5em ;");
		btnAntal1.setPrefSize(80, 30);
		btnAntal2.setStyle("-fx-font-size: 2.5em ;");
		btnAntal2.setPrefSize(80, 30);
		btnAntal3.setStyle("-fx-font-size: 2.5em ;");
		btnAntal3.setPrefSize(80, 30);
		btnRabat0.setStyle("-fx-font-size: 2.0em ;");
		btnRabat0.setPrefSize(80, 60);
		btnRabat1.setStyle("-fx-font-size: 2.0em ;");
		btnRabat1.setPrefSize(80, 60);
		btnRabat2.setStyle("-fx-font-size: 2.0em ;");
		btnRabat2.setPrefSize(80, 60);
		btnRabat3.setStyle("-fx-font-size: 2.0em ;");
		btnRabat3.setPrefSize(80, 60);
		btnRabat4.setStyle("-fx-font-size: 2.0em ;");
		btnRabat4.setPrefSize(80, 60);
		btnRabat5.setStyle("-fx-font-size: 2.0em ;");
		btnRabat5.setPrefSize(80, 60);
		btnTilføj.setStyle("-fx-font-size: 2.5em ;");
		btnTilføj.setPrefSize(250, 70);
		btnFjern.setStyle("-fx-font-size: 2.5em ;");
		btnFjern.setPrefSize(250, 70);
		btnBetal.setStyle("-fx-font-size: 2.5em ;");
		btnBetal.setPrefSize(250, 100);

		btnAntal1.setOnAction(e -> antalBtnAction(btnAntal1));
		btnAntal2.setOnAction(e -> antalBtnAction(btnAntal2));
		btnAntal3.setOnAction(e -> antalBtnAction(btnAntal3));
		btnRabat0.setOnAction(e -> txfRabatprocent.setText("0%"));
		btnRabat1.setOnAction(e -> txfRabatprocent.setText("10%"));
		btnRabat2.setOnAction(e -> txfRabatprocent.setText("20%"));
		btnRabat3.setOnAction(e -> txfRabatprocent.setText("25%"));
		btnRabat4.setOnAction(e -> txfRabatprocent.setText("50%"));
		btnRabat5.setOnAction(e -> txfRabatprocent.setText("100%"));
		btnBetal.setOnAction(e -> actionBetal());
		btnTilføj.setOnAction(e -> tilføjAction());
		btnFjern.setOnAction(e -> fjernAction());

		// Boxes
		HBox hbPrisliste = new HBox();
		HBox hbProduktgruppe = new HBox();
		HBox hbAntalButtons = new HBox();
		HBox hbRabatButtons = new HBox();
		HBox hbKurvButtons = new HBox();
		HBox hbBetal = new HBox();
		VBox vbBetal = new VBox();
		VBox vbBetalFelt = new VBox();

		hbPrisliste.getChildren().add(lblPrisliste);
		hbPrisliste.getChildren().add(cbPrisliste);
		hbProduktgruppe.getChildren().add(lblProduktgruppe);
		hbProduktgruppe.getChildren().add(cbProduktgruppe);
		hbAntalButtons.getChildren().add(btnAntal1);
		hbAntalButtons.getChildren().add(btnAntal2);
		hbAntalButtons.getChildren().add(btnAntal3);
		hbRabatButtons.getChildren().add(btnRabat0);
		hbRabatButtons.getChildren().add(btnRabat1);
		hbRabatButtons.getChildren().add(btnRabat2);
		hbRabatButtons.getChildren().add(btnRabat3);
		hbRabatButtons.getChildren().add(btnRabat4);
		hbRabatButtons.getChildren().add(btnRabat5);
		hbKurvButtons.getChildren().add(btnTilføj);
		hbKurvButtons.getChildren().add(btnFjern);
		hbBetal.getChildren().add(btnBetal);
		hbBetal.getChildren().add(vbBetal);
		hbBetal.getChildren().add(vbBetalFelt);
		vbBetalFelt.getChildren().add(lblTotalPrisFelt);
		vbBetalFelt.getChildren().add(lblRabatBeløbFelt);
		vbBetalFelt.getChildren().add(lblKlippekortFelt);
		vbBetal.getChildren().add(lblTotalpris);
		vbBetal.getChildren().add(lblRabatbeløb);
		vbBetal.getChildren().add(lblKlippekort);

		hbAntalButtons.setAlignment(Pos.CENTER);
		hbRabatButtons.setAlignment(Pos.CENTER);
		hbBetal.setAlignment(Pos.CENTER_RIGHT);
		hbKurvButtons.setSpacing(50);
		hbAntalButtons.setSpacing(30);

		// Adding to pane
		pane.add(hbPrisliste, 1, 3);
		pane.add(hbProduktgruppe, 1, 4);
		pane.add(lblProdukter, 1, 5);
		pane.add(lvwVarer, 1, 6, 1, 10);

		pane.add(lblAntal, 3, 5);
		pane.add(hbAntalButtons, 3, 6);
		pane.add(txfAntal, 3, 7);
		pane.add(lblRabat, 3, 9);
		pane.add(hbRabatButtons, 3, 10);
		pane.add(txfRabatprocent, 3, 11);
		pane.add(lblVælgPris, 3, 13);
		pane.add(txfVælgPris, 3, 14);
		pane.add(hbKurvButtons, 3, 15);
		pane.add(hbBetal, 3, 16);

		pane.add(lblKurv, 5, 5);
		pane.add(lvwKurv, 5, 6, 1, 10);

		// sorterer listen ved at sammenligne p1 og p2's toString metoder
		FXCollections.sort(visteProduktgrupper, (p1, p2) -> p1.toString().compareToIgnoreCase(p2.toString()));

		cbProduktgruppe.getSelectionModel().selectFirst();


	}

	private void selectedPrislisteChanged() {
		Prisliste prisliste = cbPrisliste.getSelectionModel().getSelectedItem();
		lvwVarer.getItems().clear();
		cbProduktgruppe.getItems().clear();
		tempProdukt.clear();

		if (prisliste != null) {
			for (Produktgruppe pg : controller.getProduktgrupper()) {
				for (Produkt p : controller.getProdukter(pg)) {
					for (Listepris lp : controller.getListepriser(prisliste)) {
						if (lp.getProdukt().equals(p)) {
							tempProdukt.add(lp);
							tempProduktgruppe.add(pg);
						}
					}
				}
			}

			visteProdukter.setAll(tempProdukt);
			visteProduktgrupper.setAll(tempProduktgruppe);
			cbProduktgruppe.getSelectionModel().selectFirst();

		} else {
			cbProduktgruppe.getItems().clear();
		}
	}

	// ændre ikke produkterne når den er valgt, muligvis pga at de bliver vist af
	// cbprisliste
	private void selectedProduktgruppeChanged() {
		Prisliste prisliste = cbPrisliste.getSelectionModel().getSelectedItem();
		Produktgruppe produktgruppe = cbProduktgruppe.getSelectionModel().getSelectedItem();
		tempProdukt.clear();
		if (prisliste != null && produktgruppe != null) {

			for (Listepris lp : prisliste.getListepriser()) {
				for (Produkt p : controller.getProdukter(produktgruppe)) {
					if (lp.getProdukt() == p) {
						tempProdukt.add(lp);
					}
				}

			}
			visteProdukter.setAll(tempProdukt);

		} else {
			lvwVarer.getItems().clear();
		}

	}

	private void antalBtnAction(Button button) {
		txfAntal.setText(button.getText());
	}

	// private String getRabatprocent (String s) {
	// return s.substring(0, s.length()-1);
	// }

	private void tilføjAction() {
		try {
			Listepris vare = lvwVarer.getSelectionModel().getSelectedItem();
			String antal = txfAntal.getText();
			String samletPris = txfVælgPris.getText();
			String rabat = txfRabatprocent.getText().substring(0, txfRabatprocent.getText().length() - 1);
			controller.opretSalgslinie(currSalg, antal, vare, samletPris, rabat);

			updateSubtotal();
			clearTxfs();

		} catch (NullPointerException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Vælg vare");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Fejl i indtastning");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (IllegalArgumentException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Fejl i tilføjelse");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		txfRabatprocent.setText("0%");
		txfAntal.setText("1");

	}

	private void fjernAction() {
		try {
			Salgslinie sl = lvwKurv.getSelectionModel().getSelectedItem();
			currSalg.removeSalgslinie(sl);
			updateSubtotal();
		} catch (NullPointerException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Vælg en vare");
			alert.setContentText("Venligst vælg en vare fra kurven på højre side.");
			alert.showAndWait();
		}
	}

	private void actionBetal() {
		BekraeftSalgWindow bekræftsalgwindow = new BekraeftSalgWindow(currSalg);
		if (lvwKurv.getItems().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText("Betaling ikke mulig");
			alert.setContentText("Ingen produkter i kurven.");
			alert.showAndWait();

		} else {
			bekræftsalgwindow.showAndWait();
			if (bekræftsalgwindow.getOrderConfirmed()) {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText("Ordre oprettet.");
				alert.setContentText("Ordren er nu registreret i systemet.");
				newSalg();
				alert.showAndWait();
			}
		}

	}

	private void updateSubtotal() {
		String totalPris = "" + controller.getSamletPris(currSalg);
		String totalKlip = "";
		if (controller.getSamletKlip(currSalg) > 0) {
			totalKlip += controller.getSamletKlip(currSalg);
			lblKlippekortFelt.setText(totalKlip + " klip.");
		}
		String totalRabat = "" + controller.getSamletRabat(currSalg);
		lblTotalPrisFelt.setText(totalPris + " kr.");
		lblRabatBeløbFelt.setText(totalRabat.substring(0, 3) + " kr.");
	}

	private void clearTxfs() {
		txfAntal.setText("1");
		txfRabatprocent.setText("0%");
		txfVælgPris.clear();
	}

	private void newSalg() {
		clearTxfs();
		currSalg = controller.createSalg();
		lvwKurv.setItems(controller.getSalgslinier(currSalg));
		updateSubtotal();
	}

}
