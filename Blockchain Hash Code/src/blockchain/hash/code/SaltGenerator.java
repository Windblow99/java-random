package blockchain.hash.code;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class SaltGenerator {
    private static final int SIZE = 128;
    //generating the salt value
    
    public static byte[] genSalt() {
        try{
            //int salt = new Random().nextInt();
            byte[] bytes = new byte[SIZE];
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.nextBytes(bytes);
            return bytes;
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
        
    }
    
    public static void main(String[] args) throws Exception{
        String salt = Base64.getEncoder().encodeToString(SaltGenerator.genSalt());
        System.out.println(salt);
    }
}
