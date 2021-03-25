package Exercise.Week7;

public class Factory_Decorator_Strategy_Game {
    public static void main(String[] args) {
        CharacterFactory cf = new CharacterFactory();
        Character basicSpy = cf.makeCharacter("spy");
        System.out.println("Spy stats: " + basicSpy.getDefence() + " | " + basicSpy.getOffence());

        Player enhancedSpy = new Shield(basicSpy);
        System.out.println("Spy stats: " + enhancedSpy.getDefence() + " | " + enhancedSpy.getOffence());

        Player enhancedSpy2 = new Sword(enhancedSpy);
        System.out.println("Spy stats: " + enhancedSpy2.getDefence() + " | " + enhancedSpy2.getOffence());
    }
}

class CharacterFactory{
    Character c;

    public Character makeCharacter(String t){
        if(t.equalsIgnoreCase("spy")){
            c = new Spy(50, 100);
        }
        else if(t.equalsIgnoreCase("scientist")){
            c = new Scientist(60, 120);
        }
        else{
            c = new Soldier(70, 140);
        }
        return c;
    }
}

interface Player{
    public int getDefence();
    public int getOffence();
}

abstract class Character implements Player{
    private int defence;
    private int offence;

    public Character(int d, int o){
        defence = d;
        offence = o;
    }

    @Override
    public int getDefence(){
        return defence;
    }

    @Override
    public int getOffence() {
        return offence;
    }
}

class Spy extends Character{

    public Spy(int d, int o) {
        super(d, o);
    }

}

class Scientist extends Character{

    public Scientist(int d, int o) {
        super(d, o);
    }
}

class Soldier extends Character{

    public Soldier(int d, int o) {
        super(d, o);
    }
}

abstract class CharDecorator implements Player{
    private Player p;

    public CharDecorator(Player p){
        this.p = p;
    }

    public Player getP() {
        return p;
    }

    @Override
    public int getDefence() {
        return p.getDefence();
    }

    @Override
    public int getOffence() {
        return p.getOffence();
    }
}

abstract class Offence extends CharDecorator{

    public Offence(Player p) {
        super(p);
    }
}

class Sword extends Offence{

    public Sword(Player p) {
        super(p);
    }

    @Override
    public int getDefence() {
        return getP().getDefence();
    }

    @Override
    public int getOffence() {
        return getP().getOffence() + 50;
    }
}

abstract class Defence extends CharDecorator{

    public Defence(Player p) {
        super(p);
    }
}

class Shield extends Defence{

    public Shield(Player p) {
        super(p);
    }

    @Override
    public int getDefence() {
        return getP().getDefence() + 50;
    }

    @Override
    public int getOffence() {
        return getP().getOffence();
    }
}