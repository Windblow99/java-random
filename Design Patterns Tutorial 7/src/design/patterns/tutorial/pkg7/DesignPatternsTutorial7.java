package design.patterns.tutorial.pkg7;

public class DesignPatternsTutorial7 {

    public static void main(String[] args) {
        charFactory cf = new charFactory();
        
        character player1 = cf.makeChar("so");
        
        System.out.println("Player 1 stats");
        System.out.println("Player 1 defence: " + player1.defenceStat());
        System.out.println("Player 1 offence: " + player1.offenceStat());
        
        player enhancedPlayer = new gun(new gun(new armour(new sword(player1))));
        
        System.out.println("Player 1 stats");
        System.out.println("Player 1 defence: " + enhancedPlayer.defenceStat());
        System.out.println("Player 1 offence: " + enhancedPlayer.offenceStat());
    }
    
}

class charFactory {
    character c;
    
    public character makeChar(String type) {
        if(type.equalsIgnoreCase("so")) {
            c = new soldier();
        }        
        else if(type.equalsIgnoreCase("so")) {
            c = new spy();
        }
        else {
            c = new scientist();
        }
        return c;
    }
}

abstract class character implements player {}

class scientist extends character {
    int offence = 10;
    int defence = 15;
    public int defenceStat(){
        return defence;
    };
    
    public int offenceStat(){
        return offence;
    }
}

class spy extends character {
    int offence = 10;
    int defence = 15;
    public int defenceStat(){
        return defence;
    };
    
    public int offenceStat(){
        return offence;
    }
}

class soldier extends character {
    int offence = 10;
    int defence = 15;
    public int defenceStat(){
        return defence;
    };
    
    public int offenceStat(){
        return offence;
    }
}

interface player {
    public int defenceStat();
    public int offenceStat();
}

abstract class charDecorator implements player {
    //abstract because we do not want to instantiate it
    player p;
    public charDecorator(player p) {
        this.p = p;
    }
    
    public int defenceStat(){
        return p.defenceStat();
    }
    
    public int offenceStat(){
        return p.offenceStat();
    }
}

class sword extends charDecorator {
    public sword(player p) {
        super(p);
    }
    
    public int offenceStat(){
        return p.offenceStat() + 40;
    }
}

class gun extends charDecorator {
    public gun(player p) {
        super(p);
    }
    
    public int offenceStat(){
        return p.offenceStat() + 110;
    }
}

class curass extends charDecorator {
    public curass(player p) {
        super(p);
    }
    
    public int defenceStat(){
        return p.defenceStat() + 60;
    }
}

class shield extends charDecorator {
    public shield(player p) {
        super(p);
    }
    
    public int defenceStat(){
        return p.defenceStat() + 80;
    }
}

class armour extends charDecorator {
    public armour(player p) {
        super(p);
    }
    
    public int defenceStat(){
        return p.defenceStat() + 150;
    }
}