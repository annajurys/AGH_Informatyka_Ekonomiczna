package project.ie;

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

    public void Distances() {
        Double dis, sum, distance;
        for(int i = 0; i < choiceNames.size(); i++) {
            ChoiceName choice = choiceNames.get(i);
            dis = 0.00;
            sum = 0.00;
            distance = 0.00;
            for(int j = 0; j < columns.size(); j++) {
                Column column = columns.get(j);
                dis = abs(column.normalized.get(choice.row) - column.BestChoice());
                sum += dis;
            }
            distance = sqrt(sum);
            choice.distance = distance;
        }
    }

    /*public void Sort() {

    }*/
}
