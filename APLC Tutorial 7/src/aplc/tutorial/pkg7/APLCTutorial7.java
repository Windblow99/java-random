package aplc.tutorial.pkg7;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Cell;

public class APLCTutorial7 {

    private static final String TARGET_FILE =
            "senarai-tenaga-pengajar-latihan-pengendali-makanan-yang-diiktiraf.xlsx";
    public static void main(String[] args) {
        //read the excel file and collect all related data
        DaExcel da = new DaExcel( TARGET_FILE );
        List<List<String>> data = da.getData();
        System.out.println("Total: " + data.size());
        
        data.stream().filter(dat -> dat.get(5).equalsIgnoreCase("Selangor")).forEach(System.out::println);
        
        //homework
        //filter out the teacher email that locate on KL and Selangor
    }
    
}
