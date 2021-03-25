package blockchain.asymmetrickey;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Demo {
    //A pair of keys: Public and private key
    //Operation: Encryption and decryption
        //Algorithm: RSA
    //Cipher for supporting the operations
    
    //Task:
        //1) Generate and store the keys
        //2) Prepare encrypt/decrypt methods
        //3) Demo
    
    public static void main(String[] args) throws Exception {
        //genkeypair();
        AsymmetricCrypto crypto = new AsymmetricCrypto();
        String data = "Hello sir! Thank you for your explanation! UwU";
        
        String encrypted = crypto.encrypt(data, getPublicKey(AppConfig.PUBLICKEY_FILE));
        System.out.println("CipherText: " + encrypted);
        Thread.sleep(2000);
        
        System.out.println("\nRecovered data: " + 
                crypto.decrypt(encrypted, getPrivateKey(AppConfig.PRIVATEKEY_FILE)));
    }
    
    private static void genkeypair() {
        KeyMaker.mkKeypair();
    }
    
    //access publickey
    private static PublicKey getPublicKey(String path) throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(path));
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance(AppConfig.ALGORITHM).generatePublic(spec);
    }
    
    //access privatekey
    private static PrivateKey getPrivateKey(String path) throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(path));
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance(AppConfig.ALGORITHM).generatePrivate(spec);
    }
}
