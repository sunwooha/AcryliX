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
import static java.awt.Color.black;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
<<<<<<< HEAD
import javafx.stage.Stage;

=======
>>>>>>> cdcf6043532cb45b8a2400a8a2364775b93c3757
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
    
    public String newComment;
    
    
    public void setJMonetRunner(JMonetRunner run) {
        this.runner = run;
    }
    
    //and a submit comment button
    @FXML
    private void clickComment(ActionEvent event){

        //the comment is entered as a string
        newComment = commentsTextArea.getText();
        runner.getCurrentCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                x = (int) Math.round(event.getX());
                y = (int) Math.round(event.getY());
                String finalComment = "(" + x + ", " + y +"): " + newComment;
                System.out.println(finalComment);
                runner.addComments(finalComment);
            }
        });
<<<<<<< HEAD
=======
        
        Label newLabel = new Label(newComment);
        //newLabel.setVisible(true);
        //newLabel.setFill(black);
        
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        
        hbox.getChildren().add(newLabel);
       
        hbox.setMinWidth(400);
        hbox.setMinHeight(400);
        hbox.setPrefWidth(400);
        hbox.setPrefHeight(400);

        //aPane.getChildren().add(hbox);
        
>>>>>>> cdcf6043532cb45b8a2400a8a2364775b93c3757
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }
    
}





































