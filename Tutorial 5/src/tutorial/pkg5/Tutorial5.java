package tutorial.pkg5;

import java.util.ArrayList;

public class Tutorial5 {
    public static void main(String[] args){
        Car myCar = new Car(); //objects created
        ArrayList<BabySeater> baby_seat = new ArrayList();
        baby_seat.add(new BabySeater());
        baby_seat.add(new BabySeater());
        
        myCar.setBabySeater(baby_seat);
        
        //burn the car
        myCar = null; //Where is the babyseat object?
        
        //new car
        Car yourcar = new Car();
        yourcar.setBabySeater(baby_seat);
    }
}

class Owner{
    vehicle v;//relationship
    String name; //data
}
class vehicle{
    Owner o;//relationship
    long regNo; //data
}

class Motorbike extends vehicle{}

class Car extends vehicle{
    //composition
    Engine engine;
    Wheel[] wheel = new Wheel[4]; //mulitplicity, predefined user array
    public Car(){
        engine = new Engine();
        wheel[0] = new Wheel();
        wheel[1] = new Wheel();
        wheel[2] = new Wheel();
        wheel[3] = new Wheel();
    }
    
    //aggregation
    ArrayList<BabySeater> seater;
    public void setBabySeater(ArrayList<BabySeater> seat){
        seater = seat;
    }
}

class Truck extends vehicle{}
class Engine{}
class Wheel{}
class BabySeater{}