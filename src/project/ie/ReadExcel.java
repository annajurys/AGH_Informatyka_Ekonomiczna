package project.ie;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    private File excelFile;
    private FileInputStream fis;
    private XSSFWorkbook workbook;

    public ReadExcel(String path) {
        try {
            excelFile = new File(path);
            fis = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readExcelFile(){

        ExcelFile f = new ExcelFile();

        XSSFSheet sheet = workbook.getSheetAt(0);

        //int row_1 = 0;

        for (int j = 0 ; j < sheet.getRow(0).getLastCellNum() ; j++) {

            //String colName = sheet.getRow(row_1).getCell(j).toString();
            //LinkedList<Object> objects = new LinkedList<>();

            for (int i = 0 ; i < sheet.getLastRowNum() ; i++) {
                //row_1++;
                //objects.add(sheet.getRow(i).getCell(j).toString());
                if(j==0 && i!=0) {
                    ChoiceNames choices = new ChoiceNames(j,i,sheet.getRow(i).getCell(j).toString());
                    f.addChoices(choices);
                    //System.out.println("choiceName: " + choices.choiceName + i + j);
                }
                //System.out.print(sheet.getRow(i).getCell(j) + " ");
            }
            //System.out.println("");
            if(j!=0) {
                LinkedList<Object> objectList = new LinkedList<>();
                for(int row=0;row<=sheet.getLastRowNum();row++) {
                    if(row!=0) {
                        objectList.add(sheet.getRow(row).getCell(j).toString());
                    }
                }
                Columns columns = new Columns(j,0,sheet.getRow(0).getCell(j).toString(),objectList);
                f.addColumns(columns);
                //System.out.println(j + "......" + row_1/sheet.getLastRowNum() + "......" + columns.getColName());
                for(int i=0;i<=10;i++) {

                    //System.out.println(columns.objects.get(i));
                }
            }
            //Columns columns = new Columns(j, row_1, colName, objects);


        }
        try {
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
