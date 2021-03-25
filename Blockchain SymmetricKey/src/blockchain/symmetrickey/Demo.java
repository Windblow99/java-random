package blockchain.symmetrickey;

//Symmetric key encryption

import java.util.Base64;

    //1) Make the secret key
        //option: a) defined secret key; b) random secret key
    //2) Perform encryption and decryption

public class Demo {
    public static void main(String[] args) throws Exception {
//        //check the key
//        byte[] key = new SymmCrypto().getKey().getEncoded();
//        System.out.println(Base64.getEncoder().encodeToString(key));

        SymmCrypto crypto = new SymmCrypto();
        String data = "#stayhealthy";
        System.out.println("Data: " + data);
        System.out.println("=====================");
        
        //encryption
        String cipherText = crypto.encrypt(data);
        System.out.println("Encrypted: " + cipherText);
        Thread.sleep(2000);
        System.out.println("");
        
        //decryption
        String originalData = crypto.decrypt(cipherText);
        System.out.println("Decrypted: " + originalData);
        
        //Exercise
        //register the company to the system
        //and then generate the company id based on the secret key
        
        //for example, company name : APIIT + Registration Number
        //company ID : ENCRYPTED OUTPUT of COMPANY NAME
        
        //Textfo;e storage - data model
        //Company ID | Company name | Registration number | Address | Tel | Email
    }
    
}
