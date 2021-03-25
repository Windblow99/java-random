package fileexampletutorial21;

    import java.io.*;
    import java.util.*;
    import java.util.Scanner;

public class FileExampleTutorial21 {
    
    public static void main(String[] args) {
        File f = new File("Buffer.txt");
        Employee Lee = new Employee("TP00000","Eren",500);
        Employee Foo = new Employee("TP00001","IDK",300);
        try{
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            /*bw.write("Suck my big dick");
            bw.newLine();
            bw.write("Nice oral");
            bw.newLine();
            bw.write("No condoms");*/
            bw.write(Lee.WriteData());
            bw.newLine();
            bw.write(Foo.WriteData());
            bw.close(); //Not necessarily needed, bw will still close the file automatically
            System.out.println("Data Executed Successfully");
        }
        catch(IOException ex)
        {
            
        }
        
        /*
        //Exercise
        Scanner Sc = new Scanner(System.in);
        
        File f = new File("Personal.txt");
        try{
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Enter your name");
            String name = Sc.nextLine();
            bw.write("Name: " + name);
            bw.newLine();
            
            System.out.println("Enter your address");
            String address = Sc.nextLine();
            bw.write("Address: " + address);
            bw.newLine();
            
            System.out.println("Enter your age");
            int age = Sc.nextInt();
            bw.write("Age: " + age);
            bw.close(); //Not necessarily needed, bw will still close the file automatically
            System.out.println("Data Executed Successfully");
        }
        catch(IOException ex)
        {
            
        }
        */
               
    }
    
    
}
