package project.ie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

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
        fileAbsolutePath = "C:\\Users\\AJ\\Desktop\\1kopia.xlsx";
        //TODO: Odkomentuj powzszy kod i usun fileAbsolutePath (ostatnie)

        labelLoadFile.setText("You choose a file: " + fileAbsolutePath);
        ReadExcel re = new ReadExcel(fileAbsolutePath);
        re.readExcelFile();

    }
    @FXML
    private void onMouseClickedContinue(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("smallBig.fxml"));
            Parent root = (Parent) loader.load();

            SmallBigController controller = loader.getController();
            controller.initVariables(borderPane);

            borderPane.setBottom(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
