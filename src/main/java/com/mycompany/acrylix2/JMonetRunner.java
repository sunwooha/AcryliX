package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.brushes.BasicBrush;
import java.awt.*;

public class JMonetRunner {
    
    JFXPaintCanvasNode currentCanvas;
    PaintTool activeTool;
    
    JMonetRunner() {
    }
    
    void startJMonet() {
        currentCanvas = new JFXPaintCanvasNode(new JMonetCanvas());
        setDefaultTool();
    }
    
    void newCanvas() {
        currentCanvas = new JFXPaintCanvasNode(new JMonetCanvas());
    }
    
    JFXPaintCanvasNode getCurrentCanvas() {
        return currentCanvas;
    }
    
    void switchToolType(PaintToolType tooltype) {
        
        // Check whether or not a tool is already active
        if (activeTool != null) {
            
            // Store the current tool's attributes
            Stroke currentStroke = activeTool.getStroke();
            Paint currentColor = activeTool.getStrokePaint();
            
            // Deactivate the current tool
            activeTool.deactivate();
                    
            // Switch the tool's type
            activeTool = PaintToolBuilder.create(tooltype)
                .withStroke(currentStroke)
                .withFillPaint(currentColor)
                .makeActiveOnCanvas(currentCanvas)
                .build();
        }
    }
    
    void switchToolColor(Color col) {
        
        // Check whether or not a tool is already active
        if (activeTool != null) {
            
            // Store the current tool's attributes
            Stroke currentStroke = activeTool.getStroke();
            PaintToolType currentToolType = activeTool.getToolType();
            
            // Deactivate the current tool
            activeTool.deactivate();
        
            // Switch the tool's color
            activeTool = PaintToolBuilder.create(currentToolType)
                .withStroke(currentStroke)
                .withFillPaint(col)
                .makeActiveOnCanvas(currentCanvas)
                .build();
        }  
    }
    
    PaintTool getActiveTool() {
        return activeTool;
    }
    
    //Sets the active tool to a black paintbrush. Default when the program starts
    void setDefaultTool() {
        activeTool = PaintToolBuilder.create(PaintToolType.PAINTBRUSH)
            .withStroke(BasicBrush.ROUND_8X8.stroke)
            .withFillPaint(Color.BLACK)
            .makeActiveOnCanvas(currentCanvas)
            .build();
    }
}
