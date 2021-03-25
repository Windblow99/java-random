package asymmetric;

import java.util.List;
import utility.FileIO;

public class keyStoreConfig {
    //location path for keypair
    public static String PUBLICKEY_FILE;
    public static String PRIVATEKEY_FILE;
    List<String> patientLst = FileIO.read("login.txt");
    String[] data = medical.split("\\|");    
        for(String medical : patientLst){
            String[] data = medical.split("\\|");
            if (data[3].equals(name)) {
                uuid.setText(data[1]);
            }
        }
    public static void main(String[] args) {
        for(String medical : patientLst){
            if (data[3].equals("5f07828c-5780-4ba8-86a1-ce357d2c2c2d")) {
                PUBLICKEY_FILE = "Keypair/MedicalPublicKey";
                PRIVATEKEY_FILE = "Keypair/MedicalPrivateKey";
                System.out.println("read medical key");
            } else if (uuid.equals("")) {
                PUBLICKEY_FILE = "Keypair/MedicalPublicKey";
                PRIVATEKEY_FILE = "Keypair/MedicalPrivateKey";
                System.out.println("read medical key");
            }
        }
        
    }   
    
    //algorithm
    public static final String ALGORITHM = "RSA";
}
