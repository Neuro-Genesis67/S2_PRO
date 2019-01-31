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
import model.Produkt;
import model.Produktgruppe;

public class ProduktPane extends GridPane {

	private ListView<Produkt> lvwProdukt;
	private ComboBox<Produktgruppe> cbbProduktgruppe = new ComboBox<>();
	private Controller controller = Controller.getInstance();

	public ProduktPane() {
		setAlignment(Pos.CENTER);
		setHgap(50);
		setVgap(50);

		VBox vbLeft = new VBox();
		vbLeft.setAlignment(Pos.CENTER);
		add(vbLeft, 1, 1);
		vbLeft.setSpacing(10);

		VBox vbRight = new VBox();
		vbRight.setAlignment(Pos.CENTER_RIGHT);
		add(vbRight, 2, 1);
		vbRight.setSpacing(10);

		HBox produktgruppeBox = new HBox();

		ObservableList<Produktgruppe> initProduktgrupper = controller.getProduktgrupper();
		cbbProduktgruppe.setItems(initProduktgrupper);
		cbbProduktgruppe.getSelectionModel().select(0);
		cbbProduktgruppe.setPrefSize(600, 50);
		cbbProduktgruppe.setStyle("-fx-font-size: 2.5em ;");
		Label lblProduktgruppe = new Label("Produktgruppe: ");
		lblProduktgruppe.setPrefSize(300, 50);
		lblProduktgruppe.setFont(Font.font("Cambria", 40)); // Sæt også en pænere font her
		produktgruppeBox.getChildren().add(lblProduktgruppe);
		produktgruppeBox.getChildren().add(cbbProduktgruppe);
		vbLeft.getChildren().add(produktgruppeBox);

		// Listview
		lvwProdukt = new ListView<>();
		lvwProdukt.setPrefSize(600, 600);
		lvwProdukt.setFixedCellSize(50);
		lvwProdukt.setStyle("-fx-font-size: 2.0em ;");
		vbLeft.getChildren().add(lvwProdukt);
		lvwProdukt.setItems(controller.getProdukter(cbbProduktgruppe.getSelectionModel().getSelectedItem()));

		// Buttons
		Button btnRedigerProdukt = new Button("Rediger produkt");
		Button btnOpretProdukt = new Button("Opret Produkt");
		Button btnSletProdukt = new Button("Slet Produkt");
		btnRedigerProdukt.setPrefSize(300, 215);
		btnOpretProdukt.setPrefSize(300, 214);
		btnSletProdukt.setPrefSize(300, 214);
		btnRedigerProdukt.setStyle("-fx-font-size: 2.5em ;");
		btnOpretProdukt.setStyle("-fx-font-size: 2.5em ;");
		btnSletProdukt.setStyle("-fx-font-size: 2.5em ;");
		vbRight.getChildren().add(btnOpretProdukt);
		vbRight.getChildren().add(btnRedigerProdukt);
		vbRight.getChildren().add(btnSletProdukt);
		btnRedigerProdukt.setOnAction(e -> redigerProduktAction());
		btnOpretProdukt.setOnAction(event -> opretProduktAction());
		btnSletProdukt.setOnAction(spicegirls -> sletProduktAction());

		ChangeListener<Produktgruppe> listener = (ov, oldProdukt, newProdukt) -> this.selectedProduktGruppeChanged();
		cbbProduktgruppe.getSelectionModel().selectedItemProperty().addListener(listener);

	}

	private void opretProduktAction() {
		Produktgruppe produktgruppe = cbbProduktgruppe.getSelectionModel().getSelectedItem();
		if (produktgruppe != null) {
			OpretProduktWindow opret = new OpretProduktWindow(produktgruppe);
			opret.showAndWait();
			lvwProdukt.refresh();
		} else {
			// Stage owner = (Stage) getScene().getWindow();
			Alert alert = new Alert(AlertType.ERROR, "Der skal vælges en produktgruppe før et produkt kan oprettes.");
			alert.setHeaderText("Vælg Produktgruppe");
			// alert.initOwner(owner);
			alert.showAndWait();
		}

	}

	private void redigerProduktAction() {
		Produktgruppe produktgruppe = cbbProduktgruppe.getSelectionModel().getSelectedItem();
		Produkt produkt = lvwProdukt.getSelectionModel().getSelectedItem();
		if (produktgruppe != null && produkt != null) {
			RedigerProduktWindow opret = new RedigerProduktWindow(produkt, produktgruppe); // pris
			opret.showAndWait();

			// Opdater listview (sker ikke automatisk med observable list, da listen ikke
			// ændres. Kun dens items)
			lvwProdukt.refresh();

		} else {
			Alert alert = new Alert(AlertType.ERROR, "Vælg et produkt der skal redigeres.");
			alert.setHeaderText("Vælg Produkt");
			alert.showAndWait();
		}

	}

	private void sletProduktAction() {
		Produkt produkt = lvwProdukt.getSelectionModel().getSelectedItem();
		if (produkt != null) {
			// TODO: Flyttes til controller
			cbbProduktgruppe.getSelectionModel().getSelectedItem().removeProdukt(produkt);
		} else {
			Stage owner = (Stage) getScene().getWindow();
			Alert alert = new Alert(AlertType.ERROR, "Der skal vælges et produkt for at slette det.");
			alert.setHeaderText("Vælg Produkt");
			alert.initOwner(owner);
			alert.showAndWait();
		}
	}

	private void selectedProduktGruppeChanged() {
		Produktgruppe produktgruppe = cbbProduktgruppe.getSelectionModel().getSelectedItem();
		if (produktgruppe != null) {

			lvwProdukt.setItems(controller.getProdukter(produktgruppe));
			// Hvis der ikke er nogen produktgrupper, NullPointerException

		} else {
			lvwProdukt.getItems().clear();
		}
	}
}
