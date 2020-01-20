package project.ie;

import java.util.Collections;
import java.util.LinkedList;

import static java.lang.Math.*;

public class ExcelFile {

    public LinkedList<ChoiceName> choiceNames = new LinkedList<>();
    public LinkedList<Column> columns = new LinkedList<>();

    public ExcelFile() {
    }

    public LinkedList<Column> getColumns() {
        return columns;
    }

    public LinkedList<ChoiceName> getChoiceNames() {
        return choiceNames;
    }

    public ExcelFile(LinkedList<Column> columns, LinkedList<ChoiceName> choiceNames) {
        this.columns = columns;
        this.choiceNames = choiceNames;
    }

    public void addColumns(Column column) {
        columns.add(column);
    }
    public void addChoices(ChoiceName choices) {
        choiceNames.add(choices);
    }

    public boolean findOutliers() {
        boolean outliers = false;
        for(int i = 0; i < columns.size(); i++) {
            Column column = columns.get(i);
            Double min = column.Min();
            Double max = column.Max();
            for(int j = 0; j < column.objects.size(); j++) {
                if(column.objects.get(j) < min || column.objects.get(j) > max) {
                    column.objects.set(j, null);
                    outliers = true;
                }
            }
        }
        return outliers;
    }

    public void Distances() {
        Double dis, sum, distance;
        for(int i = 0; i < columns.size(); i++) {
            columns.get(i).Normalization();
            columns.get(i).BestChoice();
        }
        for(int i = 0; i < choiceNames.size(); i++) {
            ChoiceName choice = choiceNames.get(i);
            sum = 0.00;
            for(int j = 0; j < columns.size(); j++) {
                Column column = columns.get(j);
                dis = abs(column.normalized.get(i) - column.best);
                sum += dis;
            }
            distance = sqrt(sum);
            choice.distance = distance;
        }
    }

    public void Sort() {
        Collections.sort(choiceNames);
    }
}
