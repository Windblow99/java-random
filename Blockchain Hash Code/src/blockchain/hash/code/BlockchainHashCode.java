package blockchain.hash.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BlockchainHashCode {
    //what is hash code?
        //Every data object comes with a hash value
    //Built-in hash function for generating the data object (hash).
    
    //in data security, we use hash function from the family called
        //secure hashing algorithm (SHA-256, etc)
        //used in blockchain
    
    //encryption is not hashing
    //hashing function is collision resistant
        //
    public static void main(String[] args) {
//        String data = "helloworld!";
//        
//        System.out.println("Data: " + data);
//        System.out.println("Hashcode: " + data.hashCode());
        HashSetDemo();
    }
    
    static void HashSetDemo(){
        List<Integer> lst = new LinkedList();
        lst.add(10);
        lst.add(20);
        lst.add(30);
        System.out.println(lst.hashCode());
        
        System.out.println("remove an element");
        lst.remove(1);
        System.out.println(lst.hashCode());
        System.out.println("add 2 new entries");
        lst.add(40);
        lst.add(50);
        System.out.println(lst.hashCode());
    }
}
