package design.patterns.lecture.pkg4;

public class CoRFurniture {
    public static void main(String[] args) {
        gradeA gA = new gradeA();
        gradeB gB = new gradeB();
        gradeC gC = new gradeC();
        
        gA.setHandler(gB);
        gB.setHandler(gC);
        
        furniture myFurn = gA.makeFurniture("c", "t");
    }
}

interface handler3 {
    public void setHandler(handler3 h3);
    public furniture makeFurniture(String grade, String type);
}

abstract class furniture {
    
}

class table extends furniture {}
class shelf extends furniture {}
class chair extends furniture {}

class gradeA implements handler3 {
    handler3 h3;
    furniture f;
    
    public void setHandler(handler3 h3) {
        this.h3 = h3;
    }
    
    public furniture makeFurniture (String grade, String type) {
        if(grade.equalsIgnoreCase("a")){
            if(type.equalsIgnoreCase("t")){
                f = new table();
            }
            else if(type.equalsIgnoreCase("s")){
                f = new shelf();
            }
            else {
                f = new chair();
            }
            return f;
        }
        else {
            return h3.makeFurniture(grade, type);
        }
    }
}

class gradeB implements handler3 {
    handler3 h3;
    furniture f;
    
    public void setHandler(handler3 h3) {
        this.h3 = h3;
    }
    
    public furniture makeFurniture (String grade, String type) {
        if(grade.equalsIgnoreCase("a")){
            if(type.equalsIgnoreCase("t")){
                f = new table();
            }
            else if(type.equalsIgnoreCase("s")){
                f = new shelf();
            }
            else {
                f = new chair();
            }
            return f;
        }
        else {
            return h3.makeFurniture(grade, type);
        }
    }
}

class gradeC implements handler3 {
    handler3 h3;
    furniture f;
    
    public void setHandler(handler3 h3) {
        this.h3 = h3;
    }
    
    public furniture makeFurniture (String grade, String type) {
        if(grade.equalsIgnoreCase("a")){
            if(type.equalsIgnoreCase("t")){
                f = new table();
            }
            else if(type.equalsIgnoreCase("s")){
                f = new shelf();
            }
            else {
                f = new chair();
            }
            return f;
        }
        else {
            return h3.makeFurniture(grade, type);
        }
    }
}