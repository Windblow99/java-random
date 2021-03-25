package asymmetric;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;

public class asymmetricCrypto {
    private Cipher cipher;
    
    public asymmetricCrypto() throws Exception {
        this.cipher = Cipher.getInstance(keyStoreConfig.ALGORITHM);
    }
    
    //encrypt
    public String encrypt(String data, PublicKey key) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherBytes = cipher.doFinal(data.getBytes()); //encrypted text
        return Base64.getEncoder().encodeToString(cipherBytes);
    }
    
    //decrypt
    public String decrypt(String cipherText, PrivateKey key) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
        byte[] originalBytes = cipher.doFinal(cipherBytes);
        return new String(originalBytes);
    }
}
