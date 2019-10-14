package project.ie;

import java.util.LinkedList;

public class ExcelFile {

    public LinkedList<ChoiceNames> choiceNames = new LinkedList<>();
    public LinkedList<Columns> columns = new LinkedList<>();

    public ExcelFile() {
    }

    public LinkedList<Columns> getColumns() {
        return columns;
    }

    public LinkedList<ChoiceNames> getChoiceNames() {
        return choiceNames;
    }

    public ExcelFile(LinkedList<Columns> columns, LinkedList<ChoiceNames> choiceNames) {
        this.columns = columns;
        this.choiceNames = choiceNames;
    }

    public void addColumns(Columns column) {
        columns.add(column);

    }
    public void addChoices(ChoiceNames choices) {
        choiceNames.add(choices);
    }

}
