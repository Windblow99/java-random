package newfolder;

public class Sample {
    //Exercise
    //Write a program that prints 10 rows (10 stars per row).
    //Main Method
    public static void main(String[] args){
        option2(10,10);
    }
    
    static void option2(int row, int col){        
        for (int i = 0; i < row; i++) { //Controlling row variable
            for(int j=0; j <col; j++){ //Controlling column variable
                System.out.print("*");
            }
            System.out.println("");
        }       
    }
}
