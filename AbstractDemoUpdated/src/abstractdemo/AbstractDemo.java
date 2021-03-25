package abstractdemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AbstractDemo {

    public static void main(String[] args) {

        TextAccess da = new TextAccess();
        da.setFileName("abc.txt");
        //write(da);
        //read(da);
        update(da, "-763262153", "michael|sripetaling|mic123321|mic2222");
    }

    //Test update the record
    static void update(DataObject da, String id, String record) {
        TextAccess txt = (TextAccess) da;
        txt.update(id, record);
    }

    //Test to read data
    static void read(DataObject da) { //DataObject da is polymorphism object
        ArrayList<String> data = da.readAll();
        if (data != null) {
            for (String record : data) {
                String[] split = record.split("\\|");
                //Stream.of(split).forEach(System.out::println);
                for (int i = 0; i < split.length; i++) {
                    System.out.println(split[i]);
                }
            }
        } else {
            System.out.println("No file content!");
        }
    }

    //Test to write data
    static void write(DataObject da) { //DataObject da is polymorphism object
        //ID|NAME|ADDR|USR|PWD
        //String.join()
        String id = new Integer(new Random().nextInt()).toString();
        String name = "johnson";
        String addr = "BukitJalil";
        String username = "johnnamejalil123";
        String password = "johnsonpasswd";

        String record = String.join("|", id, name, addr, username, password);
//        
        System.out.println(da.write(record));
        //System.out.println( da.write("101|NONAME|MYADDR|MYUSR|MYPWD") );

    }

}
//First: Data model
//Model: ID|NAME|ADDR|USR|PWD

abstract class DataObject {

    protected File filename;

    public void setFileName(String fn) {
        this.filename = new File(fn);
    }

    public abstract ArrayList<String> readAll();

    public abstract boolean write(String record);
}

//need to use this interface type in assignment, call out the main interface class using overriding method
//then call the functions in the other classes
interface Updatable {

    //public abstract
    public boolean update(String id, String newLine);
    public boolean delete(String id);
}
//========== UPDATE TO TEXTACCESS CLASS ==========
//Texfile API

class TextAccess extends DataObject implements Updatable {

    //Polymorphism:: Method overriding
    @Override
    public ArrayList<String> readAll() {
        ArrayList<String> list = new ArrayList();
        //Scanner/BufferedReader
        try (Scanner scan = new Scanner(this.filename)) {
            //reading
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                //populate it into list object
                list.add(line);
            }
        } catch (IOException ex) {
            //any exception/error happen
            ex.printStackTrace();
        }
        return list;
    }

    //Polymophism: Method overriding
    @Override
    public boolean write(String record) {
        //PrintWriter
        try (PrintWriter out = new PrintWriter(new FileWriter(this.filename, true))) {
            out.println(record);//write to file
            //if 'write' is succeeded
            return true;
        } catch (IOException ex) {
            //any exception/error
            System.out.println("Error: Failed to write.");
            return false;
        }
    }

    @Override
    public boolean update(String id, String newLine) {
        //id=-763262153 (This is taken from the line declared above)
        //newLine=michael|sripetaling|mic123321|mic2222

        //update the content
        ArrayList<String> old_list = this.readAll();//existing content
        ArrayList<String> new_list = new ArrayList();
        //iterate each element in old_list
        for (String oldLine : old_list) {
            //-324171238|johnson|BukitJalil|johnnamejalil123|johnsonpasswd
            //do search for id
            String[] split = oldLine.split("\\|");
            if (split[0].equals(id)) {
                //add the line to new_list
                String newRecordLine = String.join("|", id, newLine);
                new_list.add(newRecordLine);
            } else {
                new_list.add(oldLine);
            }
        }
        //write the new_list element to the file
        if(new_list.size() > 0){
            try(PrintWriter out = new PrintWriter(new FileWriter(filename))) {
                for (String line : new_list) {
                    out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean delete(String id) {
        ArrayList<String> old_list = this.readAll();//existing content
        
        for (String oldLine : old_list) {
            String[] split = oldLine.split("\\|");
            if (split[0].equals(id)) {
                
            } else {
                return false;
            }
        }
        return true;
    }  

}
//Binaryfile API

class BinaryAccess extends DataObject implements Updatable {

    @Override
    public ArrayList<String> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean write(String record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(String id, String newLine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        ArrayList<String> old_list = this.readAll();//existing content
        
        for (String oldLine : old_list) {
            String[] split = oldLine.split("\\|");
            if (split[0].equals(id)) {
                
            } else {
                return false;
            }
        }
        return true;
    } 
}
//ObjectBinary API

class ObjectAccess extends DataObject {

    @Override
    public ArrayList<String> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean write(String record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
