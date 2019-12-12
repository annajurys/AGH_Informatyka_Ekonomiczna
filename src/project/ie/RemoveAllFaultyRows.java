package project.ie;

import java.util.ArrayList;
import java.util.List;

public class RemoveAllFaultyRows {

        private ExcelFile excelFile;

        public void setExcelFile(ExcelFile excelFile) {
            this.excelFile = excelFile;

        }

        public void removeAllFaultyRows() {
            int howMuchNulls=0;

            //System.out.println("size columns: " + excelFile.columns.size());
            //System.out.println("size objects: " + excelFile.columns.get(0).objects.size());

            int i=0;
            while (i < excelFile.columns.size()) {
                int j=0;
                while (j < excelFile.columns.get(i).objects.size()) {
                    if (excelFile.columns.get(i).objects.get(j) == null) {
                        for(int k=0; k<excelFile.columns.size(); k++) {
                            excelFile.columns.get(k).objects.remove(j);
                        }
                        excelFile.choiceNames.remove(j);
                        j--;
                    }
                    //System.out.println(i + " i< j> " + j);
                    j++;
                }
                i++;
            }
        }
}
