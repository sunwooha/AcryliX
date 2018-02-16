/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.SelectionTool;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class FXMLLogo implements Initializable {
    
    JMonetRunner runner;
    
    JFXPaintCanvasNode myCanvas;
    
    public void setJMonetRunner(JMonetRunner run) {
        this.runner = run;
    }
    
    @FXML
    private void clickNewFile(ActionEvent event){
        System.out.println("New File");
        //runner.newCanvas();
        myCanvas = runner.getCurrentCanvas();
        myCanvas.getCanvas().clearCanvas();
    } 
    
    @FXML
    private void clickSelectPrevious(ActionEvent event){
        System.out.println("Select Previous");
        runner.getCurrentCanvas().getCanvas().clearCanvas();
        Stage stage = new Stage(); 
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Previous File");
        File selectedDirectory = fileChooser.showOpenDialog(stage);

        
        if(selectedDirectory == null){ 
             //No Directory selected 
        } 
        else{ 
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(selectedDirectory.getAbsolutePath()));
            }
            catch (IOException e) {
                System.err.println("A loading error occurred. Image not loaded.");
            }
        
            if (img != null){
                runner.switchToolType(PaintToolType.SELECTION);
                if (runner.getActiveTool().getToolType() == PaintToolType.SELECTION) {
                    SelectionTool newTool = (SelectionTool)runner.activeTool;
                    newTool.createSelection(img, new Point(0,0));
                    //newTool.resetSelection();
                }
                else {
                    System.out.println("Error. Image not imported.");
                }
            }
        }
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } 

}
