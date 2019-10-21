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

public class ChooseMethodOfFixingErrorsController implements Initializable {

    private BorderPane borderPane;
    private ExcelFile excelFile;

    protected void setBorderPaneAndExcelFile(BorderPane borderPane, ExcelFile excelFile) {
        this.borderPane = borderPane;
        this.excelFile = excelFile;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @FXML
    private void onMouseClickedBackToLoadFile(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("load_file.fxml"));
            Parent root = (Parent) loader.load();

            LoadFileController controller = loader.getController();
            controller.setBorderPane(borderPane);

            borderPane.setBottom(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onMouseClickedShowAndCorrectErrors(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("correct_errors.fxml"));
            Parent root = (Parent) loader.load();

            CorrectErrorsController controller = loader.getController();
            controller.setBorderPaneAndExcelFile(borderPane, excelFile);

            borderPane.setBottom(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onMouseClickedUseAverageOfColumn(MouseEvent event) {

    }

    @FXML
    private void onMouseClickedRemoveAllFaultyRows(MouseEvent event) {

    }

}
