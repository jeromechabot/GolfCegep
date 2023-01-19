/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Golf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jerome Chabot
 */
public class FXMLControllerCustomizeIrons implements Initializable{
    
    @FXML private Button basicBt;
    @FXML private Button superBt;
    @FXML private Button advancedBt;
    @FXML private Button proBt;
    @FXML private Button athleteBt;
    @FXML private Button ultimateBt;
    @FXML private Button backBt;
    @FXML private Text onwedBasicTxt;
    @FXML private Text onwedSuperTxt;
    @FXML private Text onwedAdvancedTxt;
    @FXML private Text onwedProTxt;
    @FXML private Text onwedAthleteTxt;
    @FXML private Text onwedUltimateTxt;
    @FXML private Text lockedBasicTxt;
    @FXML private Text lockedSuperTxt;
    @FXML private Text lockedAdvancedTxt;
    @FXML private Text lockedProTxt;
    @FXML private Text lockedAthleteTxt;
    @FXML private Text lockedUltimateTxt;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        int numberOfIrons=0;
        try{
            numberOfIrons=getMemoryIronsContent();
        }
        catch(IOException e){
            
        }
        
        int selectedIron=0;
        try{
            selectedIron=getMemorySelectedIronContent();
        }
        catch(IOException e){
            
        }
        
        switch(numberOfIrons){
            case 1: //player only owns basic irons
                lockedBasicTxt.setVisible(false);
                onwedSuperTxt.setVisible(false);
                onwedAdvancedTxt.setVisible(false);
                onwedProTxt.setVisible(false);
                onwedAthleteTxt.setVisible(false);
                onwedUltimateTxt.setVisible(false);
                superBt.setDisable(true);
                advancedBt.setDisable(true);
                proBt.setDisable(true);
                athleteBt.setDisable(true);
                ultimateBt.setDisable(true);
                break;
            case 2: //player owns basic & super irons
                lockedBasicTxt.setVisible(false);
                lockedSuperTxt.setVisible(false);
                onwedAdvancedTxt.setVisible(false);
                onwedProTxt.setVisible(false);
                onwedAthleteTxt.setVisible(false);
                onwedUltimateTxt.setVisible(false);
                advancedBt.setDisable(true);
                proBt.setDisable(true);
                athleteBt.setDisable(true);
                ultimateBt.setDisable(true);
                break;
            case 3: //player owns 3 first irons
                lockedBasicTxt.setVisible(false);
                lockedSuperTxt.setVisible(false);
                lockedAdvancedTxt.setVisible(false);
                onwedProTxt.setVisible(false);
                onwedAthleteTxt.setVisible(false);
                onwedUltimateTxt.setVisible(false);
                proBt.setDisable(true);
                athleteBt.setDisable(true);
                ultimateBt.setDisable(true);
                break;
            case 4: //player owns 4 first irons
                lockedBasicTxt.setVisible(false);
                lockedSuperTxt.setVisible(false);
                lockedAdvancedTxt.setVisible(false);
                lockedProTxt.setVisible(false);
                onwedAthleteTxt.setVisible(false);
                onwedUltimateTxt.setVisible(false);
                athleteBt.setDisable(true);
                ultimateBt.setDisable(true);
                break;
            case 5: //player owns 5 first irons
                lockedBasicTxt.setVisible(false);
                lockedSuperTxt.setVisible(false);
                lockedAdvancedTxt.setVisible(false);
                lockedProTxt.setVisible(false);
                lockedAthleteTxt.setVisible(false);
                onwedUltimateTxt.setVisible(false);
                ultimateBt.setDisable(true);
                break;
            case 6: //player owns all irons
                lockedBasicTxt.setVisible(false);
                lockedSuperTxt.setVisible(false);
                lockedAdvancedTxt.setVisible(false);
                lockedProTxt.setVisible(false);
                lockedAthleteTxt.setVisible(false);
                lockedUltimateTxt.setVisible(false);
                break;
        }
        
