package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.brushes.BasicBrush;
import java.awt.Color;

public class ToolController {
    
    PaintTool activeTool;
    
    ToolController() {
    }
    
    void switchTools(JFXPaintCanvasNode canvas, PaintToolType tooltype, Color col) {
        
        // If a tool is already active, deactivate it
        if (activeTool != null) {
            activeTool.deactivate();
        }
        
        // Switch tools (placeholder for now; definitely needs more logic, TBD)
        activeTool = PaintToolBuilder.create(tooltype)
            .withStroke(BasicBrush.ROUND_8X8.stroke)
            .withFillPaint(col)
            .makeActiveOnCanvas(canvas)
            .build(); 
    }
    
    // Sets the active tool to a black paintbrush; default for when the program starts
    void setDefaultTool(JFXPaintCanvasNode canvas) {
        switchTools(canvas, PaintToolType.PAINTBRUSH, Color.BLACK);
    }
}
