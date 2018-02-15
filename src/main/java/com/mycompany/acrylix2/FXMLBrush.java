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
    private Slider size;
    
    
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

    
    
    @FXML
    private void setSize(DragEvent event){
        System.out.println("Size: " + size.getValue());
        double newSize = size.getValue();
        runner.switchToolSize(newSize);
    }



    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        size.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Slider Value Changed (newValue: " + newValue.intValue() + ")\n");
                runner.switchToolSize((double) newValue.intValue());
            }
        });
    }
}
