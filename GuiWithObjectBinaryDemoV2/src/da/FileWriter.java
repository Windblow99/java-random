/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lecturer
 */
public class FileWriter extends FileReader {

  //API
    //Binary data
    //InputStream/OutputStream
    //Object Binary
    //ObjectInputStream/ObjectOutputStream
   @Override
    public ArrayList<String> readAll() {
        ArrayList<String> data = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.filename))) {
            data = (ArrayList<String>) in.readObject();//read ArrayList object
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return data;
        }
    }
    @Override
    public boolean write(String record) {
        boolean success = false;
        //File f = new File(this.filename);
        File f = this.filename;
        ArrayList<String> data = null;
        if (f.exists()) {
            data = this.readAll();
        } else {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileBinary.class.getName()).log(Level.SEVERE, null, ex);
            }
            data = new ArrayList();
        }
        if (data != null) {
            data.add(record);
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.filename))) {
                out.writeObject(data);
                success = true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                return success;
            }
        } else {
            return success;
        }
    }
    
    //Overloaded method
    public boolean write(ArrayList<String> data) {
        boolean success = false;
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(this.filename))){
            out.writeObject(data);
            success = true;
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            return success;
        }
    }
    
    //Testing
    public static void main(String[] args){
        FileWriter oa = new FileWriter();
        oa.setFileName("user.dat");

        //oa.write("101|ali|mali|123321");
        
        //Read
        ArrayList<String> content = oa.readAll();
        System.out.println( content );
    }
}
