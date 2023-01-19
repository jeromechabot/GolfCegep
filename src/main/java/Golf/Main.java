/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Golf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jerome Chabot
 */
public class Main extends Application{
    
    public static void main(String[] args) throws IOException{
        
        //create bank file
        File bankFile =new File("bank.txt");
        boolean isCreatedBank = bankFile.createNewFile();
        
        //create memory for drivers file, add value 1 if created to own Basic Driver
        File memoryDriversFile =new File("memoryDrivers.txt");
        boolean isCreatedDrivers = memoryDriversFile.createNewFile();
        if(isCreatedDrivers==true){
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memoryDrivers.txt"));) {
                int num = 1;
                output.writeInt(num);
            } 
            catch (FileNotFoundException e) {
               e.printStackTrace();
            }
        }
        
        //create memory for irons file, add value 1 if created to own Basic Irons
        File memoryIronsFile =new File("memoryIrons.txt");
        boolean isCreatedIrons = memoryIronsFile.createNewFile();
        if(isCreatedIrons==true){
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memoryIrons.txt"));) {
                int num = 1;
                output.writeInt(num);
            } 
            catch (FileNotFoundException e) {
               e.printStackTrace();
            }
        }
        
        //create memory for putters file, add value 1 if file created to own Basic Putters
        File memoryPuttersFile =new File("memoryPutters.txt");
        boolean isCreatedPutters = memoryPuttersFile.createNewFile();
        if(isCreatedPutters==true){
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memoryPutters.txt"));) {
                int num = 1;
                output.writeInt(num);
            } 
            catch (FileNotFoundException e) {
               e.printStackTrace();
            }
        }
        
        //create memory for selected driver, add value 1 if file created to have selected Basic Driver by default
        File memorySelectedDriverFile =new File("memorySelectedDrivers.txt");
        boolean isCreatedSelectedDriver = memorySelectedDriverFile.createNewFile();
        if(isCreatedSelectedDriver==true){
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memorySelectedDrivers.txt"));) {
                int num = 1;
                output.writeInt(num);
            } 
            catch (FileNotFoundException e) {
               e.printStackTrace();
            }
        }
        
        //create memory for selected iron, add value 1 if file created to have selected Basic Iron by default
        File memorySelectedIronFile =new File("memorySelectedIrons.txt");
        boolean isCreatedSelectedIron = memorySelectedIronFile.createNewFile();
        if(isCreatedSelectedIron==true){
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memorySelectedIrons.txt"));) {
                int num = 1;
                output.writeInt(num);
            } 
            catch (FileNotFoundException e) {
               e.printStackTrace();
            }
        }
        
        //create memory for selected putter, add value 1 if file created to have selected Basic Putter by default
        File memorySelectedPutterFile =new File("memorySelectedPutter.txt");
        boolean isCreatedSelectedPutter = memorySelectedPutterFile.createNewFile();
        if(isCreatedSelectedPutter==true){
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memorySelectedPutter.txt"));) {
                int num = 1;
                output.writeInt(num);
            }
            catch (FileNotFoundException e) {
               e.printStackTrace();
            }
        }
        
        
        Application.launch(args);
    }
    
    @Override //the start method in the Application class
    public void start(Stage primaryStage) throws Exception{
        
        Parent root=FXMLLoader.load(getClass().getResource("GolfMenu.fxml"));
        // Create a scene and place a button in the scene
        Scene scene = new Scene(root);
        primaryStage.setTitle("Golf Simulator"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    
}
