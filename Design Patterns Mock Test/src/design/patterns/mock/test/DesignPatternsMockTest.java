package design.patterns.mock.test;

public class DesignPatternsMockTest {

    public static void main(String[] args) {
        electricItem toothbrush = new toothbrush(new voltage120v());
        electricItem toothbrush2 = new toothbrush(new voltage240v());
    }   
}

interface voltage {
    
}

class voltage240v implements voltage {}
class voltage120v implements voltage {}

abstract class electricItem {
    voltage volt;
    int id;
    
    public electricItem(voltage v) {
        this.volt = v;
    }
}

class toothbrush extends electricItem {
    public toothbrush(voltage v) {
        super(v);
    }
}

class hairdryer extends electricItem {
    public hairdryer(voltage v) {
        super(v);
    }
}

class shaver extends electricItem {
    public shaver(voltage v) {
        super(v);
    }
}