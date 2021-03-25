package healthcarefunction;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import utility.FileIO;
import utility.Session;

public class PatientEncryptFunction {
    public void getMedicalList(JList jlist){
        List<String> patientLst = FileIO.read("login.txt");
        DefaultListModel listModel = new DefaultListModel();
        
        for(String patient : patientLst){
            String[] data = patient.split("\\|");
            
            if (data[2].equals("healthcare personnel")) {
                listModel.addElement(data[3]);
            }
        }
        jlist.setModel(listModel);
    }
    
    public void getMedicalUUID(String name, JTextField uuid){
        List<String> receiverList = FileIO.read("login.txt");
        
        for(String receiver : receiverList){
            String[] data = receiver.split("\\|");
            if (data[3].equals(name)) {
                uuid.setText(data[1]);
            }
        }
    }
    
    public static void decrypt(String data, JTextArea decrypted) throws Exception {
        asymmetric.asymmetricCrypto crypto = new asymmetric.asymmetricCrypto();            
        String uuid = Session.getUuid();
            
        if(uuid.equals("49995b79-42e1-4503-8b5d-6befdb6a6c83")){
            decrypted.setText(crypto.decrypt(data, asymmetric.getKey.getPrivateKey("Keypair/MedicalPrivateKey")));
        } else if(uuid.equals("another one")) {
            decrypted.setText(crypto.decrypt(data, asymmetric.getKey.getPrivateKey("Keypair/MedicalPrivateKey2")));
        } 
    }
    
    public static void encrypt(String data, String receiverUUID, JTextField encrypted) throws Exception {
        asymmetric.asymmetricCrypto crypto = new asymmetric.asymmetricCrypto();
        
        if(receiverUUID.equals("49995b79-42e1-4503-8b5d-6befdb6a6c83")){
            String encryptedText = crypto.encrypt(data, asymmetric.getKey.getPublicKey("Keypair/MedicalPublicKey"));           
            encrypted.setText(encryptedText);
        } else if(receiverUUID.equals("another one")) {
            String encryptedText = crypto.encrypt(data, asymmetric.getKey.getPublicKey("Keypair/MedicalPublicKey2"));           
            encrypted.setText(encryptedText);
        }       
    }
}
