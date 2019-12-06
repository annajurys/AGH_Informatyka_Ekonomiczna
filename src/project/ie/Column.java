package project.ie;

import java.util.LinkedList;

import static java.lang.Math.*;

public class Column {
    enum SmallOrBig {
        SMALL,
        BIG
    }

    public int column;
    public int row;
    public String colName;
    public LinkedList<Double> objects;
    public SmallOrBig smallOrBig;
    public LinkedList<Double> normalized;

    public Column(int column, int row, String colName, LinkedList<Double> objects) {
        this.column = column;
        this.row = row;
        this.colName = colName;
        this.objects = objects;
    }

    public void setSmallOrBig(SmallOrBig smallOrBig) {
        this.smallOrBig = smallOrBig;
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

    public LinkedList<Double> getObjects() {
        return objects;
    }

    public void Normalization() {
        normalized = new LinkedList<Double>();
        Double square, value;
        Double sum = 0.00;
        for (int i = 0; i < objects.size(); i++) {
            square = pow((Double) objects.get(i), 2);
            sum += square;
        }
        for (int i = 0; i < objects.size(); i++) {
            value = (Double) objects.get(i) / sqrt(sum);
            normalized.add(value);
        }
    }

    public double BestChoice() {
        double Best = normalized.get(0);
        if(smallOrBig == SmallOrBig.SMALL) {
            for(int i = 1; i < normalized.size(); i++) {
                if(normalized.get(i) < Best) {
                    Best = normalized.get(i);
                }
            }
        }
        else {
            for(int i = 1; i < normalized.size(); i++) {
                if(normalized.get(i) > Best) {
                    Best = normalized.get(i);
                }
            }
        }
        return Best;
    }
}
