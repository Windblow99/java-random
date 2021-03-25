package design.methods.lecture.pkg3;

public class Decorator {
    public static void main(String[] args) {
        coffee myCoffee = new coffee();
        System.out.println("description: " + myCoffee.desc());
        System.out.println("cost: " + myCoffee.cost());
        
        beverage customCoffee = new chocolate(myCoffee);
        System.out.println("description: " + customCoffee.desc());
        System.out.println("cost: " + customCoffee.cost());
        
        beverage customCoffee2 = new sprinkles(new sprinkles(new chocolate(myCoffee)));
        System.out.println("description: " + customCoffee2.desc());
        System.out.println("cost: " + customCoffee2.cost());
    }
}

interface beverage{
    public int cost();
    public String desc();
}

class coffee implements beverage {
    public int cost(){
        return 6;
    }
    
    public String desc(){
        return "Standard coffee";
    }
}

abstract class beverageDecorator implements beverage {
    beverage c;
    
    public beverageDecorator(beverage c){
        this.c = c;
    }
    
    public int cost(){
        return c.cost();
    }
    
    public String desc(){
        return c.desc();
    }
}

class chocolate extends beverageDecorator {
    public chocolate(beverage c){
        super(c);
    }
    
    public int cost(){
        return c.cost() + 3;
    }
    
    public String desc(){
        return c.desc() + ": with Chocolate";
    }
}

class sprinkles extends beverageDecorator {
    public sprinkles(beverage c){
        super(c);
    }
    
    public int cost(){
        return c.cost() + 4;
    }
    
    public String desc(){
        return c.desc() + ": with sprinkles";
    }
}