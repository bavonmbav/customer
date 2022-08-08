
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class SplashController implements Initializable {

    @FXML
    private AnchorPane parent;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FormeNavigue.boucheApp(parent, Duration.seconds(2), (e)->{
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
            double i = 0, y = 0;
    @FXML
    private void dragged(MouseEvent event) {
                  Node node = (Node)event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        
        stage.setX(event.getScreenX()-i);
        stage.setY(event.getScreenY()-y);
    }

    @FXML
    private void presse(MouseEvent event) {
        i = event.getSceneX();
        y = event.getSceneY();
    }
    
}
