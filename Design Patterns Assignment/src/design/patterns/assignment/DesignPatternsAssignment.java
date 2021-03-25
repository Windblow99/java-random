package design.patterns.assignment;

import java.util.Scanner;

public class DesignPatternsAssignment {

    public static void main(String[] args) {
        deviceFactory deviceFactory = new deviceFactory();
        gameFactory gameFactory = new gameFactory();
        Scanner in = new Scanner(System.in);
        
        System.out.println("Welcome to gaming wiki, plase select category:");
        System.out.println("1. Gaming Devices"); 
        System.out.println("2. Video Games"); 
        String purchaseOption = in.nextLine(); 
        
        if (purchaseOption.equalsIgnoreCase("1")){
            System.out.println("Please select type of gaming devices you want to know about:");
            System.out.println("1. PC"); 
            System.out.println("2. Xbox");
            System.out.println("3. PlayStation");
            
            String choice = in.nextLine();        
            String selectedOption = deviceFactory.chosenOption(choice);
            System.out.println(selectedOption);
        }
        else if (purchaseOption.equalsIgnoreCase("2")){
            System.out.println("Please select the video game you want to know about:");
            System.out.println("1. CyberPunk 2077"); 
            System.out.println("2. CS:GO");
            System.out.println("3. League of Legends");
            
            String choice = in.nextLine();        
            String selectedOption = gameFactory.chosenOption(choice);
            System.out.println(selectedOption);
            
            System.out.println("Please select the edition of the game " + gameFactory.getClass().getSimpleName());
            System.out.println("1. Standard Edition"); 
            System.out.println("2. Deluxe Edition");
            
            String editionChoice = in.nextLine();   
            if (editionChoice.equalsIgnoreCase("1")){
                printStandardEdition(new standardEdition());
            } else if (editionChoice.equalsIgnoreCase("2")){
                printDeluxeEdition(new deluxeEdition());
            }
        }
    }  
    
    public static void printStandardEdition(edition edition) {
        standardEdition standardEdition = new standardEdition();
        standardEdition.print();
    }
    
    public static void printDeluxeEdition(edition edition) {
        deluxeEdition deluxeEdition = new deluxeEdition();
        deluxeEdition.print();
    }
}

class devices{
    private String deviceInfo;

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}

class PC extends devices {}
class Xbox extends devices {}
class PlayStation extends devices {}

class deviceFactory{
    private devices d;
    
    public String chosenOption(String choice){
        if (choice.equalsIgnoreCase("1")){
            d = new PC();
            d.setDeviceInfo("Demo info for " + d.getClass().getSimpleName());
        } else if (choice.equalsIgnoreCase("2")){
            d = new Xbox();
            d.setDeviceInfo("Demo info for "  + d.getClass().getSimpleName());
        } else if (choice.equalsIgnoreCase("3")){
            d = new PlayStation();
            d.setDeviceInfo("Demo info for "  + d.getClass().getSimpleName());
        }
        
        return d.getDeviceInfo();
    }
}

interface edition {
    String getEditionInfo();

    void setEditionInfo(String editionInfo);
    
    void print();
}

class standardEdition implements edition {
    private String editionInfo = "Standard edition information. \nBase game only.";

    @Override
    public String getEditionInfo() {
        return editionInfo;
    }

    @Override
    public void setEditionInfo(String editionInfo) {
        this.editionInfo = editionInfo;
    }

    @Override
    public void print() {
        System.out.println(editionInfo);
    }
}

class deluxeEdition implements edition {
    private String editionInfo = "Deluxe edition information. \nBase game with additional downloadable content.";

    @Override
    public String getEditionInfo() {
        return editionInfo;
    }

    @Override
    public void setEditionInfo(String editionInfo) {
        this.editionInfo = editionInfo;
    }

    @Override
    public void print() {
        System.out.println(editionInfo);
    }
}

abstract class videoGames {
    private String gameInfo;

    public String getGameInfo() {
      return gameInfo;
    }

    public void setGameInfo(String gameInfo) {
      this.gameInfo = gameInfo;
    }
}

class Cyberpunk extends videoGames {}
class CSGO extends videoGames {}
class League extends videoGames {}

class gameFactory{
    private videoGames v;
    
    public String chosenOption(String choice){
        if (choice.equalsIgnoreCase("1")){
            v = new Cyberpunk();
            v.setGameInfo("Demo info for "  + v.getClass().getSimpleName());
        } else if (choice.equalsIgnoreCase("2")){
            v = new CSGO();
            v.setGameInfo("Demo info for "  + v.getClass().getSimpleName());
        } else if (choice.equalsIgnoreCase("3")){
            v = new League();
            v.setGameInfo("Demo info for "  + v.getClass().getSimpleName());
        }
        
        return v.getGameInfo();
    }
}