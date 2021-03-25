package blockchain.hash.code;

//Hashing algorithm:

import java.security.MessageDigest;
import java.util.Base64;

    //Algorithms: MD5, SHA family
    //Technical aspect in working up hashing functions
        //with MD5 or SHA family
        //SecureRandom class in order to generate salt value

    //Hashing is always used in password to store the hash of password in data storage.
    //Demo walkthrough of using hashing function with specified algorithm.
        //generate the salt value using securerandom class
        //Example: Password storage method - salt value
            //1) Prepend the salt to the password value
            //2) Append the salt to the password value
        //E.g. 1) Password: "123"; Salt: "8ua8sduas8ud"
                //What has to be hashed? "8ua8sduas8ud". then hash
            //2) Password: "123"; Salt: "8ua8sduas8ud"
                //What has to be hashed? "1238ua8sduas8ud". then hash

    //explain a project sample (password hashing)

public class HashingDemo extends Object { //no need to declare object, already implicitly included in Java
    //Algorithm
    private final String ALGO = "SHA-512";
    
    //MessageDigest
    private MessageDigest md;
    
    public HashingDemo(){
        try{
            md = MessageDigest.getInstance(ALGO);
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    public String hash(String input){
        //computing the hash value
        byte[] inputBytes = input.getBytes();

        //All security operations work in byte[] resulting in the need of
        //conversion byte[]->String or String->byte[]
        
        //add salt
        md.update(SaltGenerator.genSalt());
        
        //digest it(input byte)
        byte[] hashBytes = md.digest(inputBytes);
        
        //Check the output being generated by MD
        //System.out.println(Base64.getEncoder().encodeToString(hashBytes));
        
        //convert to hex
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<hashBytes.length; i++){
            sb.append(Integer.toHexString(0xFF & hashBytes[i]));
        }
        
        //lets see the hex output
        //System.out.println(sb.toString());
        return sb.toString();
    }
    
    public static void main(String[] args) {
        HashingDemo demo = new HashingDemo();
        String input = "password";
        String hashValue = demo.hash("password");
        System.out.println("Input: " + input);
        System.out.println("HashValue: " + hashValue);
    }
}
