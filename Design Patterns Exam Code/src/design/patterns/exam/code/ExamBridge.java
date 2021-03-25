package design.patterns.exam.code;

public class ExamBridge {
    public static void main(String[] args) {
        PC l = new Laptop(new AMD(), new Integrated());
        PC l2 = new Laptop(new AMD(), new Dedicated());
        PC l3 = new Laptop(new Intel(), new Integrated());
        PC l4 = new Laptop(new Intel(), new Dedicated());
        
        PC d = new Desktop(new AMD(), new Integrated());
        PC d2 = new Desktop(new AMD(), new Dedicated());
        PC d3 = new Desktop(new Intel(), new Integrated());
        PC d4 = new Desktop(new Intel(), new Dedicated());
            
        System.out.println(l);        
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(l4);
        System.out.println();
        System.out.println(d);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
    }   
}

interface Graphics {
    public String getGraphics();
}
 
class Dedicated implements Graphics {
    @Override
    public String getGraphics() {
        return "Dedicated Graphics";
    }
}
 
class Integrated implements Graphics {
    @Override
    public String getGraphics() {
        return "Integrated Graphics";
    }
}
 
interface CPU {
    public String getCPU();
}
 
 
class Intel implements CPU {
    @Override
    public String getCPU() {
        return "Intel CPU";
    }
}
 
class AMD implements CPU {
    @Override
    public String getCPU() {
        return "AMD CPU";
    }
}
 
abstract class PC {
    CPU c;
    Graphics g;
 
    public PC(CPU c, Graphics g) {
        this.c = c;
        this.g = g;
    }
 
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " CPU = " + c.getClass().getSimpleName() + ", GPU= " + g.getClass().getSimpleName();
    }
}
 
class Laptop extends PC {
    public Laptop(CPU c, Graphics g) {
        super(c, g);
    }
}
 
class Desktop extends PC {
    public Desktop(CPU c, Graphics g) {
        super(c, g);
    } 
}