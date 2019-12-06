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
    private ExcelFile excelFile;
    private int i;

    @FXML
    Label labelHelp, labelColName;

    @FXML
    Button buttonSmall, buttonBig;


    protected void setBorderPaneAndExcelFile(BorderPane borderPane, ExcelFile excelFile) {
        this.borderPane = borderPane;
        this.excelFile = excelFile;
        setLabelName();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        i=0;
    }

    public void setLabelName() {
        String colName = excelFile.columns.get(i).colName;
        labelColName.setText(colName);
    }

    @FXML
    private void onMouseClickedSmall(MouseEvent event) {
        excelFile.columns.get(i).setSmallOrBig(Column.SmallOrBig.SMALL);

        if(i < excelFile.getColumns().size()-1) {
            i++;
            setLabelName();
        }
        else {
            goToResult();
        }
    }

    @FXML
    private void onMouseClickedBig(MouseEvent event) {
        excelFile.columns.get(i).setSmallOrBig(Column.SmallOrBig.BIG);

        if(i < excelFile.getColumns().size()-1) {
            i++;
            setLabelName();
        }
        else {
            goToResult();
        }
    }

    public void goToResult() {
        for(int i = 0; i < excelFile.columns.size(); i++) {
            excelFile.columns.get(i).Normalization();
            //System.out.println(excelFile.columns.get(i).normalized);
            //System.out.println(excelFile.columns.get(i).BestChoice());
        }

        excelFile.Distances();
        /*for(int i = 0; i < excelFile.choiceNames.size(); i++) {
            System.out.println(excelFile.choiceNames.get(i).distance);
        }*/

        excelFile.Sort();
        /*System.out.println(excelFile.choiceNames);*/

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("result.fxml"));
            Parent root = (Parent) loader.load();

            ResultController controller = loader.getController();
            controller.setBorderPaneAndExcelFile(borderPane, excelFile);

            borderPane.setBottom(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
