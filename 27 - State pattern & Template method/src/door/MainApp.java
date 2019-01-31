package door;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application implements Observer {
    private Label txfState;
    private Button btnPush;
    private Door door;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("The Door");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private void initContent(GridPane pane) {
		door = new Door();
		door.addObserver(this);

		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);

		txfState = new Label();
		txfState.setFont(Font.font(50));
		txfState.setStyle("-fx-text-fill: #FACC2E; -fx-background-color: #0B4C5F");
		txfState.setFocusTraversable(false);
		txfState.setMinHeight(100);
		txfState.setMinWidth(300);
		txfState.setText(door.getState() + "");
		txfState.setAlignment(Pos.CENTER);
		
		pane.add(txfState, 0, 0);
		
		btnPush = new Button("PUSH");
		btnPush.setFont(Font.font(20));
		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(btnPush);
		pane.add(box, 0, 1);

		btnPush.setOnAction(event -> this.pushAction());
	}

	private void pushAction() {
		door.click();
	}

	@Override
	public void update(Door aDoor) {
		txfState.setText(aDoor.getState() + "");
	}
}
