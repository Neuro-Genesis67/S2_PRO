package gui;

import gui.Administration.PrislistePane;
import gui.Administration.ProduktPane;
import gui.Administration.ProduktgruppePane;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class AdministrationWindow extends Stage {

	AdministrationWindow() {
		BorderPane pane = new BorderPane();
		Scene scene = new Scene(pane);
		this.setMaximized(true);
		this.initContent(pane);
		this.setScene(scene);
		this.setTitle("Administration");
	}

	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();

		tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

		Tab tabProdukt = new Tab("Produkter");

		tabPane.getTabs().add(tabProdukt);

		Tab tabProduktgruppe = new Tab("Produktgrupper");
		tabPane.getTabs().add(tabProduktgruppe);

		Tab tabPrisgruppe = new Tab("Prislister");
		tabPane.getTabs().add(tabPrisgruppe);

		ProduktPane produktPane = new ProduktPane();
		tabProdukt.setContent(produktPane);

		ProduktgruppePane produktgruppePane = new ProduktgruppePane();
		tabProduktgruppe.setContent(produktgruppePane);

		PrislistePane prisgruppePane = new PrislistePane();
		tabPrisgruppe.setContent(prisgruppePane);
		tabPrisgruppe.setOnSelectionChanged(event -> prisgruppePane.refresh());

		pane.setCenter(tabPane);

	}

}
