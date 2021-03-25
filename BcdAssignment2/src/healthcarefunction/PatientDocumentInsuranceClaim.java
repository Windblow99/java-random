package healthcarefunction;

import java.security.*;
import java.util.Base64;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utility.FileIO;
import utility.Session;



public class PatientDocumentInsuranceClaim {
    private Signature signature;
    private KeyPairGenerator keygen;
    private KeyPair keyPair;
    
    //constructor
    public PatientDocumentInsuranceClaim() {
        try {
            signature = Signature.getInstance("SHA256WithRSA");
            keygen = KeyPairGenerator.getInstance("RSA");
            keyPair = keygen.generateKeyPair();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //sign
    public String sign(String data) throws Exception{
        signature.initSign(keyPair.getPrivate());
        signature.update(data.getBytes());
        return Base64.getEncoder().encodeToString(signature.sign());
    }
    
    //verify
    public boolean verify(String data, String ds) throws Exception{
        signature.initVerify(keyPair.getPublic());
        signature.update(data.getBytes());
        return signature.verify(Base64.getDecoder().decode(ds));
    }
    
    
    //read from the chain, filter patient only
    public void getPatientLst(JList jlist){
        List<String> patientLst = FileIO.read("login.txt");
        DefaultListModel listModel = new DefaultListModel();
        
        for(String patient : patientLst){
            String[] data = patient.split("\\|");
            if (data[2].equals("patient")) {
                listModel.addElement(data[3]);
            }
        }
        jlist.setModel(listModel);
    }
    
    public void getReceiverLst(JList jlist){
        List<String> patientLst = FileIO.read("login.txt");
        DefaultListModel listModel = new DefaultListModel();

        for(String patient : patientLst){
            String[] data = patient.split("\\|");

            switch(Session.getRole()){
                case "healthcare personnel":
                    if (data[2].equals("patient")) {
                        listModel.addElement(data[3]);
                    }
                    break;

                case "patient":
                    if (data[2].equals("insurance company")) {
                        listModel.addElement(data[3]);
                    }
                    break;
            }
        }
        jlist.setModel(listModel);
    }
    
    
    //chain.getLast().getHash(), data1, data2,"","",""
    public void sendFromHospitalToPatient(String data, String senderUUID, String receiverUUID) throws Exception{
        PatientDocumentInsuranceClaim tool = new PatientDocumentInsuranceClaim();
        String ds = tool.sign(data);
        //put ds on blockchain, specify sender, receiver
        //...
    }
    
    public void sendFromPatientToInsuranceCompany(String senderUUID, String receiverUUID){
        //take from blockchain, if there is thing meant for this recipient.
    }
    
    public void verifyByInsuranceCompany(String data, String ds)throws Exception{
        //take from blockchain, if there is thing meant for this recipient.
            //...
            
        //verify, take the ds from blockchain.
        PatientDocumentInsuranceClaim tool = new PatientDocumentInsuranceClaim();
        boolean isValid = tool.verify(data, ds);
    }
}
