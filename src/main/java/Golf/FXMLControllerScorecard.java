/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Golf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Jerome Chabot
 */
public class FXMLControllerScorecard implements Initializable{
    
    @FXML private Button continueBt;
    @FXML private TextField distHole1;
    @FXML private TextField distHole2;
    @FXML private TextField distHole3;
    @FXML private TextField distHole4;
    @FXML private TextField distHole5;
    @FXML private TextField distHole6;
    @FXML private TextField distHole7;
    @FXML private TextField distHole8;
    @FXML private TextField distHole9;
    @FXML private TextField parHole1;
    @FXML private TextField parHole2;
    @FXML private TextField parHole3;
    @FXML private TextField parHole4;
    @FXML private TextField parHole5;
    @FXML private TextField parHole6;
    @FXML private TextField parHole7;
    @FXML private TextField parHole8;
    @FXML private TextField parHole9;
    @FXML private TextField ScoreParHole1;
    @FXML private TextField ScoreParHole2;
    @FXML private TextField ScoreParHole3;
    @FXML private TextField ScoreParHole4;
    @FXML private TextField ScoreParHole5;
    @FXML private TextField ScoreParHole6;
    @FXML private TextField ScoreParHole7;
    @FXML private TextField ScoreParHole8;
    @FXML private TextField ScoreParHole9;
    @FXML private TextField ScoreShotsHole1;
    @FXML private TextField ScoreShotsHole2;
    @FXML private TextField ScoreShotsHole3;
    @FXML private TextField ScoreShotsHole4;
    @FXML private TextField ScoreShotsHole5;
    @FXML private TextField ScoreShotsHole6;
    @FXML private TextField ScoreShotsHole7;
    @FXML private TextField ScoreShotsHole8;
    @FXML private TextField ScoreShotsHole9;
    @FXML private TextField ScoreParTotal;
    @FXML private TextField ScoreShotsTotal;
    int lastHole;
    File hole1Memory =new File("hole1.txt");
    File hole2Memory =new File("hole2.txt");
    File hole3Memory =new File("hole3.txt");
    File hole4Memory =new File("hole4.txt");
    File hole5Memory =new File("hole5.txt");
    File hole6Memory =new File("hole6.txt");
    File hole7Memory =new File("hole7.txt");
    File hole8Memory =new File("hole8.txt");
    File hole9Memory =new File("hole9.txt");
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        int hole1Shots=0;
        int hole2Shots=0;
        int hole3Shots=0;
        int hole4Shots=0;
        int hole5Shots=0;
        int hole6Shots=0;
        int hole7Shots=0;
        int hole8Shots=0;
        int hole9Shots=0;
        int hole1Par=0;
        int hole2Par=0;
        int hole3Par=0;
        int hole4Par=0;
        int hole5Par=0;
        int hole6Par=0;
        int hole7Par=0;
        int hole8Par=0;
        int hole9Par=0;
        lastHole=0;
        
