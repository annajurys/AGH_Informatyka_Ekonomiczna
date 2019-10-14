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

public class InstructionController implements Initializable {

    private BorderPane borderPane;

    @FXML
    Label labelInstruction;


    @FXML
    Button buttonBackToMainView;

    protected void initVariables(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelInstruction.setWrapText(true);

    }

    @FXML
    private void onMouseClickedBackToMainView(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello.fxml"));
            Parent root = (Parent) loader.load();

            HelloController controller = loader.getController();
            controller.initVariables(borderPane);

            borderPane.setBottom(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
