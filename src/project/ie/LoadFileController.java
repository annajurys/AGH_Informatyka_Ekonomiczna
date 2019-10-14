package project.ie;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
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

    @FXML
    Label labelLoadFile, labelError;

    protected void initVariables(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource ExcelFile");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XLSX or XLS files (*.xlsx or *.xls)", "*.xlsx", ".xls");
        fileChooser.getExtensionFilters().add(extFilter);

        Window stage = new Stage();
        file = fileChooser.showOpenDialog(stage);
        fileAbsolutePath = file.getAbsolutePath();
        */
        fileAbsolutePath = "C:\\Users\\AJ\\Desktop\\1.xlsx";
        //TODO: Odkomentuj powzszy kod i usun fileAbsolutePath (ostatnie)

        labelLoadFile.setText("You choose a file: " + fileAbsolutePath);
        ReadExcel re = new ReadExcel(fileAbsolutePath);
        re.readExcelFile();

    }
}
