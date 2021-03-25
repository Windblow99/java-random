package classlab;
import java.util.Scanner;

class Account //Name of the class
{
    //Member or attributes declarations
    private int id;
    private double balance;
    private double annualinterestrate;
    //Implementation of methods in account class
    //Constructors should not have return type
    public Account(){balance = 500;} //Empty Constructor - the method that is fired/exeuted first when the object is created
    //Getters to return values of the class members
    public int getid(){return id;}
    public double getbalance(){return balance;}
    public double getannualinterestrate() {return annualinterestrate;}
    //Setters to assign values to class members
    public void setid(int Aid){id=Aid;}
    public void setbalance(double bal) {balance=bal;}
    public void setannualinterestrate(double rate){annualinterestrate = rate;}
    public double getmonthlyinterestrate()
    {
        return annualinterestrate/12;
        //return getannualinterestrate/12;
    }
    public void withdraw(double amount){balance -= amount;}
    public void deposit(double amount){balance += amount;}
}
public class Classlab {

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        Account Dick = new Account();
        Dick.setid(69696969);
        Dick.setbalance(100000);
        Dick.setannualinterestrate(5.0);
        Dick.withdraw(7000);
        Dick.withdraw(8000);
        Dick.deposit(250);
        System.out.println("Account Details");
        System.out.println("Account id = " + Dick.getid());
        System.out.println("Account current balance = " + Dick.getbalance());
        System.out.println("8==3---------------------");
        System.out.println("Enter account details to suck cock");
        System.out.println("Enter account ID");
        int vAid = Sc.nextInt();
        System.out.println("Enter your sperm bank count");
        double vAbal = Sc.nextDouble();
        System.out.println("Enter your sperm interest rate");
        double vAir = Sc.nextDouble();
        Account myAcct = new Account();
        myAcct.setid(vAid);
        myAcct.setbalance(vAbal);
        myAcct.setannualinterestrate(vAir);
        //go for some transactions and print the details
        System.out.println("Account Details");
        System.out.println("Account id = " + myAcct.getid());
        System.out.println("Account current balance = " + myAcct.getbalance());
    }
    
}
