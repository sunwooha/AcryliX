package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.brushes.BasicBrush;
import java.awt.Color;

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
    
    void switchTools(PaintToolType tooltype, Color col) {
        
        // If a tool is already active, deactivate it
        if (activeTool != null) {
            activeTool.deactivate();
        }
        
        // Switch tools (placeholder for now; definitely needs more logic, TBD)
        activeTool = PaintToolBuilder.create(tooltype)
            .withStroke(BasicBrush.ROUND_8X8.stroke)
            .withFillPaint(col)
            .makeActiveOnCanvas(currentCanvas)
            .build(); 
    }
    
    PaintTool getActiveTool() {
        return activeTool;
    }
    
    void setDefaultTool() {
        switchTools(PaintToolType.PAINTBRUSH, Color.BLACK);
    }
}
