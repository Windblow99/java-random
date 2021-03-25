package design.patterns.tutorial.pkg8;

public class DesignPatternsTutorial8 {
    public static void main(String[] args) {
        beverage myTea = new tea();
        myTea.makeBeverage(); //using the template method pattern to create the beverage
    }
}

abstract class beverage {
    public void makeBeverage() { //template for preparing a beverage || template method
        //Listed the steps to make a beverage
        boilWater();
        prepareBev();
        pourWater();
        stir();
    }
    
    public void boilWater() {
        System.out.println("Boiling the water for the beverage");
    }
    
    public void pourWater() {
        System.out.println("Pouring the boiled water into the container");
    }
    
    public void stir() { //hook method
        System.out.println("Stirring the beverage!");
    }
    
    abstract public void prepareBev();
}

class coffee extends beverage {
    public void prepareBev() {
        System.out.println("Grinding the coffee");
    }
}

class tea extends beverage {
    public void prepareBev() {
        System.out.println("Soaking the teabag");
    }
}