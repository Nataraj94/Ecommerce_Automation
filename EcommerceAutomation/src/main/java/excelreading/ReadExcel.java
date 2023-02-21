package excelreading;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import reuseable.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel extends BaseClass {

    public static String readExcel(String sheetName,int row, int column)  {

        String value = null;
        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "/src/main/resources/datasheet/TestData.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet =workbook.getSheet(sheetName);
            value=  sheet.getRow(row).getCell(column).getStringCellValue();

        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return value;
    }
}
