/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml2;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class ListePremierController implements Initializable {

    @FXML
    private TextField rechercheZone;
    @FXML
    private ListView<String> listeEleve;
    @FXML
    private ImageView CartePhoto;
    @FXML
    private Text nom;
    @FXML
    private Text postnom;
    @FXML
    private Text ville;
    @FXML
    private Text age;
    @FXML
    private Text prenom;
    @FXML
    private Text genre;
 

      ObservableList<String> listes = FXCollections.observableArrayList();
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         listes = select();
         listeEleve.setItems(listes);
        listeEleve.setCellFactory(TextFieldListCell.forListView());
        listeEleve.setEditable(true);
        listeEleve.setCellFactory(c-> new CellColor());
          //==================================================================
                        //la selection multiple de cellule d'une liste
        //==================================================================
        
             // liste.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       
       
       //======================================================================
                        //recuperation de forme 
        //=====================================================
                // liste.setCellFactory(c-> new CellColor());
        
    }    

    /*
                     bouton de recherche 
    */
    @FXML
    private void BtnRecherche(ActionEvent event) {
        
    }

      /*
                     bouton pour afficher
    */
    @FXML
    private void afficherInfo(ActionEvent event) {
         try{ 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
       
         
             PreparedStatement pst = con.prepareStatement("select Images,Nom,Postnom,Prenom,Genre,Adresse from premiere where Nom=?");
             pst.setString(1, listeEleve.getSelectionModel().getSelectedItem());
             ResultSet r = pst.executeQuery();
                   byte tab[];
           if(r.next())
           {
               tab = r.getBytes("Images");
               Image im = new Image(new ByteArrayInputStream(tab),CartePhoto.getFitHeight(),CartePhoto.getFitWidth(),true,true);
               CartePhoto.setImage(im);
               nom.setText(r.getString("Nom"));
               postnom.setText(r.getString("Postnom"));
               prenom.setText(r.getString("Prenom"));
               genre.setText(r.getString("Genre"));
               ville.setText(r.getString("Adresse"));
                       
           }
           con.close(); 
           
    }catch(Exception e)
    {	
        e.printStackTrace();
    }
    }
    
      Connection con = null;
    public ObservableList<String> select()
    {  
        
         ObservableList<String> li = FXCollections.observableArrayList();
        try{
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
         Statement s = (Statement) con.createStatement();
           
           ResultSet rs = s.executeQuery("select Nom from premiere");
         //  NomSeul nb = new NomSeul();
         //  String nom = rs.getString(nb.getNom());
           while(rs.next()) {               
               li.addAll(rs.getString("nom"));
           }
          	
								

           System.out.println("Connecter avec succer!!");
           con.close();
           
           
       }catch(Exception e)
       {
           
       }
        return li;
    }
    
       public class CellColor extends ListCell<String> {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                           super.updateItem(item, empty);
                           setGraphic(null);
                           setText(null);
                    if (item != null) {
                               Image image  = new Image("/icons/student_male_96px.png",30, 30, empty, empty);
                               setGraphic(new ImageView(image));
                               setText(item.toString().trim());
                    }
                 }
       }
}
