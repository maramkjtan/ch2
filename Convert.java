/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asschapter2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Maram Tanani
 */
public class Convert extends Application{

    Label l1;
    Label l2;
    Label l3;
    TextField t;
    RadioButton b1, b2;
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        l1= new Label("Enter Celsius Temperature");
        t= new TextField();
        l2=new Label("New temperature in is : ");
        l3= new Label();
        
        ToggleGroup t1 = new ToggleGroup();
        b1= new RadioButton("Fahrenheit");
        b1.setOnAction( new convert());
        b2=new RadioButton("Kelvin");
        b2.setOnAction(new convert());
        t1.getToggles().addAll(b1,b2);
        
        HBox h= new HBox(10,b1,b2);
        h.setAlignment(Pos.CENTER);
        
        HBox l= new HBox(10,l2,l3);
        l.setAlignment(Pos.CENTER);
        
        
          VBox v=new VBox(10,l1,t,h,l); 
          v.setAlignment(Pos.CENTER);
          Scene s =new Scene(v,700,250);
          
          
        primaryStage.setTitle("Temperature Conversion");
        primaryStage.setScene(s);
        primaryStage.show();
    
    }
    
    private class convert implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {

          if(event.getSource()==b1){
                l3.setText(Double.parseDouble(t.getText())*9/5 + 32+"");
            }else if(event.getSource()==b2){
                l3.setText(Double.parseDouble(t.getText())+ 273.15+"");
            }
        }
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
