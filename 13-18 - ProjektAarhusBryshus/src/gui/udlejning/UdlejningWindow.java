package gui.udlejning;

import java.time.LocalDate;

import controller.Controller;
import gui.BekraeftSalgWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Listepris;
import model.Salgslinie;
import model.Udlejning;

public class UdlejningWindow extends Stage {
	private Controller controller;

	public UdlejningWindow() {
		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane);
		gridPane.setPadding(new Insets(10));
		controller = Controller.getInstance();
		aktuelUdlejning = controller.confirmUdlejning();
		this.setScene(scene);
		this.initGridpane(gridPane);
		this.setTitle("Udlejning");
	}

	private ListView<Listepris> lvwListepriser;
	private ListView<Salgslinie> lvwIndkoebskurv;
	private Udlejning aktuelUdlejning;
	private TextField txfAntal;
	private DatePicker udlejningsdato;
	private DatePicker afleveringsdato;
	private TextArea txaDetaljer;

	private void initGridpane(GridPane pane) {
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(50);
		pane.setHgap(50);
		this.setMaximized(true);

		VBox vbLeft = new VBox();
		vbLeft.setSpacing(100);
		vbLeft.setAlignment(Pos.CENTER_LEFT);
		lvwListepriser = new ListView<>();

		Controller controller = Controller.getInstance();

		lvwListepriser.getItems().setAll(controller.getUdlejningspriser());
		lvwListepriser.getSelectionModel().selectFirst();
		lvwListepriser.setPrefSize(500, 735);
		lvwListepriser.setFixedCellSize(50);
		lvwListepriser.setStyle("-fx-font-size: 2.0em ;");

		vbLeft.getChildren().add(lvwListepriser);

		VBox vbCenter = new VBox();
		vbCenter.setSpacing(10);
		vbCenter.setAlignment(Pos.CENTER);
		HBox hbCheckBox = new HBox();
		hbCheckBox.setAlignment(Pos.CENTER);
		hbCheckBox.setSpacing(10);

		Button button1 = new Button("1");
		Button button2 = new Button("2");
		Button button3 = new Button("3");
		Button button4 = new Button("4");
		Button button5 = new Button("5");

		button1.setPrefSize(80, 35);
		button1.setStyle("-fx-font-size: 2.5em ;");
		button2.setPrefSize(80, 35);
		button2.setStyle("-fx-font-size: 2.5em ;");
		button3.setPrefSize(80, 35);
		button3.setStyle("-fx-font-size: 2.5em ;");
		button4.setPrefSize(80, 35);
		button4.setStyle("-fx-font-size: 2.5em ;");
		button5.setPrefSize(80, 35);
		button5.setStyle("-fx-font-size: 2.5em ;");

		button1.setOnAction(e -> actionCheckBox(button1));
		button2.setOnAction(e -> actionCheckBox(button2));
		button3.setOnAction(e -> actionCheckBox(button3));
		button4.setOnAction(e -> actionCheckBox(button4));
		button5.setOnAction(e -> actionCheckBox(button5));

		hbCheckBox.getChildren().add(button1);
		hbCheckBox.getChildren().add(button2);
		hbCheckBox.getChildren().add(button3);
		hbCheckBox.getChildren().add(button4);
		hbCheckBox.getChildren().add(button5);

		Button btnAktive = new Button("Aktive udlejninger");
		btnAktive.setPrefSize(500, 115);
		btnAktive.setStyle("-fx-font-size: 2.5em ;");
		HBox hbBottomLeft = new HBox();
		pane.add(hbBottomLeft, 0, 2);
		hbBottomLeft.getChildren().add(btnAktive);

		Button btnTilfoej = new Button("Tilføj");
		Button btnFjern = new Button("Fjern");
		btnTilfoej.setStyle("-fx-font-size: 2.5em ;");
		btnTilfoej.setPrefSize(200, 70);
		btnFjern.setStyle("-fx-font-size: 2.5em ;");
		btnFjern.setPrefSize(200, 70);

		txfAntal = new TextField("1");
		txfAntal.setPromptText("Antal");
		txfAntal.setPrefSize(150, 25);
		txfAntal.setStyle("-fx-font-size: 2.0em ;");

		udlejningsdato = new DatePicker(LocalDate.now());
		afleveringsdato = new DatePicker(LocalDate.now());
		udlejningsdato.setPrefSize(200, 30);
		udlejningsdato.setStyle("-fx-font-size: 2.0em ;");
		afleveringsdato.setPrefSize(200, 30);
		afleveringsdato.setStyle("-fx-font-size: 2.0em ;");

		Label lbludlejningsdato = new Label("Udlejningsdato");
		Label lblafleveringsdato = new Label("Afleveringsdato");

		lbludlejningsdato.setPrefSize(200, 35);
		lbludlejningsdato.setFont(Font.font("Cambria", 25));
		lblafleveringsdato.setPrefSize(200, 35);
		lblafleveringsdato.setFont(Font.font("Cambria", 25));

		HBox hbDate1 = new HBox();
		HBox hbDate2 = new HBox();
		hbDate1.getChildren().add(lbludlejningsdato);
		hbDate1.getChildren().add(udlejningsdato);
		hbDate2.getChildren().add(lblafleveringsdato);
		hbDate2.getChildren().add(afleveringsdato);
		hbDate1.setSpacing(40);
		hbDate2.setSpacing(40);
		hbDate1.setAlignment(Pos.CENTER);
		hbDate2.setAlignment(Pos.CENTER);

		HBox hbTilfoejFjern = new HBox();
		hbTilfoejFjern.setSpacing(50);
		hbTilfoejFjern.getChildren().add(btnTilfoej);
		hbTilfoejFjern.getChildren().add(btnFjern);

		Label lblAntal = new Label("Antal:");
		lblAntal.setPrefSize(80, 35);
		lblAntal.setFont(Font.font("Cambria", 25));

		vbCenter.getChildren().add(lblAntal);
		vbCenter.getChildren().add(hbCheckBox);
		vbCenter.getChildren().add(txfAntal);
		vbCenter.getChildren().add(hbTilfoejFjern);
		vbCenter.getChildren().add(hbDate1);
		vbCenter.getChildren().add(hbDate2);
		vbCenter.setSpacing(40);

		VBox vbRight = new VBox();
		vbRight.setSpacing(10);
		vbRight.setAlignment(Pos.CENTER_RIGHT);

		lvwIndkoebskurv = new ListView<>();
		vbRight.getChildren().add(lvwIndkoebskurv); // TODO
		lvwIndkoebskurv.setItems(controller.getSalgslinier(aktuelUdlejning));
		lvwIndkoebskurv.setPrefSize(500, 450);
		lvwIndkoebskurv.setFixedCellSize(50);
		lvwIndkoebskurv.setStyle("-fx-font-size: 2.0em ;");

		pane.add(vbLeft, 0, 1);
		pane.add(vbCenter, 1, 1);
		pane.add(vbRight, 2, 1);
		// pane.add(child, columnIndex, rowIndex);

		txaDetaljer = new TextArea();
		txaDetaljer.setPromptText("Udlejningens detaljer kan indtastes her");
		txaDetaljer.setStyle("-fx-font-size: 1.5em ;");

		vbRight.getChildren().add(txaDetaljer); // TODO

		HBox hbBottom = new HBox();
		hbBottom.setSpacing(75);
		pane.add(hbBottom, 2, 2);
		Button btnOpret = new Button("Opret");
		Button btnAnnuller = new Button("Annuller");
		btnOpret.setPrefSize(250, 115);
		btnOpret.setStyle("-fx-font-size: 2.5em ;");
		btnAnnuller.setPrefSize(250, 115);
		btnAnnuller.setStyle("-fx-font-size: 2.5em ;");
		hbBottom.getChildren().add(btnOpret);
		hbBottom.getChildren().add(btnAnnuller);

		btnTilfoej.setOnAction(e -> actionTilfoej(lvwListepriser.getSelectionModel().getSelectedItem()));
		btnFjern.setOnAction(e -> actionFjern(lvwIndkoebskurv.getSelectionModel().getSelectedItem()));
		btnAnnuller.setOnAction(e -> actionAnnuller());
		btnOpret.setOnAction(e -> actionOpret());
		btnAktive.setOnAction(e -> actionAktive());

	}

	private void actionAktive() {
		AktiveUdlejningerWindow window = new AktiveUdlejningerWindow();
		window.showAndWait();
		close();
	}

	private void actionCheckBox(Button button) {
		txfAntal.setText(button.getText());
	}

	private void actionTilfoej(Listepris listepris) {
		try {
			String antal = txfAntal.getText();
			controller.opretSalgslinie(aktuelUdlejning, antal, listepris);
			lvwIndkoebskurv.getSelectionModel().selectLast();
			txfAntal.setText("1");
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
		}

	}

	private void actionFjern(Salgslinie salgslinie) {
		controller.removeSalgslinie(aktuelUdlejning, salgslinie);
	}

	private void actionAnnuller() {
		controller.removeUdlejning(aktuelUdlejning);
		close();
	}

	private void actionOpret() {
		if (lvwIndkoebskurv.getItems().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText("Kurven er tom");
			alert.setContentText("Man skal ikke sælge skindet før bjørnen er skudt");
			alert.showAndWait();
		} else {

			controller.confirmUdlejning(aktuelUdlejning, udlejningsdato.getValue(), afleveringsdato.getValue(),
					txaDetaljer.getText());

			BekraeftSalgWindow confirm = new BekraeftSalgWindow(aktuelUdlejning);
			confirm.showAndWait();
			if (confirm.getOrderConfirmed()) {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText("Ordre oprettet.");
				alert.setContentText("Ordren er nu registreret i systemet.");
				clearOptions();
				alert.showAndWait();

			} else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Ikke bekræftet");
				alert.setContentText("Ordren blev ikke bekræftet.");
				alert.showAndWait();
			}
		}
	}

	private void clearOptions() {
		aktuelUdlejning = controller.confirmUdlejning();
		lvwIndkoebskurv.setItems(controller.getSalgslinier(aktuelUdlejning));
		txaDetaljer.clear();
	}
}
