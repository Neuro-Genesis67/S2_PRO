package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import ur.Observer;
import ur.Subject;
import ur.Ur;

public class MainApp extends Application implements Initializable, Observer {

    public static void main(String[] args) {
        launch(args);
    }
    
    @FXML
    private Button myButton;
    @FXML
    private TextField myField;
    
    private Ur ur = new Ur();

    @Override
    public void start(Stage stage) {
        stage.setTitle("My JavaFX App");
        
        ClassLoader contextLoader = Thread.currentThread().getContextClassLoader();
        URL url = contextLoader.getResource("root.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        try {
            BorderPane pane = (BorderPane) loader.load();
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setHeight(500);
            stage.setWidth(800);
            stage.show();
        } catch (IOException e) {
            System.out.println("Problem loading layout: " + e.getMessage());
            System.out.println(e.getCause());
        }
        
    }
    
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL location, ResourceBundle resources) {
        myButton.setOnAction(event -> handleButtonAction(event));
        ur.registerObserver(this);
    }

    private void handleButtonAction(ActionEvent event) {
        ur.tiktak();
    }

    @Override
    public void update(Subject o) {
        if (o instanceof Ur) {
            Ur subjectUr = (Ur) o;
            subjectUr.getTid();
            myField.setText(subjectUr.getTid() + "");
        }
    }

}
