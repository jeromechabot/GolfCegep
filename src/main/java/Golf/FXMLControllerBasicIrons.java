/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Golf;

import java.io.File;
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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Jerome Chabot
 */
public class FXMLControllerBasicIrons implements Initializable{
    
    File bankFile =new File("bank.txt");
    @FXML private TextField maxCarry4IronTF;
    @FXML private TextField maxCarry5IronTF;
    @FXML private TextField maxCarry6IronTF;
    @FXML private TextField maxCarry7IronTF;
    @FXML private TextField maxCarry8IronTF;
    @FXML private TextField maxCarry9IronTF;
    @FXML private TextField maxCarryPitchingWedgeTF;
    @FXML private TextField maxCarrySandWedgeTF;
    @FXML private TextField precision4IronTF;
    @FXML private TextField precision5IronTF;
    @FXML private TextField precision6IronTF;
    @FXML private TextField precision7IronTF;
    @FXML private TextField precision8IronTF;
    @FXML private TextField precision9IronTF;
    @FXML private TextField precisionPitchingWedgeTF;
    @FXML private TextField precisionSandWedgeTF;
    @FXML private TextField bankTF;
    @FXML private TextField costTF;
    @FXML private TextField remainingAfterTF;
    @FXML private Button buyBt;
    @FXML private Button backBt;
    int remainingAfter;
    int cost;
    int bankValue;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        bankTF.setEditable(false);
        costTF.setEditable(false);
        remainingAfterTF.setEditable(false);
        maxCarry4IronTF.setEditable(false);
        maxCarry5IronTF.setEditable(false);
        maxCarry6IronTF.setEditable(false);
        maxCarry7IronTF.setEditable(false);
        maxCarry8IronTF.setEditable(false);
        maxCarry9IronTF.setEditable(false);
        maxCarryPitchingWedgeTF.setEditable(false);
        maxCarrySandWedgeTF.setEditable(false);
        precision4IronTF.setEditable(false);
        precision5IronTF.setEditable(false);
        precision6IronTF.setEditable(false);
        precision7IronTF.setEditable(false);
        precision8IronTF.setEditable(false);
        precision9IronTF.setEditable(false);
        precisionPitchingWedgeTF.setEditable(false);
        precisionSandWedgeTF.setEditable(false);

        
        maxCarry4IronTF.setText("180 yards");
        maxCarry5IronTF.setText("170 yards");
        maxCarry6IronTF.setText("160 yards");
        maxCarry7IronTF.setText("150 yards");
        maxCarry8IronTF.setText("140 yards");
        maxCarry9IronTF.setText("130 yards");
        maxCarryPitchingWedgeTF.setText("120 yards");
        maxCarrySandWedgeTF.setText("100 yards");
        precision4IronTF.setText("10%");
        precision5IronTF.setText("15%");
        precision6IronTF.setText("20");
        precision7IronTF.setText("25%");
        precision8IronTF.setText("30%");
        precision9IronTF.setText("35%");
        precisionPitchingWedgeTF.setText("40%");
        precisionSandWedgeTF.setText("45%");
        
        //get content of bank file
        bankValue=0;
        try{
            bankValue=getBankContent();
        }
        
        catch(IOException e){
            
        }
        bankTF.setText(Integer.toString(bankValue)+"$");
        
        //Value we predefined for Basic Clubs
        cost=0;
        costTF.setText(Integer.toString(cost)+"$");
        
        remainingAfter=bankValue-cost;
        remainingAfterTF.setText(Integer.toString(remainingAfter)+"$");
        
        if(remainingAfter < 0){
            remainingAfterTF.setStyle("-fx-text-fill: red;");
            buyBt.setDisable(true);
        }
        
        //Disable Button if owned
        int numberOfIrons=0;
        try{
            numberOfIrons=getMemoryIronsContent();
        }
        catch(IOException e){
            
        }
        if(numberOfIrons>=1){
            buyBt.setDisable(true);
        }
        
        bankTF.setAlignment(Pos.CENTER);
        costTF.setAlignment(Pos.CENTER);
        remainingAfterTF.setAlignment(Pos.CENTER);
        maxCarry4IronTF.setAlignment(Pos.CENTER);
        maxCarry5IronTF.setAlignment(Pos.CENTER);
        maxCarry6IronTF.setAlignment(Pos.CENTER);
        maxCarry7IronTF.setAlignment(Pos.CENTER);
        maxCarry8IronTF.setAlignment(Pos.CENTER);
        maxCarry9IronTF.setAlignment(Pos.CENTER);
        maxCarryPitchingWedgeTF.setAlignment(Pos.CENTER);
        maxCarrySandWedgeTF.setAlignment(Pos.CENTER);
        precision4IronTF.setAlignment(Pos.CENTER);
        precision5IronTF.setAlignment(Pos.CENTER);
        precision6IronTF.setAlignment(Pos.CENTER);
        precision7IronTF.setAlignment(Pos.CENTER);
        precision8IronTF.setAlignment(Pos.CENTER);
        precision9IronTF.setAlignment(Pos.CENTER);
        precisionPitchingWedgeTF.setAlignment(Pos.CENTER);
        precisionSandWedgeTF.setAlignment(Pos.CENTER);
    }
    
    public int getBankContent() throws IOException{
        
        int fileContent=0;
        if (bankFile.length()!=0){
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("bank.txt"));) {
                while (input.available()>0) {
                       int temp = input.readInt();
                       fileContent+=temp;
                }
            }
        }
        return fileContent;
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
    
    public void onClickBuy() throws IOException{
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memoryIrons.txt"));) {
            int num=1;
            output.writeInt(num);
        } 
        catch (FileNotFoundException e) {
               e.printStackTrace();
        }
        buyBt.setDisable(true);
        
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("bank.txt"));) {
            int num=remainingAfter;
            output.writeInt(num);
        } 
        catch (FileNotFoundException e) {
               e.printStackTrace();
        }
        
        bankTF.setText(Integer.toString(remainingAfter)+"$");
        remainingAfter=remainingAfter-cost;
        remainingAfterTF.setText(Integer.toString(remainingAfter)+"$");
    }
    
    
    
    
    public void onClickBack(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("ShopIrons.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
}
