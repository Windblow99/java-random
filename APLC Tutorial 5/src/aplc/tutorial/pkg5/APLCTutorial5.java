package aplc.tutorial.pkg5;

import java.util.List;
import java.util.function.Function;

public class APLCTutorial5 {

    //function consists of a block of statements that performs a specific task
    //Input: double, double; Output: double
    double power (double d1, double d2) {
        return Math.pow(d1, d2);
    }
    //Input: Collection; Output: Nothing --> Consumer
    void disp (List<Object>lst) {
        lst.forEach(System.out::println);
    }
    //Input: Nothing; Output: double --> Supplier
    double getRand() {
        return Math.random();
    }
    
    //higher order function is a function that takes a function as argument or return a function
    //hof covers broad area of functional programming
    //subset programming concepts like currying & partial application to realise the hof's definition
    void f1(Function<Integer, Integer> func, int value) {
        System.out.println(func.apply(value));
    }
    
    static Function<Integer, Integer> addOne = elem -> elem+1; //Function as value
    public static void main(String[] args) {
        APLCTutorial5 demo = new APLCTutorial5();
//        demo.f1(addOne, 100); //101
        demo.f1(elem->elem+1, 100); //101
        
        //Hof---> filter(f), map(f), reduce(f)
        //f can be function or lambda expr
    }
}
