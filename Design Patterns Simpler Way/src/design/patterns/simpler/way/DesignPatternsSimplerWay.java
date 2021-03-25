package design.patterns.simpler.way;

import java.util.Scanner;

public class DesignPatternsSimplerWay {
    public static void main(String[] args) {
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
            if (choice.equalsIgnoreCase("1")){
                devices devices = new devices();
                devices.setDeviceInfo("PC");
                System.out.println("Demo info for " + devices.getDeviceInfo());
            } else if (choice.equalsIgnoreCase("2")){
                devices devices = new devices();
                devices.setDeviceInfo("Xbox");
                System.out.println("Demo info for " + devices.getDeviceInfo());
            } else if (choice.equalsIgnoreCase("3")){
                devices devices = new devices();
                devices.setDeviceInfo("PlayStation");
                System.out.println("Demo info for " + devices.getDeviceInfo());
            } 
        } else if (purchaseOption.equalsIgnoreCase("2")){
            System.out.println("Please select the video game you want to know about:");
            System.out.println("1. CyberPunk 2077"); 
            System.out.println("2. CS:GO");
            System.out.println("3. League of Legends");
            
            String choice = in.nextLine();
            if (choice.equalsIgnoreCase("1")){
                videoGames videoGames = new videoGames();
                videoGames.setTitle("CyberPunk 2077");
                System.out.println("Please select the edition of the game " + videoGames.getTitle());
                System.out.println("1. Standard Edition"); 
                System.out.println("2. Deluxe Edition");
            } else if (choice.equalsIgnoreCase("2")){
                videoGames videoGames = new videoGames();
                videoGames.setTitle("CS:GO");
                System.out.println("Please select the edition of the game " + videoGames.getTitle());
                System.out.println("1. Standard Edition"); 
                System.out.println("2. Deluxe Edition");
            } else if (choice.equalsIgnoreCase("3")){
                videoGames videoGames = new videoGames();
                videoGames.setTitle("League of Legends");
                System.out.println("Please select the edition of the game " + videoGames.getTitle());
                System.out.println("1. Standard Edition"); 
                System.out.println("2. Deluxe Edition");
            } 
            
            String editionChoice = in.nextLine();   
            if (editionChoice.equalsIgnoreCase("1")){
                System.out.println("Standard edition information.");
                System.out.println("Base game only.");
            } else if (editionChoice.equalsIgnoreCase("2")){
                System.out.println("Deluxe edition information.");
                System.out.println("Base game with additional downloadable content.");
            }  
        }
    }
}

class devices {
    private String deviceInfo;

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}

class videoGames {
    private String gamesInfo;

    public String getTitle() {
        return gamesInfo;
    }

    public void setTitle(String gamesInfo) {
        this.gamesInfo = gamesInfo;
    }
}

class edition {
    private String editionInfo;

    public String getEditionInfo() {
        return editionInfo;
    }

    public void setEditionInfo(String editionInfo) {
        this.editionInfo = editionInfo;
    }
}