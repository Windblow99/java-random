package design.methods.lecture.pkg6;

public class StrategyandFactory {
    public static void main(String[] args) {
        ticketFactory tf = new ticketFactory();
        
        ticket myTicket = tf.getTicket("adult", new fixed());       
        System.out.println(myTicket.ticketCost(3));
        
        ticket myTicket2 = tf.getTicket("child", new variable());       
        System.out.println(myTicket2.ticketCost(13));
    }
}

interface price {
    public int calcCost(String type, int distance);
}

class fixed implements price {
    int cost;
    public int calcCost(String type, int distance) {
        if (type.equalsIgnoreCase("adult")){
            cost = 10;
        }else {
            cost = 7;
        }
        return cost;
    }
}

class variable implements price {
    int cost;
    int additionalCost = 0;
    
    public int calcCost(String type, int distance) {
        if (type.equalsIgnoreCase("adult")){
            cost = 10;
            additionalCost = distance - 5;
            cost += additionalCost;
        }else {
            cost = 7;
            additionalCost = distance - 5;
            cost += additionalCost;
        }
        return cost;
    }
}

abstract class ticket {
    price p;
    
    public ticket(price p) {
        this.p = p;
    }
    
    public void setP(price p) {
        this.p = p;
    }
    
    abstract public int ticketCost(int distance);
}

class adult extends ticket {
    public adult(price p) {
        super(p);
    }
    public int ticketCost(int distance) {
        return p.calcCost(this.getClass().getSimpleName(), distance);
    }
}

class child extends ticket {
    public child(price p) {
        super(p);
    }
    public int ticketCost(int distance) {
        return p.calcCost(this.getClass().getSimpleName(), distance);
    }
}

class ticketFactory {
    ticket t;
    
    public ticket getTicket(String type, price p) {
        if(type.equalsIgnoreCase("a")) {
            t = new adult(p);
        }
        else {
            t = new child(p);
        }
        return t;
    }
}