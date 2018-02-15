/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.acrylix2;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.builder.PaintTool;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class EyeDropperTool extends PaintTool {
    
    Cursor customCursor;
    
    public EyeDropperTool(PaintToolType type) {
        super(type);
        createCursor();
        setToolCursor(customCursor);
    }
    
    void createCursor() {
        customCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point cursorHotSpot = new Point(0,0);
        Image cursorImage = null;
        try {
            cursorImage = ImageIO.read(new File("/main/resources/icons/eye"));
        } catch (IOException e) {
            System.err.println("A loading error occurred. Cursor image not loaded.");
        }
        if (cursorImage != null) {
            customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "EyeDropper_Cursor");
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e, Point imageLocation) {
        BufferedImage img = this.getCanvas().getCanvasImage();
        Color pickedColor = new Color(img.getRGB(imageLocation.x, imageLocation.y), true);
    }
}
