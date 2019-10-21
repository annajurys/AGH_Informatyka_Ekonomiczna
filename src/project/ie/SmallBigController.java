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
import java.util.LinkedList;
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
        String colName = excelFile.columns.get(0).colName;
        labelColName.setText(colName);

        i++;
    }

    @FXML
    private void onMouseClickedSmall(MouseEvent event) {
        if(i < excelFile.getColumns().size()) {
            excelFile.columns.get(i).setSmallOrBig(Columns.SmallOrBig.SMALL);
            if(excelFile.getColumns().getLast().getColumn()>i)
                setLabelName();
        }
        else {
            onMouseClickedContinue(event);
        }
    }

    @FXML
    private void onMouseClickedBig(MouseEvent event) {
        if(i < excelFile.getColumns().size()) {
            excelFile.columns.get(i).setSmallOrBig(Columns.SmallOrBig.SMALL);
            if(excelFile.getColumns().getLast().getColumn()>i)
                setLabelName();
        }
        else {
            onMouseClickedContinue(event);
        }
    }

    @FXML
    private void onMouseClickedContinue(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("result.fxml"));
            Parent root = (Parent) loader.load();

            ResultController controller = loader.getController();
            controller.setBorderPane(borderPane);

            borderPane.setBottom(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
