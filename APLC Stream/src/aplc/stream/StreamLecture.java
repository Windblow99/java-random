package aplc.stream;

import java.util.*;

public class StreamLecture {
//Stream class - from Java 8 as functional programming
    //collection container that provides a series of operations
   
    //how do you collect data objects from any source (input console, file or DB)?
        //variable - single value storage
        //array - multi-value storage on a specific
        //HashMap, HashSet, LinkedList, ArrayList and etc - Collection APIs
   
    //Array
    int[] nums = {10, 20, 30, 40, 50};
   
    //Collection Api: List
    List<Integer> numList = Arrays.asList(10, 20, 30, 40, 50);
   
    //transform all elements from the collection to new elements
        //e.g. multiply each element by 2
        //Output: 20, 40, 60, 80, 100
   
    void streamwithArray(){
        //populate all elements into Stream. Stream.of; Array.stream; coll.stream()
        //Stream.of()
        //map() - transform to a new element
       
        //Arrow function - elem -> elem*2
            //lambda expression
        Arrays.stream(nums).map(elem -> elem * 2).forEach(System.out::println);
        System.out.println("");
    }
   
    //method - can be transformed into lambda expression
    int multiply(int elem){
        return elem * 2;
    }
   
    void streamwithCollection(){
        numList.stream()
                .map(elem -> elem * 2)
                .forEach(System.out::println);
    }
   
    public static void main(String[] args) {
        StreamLecture demo = new StreamLecture();
        demo.streamwithArray();
        demo.streamwithCollection();
    }
}


//package streamdemo;
//
//import java.util.Arrays;
//import java.util.stream.DoubleStream;
//
//public class StreamExercise {
//    public static void main(String[] args) {
//        double[] prices = {29.90, 59.00, 12.50, 75.80, 55.60};
//        
//        DoubleStream streamPrices = Arrays.stream(prices);
//        streamPrices.map(p -> p * 1.06).forEach(System.out::println);
//    }
//}
