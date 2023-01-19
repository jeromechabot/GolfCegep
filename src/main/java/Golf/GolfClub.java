/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Golf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Jerome Chabot
 */
public class GolfClub {
    static double phi;
    double maxCarry;
    String name;
    double precisionIndex; //this will be a percentage
    int typeCode;
    int specificCode;
    ArrayList golfBag=new ArrayList<GolfClub>();
    
    public GolfClub(double phi, double maxCarry, String name, double precisionIndex, int typeCode, int specificCode){
        this.phi=phi;
        this.maxCarry=maxCarry;
        this.name=name;
        this.precisionIndex=precisionIndex;
        this.typeCode=typeCode;
        this.specificCode=specificCode;
        
    }
    
    public void setGolfBag() throws IOException{
        //empty golfBag to reset values
        
        golfBag.clear();
        
        int selectedDrivers=0;  
        int selectedIrons=0;
        int selectedPutter=0;
        try{
            selectedDrivers=getMemorySelectedDriverContent();
            selectedIrons=getMemorySelectedIronContent();
            selectedPutter=getMemorySelectedPutterContent();
        }
        catch(IOException e){
            
        }
        
        switch(selectedDrivers){
            case 1 :
                golfBag.add(basicDriver);
                golfBag.add(basic3Wood);
                break;
            case 2 :
                golfBag.add(superDriver);
                golfBag.add(super3Wood);
                break;
            case 3 :
                golfBag.add(advancedDriver);
                golfBag.add(advanced3Wood);
                break;
            case 4 :
                golfBag.add(proDriver);
                golfBag.add(pro3Wood);
                break;
            case 5 :
                golfBag.add(athleteDriver);
                golfBag.add(athlete3Wood);
                break;
            case 6 :
                golfBag.add(ultimateDriver);
                golfBag.add(ultimate3Wood);
                break;
        }
        
        switch(selectedIrons){
            case 1 :
                golfBag.add(basic4Iron);
                golfBag.add(basic5Iron);
                golfBag.add(basic6Iron);
                golfBag.add(basic7Iron);
                golfBag.add(basic8Iron);
                golfBag.add(basic9Iron);
                golfBag.add(basicPitchingWedge);
                golfBag.add(basicSandWedge);
                break;
            case 2 :
                golfBag.add(super4Iron);
                golfBag.add(super5Iron);
                golfBag.add(super6Iron);
                golfBag.add(super7Iron);
                golfBag.add(super8Iron);
                golfBag.add(super9Iron);
                golfBag.add(superPitchingWedge);
                golfBag.add(superSandWedge);
                break;
            case 3 :
                golfBag.add(advanced4Iron);
                golfBag.add(advanced5Iron);
                golfBag.add(advanced6Iron);
                golfBag.add(advanced7Iron);
                golfBag.add(advanced8Iron);
                golfBag.add(advanced9Iron);
                golfBag.add(advancedPitchingWedge);
                golfBag.add(advancedSandWedge);
                break;
            case 4 :
                golfBag.add(pro4Iron);
                golfBag.add(pro5Iron);
                golfBag.add(pro6Iron);
                golfBag.add(pro7Iron);
                golfBag.add(pro8Iron);
                golfBag.add(pro9Iron);
                golfBag.add(proPitchingWedge);
                golfBag.add(proSandWedge);
                break;
            case 5 :
                golfBag.add(athlete4Iron);
                golfBag.add(athlete5Iron);
                golfBag.add(athlete6Iron);
                golfBag.add(athlete7Iron);
                golfBag.add(athlete8Iron);
                golfBag.add(athlete9Iron);
                golfBag.add(athletePitchingWedge);
                golfBag.add(athleteSandWedge);
                break;
            case 6 :
                golfBag.add(ultimate4Iron);
                golfBag.add(ultimate5Iron);
                golfBag.add(ultimate6Iron);
                golfBag.add(ultimate7Iron);
                golfBag.add(ultimate8Iron);
                golfBag.add(ultimate9Iron);
                golfBag.add(ultimatePitchingWedge);
                golfBag.add(ultimateSandWedge);
                break;
        }
        
        switch(selectedPutter){
            case 1: 
                golfBag.add(basicPutter); break;
            case 2: 
                golfBag.add(superPutter); break;
            case 3: 
                golfBag.add(advancedPutter); break;
            case 4: 
                golfBag.add(proPutter); break;
            case 5: 
                golfBag.add(athletePutter); break;
            case 6: 
                golfBag.add(ultimatePutter); break;
        }
    }
    
