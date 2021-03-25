package block;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import utility.*;

public class Block implements Serializable {
    private String hash;
    private String previousHash;
    private String data;
    private String data2;
    private long timestamp;
    private String senderUUID;
    private String receiverUUID;
    private String digitalSignature;
    
    //constructor
    public Block (String previousHash, String data1, String data2, String senderUUID, String receiverUUID, String digitalSignature) throws Exception {
        this.data = data1;
        this.data2 = data2;
        this.previousHash = previousHash;
        this.timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        this.senderUUID = senderUUID;
        this.receiverUUID = receiverUUID;
        byte[] blkBytes = getBlockBytes(this);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(blkBytes);
        baos.write(data.getBytes());
        baos.write(data2.getBytes());
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
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String getData2() {
        return data2;
    }
    
    public void setData2(String data2) {
        this.data2 = data2;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSenderUUID() {
        return senderUUID;
    }

    public void setSenderUUID(String senderUUID) {
        this.senderUUID = senderUUID;
    }

    public String getReceiverUUID() {
        return receiverUUID;
    }

    public void setReceiverUUID(String receiverUUID) {
        this.receiverUUID = receiverUUID;
    }

    public String getDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature = digitalSignature;
    }
    
    
    //@toString
    @Override
    public String toString() {
        return hash + "," + timestamp + "," + data + "," + data2 + "," + previousHash + "," + senderUUID + "," + receiverUUID + "," + digitalSignature;
    }
}
