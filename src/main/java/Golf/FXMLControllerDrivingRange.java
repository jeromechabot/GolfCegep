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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.text.Text;
import javafx.stage.Stage;





public class FXMLControllerDrivingRange implements Initializable   {
    public double angle, windAngle, windPower, angleDifWind, power, accuracy;
    public double initialX, initialY, endX, endY, distanceX, finalX, finalY, endCurveX, endCurveY, controlX, controlY, powerDetStartX, powerDetStartY, powerDetEndX, powerDetEndY, accuracyDetStartX, accuracyDetStartY, accuracyDetEndX, accuracyDetEndY;
    boolean goodForShot;
    TranslateTransition accuracypt, powerpt;
    PathTransition shotpt;
    Arc shotAttempt;
    @FXML Circle circle;
    Rectangle powerGauge, accuracyGauge;
    @FXML Rectangle powerDet; 
    @FXML Rectangle accuracyDet;
    @FXML Pane pane;
    @FXML Pane grass;
    Line accuracyLine, powerLine;
    ExecutorService executor;
    @FXML Line previewLine;
    @FXML MenuButton clubSelection;
    @FXML Text activeClubDisplay;
    @FXML Text windPowerDisplay;
    @FXML MenuItem menuItemDriver;
    @FXML MenuItem menuItem3Wood;
    @FXML MenuItem menuItem4Iron;
    @FXML MenuItem menuItem5Iron;
    @FXML MenuItem menuItem6Iron;
    @FXML MenuItem menuItem7Iron;
    @FXML MenuItem menuItem8Iron;
    @FXML MenuItem menuItem9Iron;
    @FXML MenuItem menuItemPitchingWedge;
    @FXML MenuItem menuItemSandWedge;
    @FXML MenuItem menuItemPutter;
    ArrayList <GolfClub> golfBag=new ArrayList<GolfClub>();
    GolfClub activeClub;
    Rotate rotate;
    Point2D powerStart, powerEnd, accuracyStart, accuracyEnd;
    @FXML ImageView windArrow;
    QuadCurve attemptLine;
    ScaleTransition st;
    @FXML Button nextShotBt;
    @FXML Pane powerPane;
    @FXML Pane accuracyPane;
    Stage primaryStage;
    double maxCarry;
    long time;
    
    
    
    
    
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        
////        Parent root=FXMLLoader.load(getClass().getResource("DrivingRange.fxml"));
//        // Create a scene and place a button in the scene
//        Scene scene = new Scene(powerPane);
//        primaryStage.setTitle("Golf Simulator"); // Set the stage title
//        primaryStage.setScene(scene); // Place the scene in the stage
//        primaryStage.show(); // Display the stage
//    }
    
 @Override // Override the start method in the Application class