        switch(selectedIron){
            case 1: basicBt.setStyle("-fx-border-color: black;" + "-fx-border-width: 3;" + "-fx-background-color: yellow;"); break;
            case 2: superBt.setStyle("-fx-border-color: black;" + "-fx-border-width: 3;" + "-fx-background-color: #76ff03;"); break;
            case 3: advancedBt.setStyle("-fx-border-color: black;" + "-fx-border-width: 3;" + "-fx-background-color: #00e5ff;"); break;
            case 4: proBt.setStyle("-fx-border-color: black;" + "-fx-border-width: 3;" + "-fx-background-color: #d500f9;"); break;
            case 5: athleteBt.setStyle("-fx-border-color: black;" + "-fx-border-width: 3;" + "-fx-background-color: #ffab00;"); break;
            case 6: ultimateBt.setStyle("-fx-border-color: black;" + "-fx-border-width: 3;" + "-fx-background-color: #e53935;"); break;
        }
    }
    
    public int getMemoryIronsContent() throws IOException{
        
        int fileContent=0;
        
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("memoryIrons.txt"));) {
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
    
    public void onClickBasic(ActionEvent actionEvent) throws IOException{
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memorySelectedIron.txt"));) {
            int num = 1;
            output.writeInt(num);
        } 
        catch (FileNotFoundException e) {
           e.printStackTrace();
        }
        basicBt.setStyle("-fx-border-color: black;" + "-fx-border-width: 3;" + "-fx-background-color: yellow;");
        superBt.setStyle(null);
        advancedBt.setStyle(null);
        proBt.setStyle(null);
        athleteBt.setStyle(null);
        ultimateBt.setStyle(null);
    }
    
    public void onClickSuper(ActionEvent actionEvent) throws IOException{
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memorySelectedIron.txt"));) {
            int num = 2;
            output.writeInt(num);
        } 
        catch (FileNotFoundException e) {
           e.printStackTrace();
        }
        basicBt.setStyle(null);
        superBt.setStyle("-fx-border-color: black;" + "-fx-border-width: 3;" + "-fx-background-color: #76ff03;");
        advancedBt.setStyle(null);
        proBt.setStyle(null);
        athleteBt.setStyle(null);
        ultimateBt.setStyle(null);
    }
    
    public void onClickAdvanced(ActionEvent actionEvent) throws IOException{
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memorySelectedIron.txt"));) {
            int num = 3;
            output.writeInt(num);
        } 
        catch (FileNotFoundException e) {
           e.printStackTrace();
        }
        basicBt.setStyle(null);
        superBt.setStyle(null);
        advancedBt.setStyle("-fx-border-color: black;" + "-fx-border-width: 3;" + "-fx-background-color: #00e5ff;");
        proBt.setStyle(null);
        athleteBt.setStyle(null);
        ultimateBt.setStyle(null);
    }
    
    public void onClickPro(ActionEvent actionEvent) throws IOException{
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memorySelectedIron.txt"));) {
            int num = 4;
            output.writeInt(num);
        } 
        catch (FileNotFoundException e) {
           e.printStackTrace();
        }
        basicBt.setStyle(null);
        superBt.setStyle(null);
        advancedBt.setStyle(null);
        proBt.setStyle("-fx-border-color: black;" + "-fx-border-width: 3;" + "-fx-background-color: #d500f9;");
        athleteBt.setStyle(null);
        ultimateBt.setStyle(null);
    }
    
    public void onClickAthlete(ActionEvent actionEvent) throws IOException{
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memorySelectedIron.txt"));) {
            int num = 5;
            output.writeInt(num);
        } 
        catch (FileNotFoundException e) {
           e.printStackTrace();
        }
        basicBt.setStyle(null);
        superBt.setStyle(null);
        advancedBt.setStyle(null);
        proBt.setStyle(null);
        athleteBt.setStyle("-fx-border-color: black;" + "-fx-border-width: 3;" + "-fx-background-color: #ffab00;");
        ultimateBt.setStyle(null);
    }
    
    public void onClickUltimate(ActionEvent actionEvent) throws IOException{
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memorySelectedIron.txt"));) {
            int num = 6;
            output.writeInt(num);
        } 
        catch (FileNotFoundException e) {
           e.printStackTrace();
        }
        basicBt.setStyle(null);
        superBt.setStyle(null);
        advancedBt.setStyle(null);
        proBt.setStyle(null);
        athleteBt.setStyle(null);
        ultimateBt.setStyle("-fx-border-color: black;" + "-fx-border-width: 3;" + "-fx-background-color: #e53935;");
    }
    
    
    public void onClickBack(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("CustomizeMenu.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
}
