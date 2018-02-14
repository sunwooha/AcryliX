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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Parankush
 */
public class FXMLText implements Initializable {
    
    JMonetRunner runner;
    
    public void setJMonetRunner(JMonetRunner run) {
        this.runner = run;
    }
    
    @FXML
    private void writeComment(ActionEvent event){
        System.out.println("Comment");
    }
    
    @FXML
    private void selectFont(ActionEvent event){
        System.out.println("Font");
    }
    
    @FXML
    private void writeSize(ActionEvent event){
        System.out.println("Size");
    }
    
    @FXML
    private void clickBold(ActionEvent event){
        System.out.println("Bold");
    }
    
    @FXML
    private void clickRegular(ActionEvent event){
        System.out.println("reg");
    }
    
    @FXML
    private void clickItalic(ActionEvent event){
        System.out.println("italic");
    }
    
    @FXML
    private void writeXPosition(ActionEvent event){
        System.out.println("X-Pos");
    }
    
    @FXML
    private void writeYPosition(ActionEvent event){
        System.out.println("Y-Pos");
    }
    
    @FXML
    private void clickFlipHorizontally(ActionEvent event){
        System.out.println("horizontal");
    }
    
    @FXML
    private void clickFlipVertically(ActionEvent event){
        System.out.println("vertical");
    }
    
    @FXML
    private void clickUngroup(ActionEvent event){
        System.out.println("ungroup");
    }
    
    @FXML
    private void clickDelete(ActionEvent event){
        System.out.println("delete");
    }
    
    @FXML
    private void clickRotate(ActionEvent event){
        System.out.println("rotate");
    }
    
    @FXML
    private void clickFirstFont(ActionEvent event){
        System.out.println("first font");
    }
    
    @FXML
    private void clickSecondFont(ActionEvent event){
        System.out.println("second font");
    }
    
    @FXML
    private void clickThirdFont(ActionEvent event){
        System.out.println("third font");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }  
    
    
}
