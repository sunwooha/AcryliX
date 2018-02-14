/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLShapes implements Initializable {
    
    JMonetRunner runner;
    
    @FXML
    public TextField xPositionTextField;
    
    @FXML
    public TextField yPositionTextField;
    
    @FXML
    public TextField widthTextField;
    
    @FXML
    public TextField heightTextField;
    
    public int x = -1;
    
    public int y = -1;
    
    public int w = 0;
    
    public int h = 0;
   
    
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
        if(currentTool.getToolType() == PaintToolType.RECTANGLE || currentTool.getToolType() == PaintToolType.OVAL){
            String xPos = xPositionTextField.getText();
            if(!(xPos.equals(""))){
                x = Integer.parseInt(xPos);
                if(w > 0 && h > 0 && y >= 0 && x >= 0){
                    draw((Graphics2D) runner.currentCanvas.getCanvas().getScratchImage().getGraphics());
                }
            }
            System.out.println("X-Pos: " + x);
        }
    }
    
    @FXML
    private void writeYPosition(ActionEvent event){
        PaintTool currentTool = runner.getActiveTool();
        if(currentTool.getToolType() == PaintToolType.RECTANGLE || currentTool.getToolType() == PaintToolType.OVAL){
            String yPos = yPositionTextField.getText();
            System.out.println("Y-Pos: " + y);
            if(!(yPos.equals(""))){
                y = Integer.parseInt(yPos);
                if(w > 0 && h > 0 && y >= 0 && x >= 0){
                    draw((Graphics2D) runner.currentCanvas.getCanvas().getScratchImage().getGraphics());
                }
            }
            System.out.println("Y-Pos: " + y);
        }
    }
    
    @FXML
    private void writeWidth(ActionEvent event){
        PaintTool currentTool = runner.getActiveTool();
        if(currentTool.getToolType() == PaintToolType.RECTANGLE || currentTool.getToolType() == PaintToolType.OVAL){
            String width = widthTextField.getText();
            if(!(width.equals(""))){
                w = Integer.parseInt(width);
                if(w > 0 && h > 0 && y >= 0 && x >= 0){
                    draw((Graphics2D) runner.currentCanvas.getCanvas().getScratchImage().getGraphics());
                }
            }
            System.out.println("width: " + w);
        }
    }
    
    @FXML
    private void writeHeight(ActionEvent event){
        PaintTool currentTool = runner.getActiveTool();
        if(currentTool.getToolType() == PaintToolType.RECTANGLE || currentTool.getToolType() == PaintToolType.OVAL){
            String height = heightTextField.getText();
            if(!(height.equals(""))){
                h = Integer.parseInt(height);
                if(w > 0 && h > 0 && y >= 0 && x >= 0){
                    System.out.println(x + ", " + y + ", " + w + ", " + h);
                    draw((Graphics2D) runner.currentCanvas.getCanvas().getScratchImage().getGraphics());
                }
            }
            System.out.println("height: " + h);
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
        System.out.println("Delete");
    }
    
    @FXML
    private void clickRotate(ActionEvent event){
        System.out.println("Rotate");
    }
    
    @FXML
    private void clickScale(ActionEvent event){
        System.out.println("Rotate");
    }
    
    public void draw(Graphics2D g){
        g.setStroke(runner.getActiveTool().getStroke());
        g.setPaint(runner.getActiveTool().getStrokePaint());
        
        if(runner.getActiveTool().getToolType() == PaintToolType.RECTANGLE){
            g.drawRect(x, y, w, h);
            g.fillRect(x, y, w, h);
        }
        else if(runner.getActiveTool().getToolType() == PaintToolType.OVAL){
            g.drawOval(x, y, w, h);
            g.fillOval(x, y, w, h);
        }
        g.dispose();
        runner.currentCanvas.getCanvas().invalidateCanvas();
        runner.currentCanvas.getCanvas().commit();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
}










