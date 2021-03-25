/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractdemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lecturer
 */
public class AbstractDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
//First: Data model
//Model: ID|NAME|ADDR|USR|PWD
class DataObject{
    protected File filename;
    public void setFileName(String fn){
        this.filename = new File(fn);
    }
    
    public ArrayList<String> readAll(){
        ArrayList<String> list = null;
        return list;
    }
    public boolean write(String record){
        //method body code
        return false;
    }
}
//========== UPDATE TO TEXTACCESS CLASS ==========
//Texfile API
class TextAccess extends DataObject{
    
    //Polymorphism:: Method overriding
    @Override
    public ArrayList<String> readAll(){
        ArrayList<String> list = new ArrayList();
        //Scanner/BufferedReader
        try(Scanner scan = new Scanner(this.filename)){
            //reading
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                //populate it into list object
                list.add(line);
            }
        }catch(IOException ex){
            //any exception/error happen
            ex.printStackTrace();
        }
        return list;
    }
    //Polymophism: Method overriding
    @Override
    public boolean write(String record){
        //PrintWriter
        try(PrintWriter out = new PrintWriter(new FileWriter(this.filename, true))){
            out.println(record);//write to file
            //if 'write' is succeeded
            return true;
        }catch(IOException ex){
            //any exception/error
            System.out.println("Error: Failed to write.");
            return false;
        }
    }
    
}
//Binaryfile API
class BinaryAccess extends DataObject{
    
}
//ObjectBinary API
class ObjectAccess extends DataObject{
    
}
