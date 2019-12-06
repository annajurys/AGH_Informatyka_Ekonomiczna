package project.ie;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelFile {

    private File excelFile;
    private FileInputStream fis;
    private XSSFWorkbook workbook;

    public GetExcelFile(String path) {
        try {
            excelFile = new File(path);
            fis = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int howMuchColumns () {
        //System.out.println("ff");
        XSSFSheet sheet = workbook.getSheetAt(0);
        int howMuchColumns = 0;
        int i=1;
        //System.out.println(sheet.getRow(0).getCell(i).toString());
        while(i < sheet.getRow(0).getPhysicalNumberOfCells())
        {
            if(sheet.getRow(0).getCell(i).toString().isEmpty())
                break;

            howMuchColumns++;
            i++;
        }
        return howMuchColumns+1;
    }

    public int howMuchRows () {
        XSSFSheet sheet = workbook.getSheetAt(0);
        int howMuchRows = 0;
        int i=1;
        while(i < sheet.getPhysicalNumberOfRows())
        {
            if(sheet.getRow(i).getCell(0).toString().isEmpty())
                break;

            howMuchRows++;
            i++;
        }

        return howMuchRows+1;
    }


    public ExcelFile getExcelFileAndSaveInExcelFile(){
        ExcelFile excelFile = new ExcelFile();
        XSSFSheet sheet = workbook.getSheetAt(0);
        int colNumber = howMuchColumns();
        int rowNumber = howMuchRows();
        for (int j = 0 ; j < colNumber ; j++) {
            for (int i = 0 ; i < rowNumber ; i++) {
                if(j==0 && i!=0) {
                    ChoiceName choice = new ChoiceName(j,i,sheet.getRow(i).getCell(j).toString());
                    excelFile.addChoices(choice);
                    System.out.println(" choiceName: " + choice.choiceName + " row: " + i + " col:" + j);
                }
            }
            if(j!=0) {
                LinkedList<Double> objectList = new LinkedList<>();
                for(int row=1;row<rowNumber;row++) {
                    if(sheet.getRow(row).getCell(j).toString().isEmpty() || sheet.getRow(row).getCell(j).getCellType()!= CellType.NUMERIC) {
                        objectList.add(null);
                    }
                    else {
                        objectList.add((Double.valueOf(sheet.getRow(row).getCell(j).toString())));
                    }
                }
                Column column = new Column(j,0,sheet.getRow(0).getCell(j).toString(),objectList);
                excelFile.addColumns(column);
                System.out.println(" row:" + 0 + " col: " + j + " colName: " + column.getColName());
                for(int i = 0; i< column.objects.size(); i++) {
                    System.out.println(column.objects.get(i));
                }
            }
        }
        try {
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return excelFile;
    }
}
