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
public class FXMLControllerAdvancedPutter implements Initializable{
    
    File bankFile =new File("bank.txt");
    @FXML private TextField precisionPutterTF;
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
        precisionPutterTF.setEditable(false);
        
        precisionPutterTF.setText("70%");
        
        //get content of bank file
        bankValue=0;
        try{
            bankValue=getBankContent();
        }
        
        catch(IOException e){
            
        }
        bankTF.setText(Integer.toString(bankValue)+"$");
        
        //Value we predefined for Advanced Clubs
        cost=20;
        costTF.setText(Integer.toString(cost)+"$");
        
        remainingAfter=bankValue-cost;
        remainingAfterTF.setText(Integer.toString(remainingAfter)+"$");
        
        if(remainingAfter < 0){
            remainingAfterTF.setStyle("-fx-text-fill: red;");
            buyBt.setDisable(true);
        }
        
        //Disable Button if owned
        int numberOfPutters=0;
        try{
            numberOfPutters=getMemoryPuttersContent();
        }
        catch(IOException e){
            
        }
        if(numberOfPutters>=3){
            buyBt.setDisable(true);
        }
        
        bankTF.setAlignment(Pos.CENTER);
        costTF.setAlignment(Pos.CENTER);
        remainingAfterTF.setAlignment(Pos.CENTER);
        precisionPutterTF.setAlignment(Pos.CENTER);
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
    
    public int getMemoryPuttersContent() throws IOException{
        int fileContent=0;
        
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("memoryPutters.txt"));) {
            while (input.available()>0) {
                int temp = input.readInt();
                fileContent+=temp;
            }
        }
        return fileContent;
    }
    
    public void onClickBuy() throws IOException{
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("memoryPutters.txt"));) {
            int num=3;
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
        Parent GUI = FXMLLoader.load(getClass().getResource("ShopPutters.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
}
