package factoryMethod;

import java.util.*;
public class factorymethodEx {

    public static void main(String[] args) {
        toolFactory tf = new toolFactory();
        //tool t;
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to tool rental, plase select a type of tool");
        
        String choice = in.nextLine();
        
        tool toolRental = tf.makeTool(choice);
        
        System.out.println("You have selected a " + toolRental.getClass().getSimpleName());
    
        //process rental
    }

}

class tool{}
class drill extends tool{}
class ladder extends tool{}
class saw extends tool{}

class toolFactory{
    private tool t;
    
    public tool makeTool(String choice){
        if (choice.equalsIgnoreCase("s")){
            t = new saw();
        }
        else if (choice.equalsIgnoreCase("d")){
            t = new drill();
        }
        else {
            t = new ladder();
        }
        
        return t;
    }
}