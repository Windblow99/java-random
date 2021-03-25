package aplc.assignment;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class task1 {
    static String excelFile = "coursework-marks.xlsx";
    
    public static void main(String[]args){
        ExcelReader excelReader = new ExcelReader(excelFile);
        List<List<String>>excelData = excelReader.retrieveData();
        
        System.out.println("Showing all student records:");
        printRecord(excelData,1);
        
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.println("\nShowing students average arks: " + df.format(averageMarks(excelData))); //Println for q2
        
        System.out.println("\nShowing students minimum Marks: " + minimumMaximum(excelData).getMin()); //Println for q3
        System.out.println("\nShowing students maximum Marks: " + minimumMaximum(excelData).getMax()); //Println for q4
        
        System.out.println("\nShowing records of failed students: ");
        failedStudents(excelData,50).forEach(System.out::println);//Q4
        
        System.out.println("\nShowing records of distinction students: ");
        distinctionStudents(excelData,85);//Q5
    }
    
    static UnaryOperator<List<List<String>>>print = e -> e; //lambda
    static void printRecord(List<List<String>> excelData, int n){ //recursion
        if (n > 0){
            printRecord(excelData, n-1);
            System.out.println(print.apply(excelData)); //partial application
        }
    }

    //without accessing external variables, prevent side-effects
    //2) compute the average marks;   
    public static double averageMarks(List<List<String>> excelData){
        return excelData.stream()
                .mapToDouble(e -> Integer.parseInt(e.get(2)))
                .summaryStatistics()
                .getAverage();
    }
    
    //3) find the minimum and maximum marks; (purity, doesn not change the original list)
    public static DoubleSummaryStatistics minimumMaximum(List<List<String>> excelData){   
        return excelData.stream()
                .map(e -> Double.parseDouble(e.get(2))) //higher order function
                .mapToDouble((Object e) -> (double) e)
                .summaryStatistics();
    }

    //4) populate those students who fail the coursework
    public static List<String>failedStudents (List<List<String>> excelData, int failCriteria){
        return excelData.stream()
                .filter(e -> Integer.parseInt(e.get(2))<(failCriteria)) //higher order function
                .map(e -> Collections.singleton(e.get(0) + e.get(1) + e.get(2)))
                .flatMap(Collection::stream) 
                .collect(Collectors.toList());
    } 
        
    // 5) populate those students who obtain higher distinction
    static void distinctionStudents (List<List<String>> excelData, int distinctionCriteria){
        excelData.stream()
                .filter(e -> Integer.parseInt(e.get(2))>=(distinctionCriteria))
                .forEach(System.out::println);
    }
}
