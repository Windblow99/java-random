package aplc.tutorial.pkg4;

// Purity concept introduces a function without side effects (pure functions)

public class APLCTutorial4 {
//    //In the past, a function/method or static method is created
//    static double getRate() {
//        return 3.0;
//    }
//    
//    //instance method in OOP approach
//    //Accoutn class has a balance attribute
//    double balance;
//    void deposit (double amount) { //impure function
//        balance += amount;
//    }
//    
//    //introduce side-effect (accessing external variable)
//    //local side-effect may cause impure function
//    double increment (double a, double b) {
//        double result; //local variable introduces local side effect
//        result = a +b;
//        return result;
//        //return a + b;
//    }
//    
//    //Another example, throwing an exception (considered side effect)
//    void withdraw (double amount) throws Exception {
//        //check for negative amount
//        if (amount < 0) {
//            throw new Exception();
//            //System.out.println("Invalid input");
//        }
//    }
    
//    //Why can't we have side-effect in method/function?
//    //In maths, F(x) + F(y) = inconsistent result
//    static int x;
//    
//    int calc (int i) { //access external variable
//        x += i;
//        return x;
//    }
//    
//    double powerUp(double a, double b) {
//        return Math.pow(a,b);
//    }
//    
//    //Output is unpredictable
//    //Pure functions emphasize the same input argument produces the same output
//    //Results in output being inconsistent even though the same input argument is passed
//    
//    public static void main(String[] args) {
//        APLCTutorial4 demo = new APLCTutorial4();
//        System.out.println(demo.powerUp(10,2));
//        System.out.println(demo.powerUp(10,2));
//        System.out.println(demo.powerUp(10,2));
//        
////        System.out.println(demo.calc(10)); //10
////        System.out.println(demo.calc(10)); //20
////        System.out.println(demo.calc(10)); //30
//    }
    
    //referential transparency demo
    int add(int a, int b) {
        int result = a + b; //local side effect (not rt)
        //System.out.println("Returning " + result); //access output console resource (cause unreasonable outcome)
        return result;
    }
    
    int times(int a, int b, int c) {
        return a * add(b, c);
    }
    
    public static void main(String[] args) {
        APLCTutorial4 demo = new APLCTutorial4();
        System.out.println(demo.times(10,2,5));
        System.out.println(demo.times(10,2,5));
        System.out.println(demo.times(10,2,5));
    }
}
