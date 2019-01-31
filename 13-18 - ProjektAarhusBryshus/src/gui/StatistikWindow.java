package gui;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class StatistikWindow extends Stage {

	StatistikWindow() {
		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane);
		this.setScene(scene);
		this.initGridpane(gridPane);
		this.setTitle("Statistik");
	}

	private TextArea txaOutput;
	private DatePicker dpStart;
	private DatePicker dpEnd;
	private Label lblPeriodestart = new Label("Startdato");
	private Label lblPeriodeslut = new Label("Slutdato");

	private void initGridpane(GridPane pane) {
		pane.setVgap(50);
		pane.setHgap(50);
		pane.setAlignment(Pos.CENTER);
		lblPeriodestart.setPrefSize(500, 65);
		lblPeriodestart.setFont(Font.font("Cambria", 30));
		lblPeriodeslut.setPrefSize(500, 65);
		lblPeriodeslut.setFont(Font.font("Cambria", 30));

		this.setMaximized(true);

		dpStart = new DatePicker(LocalDate.now());
		dpEnd = new DatePicker(LocalDate.now().plus(1, DAYS));
		dpStart.setPrefSize(300, 35);
		dpStart.setStyle("-fx-font-size: 2.7em ;");
		dpEnd.setPrefSize(300, 35);
		dpEnd.setStyle("-fx-font-size: 2.7em ;");

		Button btnBeregn = new Button("Beregn");
		btnBeregn.setStyle("-fx-font-size: 2.5em ;");
		btnBeregn.setPrefSize(300, 150);

		ToggleGroup tgStatistik = new ToggleGroup();
		RadioButton rbDagsSalg = new RadioButton("Dagens salg");
		RadioButton rbSolgteKlip = new RadioButton("Solgte klip for periode");
		RadioButton rbForbrugteKlip = new RadioButton("Forbrugte klip for periode");
		rbDagsSalg.setSelected(true);
		rbDagsSalg.setToggleGroup(tgStatistik);
		rbSolgteKlip.setToggleGroup(tgStatistik);
		rbForbrugteKlip.setToggleGroup(tgStatistik);
		VBox vbLeft = new VBox();
		VBox vbRadiobuttons = new VBox();
		VBox vbDatepickers = new VBox();
		vbRadiobuttons.getChildren().add(rbDagsSalg);
		vbRadiobuttons.getChildren().add(rbSolgteKlip);
		vbRadiobuttons.getChildren().add(rbForbrugteKlip);
		vbDatepickers.getChildren().add(lblPeriodestart);
		vbDatepickers.getChildren().add(dpStart);
		vbDatepickers.getChildren().add(lblPeriodeslut);
		vbDatepickers.getChildren().add(dpEnd);
		vbLeft.setSpacing(100);
		vbRadiobuttons.setSpacing(10);

		rbDagsSalg.setPrefSize(500, 65);
		rbDagsSalg.setFont(Font.font("Cambria", 30));
		rbSolgteKlip.setPrefSize(500, 65);
		rbSolgteKlip.setFont(Font.font("Cambria", 30));
		rbForbrugteKlip.setPrefSize(500, 65);
		rbForbrugteKlip.setFont(Font.font("Cambria", 30));

		vbLeft.getChildren().add(vbRadiobuttons);
		vbLeft.getChildren().add(vbDatepickers);
		vbLeft.getChildren().add(btnBeregn);

		txaOutput = new TextArea();
		txaOutput.setPrefSize(800, 800);
		pane.add(txaOutput, 2, 0);
		pane.add(vbLeft, 1, 0);

		btnBeregn.setOnAction(event -> actionBeregn((RadioButton) tgStatistik.getSelectedToggle()));

	}

	private void actionBeregn(RadioButton toggled) {

		Controller controller = Controller.getInstance();
		String output = "";
		switch (toggled.getText()) {
			case "Dagens salg": {
				output = controller.getDagssalg();
				break;
			}
			case "Solgte klip for periode": {
				try {
					output = controller.solgteKlippekort(dpStart.getValue(), dpEnd.getValue());
					break;
				} catch (IllegalArgumentException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("Fejl i datoer");
					alert.setContentText(e.getMessage());
					alert.showAndWait();
				}

			}
			case "Forbrugte klip for periode": {
				output = controller.forbrugteKlip(dpStart.getValue(), dpEnd.getValue());
				break;
			}
		}
		txaOutput.setText(output);
		txaOutput.setStyle("-fx-font-size: 2.0em ;");

	}
}
