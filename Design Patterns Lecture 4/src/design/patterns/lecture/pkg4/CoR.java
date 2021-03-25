package design.patterns.lecture.pkg4;

public class CoR {
    public static void main(String[] args) {
        manager m = new manager();
        regManager rm = new regManager();
        vicePres vp = new vicePres();
        ceo c = new ceo();
        
        m.setNextHandler(rm);
        rm.setNextHandler(vp);
        vp.setNextHandler(c);
        
        ////////
        
        m.makePurchaseRequest(12000);
    }
}

interface handler {
    public void makePurchaseRequest(int value);
}

class manager implements handler {
    private handler h;
    
    public void setNextHandler (handler h) {
        this.h = h;
    }
    
    public void makePurchaseRequest(int value) {
        if(value < 5001) {
            System.out.println("Manager is evaluating the request");
        }
        else {
            h.makePurchaseRequest(value);
        }
    }
}

class regManager implements handler {
    private handler h;
    
    public void setNextHandler (handler h) {
        this.h = h;
    }
    
    public void makePurchaseRequest(int value) {
        if(value < 10001) {
            System.out.println("Regional manager is evaluating the request");
        }
        else {
            h.makePurchaseRequest(value);
        }
    }
}

class vicePres implements handler {
    private handler h;
    
    public void setNextHandler (handler h) {
        this.h = h;
    }
    
    public void makePurchaseRequest(int value) {
        if(value < 100001) {
            System.out.println("VP is evaluating the request");
        }
        else {
            h.makePurchaseRequest(value);
        }
    }
}

class ceo implements handler {
    private handler h;
    
    public void setNextHandler (handler h) {
        this.h = h;
    }
    
    public void makePurchaseRequest(int value) {
        System.out.println("CEO is considering the request...rejected");
    }
}