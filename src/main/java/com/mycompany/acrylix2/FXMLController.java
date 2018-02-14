package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.brushes.BasicBrush;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import java.awt.Color;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLController implements Initializable {
    
    JMonetRunner runner;
    JFXPaintCanvasNode myCanvas;
    
    @FXML
    private TextField currX;
    
    @FXML
    private TextField currY;
    
    @FXML
    private Label label;
    
    @FXML
    private Pane pane;
    
    @FXML
    private AnchorPane aPane;
    
    @FXML 
    private TextField fileName;
    
    @FXML
    private void clickExport(ActionEvent event){
        System.out.println("You clicked export!");
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        File file = fileChooser.showSaveDialog(stage);
        
        if (file != null) {
            runner.exportImage(fileName.getText(), "png", file);
        }
    }
    
    @FXML
    private void clickErase(ActionEvent event){
        System.out.println("You clicked erase!");
        runner.switchToolType(PaintToolType.ERASER);
    }
    
    @FXML
    private void clickRotate(ActionEvent event){
        System.out.println("You clicked rotate!");
        runner.switchToolType(PaintToolType.ROTATE);
    }
    
    @FXML
    private void clickAcrylix(ActionEvent event) throws IOException{
        
        //now, we will create a pop-up window
        
        //fist get the XML file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/LogoAttributes.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        
        //then, set the scene from that file
        Scene scene = new Scene(p);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //set attributes of the window.
        stage.setTitle("Acrylix");
        stage.setScene(scene);
        stage.show();
        
        // pass the JMonetRunner
        FXMLLogo controller = loader.getController();
        controller.setJMonetRunner(runner);
    }
    
    @FXML
    private void clickOnReset(ActionEvent event){
        System.out.println("You clicked reset!");
        myCanvas = runner.getCurrentCanvas();
        myCanvas.getCanvas().clearCanvas();
    }
    
    @FXML
    private void colorRed(ActionEvent event){
        System.out.println("You clicked red!");
        runner.switchToolColor(new Color(235,38,31));
    }
    
    @FXML
    private void colorOrange(ActionEvent event){
        System.out.println("You clicked orange!");
        runner.switchToolColor(new Color(253,146,38));
    }
    
    @FXML
    private void colorYellow(ActionEvent event){
        System.out.println("You clicked yellow!");
        runner.switchToolColor(new Color(254,249,55));
    }
    
    @FXML
    private void colorGreen(ActionEvent event){
        System.out.println("You clicked green!");
        runner.switchToolColor(new Color(40,247,45));
    }
    
    @FXML
    private void colorBlue(ActionEvent event){
        System.out.println("You clicked blue!");
        runner.switchToolColor(new Color(16,63,251));
    }
    
    @FXML
    private void colorPurple(ActionEvent event){
        System.out.println("You clicked purple!");
        runner.switchToolColor(new Color(146,40,144));
    }
    
    @FXML
    private void colorBlack(ActionEvent event){
        System.out.println("You clicked black!");
        runner.switchToolColor(Color.BLACK);
    }
    
    @FXML
    private void colorWhite(ActionEvent event){
        System.out.println("You clicked white!");
        runner.switchToolColor(Color.WHITE);
    }
    
    @FXML
    private void colorFill(ActionEvent event){
        System.out.println("You clicked fill!");
        runner.switchToolType(PaintToolType.FILL);
    }
    
    @FXML
    private void clickText(ActionEvent event) throws IOException{
        System.out.println("You clicked the text button!");
        runner.switchToolType(PaintToolType.TEXT);
        //now, we will create a pop-up window
        
        //fist get the XML file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/TextAttributes.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        
        //then, set the scene from that file
        Scene scene = new Scene(p);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //set attributes of the window.
        stage.setTitle("Text Attributes");
        stage.setScene(scene);
        stage.show();
        
        // pass the JMonetRunner
        FXMLText controller = loader.getController();
        controller.setJMonetRunner(runner);
    }
    
    @FXML
    private void clickBrush(ActionEvent event) throws IOException{
        System.out.println("You clicked the brush button!");
        
        //now, we will create a pop-up window
        
        //fist get the XML file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/BrushAttributes.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        
        //then, set the scene from that file
        Scene scene = new Scene(p);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //set attributes of the window.
        stage.setTitle("Brush Attributes");
        stage.setScene(scene);
        stage.show();
        
        // pass the JMonetRunner
        FXMLBrush controller = loader.getController();
        controller.setJMonetRunner(runner);
    }
    
    @FXML
    private void clickCurve(ActionEvent event){
        System.out.println("You clicked the curve button!");
        runner.switchToolType(PaintToolType.CURVE);
    }
    
    @FXML
    private void clickImage(ActionEvent event){
        System.out.println("You clicked the image button!");
        Stage stage = new Stage(); 
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        File selectedDirectory = fileChooser.showOpenDialog(stage);

        if(selectedDirectory == null){ 
             //No Directory selected 
        } 
        else{ 
            boolean imageSuccessful = runner.insertImage(selectedDirectory.getAbsolutePath());
            System.out.println(selectedDirectory.getAbsolutePath());
            
            if (imageSuccessful == true) {
                //first get the XML file
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/ShapesAttributes.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    System.err.println("An error occurred.");
                    return;
                }
                Parent p = loader.getRoot();
        
                //then, set the scene from that file
                Scene scene = new Scene(p);
                scene.getStylesheets().add("/styles/Styles.css");
        
                //put the scene in a stage (new window)
                Stage stage2 = new Stage();
        
                //set attributes of the window.
                stage2.setTitle("Selection Attributes");
                stage2.setScene(scene);
                stage2.show();
        
                // pass the JMonetRunner
                FXMLShapes controller = loader.getController();
                controller.setJMonetRunner(runner);
            }
        }
    }
    
    @FXML
    private void clickLine(ActionEvent event) throws IOException{
        System.out.println("You clicked the line button!");
        runner.switchToolType(PaintToolType.LINE);
        
        //now, we will create a pop-up window
        
        //first, get the XML file
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LineAttributes.fxml"));
        
        //then, set the scene from that file
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //set attributes of the window.
        stage.setTitle("Line Attributes");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void clickGroup(ActionEvent event) throws IOException{
        System.out.println("You clicked the select button!");
        runner.switchToolType(PaintToolType.SELECTION);
        
        //fist get the XML file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/ShapesAttributes.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        
        //then, set the scene from that file
        Scene scene = new Scene(p);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //set attributes of the window.
        stage.setTitle("Selection Attributes");
        stage.setScene(scene);
        stage.show();
        
        // pass the JMonetRunner
        FXMLShapes controller = loader.getController();
        controller.setJMonetRunner(runner); 
    }
    
    @FXML
    private void clickZoomIn(ActionEvent event){
        System.out.println("You clicked the zoom in button!");
        runner.switchToolType(PaintToolType.MAGNIFIER);
    }
    
    @FXML
    private void clickZoomOut(ActionEvent event){
        System.out.println("You clicked the zoom out button!");
        runner.switchToolType(PaintToolType.MAGNIFIER);
    }
    
    @FXML
    private void clickSelect(ActionEvent event){
        System.out.println("You clicked the select button!");
        runner.switchToolType(PaintToolType.ARROW);   
    }
    
    @FXML
    private void clickPrint(ActionEvent event){
        System.out.println("You clicked the print button!");
    }
    
    @FXML
    private void clickRect(ActionEvent event) throws IOException {
        System.out.println("You clicked the rectangle button!");
        runner.switchToolType(PaintToolType.RECTANGLE);
        
        //now, we will create a pop-up window
        
         //fist get the XML file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/ShapesAttributes.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        
        //then, set the scene from that file
        Scene scene = new Scene(p);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //set attributes of the window.
        stage.setTitle("Shape Attributes");
        stage.setScene(scene);
        stage.show();
        
        // pass the JMonetRunner
        FXMLShapes controller = loader.getController();
        controller.setJMonetRunner(runner); 
    }
    
    @FXML
    private void clickOval(ActionEvent event) throws IOException{
        System.out.println("You clicked the oval button!");
        runner.switchToolType(PaintToolType.OVAL);
        
        //now, we will create a pop-up window
        
         //fist get the XML file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/ShapesAttributes.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        
        //then, set the scene from that file
        Scene scene = new Scene(p);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //set attributes of the window.
        stage.setTitle("Shape Attributes");
        stage.setScene(scene);
        stage.show();
        
        // pass the JMonetRunner
        FXMLShapes controller = loader.getController();
        controller.setJMonetRunner(runner); 
    }
    
    @FXML
    private void clickPoly(ActionEvent event) throws IOException{
        System.out.println("You clicked the polygon button!");
        runner.switchToolType(PaintToolType.POLYGON);
        
        //now, we will create a pop-up window
        
         //fist get the XML file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/ShapesAttributes.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        
        //then, set the scene from that file
        Scene scene = new Scene(p);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //set attributes of the window.
        stage.setTitle("Shape Attributes");
        stage.setScene(scene);
        stage.show();
        
        // pass the JMonetRunner
        FXMLShapes controller = loader.getController();
        controller.setJMonetRunner(runner);
    }
    
    @FXML
    private void clickEye(ActionEvent event){
        System.out.println("You clicked the eye dropper button!");
    }
    
    @FXML
    private void clickComment(ActionEvent event){
        System.out.println("You clicked the click comment button!");
    }
    
    @FXML
    private void clickShowComments(ActionEvent event){
        System.out.println("You clicked the show comment button!");
    }
    
    @FXML
    private void clickHelp(ActionEvent event){
        System.out.println("You clicked the help button!");
    }
    
    @FXML
    private void writeFileName(ActionEvent event){
        System.out.println("You clicked the file name button!");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         JFXPaintCanvasNode myCanvas = new JFXPaintCanvasNode(new JMonetCanvas());
        
        runner = new JMonetRunner();
        runner.startJMonet();
        
        myCanvas = runner.currentCanvas;
        aPane.getChildren().add(myCanvas);
        myCanvas.getCanvas().setSize(1140, 595);
        myCanvas.getCanvas().getCursor();
        
        //getting canvas coordinates of mouse
        myCanvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                currX.setText(Integer.toString((int) Math.round(event.getX())));
                currY.setText(Integer.toString((int) Math.round(event.getY())));
            }
        });  
    }    
}
