/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Golf;

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
public class FXMLControllerMainMenu {
    
    @FXML private Button playBt;
    @FXML private Button shopBt;
    @FXML private Button customizeBt;
    @FXML private Button exitBt;
    
    public void onClickPlay(ActionEvent actionEvent) throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("PlayMenu.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickShop(ActionEvent actionEvent)throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("ShopMenu.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickCustomize(ActionEvent actionEvent)throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("CustomizeMenu.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickExit(){
        Stage stage = (Stage) exitBt.getScene().getWindow();
        stage.close();
    }
    
    
}
