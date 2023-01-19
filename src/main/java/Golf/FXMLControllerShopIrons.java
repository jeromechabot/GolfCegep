/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Golf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class FXMLControllerShopIrons implements Initializable{
    
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
        
        switch(numberOfIrons){
            case 1: //player only owns basic Irons
                lockedBasicTxt.setVisible(false);
                onwedSuperTxt.setVisible(false);
                lockedSuperTxt.setVisible(false);
                onwedAdvancedTxt.setVisible(false);
                onwedProTxt.setVisible(false);
                onwedAthleteTxt.setVisible(false);
                onwedUltimateTxt.setVisible(false);
                break;
            case 2: //player owns basic & super Irons
                lockedBasicTxt.setVisible(false);
                lockedSuperTxt.setVisible(false);
                onwedAdvancedTxt.setVisible(false);
                lockedAdvancedTxt.setVisible(false);
                onwedProTxt.setVisible(false);
                onwedAthleteTxt.setVisible(false);
                onwedUltimateTxt.setVisible(false);
                break;
            case 3: //player owns 3 first Irons
                lockedBasicTxt.setVisible(false);
                lockedSuperTxt.setVisible(false);
                lockedAdvancedTxt.setVisible(false);
                onwedProTxt.setVisible(false);
                lockedProTxt.setVisible(false);
                onwedAthleteTxt.setVisible(false);
                onwedUltimateTxt.setVisible(false);
                break;
            case 4: //player owns 4 first Irons
                lockedBasicTxt.setVisible(false);
                lockedSuperTxt.setVisible(false);
                lockedAdvancedTxt.setVisible(false);
                lockedProTxt.setVisible(false);
                onwedAthleteTxt.setVisible(false);
                lockedAthleteTxt.setVisible(false);
                onwedUltimateTxt.setVisible(false);
                break;
            case 5: //player owns 5 first Irons
                lockedBasicTxt.setVisible(false);
                lockedSuperTxt.setVisible(false);
                lockedAdvancedTxt.setVisible(false);
                lockedProTxt.setVisible(false);
                lockedAthleteTxt.setVisible(false);
                onwedUltimateTxt.setVisible(false);
                lockedUltimateTxt.setVisible(false);
                break;
            case 6: //player owns all Irons
                lockedBasicTxt.setVisible(false);
                lockedSuperTxt.setVisible(false);
                lockedAdvancedTxt.setVisible(false);
                lockedProTxt.setVisible(false);
                lockedAthleteTxt.setVisible(false);
                lockedUltimateTxt.setVisible(false);
                break;
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
    
    public void onClickBasic(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("BasicIrons.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickSuper(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("SuperIrons.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickAdvanced(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("AdvancedIrons.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickPro(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("ProIrons.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickAthlete(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("AthleteIrons.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickUltimate(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("UltimateIrons.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    public void onClickBack(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("ShopMenu.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
}
