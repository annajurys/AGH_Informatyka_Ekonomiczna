package project.ie;

import java.util.ArrayList;
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
    public Double best;

    public Column(int column, int row, String colName, LinkedList<Double> objects) {
        this.column = column;
        this.row = row;
        this.colName = colName;
        this.objects = objects;
        best = 0.00;
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

    public Double Average() {
        Double sum = 0.00;
        int n = 0;
        for (Double object : objects) {
            if(object != null) {
                sum += object;
                n += 1;
            }
        }
        if( n!= 0) {
            return sum / n;
        }
        else {
            throw new ArithmeticException();
        }
    }

    public Double StandardDeviation () {
        Double sum = 0.00;
        int n = 0;
        for (Double object : objects) {
            if(object != null) {
                sum += pow(object - Average(), 2);
                n += 1;
            }
        }
        if(n != 0) {
            return sqrt(sum / n);
        }
        else {
            throw new ArithmeticException();
        }
    }

    public Double Min() {
        return Average() - 3*StandardDeviation();
    }

    public Double Max() {
        return Average() + 3*StandardDeviation();
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

    public void BestChoice() {
        best = normalized.get(0);
        if(smallOrBig == SmallOrBig.SMALL) {
            for(int i = 1; i < normalized.size(); i++) {
                if(normalized.get(i) < best) {
                    best = normalized.get(i);
                }
            }
        }
        else {
            for(int i = 1; i < normalized.size(); i++) {
                if(normalized.get(i) > best) {
                    best = normalized.get(i);
                }
            }
        }
    }
}
