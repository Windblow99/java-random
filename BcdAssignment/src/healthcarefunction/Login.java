package healthcarefunction;

import healthcaregui.ViewHospitalHome;
import healthcaregui.ViewInsuranceCompany;
import healthcaregui.ViewPatientHome;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utility.*;

public class Login {
    public static boolean login(String username, String password){
        
        String userUUID = "";
        String role = "";
        boolean usnFound = false;
        boolean uuidFound = false;
        boolean passFound = false;
        
        List<String> userLst = FileIO.read("login.txt");
        List<String> pwdLst = FileIO.read("secret.txt");
        List<String> uuidLst = new ArrayList();
        
        //check if the list is available
        if (userLst == null || pwdLst == null) {
            JOptionPane.showMessageDialog(null, "technical error. Please seek for help.");
            return false;
        }
        
        //validation
        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "the fields cannot be empty.");
            return false;
        }
        
        //check username
        for(String user : userLst){
            String[] usnArray = user.split("\\|");
            if (usnArray[0].equals(username)) {
                usnFound = true;
                userUUID = usnArray[1];
                role = usnArray[2];
            }
        }
        
        //check uuid
        if (usnFound) {
            //comparing uuid to another uuid of another list..
            for(String pwd : pwdLst){
                String[] uuidArray = pwd.split("\\|");
                if (uuidArray[0].equals(userUUID)) {
                    uuidFound = true;
                }
            }
        }
        
        //check password
        if (uuidFound) {
            for(String pwd : pwdLst){
                String[] pwdComponent = pwd.split("\\|");
                try {
                    String inputPwdHash = Hasher.hashPassword(Text.prepend(pwdComponent[1], password), "SHA-256"); 
                    if (inputPwdHash.equals(pwdComponent[2])) {
                        passFound = true;
                    }
                } catch (Exception e) {
                }      
            }
        }
        
        
        //pop-up message
        if (!passFound || !uuidFound) { 
            JOptionPane.showMessageDialog(null, "The username or password is incorrect.");
            return false;
        }
        else{
            JOptionPane.showMessageDialog(null, "Login successfully.");
            Session.setUuid(userUUID);
            Session.setRole(role);
            
            //different role show differen form
            switch(role){
                case "patient":
                    ViewPatientHome pHome = new ViewPatientHome();
                    pHome.setLocationRelativeTo(null);
                    pHome.setVisible(true);
                    break;

                case "healthcare personnel":
                    ViewHospitalHome hHome = new ViewHospitalHome();
                    hHome.setLocationRelativeTo(null);
                    hHome.setVisible(true);
                    break;


                case "insurance company": 
                    ViewInsuranceCompany vic = new ViewInsuranceCompany();
                    vic.setLocationRelativeTo(null);
                    vic.setVisible(true);
                    break;
            }
            
            return true;
        }
    }
}
