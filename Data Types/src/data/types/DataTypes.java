package data.types;
import java.util.*;


public class DataTypes {
    //Notes
    //Primitive Data Type (PDT) vs. Wrapper class
    //Numeric type
    //byte, short, int, long
    byte b = 10; //8 bit
    short s = 100; //16 bit
    int i = 500;//32 bit
    long l = 9888888;//64bit
    //floating point type
    float f = 1.9F; //32bit
    double d = 9.9;//64bit
    //character
    char c = 'a'; //Object
    
    //Wrapper class - object type
    //PDT: byte
    Byte b2 = 10;
    
    Short s2 = 20;//wrapper class
    Short s3 = s2;//wrapper class
    short s4 = 20; //PDT
    short s5 = s4; //PDT
    
    Integer i2 = 30;
    Long l2 = 40L;
    
    //variable declaration - memory location
    //declare a variable named quantity typed int
    int quantity; //variable declaration
    
    public static void main(String[] args) {
        
    }
    
    static void enhancedfor(String[] args){
      //array
        double[] nums = {1.1,2.2,3.3,4.4,5.5};
        double sum = 0;
    
        //enhanced for
        for(double temp : nums){
        sum = sum + temp;
        }
    }
    
    static void scanner(String[] args){
        Scanner scan = new Scanner(System.in); //API
        System.out.println("Enter a feet : ");
        int foot = scan.nextInt();
        
        double meter = foot * 0.305;
        
        System.out.println("Meter: " + meter);
    }
    
}
