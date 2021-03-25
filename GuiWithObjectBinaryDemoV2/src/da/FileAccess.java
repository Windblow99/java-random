/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lecturer
 */
public class FileAccess extends FileReader implements Updatable {

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
        //id=180585664
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

}
