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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
/**
 *
 */
public class FXMLComments implements Initializable {
    
    //below, we have a text field accepting text as a comment
    @FXML
    public TextField commentsTextField;
    
    
    //and a submit comment button
    @FXML
    private void clickComment(ActionEvent event){
        
        //the comment is entered as a string
        String newComment = commentsTextField.getText();
        
        //now, send this comment to the arraylist of comments on the FXMLController.
        FXMLController mainClass = new FXMLController();
        mainClass.comments.add(newComment);
        
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
    
}





































