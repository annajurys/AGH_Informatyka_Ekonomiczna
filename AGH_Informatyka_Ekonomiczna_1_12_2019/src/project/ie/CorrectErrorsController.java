package project.ie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CorrectErrorsController implements Initializable {

    private BorderPane borderPane;
    private ExcelFile excelFile;
    //private LinkedList<Integer> listOfNullColumns = new LinkedList<>();
    //private LinkedList<Integer> listOfNullRows = new LinkedList<>();
    //private LinkedList<String> listOfChoiceNames = new LinkedList<>();
    //private LinkedList<String> listOfColNames = new LinkedList<>();
    private int i, j;

    @FXML
    Label labelHelp, labelPlace;

    @FXML
    TextField textFieldValue;

    @FXML
    Button buttonSave;

    protected void setBorderPaneAndExcelFile(BorderPane borderPane, ExcelFile excelFile) {
        this.borderPane = borderPane;
        this.excelFile = excelFile;

        i=0;
        j=0;

        setLabelPlace();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //doListOfNulls();
        //i=0;
        //for(int e=0;e<listOfChoiceNames.size();e++)
        //{
        //    System.out.println(listOfChoiceNames.get(e).toString());
        //}
    }

    public void setLabelPlace() {
        String text = null;
        boolean foundNullValue = false;
        i=0;
        while (i < excelFile.columns.size() && !foundNullValue) {
            j=0;
            while (j < excelFile.columns.get(i).objects.size() && !foundNullValue) {
                if (excelFile.columns.get(i).objects.get(j) == "null") {
                    foundNullValue = true;
                    text = excelFile.columns.get(i).colName + " " + excelFile.choiceNames.get(j).choiceName;

                }

                j++;
            }
            i++;
        }

        i--;
        j--;

        if(!foundNullValue)
            openSmallBig();
        else {
            labelPlace.setText(text);
        }
    }

    public void openSmallBig() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("smallBig.fxml"));
            Parent root = (Parent) loader.load();

            SmallBigController controller = loader.getController();
            controller.setBorderPaneAndExcelFile(borderPane,  excelFile);

            borderPane.setBottom(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onMouseClickedSave(MouseEvent event) {
        System.out.println("zzz " + i + " " + j);

        excelFile.columns.get(i).objects.set(j, textFieldValue.getText()); //sprawdzic czy to int
        textFieldValue.clear();
        setLabelPlace();
    }


    /*
    public void doListOfNulls() {
        for(int i_1=0;i_1<excelFile.getColumns().size();i_1++) {
            for(int j=0;j<excelFile.getChoiceNames().size();j++) {
                if(excelFile.getColumns().get(i_1).objects.get(j).toString()=="null") {
                    listOfNullColumns.add(i);
                    listOfNullRows.add(j);
                    listOfChoiceNames.add(excelFile.getChoiceNames().get(j).choiceName);
                    listOfColNames.add(excelFile.columns.get(i).colName);

                }
            }
        }
        i++;
    }
    */
}
