package project.ie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultController implements Initializable {

    private BorderPane borderPane;

    protected void setBorderPane(BorderPane borderPane) { this.borderPane = borderPane; }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
