package com.mycompany.acrylix2;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class MainApp extends Application {
    
    JMonetRunner runner;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        StackPane realRoot = new StackPane(root);
        realRoot.setStyle("-fx-background: rgb(51,51,51)rgb(51,51,51);");

        NumberBinding maxScale = Bindings.min(realRoot.widthProperty().divide(1500), realRoot.heightProperty().divide(500));
        root.scaleXProperty().bind(maxScale);
        root.scaleYProperty().bind(maxScale);
        
        Scene scene = new Scene(realRoot);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("AcryliX");
        stage.setScene(scene);        
        stage.show();
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
