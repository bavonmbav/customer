package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class LoginController implements Initializable {

    Connection con = null;
    PreparedStatement st;
    ResultSet r;

    @FXML
    private AnchorPane parent;
    @FXML
    private TextField name;
 

    Parent root;
    @FXML
    private Label labelaf;
    @FXML
    private CheckBox select;
    @FXML
    private PasswordField passes;
    @FXML
    private TextField passewtxt;
    @FXML
    private Label MessageError;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // con = MyConnexion.conneDb();
    }
// connexion a la base et lanccement de home page

    @FXML
    private void connecte(ActionEvent event) {  
        
        String user = name.getText();
        String passew = passes.getText();
        /*============================================================================
        *
        *           controler les cases si elles sont vide.
        *           une notification est creer d'erreure
        *=============================================================================
        */
        if(user.isEmpty() && passew.isEmpty()){
            MessageError.setText("Completez les cases!");
            Notifications  not = Notifications.create();
            not.graphic(null);
            not.title("Erreur");
            not.text("Veuillez compler  toutes les cases svp!");
            not.hideAfter(Duration.seconds(4));
           not.position(Pos.BOTTOM_RIGHT);
           not.onAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                }
            });
           
            not.showError();
        }
         /*============================================================================
        *
        *           controler la case User si elle est vide.
        *           une notification est creer d'erreure
        *=============================================================================
        */
         
        else if(user.isEmpty())
         {
               MessageError.setText("Completez le User!");
            Notifications  not = Notifications.create();
            not.graphic(null);
            not.title("Erreur");
            not.text("Veuillez compler  la case User svp!");
            not.hideAfter(Duration.seconds(4));
           not.position(Pos.BOTTOM_RIGHT);
           not.onAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                }
            });
           
            not.showError();
         }
         /*============================================================================
        *
        *           controler la case PassWord si elle est vide.
        *           une notification est creer d'erreure
        *=============================================================================
        */
       else if(passew.isEmpty())
         {
               MessageError.setText("Completez  le passWord!");
            Notifications  not = Notifications.create();
            not.graphic(null);
            not.title("Erreur");
            not.text("Veuillez compler la case PassWord svp!");
            not.hideAfter(Duration.seconds(4));
           not.position(Pos.BOTTOM_RIGHT);
           not.onAction((ActionEvent event1) -> {
               });
           
            not.showError();
         }
      //  String sql = "SELECT * FROM login";
        try {
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
           Statement st = (Statement) con.createStatement();
           
           ResultSet r = st.executeQuery("select * from login");
            if (r.next()) {
                MessageError.setText("");
                if (user.equals(r.getString("Users")) && passew.equals(r.getString("passeWord"))) {
                    //femeture de la fenetre login et lancement de la page home

                    parent.getScene().getWindow().hide();
                    Stage s = new Stage();

                    root = FXMLLoader.load(getClass().getResource("/fxml/Aceuil.fxml"));
                    s.setScene(new Scene(root));
                    s.setResizable(false);
                    s.show();
                      Notifications  not = Notifications.create();
            not.graphic(null);
            not.title("Succes...");
            not.text("connection reussite");
            not.hideAfter(Duration.seconds(4));
           not.position(Pos.BOTTOM_RIGHT);
           not.onAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                  
                }
            });
           
            not.showConfirm();
                   
                } 
                 /*============================================================================
        *
        *           verifier sinon si le mot de passe et le nom sont incorrecte
        *=============================================================================
        */
                 if (!user.equals(r.getString("Users")) && !passew.equals(r.getString("passeWord"))) 
                {
                    MessageError.setText("");
                    Notifications  not = Notifications.create();
            
                              /*============================================================================
        *
        *          verifier sinon si  le nom est incorrecte
        *=============================================================================
        */                  if (!user.equals(r.getString("Users")))
                         {MessageError.setText("");
                 
                                not.graphic(null);
                                not.title("Erreur");
                                not.text("les informations sont incorrecte pour le User ");
                                not.hideAfter(Duration.seconds(4));
                               not.position(Pos.BOTTOM_RIGHT);
                               not.onAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                      
                                    }
                                });
           
                                            not.showError();
        }
                 /*============================================================================
        *
        *           verifier sinon si le mot de passe  est incorrecte
        *=============================================================================
                            */else if (!passew.equals(r.getString("passeWord")))
                            {MessageError.setText("");

                                not.graphic(null);
                                not.title("Erreur");
                                not.text("les informations sont incorrecte pour le PassWord ");
                                not.hideAfter(Duration.seconds(4));
                               not.position(Pos.BOTTOM_RIGHT);
                               not.onAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                      
                                    }
                                });

                                not.showError();
        }
        
            else
        {
                                    not.graphic(null);
                                    not.title("Erreur");
                                    not.text("les informations sont incorrecte pour le User et PassWord");
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
       
        
        
        else {
                   
                }
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void selection(ActionEvent event) {
         if(select.isSelected())
            
        {
            passewtxt.setText(passes.getText());
            passes.setVisible(false);
            passewtxt.setVisible(true);
            labelaf.setText("Masquer le mot de passe");
           
        }
        else
        {
            passes.setText(passewtxt.getText());
            passes.setVisible(true);
            passewtxt.setVisible(false);
            labelaf.setText("Afficher le mot de passe");
        }
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

    @FXML
    private void clase(MouseEvent event) {
        System.exit(0);
    }

}
