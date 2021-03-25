package aplc.tutorial.pkg7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DaExcel {
    //helper class
    private FileInputStream fis;
    private XSSFWorkbook wb;
    
    public DaExcel(String target) {
        try {
            fis = new FileInputStream(target);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<List<String>> getData() {
        List<List<String>>list = new ArrayList<>();
        try {
            XSSFSheet sheet = wb.getSheetAt(0);
            for (Row row:sheet) {
                int rowNum = row.getRowNum();
                if (rowNum > 3 && rowNum < 42) {
                    List<String> record = new ArrayList<>();
                    record.add(row.getCell(1).getStringCellValue());
                    record.add(row.getCell(2).getStringCellValue());
                    record.add(row.getCell(3).getStringCellValue());
                    record.add(row.getCell(4).getStringCellValue());
                    record.add(Double.toString(row.getCell(5).getNumericCellValue()));
                    record.add(row.getCell(6).getStringCellValue());
                    record.add(row.getCell(7).getStringCellValue());
                    record.add(row.getCell(8).getStringCellValue());
                    list.add(record);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
