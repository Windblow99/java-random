package aplc.assignment;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jpl7.Query;
import org.jpl7.Term;

public class task2 {
    static final String prologFile = "taskRule.pl";
    static String excelFile = "coursework-marks.xlsx";
    
    public static void main(String[] args) {
        prologTest();
        ExcelReader excelReader = new ExcelReader(excelFile);
        List<List<String>> excelData = excelReader.retrieveData();
        String finalData = readMarks.apply(excelData);

        String stringQuery = finalData.replace(" ", "");
        String query = "bubble_sort(" + stringQuery + ", Y)";
        Query queryLine = new Query(query);

        Map<String, Term> sol = new HashMap<>();
        while (queryLine.hasMoreSolutions()) {
            sol = queryLine.nextSolution();
            Term print = sol.get("Y");
            String printString = print.toString();
            String printClean = printString.replaceAll("[^0-9]+","\n");
            System.out.println(printClean);
        }
    }

    static void prologTest() {
        String stringStatement = "consult('" + prologFile + "')";
        Query queryStatement = new Query(stringStatement);
        System.out.println(queryStatement.hasSolution() ? "success" : "fail");
        queryStatement.close();
    }

    static Function<List<List<String>>, String> readMarks = a -> {
        return a.stream()
                .map(e -> Collections.singleton(e.get(2)))
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                .toString();
    };
}
