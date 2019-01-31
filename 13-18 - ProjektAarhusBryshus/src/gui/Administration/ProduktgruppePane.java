package gui.Administration;

import controller.Controller;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Produktgruppe;

public class ProduktgruppePane extends GridPane {
	private ListView<Produktgruppe> lvwProduktgruppe;
	private Controller controller = Controller.getInstance();

	public ProduktgruppePane() {
		setAlignment(Pos.CENTER);
		setHgap(50);
		setVgap(50);

		// Creating and styling labels

		Label lblOverskrift = new Label("Produktgrupper:");
		lblOverskrift.setPrefSize(300, 50);
		lblOverskrift.setFont(Font.font("Cambria", 40));

		// Creating and adding VBoxes
		VBox vbLeft = new VBox();
		vbLeft.setAlignment(Pos.CENTER);
		add(vbLeft, 1, 1);

		VBox vbRight = new VBox();
		vbRight.setAlignment(Pos.BOTTOM_RIGHT);
		vbRight.setSpacing(173);
		add(vbRight, 2, 1);

		lvwProduktgruppe = new ListView<>();
		ObservableList<Produktgruppe> produktgrupper = controller.getProduktgrupper();
		lvwProduktgruppe.setItems(produktgrupper);
		lvwProduktgruppe.setPrefSize(600, 600);
		lvwProduktgruppe.setFixedCellSize(50);
		lvwProduktgruppe.setStyle("-fx-font-size: 2.0em ;");

		vbLeft.getChildren().add(lblOverskrift);
		vbLeft.getChildren().add(lvwProduktgruppe);

		// Buttons
		Button btnOpretProduktgruppe = new Button("Opret \nProduktgruppe");
		Button btnSletProduktgruppe = new Button("Slet \nProduktgruppe");
		btnOpretProduktgruppe.setPrefSize(300, 214);
		btnSletProduktgruppe.setPrefSize(300, 214);
		btnOpretProduktgruppe.setStyle("-fx-font-size: 2.5em ;");
		btnSletProduktgruppe.setStyle("-fx-font-size: 2.5em ;");

		// vbRight.getChildren().add(lblSpacing1);
		vbRight.getChildren().add(btnOpretProduktgruppe);
		vbRight.getChildren().add(btnSletProduktgruppe);

		btnOpretProduktgruppe.setOnAction(event -> opretAction());
		btnSletProduktgruppe.setOnAction(event -> sletAction());
	}

	private void opretAction() {
		OpretProduktgruppeWindow opret = new OpretProduktgruppeWindow();
		opret.showAndWait();
	}

	private void sletAction() {
		Produktgruppe produktgruppe = lvwProduktgruppe.getSelectionModel().getSelectedItem();
		if (produktgruppe != null) {
			controller.removeProduktgruppe(produktgruppe);
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Produktgruppe mangler!");
			alert.setContentText("Venligst vælg en produktgruppe");
		}
	}

}
