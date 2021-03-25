package association;

import java.util.Scanner;

class Vote {
    private int count;
    public void Vote(){}
    public int getCount() {return count;}
    public void setCount(int count)
    {this.count = count;}
    
    public void increment() { count++;}
    public void decrement(){ count--;}  
}

class Candidate {
    private String name;
    private Vote vote;
    public void Candidate(){}
    public Candidate (String name, Vote vote){
        this.name = name;
        this.vote = vote;
    }
    public String getName(){return name;}
    public Vote getVote(){return vote;}  
}

public class Association {
   
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
         Vote V1 = new Vote();
         Vote V2 = new Vote();
        
        String choice = "Y";
        String opt;
       do 
               {
                   System.out.println("1 - Vote for Candidate 1");
                   System.out.println("2 - Vote for Candidate 2 ");
                   System.out.println("-1 - Downvote Candidate 1");
                   System.out.println("-2 - Downvote Candidate 2 ");
                   choice = Sc.next();
                    switch (choice)
                    {
                        case "1":  { V1.increment(); break;}
                        case "2":  { V2.increment(); break;}
                         case "-1":  { V1.decrement(); break;}
                        case "-2":  { V2.decrement(); break;}               
                    }
                       System.out.println("Wish to Continue Y/N");
                   opt= Sc.next(); 
               }
    while (opt.equals("Y") );
       
         Candidate Lee = new Candidate("Lee Chen",V1);
         Candidate Foo = new Candidate("Foo Chen",V2);
         System.out.println("Lee Chen Total Vote Count=" + V1.getCount());
         // Another way //
         System.out.println("Cadidate Details");
         System.out.println("Candidate Name" + Lee.getName());
         Vote Temp = Lee.getVote();
         System.out.println("Lee VoteCount="+ Temp.getCount());
    }
    
}
