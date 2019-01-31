package gui;

import controller.Controller;
import gui.udlejning.UdlejningWindow;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import storage.Storage;

public class MainApp extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Kasseapparatssystem");
		BorderPane pane = new BorderPane();
		// instantierer controller og storage for at oprette vores data
		Controller.getInstance();
		Storage.getInstance().initContent();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.setMinHeight(160);
		stage.setMinWidth(330);
		stage.show();
	}

	private void initContent(BorderPane pane) {
		GridPane gridPane = new GridPane();
		initGridPane(gridPane);
		pane.setCenter(gridPane);
		pane.setPadding(new Insets(10));

	}

	private void initGridPane(GridPane gridPane) {
		// gridPane.setGridLinesVisible(true);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(20);
		gridPane.setVgap(10);

		Label lblTitel = new Label("AARHUS BRYGHUS");
		gridPane.add(lblTitel, 0, 0);
		lblTitel.setFont(Font.font("Cambria", 64)); // TODO: Find en flot font

		VBox vbButtons = new VBox();
		vbButtons.setAlignment(Pos.CENTER);
		vbButtons.setSpacing(10);

		gridPane.add(vbButtons, 0, 1);

		Button btnSalg = new Button("Salg");
		btnSalg.setPrefSize(350, 75);
		btnSalg.setFont(Font.font("Bold Arial", 40));
		vbButtons.getChildren().add(btnSalg);

		Button btnUdlejning = new Button("Udlejning");
		btnUdlejning.setPrefSize(350, 75);
		btnUdlejning.setFont(Font.font("Bold Arial", 40));
		vbButtons.getChildren().add(btnUdlejning);

		Button btnAdministration = new Button("Administration");
		btnAdministration.setPrefSize(350, 75);
		btnAdministration.setFont(Font.font("Bold Arial", 40));
		vbButtons.getChildren().add(btnAdministration);

		Button btnStatistik = new Button("Statistik");
		btnStatistik.setPrefSize(350, 75);
		btnStatistik.setFont(Font.font("Bold Arial", 40));
		vbButtons.getChildren().add(btnStatistik);

		btnSalg.setOnAction(event -> visSalgWindow());
		btnUdlejning.setOnAction(event -> visUdlejningWindow());
		btnAdministration.setOnAction(event -> visAdministrationWindow());
		btnStatistik.setOnAction(event -> visStatistikWindow());

	}

	private void visSalgWindow() {
		SalgWindow salgWindow = new SalgWindow();
		salgWindow.showAndWait();
	}

	private void visAdministrationWindow() {
		AdministrationWindow administrationWindow = new AdministrationWindow();
		administrationWindow.showAndWait();
	}

	private void visStatistikWindow() {
		StatistikWindow statistikWindow = new StatistikWindow();
		statistikWindow.showAndWait();
	}

	private void visUdlejningWindow() {
		UdlejningWindow udlejningWindow = new UdlejningWindow();
		udlejningWindow.showAndWait();
	}
}
