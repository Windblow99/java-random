package aplc.tutorial.pkg3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class APLCTutorial3 {
    static List<Integer> num = 
            Arrays.asList(12,34,21,4,56,77,88,44,885,2,5,7,98,54);
    
    //Iterate and display through all elements of array list
    static void q1(List<Integer> num){
        //lambda expression
//        num.forEach((elem) -> {
//            System.out.println(elem);
//        });

        //Method references
        num.forEach(System.out::println);
    }
    
    //Search and display an element, ie., 885
    static Integer q2( int target ){
        return num.stream()
                .filter(iNum->iNum == target)
                .findAny().orElse(null);
        //if display just use system.out.println
    }
    
    //Double up each array element by 2 
    //and store them in another array list
    static List<Integer> q3(){
//        ArrayList<Integer>arrList = new ArrayList();
//        num.stream().forEach(v -> {
//            arrList.add(v*2);
//        });
//        return arrList;

        //can use map or collect method
        //return num.stream().map(elem->elem*2).collect(Collectors.toList());
        //the above code can be explained in this way.
        Stream<Integer> newElementStream = num.stream().map(elem->elem*2);
        List<Integer> newColl = newElementStream.collect(Collectors.toList());
        return newColl;
    }
    
    //Sort all elements in ascending order
    static List<Integer> q4(){
        return num.stream().sorted().collect(Collectors.toList());
    }
    
    //Sort all elements in descending order
    static List<Integer> q5(){
        return num.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
    
    //Generate numbers from 2 to 20 with a gap of 2. 
    //Join this generated numbers with the array list above. 
    //Display all elements of the newly created array list.
    static void q6(){
        List<Integer> numbers = Stream.iterate(2, n->n+2)
                .limit(10)
                .collect(Collectors.toList());
        
//        List<Integer> newList = Stream.of(num, numbers)
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());
//        
//        newList.stream()
//                .forEach(System.out::println);

        //can be shortened to
        Stream.of(num, numbers)
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }
    
    //Find and display all the elements that is greater than 10
    static void q7( List<Integer> num, Integer greaterNum ){
        num.stream()
                .filter(elem->elem>greaterNum)
                .forEach(System.out::println);
    }
    
    //Find the minimum value
    static int q8i(List<Integer> num){
//        Integer min = num.stream()
//                .min(Comparator.comparing(Integer::valueOf))
//                .get();
//        return min;
        return num.stream()
                .mapToInt(Integer::intValue) //convert element to primitive int
                .min().getAsInt();
    }
    
    //Find the maximum value
    static int q8ii(List<Integer> num){
        return num.stream().max(Integer::compare).get();
    }
    
    //Find the sum value of the list.
    static int q9i(List<Integer> num){ 
        //0+1=1
        //1+2=3
        //3+3=6
        //6+4=10
        //10+5=15
        
        //list: 1,2,3,4,5
        
        //reduce() is to reduce elements into 1 value.
        return num.stream().reduce(0, (a,b)->(a+b));
    }
    
    //Find the average value of the list.
    static double q9ii(List<Integer> num){
        return num.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage();
    }

    //Find any even number on the list. Display the result either true or false.
    static boolean q10( List<Integer> num ){
        return num.stream().anyMatch(n->n%2 == 0);
    }   
}
