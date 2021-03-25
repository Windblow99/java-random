package Blockchain2;

import blockchain.block.concept.Block;
import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) throws Exception {
        tst1();
    }
    
    //test to generate the currentHash of Block object
    static void tst1() throws Exception {
        Block genesisBlock = new Block("0", "");
        Blockchain.nextBlock(genesisBlock);
        Blockchain.persist();
        
        LinkedList<Block>chain = Blockchain.get();
        Block b2 = new Block(chain.getLast().getHash(), "efg");
        Blockchain.nextBlock(b2);
        Blockchain.persist();
        
        chain = Blockchain.get();
        Block b3 = new Block(chain.getLast().getHash(), "hij");
        Blockchain.nextBlock(b3);
        Blockchain.persist();
        
        Blockchain.distribute();
    }
}
