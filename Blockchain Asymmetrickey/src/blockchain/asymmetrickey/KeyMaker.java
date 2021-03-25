package blockchain.asymmetrickey;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyMaker {
    private KeyPairGenerator keygen;
    private KeyPair keypair;
    private final int keysize = 1024;
    
    public KeyMaker() throws Exception {
        this.keygen = KeyPairGenerator.getInstance(AppConfig.ALGORITHM);
        this.keygen.initialize(keysize);
    }
    
    public static void mkKeypair() {
        try {
            //generate keypair
            KeyMaker km = new KeyMaker();
            km.keypair = km.keygen.generateKeyPair();
            
            //publickey
            PublicKey pukey = km.keypair.getPublic();
            
            //privatekey
            PrivateKey pvkey = km.keypair.getPrivate();
            
            //show keys
            //System.out.println(pukey.getEncoded().toString());
            
            //store keypair
            store(AppConfig.PUBLICKEY_FILE, pukey.getEncoded());
            store(AppConfig.PRIVATEKEY_FILE, pvkey.getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //mkKeypair()
    
    //store keypair
    private static void store(String path, byte[]key) {
        File file = new File(path);
        file.getParentFile().mkdirs();
        try {
            Files.write(Paths.get(path), key, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
