package project.ie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuViewController implements Initializable {

    @FXML
    BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setGUI("Hello");
    }

    private void setGUI(String name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(name + ".fxml"));
            Parent root = (Parent) loader.load();

            switch(name) {
                case "Hello":
                    HelloController helloController = loader.getController();
                    helloController.setBorderPane(borderPane);
                    break;
            }

            borderPane.setBottom(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
