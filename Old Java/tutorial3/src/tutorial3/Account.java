package tutorial3;

public class Account {
    //data
    //encapsulate the data - hide
    //set the visibility to data fields
    private int id;
    private double balance,annualInterestRate;
    
    //operation
    //default constructor
    public Account (){}
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        //validation
        if (id > 0){
            this.id = id;
        }
    }
    
    public double getBalance(){
        return balance;
    }
    
    public void setBalance(double bal){
        this.balance = bal;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    public void deposit(double amt){
        this.balance += amt;
    }
    
    public void withdraw(double amt){
        this.balance -= amt;
    }
    
    public String toString(){
        return "ID: " + this.getId() + "\nBalance: " + this.getBalance();
    }
}
