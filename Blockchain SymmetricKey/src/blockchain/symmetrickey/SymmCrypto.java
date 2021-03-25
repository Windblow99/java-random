package blockchain.symmetrickey;

import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SymmCrypto {
    //mysecret
    private static final String SECRET = "Let's fuck!";
    private static final String ALGORITHM = "AES";
    private Key key;
    
    //getter
    public Key  getKey() {
        return key;
    }
    
    public SymmCrypto() {
        key = genKey();
    }
    
    //helper - genkey
    private static Key genKey() {
        SecretKeySpec spec = new SecretKeySpec(
                Arrays.copyOf(SECRET.getBytes(), 16),
                ALGORITHM
        );
        return spec;
    }
    
    //Operation
    public String encrypt(String data) throws Exception {
        //Cipher
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        //init
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //encrypt
        byte[] cipherBytes = cipher.doFinal(data.getBytes());
        //convert to string
        return Base64.getEncoder().encodeToString(cipherBytes);
    }
    
    public String decrypt(String cipherText) throws Exception {
        //Cipher
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        //init
        cipher.init(Cipher.DECRYPT_MODE, key);
        //decrypt
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decryptedBytes);
    }
}