    public int getMemorySelectedDriverContent() throws IOException{
        
        int fileContent=0;
        
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("memorySelectedDrivers.txt"));) {
            while (input.available()>0) {
                int temp = input.readInt();
                fileContent+=temp;
            }
        }
        return fileContent;
    }
    
    public int getMemorySelectedIronContent() throws IOException{
        
        int fileContent=0;
        
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("memorySelectedIron.txt"));) {
            while (input.available()>0) {
                int temp = input.readInt();
                fileContent+=temp;
            }
        }
        return fileContent;
    }
    
    public int getMemorySelectedPutterContent() throws IOException{
        
        int fileContent=0;
        
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("memorySelectedPutter.txt"));) {
            while (input.available()>0) {
                int temp = input.readInt();
                fileContent+=temp;
            }
        }
        return fileContent;
    }
        
    //list of Drivers
    static GolfClub basicDriver=new GolfClub(10.0, 250.0, "Basic Driver", 0.0, 0, 0);
    static GolfClub superDriver=new GolfClub(10.0, 260.0, "Super Driver", 5.0, 0, 1);
    static GolfClub advancedDriver=new GolfClub(10.0, 270.0, "Advanced Driver", 10.0, 0, 2);
    static GolfClub proDriver=new GolfClub(10.0, 280.0, "Pro Driver", 15.0, 0, 3);
    static GolfClub athleteDriver=new GolfClub(10.0, 290.0, "Athlete Driver", 20.0, 0, 4);
    static GolfClub ultimateDriver=new GolfClub(10.0, 300.0, "Ultimate Driver", 25.0, 0, 5);
    
    //list of 3 Woods
    static GolfClub basic3Wood=new GolfClub(15.0, 225.0, "Basic 3 Wood", 5.0, 1, 0);
    static GolfClub super3Wood=new GolfClub(15.0, 230.0, "Super 3 Wood", 10.0, 1, 1);
    static GolfClub advanced3Wood=new GolfClub(15.0, 235.0, "Advanced 3 Wood", 15.0, 1, 2);
    static GolfClub pro3Wood=new GolfClub(15.0, 240.0, "Pro 3 Wood", 20.0, 1, 3);
    static GolfClub athlete3Wood=new GolfClub(15.0, 245.0, "Athlete 3 Wood", 25.0, 1, 4);
    static GolfClub ultimate3Wood=new GolfClub(15.0, 250.0, "Ultimate 3 Wood", 30.0, 1, 5);
    
    //list of 4 Irons
    static GolfClub basic4Iron=new GolfClub(24.0, 180.0, "Basic 4 Iron", 10.0, 2, 0);
    static GolfClub super4Iron=new GolfClub(24.0, 180.0, "Super 4 Iron", 20.0, 2, 1);
    static GolfClub advanced4Iron=new GolfClub(24.0, 180.0, "Advanced 4 Iron", 30.0, 2, 2);
    static GolfClub pro4Iron=new GolfClub(24.0, 180.0, "Pro 4 Iron", 40.0, 2, 3);
    static GolfClub athlete4Iron=new GolfClub(24.0, 180.0, "Athlete 4 Iron", 50.0, 2, 4);
    static GolfClub ultimate4Iron=new GolfClub(24.0, 180.0, "Ultimate 4 Iron", 60.0, 2, 5);
    
    //list of 5 Irons
    static GolfClub basic5Iron=new GolfClub(27.0, 170.0, "Basic 5 Iron", 15.0, 3, 0);
    static GolfClub super5Iron=new GolfClub(27.0, 170.0, "Super 5 Iron", 25.0, 3, 1);
    static GolfClub advanced5Iron=new GolfClub(27.0, 170.0, "Advanced 5 Iron", 35.0, 3, 2);
    static GolfClub pro5Iron=new GolfClub(27.0, 170.0, "Pro 5 Iron", 45.0, 3, 3);
    static GolfClub athlete5Iron=new GolfClub(27.0, 170.0, "Athlete 5 Iron", 55.0, 3, 4);
    static GolfClub ultimate5Iron=new GolfClub(27.0, 170.0, "Ultimate 5 Iron", 65.0, 3, 5);
    
    //list of 6 Irons
    static GolfClub basic6Iron=new GolfClub(31.0, 160.0, "Basic 6 Iron", 20.0, 4, 0);
    static GolfClub super6Iron=new GolfClub(31.0, 160.0, "Super 6 Iron", 30.0, 4, 1);
    static GolfClub advanced6Iron=new GolfClub(31.0, 160.0, "Advanced 6 Iron", 40.0, 4, 2);
    static GolfClub pro6Iron=new GolfClub(31.0, 160.0, "Pro 6 Iron", 50.0, 4, 3);
    static GolfClub athlete6Iron=new GolfClub(31.0, 160.0, "Ahtlete 6 Iron", 60.0, 4, 4);
    static GolfClub ultimate6Iron=new GolfClub(31.0, 160.0, "Ultimate 6 Iron", 70.0, 4, 5);
    
    //list of 7 Irons
    static GolfClub basic7Iron=new GolfClub(35.0, 150.0, "Basic 7 Iron", 25.0, 5, 0);
    static GolfClub super7Iron=new GolfClub(35.0, 150.0, "Super 7 Iron", 35.0, 5, 1);
    static GolfClub advanced7Iron=new GolfClub(35.0, 150.0, "Advanced 7 Iron", 45.0, 5, 2);
    static GolfClub pro7Iron=new GolfClub(35.0, 150.0, "Pro 7 Iron", 55.0, 5, 3);
    static GolfClub athlete7Iron=new GolfClub(35.0, 150.0, "Athlete 7 Iron", 65.0, 5, 4);
    static GolfClub ultimate7Iron=new GolfClub(35.0, 150.0, "Ultimate 7 Iron", 75.0, 5, 5);
    
    //list of 8 Irons
    static GolfClub basic8Iron=new GolfClub(38.0, 140.0, "Basic 8 Iron", 30.0, 6, 0);
    static GolfClub super8Iron=new GolfClub(38.0, 140.0, "Super 8 Iron", 40.0, 6, 1);
    static GolfClub advanced8Iron=new GolfClub(38.0, 140.0, "Advanced 8 Iron", 50.0, 6, 2);
    static GolfClub pro8Iron=new GolfClub(38.0, 140.0, "Pro 8 Iron", 60.0, 6, 3);
    static GolfClub athlete8Iron=new GolfClub(38.0, 140.0, "Athlete 8 Iron", 70.0, 6, 4);
    static GolfClub ultimate8Iron=new GolfClub(38.0, 140.0, "Ultimate 8 Iron", 80.0, 6, 5);
    
    //list of 9 Irons
    static GolfClub basic9Iron=new GolfClub(42.0, 130.0, "Basic 9 Iron", 35.0, 7, 0);
    static GolfClub super9Iron=new GolfClub(42.0, 130.0, "Super 9 Iron", 45.0, 7, 1);
    static GolfClub advanced9Iron=new GolfClub(42.0, 130.0, "Advanced 9 Iron", 55.0, 7, 2);
    static GolfClub pro9Iron=new GolfClub(42.0, 130.0, "Pro 9 Iron", 65.0, 7, 3);
    static GolfClub athlete9Iron=new GolfClub(42.0, 130.0, "Athlete 9 Iron", 75.0, 7, 4);
    static GolfClub ultimate9Iron=new GolfClub(42.0, 130.0, "Ultimate 9 Iron", 85.0, 7, 5);
    
    //list of Pitching Wedges
    static GolfClub basicPitchingWedge=new GolfClub(45.0, 120.0, "Basic Pitching Wedge", 40.0, 8, 0);
    static GolfClub superPitchingWedge=new GolfClub(45.0, 120.0, "Super Pitching Wedge", 50.0, 8, 1);
    static GolfClub advancedPitchingWedge=new GolfClub(45.0, 120.0, "Advanced Pitching Wedge", 60.0, 8, 2);
    static GolfClub proPitchingWedge=new GolfClub(45.0, 120.0, "Pro Pitching Wedge", 70.0, 8, 3);
    static GolfClub athletePitchingWedge=new GolfClub(45.0, 120.0, "Athlete Pitching Wedge", 80.0, 8, 4);
    static GolfClub ultimatePitchingWedge=new GolfClub(45.0, 120.0, "Ultimate Pitching Wedge", 90.0, 8, 5);
    
    //list of Sand Wedges
    static GolfClub basicSandWedge=new GolfClub(56.0, 100.0, "Basic Sand Wedge", 45.0, 9, 0);
    static GolfClub superSandWedge=new GolfClub(56.0, 100.0, "Super Sand Wedge", 55.0, 9, 1);
    static GolfClub advancedSandWedge=new GolfClub(56.0, 100.0, "Advanced Sand Wedge", 65.0, 9, 2);
    static GolfClub proSandWedge=new GolfClub(56.0, 100.0, "Pro Sand Wedge", 75.0, 9, 3);
    static GolfClub athleteSandWedge=new GolfClub(56.0, 100.0, "Athlete Sand Wedge", 85.0, 9, 4);
    static GolfClub ultimateSandWedge=new GolfClub(56.0, 100.0, "Ultimate Sand Wedge", 95.0, 9, 5);
    
    //list of Putters
    static GolfClub basicPutter=new GolfClub(1.0, 50.0, "Basic Putter", 50.0, 10, 0);
    static GolfClub superPutter=new GolfClub(1.0, 50.0, "Super Putter", 60.0, 10, 1);
    static GolfClub advancedPutter=new GolfClub(1.0, 50.0, "Advanced Putter", 70.0, 10, 2);
    static GolfClub proPutter=new GolfClub(1.0, 50.0, "Pro Putter", 80.0, 10, 3);
    static GolfClub athletePutter=new GolfClub(1.0, 50.0, "Athlete Putter", 90.0, 10, 4);
    static GolfClub ultimatePutter=new GolfClub(1.0, 50.0, "Ultimate Putter", 100.0, 10, 5);
    
    
    
}
