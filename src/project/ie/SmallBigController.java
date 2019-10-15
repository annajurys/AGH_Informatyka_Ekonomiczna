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

public class SmallBigController implements Initializable {

    private BorderPane borderPane;

    @FXML
    Label labelHelp, labelColName;

    @FXML
    Button buttonSmall, buttonBig;



    protected void initVariables(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //ExcelFile f = new ExcelFile();
        //labelColName.setText(f.getColumns().get(0).colName);
    }

    @FXML
    private void onMouseClickedSmall(MouseEvent event) {

    }

    @FXML
    private void onMouseClickedBig(MouseEvent event) {

    }
}
