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
import java.net.URL;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Parankush
 */
public class FXMLSelection implements Initializable {
    
    JMonetRunner runner;
    
    public void setJMonetRunner(JMonetRunner run) {
        this.runner = run;
    }
    
    @FXML
    private void clickFlipHorizontally(ActionEvent event){
        System.out.println("Horizontal");
        PaintTool currentTool = runner.getActiveTool();
        if (currentTool.getToolType() == PaintToolType.SELECTION){
            SelectionTool newTool = (SelectionTool)currentTool;
            newTool.flipHorizontal();
        }
        else {
            System.out.println("Nothing is selected.");
        }
    }
    
    @FXML
    private void clickFlipVertically(ActionEvent event){
        System.out.println("Vertical");
        PaintTool currentTool = runner.getActiveTool();
        if (currentTool.getToolType() == PaintToolType.SELECTION){
            SelectionTool newTool = (SelectionTool)currentTool;
            newTool.flipVertical();
        }
        else {
            System.out.println("Nothing is selected.");
        }
    }
    
    @FXML
    private void clickRotate(ActionEvent event){
        System.out.println("Rotate");
        BufferedImage img;
        Point p;
        
        PaintTool currentTool = runner.getActiveTool();
        if (currentTool instanceof SelectionTool) {
            SelectionTool newTool = (SelectionTool)currentTool;
            if (newTool.hasSelection()) {
                img = newTool.getSelectedImage();
                p = newTool.getSelectionOutline().getBounds().getLocation();
                newTool.deleteSelection();
                
                runner.switchToolType(PaintToolType.ROTATE);
                if (runner.getActiveTool().getToolType() == PaintToolType.ROTATE) {
                    RotateTool rotateTool = (RotateTool)runner.getActiveTool();
                    rotateTool.createSelection(img, p);
                    runner.setActiveTool(rotateTool);
                }
            }
        }
        else {
            System.out.println("Nothing is selected.");
            
        }
    }
    
    @FXML
    private void clickScale(ActionEvent event){
        System.out.println("Scale");
        BufferedImage img;
        Point p;
        
        PaintTool currentTool = runner.getActiveTool();
        if (currentTool instanceof SelectionTool) {
            SelectionTool newTool = (SelectionTool)currentTool;
            if (newTool.hasSelection()) {
                img = newTool.getSelectedImage();
                p = newTool.getSelectionOutline().getBounds().getLocation();
                newTool.deleteSelection();
                
                runner.switchToolType(PaintToolType.SCALE);
                if (runner.getActiveTool().getToolType() == PaintToolType.SCALE) {
                    ScaleTool scaleTool = (ScaleTool)runner.getActiveTool();
                    scaleTool.createSelection(img, p);
                    runner.setActiveTool(scaleTool);
                }
            }
        }
        else {
            System.out.println("Nothing is selected.");
        }
    }
    
    @FXML
    private void clickDuplicate(ActionEvent event) {
        System.out.println("Duplicate");
        BufferedImage img;
        Point p;
        PaintTool currentTool = runner.getActiveTool();
        if (currentTool instanceof SelectionTool) {
            SelectionTool newTool = (SelectionTool)currentTool;
            if (newTool.hasSelection()) {
                img = newTool.getSelectedImage();
                p = newTool.getSelectionOutline().getBounds().getLocation();
                newTool.clearSelection();
                
                SelectionTool secondTool = (SelectionTool)runner.getActiveTool();
                secondTool.createSelection(img, p);
                runner.setActiveTool(secondTool);
            }
        }
        else {
            System.out.println("Nothing is selected.");
        }
    }
    
    @FXML
    private void clickTrash(ActionEvent event) {
        BufferedImage img; 
        Point p; 
         
        PaintTool currentTool = runner.getActiveTool(); 
        if (currentTool instanceof SelectionTool) { 
            SelectionTool newTool = (SelectionTool)currentTool; 
            if (newTool.hasSelection()) { 
                img = newTool.getSelectedImage(); 
                p = newTool.getSelectionOutline().getBounds().getLocation(); 
                newTool.deleteSelection(); 
            } 
        } 
        System.out.println("Delete"); 
    }
    
    @FXML
    private void clickSelection(ActionEvent event) {
        
        runner.switchToolType(PaintToolType.SELECTION);
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}





























