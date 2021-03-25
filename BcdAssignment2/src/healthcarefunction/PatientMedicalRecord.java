package healthcarefunction;

import block.Block;
import block.Blockchain;
import java.io.File;
import java.util.LinkedList;
import javax.swing.JTextField;


public class PatientMedicalRecord {
    
    private static LinkedList<Block> db = new LinkedList<>();
      
    //the whole process to create new medical record.
    public void addMedicalRecord(String data1, String data2) throws Exception{
        Blockchain bcdTool = new Blockchain();
        LinkedList<Block> chain = bcdTool.get();
        System.out.println(chain);
        
        //first block
        if(chain == null) {
            Block genesisBlock = new Block("0", data1, data2,"","",""); //0 is the previous hash
            bcdTool.nextBlock(genesisBlock);
            bcdTool.persist();
        
        //second block and onwards 
        }else{
            db = chain;
            bcdTool.setDb(db);
            Block block = new Block(chain.getLast().getHash(), data1, data2,"","","");
            bcdTool.nextBlock(block);
            bcdTool.persist(); 
        }
        
        //easy for us to check the data structure.
        bcdTool.distribute();
    }
    
    //read personal medical records
    public boolean readMedicalRecord(JTextField data1, JTextField data2){
        Blockchain bcdTool = new Blockchain();
        File file = new File("masterchain.dat");
        if (file.length() == 0) {
            return false;
            
        }else{
            LinkedList<Block> chain  =  bcdTool.get();
            //System.out.println(chain);
            String rec = chain.getLast().toString();
            String[] data = rec.split(",");
            data1.setText(data[2]);
            data2.setText(data[3]);
            return true;
        }
    }
}
