/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Golf;

import java.io.File;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Jerome Chabot
 */
public class FXMLControllerPlayMenu {
    
    @FXML private Button golfBt;
    @FXML private Button drivingRangeBt;
    @FXML private Button tutorialBt;
    @FXML private Button backBt;
    
    public void onClickGolf(ActionEvent actionEvent) throws IOException{
        File hole1Memory =new File("hole1.txt");
        File hole2Memory =new File("hole2.txt");
        File hole3Memory =new File("hole3.txt");
        File hole4Memory =new File("hole4.txt");
        File hole5Memory =new File("hole5.txt");
        File hole6Memory =new File("hole6.txt");
        File hole7Memory =new File("hole7.txt");
        File hole8Memory =new File("hole8.txt");
        File hole9Memory =new File("hole9.txt");
        boolean deleteHole1=hole1Memory.delete();
        boolean deleteHole2=hole2Memory.delete();
        boolean deleteHole3=hole3Memory.delete();
        boolean deleteHole4=hole4Memory.delete();
        boolean deleteHole5=hole5Memory.delete();
        boolean deleteHole6=hole6Memory.delete();
        boolean deleteHole7=hole7Memory.delete();
        boolean deleteHole8=hole8Memory.delete();
        boolean deleteHole9=hole9Memory.delete();
        
        Parent GUI = FXMLLoader.load(getClass().getResource("Hole1.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }
    
    public void onClickDrivingRange(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("DrivingRange.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickTutorial(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("Tutorial1.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    public void onClickBack(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("GolfMenu.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
}
