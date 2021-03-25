package design.patterns.lecture.pkg5;

public class adapterEx {
    public static void main(String[] args) {
        
        laptop l = new laptop();
        
        socket(l);
        
        
        laptop2Pin l2 = new laptop2Pin();
        
        adapter adapt = new adapter(l2);
        
        socket(adapt);
        
    }
    
    public static void socket(threePin tpin){
        tpin.powerOn();
    }
}

interface threePin {
    public void powerOn();
}

class laptop implements threePin {

    @Override
    public void powerOn() {
        System.out.println("Powering on three pin laptop");
    }
    
}

interface twoPin {
    public void powerOnTwoPin();
}

class laptop2Pin implements twoPin {

    @Override
    public void powerOnTwoPin() {
        System.out.println("Powering on the 2pin laptop");
    }
    
}


class adapter implements threePin {
    twoPin tpin;

    public adapter(twoPin tpin) {
        this.tpin = tpin;
    }

    public void setTpin(twoPin tpin) {
        this.tpin = tpin;
    }
       
    
    @Override
    public void powerOn() {
        System.out.println("adapting the incompatible interface");
        tpin.powerOnTwoPin();
    }
    
    
}


