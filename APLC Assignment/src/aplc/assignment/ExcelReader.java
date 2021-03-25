package aplc.assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private FileInputStream fileInputStream;
    private XSSFWorkbook workBook;
    
    public ExcelReader(String target) {
        try {
            fileInputStream = new FileInputStream(target);
            workBook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {}
    }
    
    public List<List<String>> retrieveData() {
        List<List<String>>excelList = new ArrayList<>();
        try {
            XSSFSheet sheet = workBook.getSheetAt(0);
            for (Row row:sheet) {
                int rowNum = row.getRowNum();
                if (rowNum >= 1 && rowNum <= 51) {
                    List<String> excelEntry = new ArrayList<>();
                    excelEntry.add(row.getCell(1).getStringCellValue());
                    excelEntry.add(row.getCell(2).getStringCellValue());
                    excelEntry.add(Integer.toString((int) row.getCell(3).getNumericCellValue()));
                    excelList.add(excelEntry);
                }
            }
        } catch (Exception e) {}
        return excelList;
    }
}
