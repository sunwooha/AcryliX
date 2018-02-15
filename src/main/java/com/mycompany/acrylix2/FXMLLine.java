/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.RotateTool;
import com.defano.jmonet.tools.SelectionTool;
import com.defano.jmonet.tools.brushes.BasicBrush;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 *
 * @author Parankush
 */
public class FXMLLine implements Initializable {
    
    JMonetRunner runner;
    
    @FXML
    private TextField xStart;
   
    @FXML
    private TextField yStart;
    
    @FXML
    private TextField xEnd;
    
    @FXML
    private TextField yEnd;
    
    public int x1 = -1;
    
    public int y1 = -1;
    
    public int x2 = -1;
    
    public int y2 = -1;
    
    public void setJMonetRunner(JMonetRunner run) {
        this.runner = run;
    }
    

    
    
    
    
    @FXML
    private void writeStartXPosition(ActionEvent event){
        if(!(xStart.getText().equals(""))){
            x1 = Integer.parseInt(xStart.getText());
            if(x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0){
                System.out.println("("+ x1 + ", " + y2 + "), (" + x1 + ", " + y2 + ")");
                draw((Graphics2D) runner.currentCanvas.getCanvas().getScratchImage().getGraphics());
            }
        }
        System.out.println("X-Pos1: " + x1);
    }
    
    @FXML
    private void writeStartYPosition(ActionEvent event){
        if(!(yStart.getText().equals(""))){
            y1 = Integer.parseInt(yStart.getText());
            if(x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0){
                System.out.println("("+ x1 + ", " + y2 + "), (" + x1 + ", " + y2 + ")");
                draw((Graphics2D) runner.currentCanvas.getCanvas().getScratchImage().getGraphics());
            }
        }
        System.out.println("Y-Pos1: " + y1);
    }
    
     @FXML
    private void writeEndXPosition(ActionEvent event){
        if(!(xEnd.getText().equals(""))){
            x2 = Integer.parseInt(xEnd.getText());
            if(x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0){
                System.out.println("("+ x1 + ", " + y2 + "), (" + x1 + ", " + y2 + ")");
                draw((Graphics2D) runner.currentCanvas.getCanvas().getScratchImage().getGraphics());
            }
        }
        System.out.println("Y-Pos2: " + x2);
    }
    
     @FXML
    private void writeEndYPosition(ActionEvent event){
        if(!(yEnd.getText().equals(""))){
            y2 = Integer.parseInt(yEnd.getText());
            if(x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0){
                System.out.println("("+ x1 + ", " + y2 + "), (" + x1 + ", " + y2 + ")");
                draw((Graphics2D) runner.currentCanvas.getCanvas().getScratchImage().getGraphics());
            }
        }
        System.out.println("Y-Pos: " + y2);
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
    private void clickDelete(ActionEvent event){
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
    
    public void draw(Graphics2D g){
        g.setPaint(runner.getActiveTool().getStrokePaint());
        g.setStroke(runner.getActiveTool().getStroke());
        g.drawLine(x1, y1, x2, y2);
        g.dispose();
        runner.currentCanvas.getCanvas().invalidateCanvas();
        runner.currentCanvas.getCanvas().commit();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }  
    
    
}

