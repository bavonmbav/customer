
package menu;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


public class Menu2Controller implements Initializable {

    @FXML
    private AnchorPane barmenu;
    @FXML
    private TextField nom1;
    @FXML
    private TextField postnom;
    @FXML
    private TextField adrress;
    @FXML
    private TextField prenom;
    @FXML
    private TextField telephone;
    @FXML
    private TextField sexe;
    @FXML
    private Label imalabe;
    @FXML
    private ImageView view;
    private FileInputStream tream;
    private Image image;
    private File fil;
    
    FileChooser chosse = new FileChooser();
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         chosse.setInitialDirectory(fil);
   
    }    

    @FXML
    private void ajouter(ActionEvent event) {
         String nom = nom1.getText();
        String post = postnom.getText();
        String pren  = prenom.getText();
        String adr = adrress.getText();
        String tel = telephone.getText();
        telephone.setText("+243" + tel);
        String btn = sexe.getText();
        
        if(btn.equals("F") || btn.equals("M") || btn.equals("m") || btn.equals("f"))
        {  
        String sql = "INSERT INTO deuxieme(Nom,PostNom,Prenom,Genre,Adresse,Images,Telephone) VALUES (?,?,?,?,?,?,?)";
        try{
         Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
         PreparedStatement pst = con.prepareStatement(sql);
         pst.setString(1, nom);
         pst.setString(2, post);
         pst.setString(3, pren);
         pst.setString(4,btn);
         pst.setString(5, adr);
         
         tream = new FileInputStream(fil);
         pst.setBinaryStream(6, (InputStream)tream, (int)fil.length());
         pst.setString(7, tel);
        
       
       
        boolean execute = pst.execute();
            clear();
        
         con.close();
         
         
         
         
           Notifications  not = Notifications.create();
            not.graphic(null);
            not.title("SUCCES");
            not.text("ajouter");
            not.hideAfter(Duration.seconds(4));
           not.position(Pos.BOTTOM_RIGHT);
           not.onAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                  
                }
            });
           
            not.showConfirm();
          }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        }
        else{
             Notifications  not = Notifications.create();
            not.graphic(null);
            not.title("Erreur");
            not.text("le genre doit etre 'F' ou 'M' ou 'f' et 'm'");
            not.hideAfter(Duration.seconds(4));
           not.position(Pos.BOTTOM_RIGHT);
           not.onAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                  
                }
            });
           
            not.showError();
        } 
    }

    @FXML
    private void shoix(MouseEvent event) {
          try{
         Stage s = new Stage();
        chosse.getExtensionFilters().addAll(new  FileChooser.ExtensionFilter("imgas", "*.png","*.jpg"));
        fil = chosse.showOpenDialog(s);
//        chosse.setInitialDirectory(fil.getParentFile());
        if(fil != null)
        {
            imalabe.setText(fil.getAbsolutePath());
             image = new Image(fil.toURI().toString(),100,150,true,true);
            view.setImage(image); 
            view.setFitWidth(100);
            view.setFitHeight(150);
            view.setPreserveRatio(true);
            
        }
       
       
        
           
     }catch(Exception ex)
     {
      ex.printStackTrace();
     }
     
    }
     public void clear()
    {   nom1.setText("");
        postnom.setText("");
        prenom.setText("");
        adrress.setText("");
        telephone.setText("");
        sexe.setText("");
        sexe.setText("");
        Image im = new Image("/images/searchx.png");
        view.setImage(im);
        imalabe.setVisible(false);
        
    }
}
