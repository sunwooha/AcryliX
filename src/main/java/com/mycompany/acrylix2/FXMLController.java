package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.brushes.BasicBrush;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLController implements Initializable {
    
    JMonetRunner runner;
    JFXPaintCanvasNode myCanvas;
    
    
    @FXML
    private Label label;
    
    @FXML
    private Pane pane;
    
    @FXML
    private AnchorPane aPane;
    
    
    
    @FXML
    private void colorRed(ActionEvent event){
        System.out.println("You clicked red!");
    }
    
    @FXML
    private void colorOrange(ActionEvent event){
        System.out.println("You clicked orange!");
    }
    
    @FXML
    private void colorYellow(ActionEvent event){
        System.out.println("You clicked yellow!");
    }
    
    @FXML
    private void colorGreen(ActionEvent event){
        System.out.println("You clicked green!");
    }
    
    @FXML
    private void colorBlue(ActionEvent event){
        System.out.println("You clicked blue!");
    }
    
    @FXML
    private void colorPurple(ActionEvent event){
        System.out.println("You clicked purple!");
    }
    
    @FXML
    private void colorBlack(ActionEvent event){
        System.out.println("You clicked black!");
    }
    
    @FXML
    private void colorWhite(ActionEvent event){
        System.out.println("You clicked white!");
    }
    
    @FXML
    private void colorFill(ActionEvent event){
        System.out.println("You clicked fill!");
    }
    
    @FXML
    private void clickText(ActionEvent event){
        System.out.println("You clicked the text button!");
    }
    
    @FXML
    private void clickBrush(ActionEvent event){
        System.out.println("You clicked the brush button!");
    }
    
    @FXML
    private void clickCurve(ActionEvent event){
        System.out.println("You clicked the curve button!");
    }
    
    @FXML
    private void clickImage(ActionEvent event){
        System.out.println("You clicked the image button!");
    }
    
    @FXML
    private void clickLine(ActionEvent event){
        System.out.println("You clicked the line button!");
    }
    
    @FXML
    private void clickGroup(ActionEvent event){
        System.out.println("You clicked the group button!");
    }
    
    @FXML
    private void clickZoomIn(ActionEvent event){
        System.out.println("You clicked the zoom in button!");
    }
    
    @FXML
    private void clickZoomOut(ActionEvent event){
        System.out.println("You clicked the zoom out button!");
    }
    
    @FXML
    private void clickSelect(ActionEvent event){
        System.out.println("You clicked the select button!");
    }
    
    @FXML
    private void clickPrint(ActionEvent event){
        System.out.println("You clicked the print button!");
    }
    
    @FXML
    private void clickRect(ActionEvent event){
        System.out.println("You clicked the rectangle button!");
    }
    
    @FXML
    private void clickCircle(ActionEvent event){
        System.out.println("You clicked the circle button!");
    }
    
    @FXML
    private void clickPoly(ActionEvent event){
        System.out.println("You clicked the polygon button!");
    }
    
    @FXML
    private void clickEye(ActionEvent event){
        System.out.println("You clicked the eye dropper button!");
    }
    
    @FXML
    private void clickComment(ActionEvent event){
        System.out.println("You clicked the comment button!");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
<<<<<<< HEAD
        // TODO
         JFXPaintCanvasNode myCanvas = new JFXPaintCanvasNode(new JMonetCanvas());
         aPane.getChildren().add(myCanvas);
         myCanvas.getCanvas().setSize(1025, 595);
         
         PaintTool activeTool = PaintToolBuilder.create(PaintToolType.PAINTBRUSH)
        .withStroke(BasicBrush.ROUND_8X8.stroke)
        .withFillPaint(Color.RED)
        .makeActiveOnCanvas(myCanvas)
        .build();
         
=======
        
        runner = new JMonetRunner();
        runner.startJMonet();
        
        myCanvas = runner.currentCanvas;
        
        aPane.getChildren().add(myCanvas);
        myCanvas.getCanvas().setSize(1025, 595);
>>>>>>> a2b18c48c37a9c4aad45f1aae9c4a6d0fbaea70c
    }    
}