    public void initialize(URL url, ResourceBundle rb){
        System.out.println("Initialized");
        
        
        try{
            setGolfBag();
        }
        catch(IOException e){
            
        }
        
        activeClub=golfBag.get(0);
        activeClubDisplay.setText("Selected Club: Driver");

        menuItemDriver.setOnAction(event -> {
            activeClubDisplay.setText("Selected Club: Driver");
            activeClub=golfBag.get(0);
            maxCarry=activeClub.maxCarry;
            endX= initialX+maxCarry*2;
            previewLine.setEndX(endX);
        });
        
        menuItem3Wood.setOnAction(event -> {
            activeClubDisplay.setText("Selected Club: 3 Wood");
            activeClub=golfBag.get(1);
            maxCarry=activeClub.maxCarry;
            endX= initialX+maxCarry*2;
            previewLine.setEndX(endX);
        });
        
        menuItem4Iron.setOnAction(event -> {
            activeClubDisplay.setText("Selected Club: 4 Iron");
            activeClub=golfBag.get(2);
            maxCarry=activeClub.maxCarry;
            endX= initialX+maxCarry*2;
            previewLine.setEndX(endX);
        });
        
        menuItem5Iron.setOnAction(event -> {
            activeClubDisplay.setText("Selected Club: 5 Iron");
            activeClub=golfBag.get(3);
            maxCarry=activeClub.maxCarry;
            endX= initialX+maxCarry*2;
            previewLine.setEndX(endX);
        });
        
        menuItem6Iron.setOnAction(event -> {
            activeClubDisplay.setText("Selected Club: 6 Iron");
            activeClub=golfBag.get(4);
            maxCarry=activeClub.maxCarry;
            endX= initialX+maxCarry*2;
            previewLine.setEndX(endX);
        });
        
        menuItem7Iron.setOnAction(event -> {
            activeClubDisplay.setText("Selected Club: 7 Iron");
            activeClub=golfBag.get(5);
            maxCarry=activeClub.maxCarry;
            endX= initialX+maxCarry*2;
            previewLine.setEndX(endX);
        });
        
        menuItem8Iron.setOnAction(event -> {
            activeClubDisplay.setText("Selected Club: 8 Iron");
            activeClub=golfBag.get(6);
            maxCarry=activeClub.maxCarry;
            endX= initialX+maxCarry*2;
            previewLine.setEndX(endX);
        });
        
        menuItem9Iron.setOnAction(event -> {
            activeClubDisplay.setText("Selected Club: 9 Iron");
            activeClub=golfBag.get(7);
            maxCarry=activeClub.maxCarry;
            endX= initialX+maxCarry*2;
            previewLine.setEndX(endX);
        });
        
        menuItemPitchingWedge.setOnAction(event -> {
            activeClubDisplay.setText("Selected Club: Pitching Wedge");
            activeClub=golfBag.get(8);
            maxCarry=activeClub.maxCarry;
            endX= initialX+maxCarry*2;
            previewLine.setEndX(endX);
        });
        
        menuItemSandWedge.setOnAction(event -> {
            activeClubDisplay.setText("Selected Club: Sand Wedge");
            activeClub=golfBag.get(9);
            maxCarry=activeClub.maxCarry;
            endX= initialX+maxCarry*2;
            previewLine.setEndX(endX);
        });
        
        menuItemPutter.setOnAction(event -> {
            activeClubDisplay.setText("Selected Club: Putter");
            activeClub=golfBag.get(10);
            maxCarry=activeClub.maxCarry;
            endX= initialX+maxCarry*2;
            previewLine.setEndX(endX);
        });
        
        maxCarry=activeClub.maxCarry;
        goodForShot = false;
        nextShotBt.setVisible(false);
        angle = 0;
        initialX = 260;
        initialY= 370;
        endX= initialX+maxCarry*2;
        endY= 370;
        previewLine.setEndX(endX);
        controlX=0;
        controlY=0;
        powerDetStartX=0;
        powerDetStartY=720;
        powerDetEndX=250;
        powerDetEndY=720;
        accuracyDetStartX=20;
        accuracyDetStartY=0;
        accuracyDetEndX=20;
        accuracyDetEndY=300;
    //    pane = new Pane();
        rotate = new Rotate();
        rotate.setPivotX(initialX);
        rotate.setPivotY(initialY);

        setWindOrientation();
        setWindPower();

    //    previewLine = new Line(initialX, initialY, endX, endY);
        previewLine.getTransforms().addAll(rotate);
        previewLine.setStroke(Color.BLACK);
    //    pane.getChildren().addAll(previewLine);

        attemptLine = new QuadCurve(initialX, initialY, controlX, controlY, endX, endY);
        attemptLine.setStroke(Color.TRANSPARENT);
        attemptLine.setFill(Color.TRANSPARENT);
        pane.getChildren().addAll(attemptLine);
        


        powerLine = new Line(60, 735, 200, 735);
        powerLine.setStroke(Color.BLANCHEDALMOND);
        accuracyLine = new Line(35, 750, 35, 600);
        accuracyLine.setStroke(Color.CORNFLOWERBLUE);




        powerGauge= new Rectangle(powerDetStartX, powerDetStartY, 150, 30);
        powerGauge.setFill(Color.GREY);
        powerGauge.setStroke(Color.GREY);
        accuracyGauge = new Rectangle(20, 600, 30, 150);
        accuracyGauge.setFill(Color.BLACK);
        accuracyGauge.setStroke(Color.BLACK);

    //    powerDet= new Rectangle(powerDetStartX, powerDetStartY, 10, 30);
    //    powerDet.setFill(Color.CYAN);
    //    powerDet.setStroke(Color.CYAN);
    //    accuracyDet = new Rectangle(20, 600, 30, 10);
    //    accuracyDet.setFill(Color.AQUAMARINE);
    //    accuracyDet.setStroke(Color.AQUAMARINE);

        shotpt = new PathTransition();
        accuracypt = new TranslateTransition();
        powerpt = new TranslateTransition();
    //    pane.getChildren().remove(ReadyBt);
    
        
    
    }

@FXML public void onScroll(){
        pane.setOnScroll(new EventHandler<ScrollEvent>() {
        boolean status=true;
        @Override
        public void handle(ScrollEvent event) {
            if(status){
        if (!event.isInertia()) {
          rotate.setAngle(rotate.getAngle() - event.getDeltaY()/53.6);
          angle = rotate.getAngle();
        System.out.println(rotate.getAngle());
        
        }}
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent me) {
        System.out.println("Mouse entered");
        if(status){
            status=false;
            goodForShot=true;
            
        }
        if(goodForShot==true){
            launchPowerGauge1();
        }
        }
        
        });
        
        event.consume();
      }
        
    });
        
    }

        public void setScaleTransition(){
            st = new ScaleTransition(Duration.millis(time/2), circle);
            //a putter shot will roll and not go in the air
            if(!activeClub.equals(golfBag.get(10))){
                //top value will be doubling the size of the ball
                st.setByX(power);
                st.setByY(power);
                st.setCycleCount(2);
                st.setAutoReverse(true);
            }
            else{
                st.setByX(0);
                st.setByY(0);
                st.setCycleCount(2);
                st.setAutoReverse(true);
            }
            
        }
    @FXML public void launchAnimation(){
        
        attemptLine.setStroke(Color.AQUA);
        attemptLine.setFill(Color.AQUA);
            System.out.println("Accuracy Upon Animation"+ accuracy);
            angle=angle+accuracy;
            distanceX=power*(endX-initialX);
            finalX = initialX+(Math.cos(Math.toRadians(angle))*distanceX);
            finalY = initialY+(Math.sin(Math.toRadians(angle))*distanceX);
            controlX=initialX+((finalX-initialX)/2);
            controlY=initialY+((finalY-initialY)/2);
            endCurveX=getPositionXWithWind(windPower, distanceX, windAngle, angle);
            endCurveY=getPositionYWithWind(windPower, distanceX, windAngle, angle);
            attemptLine.setStartX(initialX);
            attemptLine.setStartY(initialY);
            attemptLine.setControlX(controlX);
            attemptLine.setControlY(controlY);
            attemptLine.setEndX(endCurveX);
            attemptLine.setEndY(endCurveY);

            setScaleTransition();

            previewLine.setStroke(Color.TRANSPARENT);
//            pane.getChildren().addAll(attemptLine);
            shotpt.setDuration(Duration.millis(time));
            shotpt.setPath(attemptLine);
            shotpt.setNode(circle);
            shotpt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            shotpt.setCycleCount(1);
            shotpt.setAutoReverse(false);
//            shotpt.setOnFinished(new EventHandler<ActionEvent>(){
//                @Override
//                public void handle(ActionEvent ae){
//                    pane.getChildren().remove(circle);
//                }
//            });
            shotpt.play();
            st.play();
            nextShotBt.setVisible(true);
            
            
        
        
}
  @FXML public void launchPowerGauge1(){
//      pane.getChildren().addAll(powerGauge, powerDet);
        
        powerpt.setDuration(Duration.millis(1200));
      powerpt.setByX(250);
      powerpt.setNode(powerDet);
      powerpt.setCycleCount(Timeline.INDEFINITE);
      powerpt.setAutoReverse(true);
      powerStart = powerDet.localToParent(powerDetStartX, powerDetStartY);
      powerEnd = powerDet.localToParent(powerDetEndX, powerDetEndY);
      powerpt.play();
      
      pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
        boolean status=true;
        @Override
        public void handle(MouseEvent me) {
        System.out.println("Mouse entered");
        if(status){
            status=false;
            powerpt.stop();
            power = (powerStart.distance(powerEnd)-powerDet.getTranslateX());
            if(power>=230&&power<=250){
                power=1;
            }
            else{
                power=power/230;
            }
            System.out.println("Power = "+ power);
            time=(long)(6500*power);
            goodForShot=true;
            
        }
        if(goodForShot==true){
            
              Platform.runLater(new Runnable(){
              @Override
              public void run(){
                  try {
                      Thread.sleep(1000);
                      launchAccuracyGauge2();
                      
                  } catch (InterruptedException ex) {
                  }
                  
              }
              });
              
            
        }
        }
      
  });
}
  @FXML public void launchAccuracyGauge2(){
//      pane.getChildren().addAll(accuracyGauge, accuracyDet);
      accuracypt.setDuration(Duration.millis(1500));
      accuracypt.setByY(300);
      accuracypt.setNode(accuracyDet);
      accuracypt.setCycleCount(Timeline.INDEFINITE);
      accuracypt.setAutoReverse(true);
      accuracyStart = accuracyDet.localToParent(accuracyDetStartX, accuracyDetStartY);
      accuracyEnd = accuracyDet.localToParent(accuracyDetEndX, accuracyDetEndY);
      accuracypt.play();
      
      pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
        boolean status=true; 
        int temp;
        @Override
        public void handle(MouseEvent me) {
        System.out.println("Mouse entered");
        if(status){
            status=false;
            accuracypt.stop();
            accuracy = (accuracyStart.distance(accuracyEnd)-accuracyDet.getTranslateY());
            accuracy=300-accuracy;
            
            if(accuracy>=0&&accuracy<35){
                temp= 5+((int) (Math.random()*10));
                temp=temp*-1;
                accuracy=temp;
            }
            if(accuracy>=35&&accuracy<80){
                temp= 3+((int) (Math.random()*8));
                temp=temp*-1;
                accuracy=temp;
            }
            if(accuracy>=80&&accuracy<115){
                temp= 2+((int) (Math.random()*5));
                temp=temp*-1;
                accuracy=temp;
            }
            if(accuracy>=115&&accuracy<140){
                temp= ((int) (Math.random()*3));
                temp=temp*-1;
                accuracy=temp;
            }
            if(accuracy>=140&&accuracy<160){
                accuracy=0;
            }
            if(accuracy>=160&&accuracy<185){
                temp= ((int) (Math.random()*3));
                accuracy=temp;
                
            }
            if(accuracy>=185&&accuracy<220){
                temp= 2+((int) (Math.random()*5));
                accuracy=temp;
                
            }
            if(accuracy>=220&&accuracy<265){
                temp= 3+((int) (Math.random()*8));
                accuracy=temp;
            }
            if(accuracy>=265&&accuracy<=300){
                temp= 5+((int) (Math.random()*10));
                accuracy=temp;
            }
            System.out.println("Accuracy = "+ accuracy);
            goodForShot=true;
        }
        if(goodForShot==true){
            
              Platform.runLater(new Runnable(){
              @Override
              public void run(){
                  try {
                      Thread.sleep(1000);
                      launchAnimation();
                      
                  } catch (InterruptedException ex) {
                  }
                  
              }
              });
              
            
        }
        }
      
  });
  }
  public void setWindOrientation(){
      int windOrientation = (int)(Math.random()*8);
      windArrow.setImage(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Arrow_east.svg/1200px-Arrow_east.svg.png"));
            switch (windOrientation) {
                case 0: windAngle = 0; break;
                case 1: windAngle = Math.toRadians(45); windArrow.setRotate(45); break;
                case 2: windAngle = Math.toRadians(90); windArrow.setRotate(90);break;
                case 3: windAngle = Math.toRadians(135); windArrow.setRotate(135); break;
                case 4: windAngle = Math.toRadians(180); windArrow.setRotate(180); break;
                case 5: windAngle = Math.toRadians(225); windArrow.setRotate(225); break;
                case 6: windAngle = Math.toRadians(270); windArrow.setRotate(270); break;
                case 7: windAngle = Math.toRadians(315); windArrow.setRotate(315); break;   
        }
  }
  public void setWindPower(){
      windPower = (int)(Math.random()*30);//km per hour (speed)
      windPowerDisplay.setText(Double.toString(windPower)+" km/h");
  }
  public double getPositionXWithWind(double windPower, double normalDistance, double windAngle, double shotAngle){
      double v, x, p, angleX;
      v=windPower;
      x= normalDistance;
      angleX=windAngle;
      p=finalX+(0.01*x*v*Math.cos(angleX));
      return p;
  }
  public double getPositionYWithWind(double windPower, double normalDistance, double windAngle, double shotAngle){
      double v, y, p, angleY;
      v=windPower;
      y= normalDistance;
      angleY=windAngle;
      p=finalY+(0.01*y*v*Math.sin(angleY));
      return p;
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
                golfBag.add(GolfClub.basicDriver);
                golfBag.add(GolfClub.basic3Wood);
                break;
            case 2 :
                golfBag.add(GolfClub.superDriver);
                golfBag.add(GolfClub.super3Wood);
                break;
            case 3 :
                golfBag.add(GolfClub.advancedDriver);
                golfBag.add(GolfClub.advanced3Wood);
                break;
            case 4 :
                golfBag.add(GolfClub.proDriver);
                golfBag.add(GolfClub.pro3Wood);
                break;
            case 5 :
                golfBag.add(GolfClub.athleteDriver);
                golfBag.add(GolfClub.athlete3Wood);
                break;
            case 6 :
                golfBag.add(GolfClub.ultimateDriver);
                golfBag.add(GolfClub.ultimate3Wood);
                break;
        }
        
        switch(selectedIrons){
            case 1 :
                golfBag.add(GolfClub.basic4Iron);
                golfBag.add(GolfClub.basic5Iron);
                golfBag.add(GolfClub.basic6Iron);
                golfBag.add(GolfClub.basic7Iron);
                golfBag.add(GolfClub.basic8Iron);
                golfBag.add(GolfClub.basic9Iron);
                golfBag.add(GolfClub.basicPitchingWedge);
                golfBag.add(GolfClub.basicSandWedge);
                break;
            case 2 :
                golfBag.add(GolfClub.super4Iron);
                golfBag.add(GolfClub.super5Iron);
                golfBag.add(GolfClub.super6Iron);
                golfBag.add(GolfClub.super7Iron);
                golfBag.add(GolfClub.super8Iron);
                golfBag.add(GolfClub.super9Iron);
                golfBag.add(GolfClub.superPitchingWedge);
                golfBag.add(GolfClub.superSandWedge);
                break;
            case 3 :
                golfBag.add(GolfClub.advanced4Iron);
                golfBag.add(GolfClub.advanced5Iron);
                golfBag.add(GolfClub.advanced6Iron);
                golfBag.add(GolfClub.advanced7Iron);
                golfBag.add(GolfClub.advanced8Iron);
                golfBag.add(GolfClub.advanced9Iron);
                golfBag.add(GolfClub.advancedPitchingWedge);
                golfBag.add(GolfClub.advancedSandWedge);
                break;
            case 4 :
                golfBag.add(GolfClub.pro4Iron);
                golfBag.add(GolfClub.pro5Iron);
                golfBag.add(GolfClub.pro6Iron);
                golfBag.add(GolfClub.pro7Iron);
                golfBag.add(GolfClub.pro8Iron);
                golfBag.add(GolfClub.pro9Iron);
                golfBag.add(GolfClub.proPitchingWedge);
                golfBag.add(GolfClub.proSandWedge);
                break;
            case 5 :
                golfBag.add(GolfClub.athlete4Iron);
                golfBag.add(GolfClub.athlete5Iron);
                golfBag.add(GolfClub.athlete6Iron);
                golfBag.add(GolfClub.athlete7Iron);
                golfBag.add(GolfClub.athlete8Iron);
                golfBag.add(GolfClub.athlete9Iron);
                golfBag.add(GolfClub.athletePitchingWedge);
                golfBag.add(GolfClub.athleteSandWedge);
                break;
            case 6 :
                golfBag.add(GolfClub.ultimate4Iron);
                golfBag.add(GolfClub.ultimate5Iron);
                golfBag.add(GolfClub.ultimate6Iron);
                golfBag.add(GolfClub.ultimate7Iron);
                golfBag.add(GolfClub.ultimate8Iron);
                golfBag.add(GolfClub.ultimate9Iron);
                golfBag.add(GolfClub.ultimatePitchingWedge);
                golfBag.add(GolfClub.ultimateSandWedge);
                break;
        }
        
        switch(selectedPutter){
            case 1: 
                golfBag.add(GolfClub.basicPutter); break;
            case 2: 
                golfBag.add(GolfClub.superPutter); break;
            case 3: 
                golfBag.add(GolfClub.advancedPutter); break;
            case 4: 
                golfBag.add(GolfClub.proPutter); break;
            case 5: 
                golfBag.add(GolfClub.athletePutter); break;
            case 6: 
                golfBag.add(GolfClub.ultimatePutter); break;
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
        
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("memorySelectedIrons.txt"));) {
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
    
    
    
    @FXML public void onClickNextShot(){
        angle=0;
        rotate.setAngle(0);
        attemptLine.setStroke(Color.TRANSPARENT);
        attemptLine.setFill(Color.TRANSPARENT);
        activeClub=golfBag.get(0);
        activeClubDisplay.setText("Selected Club: Driver");
        maxCarry=activeClub.maxCarry;
        endX=initialX+maxCarry*2;
        endY=initialY;
        previewLine.setEndX(endX);
        previewLine.setEndY(endY);
        previewLine.setStroke(Color.BLACK);
        shotpt.setPath(previewLine);
        powerpt.setFromX(0);
        powerDet.setX(0);
        accuracypt.setFromY(0);
        accuracyDet.setY(0);
        pane.getChildren().remove(circle);
        circle.setCenterX(initialX);
        circle.setCenterY(initialY);
        pane.getChildren().add(circle);
        onScroll();
        
    }
    
    @FXML public void onClickMenu(ActionEvent actionEvent)throws IOException{
        Parent GUI = FXMLLoader.load(getClass().getResource("GolfMenu.fxml"));
        Scene scene = new Scene(GUI);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    
  }

