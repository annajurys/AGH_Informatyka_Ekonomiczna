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

public class HelloController implements Initializable {

    private BorderPane borderPane;

    @FXML
    Label labelHello;

    @FXML
    Button buttonInstruction, buttonLoadFile;

    protected void initVariables(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @FXML
    private void onMouseClickedInstruction(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("instruction.fxml"));
            Parent root = (Parent) loader.load();

            InstructionController controller = loader.getController();
            controller.initVariables(borderPane);

            borderPane.setBottom(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onMouseClickedLoadFile(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("load_file.fxml"));
            Parent root = (Parent) loader.load();

            LoadFileController controller = loader.getController();

            borderPane.setBottom(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
