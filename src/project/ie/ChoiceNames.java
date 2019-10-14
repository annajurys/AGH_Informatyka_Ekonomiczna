package project.ie;

import java.util.LinkedList;

public class ChoiceNames {

    public int column;
    public int row;
    public String choiceName;

    public ChoiceNames(int column, int row, String colName) {
        this.column = column;
        this.row = row;
        this.choiceName = colName;
    }


    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public String getChoiceName() {
        return choiceName;
    }
}
