package domain;

import da.FileWriter;
import java.util.ArrayList;
import util.Func;

public class User {

    private FileWriter oa;
    private String id, name, username, password;
    public void setUsername(String un){
        this.username = un;
    }
    public void setPassword(String pw){
        this.password = pw;
    }
    public void setName(String name){
        this.name = name;
    }
    
    //constructor
    public User(){
        oa = new FileWriter();
        oa.setFileName("user.dat");
    }

    public boolean login(){
       boolean success = false;
       //logic step
       //101|john|john123|123321
       //USERNAME(2) and PASSWORD(3)
       ArrayList<String> data = oa.readAll();
        for (String record : data) {
            String[] split = record.split("\\|");
            if (split[2].equals(username) && 
                    split[3].equals(password)) {
                success = true;
                break;
            }
        }
       return success;     
    }
    
    //create User
    public String create(){
        Long id = Func.generateUniqueId();
        String uid = Long.toString(id);
        //logic step
        String record = String.join("|", 
                uid, name, username, password);
        boolean ok = oa.write(record);
        if(ok){
            return uid;
        }else{
            return null;
        }
        
    }
    
    public String remove(String id){
        boolean success = false;
        ArrayList<String> data = oa.readAll();
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).startsWith(id)){
                //remove
                data.remove(i);
                success = true;
                break;
            }
        }
        if (success) {
        if(oa.write(data)){
            return id;
        }else{return null;}
    } else{
        return null;
      }
    }
    
    public static void main(String[] args){
        User obj = new User();
        obj.remove("102");
    }
}
