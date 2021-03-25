package lecture.week.pkg6;

public class LectureWeek6 {

}
class Account{
    //modifiers can be private, public, protected, package-private
    protected double balance;
    int id; //package - private
    
    //constructor
    public Account(){} //if no default constructor, cannot use super
    public Account(double bal){
        balance = bal;
    }
    public double getBalance(){
        return balance;
    }
    
    //deposit - this serves as a base implementation
    public void deposit(double amt){
        this.balance += amt;
    }
    //withdraw
    public void withdraw(double amt){
        this.balance -= amt;
    }
}

class Savings extends Account{
    
    public Savings(){
        super();
    }
    //add Interest
    
    @Override //this is called polymorphism (overriding method deposit from parent class
    public void deposit(double amt){
        this.balance += amt-1;
    }
    
    @Override
    public void withdraw(double amt){
        this.balance -= amt-1;
    }
}

class Checking extends Account{
    //deduction
    
    @Override //this is called polymorphism (overriding method deposit from parent class
    public void deposit(double amt){
        this.balance += amt-1;
    }
    
    @Override
    public void withdraw(double amt){
        this.balance -= amt-1;
    }
}