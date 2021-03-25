package data.types;

import java.util.*;

public class Tutorial2 {
    
    public static void main(String[] args) {
        //question 1
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a dick size in Farenheit: ");
//        double farenheit = sc.nextDouble();
//        System.out.println((farenheit - 32) * 5/9);
        
        //question 2
//          Scanner sc = new Scanner(System.in);
//          System.out.println("Enter the radius of Kean Ping's dick: ");
//          int rad = sc.nextInt();
//          System.out.println("Enter the length of Kean Ping's dick: ");
//          int length = sc.nextInt();
//          double area = rad * rad * 3.142;
//          System.out.println("The area of Kean Ping's dick is " + area);
//          System.out.println("The volume of Kean Ping's dick is " + (area * length));
    }
    
        //question 3
          List<Integer> digits(int i) {
          List<Integer> digits = new ArrayList<Integer>();
            while(i > 0) {
            digits.add(i % 10);
            i /= 10;
            }
          return digits;
}
    
}