        try{
            if(hole1Memory.exists()){
                hole1Shots = 0;
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("hole1.txt"));) {
                        while (input.available()>0) {
                            hole1Shots = input.readInt();
                        }
                }
                catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                ScoreShotsHole1.setText(Integer.toString(hole1Shots));
                ScoreParHole1.setText(Integer.toString(hole1Shots-4));
                hole1Par=hole1Shots-4;
                lastHole=1;
            }
            if(hole2Memory.exists()){
                hole2Shots = 0;
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("hole2.txt"));) {
                        while (input.available()>0) {
                            hole2Shots = input.readInt();
                        }
                }
                catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                ScoreShotsHole2.setText(Integer.toString(hole2Shots));
                ScoreParHole2.setText(Integer.toString(hole2Shots-5));
                hole2Par=hole2Shots-5;
                lastHole=2;
            }
            if(hole3Memory.exists()){
                hole3Shots = 0;
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("hole3.txt"));) {
                        while (input.available()>0) {
                            hole3Shots = input.readInt();
                        }
                }
                catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                ScoreShotsHole3.setText(Integer.toString(hole3Shots));
                ScoreParHole3.setText(Integer.toString(hole3Shots-3));
                hole3Par=hole3Shots-3;
                lastHole=3;
            }
            if(hole4Memory.exists()){
                hole4Shots = 0;
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("hole4.txt"));) {
                        while (input.available()>0) {
                            hole4Shots = input.readInt();
                        }
                }
                catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                ScoreShotsHole4.setText(Integer.toString(hole4Shots));
                ScoreParHole4.setText(Integer.toString(hole4Shots-4));
                hole4Par=hole4Shots-4;
                lastHole=4;
            }
            if(hole5Memory.exists()){
                hole5Shots = 0;
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("hole5.txt"));) {
                        while (input.available()>0) {
                            hole5Shots = input.readInt();
                        }
                }
                catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                ScoreShotsHole5.setText(Integer.toString(hole5Shots));
                ScoreParHole5.setText(Integer.toString(hole5Shots-5));
                hole5Par=hole5Shots-5;
                lastHole=5;
            }
            if(hole6Memory.exists()){
                hole6Shots = 0;
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("hole6.txt"));) {
                        while (input.available()>0) {
                            hole6Shots = input.readInt();
                        }
                }
                catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                ScoreShotsHole6.setText(Integer.toString(hole6Shots));
                ScoreParHole6.setText(Integer.toString(hole6Shots-5));
                hole6Par=hole6Shots-5;
                lastHole=6;
            }
            if(hole7Memory.exists()){
                hole7Shots = 0;
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("hole7.txt"));) {
                        while (input.available()>0) {
                            hole7Shots = input.readInt();
                        }
                }
                catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                ScoreShotsHole7.setText(Integer.toString(hole7Shots));
                ScoreParHole7.setText(Integer.toString(hole7Shots-4));
                hole7Par=hole7Shots-4;
                lastHole=7;
            }
            if(hole8Memory.exists()){
                hole8Shots = 0;
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("hole8.txt"));) {
                        while (input.available()>0) {
                            hole8Shots = input.readInt();
                        }
                }
                catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                ScoreShotsHole8.setText(Integer.toString(hole8Shots));
                ScoreParHole8.setText(Integer.toString(hole8Shots-4));
                hole8Par=hole8Shots-4;
                lastHole=8;
            }
            if(hole9Memory.exists()){
                hole9Shots = 0;
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("hole9.txt"));) {
                        while (input.available()>0) {
                            hole9Shots = input.readInt();
                        }
                }
                catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                ScoreShotsHole9.setText(Integer.toString(hole9Shots));
                ScoreParHole9.setText(Integer.toString(hole9Shots-3));
                hole9Par=hole9Shots-3;
                lastHole=9;
            }
            int total=hole1Shots+hole2Shots+hole3Shots+hole4Shots+hole5Shots+hole6Shots+hole7Shots+hole8Shots+hole9Shots;
            int totalWithPar=hole1Par+hole2Par+hole3Par+hole4Par+hole5Par+hole6Par+hole7Par+hole8Par+hole9Par;
            ScoreParTotal.setText(Integer.toString(totalWithPar));
            ScoreShotsTotal.setText(Integer.toString(total));
            
        }
        catch(IOException e){
            
        }
        
        
    }
    
    public void onClickContinue(ActionEvent actionEvent) throws IOException{
        if(hole9Memory.exists()){
            Parent GUI = FXMLLoader.load(getClass().getResource("GolfMenu.fxml"));
            Scene scene = new Scene(GUI);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else{
            StringBuilder sb=new StringBuilder();
            sb.append("Hole");
            sb.append(Integer.toString((lastHole+1)));
            sb.append(".fxml");
            Parent GUI = FXMLLoader.load(getClass().getResource(sb.toString()));
            Scene scene = new Scene(GUI);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
    
    
    
    
    
    
}
