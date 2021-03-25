package design.methods.tutorial.pkg9;

public class DesignMethodsTutorial9 {
    public static void main(String[] args) {
        entertainmentFacade ef = new entertainmentFacade();
        ef.start();
        ef.off();
    }
}

class entertainmentFacade {
    sound front;
    sound rear;
    tv t;
    lights oh;
    lights table;
    curtains c;
    streaming str;
    
    public entertainmentFacade() {
        front = new frontSpeakers();
        rear = new rearSpeakers();
        t = new tv();
        oh = new overheadLights(new lightOn());
        table = new tableLamps(new lightOn());
        c = new curtains();
        str = new streaming();
    }
    
    public void start() {
        System.out.println("Setting up the entertainment system...");
        c.close();
        oh.power();
        t.on();
        front.on();
        rear.on();
        str.beginStreaming();
    }
    
    public void off() {
        System.out.println("Stopping the entertainment system...");
        c.open();
        oh.power();
        t.off();
        front.off();
        rear.off();
        str.stopStreaming();
    }
}

abstract class sound {
    abstract public void on();
    abstract public void off();
}

class frontSpeakers extends sound {
    public void on() {
        System.out.println("Switching front speakers on");
    }
    public void off() {
        System.out.println("Switching front speakers off");
    }
}

class rearSpeakers extends sound {
    public void on() {
        System.out.println("Switching rear speakers on");
    }
    public void off() {
        System.out.println("Switching rear speakers off");
    }
}

class tv {
    public void on() {
        System.out.println("Switching tv on");
    }
    public void off() {
        System.out.println("Switching tv off");
    }
}

abstract class lights {
    lightState state;
    
    public lights(lightState s) {
        state = s;
    }
    
    public void setState(lightState s){
        state = s;
    }
    
    abstract public void power();
}

interface lightState {
    public void onOff(lights l);
}

class lightOn implements lightState {
    public void onOff(lights l) {
        System.out.println(l.getClass().getSimpleName() + " have been switched on");
        l.setState(new lightOff());
    }
}

class lightOff implements lightState {
    public void onOff(lights l) {
        System.out.println(l.getClass().getSimpleName() + " have been switched off");
        l.setState(new lightOn());
    }
}

class overheadLights extends lights {
    public overheadLights(lightState s){
        super(s);
    }
    
    public void power() {
        state.onOff(this);
    }
}

class tableLamps extends lights {   
    public tableLamps(lightState s){
        super(s);
    }
    
    public void power() {
        state.onOff(this);
    }
}

class curtains {
    public void close() {
        System.out.println("Closing the curtains");
    }
    public void open() {
        System.out.println("Opening the curtains");
    }
}

class streaming {
    public void beginStreaming() {
        System.out.println("Selecting movie from playlist");
        System.out.println("Playing movie from playlist");
    }
    public void stopStreaming() {
        System.out.println("Stopping stream");
    }
}