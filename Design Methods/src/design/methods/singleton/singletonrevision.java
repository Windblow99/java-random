package design.methods.singleton;

public class singletonrevision {
}

class toolFactory {
    private tool t;
    private static toolFactory tf;
    
    private toolFactory(){}
    
    public static toolFactory getInstance(){
        if(tf==null){
            tf = new toolFactory(); //lazy instantiation
        }
        return tf;
    }
    
    public tool getTool(String s) {
        if (s.equalsIgnoreCase(anotherString:"s")) {
            t = new saw();
        }
        else if (s.equalsIgnoreCase(anotherString:"d")) {
            t = new drill();
        }
        else {
            t = null;
        }
    }
}

class tool {}
class saw extends tool {}
class drill extends tool {}
