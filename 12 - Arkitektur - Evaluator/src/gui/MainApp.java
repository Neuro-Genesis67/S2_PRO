package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.EmailEvaluator;
import model.FieldEvaluator;
import model.NumberEvaluator;

public class MainApp extends Application {

    private TextField txtNumber;
    private TextField txtEmail;
    private Controller controller;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Evaluator");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        pane.add(new Label("Tal"), 0, 0);
        pane.add(new Label("Email"), 0, 1);

        txtNumber = new TextField();
        pane.add(txtNumber, 1, 0);
        txtEmail = new TextField();
        pane.add(txtEmail, 1, 1);

        controller = new Controller();

        txtNumber.setOnKeyReleased(event -> this.controller.actionPerformed(txtNumber));
        txtEmail.setOnKeyReleased(event -> this.controller.actionPerformed(txtEmail));
    }

    private class Controller  {
        private FieldEvaluator evalEmail = new FieldEvaluator(new EmailEvaluator());
        private FieldEvaluator evalNumb = new FieldEvaluator(new NumberEvaluator());

        public void actionPerformed(TextField field) {
            if (field == txtNumber) {
                if (evalNumb.evaluate(txtNumber.getText())) {
                    txtNumber.setStyle("-fx-text-inner-color: green;");
                }
                else {
                    txtNumber.setStyle("-fx-text-inner-color: red;");
                }
            }
            else if (field == txtEmail) {
                if (evalEmail.evaluate(txtEmail.getText())) {
                    txtEmail.setStyle("-fx-text-inner-color: green;");
                }
                else {
                    txtEmail.setStyle("-fx-text-inner-color: red;");
                }
            }
        }
    }


}
