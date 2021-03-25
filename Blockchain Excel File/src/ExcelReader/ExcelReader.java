package ExcelReader;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.javatuples.Quintet;

public class ExcelReader {
    //data file
    private static final String DATAFILE = "senarai-keperluan-peralatan-dan-kenderaan-kkm-rmk11.xlsx";
    
    //helper classes
    private static FileInputStream fis;
    private static XSSFWorkbook wb;
    public List<Quintet<String, String, String, String, String>> data;
    
    //constructor
    public ExcelReader() {
        data = new ArrayList<>();
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws Exception {
        fis = new FileInputStream(new File(DATAFILE));
        wb = new XSSFWorkbook(fis);
    }
    
    //access excel data
    public ExcelReader getAll() {
        try {
            XSSFSheet sheet = wb.getSheetAt(0);
            for(Row row:sheet) {
                int rowNum = row.getRowNum();
                if(rowNum > 2) {
                    Quintet q = new Quintet(row.getCell(1),
                            row.getCell(2),
                            row.getCell(3),
                            row.getCell(4),
                            row.getCell(5)
                    );
                    data.add(q);
                    //hash each data item and store it in the block
                    //set the number of transaction for the block
                    //e.g. block size: 3 transactions
                    //finally, chain the blocks
                }                
            }
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            return this;
        }
    }
    
    public void show() {
        System.out.println(data);
    }
    
    public static void main(String[] args) {
        ExcelReader er = new ExcelReader();
        er.getAll().show();
    }
}
