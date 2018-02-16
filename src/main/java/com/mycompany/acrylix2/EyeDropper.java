
package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.ChangeSet;
import com.defano.jmonet.canvas.PaintCanvas;
import com.defano.jmonet.canvas.observable.CanvasCommitObserver;
import com.defano.jmonet.canvas.observable.SurfaceInteractionObserver;
import io.reactivex.subjects.BehaviorSubject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javax.imageio.ImageIO;
import java.util.Observable;

public class EyeDropper extends Observable implements SurfaceInteractionObserver {
    
    private PaintCanvas canvas;
    private AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
    private Cursor toolCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
    private int constrainedAngle = 15;
    Cursor customCursor;
    private Color pickedColor;
    
    public EyeDropper() {
        createCursor();
        setToolCursor(customCursor);
        pickedColor = new Color(0, 0, 0);
    }
    
    public void activate (PaintCanvas canvas) {
        this.canvas = canvas;
        this.canvas.addSurfaceInteractionObserver(this);
        this.canvas.setCursor(toolCursor);
    }
    
    public void deactivate() {
        if (canvas != null) {
            canvas.removeSurfaceInteractionObserver(this);
            canvas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    public PaintCanvas getCanvas() {
        return canvas;
    }
    
    void createCursor() {
        customCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
        System.out.println("Cursor created!");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point cursorHotSpot = new Point(0,0);
        Image cursorImage = null;
        try {
            cursorImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("icons/eye.png"));
        } catch (IOException e) {
            System.err.println("A load error occurred. Cursor image not loaded.");
        }
        if (cursorImage != null) {
            customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "EyeDropper_Cursor");
        }
    }
    
    public Cursor getToolCursor() {
        return toolCursor;
    }
    
    public void setToolCursor(Cursor toolCursor) {
        this.toolCursor = toolCursor;

        if (this.canvas != null) {
            this.canvas.setCursor(toolCursor);
        }
    }
    
    public void setPickedColor(Color pickedColor) {
        synchronized (this) {
            this.pickedColor = pickedColor;
        }
        setChanged();
        notifyObservers();
    }
    
    public synchronized Color getPickedColor() {
        return pickedColor;
    }
    
    @Override
    public void mouseClicked(MouseEvent e, Point imageLocation) {
        BufferedImage img = this.getCanvas().getCanvasImage();
        Color colorPick = new Color(img.getRGB(imageLocation.x, imageLocation.y), true);
        setPickedColor(colorPick);
    }
    
    @Override
    public void mousePressed(MouseEvent e, Point imageLocation) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e, Point imageLocation) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e, Point imageLocation) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e, Point imageLocation) {
        
    }
    
    @Override
    public void mouseDragged(MouseEvent e, Point imageLocation) {
        
    }
    
    @Override
    public void mouseMoved(MouseEvent e, Point imageLocation) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
