package design.patterns.tutorial.pkg8;

//public class pizzaTemplateMethod {

import java.util.Scanner;

//    public static void main(String[] args) {
//        boolean extra = true;
//        pizza p1 = new beef();
//        pizza p2 = new chicken();
//        p1.makePizza(true);
//        p2.makePizza(false);
//    }
//}
//
//abstract class pizza{
//    final public void makePizza(boolean extra){
//        prepareDough();
//        putTomatoBase();
//        addToppings();
//        putExtra(extra);
//        PutCheese();
//    }
//    
//    final public void prepareDough(){
//        System.out.println("Preparing the pizza dough...");
//    }
//    
//    public void putTomatoBase(){
//        System.out.println("Putting tomato sauce base on the dough...");
//    }
//    
//    public void PutCheese(){
//        System.out.println("Adding cheese on the pizza layer...");
//    }
//    
//    public void putExtra(boolean extra){
//        if(extra == true){
//            System.out.println("Adding extra toppings...");
//        }
//    }
//    
//    abstract public void addToppings();
//}
// 
//class beef extends pizza{
//    public void addToppings(){
//        System.out.println("Putting beef toppings on the pizza...");
//    }
//}
// 
//class chicken extends pizza{
//    public void addToppings(){
//        System.out.println("Putting chicken toppings on the pizza...");
//    }
//}
// 
//class veg extends pizza{
//    public void addToppings(){
//        System.out.println("Putting vegetable toppings on the pizza...");
//    }
//}
// 
//class seafood extends pizza{
//    public void addToppings(){
//        System.out.println("Putting seafood toppings on the pizza...");
//    }
//}

//sample answer
public class pizzaTemplateMethod {
    public static void main(String[] args) {
        pizza myPizza = new chickenPizza();
        
        myPizza.makePizza();
    }
}

abstract class pizza { //template method - final
    final public void makePizza() {
        makeDough();
        addTomatoBase();
        addMainTopping();
        addCheese();
        if (topping()) { //hook method
            addExtraTopping();
        }
    }
    
    public boolean topping() { //used to override in the implementations
        return false;
    }
    
    final public void makeDough() {
        System.out.println("making the dough for the pizza");
    }
    
    abstract public void addMainTopping();
    
    final public void addTomatoBase() { //we do not change final methods
        System.out.println("adding a base of fresh tomato");
    }
    
    public void addCheese() {
        System.out.println("adding cheese to the pizza");
    }
    
    abstract public void addExtraTopping(); //to be implemented by the subclasses
}

class chickenPizza extends pizza {
    public void addExtraTopping() {
        System.out.println("adding olives to the chicken pizza");
    }
    
    public void addMainTopping() {
        System.out.println("adding chicken pieces to the pizza");
    }
    
    //overriding the hook method
    public boolean topping() {
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to add an extra topping?");
        String top = in.nextLine();
        
        if(top.equalsIgnoreCase("y")) {
            return true;
        }
        else {
            return false;
        }
    }
}

