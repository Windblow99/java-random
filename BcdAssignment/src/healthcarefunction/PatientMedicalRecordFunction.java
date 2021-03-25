package healthcarefunction;

import block.Block;
import block.Blockchain;
import entity.Patient;
import java.io.File;
import java.util.LinkedList;
import javax.swing.JTextField;
import utility.Session;


public class PatientMedicalRecordFunction {
    
    private static LinkedList<Block> db = new LinkedList<>();
      
    //the whole process to create new medical record.
    public void addMedicalRecord(String diagnoses, String treatmentPlans, String medications, String immunizations) throws Exception{
        Blockchain bcdTool = new Blockchain();
        LinkedList<Block> chain = bcdTool.get();
        //System.out.println(chain);
        
        //store medical data into patient object
        Patient patientData = new Patient(diagnoses, treatmentPlans, medications, immunizations);
        
        //first block
        if(chain == null) {
            Block genesisBlock = new Block("0", patientData.toString()); //0 is the previous hash
            bcdTool.nextBlock(genesisBlock);
            bcdTool.persist();
            
        //second block and onwards 
        }else{
            db = chain;
            bcdTool.setDb(db);
            Block block = new Block(chain.getLast().getHash(), patientData.toString());
            bcdTool.nextBlock(block);
            bcdTool.persist(); 
        }
        
        //easy for us to check the data structure.
        bcdTool.distribute();
    }
    
    //read personal medical records
    public boolean readMedicalRecord(JTextField diagnoses, JTextField treatmentPlans, JTextField medications, JTextField immunizations){
        Blockchain bcdTool = new Blockchain();
        File file = new File("masterchain.dat");
        String uuid = Session.getUuid();
        
        if (file.length() == 0) {
            return false;            
        } else {
            LinkedList<Block> chain  =  bcdTool.get();
            //System.out.println(chain);
            String block = chain.getLast().toString();
            String[] trx = block.split(",");
            String patientData = trx[2];
            String[] specificPatientData = patientData.split("\\|");
            
            if (uuid.equals(trx[4])){
                diagnoses.setText(specificPatientData[0]);
                treatmentPlans.setText(specificPatientData[1]);
                medications.setText(specificPatientData[2]);
                immunizations.setText(specificPatientData[3]);
                return true;
            } else {
                return false;
            }     
        } 
    }
}
