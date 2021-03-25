package tutorial3;
import java.util.Scanner;

public class Tutorial3 {
   
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        /* Question 1
        System.out.println("Enter the first number");
        int number1 = Sc.nextInt();
        System.out.println("Enter the second number");
        int number2 = Sc.nextInt();
        System.out.println("Enter the third number");
        int number3 = Sc.nextInt();
        
        if (number1 <= number2 && number2 <= number3){
            System.out.println("Number 3>Number2>Number1");
        }else if (number1 <= number3 && number3<= number2){
            System.out.println("number2>number3>number1");
        }else if (number2 <= number1 && number1<= number3){
            System.out.println("number2>number1>number3");
        }else if (number2 <= number3 && number3<= number1){
            System.out.println("number1>number3>number2");
        }else if (number3 <= number2 && number2<= number1){
            System.out.println("number1>number2>number3");
        }else if (number3 <= number1 && number1<= number2){
            System.out.println("number2>number1>number3");
        }*/
        
        //Question 2
        /*System.out.println("Enter the value of the first edge");
        double value1 = Sc.nextDouble();
        System.out.println("Enter the value of the first edge");
        double value2 = Sc.nextDouble();
        System.out.println("Enter the value of the first edge");
        double value3 = Sc.nextDouble();
        
        if ((((value1 + value2 )> value3) || ((value1+value3)>value2)) || ((value2+value3)>value1)){
            System.out.println("Logic is valid");
            System.out.println(value1+value2+value3);
        }else{
            System.out.println("The logic is false");
        }*/
        
        //Question 3
        /*System.out.println("Enter the month desired.");
        String month = Sc.nextLine();
        month = month.toUpperCase();
        System.out.println("Enter the year desired in digits.");
        int year = Sc.nextInt();
        
        if((year%4)==0){
            switch(month){
                case("JANUARY"):
                case("MARCH"):
                case("MAY"):
                case("JULY"):
                case("AUGUST"):
                case("OCTOBER"):
                case("DECEMBER"):
                {
                    System.out.println(month + " has 31 fucking days, moron.");
                    break;
                }
                case("FEBRUARY"):
                {
                    System.out.println("February has 29 fucking days, moron.");
                    break;
                }
                case("APRIL"):
                case("JUNE"):
                case("SEPTEMBER"):
                case("NOVEMBER"):
                {
                    System.out.println(month + " has 30 fucking days, moron.");
                    break;
                }
            }
        }else if ((year%4)>0){
            switch(month){
                case("JANUARY"):
                case("MARCH"):
                case("MAY"):
                case("JULY"):
                case("AUGUST"):
                case("OCTOBER"):
                case("DECEMBER"):
                {
                    System.out.println(month + " has 31 fucking days, moron.");
                    break;
                }
                case("FEBRUARY"):
                {
                    System.out.println("February has 29 fucking days, moron.");
                    break;
                }
                case("APRIL"):
                case("JUNE"):
                case("SEPTEMBER"):
                case("NOVEMBER"):
                {
                    System.out.println(month + " has 30 fucking days, moron.");
                    break;
                }
            }
        }*/
        
        //Question 4
        /*System.out.println("Enter the your assignment marks and meet your fate.");
        double marks = Sc.nextDouble();
        
        if (marks>=0 && marks<=40 ){
            System.out.println("Your grade is F and you have fucking failed.");
        }else if (marks>=41 && marks<=49 ){
            System.out.println("Your grade is F+ and you have fucking failed marginally.");
        }else if (marks>=50 && marks<=54 ){
            System.out.println("Your grade is D and you have fucking passed.");
        }else if (marks>=55 && marks<=64 ){
            System.out.println("Your grade is C and you have fucking passed.");
        }else if (marks>=65 && marks<=69 ){
            System.out.println("Your grade is B and you have fucking passed with a credit.");
        }else if (marks>=70 && marks<=74 ){
            System.out.println("Your grade is B+ and you have fucking passed with a credit.");
        }else if (marks>=75 && marks<=79 ){
            System.out.println("Your grade is A and you have fucking passed with a distinction.");
        }else if (marks>=80 && marks<=100 ){
            System.out.println("Your grade is A+ and you have fucking passed with a distinction.");
        }*/
        
        //Question 5
        /*Scanner scanner = new Scanner(System.in);
        double[] array = new double[100];
        double sum = 0;
        System.out.println("Input a number:");
        for (int i=0; i<100;)
        {
    	  array[i] = scanner.nextInt();
          for( double num : array) {
          sum = sum+num;
          }
          System.out.println("Sum of input numbers is:"+sum);
        }*/
        
        //Question 6
        /*double fee = 10000;
        
        for(int i = 1; i <= 10; i++){
        fee += fee * .05;

        if (i == 10) {
            System.out.println("The cost of tuition in 10 years is $" + fee);
        }
        }*/

        //Question7
        /*System.out.println("Proceed to not end your life? Yes or No? You will go peacefully.");
        String input = Sc.next();
        input = input.toUpperCase();
        
        do
        {
              System.out.println("Why do you so willfully reject it?");
              System.out.println("Proceed to not end your life? Yes or No? You will go peacefully.");
              input = Sc.next();
              input = input.toUpperCase();
        }
        while (input.equals("YES"));*/
    }
    
}
