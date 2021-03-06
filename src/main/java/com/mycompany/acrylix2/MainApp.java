package com.mycompany.acrylix2;

import java.awt.SplashScreen;
import javafx.scene.image.Image;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.ImageIcon;
import sun.applet.Main;


public class MainApp extends Application {
    
    JMonetRunner runner;

    final SplashScreen splash = SplashScreen.getSplashScreen();

    @Override
    public void start(Stage stage) throws IOException {
                
        //first, remove splash screen
        //Close splashscreen
        if (splash != null) {
            System.out.println("Closing splashscreen...");
            splash.close();
        }
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        StackPane realRoot = new StackPane(root);
        realRoot.setPrefSize(1440.0, 720.0);
        realRoot.setStyle("-fx-background: rgb(51,51,51)rgb(51,51,51);");

        NumberBinding maxScale = Bindings.min(realRoot.widthProperty().divide(1500), realRoot.heightProperty().divide(500));
        root.scaleXProperty().bind(maxScale);
        root.scaleYProperty().bind(maxScale);
        
        Scene scene = new Scene(realRoot);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("AcryliX");
        stage.setScene(scene);   
        
        Image img = new Image(getClass().getResourceAsStream("/icons/logo.png"));
        stage.getIcons().add(img);
        stage.show();
        
        
        //below code is used to properly close the window.
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
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
       
        
        String osName = System.getProperty("os.name").toLowerCase();
        boolean isMacOs = osName.startsWith("mac");    
        
        if (isMacOs) {
            try {
                URL iconURL = Main.class.getResource("/icons/logo.png");
                java.awt.Image image = new ImageIcon(iconURL).getImage();
                com.apple.eawt.Application.getApplication().setDockIconImage(image);
            } catch (Exception e) {
            // Won't work on Windows or Linux.
            }
        }
        
        launch(args);
    }
    
}
