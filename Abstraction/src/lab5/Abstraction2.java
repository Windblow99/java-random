package lab5;

public class Abstraction2 {
    
    public static void main(String[] args) {       
        //cannot instantiate object for abstract class
        Shape shape = new Circle();
        shape.draw();
        shape = new Triangle();
        shape.draw();
    }
}
//ABSTRACTION IMPL
//Class family - "extends" = "is-a-kind-of"
//Another class family

class User{}
class Lecturer extends User{}
class Student extends User implements Disposable{
    
    @Override
    public void dispose(){}
}

interface Disposable{
    abstract void dispose();
}

abstract class Shape{

    //WHAT OPERATION? - draw
    abstract void draw();

    void overrideMe(){}
} //General class

class Circle extends Shape implements Disposable{ //Specific
    
        //@override
        void aMethod(){}
        
        //@override is optional
        void overrideMe(){
            
        }

        @Override
        void draw() {
            System.out.println("Drawing a circle...");
        }
        
        @Override
        public void dispose(){}
    } //Specific class

class Rectangle extends Shape{

        @Override
        void draw() {
            System.out.println("Drawing a rectangle...");
        }
    }

class Triangle extends Shape{

        @Override
        void draw() {
            System.out.println("Drawing a triangle...");
        }
}