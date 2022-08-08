
package controller;


import classes.Eleve;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class AceuilController implements Initializable {

    @FXML
    private AnchorPane fils;
    @FXML
    private Pane pane;
    @FXML
    private ImageView ouvre;
    @FXML
    private ImageView ferm;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
        
       
       
    }    

    @FXML
    private void menu() {
       pane.setVisible(true);
        ferm.setVisible(true);
        ouvre.setVisible(false);

    }

    @FXML
    private void fermer(MouseEvent event) {
         pane.setVisible(false);
        ferm.setVisible(false);
        ouvre.setVisible(true);
    }

    @FXML
    private void homeLogin(ActionEvent event) {
        fils.getScene().getWindow().hide();
        Stage s = new Stage();
        try{
               Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
               s.setScene(new Scene(root));
               s.initStyle(StageStyle.TRANSPARENT);
               s.show();
               
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
     
        
    }
//==================fermeture du systeme========
    @FXML
    private void clases(MouseEvent event) {
        System.exit(0);
    }
///===================inscription des eleves ==========
    @FXML
    private void inscription(ActionEvent event) {
       
        
    }
//=================impresion de facture=========
    @FXML
    private void imprimer(ActionEvent event) {
    }
//================= tableau des frais d'etude=========
    @FXML
    private void paiement(ActionEvent event) {
        
    }
//========================= voir les differente cours et les tables de nom des eleves====
    @FXML
    private void promotion(ActionEvent event) throws IOException, Exception {
               fils.getScene().getWindow().hide();
              Stage primaryStage = new Stage();
               Parent root = FXMLLoader.load(getClass().getResource("/fxml2/cours.fxml"));
               Scene sc = new Scene(root);
               sc.setFill(Color.TRANSPARENT);
               primaryStage.setScene(sc);
//               primaryStage.initStyle(StageStyle.TRANSPARENT);
               primaryStage.show();
     
       
    }
//===================================================================================
   
    
 //============================les classe et leurs tables de base de doonnes========
    @FXML
    private void premier(ActionEvent event) {
         fils.getScene().getWindow().hide();
         Stage s = new Stage();
        try{
               Parent root = FXMLLoader.load(getClass().getResource("/fxml/tabledebase.fxml"));
               s.setScene(new Scene(root));
              s.initStyle(StageStyle.UNDECORATED);
               s.show();
               
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @FXML
    private void deuxieme(ActionEvent event) {
         fils.getScene().getWindow().hide();
          Stage s = new Stage();
        try{
               Parent root = FXMLLoader.load(getClass().getResource("/fxml/table2.fxml"));
               s.setScene(new Scene(root));
            s.initStyle(StageStyle.UNDECORATED);
               s.show();
               
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @FXML
    private void troixieme(ActionEvent event) {
         fils.getScene().getWindow().hide();
          Stage s = new Stage();
        try{
               Parent root = FXMLLoader.load(getClass().getResource("/fxml/table3.fxml"));
               s.setScene(new Scene(root));
             s.initStyle(StageStyle.UNDECORATED);
               s.show();
               
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }

    @FXML
    private void quatriem(ActionEvent event) {
         fils.getScene().getWindow().hide();
          Stage s = new Stage();
        try{
               Parent root = FXMLLoader.load(getClass().getResource("/fxml/table4.fxml"));
               s.setScene(new Scene(root));
             s.initStyle(StageStyle.UNDECORATED);
               s.show();
               
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }

    @FXML
    private void cinquieme(ActionEvent event) {
         fils.getScene().getWindow().hide();
          Stage s = new Stage();
        try{
               Parent root = FXMLLoader.load(getClass().getResource("/fxml/table5.fxml"));
               s.setScene(new Scene(root));
              s.initStyle(StageStyle.UNDECORATED);
               s.show();
               
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @FXML
    private void sixieme(ActionEvent event) {
         fils.getScene().getWindow().hide();
          Stage s = new Stage();
        try{
               Parent root = FXMLLoader.load(getClass().getResource("/fxml/table6.fxml"));
               s.setScene(new Scene(root));
               s.initStyle(StageStyle.UNDECORATED);
               s.show();
               
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
