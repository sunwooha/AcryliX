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
import java.awt.BasicStroke;
import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLBrush implements Initializable {
    
    JMonetRunner runner;
    
    public void setJMonetRunner(JMonetRunner run) {
        this.runner = run;
    }
    
    
    @FXML
    private void clickSpray(ActionEvent event){
        System.out.println("Spray");
        runner.switchToolType(PaintToolType.AIRBRUSH);
    }
    
    @FXML
    private void clickPaint(ActionEvent event){
        System.out.println("Paint");
        runner.switchToolType(PaintToolType.PAINTBRUSH);
    }

    @FXML
    private void clickPencil(ActionEvent event){
        System.out.println("Pencil");
        runner.switchToolType(PaintToolType.PENCIL);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
}
