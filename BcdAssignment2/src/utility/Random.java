
package utility;

import java.security.SecureRandom;


public class Random {
    
    private static final int size = 16;
        
    public static byte[] getSecureRand() throws Exception {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] bytes = new byte[size];
        sr.nextBytes(bytes);
        return bytes;
    }
}
