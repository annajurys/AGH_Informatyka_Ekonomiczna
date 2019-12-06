package project.ie;

import java.util.ArrayList;
import java.util.List;

public class AverageOfColumn {

    private ExcelFile excelFile;
    public List<Double> listOfAverageOfColumn;

    public void setExcelFile(ExcelFile excelFile) {
        this.excelFile = excelFile;

    }
    /*
    public List<Double> getAverageOfColumn() {
        //
        //System.out.println("fffffffffffffffffffffffffffffffffeweeeeeeeeeeeeee");
        double sumOfColumn = 0;
        double averageOfColumn = 0;
        listOfAverageOfColumn = new ArrayList<>();
        boolean foundNullValue = false;
        int i=0, j=0;
        int howMuchNulls=0;

        while (i < excelFile.columns.size()) {
            while (j < excelFile.columns.get(i).objects.size() && !foundNullValue) {
                if (excelFile.columns.get(i).objects.get(j).equals("null")) {
                    foundNullValue = true;
                    for(int k=0; k<excelFile.columns.get(i).objects.size(); k++) {
                        if(!Double.valueOf(String.valueOf(excelFile.columns.get(i).objects.get(k))).equals(null))
                            sumOfColumn+=Double.valueOf(String.valueOf(excelFile.columns.get(i).objects.get(k)));
                        else
                            howMuchNulls++;
                    }
                    averageOfColumn = sumOfColumn/(excelFile.columns.get(i).objects.size()-howMuchNulls);
                    listOfAverageOfColumn.add(averageOfColumn);
                }

                j++;
            }
            i++;
        }
        //System.out.println("ffffffffffffffff");
        return listOfAverageOfColumn;
    }*/

    public void setAverageForNulls() {
        double sumOfColumn = 0;
        double averageOfColumn = 0;
        listOfAverageOfColumn = new ArrayList<>();
        boolean foundNullValue = false;
        int i=0, j=0;
        int howMuchNulls=0;

        while (i < excelFile.columns.size()) {
            while (j < excelFile.columns.get(i).objects.size() && !foundNullValue) {
                if (excelFile.columns.get(i).objects.get(j) == null) {
                    foundNullValue = true;
                    for(int k=0; k<excelFile.columns.get(i).objects.size(); k++) {
                        if((excelFile.columns.get(i).objects.get(k)) != null)
                            sumOfColumn+=Double.valueOf(String.valueOf(excelFile.columns.get(i).objects.get(k)));
                        else
                            howMuchNulls++;
                    }
                    averageOfColumn = sumOfColumn/(excelFile.columns.get(i).objects.size()-howMuchNulls);
                    excelFile.columns.get(i).objects.set(j, averageOfColumn);
                    //listOfAverageOfColumn.add(averageOfColumn);
                }

                j++;
            }
            i++;
        }
    }
}
