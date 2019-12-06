package project.ie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadFileController implements Initializable {

    private BorderPane borderPane;

    File file;
    String fileAbsolutePath;
    GetExcelFile excel;
    ExcelFile excelFile;

    @FXML
    Label labelLoadFile, labelError;

    @FXML
    Button buttonFixTheErrors, buttonContinue;

    protected void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource ExcelFile");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XLSX or XLS files (*.xlsx or *.xls)", "*.xlsx", ".xls");
        fileChooser.getExtensionFilters().add(extFilter);

        Window stage = new Stage();
        //file = fileChooser.showOpenDialog(stage);
        //fileAbsolutePath = file.getAbsolutePath();

        fileAbsolutePath = "C:\\Users\\AJ\\Desktop\\1kopia.xlsx";
        //TODO: Odkomentuj powzszy kod i usun fileAbsolutePath (ostatnie)

        labelLoadFile.setText("You choose a file: " + fileAbsolutePath);
        excel = new GetExcelFile(fileAbsolutePath);
        excelFile = excel.getExcelFileAndSaveInExcelFile();

        for(int i=0;i<excelFile.getColumns().size();i++) {
            for(int j=0;j<excelFile.getChoiceNames().size();j++) {
                if(excelFile.getColumns().get(i).objects.get(j).toString()=="null") {
                    labelError.setText(labelError.getText() + "Error: Empty cell or not numeric value in " + excelFile.getColumns().get(i).colName + " in " + excelFile.getChoiceNames().get(j).choiceName + "\n");
                }
            }
        }
        if(labelError.getText().isEmpty()) {
            buttonFixTheErrors.setVisible(false);
            labelError.setVisible(false);
        }
        else {
            buttonContinue.setVisible(false);
        }
    }

    @FXML
    private void onMouseClickedContinue(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("smallBig.fxml"));
            Parent root = (Parent) loader.load();

            SmallBigController controller = loader.getController();
            controller.setBorderPaneAndExcelFile(borderPane, excelFile);

            borderPane.setBottom(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onMouseClickedFixTheErrors(MouseEvent event) {
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
