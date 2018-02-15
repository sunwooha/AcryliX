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

    //first create first color actions
    @FXML
    private void firstColorRed(ActionEvent event){
        System.out.println("You clicked red!");
        runner.switchToolColor(new Color(235,38,31));
    }
    
    @FXML
    private void firstColorOrange(ActionEvent event){
        System.out.println("You clicked orange!");
        runner.switchToolColor(new Color(253,146,38));
    }
    
    @FXML
    private void firstColorYellow(ActionEvent event){
        System.out.println("You clicked yellow!");
        runner.switchToolColor(new Color(254,249,55));
    }
    
    @FXML
    private void firstColorGreen(ActionEvent event){
        System.out.println("You clicked green!");
        runner.switchToolColor(new Color(40,247,45));
    }
    
    @FXML
    private void firstColorBlue(ActionEvent event){
        System.out.println("You clicked blue!");
        runner.switchToolColor(new Color(16,63,251));
    }
    
    @FXML
    private void firstColorPurple(ActionEvent event){
        System.out.println("You clicked purple!");
        runner.switchToolColor(new Color(146,40,144));
    }
    
    @FXML
    private void firstColorBlack(ActionEvent event){
        System.out.println("You clicked black!");
        runner.switchToolColor(Color.BLACK);
    }
    
    @FXML
    private void firstColorWhite(ActionEvent event){
        System.out.println("You clicked white!");
        runner.switchToolColor(Color.WHITE);
    }
    
    
    //next, create second color option actions
        @FXML
    private void secondColorRed(ActionEvent event){
        System.out.println("You clicked red!");
        runner.switchToolColor(new Color(235,38,31));
    }
    
    @FXML
    private void secondColorOrange(ActionEvent event){
        System.out.println("You clicked orange!");
        runner.switchToolColor(new Color(253,146,38));
    }
    
    @FXML
    private void secondColorYellow(ActionEvent event){
        System.out.println("You clicked yellow!");
        runner.switchToolColor(new Color(254,249,55));
    }
    
    @FXML
    private void secondColorGreen(ActionEvent event){
        System.out.println("You clicked green!");
        runner.switchToolColor(new Color(40,247,45));
    }
    
    @FXML
    private void secondColorBlue(ActionEvent event){
        System.out.println("You clicked blue!");
        runner.switchToolColor(new Color(16,63,251));
    }
    
    @FXML
    private void secondColorPurple(ActionEvent event){
        System.out.println("You clicked purple!");
        runner.switchToolColor(new Color(146,40,144));
    }
    
    @FXML
    private void secondColorBlack(ActionEvent event){
        System.out.println("You clicked black!");
        runner.switchToolColor(Color.BLACK);
    }
    
    @FXML
    private void secondColorWhite(ActionEvent event){
        System.out.println("You clicked white!");
        runner.switchToolColor(Color.WHITE);
    }
    

    
    //below button is what sets the new gradient!
    @FXML
    private void clickGradient(ActionEvent event){
        System.out.println("You clicked gradient!");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } 
    
}
