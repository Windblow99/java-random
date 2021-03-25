package aplc.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTutorial {
    public static void main(String[] args) {
        List<String> names
                    = Arrays.asList("Dory", "Gill", "Bruce", "Nemo");
        boolean result = findNemo(names); //cause local side effect in purity concept
        System.out.println(result ? "Found Nemo" : "Sorry, Nemo not found!");
    }
   
    static boolean findNemo(List<String>names){
        return names.stream().anyMatch(x->x.equalsIgnoreCase("Nemo"));
    }
}

//public class Lab2Nemo {
//    public static void main(String[] args) {
//        List<String> names = Arrays.asList("Dory", "Gill", "Bruce", "Nemo");
//        findNemo(names);
//    }
//    
//    static void findNemo(List<String> names){
//        boolean ans = names.stream().anyMatch(n -> n.equals("Nemo"));
//        System.out.println(ans ? "Found Nemo" : "Sorry, Nemo not found");
//    }
//}

//model answer
//public static void findNemo2(List<String>names) {
//    //get Stream from coll
//    String target = names.stream()
//               .filter(elem->elem.equals("Nemo"))
//               .findAny()
//               .orElse(null);
//    System.out.println((target != null) ? "Found Nemo" : "Sorry, Nemo");
//}