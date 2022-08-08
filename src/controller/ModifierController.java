/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author BvNet
 */
public class ModifierController implements Initializable{

    @FXML
     TextField noms;
    @FXML
     TextField prenoms;
    @FXML
     TextField postnoms;
    @FXML
     TextField genres;
    @FXML
     TextField adressss;
    @FXML
     TextField telephoness;
    @FXML
     ImageView image;
    @FXML
     Label imalabe;
    
      private FileInputStream tream;
    private Image images;
    private File fil;
  FileChooser chosse = new FileChooser();
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          chosse.setInitialDirectory(fil);
    }  

    @FXML
        private void setImga(MouseEvent event) {
         try{
         Stage s = new Stage();
        chosse.getExtensionFilters().addAll(new  FileChooser.ExtensionFilter("imgae", "*.png","*jpg"));
        fil = chosse.showOpenDialog(s);
//        chosse.setInitialDirectory(fil.getParentFile());
        if(fil != null)
        {
            imalabe.setText(fil.getAbsolutePath());
             images = new Image(fil.toURI().toString(),100,150,true,true);
            image.setImage(images); 
            image.setFitWidth(100);
            image.setFitHeight(150);
            image.setPreserveRatio(true);
            
        }
       
       
        
           
     }catch(Exception ex)
     {
      ex.printStackTrace();
     }
     
    }

          @FXML
    private void setmodie(ActionEvent event) {
        try {
            String sql ="update premiere set Postnom=?,Prenom=? ,Genre =?,Adresse=?,Images=?,telephone=? where Nom=?";
            Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
            PreparedStatement pst = con.prepareStatement(sql);
         pst.setString(1, noms.getText());
         pst.setString(2, postnoms.getText());
         pst.setString(3, prenoms.getText());
         pst.setString(4,genres.getText());
         pst.setString(5, adressss.getText());
         
         tream = new FileInputStream(fil);
         pst.setBinaryStream(6, (InputStream)tream, (int)fil.length());
         pst.setString(7, telephoness.getText());
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace();
        }
    }
        

    
}
