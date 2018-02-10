package com.mycompany.acrylix2;

import com.defano.jmonet.canvas.JFXPaintCanvasNode;
import com.defano.jmonet.canvas.JMonetCanvas;
import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.brushes.BasicBrush;
import com.defano.jmonet.tools.builder.PaintTool;
import com.defano.jmonet.tools.builder.PaintToolBuilder;
import java.awt.Color;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        // Create a JFX node for our paint canvas
        JFXPaintCanvasNode myCanvas = new JFXPaintCanvasNode(new JMonetCanvas());

        // Create a pane for it
        StackPane pane = new StackPane();
        pane.getChildren().add(myCanvas);

        // And add it to our stage
        stage.setScene(new Scene(pane, 640, 480));
        stage.show();
        
        PaintTool activeTool = PaintToolBuilder.create(PaintToolType.PAINTBRUSH)
        .withStroke(BasicBrush.ROUND_8X8.stroke)
        .withFillPaint(Color.RED)
        .makeActiveOnCanvas(myCanvas)
        .build();
    }



    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
