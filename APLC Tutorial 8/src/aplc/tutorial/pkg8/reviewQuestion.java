package aplc.tutorial.pkg8;

import java.util.function.BiFunction;

public class reviewQuestion {
    //review question - recursion technique
    //nLines(int)
    static void nLinesRes(int n){
        if (n > 0){
            nLinesRes(n-1); //recursive call
            System.out.println(n);
        }
    }
    
    public static void main(String[] args) {
//        nLinesRes(3);

        long result = power.apply(2, 3);
        System.out.println(result);
    }
    
    static BiFunction<Integer, Integer, Long> power = 
            (base, expo) -> (expo != 0) //base case
                    ? reviewQuestion.power.apply(base, expo-1) * base //recursive call
                    : 1
                    ;
}
