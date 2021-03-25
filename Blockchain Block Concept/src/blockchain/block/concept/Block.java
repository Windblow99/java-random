package blockchain.block.concept;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;

public class Block implements Serializable {
    //Block Concept
    //Block consists of data properties and connect to the previous block
        //form a blockchain
    //Data properties include hash, previousHashm dataStructure, timeStamp. etc.
    //Blocks are connected in chronological order to form a blockchain
        //connection is performed by reference to the previous block
    //Demo: Block class with all possible properties, 
        //hash the block object, connect blocks using previousHash to form a blockchain
    
    private String hash;
    private String previousHash;
    private String data; //to be improved later on
    private long timestamp;
    
    //constructor
    public Block (String previousHash, String data) throws Exception {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        //generate the current blockhash
        //IDEA: To complicate the hash output by combining data + preHash + timestamp + blockbytes
        byte[] blkBytes = getBlockBytes(this);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(blkBytes);
        baos.write(data.getBytes());
        baos.write(previousHash.getBytes());
        baos.write(Long.toString(timestamp).getBytes());
        
        this.hash = blockHasher.hash(baos.toByteArray(), "SHA-256");
    }
    
    //convert the object to byte[] so that BlockHasher.hash(byte[], algorithm)
    private static byte[] getBlockBytes(Block blk){
        //ByteArrayOutputStream and ObjectOutputStream from io package        
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(baos)){
            out.writeObject(blk);
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //getset methods
    public String getHash() {
        return hash;
    }
    
    public String getPreviousHash() {
        return previousHash;
    }
    
    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    //@toString
    @Override
    public String toString() {
        return "Block{" + "hash=" + hash + ", timestamp=" + timestamp + '}';
    }
}
