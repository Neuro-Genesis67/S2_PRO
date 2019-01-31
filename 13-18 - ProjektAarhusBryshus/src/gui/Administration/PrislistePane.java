package gui.Administration;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
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
import model.Listepris;
import model.Prisliste;

public class PrislistePane extends GridPane {
	private ListView<Listepris> lvwListepris;
	private ComboBox<Prisliste> cbbPrisliste = new ComboBox<>();
	private Controller controller = Controller.getInstance();

	public PrislistePane() {
		setAlignment(Pos.CENTER);
		setHgap(50);
		setVgap(50);

		Label lblPrisliste = new Label("Prisliste: ");
		lblPrisliste.setPrefSize(300, 50);
		lblPrisliste.setFont(Font.font("Cambria", 40));

		VBox vbLeft = new VBox();
		vbLeft.setAlignment(Pos.CENTER);
		add(vbLeft, 1, 1);
		vbLeft.setSpacing(10);

		VBox vbRight = new VBox();
		vbRight.setAlignment(Pos.CENTER_RIGHT);
		add(vbRight, 2, 1);
		vbRight.setSpacing(10);

		ObservableList<Prisliste> initPrislister = controller.getPrislister();
		cbbPrisliste.setItems(initPrislister);
		cbbPrisliste.getSelectionModel().select(0);
		cbbPrisliste.setPrefSize(600, 50);
		cbbPrisliste.setStyle("-fx-font-size: 2.5em ;");

		ChangeListener<Prisliste> listener = (ov, oldProdukt, newProdukt) -> this.selectedPrislisteChanged();
		cbbPrisliste.getSelectionModel().selectedItemProperty().addListener(listener);

		HBox hbPrisliste = new HBox();
		hbPrisliste.getChildren().add(lblPrisliste);
		hbPrisliste.getChildren().add(cbbPrisliste);

		Button btnOpretPL = new Button("Opret Prisliste");
		Button btnSletPL = new Button("Slet Prisliste");
		Button btnAddProdukt = new Button("Tilføj Produkt");
		Button btnRemoveProdukt = new Button("Fjern Produkt");
		btnOpretPL.setPrefSize(300, 160);
		btnSletPL.setPrefSize(300, 160);
		btnAddProdukt.setPrefSize(300, 160);
		btnRemoveProdukt.setPrefSize(300, 160);
		btnOpretPL.setStyle("-fx-font-size: 2.5em ;");
		btnSletPL.setStyle("-fx-font-size: 2.5em ;");
		btnAddProdukt.setStyle("-fx-font-size: 2.5em ;");
		btnRemoveProdukt.setStyle("-fx-font-size: 2.5em ;");
		vbRight.getChildren().add(btnOpretPL);
		vbRight.getChildren().add(btnSletPL);
		vbRight.getChildren().add(btnAddProdukt);
		vbRight.getChildren().add(btnRemoveProdukt);

		btnOpretPL.setOnAction(event -> opretPrisliste());
		btnSletPL.setOnAction(event -> sletPrisliste());
		btnAddProdukt.setOnAction(event -> tilføjProduktTilPrisliste());
		btnRemoveProdukt.setOnAction(event -> fjernProduktFraPrisliste());

		lvwListepris = new ListView<>();
		vbLeft.getChildren().add(hbPrisliste);
		vbLeft.getChildren().add(lvwListepris);

		lvwListepris.setPrefSize(600, 600);
		lvwListepris.setFixedCellSize(50);
		lvwListepris.setStyle("-fx-font-size: 2.0em ;");

		lvwListepris.setItems(controller.getListepriser(cbbPrisliste.getSelectionModel().getSelectedItem()));
	}

	private void opretPrisliste() {
		OpretPrislisteWindow opret = new OpretPrislisteWindow();
		opret.showAndWait();
	}

	private void sletPrisliste() {
		Prisliste prisliste = cbbPrisliste.getSelectionModel().getSelectedItem();
		if (prisliste != null) {
			Stage owner = (Stage) getScene().getWindow();
			Alert alert = new Alert(AlertType.ERROR, "Du er ved at slette en prisliste permanet, er du sikker?");
			alert.setHeaderText("Vent!");
			alert.initOwner(owner);
			alert.showAndWait();
			controller.removePrisliste(prisliste);
		} else {
			Stage owner = (Stage) getScene().getWindow();
			Alert alert = new Alert(AlertType.ERROR, "Der skal vælges en prisliste for at slette den.");
			alert.setHeaderText("Vælg Prisliste");
			alert.initOwner(owner);
			alert.showAndWait();
		}
	}

	private void tilføjProduktTilPrisliste() {
		Prisliste prisliste = cbbPrisliste.getSelectionModel().getSelectedItem();
		if (prisliste != null) {
			TilføjProduktTilPrislisteWindow opret = new TilføjProduktTilPrislisteWindow(prisliste);
			opret.showAndWait();
		} else {
			Stage owner = (Stage) getScene().getWindow();
			Alert alert = new Alert(AlertType.ERROR, "Der skal vælges en prisliste for at tilføje et produkt.");
			alert.setHeaderText("Vælg Prisliste");
			alert.initOwner(owner);
			alert.showAndWait();
		}
	}

	private void fjernProduktFraPrisliste() {
		Prisliste prisliste = cbbPrisliste.getSelectionModel().getSelectedItem();
		Listepris listepris = lvwListepris.getSelectionModel().getSelectedItem();
		if (listepris != null && prisliste != null) {
			controller.removeListepris(listepris, prisliste);
		} else {
			Stage owner = (Stage) getScene().getWindow();
			Alert alert = new Alert(AlertType.ERROR, "Der skal vælges et produkt og en prisliste for denne handling.");
			alert.setHeaderText("Vælg Produkt og Prisliste");
			alert.initOwner(owner);
			alert.showAndWait();
		}

	}

	private void selectedPrislisteChanged() {
		Prisliste prisliste = cbbPrisliste.getSelectionModel().getSelectedItem();
		if (prisliste != null) {
			lvwListepris.setItems(controller.getListepriser(prisliste));
			// Hvis der ikke er nogen produktgrupper, NullPointerException

		} else {
			lvwListepris.getItems().clear();
		}
	}

	public void refresh() {
		lvwListepris.refresh();
	}
}
