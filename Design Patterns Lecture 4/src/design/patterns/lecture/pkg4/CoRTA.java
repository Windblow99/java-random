package design.patterns.lecture.pkg4;

public class CoRTA {
    public static void main(String[] args) {
        wifiError wi = new wifiError();
        printError pr = new printError();
        deptHead dh = new deptHead();
        
        wi.setH(pr);
        pr.setH(dh);
        
        wi.reportError("Please help i cannot access the wifi");
    }
}

interface handler2 {
    public void reportError(String msg);
}

class wifiError implements handler2 {
    private handler2 h2;
    
    public void setH (handler2 h2) {
        this.h2 = h2;
    }
    
    public void reportError(String msg){
        if(msg.contains("wifi")){
            System.out.println("Thank you for reporting your wifi issue, someone will be with you shortly");
        }
        else{
            h2.reportError(msg);
        }
    }
}

class printError implements handler2 {
    private handler2 h2;
    
    public void setH (handler2 h2) {
        this.h2 = h2;
    }
    
    public void reportError(String msg){
        if(msg.contains("print")){
            System.out.println("Thank you for reporting your print issue, someone will be with you shortly");
        }
        else{
            h2.reportError(msg);
        }
    }
}

class deptHead implements handler2 {
    private handler2 h2;
    
    public void setH (handler2 h2) {
        this.h2 = h2;
    }
    
    public void reportError(String msg){
        System.out.println("Please provide more details");
    }
}