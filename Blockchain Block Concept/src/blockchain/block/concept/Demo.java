package blockchain.block.concept;

public class Demo {
    public static void main(String[] args) {
        try {
            tst1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //test to generate the currentHash of Block object
    static void tst1() throws Exception {
        Block b1 = new Block("0", "abc");
        System.out.println(b1);
        Block b2 = new Block("1", "efg");
        System.out.println(b2);
        Block b3 = new Block("2", "hij");
        System.out.println(b3);
    }
}
