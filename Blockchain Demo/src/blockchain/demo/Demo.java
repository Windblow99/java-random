package blockchain.demo;

public class Demo {
    static BasicDsDemo dsf = new BasicDsDemo();
    
    public static void main(String[] args) throws Exception {
        tst2();
    }
    
    static void tst2() throws Exception {
        String data = "happyworkingassignemnt!";
        System.out.println(data);
        String ds = dsf.encrypt(dsf.hash(data));
        System.out.println("Digital signature: " + ds);
        
        System.out.println("Sending...");
//        data = "merrychristmas!"; //to check how data modified would affect
        //Sending data to verifier
        Thread.sleep(3000);
        
        boolean isValid = dsf.verify(data, ds);
        System.out.println("\nThe data and digital signature matched: " + isValid);
    }
    
    static void tst1() throws Exception{
        String data = "happymooncakefestival!";
 
        String ds = dsf.encrypt(dsf.hash(data));
 
        System.out.println("Digital signature: " + ds);
        System.out.println("Sending...");
//        data = "merrychristmas";
        //sending data to verifier
        Thread.sleep(3000);
 
        boolean isValid = dsf.verify(data, ds);
        System.out.println("\nthe data and digital signature matched: " + isValid);
    }
}
