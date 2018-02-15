package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.RectangleTool;
import com.defano.jmonet.tools.brushes.BasicBrush;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import com.defano.jmonet.tools.SelectionTool;
import com.defano.jmonet.tools.RectangleTool;
import com.defano.jmonet.tools.RotateTool;
import com.defano.jmonet.tools.ScaleTool;
import com.defano.jmonet.tools.base.AbstractSelectionTool;
import com.defano.jmonet.tools.ProjectionTool;
import com.defano.jmonet.tools.util.Geometry;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class FXMLPolygon implements Initializable{
    
    @FXML
    public TextField xPositionTextField;
    
    @FXML
    public TextField yPositionTextField;
    
    private int[] x;
    
    private int[] y;
    
    private int numberOfSides;
    
    JMonetRunner runner;
    
    public void setJMonetRunner(JMonetRunner run) {
        this.runner = run;
    }
    
    @FXML
    private void writeComment(ActionEvent event){
        System.out.println("Comment");
    }
    
    @FXML
    private void writeXPosition(ActionEvent event){
        PaintTool currentTool = runner.getActiveTool();
        if(currentTool.getToolType() == PaintToolType.POLYGON){
            String xPos = xPositionTextField.getText();
            if(!(xPos.equals(""))){
                String[] tokens = xPos.split(",");
                numberOfSides = tokens.length;
                x = new int[numberOfSides];
                for(int i = 0; i < numberOfSides; i++){
                    x[i] = Integer.parseInt(tokens[i]);
                }
                /*if(x.length == y.length && numberOfSides != 0){
                    draw((Graphics2D) runner.currentCanvas.getCanvas().getScratchImage().getGraphics());
                }*/
            }
        }
    }
    
    @FXML
    private void writeYPosition(ActionEvent event){
        PaintTool currentTool = runner.getActiveTool();
        if(currentTool.getToolType() == PaintToolType.POLYGON){
            String yPos = yPositionTextField.getText();
            if(!(yPos.equals(""))){
                String[] tokens = yPos.split(",");
                numberOfSides = tokens.length;
                y = new int[numberOfSides];
                for(int i = 0; i < numberOfSides; i++){
                    y[i] = Integer.parseInt(tokens[i]);
                }
                if(x.length == y.length && numberOfSides != 0){
                    draw((Graphics2D) runner.currentCanvas.getCanvas().getScratchImage().getGraphics());
                }
            }
        }
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
    private void clickUngroup(ActionEvent event){
        System.out.println("Ungroup");
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
    
    public void draw(Graphics2D g){
        g.setStroke(runner.getActiveTool().getStroke());
        g.setPaint(runner.getActiveTool().getStrokePaint());
        
        if(runner.getActiveTool().getToolType() == PaintToolType.POLYGON){
            g.drawPolygon(x, y, numberOfSides);
            g.fillPolygon(x, y, numberOfSides);
        }
        g.dispose();
        runner.currentCanvas.getCanvas().invalidateCanvas();
        runner.currentCanvas.getCanvas().commit();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}
