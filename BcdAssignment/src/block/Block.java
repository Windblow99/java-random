package block;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import utility.*;

public class Block implements Serializable {
    private final String hash;
    private String previousHash;
    private final String patientData;
    private long timestamp;
    private String uuid;
    
    //constructor
    public Block (String previousHash, String patientData) throws Exception {
        this.patientData = patientData;
        this.previousHash = previousHash;
        this.timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        this.uuid = Session.getUuid();
        
        byte[] blkBytes = getBlockBytes(this);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(blkBytes);
        baos.write(previousHash.getBytes());
        baos.write(Long.toString(timestamp).getBytes());
        
        this.hash = Hasher.hashBlock(baos.toByteArray(), "SHA-256");
    }
    
    //convert the object to byte[] so that BlockHasher.hash(byte[], algorithm)
    private static byte[] getBlockBytes(Block blk){
        //ByteArrayOutputStream and ObjectOutputStream from io package        
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(baos)){
            out.writeObject(blk);
            return baos.toByteArray();
        } catch (Exception e) {
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
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    //@toString
    @Override
    public String toString() {
        return hash + "," + previousHash + "," + patientData + "," + timestamp + "," + uuid;
    }
}
