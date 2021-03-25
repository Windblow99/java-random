package pwd;

public class SecureRandomTst {

    public static void main(String[] args) throws Exception {

       tst1();
       
    }
    
    static void tst1() throws Exception{
        String username = "d1ck";
        String password = "d1ck";
        
        Password.create( username, password );
        System.out.println("");
    }
    
}
