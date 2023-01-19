/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Golf;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author jayja
 */
public class FXMLControllerCustomizeMenu {
    
    @FXML private Button driversBt;
    @FXML private Button ironsBt;
    @FXML private Button puttersBt;
    @FXML private Button backBt;
    
    public void onClickDrivers(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("CustomizeDrivers.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickIrons(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("CustomizeIrons.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickPutters(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("CustomizePutters.fxml"));
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