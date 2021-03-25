package design.patterns.exam.code;

import java.util.Scanner;

public class DesignPatternsExamCode {
    public static void main(String[] args) {
        pizzaria myPizza = new BeefPepperoni();
        
        myPizza.assemblePizza();
    }
}

abstract class pizzaria {
    final public void assemblePizza() {
        prepareDough();
        applyTomatoSauceBase();
        baseTopping();
        addCheeseCovering();
        if (optionalAddOn()) {
            addExtraTopping();
        }
    }
    
    public boolean optionalAddOn() {
        return false;
    }
    
    final public void prepareDough() {
        System.out.println("preparing the dough for the pizza");
    }
    
    abstract public void baseTopping();
    
    final public void applyTomatoSauceBase() {
        System.out.println("adding a base of fresh tomato");
    }
    
    public void addCheeseCovering() {
        System.out.println("adding cheese to the pizza");
    }
    
    abstract public void addExtraTopping();
}

class BeefPepperoni extends pizzaria {
    @Override
    public void addExtraTopping() {
        System.out.println("adding extra cheese to the beef pizza");
    }
    
    @Override
    public void baseTopping() {
        System.out.println("adding beef to the pizza");
    }

    @Override
    public boolean optionalAddOn() {
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

class HawaiianChicken extends pizzaria {
    @Override
    public void addExtraTopping() {
        System.out.println("adding extra olives to the chicken pizza");
    }
    
    @Override
    public void baseTopping() {
        System.out.println("adding chicken to the pizza");
    }
    
    @Override
    public boolean optionalAddOn() {
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

class VeggieLovers extends pizzaria {
    @Override
    public void addExtraTopping() {
        System.out.println("adding extra pineapple to the veggie pizza");
    }
    
    @Override
    public void baseTopping() {
        System.out.println("adding veggie to the pizza");
    }

    @Override
    public boolean optionalAddOn() {
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

class Seafood extends pizzaria {
    @Override
    public void addExtraTopping() {
        System.out.println("adding extra tuna to the seafood pizza");
    }
    
    @Override
    public void baseTopping() {
        System.out.println("adding seafood to the pizza");
    }

    @Override
    public boolean optionalAddOn() {
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