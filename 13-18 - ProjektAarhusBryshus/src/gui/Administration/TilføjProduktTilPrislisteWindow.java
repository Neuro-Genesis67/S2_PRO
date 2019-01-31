package gui.Administration;

import java.util.ArrayList;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Prisliste;
import model.Produkt;
import model.Produktgruppe;

class TilføjProduktTilPrislisteWindow extends Stage {

	private Prisliste prisliste;
	private TextField txfPris = new TextField();
	private ListView<Produkt> lvwProdukter, lvwValgteProdukter;
	private ComboBox<Produktgruppe> cbbProduktgruppe = new ComboBox<>();
	private Controller controller = Controller.getInstance();
	private ObservableList<Produkt> produkterList = FXCollections.observableArrayList();
	private ComboBox<Integer> cbbKlippekort;
	private CheckBox cbKlippekort;

	public TilføjProduktTilPrislisteWindow(Prisliste prisliste) {
		GridPane pane = new GridPane();
		Scene scene = new Scene(pane);
		this.prisliste = prisliste;

		initContent(pane);
		this.setMaximized(true);
		this.setScene(scene);
		this.setTitle("Tilføj produkter til prisliste");
	}

	private void initContent(GridPane pane) {
		pane.setHgap(80);
		pane.setVgap(50);
		pane.setAlignment(Pos.CENTER);
		this.setMaximized(true);

		// Labels
		/*
		 * Lavet til PrislistePane
		 *
		 * Combobox med produktgrupper listview med produkter en måde at tilføje flere
		 * til en prisliste?
		 */
		Label lblProduktgrupper = new Label("Produktgruppe: ");
		Label lblTilføjelser = new Label("" + prisliste);
		Label lblKlipperkortsPris = new Label("Klippekortspris: ");
		Label lblPris = new Label("Sæt pris: ");

		lblProduktgrupper.setPrefSize(300, 50);
		lblProduktgrupper.setFont(Font.font("Cambria", 40));
		lblTilføjelser.setPrefSize(600, 50);
		lblTilføjelser.setFont(Font.font("Cambria", 40));
		lblKlipperkortsPris.setPrefSize(300, 50);
		lblKlipperkortsPris.setFont(Font.font("Cambria", 40));
		lblPris.setPrefSize(300, 40);
		lblPris.setFont(Font.font("Cambria", 40));

		// ListViews
		lvwProdukter = new ListView<>();
		lvwValgteProdukter = new ListView<>();

		lvwProdukter.setPrefSize(400, 700);
		lvwProdukter.setFixedCellSize(50);
		lvwProdukter.setStyle("-fx-font-size: 2.0em ;");
		lvwValgteProdukter.setPrefSize(400, 400);
		lvwValgteProdukter.setFixedCellSize(50);
		lvwValgteProdukter.setStyle("-fx-font-size: 2.0em ;");

		// Buttons
		Button btnTilføj = new Button("Tilføj ->");
		Button btnFjern = new Button("<- Fjern");
		Button btnOpret = new Button("Opret");
		Button btnFortryd = new Button("Fortryd");

		btnTilføj.setStyle("-fx-font-size: 2.5em ;");
		btnTilføj.setPrefSize(200, 100);
		btnFjern.setStyle("-fx-font-size: 2.5em ;");
		btnFjern.setPrefSize(200, 100);
		btnOpret.setStyle("-fx-font-size: 2.5em ;");
		btnOpret.setPrefSize(200, 80);
		btnFortryd.setStyle("-fx-font-size: 2.5em ;");
		btnFortryd.setPrefSize(200, 80);

		// Comboboxes
		ObservableList<Produktgruppe> initProduktgrupper = controller.getProduktgrupper(); // TODO Listen indeholder
		// produktgruppen
		// "Udlejning". Den skal
		// ikke være der, hvordan
		// fjerner vi den? (Jeg
		// kunne
		// fjerne den da jeg kender
		// dens
		// index, men det virker
		// ikke som en
		// langtidsholdbar løsning.

		cbbProduktgruppe.setItems(initProduktgrupper);
		cbbProduktgruppe.getSelectionModel().select(0);
		cbbProduktgruppe.setPrefSize(200, 50);
		cbbProduktgruppe.setStyle("-fx-font-size: 2.5em ;");

		// TextField
		txfPris.setPrefSize(500, 50);
		txfPris.setStyle("-fx-font-size: 2.5em ;");

		// Adding boxes to the pane
		HBox hbLeft = new HBox();
		VBox vbLeft = new VBox();
		VBox vbCenter = new VBox();
		VBox vbRight = new VBox();
		HBox hbRight = new HBox();
		VBox vbBottomRight = new VBox();
		HBox hbKlipperkort = new HBox();
		HBox hbBottomRight = new HBox();
		vbLeft.setAlignment(Pos.CENTER_LEFT);
		vbCenter.setAlignment(Pos.CENTER);
		vbRight.setAlignment(Pos.CENTER_RIGHT);
		hbLeft.setSpacing(20);
		vbRight.setSpacing(10);
		vbBottomRight.setSpacing(20);
		hbKlipperkort.setSpacing(30);
		hbBottomRight.setSpacing(50);
		vbCenter.setSpacing(80);
		vbCenter.setPrefSize(200, 100);
		pane.add(vbLeft, 1, 1);
		pane.add(vbCenter, 2, 1);
		pane.add(vbRight, 3, 1);

		// Boxes:
		// Venstre side: Label, Cbb, Listview.
		vbLeft.getChildren().add(hbLeft);
		hbLeft.getChildren().add(lblProduktgrupper);
		hbLeft.getChildren().add(cbbProduktgruppe);
		vbLeft.getChildren().add(lvwProdukter);

		// Midten: Tilføj & FJern buttons
		vbCenter.getChildren().add(btnTilføj);
		vbCenter.getChildren().add(btnFjern);

		// Højre side: Lbl, lvw, btn (opret og fjern), txfpris
		hbRight.getChildren().add(lblTilføjelser);
		vbRight.getChildren().add(hbRight);
		vbRight.getChildren().add(lvwValgteProdukter);
		vbRight.getChildren().add(vbBottomRight);
		vbBottomRight.getChildren().add(lblPris);
		vbBottomRight.getChildren().add(txfPris);
		vbBottomRight.getChildren().add(hbBottomRight);
		hbBottomRight.getChildren().add(btnOpret);
		hbBottomRight.getChildren().add(btnFortryd);

		// Button actions
		btnTilføj.setOnAction(event -> tilføjAction());
		btnFjern.setOnAction(spicegirls -> fjernAction());
		btnOpret.setOnAction(event -> opretAction());
		btnFortryd.setOnAction(event -> annullerAction());

		// Sørger for at man ikke kan tilføje produkter der allerede er tilføjede.
		ArrayList<Produkt> valgteProdukter = new ArrayList<>(
				controller.getProdukter(cbbProduktgruppe.getSelectionModel().getSelectedItem()));
		valgteProdukter.removeAll(controller.getProdukter(prisliste));
		ChangeListener<Produktgruppe> listener = (ov, oldProdukt, newProdukt) -> this.selectedProduktgruppeChanged();
		cbbProduktgruppe.getSelectionModel().selectedItemProperty().addListener(listener);

		if (prisliste.equals(controller.getFredagsbarPrisliste())) {
			vbBottomRight.getChildren().add(hbKlipperkort);

			cbbKlippekort = new ComboBox<>();
			cbbKlippekort.setDisable(true);
			cbbKlippekort.getItems().add(1);
			cbbKlippekort.getItems().add(2);
			cbbKlippekort.getItems().add(3);
			cbbKlippekort.getItems().add(4);
			cbbKlippekort.getSelectionModel().selectFirst();
			cbbKlippekort.setPrefSize(250, 40);

			cbKlippekort = new CheckBox("Klippekort");
			cbKlippekort.setPrefSize(250, 40);
			cbKlippekort.setFont(Font.font("Cambria", 20));
			ChangeListener<Boolean> cbChangelist = (observable, oldValue, newValue) -> cbbKlippekort
					.setDisable(oldValue);
			cbKlippekort.selectedProperty().addListener(cbChangelist);

			hbKlipperkort.getChildren().add(cbKlippekort);
			hbKlipperkort.getChildren().add(cbbKlippekort);
		}

		lvwProdukter.getItems().addAll(valgteProdukter);
		lvwValgteProdukter.setItems(produkterList);

	}

