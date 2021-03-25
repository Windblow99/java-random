package fileexampletutorial2;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class FileExampleTutorial2 {


    public static void main(String[] args) {

        File f = new File("Employee.txt");
        System.out.println(f.exists());
        try
        {
            FileWriter fw = new FileWriter(f,true);
            FileReader fr = new FileReader(f);
            /*
            //true option is to update the file and add new stuff
            FileWriter fw = new FileWriter(f,true);
            fw.write(" JACK AND JILL FUCKED UP THE HILL/n");
            fw.close();
            System.out.println("Executed Successfully.");
            */
            int i = fr.read();
            while (i!=-1)
            {
                System.out.println((char)i);
                i=fr.read();
            }
            System.out.println();
            System.out.println("Print executed successfully.");
        }
        catch(IOException Ex)
        {
            
        }
            
        
    }
    
}
