package aplc.tutorial.pkg11;

import java.util.HashMap;
import java.util.Map;
import org.jpl7.Query;
import org.jpl7.Term;


public class demo {
    
    //prolog filename
    static final String plFile = "tutorial10.pl";
    
    public static void main(String[] args) {
        tst1();
        tst2();
    }
    
    static void tst1() {
        //consult pl file
        String s1 = "consult('" + plFile + "')";
        Query q1 = new Query(s1);
        System.out.println(q1.hasSolution() ? "success" : "fail");
        q1.close();
        
        String s2 = "male(Who)";
        Query q2 = new Query(s2);
        Map<String, Term> sol = q2.oneSolution();
        System.out.println("\nfirst solution:" + sol.get("Who"));
    }
    
    static void tst2() {
        String s1 = "rich(Who)";
        Query q1 = new Query(s1);
        //1
        System.out.println("\nLooking for rich guys...");
        Map<String, Term> sol = new HashMap<String, Term>();
        while (q1.hasMoreSolutions()) {
            sol = q1.nextSolution();
            System.out.println(sol.get("Who"));
        }
        //q1.close();
        
        //2
        Map<String, Term>[] sols = q1.allSolutions();
        for (int i = 0; i < sols.length; i++) {
            System.out.println(sols[i].get("Who"));
        }
    }
}
