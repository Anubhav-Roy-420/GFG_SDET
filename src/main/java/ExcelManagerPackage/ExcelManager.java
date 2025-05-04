package ExcelManagerPackage;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelManager {


    private static String file_location = "src/main/resources/DataDriven.xlsx";

    public static Object[][] getData() throws IOException {

        String[][] data;
        File f1 = new File(file_location);
        FileInputStream fis = new FileInputStream(f1);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        data = new String[rowCount][colCount];

        for (int i = 1; i <=rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }

        wb.close();
        fis.close();
        return data;
    }



}