package aplc.tutorial.pkg8;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class tutorialQuestion {
    public static void main(String[] args) {
        tutorialQuestion demo = new tutorialQuestion();
//        tutorialQuestion.countdown(5);
        
//        System.out.println(tutorialQuestion.rev.apply("hello"));
        System.out.println(tutorialQuestion.maximum(new int[]{2,3,8,5,6}, 5));
    }
    
    //2a-fibonacci number
    public static int n1 = 0, n2 = 1, n3;
    public static void fibonacciRecursion(int count) {
        if (count>0) { //base case
            n3 = n1 + n2;
            System.out.println(n3 + " ");
            n1 = n2;
            n2 = n3;
            fibonacciRecursion(count - 1); //recursive call
        }
    }
    public static int fib(int n) { //recommended answer
        if (n==0) return 0;
        if (n==1) return 1;
        return fib(n-1) + fib(n-2);
    }
    
    //2b=factrial number
    private static int factRecursive(int number) {
        //base condition
        if (number == 1) {
            return 1;
        }
        return number + factRecursive(number - 1); //recursive call
    }
    
    //3-countdown
    public static void countdown(int number) {
        try {
            Thread.sleep(100);
            if (number == 0) {
                System.out.println("Kaboom!");
            } else {
                System.out.println(number);
                countdown(number - 1);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    //4a-factorial lambda
    UnaryOperator<Long> fact = x -> x == 0 ? 1 : x * this.fact.apply(x-1);
    
    //4b-sum of numbers lambda
    static Function<Integer, Integer> addTotal =
            (n) -> (n>0) ? tutorialQuestion.addTotal.apply(n-1) + n : n;
    
    //4c=reversed string lambda
    static UnaryOperator<String> rev = str -> str.length() < 2
            ? str
            : tutorialQuestion.rev.apply(str.substring(1)) + str.charAt(0)
            ;
    
    //5-max
    static int findMax(int temp, int count, int[] array) {
        if (count < array.length - 1) {
            temp = findMax(array[count], count + 1, array);
        } else {
            temp = findMax(temp, count + 1, array);
        }
        return temp;
    }
    
    //improved version
    static BinaryOperator<Integer> max = (e1, e2) -> (e1 > e2) ? e1 : e2 ;
    //maximum
    static int maximum(int[] arr, int length) {
        if (length == 1) return arr[0]; //base case
        return max.apply(maximum(arr, length-1), arr[length-1]); //recursive call
    }
}
