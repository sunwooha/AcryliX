package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;

public class JMonetRunner {
    
    JFXPaintCanvasNode currentCanvas;
    ToolController controller;
    
    JMonetRunner() {
    }
    
    void startJMonet() {
        currentCanvas = new JFXPaintCanvasNode(new JMonetCanvas());
        controller = new ToolController();
        controller.setDefaultTool(currentCanvas);
    }
    
    void newCanvas() {
        currentCanvas = new JFXPaintCanvasNode(new JMonetCanvas());
    }
    
    JFXPaintCanvasNode getCurrentCanvas() {
        return currentCanvas;
    }
}
