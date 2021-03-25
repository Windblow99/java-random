package aplc.tutorial.pkg6;

import java.util.function.Function;

public class CurriedDemo {

    //without currying technique
    double add (double a, double b, double c) {
        return a + b + c;
    }
    
    //with currying technique
    //function applications accept an input value at a time
    //with lambda expression
    Function<Double, Function<Double, Function<Double, Double>>> addv2 = 
            a -> b -> c -> a + b + c;
    
    public static void main(String[] args) {
        CurriedDemo demo = new CurriedDemo();
        
        double result = demo.add(10, 20, 30);
        
        double result2 = demo.addv2.apply(10.0).apply(20.0).apply(30.0);
        //partial application
        //1st application
        Function<Double, Function<Double, Double>> f = demo.addv2.apply(10.0);
        //2nd application
        Function<Double, Double> f2 = f.apply(20.0);
        //3rd application
        double result3 = demo.doFinal(f2, 30.0);
    }
    
    double doFinal(Function<Double, Double> f, double value) {
        return f.apply(value);
    }
}
