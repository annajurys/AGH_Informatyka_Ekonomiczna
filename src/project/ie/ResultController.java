package project.ie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ResultController implements Initializable {

    private BorderPane borderPane;
    private ExcelFile excelFile;

    @FXML
    Label labelResults, labelResults1, labelResultsRight;

    @FXML
    ImageView imageViewStar1, imageViewStar2, imageViewStar3, imageViewStar4, imageViewStar5, imageViewStar6, imageViewStar7, imageViewStar8, imageViewStar9;

    @FXML
    LinkedList <ImageView> stars;


    public void setBorderPaneAndExcelFile(BorderPane borderPane, ExcelFile excelFile) {
        this.borderPane = borderPane;
        this.excelFile = excelFile;

        stars = new LinkedList<>();
        stars.add(imageViewStar1);
        stars.add(imageViewStar2);
        stars.add(imageViewStar3);
        stars.add(imageViewStar4);
        stars.add(imageViewStar5);
        stars.add(imageViewStar6);
        stars.add(imageViewStar7);
        stars.add(imageViewStar8);
        stars.add(imageViewStar9);

        excelFile.Distances();

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilderRight = new StringBuilder(System.lineSeparator());

        for(int i = 0; i < excelFile.columns.size(); i++) {
            int number_of_adds = 0;
            Column column = excelFile.columns.get(i);
            stringBuilder.append(System.lineSeparator() + column.colName + ":");
            for(int j = 0; j < column.normalized.size(); j++) {
                if(column.normalized.get(j).doubleValue() == column.best.doubleValue()) {
                    number_of_adds++;
                }
            }
            int now = 1;
            for(int j = 0; j < column.normalized.size(); j++) {
                if(column.normalized.get(j).doubleValue() == column.best.doubleValue() && now!=number_of_adds) {
                    stringBuilderRight.append(" " + excelFile.choiceNames.get(j)+",");
                    now++;
                }
                else if(column.normalized.get(j).doubleValue() == column.best.doubleValue() && now==number_of_adds) {
                    stringBuilderRight.append(" " + excelFile.choiceNames.get(j));
                }
            }

            stringBuilderRight.append(System.lineSeparator());
        }

        labelResults.setText(stringBuilder.toString());
        labelResultsRight.setText(stringBuilderRight.toString());

        /*
        String results = "";
        for(int i = 0; i < excelFile.columns.size(); i++) {
            Column column = excelFile.columns.get(i);
            results += System.lineSeparator() + column.colName + ":";
            for(int j = 0; j < column.normalized.size(); j++) {
                if(column.normalized.get(j).doubleValue() == column.best.doubleValue()) {
                    results += " " + excelFile.choiceNames.get(j);
                }
            }
        }
        labelResults.setText(results);
        */

        //TESTOWANIE cz.1 - choiceNames przed posortowaniem
        System.out.println("-------------------");
        System.out.println("Opcje: ");
        for(int i = 0; i < excelFile.choiceNames.size(); i++) {
            System.out.println(excelFile.choiceNames.get(i).choiceName);
        }
        System.out.println("-------------------");
        System.out.println("Wartości: ");
        for (int i = 0; i < excelFile.columns.size(); i++) {
            System.out.println(excelFile.columns.get(i).colName);
            for (int j = 0; j < excelFile.columns.get(i).objects.size(); j++) {
                //System.out.println("wartość dla wiersza: " + (i+1) + " i dla kolumny: " + j);
                System.out.println(excelFile.columns.get(i).objects.get(j));
            }
            System.out.println(excelFile.columns.get(i).smallOrBig);
        }
        System.out.println("-------------------");
        System.out.println("Wartości znormalizowane: ");
        for (int i = 0; i < excelFile.columns.size(); i++) {
            System.out.println(excelFile.columns.get(i).colName);
            for (int j = 0; j < excelFile.columns.get(i).objects.size(); j++) {
                System.out.println(excelFile.columns.get(i).normalized.get(j));
            }
        }
        System.out.println("-------------------");
        System.out.println("Najlepsze wartości: ");
        for(int i = 0; i < excelFile.columns.size(); i ++) {
            System.out.println(excelFile.columns.get(i).colName);
            System.out.println(excelFile.columns.get(i).best);
        }
        System.out.println("-------------------");
        System.out.println("Odległości: ");
        for(int i = 0; i < excelFile.choiceNames.size(); i++) {
            System.out.println(excelFile.choiceNames.get(i).choiceName);
            System.out.println(excelFile.choiceNames.get(i).distance);
        }

        excelFile.Sort();
        String results1 = "";
        int k = 1;
        if(excelFile.choiceNames.size() == 1) {
            for(int i = 0; i < 9; i++) {
                stars.get(i).setVisible(false);
            }
            results1 += System.lineSeparator() + excelFile.choiceNames.get(0).toString();
        }
        else if(excelFile.choiceNames.size() == 2) {
            for(int i = 6; i < 9; i++) {
                stars.get(i).setVisible(false);
            }
            if (excelFile.choiceNames.get(0).distance > 0.7) {
                stars.get(1).setVisible(false);
                stars.get(2).setVisible(false);
            } else if (excelFile.choiceNames.get(0).distance > 0.4) {
                stars.get(2).setVisible(false);
            }
            if (excelFile.choiceNames.get(1).distance > 0.7) {
                stars.get(4).setVisible(false);
                stars.get(5).setVisible(false);
            } else if (excelFile.choiceNames.get(1).distance > 0.4) {
                stars.get(5).setVisible(false);
            }
            results1 += System.lineSeparator() + excelFile.choiceNames.get(0).toString();
            results1 += System.lineSeparator() + excelFile.choiceNames.get(1).toString();
        }
        else {
            for (int i = 0; i < 3; i++) {
                results1 += System.lineSeparator() + excelFile.choiceNames.get(i).toString();
                if (excelFile.choiceNames.get(i).distance > 0.7) {
                    stars.get(k).setVisible(false);
                    stars.get(k + 1).setVisible(false);
                } else if (excelFile.choiceNames.get(i).distance > 0.4) {
                    stars.get(k + 1).setVisible(false);
                }
                k += 3;
            }
        }
        labelResults1.setText(results1);

        //TESTOWANIE cz.2 - choiceNames po posortowaniu
        System.out.println("-------------------");
        System.out.println("Wyniki: ");
        for(int i = 0; i < excelFile.choiceNames.size(); i++) {
            System.out.println(excelFile.choiceNames.get(i).choiceName);
        }
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
}
