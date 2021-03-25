package DesignPatternsTutorial12;


public class Ex {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

abstract class topping {}
class cubes extends topping {}
class floss extends topping {}
class tandoori extends topping {}

abstract class sauce {}
class tomato extends sauce {}
class spicy extends sauce {}
class basil extends sauce {}

abstract class dough {}
class thin extends dough {}
class thick extends dough {}
class stuffed extends dough {}

class pizza {
    dough dh;
    sauce sa;
    topping to;
    
    public void setDough(dough dh) {
        this.dh = dh;
    }
    
    public void setSauce(sauce dh) {
        this.sa = dh;
    }
    
    public void setTopping(topping dh) {
        this.to = dh;
    }
}

abstract class pizzaFactory {
    abstract public dough makeDough();
    abstract public sauce makeSauce();
    abstract public topping makeTopping();
    
    public void makePizza() {
        
    }
}

class klPizzaFactory extends pizzaFactory {
    pizza pi;
    
    public dough makeDough(){
        return new thin();
    }
    
    public sauce makeSauce() {
        return new tomato();
    }
    
    public topping makeToppping() {
        return new cubes();
    }

    @Override
    public topping makeTopping() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class penPizzaFactory extends pizzaFactory {
    public dough makeDough(){
        return new thick();
    }
    
    public sauce makeSauce() {
        return new spicy();
    }
    
    public topping makeToppping() {
        return new tandoori();
    }

    @Override
    public topping makeTopping() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class jbPizzaFactory extends pizzaFactory {
    public dough makeDough(){
        return new stuffed();
    }
    
    public sauce makeSauce() {
        return new basil();
    }
    
    public topping makeToppping() {
        return new floss();
    }

    @Override
    public topping makeTopping() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class pizzaDirector {
    pizzaFactory pf;
    pizza pi;
    
    public pizza orderPizza(String location) {
        if (location.equalsIgnoreCase("kl")) {
            pf = new klPizzaFactory();
        }
        
        pi = new pizza();
        
        pi.setDough(pf.makeDough());
        pi.setSauce(pf.makeSauce());
        pi.setTopping(pf.makeTopping());
        
        return pi;
    }
}