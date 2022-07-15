
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class LoginController implements Initializable {

    @FXML
    private AnchorPane parent;
    @FXML
    private TextField name;
    @FXML
    private TextField passe;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void connecte(ActionEvent event) {
        
    }
    
}
