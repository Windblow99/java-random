package design.methods.singleton;

public class singletonEx {
    public static void main(String[] args) {
        student a = student.getInstance();
        student b = student.getInstance();
        student c = student.getInstance();
        
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
    }
}

class student{
    private static student s;
    private student(){}   
    
    public static student getInstance(){
        if (s == null){
            s = new student();
        }
        return s;
    }
}