	private void tilføjAction() {

		Produkt produkt = lvwProdukter.getSelectionModel().getSelectedItem();
		if (produkt != null) {
			if (!produkterList.contains(produkt)) {
				produkterList.add(produkt);
			}

			lvwProdukter.getItems().remove(produkt);
		} else {
			Alert alert = new Alert(AlertType.ERROR, "Der skal vælges et produkt for at tilføje det.");
			alert.setHeaderText("Vælg Produkt");
			alert.showAndWait();
		}
	}

	private void fjernAction() {

		Produkt p = lvwValgteProdukter.getSelectionModel().getSelectedItem();
		if (p != null) {
			lvwValgteProdukter.getItems().remove(p);
			lvwProdukter.getItems().add(p);
		}

	}

	private void opretAction() {
		try {
			if (produkterList.size() > 0) { // hvis der ikke står noget i txf er der fejl

				String pris = txfPris.getText();

				// Hvis der er klippekortpris tilknyttet
				if (cbKlippekort != null && cbKlippekort.isSelected()) {
					int antalKlip = cbbKlippekort.getSelectionModel().getSelectedItem();

					for (Produkt p : produkterList) {
						controller.opretListepris(p, pris, antalKlip, prisliste);
						close();
					}
				} else {
					for (Produkt p : produkterList) {
						controller.opretListepris(p, pris, prisliste);
						close();
					}
				}
			}

		} catch (NullPointerException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Ingen pris");
			alert.setContentText("Vælg venligst en pris.");
			alert.showAndWait();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl i prisen");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl i indtastningen");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	private void annullerAction() {
		// Sæt alle ting til default
		close();
	}

	private void selectedProduktgruppeChanged() {
		ArrayList<Produkt> produkter = new ArrayList<>(
				controller.getProdukter(cbbProduktgruppe.getSelectionModel().getSelectedItem()));
		produkter.removeAll(controller.getProdukter(prisliste));
		lvwProdukter.getItems().setAll(produkter);
	}
}
