/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.acrylix2;

import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.SelectionTool;
import com.defano.jmonet.tools.RotateTool;
import com.defano.jmonet.tools.ScaleTool;
import java.awt.Graphics2D;
import java.net.URL;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
/**
 *
 */
public class FXMLComments extends FXMLController{
    
    JMonetRunner runner;
    
    int x;
    int y;
    
    //below, we have a text field accepting text as a comment
    @FXML
    public TextArea commentsTextArea;
    
    public void setJMonetRunner(JMonetRunner run) {
        this.runner = run;
    }
    
    //and a submit comment button
    @FXML
    private void clickComment(ActionEvent event){
        
        //the comment is entered as a string
        String newComment = commentsTextArea.getText();
        
        //now, send this comment to the arraylist of comments on the FXMLController.
        //FXMLController mainClass = new FXMLController();
        //mainClass.getComments().add(newComment);
        runner.addComments(newComment);
        runner.getCurrentCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = (int) Math.round(event.getX());
                y = (int) Math.round(event.getY());
                
            }
        });
        
        Label newLabel = new Label(newComment);
        newLabel.setBounds(x, y, 50, 100);
        newLabel.setAlignment(Label.CENTER);
        newLabel.setVisible(true);
        
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        
        //hbox.getChildren().add(newLabel);
        
      
        aPane.getChildren().add(hbox);
        
        
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
    
}





































