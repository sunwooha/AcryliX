package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.brushes.BasicBrush;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLGradient implements Initializable {
    
    JMonetRunner runner;
    double r1, g1, b1;
    double r2, g2, b2;
    double r3, g3, b3;
    long r4, g4, b4;
    
    public void setJMonetRunner(JMonetRunner run) {
        this.runner = run;
    }

    //first create first color actions
    @FXML
    private void firstColorRed(ActionEvent event){
        System.out.println("First color set to red.");
        r1 = 235;
        g1 = 38;
        b1 = 31;
    }
    
    @FXML
    private void firstColorOrange(ActionEvent event){
        System.out.println("First color set to orange.");
        r1 = 253;
        g1 = 146;
        b1 = 38;
    }
    
    @FXML
    private void firstColorYellow(ActionEvent event){
        System.out.println("First color set to yellow.");
        r1 = 254;
        g1 = 249;
        b1 = 55;
    }
    
    @FXML
    private void firstColorGreen(ActionEvent event){
        System.out.println("First color set to green.");
        r1 = 40;
        g1 = 247;
        b1 = 45;
    }
    
    @FXML
    private void firstColorBlue(ActionEvent event){
        System.out.println("First color set to blue.");
        r1 = 16;
        g1 = 63;
        b1 = 251;
    }
    
    @FXML
    private void firstColorPurple(ActionEvent event){
        System.out.println("First color set to purple.");
        r1 = 146;
        g1 = 40;
        b1 = 144;
    }
    
    @FXML
    private void firstColorBlack(ActionEvent event){
        System.out.println("First color set to black.");
        r1 = 0;
        g1 = 0;
        b1 = 0;
    }
    
    @FXML
    private void firstColorWhite(ActionEvent event){
        System.out.println("First color set to white.");
        r1 = 255;
        g1 = 255;
        b1 = 255;
    }
    
    
    //next, create second color option actions
        @FXML
    private void secondColorRed(ActionEvent event){
        System.out.println("Second color set to red.");
        r2 = 235;
        g2 = 38;
        b2 = 31;
    }
    
    @FXML
    private void secondColorOrange(ActionEvent event){
        System.out.println("Second color set to orange.");
        r2 = 253;
        g2 = 146;
        b2 = 38;
    }
    
    @FXML
    private void secondColorYellow(ActionEvent event){
        System.out.println("Second color set to yellow.");
        r2 = 254;
        g2 = 249;
        b2 = 55;
    }
    
    @FXML
    private void secondColorGreen(ActionEvent event){
        System.out.println("Second color set to green.");
        r2 = 40;
        g2 = 247;
        b2 = 45;
    }
    
    @FXML
    private void secondColorBlue(ActionEvent event){
        System.out.println("Second color set to blue.");
        r2 = 16;
        g2 = 63;
        b2 = 251;
    }
    
    @FXML
    private void secondColorPurple(ActionEvent event){
        System.out.println("Second color set to purple.");
        r2 = 146;
        g2 = 40;
        b2 = 144;
    }
    
    @FXML
    private void secondColorBlack(ActionEvent event){
        System.out.println("Second color set to black.");
        r2 = 0;
        g2 = 0;
        b2 = 0;
    }
    
    @FXML
    private void secondColorWhite(ActionEvent event){
        System.out.println("Second color set to white.");
        r2 = 255;
        g2 = 255;
        b2 = 255;
    }
    
    //below button is what sets the new gradient!
    @FXML
    private void clickGradient(ActionEvent event){
        System.out.println("You clicked gradient!");
        r3 = Math.sqrt((Math.pow(r1,2)+(Math.pow(r2,2)))/2);
        g3 = Math.sqrt((Math.pow(g1,2)+(Math.pow(g2,2)))/2);
        b3 = Math.sqrt((Math.pow(b1,2)+(Math.pow(b2,2)))/2);
        
        r4 = Math.round(r3);
        g4 = Math.round(g3);
        b4 = Math.round(b3);
        
        runner.switchToolColor(new Color((int)r4, (int)g4, (int)b4));
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
