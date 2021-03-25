package aplc.tutorial.pkg10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class APLCTutorial10 {
    static List<Student> markList;
    
    static {
        markList = getStudents();
    }
    
    static List<Student> getStudents() {
        List<Student> lst = new ArrayList();
        lst.add(new Student(new Integer[]{23,56,76,76}));
        lst.add(new Student(new Integer[]{43,61,66,78}));
        lst.add(new Student(new Integer[]{12,56,87,78}));
        lst.add(new Student(new Integer[]{67,23,86,76}));
        return lst;
    }
    
    public static void main(String[] args) {
        compute();
    }
    
    private static void compute() {
        markList.stream()
                .map(elem -> {
                    return Stream.of(elem.getMarks())
                            .map( marks -> f.apply(marks)) //multiply 25%
                            .mapToDouble(Number::doubleValue)
                            .sum();
                }).forEach(result -> System.out.println(Math.round(result) + "%"));
    }
    
    //Function object
    static Function<Integer, Double> f = e -> e * 0.25;
}

class Student{
    Integer marks[] = new Integer[4];
    public Student(Integer[] marks) {
	super();
	this.marks = marks;
    }
    
    public Integer[] getMarks() {
	return marks;
    }
}

