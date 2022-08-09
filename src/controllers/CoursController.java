
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BvNet
 */
public class CoursController implements Initializable {

    @FXML
    private BorderPane border;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml2/courspage.fxml"));
             border.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void listePremier(ActionEvent event) {
          Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml2/listePremier.fxml"));
             border.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void listeDeux(ActionEvent event) {
           Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml2/listeDeuxieme.fxml"));
             border.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void listeTrois(ActionEvent event) {
           Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml2/listeTrois.fxml"));
             border.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ListeQuatre(ActionEvent event) {
           Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml2/listequatre.fxml"));
             border.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void listeCinq(ActionEvent event) {
           Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml2/listeCinq.fxml"));
             border.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ListeSix(ActionEvent event) {
           Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml2/listeSix.fxml"));
             border.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
          border.getScene().getWindow().hide();
                    Stage s = new Stage();

                   Parent root = FXMLLoader.load(getClass().getResource("/fxml/Aceuil.fxml"));
                    s.setScene(new Scene(root));
                    s.setResizable(false);
                    s.show();
      
    }
    
}
