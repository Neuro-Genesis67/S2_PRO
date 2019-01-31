package gui.udlejning;

import controller.Controller;
import gui.BekraeftSalgWindow;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Udlejning;


class AktiveUdlejningerWindow extends Stage {

	 private Controller controller;
	 private TextArea txaInformationer;
	 private ListView<Udlejning> lvwUdlejninger;

	 public AktiveUdlejningerWindow() {
		  GridPane pane = new GridPane();
		  Scene scene = new Scene(pane);
		  pane.setPadding(new Insets(10));
		  controller = Controller.getInstance();

		  this.setScene(scene);
		  this.initGridPane(pane);
		  this.setTitle("Aktive udlejninger");
	 }

	 private void initGridPane(GridPane pane) {
		  this.setMaximized(true);
		  pane.setAlignment(Pos.CENTER);
		  pane.setVgap(50);
		  pane.setHgap(50);

		  Button btnFaerdiggoer = new Button("Færdiggør udlejning");
		  btnFaerdiggoer.setPrefSize(500, 115);
		  btnFaerdiggoer.setStyle("-fx-font-size: 2.5em ;");

		  lvwUdlejninger = new ListView<>();
		  lvwUdlejninger.setPrefSize(500, 450);
		  lvwUdlejninger.setFixedCellSize(50);
		  lvwUdlejninger.setStyle("-fx-font-size: 2.0em ;");
		  lvwUdlejninger.setItems(controller.getAktiveUdlejninger());
		  ChangeListener<Udlejning> listenerUdlejning = (ov, oldUdlejning, newUdlejning) -> actionUdlejningChanged(newUdlejning);
		  lvwUdlejninger.getSelectionModel().selectedItemProperty().addListener(listenerUdlejning);

		  VBox vbLeft = new VBox();
		  vbLeft.getChildren().add(lvwUdlejninger);
		  vbLeft.getChildren().add(btnFaerdiggoer);
		  vbLeft.setSpacing(20);
		  pane.add(vbLeft, 0, 0, 1, 2);

		  VBox vbInformation = new VBox();
		  Label lblInformation = new Label("Informationer");
		  lblInformation.setPrefSize(200, 35);
		  lblInformation.setFont(Font.font("Cambria", 25));
		  txaInformationer = new TextArea();
		  txaInformationer.setPrefSize(500, 415);
		  txaInformationer.setStyle("-fx-font-size: 1.5em ;");
		  vbInformation.getChildren().add(lblInformation);
		  vbInformation.getChildren().add(txaInformationer);
		  pane.add(vbInformation, 1, 0);

		  btnFaerdiggoer.setOnAction(e -> actionFaerdiggoer());
	 }

	 private void actionUdlejningChanged(Udlejning newUdl) {
		  if(newUdl != null){
				txaInformationer.setText(controller.getSalgsinformation(newUdl));
		  } else {
				txaInformationer.clear();
		  }
	 }

	 private void actionFaerdiggoer(){
		  try {
				Udlejning udlejning = lvwUdlejninger.getSelectionModel().getSelectedItem();
				BekraeftSalgWindow window = new BekraeftSalgWindow(udlejning);
				window.showAndWait();
				if (window.getOrderConfirmed()) {
					 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					 alert.setHeaderText("Udlejningen afsluttet.");
					 alert.setContentText("Udlejningen er nu afsluttet og betalt");
					 alert.showAndWait();
					 lvwUdlejninger.getItems().remove(udlejning);
				}
		  } catch (NullPointerException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText("Ingen udlejning valgt.");
				alert.setContentText("Vælg venligst en udlejning fra menuen til venstre");
				alert.showAndWait();
		  }

	 }

}
