/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.brushes.BasicBrush;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 *
 * @author Parankush
 */
public class FXMLLine implements Initializable {
    
    @FXML
    private void writeComment(ActionEvent event){
        System.out.println("Comment");
    }
    
    @FXML
    private void writeStartXPosition(ActionEvent event){
        System.out.println("X-Pos");
    }
    
    @FXML
    private void writeStartYPosition(ActionEvent event){
        System.out.println("Y-Pos");
    }
    
     @FXML
    private void writeEndXPosition(ActionEvent event){
        System.out.println("Y-Pos");
    }
    
     @FXML
    private void writeEndYPosition(ActionEvent event){
        System.out.println("Y-Pos");
    }
    
   
    @FXML
    private void clickFlipHorizontally(ActionEvent event){
        System.out.println("Horizontal");
    }
    
    @FXML
    private void clickFlipVertically(ActionEvent event){
        System.out.println("Vertical");
    }
    
    @FXML
    private void clickUngroup(ActionEvent event){
        System.out.println("Ungroup");
    }
    
    @FXML
    private void clickDelete(ActionEvent event){
        System.out.println("Delete");
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }  
    
    
}

