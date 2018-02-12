package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.brushes.BasicBrush;
import com.defano.jmonet.tools.SelectionTool;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

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
            
            // Deactivate the current tool
            activeTool.deactivate();
                    
            // Switch the tool's type
            activeTool = PaintToolBuilder.create(tooltype)
                .withStroke(currentStroke)
                .withFillPaint(Color.BLACK)
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
                .withFontColor(col)
                .withStrokePaint(col)
                .makeActiveOnCanvas(currentCanvas)
                .build();
        }  
    }
    
    PaintTool getActiveTool() {
        return activeTool;
    }
    
    // Sets the active tool to a black paintbrush. Default when the program starts
    void setDefaultTool() {
        activeTool = PaintToolBuilder.create(PaintToolType.PAINTBRUSH)
            .withStroke(BasicBrush.ROUND_8X8.stroke)
            .withFillPaint(Color.BLACK)
            .makeActiveOnCanvas(currentCanvas)
            .build();
    }
    
    // Inserts an image (from a file) into the canvas
    void insertImage(String imagefile) {
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imagefile));
        } catch (IOException e) {
            System.err.println("A loading error occurred. Image not loaded.");
        }
        
        if (img != null){
            System.out.println("test");
            currentCanvas.getCanvas().setScratchImage(img); currentCanvas.getCanvas().commit();
        }
    }
    
    void exportImage(String filename, String imagetype) {
        BufferedImage img = currentCanvas.getCanvas().getCanvasImage();
        File outputfile = new File(filename);
        try {
            ImageIO.write(img, imagetype, outputfile);
        } catch (IOException e) {
            System.err.println("An error occurred. File not saved.");
        }
    }
}
