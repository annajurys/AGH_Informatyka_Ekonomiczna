package project.ie;

import java.util.ArrayList;
import java.util.List;

public class AverageOfColumn {

    private ExcelFile excelFile;

    public void setExcelFile(ExcelFile excelFile) {
        this.excelFile = excelFile;

    }


    public void setAverageOfColumn() {
        double sumOfColumn = 0;
        double averageOfColumn = 0;
        int i=0, j=0;
        int howMuchNulls=0;
        List<Integer> whereToPutAverage = new ArrayList<>();

        while (i < excelFile.columns.size()) {
            whereToPutAverage.clear();
            while (j < excelFile.columns.get(i).objects.size()) {
                if (excelFile.columns.get(i).objects.get(j) == null) {
                    for(int k=0; k<excelFile.columns.get(i).objects.size(); k++) {
                        if((excelFile.columns.get(i).objects.get(k)) != null)
                            sumOfColumn+=Double.valueOf(String.valueOf(excelFile.columns.get(i).objects.get(k)));
                        else {
                            howMuchNulls++;
                            System.out.println("nasze j: " + j);
                            whereToPutAverage.add(j);
                        }
                    }
                    averageOfColumn = sumOfColumn/(excelFile.columns.get(i).objects.size()-howMuchNulls);
                }

                for(Integer elem : whereToPutAverage) {
                    System.out.println(elem + "      hejki  col: " + i + " row: " + j);
                }
                for(int l=0;l<=howMuchNulls;l++) {
                    //System.out.println(l + " licznik:");
                    System.out.println("i: " + i + " j: " + whereToPutAverage.get(l) + " average: " + averageOfColumn);
                    //excelFile.columns.get(i).objects.set(whereToPutAverage.get(l), averageOfColumn);//outofbounds
                }

                j++;
            }
            i++;
        }
    }
}
