package com.mycompany.acrylix2;
import com.defano.jmonet.algo.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FillBoundaryFunction implements BoundaryFunction {
    
    JMonetRunner runner;
    Color colorToFill;
    
    @Override
    public boolean shouldFillPixel(BufferedImage canvas, BufferedImage scratch, Point point) {
        Color canvasPixel = new Color(canvas.getRGB(point.x, point.y), true);
        Color scratchPixel = new Color(scratch.getRGB(point.x, point.y), true);
        
        Paint currentStrokePaint = runner.getActiveTool().getStrokePaint();
        /*System.out.print("x: " + point.x + "y: " + point.y + " ");
        System.out.println(canvasPixel != (Color) currentStrokePaint && scratchPixel != (Color) currentStrokePaint);*/
        
        boolean shouldFillPixel = false;
        if (canvasPixel.getAlpha() == 0 && scratchPixel.getAlpha() == 0) {
            shouldFillPixel = true;
        }
        /*else if (canvasPixel != colorToFill && scratchPixel != colorToFill) {
            shouldFillPixel = true;
        }*/
        return shouldFillPixel;
    }
    
    public void setJMonetRunner(JMonetRunner runner) {
        this.runner = runner;
    }
}
