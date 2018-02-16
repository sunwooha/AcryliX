package com.mycompany.acrylix2;
import com.defano.jmonet.algo.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FillBoundaryFunction implements BoundaryFunction {
    
    JMonetRunner runner;
    Color colorToFill;
    Color firstCanvasColor;
    Color firstScratchColor;
    boolean firstColorSet = false;
    
    @Override
    public boolean shouldFillPixel(BufferedImage canvas, BufferedImage scratch, Point point) {
        Color canvasPixel = new Color(canvas.getRGB(point.x, point.y), true);
        Color scratchPixel = new Color(scratch.getRGB(point.x, point.y), true);
        
        if (this.firstColorSet == false) {
            this.firstCanvasColor = canvasPixel;
            this.firstScratchColor = scratchPixel;
            this.firstColorSet = true;
        }
        
        boolean shouldFillPixel = false;
        
        if (canvasPixel.equals(this.firstCanvasColor) && scratchPixel.equals(this.firstScratchColor)) {
            shouldFillPixel = true;
        }
        
        return shouldFillPixel;
    }
    
    public void setJMonetRunner(JMonetRunner runner) {
        this.runner = runner;
    }
    
    public void setFillColor(Color col) {
        this.colorToFill = col;
    }
}