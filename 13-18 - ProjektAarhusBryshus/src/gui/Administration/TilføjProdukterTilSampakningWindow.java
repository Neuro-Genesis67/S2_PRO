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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Produkt;
import model.Produktgruppe;
import model.Sampakning;

class TilføjProdukterTilSampakningWindow extends Stage {

	private ListView<Produkt> lvwProdukter, lvwValgteProdukter;
	private ComboBox<Produktgruppe> cbbProduktgruppe = new ComboBox<>();
	private Controller controller = Controller.getInstance();
	private ObservableList<Produkt> produkterList = FXCollections.observableArrayList();
	private Sampakning sampakning;

	public TilføjProdukterTilSampakningWindow(Sampakning sampakning) {
		this.sampakning = sampakning;
		GridPane pane = new GridPane();
		Scene scene = new Scene(pane);


		initContent(pane);
		this.setMaximized(true);
		this.setScene(scene);
		this.setTitle("Tilføj Produkter til sampakning");
	}

	private void initContent(GridPane pane) {
		pane.setHgap(80);
		pane.setVgap(50);
		pane.setAlignment(Pos.CENTER);
		this.setMaximized(true);

		// Labels
		Label lblProduktgrupper = new Label("Produktgruppe: ");
		Label lblTilføjelser = new Label("" + sampakning);

		lblProduktgrupper.setPrefSize(300, 50);
		lblProduktgrupper.setFont(Font.font("Cambria", 40));
		lblTilføjelser.setPrefSize(600, 50);
		lblTilføjelser.setFont(Font.font("Cambria", 40));

		// ListViews
		lvwProdukter = new ListView<>();
		lvwValgteProdukter = new ListView<>();
		lvwProdukter.setPrefSize(400, 700);
		lvwProdukter.setFixedCellSize(50);
		lvwProdukter.setStyle("-fx-font-size: 2.0em ;");
		lvwValgteProdukter.setPrefSize(400, 625);
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

		// Combobox
		// Fylder cbb med produktgrupper og vælger første index
		ObservableList<Produktgruppe> initProduktgrupper = controller.getProduktgrupper();
		cbbProduktgruppe.getItems().addAll(initProduktgrupper);
		cbbProduktgruppe.getItems().remove(controller.getSampakninggruppe());
		cbbProduktgruppe.getSelectionModel().select(0);
		cbbProduktgruppe.setPrefSize(200, 50);
		cbbProduktgruppe.setStyle("-fx-font-size: 2.5em ;");

		// Laver en liste med produkter baseret på comboboxens valgte produktgruppe
		ArrayList<Produkt> listViewProdukter = new ArrayList<>(
				controller.getProdukter(cbbProduktgruppe.getSelectionModel().getSelectedItem()));

		ChangeListener<Produktgruppe> listener = (ov, oldProdukt, newProdukt) -> {

			ArrayList<Produkt> produkter = new ArrayList<>(
					controller.getProdukter(cbbProduktgruppe.getSelectionModel().getSelectedItem()));
			lvwProdukter.getItems().setAll(produkter);

		};
		cbbProduktgruppe.getSelectionModel().selectedItemProperty().addListener(listener);

		lvwProdukter.getItems().addAll(listViewProdukter);

		lvwValgteProdukter.setItems(produkterList);
		lvwValgteProdukter.getItems().addAll(controller.getSampakprodukter(sampakning));

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
		vbRight.setSpacing(0);
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
		vbBottomRight.getChildren().add(hbBottomRight);
		hbBottomRight.getChildren().add(btnOpret);
		hbBottomRight.getChildren().add(btnFortryd);

		// Button actions
		btnTilføj.setOnAction(event -> tilføjAction());
		btnFjern.setOnAction(spicegirls -> fjernAction());
		btnOpret.setOnAction(event -> opretAction());
		btnFortryd.setOnAction(event -> annullerAction());

	}

	private void tilføjAction() {

		Produkt produkt = lvwProdukter.getSelectionModel().getSelectedItem();
		if (produkt != null) {
			produkterList.add(produkt);
		} else {
			Alert alert = new Alert(AlertType.ERROR, "Der skal vælges et produkt for at tilføje det.");
			alert.setHeaderText("Vælg Produkt");
			alert.showAndWait();
		}
	}

	private void fjernAction() {
		Produkt produkt = lvwValgteProdukter.getSelectionModel().getSelectedItem();
		if (produkt != null) {
			lvwValgteProdukter.getItems().remove(produkt);
			lvwProdukter.getItems().add(produkt);
		}

	}

	private void opretAction() {
		ObservableList<Produkt> produkter = lvwValgteProdukter.getItems();
		controller.setSampakningProdukter(sampakning, produkter);
		close();
	}

	private void annullerAction() {
		// Sæt alle ting til default
		close();
	}
}
