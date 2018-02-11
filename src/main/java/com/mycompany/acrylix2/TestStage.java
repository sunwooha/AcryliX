package com.mycompany.acrylix2;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import com.defano.jmonet.canvas.JFXPaintCanvasNode;
 
// This is just a placeholder so that I can test stuff.
public class TestStage extends Stage {
 
    TestStage(JFXPaintCanvasNode canvas) {
 
        // Create a pane for it
        StackPane pane = new StackPane();
        pane.getChildren().add(canvas);
 
        // And add it to our stage
        this.setScene(new Scene(pane, 640, 480));
        this.show();
    }
}
 
