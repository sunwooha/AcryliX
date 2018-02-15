package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.SelectionTool;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class JMonetRunner {
    
    JFXPaintCanvasNode currentCanvas;
    PaintTool activeTool;
    Color gradientColor;
    Color eyeDropperColor;
    
    JMonetRunner() {
    }
    
    void startJMonet() {
        currentCanvas = new JFXPaintCanvasNode(new JMonetCanvas());
        setDefaultTool();
        gradientColor = new Color(0, 0, 0);
    }
    
    void newCanvas() {
        currentCanvas = new JFXPaintCanvasNode(new JMonetCanvas());
        setDefaultTool();
        System.out.println("New canvas created.");
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
                .withFillPaint(activeTool.getStrokePaint())
                .withStrokePaint(activeTool.getStrokePaint())
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
    
    void switchToolSize(Double size) {
        
        // Check whether or not a tool is already active
        if (activeTool != null) {

            PaintToolType currentToolType = activeTool.getToolType();
            Paint currentStokePaint = activeTool.getStrokePaint();
            Font currentFont = activeTool.getFont();
            
            
            // Deactivate the current tool
            activeTool.deactivate();

            // Switch the tool's color
            activeTool = PaintToolBuilder.create(currentToolType)
                .withStroke(new BasicStroke(size.floatValue(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL))
                .withStrokePaint(currentStokePaint)
                .withFillPaint(currentStokePaint)
                .withFont(new Font(currentFont.getName(), currentFont.getStyle(), size.intValue()))
                .withFontColor(activeTool.getFontColor())
                .makeActiveOnCanvas(currentCanvas)
                .build();
        }  
    }
    
    void switchFontStyle(int style) {
        
        // Check whether or not a tool is already active
        if (activeTool != null) {

            PaintToolType currentToolType = activeTool.getToolType();
            Paint currentStokePaint = activeTool.getStrokePaint();
            Font currentFont = activeTool.getFont();
            
            
            // Deactivate the current tool
            activeTool.deactivate();

            // Switch the tool's color
            activeTool = PaintToolBuilder.create(currentToolType)
                .withStroke(activeTool.getStroke())
                .withStrokePaint(currentStokePaint)
                .withFillPaint(currentStokePaint)
                .withFont(new Font(currentFont.getName(), style, currentFont.getSize()))
                .withFontColor(activeTool.getFontColor())
                .makeActiveOnCanvas(currentCanvas)
                .build();
        }  
    }
    
    void switchFont(String font) {
        
        // Check whether or not a tool is already active
        if (activeTool != null) {

            PaintToolType currentToolType = activeTool.getToolType();
            Paint currentStokePaint = activeTool.getStrokePaint();
            Font currentFont = activeTool.getFont();
            
            
            // Deactivate the current tool
            activeTool.deactivate();

            // Switch the tool's color
            activeTool = PaintToolBuilder.create(currentToolType)
                .withStroke(activeTool.getStroke())
                .withStrokePaint(currentStokePaint)
                .withFillPaint(currentStokePaint)
                .withFont(new Font(font, currentFont.getStyle(), currentFont.getSize()))
                .withFontColor(activeTool.getFontColor())
                .makeActiveOnCanvas(currentCanvas)
                .build();
        }  
    }
    
    void setActiveTool(PaintTool p) {
        activeTool = p;
    }
    
    PaintTool getActiveTool() {
        return activeTool;
    }
    
    // Sets the active tool to a black paintbrush. Default when the program starts
    void setDefaultTool() {
        activeTool = PaintToolBuilder.create(PaintToolType.PAINTBRUSH)
            .withStroke(new BasicStroke(8, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL))
            .withFillPaint(Color.BLACK)
            .withFont(new Font("Courier New", Font.PLAIN, 15))
            .withFontColor(Color.BLACK)
            .makeActiveOnCanvas(currentCanvas)
            .build();
    }
    
    // Inserts an image (from a file) into the canvas
    boolean insertImage(String imagefile) {
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imagefile));
        } catch (IOException e) {
            System.err.println("A loading error occurred. Image not loaded.");
        }
        
        if (img != null){
            switchToolType(PaintToolType.SELECTION);
            if (activeTool.getToolType() == PaintToolType.SELECTION) {
                SelectionTool newTool = (SelectionTool)activeTool;
                newTool.createSelection(img, new Point(0,0));
                activeTool = newTool;
                return true;
            }
            else {
                System.out.println("Error. Image not imported.");
            }
        }
        return false;
    }
    
    void exportImage(String filename, String imagetype, File file) {
        BufferedImage img = currentCanvas.getCanvas().getCanvasImage();

        try {
            ImageIO.write(img, imagetype, file);
        } catch (IOException e) {
            System.err.println("An error occurred. File not saved.");
        }
    }
    
    void setGradientColor(Color col) {
        gradientColor = col;
    }
    
    Color getGradientColor() {
        return gradientColor;
    }
    
    void setEyeDropperColor(Color col) {
        eyeDropperColor = col;
    }
    
    Color getEyeDropperColor() {
        return eyeDropperColor;
    }
}
