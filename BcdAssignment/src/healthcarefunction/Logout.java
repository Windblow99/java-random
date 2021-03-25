
package healthcarefunction;

import javax.swing.JOptionPane;
import utility.Session;


public class Logout {
    public static boolean logout(){
       int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?");
       
        if(result == 0) {
            Session.setUuid("");
            return true;
        }else{
            return false;
        }
    }
}
