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
    private ExcelFile excelFile;

    public void setBorderPaneAndExcelFile(BorderPane borderPane, ExcelFile excelFile) {
        this.borderPane = borderPane;
        this.excelFile = excelFile;

        System.out.println("-------------------");
        for (int i = 0; i < excelFile.columns.size(); i++) {
            for (int j = 0; j < excelFile.columns.get(i).objects.size(); j++) {
                //System.out.println("wartość dla wiersza: " + (i+1) + " i dla kolumny: " + j);
                System.out.println(excelFile.columns.get(i).objects.get(j));
                //System.out.println("znormalizowana: ");
                //excelFile.columns.get(i).normalized.get(j);

            }
            System.out.println("Small/Big");
            System.out.println(excelFile.columns.get(i).smallOrBig);
            //System.out.println("BestChoice");
            //System.out.println(excelFile.columns.get(i).BestChoice());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
