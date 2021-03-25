package asymmetric;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class getKey {
    public static void genkeypair() {
        keyGen.mkKeypair();
    }
    
    //access publickey
    public static PublicKey getPublicKey(String path) throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(path));
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance(keyStoreConfig.ALGORITHM).generatePublic(spec);
    }
    
    //access privatekey
    public static PrivateKey getPrivateKey(String path) throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(path));
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance(keyStoreConfig.ALGORITHM).generatePrivate(spec);
    }
}
