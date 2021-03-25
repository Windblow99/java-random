package filedemo;

import java.io.*;
import java.util.*;

public class Filedemo {
    
    public static void main(String[] args) {
        
        TextAccess da = new TextAccess();
        da.setFileName("abc.txt");
        write(da);
        read(da);
    }
    //Test to read data
    static void read(DataObject da){ //DataObject da is polymorphism object
        ArrayList<String> data = da.readAll();
        if(data != null){
            for(String record : data){
                String[] split = record.split("\\|"); //backward slash is the syntax, need to begin with it to differentiate
                //Stream.of(split).forEach(System.out::println);
                for (int i = 0; i < split.length; i++) {
                    System.out.println( split[i] );
                }
            }
        }else{
            System.out.println("No file content!");
        }
    }
    //Test to write data
    static void write(DataObject da){ //DataObject da is polymorphism object
        //ID|NAME|ADDR|USR|PWD
        //String.join()
        String id = new Integer(new Random().nextInt()).toString();
        String name = "johnson";
        String addr = "BukitJalil";
        String username = "johnnamejalil123";
        String password = "johnsonpasswd";
        
        String record = String.join("|", id, name, addr, username, password);
//        
        System.out.println( da.write( record ) );
        //System.out.println( da.write("101|NONAME|MYADDR|MYUSR|MYPWD") );
        
    }
}
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
            out.println(record);//write to file, with a breakline
            //if 'write' is succeeded
            return true;
        }catch(IOException ex){
            //any exception/error
            System.out.println("Error: Failed to write.");
            return false;
        }
    }
    
}