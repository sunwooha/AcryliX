/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.acrylix2;

import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.builder.PaintTool;
import java.awt.Font;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author Parankush
 */
public class FXMLText implements Initializable {
    
    JMonetRunner runner;
    
    @FXML
    private TextField fontSize;
    
    
    public void setJMonetRunner(JMonetRunner run) {
        this.runner = run;
    }
    
    @FXML
    private void writeSize(ActionEvent event){
        int size = Integer.parseInt(fontSize.getText());
        PaintTool currentTool = runner.getActiveTool();
        if(currentTool.getToolType() == PaintToolType.TEXT){
            runner.switchFontSize((double) size);
        }
        System.out.println("Size: " + size);
    }
    
    @FXML
    private void clickBold(ActionEvent event){
        int bold = Font.BOLD;
        PaintTool currentTool = runner.getActiveTool();
        if(currentTool.getToolType() == PaintToolType.TEXT){
            runner.switchFontStyle(bold);
        }
    }
    
    @FXML
    private void clickRegular(ActionEvent event){
        int bold = Font.PLAIN;
        PaintTool currentTool = runner.getActiveTool();
        if(currentTool.getToolType() == PaintToolType.TEXT){
            runner.switchFontStyle(bold);
        }
    }
    
    @FXML
    private void clickItalic(ActionEvent event){
        int bold = Font.ITALIC;
        PaintTool currentTool = runner.getActiveTool();
        if(currentTool.getToolType() == PaintToolType.TEXT){
            runner.switchFontStyle(bold);
        }
    }
    
    @FXML
    private void clickCourierFont(ActionEvent event){
        String courier = "Courier New";
        PaintTool currentTool = runner.getActiveTool();
        if(currentTool.getToolType() == PaintToolType.TEXT){
            runner.switchFont(courier);
        }
    }
    
    @FXML
    private void clickGothicFont(ActionEvent event){
        String gothic = "Baskerville";
        PaintTool currentTool = runner.getActiveTool();
        if(currentTool.getToolType() == PaintToolType.TEXT){
            runner.switchFont(gothic);
        }
    }
    
    @FXML
    private void clickWingdingsFont(ActionEvent event){
        String wingdings = "Wingdings";
        PaintTool currentTool = runner.getActiveTool();
        if(currentTool.getToolType() == PaintToolType.TEXT){
            runner.switchFont(wingdings);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }  
    
    
}
