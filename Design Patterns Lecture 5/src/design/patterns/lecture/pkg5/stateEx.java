package design.patterns.lecture.pkg5;

import java.util.LinkedList;
import java.util.Scanner;

public class stateEx {
    public static void main(String[] args) {
        TV tv = new TV(new OFF());
        observer m = new manager();
        observer w = new worker();
        
        tv.addObserver(w);
        tv.addObserver(w);
        tv.addObserver(w);
        tv.addObserver(m);
        
        remote r = new remote(tv);
        
        Scanner in = new Scanner(System.in);
        
        while (true) {
            in.nextLine();
            r.redButton();
        }
    }
}

interface state {
    public void onOFF(TV tv);
}

class ON implements state {
    
    @Override
    public void onOFF(TV tv) {
        System.out.println("ON State: Switiching the TV off");
        tv.setS(new OFF());
    }
}

class OFF implements state {
    
    @Override
    public void onOFF(TV tv) {
        System.out.println("OFF State: Switching the TV on");
        tv.setS(new ON());
    }
}

class TV extends subject {
    state s;
    
    public void setS(state s) {
        this.s = s;
    }
    
    public TV(state s) {
        this.s = s;
    }
    
    public void power() {
        s.onOFF(this);
        updateObservers();
    }
    
    public void updateObservers() {
        for(observer o: observers) {
            o.update(s);
        }
    }
}

class remote {
    TV tv;
    
    public remote(TV tv) {
        this.tv = tv;
    }
    
    public void redButton() {
        tv.power();
    }
}

interface observer {
    public void update(state s);
}

class manager implements observer {
    public void update(state s) {
        System.out.println("Manager has been updated that the TV has been switched " + s.getClass().getSimpleName());
    }
}

class worker implements observer {
    public void update(state s) {
        System.out.println("Worker has been updated that the TV has been switched " + s.getClass().getSimpleName());
    }
}

abstract class subject {
    LinkedList<observer> observers = new LinkedList<>();
    
    public void addObserver(observer o) {
        observers.add(o);
    }
    
    abstract public void updateObservers();
}