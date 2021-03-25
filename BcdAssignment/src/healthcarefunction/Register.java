package healthcarefunction;

import java.util.Base64;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import utility.*;

public class Register {
    
    private static final String ALGO = "SHA-256";
    private static final String FILE = "secret.txt";
    private static final String FILE_LOGIN = "login.txt";
    
    public static void persist( String username, String passwd, String role, String name){
        
        String uuid = UUID.randomUUID().toString();
        //System.out.println( uuid );
        
         try {
            String rand = Base64.getEncoder().encodeToString( Random.getSecureRand() );
            String hash = Hasher.hashPassword( Text.prepend(rand, passwd), ALGO);
         
            //FORMAT: UUID | SALT | PASSWORDHASH
            FileIO.write(FILE, String.join("|", uuid, rand, hash));
            //FORMAT: USERNAME | UUID | ROLE
            FileIO.write(FILE_LOGIN, String.join("|", username, uuid, role, name));
            //System.out.println( "rand: " + rand );
            //System.out.println( "Password Hash: " + hash );
            
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
    public static boolean register(String username, String password,  String rePassword, String role, String name){
                     
        //validation
        if (username.equals("") || password.equals("") || rePassword.equals("")) {
            JOptionPane.showMessageDialog(null, "the fields cannot be empty.");
            return false;
        }
        
        //check username
        List<String> userLst = FileIO.read("login.txt");
        for(String user : userLst){
            String[] usn = user.split("\\|");
            if (usn[0].equals(username)) {
                JOptionPane.showMessageDialog(null, "The username is taken. Please choose another one.");
                return false;
            }
        }
        
        //validation
        if (!password.equals(rePassword)) {
            JOptionPane.showMessageDialog(null, "password does not match.");
            return false;
        }
        

        Register.persist(username,password, role, name);
        JOptionPane.showMessageDialog(null, "Register successfully.");
        return true;
    }
}
