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

public class OutliersController implements Initializable {

    private BorderPane borderPane;
    ExcelFile excelFile;

    @FXML
    Label labelOutliers, labelOutlier;

    @FXML
    Button buttonFixTheOutliers;

    protected void setBorderPaneAndExcelFile(BorderPane borderPane, ExcelFile excelFile) {
        this.borderPane = borderPane;
        this.excelFile = excelFile;
        for(int i=0;i<excelFile.getColumns().size();i++) {
            for(int j=0;j<excelFile.getChoiceNames().size();j++) {
                if(excelFile.getColumns().get(i).objects.get(j) == null) {
                    labelOutlier.setText(labelOutlier.getText() + "Outlier in " + excelFile.getColumns().get(i).colName + " in " + excelFile.getChoiceNames().get(j).choiceName + "\n");
                }
            }
        }
    }

    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void onMouseClickedFixTheOutliers(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("choose_method_of_fixing_errors.fxml"));
            Parent root = (Parent) loader.load();

            ChooseMethodOfFixingErrorsController controller = loader.getController();
            controller.setBorderPaneAndExcelFile(borderPane,excelFile);

            borderPane.setBottom(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
