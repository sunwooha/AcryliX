package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.model.PaintToolType;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import com.sun.javafx.robot.FXRobot;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.util.ArrayList;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Slider;
import javafx.scene.transform.Scale;
import javax.print.PrintException;

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
    private TextField goToX;
    
    @FXML
    private TextField goToY;
    
    public int width;
    
    public int height;
    
    public int xCoordinate;
    
    public int yCoordinate;
    
    public Button goButton;
    
    public int gotox = -1;
    
    public int gotoy = -1;
    
    public int currentX;
    
    public int currentY;
    
    public ArrayList<String> comments;
    
    @FXML
    private Slider size;
    
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
        
        //move window to leftmost side
        stage.setX(1);
        stage.setY(1);
        
        //set transparency
        stage.setOpacity(0.85);
        
        //window stays on top
        stage.setAlwaysOnTop(true);

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
    private void colorGradient(ActionEvent event) throws IOException {
        System.out.println("You clicked gradient!");
        runner.switchToolColor(runner.getGradientColor());
        
        //fist get the XML file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/GradientAttributes.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        
        //then, set the scene from that file
        Scene scene = new Scene(p);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //move window to leftmost side
        stage.setX(1);
        stage.setY(1);
        
        //set transparency
        stage.setOpacity(0.85);
        
        //window stays on top
        stage.setAlwaysOnTop(true);
        
        //set attributes of the window.
        stage.setTitle("Gradient Attributes");
        stage.setScene(scene);
        stage.show();
        
        // pass the JMonetRunner 
        FXMLGradient controller = loader.getController(); 
        controller.setJMonetRunner(runner);
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
        
        //set transparency
        stage.setOpacity(0.85);
        
        //move window to leftmost side
        stage.setX(0);
        stage.setY(0);
        
        //window stays on top
        stage.setAlwaysOnTop(true);
        
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
        runner.switchToolType(PaintToolType.PAINTBRUSH);
        
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
        
        //set transparency
        stage.setOpacity(0.85);

        //move window to leftmost side
        stage.setX(0);
        stage.setY(0);
        
        //window stays on top
        stage.setAlwaysOnTop(true);
        
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
                loader.setLocation(getClass().getResource("/fxml/SelectionAttributes.fxml"));
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
        
                //move window to leftmost side
                stage2.setX(0);
                stage2.setY(0);
                
                //set transparency
                stage2.setOpacity(0.85);
                
                //window stays on top
                stage2.setAlwaysOnTop(true);
                
                //set attributes of the window.
                stage2.setTitle("Selection Attributes");
                stage2.setScene(scene);
                stage2.show();
        
                // pass the JMonetRunner
                FXMLSelection controller = loader.getController();
                controller.setJMonetRunner(runner);
            }
        }
    }
    
    @FXML
    private void clickLine(ActionEvent event) throws IOException{
        System.out.println("You clicked the line button!");
        runner.switchToolType(PaintToolType.LINE);
        
        //now, we will create a pop-up window
        
        //fist get the XML file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/LineAttributes.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        
        //then, set the scene from that file
        Scene scene = new Scene(p);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //move window to leftmost side
        stage.setX(0);
        stage.setY(0);
        
        //set transparency
        stage.setOpacity(0.85);
        
        //window stays on top
        stage.setAlwaysOnTop(true);
        
        //set attributes of the window.
        stage.setTitle("Line Attributes");
        stage.setScene(scene);
        stage.show();
        
        // pass the JMonetRunner
        FXMLLine controller = loader.getController();
        controller.setJMonetRunner(runner); 
    }
    
    @FXML
    private void clickGroup(ActionEvent event) throws IOException{
        System.out.println("You clicked the select button!");
        runner.switchToolType(PaintToolType.SELECTION);
        
        //fist get the XML file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/SelectionAttributes.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        
        //then, set the scene from that file
        Scene scene = new Scene(p);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //move window to leftmost side
        stage.setX(0);
        stage.setY(0);
        
        //set transparency
        stage.setOpacity(0.85);
        
        //window stays on top
        stage.setAlwaysOnTop(true);
        
        //set attributes of the window.
        stage.setTitle("Selection Attributes");
        stage.setScene(scene);
        stage.show();
        
        // pass the JMonetRunner
        FXMLSelection controller = loader.getController();
        controller.setJMonetRunner(runner); 
    }
    
    @FXML
    private void clickZoomIn(ActionEvent event){
        System.out.println("You clicked the zoom in button!");
        double scale = runner.getCurrentCanvas().getCanvas().getScale();
        if(scale >= 100){
            //nothing
        }
        else{
            runner.getCurrentCanvas().getCanvas().setScale(scale*2);
        }
    }
    
    @FXML
    private void clickZoomOut(ActionEvent event){
        System.out.println("You clicked the zoom out button!");
        double scale = runner.getCurrentCanvas().getCanvas().getScale();
        if (scale == 1){
            //nothing
        }
        else{
            runner.getCurrentCanvas().getCanvas().setScale(scale/2);
        }
        
        //runner.switchToolType(PaintToolType.MAGNIFIER);
    }
    
    @FXML
    private void clickSelect(ActionEvent event){
        System.out.println("You clicked the select button!");
        runner.switchToolType(PaintToolType.ARROW);   
    }
    
    @FXML
    private void clickPrint(ActionEvent event) throws PrintException{
        System.out.println("You clicked the print button!");
        Printer defaultPrinter = Printer.getDefaultPrinter();
        WritableImage canvasImage = new WritableImage(1140, 595);
        SnapshotParameters snapshotParams = new SnapshotParameters();
        canvasImage = runner.getCurrentCanvas().snapshot(snapshotParams, canvasImage);
        
        ImageView image = new ImageView(canvasImage);
        PrinterJob job = PrinterJob.createPrinterJob();
        
        if(defaultPrinter != null){
            String name = defaultPrinter.getName();
            System.out.println("Default printer name: " + name);
      
            if(job != null){
                PageLayout pageLayout = job.getJobSettings().getPageLayout();
                pageLayout = defaultPrinter.createPageLayout(pageLayout.getPaper(), PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
                job.getJobSettings().setPageLayout(pageLayout);
                if (job.showPrintDialog(runner.getCurrentCanvas().getScene().getWindow())) {
                    pageLayout = job.getJobSettings().getPageLayout();
                    final double scale = Math.min(pageLayout.getPrintableWidth() / image.getBoundsInParent().getWidth(), pageLayout.getPrintableHeight() / image.getBoundsInParent().getHeight());
                    image.getTransforms().add(new Scale(scale, scale));
                    if (job.printPage(image)) {
                        System.out.println("Printing " + job.getJobSettings().getJobName() + " to " + name);
                        job.endJob();
                    }
                    else{
                        System.out.println("Printing failed");
                    }
                }
            } 
        }
        else{
            System.out.println("No printers installed!");
        }
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
        
        //move window to leftmost side
        stage.setX(0);
        stage.setY(0);
        
        //set transparency
        stage.setOpacity(0.85);
        
        //window stays on top
        stage.setAlwaysOnTop(true);
        
        //set attributes of the window.
        stage.setTitle("Shape Attributes");
        stage.setScene(scene);
        stage.show();
        
        // pass the JMonetRunner
        FXMLShapes controller = loader.getController();
        controller.setJMonetRunner(runner);
        width = controller.w;
        height = controller.h;
        xCoordinate = controller.x;
        yCoordinate = controller.y;
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
        
        //move window to leftmost side
        stage.setX(0);
        stage.setY(0);
        
        //set transparency
        stage.setOpacity(0.85);
        
        //window stays on top
        stage.setAlwaysOnTop(true);
        
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
        loader.setLocation(getClass().getResource("/fxml/PolygonAttributes.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        
        //then, set the scene from that file
        Scene scene = new Scene(p);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //move window to leftmost side
        stage.setX(0);
        stage.setY(0);
        
        //set transparency
        stage.setOpacity(0.85);
        
        //window stays on top
        stage.setAlwaysOnTop(true);
        
        //set attributes of the window.
        stage.setTitle("Polygon Attributes");
        stage.setScene(scene);
        stage.show();
        
        // pass the JMonetRunner
        FXMLPolygon controller = loader.getController();
        controller.setJMonetRunner(runner);
    }
    
    @FXML
    private void clickEye(ActionEvent event){
        System.out.println("You clicked the eye dropper button!");
        runner.startEyeDropper();
    }
    
    @FXML
    private void clickComment(ActionEvent event) throws IOException{
        System.out.println("You clicked the click comment button!");
        
        //now, we will create a pop-up window
        
        //fist get the XML file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/CommentsAttributes.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        
        //then, set the scene from that file
        Scene scene = new Scene(p);
        scene.getStylesheets().add("/styles/Styles.css");
        
        //put the scene in a stage (new window)
        Stage stage = new Stage();
        
        //move window to leftmost side
        stage.setX(0);
        stage.setY(0);
        
        //set transparency
        stage.setOpacity(0.85);
        
        //window stays on top
        stage.setAlwaysOnTop(true);

        stage.setTitle("Comments");
        stage.setScene(scene);
        stage.show();
        
        
    }
    
    @FXML
    private void clickShowComments(ActionEvent event) throws IOException{
        System.out.println("You clicked the show comment button!");
        
        
        for(int i = 0; i < comments.size(); i++) {
            System.out.println(comments.get(i));
        }
    }
    
    @FXML
    private void clickHelp(ActionEvent event){
        System.out.println("You clicked the help button!");
    }
    
    @FXML
    private void writeFileName(ActionEvent event){
        System.out.println("You clicked the file name button!");
    }
    
    @FXML
    private void clickUndo(ActionEvent event){
        JMonetCanvas canvas = (JMonetCanvas) runner.getCurrentCanvas().getCanvas();
        if(canvas.undo()){
            System.out.println("Undo works!");
        }
        else{
            System.out.println("Theres nothing to undo");
        }
    }
    
    @FXML
    private void clickRedo(ActionEvent event){
        JMonetCanvas canvas = (JMonetCanvas) runner.getCurrentCanvas().getCanvas();
        if(canvas.redo()){
            System.out.println("Redo");
        }
        else{
            System.out.println("Theres nothing to redo");
        }
        
    }
    
    @FXML
    private void goToXCoordinate(ActionEvent event){
        gotox = Integer.parseInt(goToX.getText());
    }
    
    @FXML
    private void goToYCoordinate(ActionEvent event){
        gotoy = Integer.parseInt(goToY.getText());
    }
    
    @FXML
    private void goToCoords(ActionEvent event){
        if(gotox >= 0 && gotoy >= 0){
            Point p = new Point(currentX, currentY);
            p.move(gotox, gotoy);
            System.out.println("moving to " + gotox + ", " + gotoy);
            try {           
                Robot robot = new Robot();
                robot.mouseMove((381 + (int) p.getX()), (217 +(int) p.getY()));
            }
            catch (AWTException e) {
            e.printStackTrace();
            }
        }
        else{
            System.out.println("Please put in correct coordinates!");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        JFXPaintCanvasNode myCanvas = new JFXPaintCanvasNode(new JMonetCanvas());
                
        runner = new JMonetRunner();
        runner.startJMonet();
        
        myCanvas = runner.currentCanvas;
        
        
        aPane.getChildren().add(myCanvas);
        myCanvas.getCanvas().setSize((int) aPane.getPrefWidth(), (int) aPane.getPrefHeight());
        myCanvas.getCanvas().setScrollPosition(0.01, 0.01);
        
        //getting canvas coordinates of mouse
        myCanvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                currentX = (int) Math.round(event.getX());
                currentY = (int) Math.round(event.getY());
                currX.setText(Integer.toString(currentX));
                currY.setText(Integer.toString(currentY));
            }
        });  
        
        size.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Slider Value Changed (newValue: " + newValue.intValue() + ")\n");
                runner.switchToolSize((double) newValue.intValue());
            }
        });
    }    
}
