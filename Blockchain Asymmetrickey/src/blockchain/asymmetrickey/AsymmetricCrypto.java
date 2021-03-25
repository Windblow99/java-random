package blockchain.asymmetrickey;

import java.security.PublicKey;
import java.security.PrivateKey;
import java.util.Base64;
import javax.crypto.Cipher;

public class AsymmetricCrypto {
    //Question: Besides keypair, what do we need to perform encryption/decryption?
        //Cipher instance
    private Cipher cipher;
    
    public AsymmetricCrypto() throws Exception {
        this.cipher = Cipher.getInstance(AppConfig.ALGORITHM);
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
