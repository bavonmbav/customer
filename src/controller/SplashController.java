
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


public class SplashController implements Initializable {

    @FXML
    private AnchorPane parent;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FormeNavigue.boucheApp(parent, Duration.seconds(5), (e)->{
            try {
              
                
                   // System.exit(0);
                    Parent fxml = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
                   // parent.setVisible(false);
                    parent.getChildren().sorted();
                    parent.getChildren().setAll(fxml);
                
                
             
                
            } catch (IOException ex) {
              ex.printStackTrace();
            }
        });
    }    
    
}
