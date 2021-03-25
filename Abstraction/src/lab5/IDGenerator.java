package lab5;
import java.util.Random;

public class IDGenerator {
    
    public static long generate(){
        return Math.abs(new Random().nextLong() );
    }
    
    //TESTING
    public static void main(String[] args) {
        System.out.println( IDGenerator.generate() );
    }
}
