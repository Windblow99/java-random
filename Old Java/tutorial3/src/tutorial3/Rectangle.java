package tutorial3;

public class Rectangle {
    double height,width;
    String color;
    
    public Rectangle(){}
    
    public Rectangle(double height, double width, String color){}

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public double findArea(){
        return width * height;
    }
    
    public double findPerimeter(){
        return (width * 2) + (height * 2);
    }
}
