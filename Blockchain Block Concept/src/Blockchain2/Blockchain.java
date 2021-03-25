package Blockchain2;

import blockchain.block.concept.Block;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import com.google.gson.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Blockchain {
    //master/database file
    private static final String BCHAIN_FILE = "masterchain.dat";
    
    //data structure - LinkedList
    private static LinkedList<Block> db = new LinkedList<>();
    
    //addEntry
    public static void nextBlock(Block newBlock) {
        Blockchain.db.add(newBlock);
    }
    
    //method functions
    public static void persist() { //update the BCHAIN_FILE
        //write the LinkedList object to the file
        try(FileOutputStream fos = new FileOutputStream(BCHAIN_FILE);
                ObjectOutputStream out = new ObjectOutputStream(fos); 
                ) {
            out.writeObject(db);
        } catch (IOException e) {
        }
    }
    
    public static LinkedList<Block>get() {
        //read the LinkedList object from the file
        try(FileInputStream fis = new FileInputStream(BCHAIN_FILE);
                ObjectInputStream in = new ObjectInputStream(fis);
                ) {
            return (LinkedList<Block>)in.readObject();
        } catch (Exception e) {
            return null;
        }
    }
    
    public static void distribute() {
        //display and store the chain
        try {
            //display
            String chain = new GsonBuilder().setPrettyPrinting().create().toJson(db);
            System.out.println(chain);
            
            //store the chain in text readable file
            Files.write(Paths.get("ledger.txt"), chain.getBytes(), StandardOpenOption.CREATE);
            
        } catch (IOException e) {
        }
    }
}
