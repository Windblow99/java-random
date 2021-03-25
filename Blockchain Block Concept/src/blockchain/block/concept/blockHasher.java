package blockchain.block.concept;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class blockHasher {
    private static final int SIZE = 128;
    //generating the salt value
    
    public static String hash(byte[] obj, String algo) throws Exception {
        //create message digest instance for algorithm
        MessageDigest md = MessageDigest.getInstance(algo);
        //add the input to the md
        md.update(obj);
        //generate the hash
        byte[] hashcode = md.digest();
        //Convert the hashcode into hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < hashcode.length; i++){
            sb.append(
                Integer.toHexString(0xFF & hashcode[i])
            );
        }
        return sb.toString();
    }
}
