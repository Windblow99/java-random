package utility;

import java.security.MessageDigest;

public class Hasher {
    
    //password hash
    public static String hashPassword( String passwd, String algo ) throws Exception{
        //create message digest instance for algorithm
        MessageDigest md = MessageDigest.getInstance( algo ); 
        //add the input to the md
        md.update( passwd.getBytes() );
        //generate the hash
        byte[] hashcode = md.digest();
        //convert the hashcode into hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashcode.length; i++) {
            sb.append( 
                    Integer.toHexString(0xFF & hashcode[i])
            );
        }
        //System.out.println( "Hashcode: " + sb.toString() );
        return sb.toString();
    }
    
    
    //block hash
    public static String hashBlock(byte[] obj, String algo) throws Exception {
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
