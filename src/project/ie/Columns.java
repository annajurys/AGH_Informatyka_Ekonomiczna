package project.ie;

import java.util.LinkedList;

public class Columns {

    public int column;
    public int row;
    public String colName;
    public LinkedList<Object> objects = new LinkedList<>();

    public Columns(int column, int row, String colName, LinkedList<Object> objects) {
        this.column = column;
        this.row = row;
        this.colName = colName;
        this.objects = objects;
    }


    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public String getColName() {
        return colName;
    }

    public LinkedList<Object> getObjects() {
        return objects;
    }
}
