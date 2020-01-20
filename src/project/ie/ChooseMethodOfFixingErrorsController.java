package project.ie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
        for(int i = 0; i < excelFile.columns.size(); i++) {
            Column column = excelFile.columns.get(i);
            Double average = column.Average();
            for(int j = 0; j < column.objects.size(); j++) {
                if (column.objects.get(j) == null) {
                    column.objects.set(j, average);
                }
            }
        }
        goToSmallBig();
    }

    @FXML
    private void onMouseClickedRemoveAllFaultyRows(MouseEvent event) {
        RemoveAllFaultyRows removeAllFaultyRows = new RemoveAllFaultyRows();
        removeAllFaultyRows.setExcelFile(excelFile);
        removeAllFaultyRows.removeAllFaultyRows();

        goToSmallBig();
    }

    public void goToSmallBig() {
        boolean outliers = excelFile.findOutliers();
        if(outliers == true) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("outliers.fxml"));
                Parent root = (Parent) loader.load();

                OutliersController controller = loader.getController();
                controller.setBorderPaneAndExcelFile(borderPane, excelFile);

                borderPane.setBottom(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("smallBig.fxml"));
                Parent root = (Parent) loader.load();

                SmallBigController controller = loader.getController();
                controller.setBorderPaneAndExcelFile(borderPane, excelFile);

                borderPane.setBottom(root);
        }   catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
