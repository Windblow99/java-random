package design.methods.lecture.pkg6;

import java.util.LinkedList;

public class Observer {
    public static void main(String[] args) {
        observer pie = new piechart();
        observer bar = new barchart();
        
        subject d = new data();
        
        d.addObserver(bar);
        d.addObserver(pie);
        
        d.updateData();
    }
}

interface observer {
    public void update();
}

abstract class subject {
    LinkedList<observer> observers = new LinkedList<observer>();
    
    public void addObserver(observer o) {
        observers.add(o);
    }
    
    abstract public void updateData();
    abstract public void updateObservers();
}

class data extends subject {
    public void updateData() {
        System.out.println("Data is being updated");       
        //update update observers
        updateObservers();
    }
    
    public void updateObservers() {
        for(observer o: observers) {
            o.update();
        }
    }
}

class piechart implements observer {
    public void update() {
        System.out.println("... updating the pie chart");
    }
}

class barchart implements observer {
    public void update() {
        System.out.println("... updating the bar chart");
    }
}