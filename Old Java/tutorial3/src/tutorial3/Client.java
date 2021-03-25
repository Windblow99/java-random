package tutorial3;

public class Client {

    public static void main(String[] args) {
        //initiate object
        Account saving = new Account();
        saving.setId(1222);
        saving.setBalance(20000);
        saving.setAnnualInterestRate(0.045);
        System.out.println(saving);
        //show(saving);
        saving.deposit(2000);
        System.out.println(saving);
        //show(saving);
        saving.withdraw(500);
        //show(saving);
        
        //current account
        Account curr = new Account();
        curr.setId(1333);
        curr.setBalance(30000);
        curr.setAnnualInterestRate(0.05);
        System.out.println(curr);
    }
    
//    static void show(Account acc){
//        System.out.println("ID: " + acc.getId());
//        System.out.println("Balance: " + acc.getBalance());
//        System.out.println("Monthly Interest: " + acc.getAnnualInterestRate()/12);
//    }
}