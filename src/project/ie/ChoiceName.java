package project.ie;

import java.util.LinkedList;

public class ChoiceName implements Comparable<ChoiceName>{

    public int column;
    public int row;
    public String choiceName;
    public Double distance;

    public ChoiceName(int column, int row, String colName) {
        this.column = column;
        this.row = row;
        this.choiceName = colName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
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

    @Override
    public String toString() { return choiceName; }

    @Override
    public int compareTo(ChoiceName choiceName) {
        return Double.compare(this.getDistance(), choiceName.getDistance());
    }
}
