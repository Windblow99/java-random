package lecture.polymorphism.pkgabstract;

public class LecturePolymorphismAbstract {
    
    public static void main(String[] args) {
        Shape s = new Circle();
    }
}
//abstract class
abstract class Shape{
    //normal methods - can be overridden by child class
    public abstract double getArea(); //incomplete operation
}

class Rectangle extends Shape{

    @Override
    public double getArea() {
        //inject formula for area of rectangle
        return 0.0;
    }
    
}

class Circle extends Shape{

    @Override
    public double getArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
