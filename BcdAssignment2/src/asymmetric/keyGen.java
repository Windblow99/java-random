package asymmetric;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class keyGen {
    private KeyPairGenerator keygen;
    private KeyPair keypair;
    private final int keysize = 1024;
    
    public keyGen() throws Exception {
        this.keygen = KeyPairGenerator.getInstance(keyStoreConfig.ALGORITHM);
        this.keygen.initialize(keysize);
    }
    
    public static void mkKeypair() {
        try {
            //generate keypair
            keyGen km = new keyGen();
            km.keypair = km.keygen.generateKeyPair();
            
            //publickey
            PublicKey pukey = km.keypair.getPublic();
            
            //privatekey
            PrivateKey pvkey = km.keypair.getPrivate();
            
            //show keys
            //System.out.println(pukey.getEncoded().toString());
            
            //store keypair
            store(keyStoreConfig.PUBLICKEY_FILE, pukey.getEncoded());
            store(keyStoreConfig.PRIVATEKEY_FILE, pvkey.getEncoded());
        } catch (Exception e) {}
    } //mkKeypair()
    
    //store keypair
    private static void store(String path, byte[]key) {
        File file = new File(path);
        file.getParentFile().mkdirs();
        try {
            Files.write(Paths.get(path), key, StandardOpenOption.CREATE);
        } catch (Exception e) {}
    }
}
