package block;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import com.google.gson.*;

public class Blockchain {
    private final String BCHAIN_FILE = "masterChain.dat";
    private LinkedList<Block> db = new LinkedList<>();
    
    //setter
    public void setDb(LinkedList<Block> db) {
       this.db = db;
    }
    
    //store chain into a data file
    public void persist() {
        try(FileOutputStream fos = new FileOutputStream(BCHAIN_FILE);
                ObjectOutputStream out = new ObjectOutputStream(fos); 
                ) {
            out.writeObject(db);
        } catch (IOException e) {
        }
    }
    
    //retrive the whole chain
    public LinkedList<Block>get() {
        try(FileInputStream fis = new FileInputStream(BCHAIN_FILE);
                ObjectInputStream in = new ObjectInputStream(fis);
                ) {
            return (LinkedList<Block>)in.readObject();
        } catch (Exception e) {
            return null;
        }
    }
    
    //chain pretty printing
    public void distribute() throws IOException {
        String chain = new GsonBuilder().setPrettyPrinting().create().toJson(db);
        Files.write(Paths.get("chain.txt"), chain.getBytes(), StandardOpenOption.CREATE);
    }
    
    //add block into chain
    public void nextBlock(Block newBlock) {
        db.add(newBlock);
    }
}
