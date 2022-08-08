
package tableClasse;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.Eleves;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Table6Controller implements Initializable {

    @FXML
    private TableView<Eleves> tableaux;
    @FXML
    private TableColumn<Eleves, String> nom;
    @FXML
    private TableColumn<Eleves, String> postnom;
    @FXML
    private TableColumn<Eleves, String> prenom;
    @FXML
    private TableColumn<Eleves, String> Genre;
    @FXML
    private TableColumn<Eleves, String> Adresse;
    @FXML
    private TableColumn<Eleves, String> tellephone;
    @FXML
    private TextField filter;
    @FXML
    private TableColumn<Eleves, String> Date;
    @FXML
    private TableColumn<Eleves, String> affiche1;
    @FXML
    private TextField noms;
    @FXML
    private TextField prenoms;
    @FXML
    private TextField postnoms;
    @FXML
    private TextField genres;
    @FXML
    private TextField adressss;
    @FXML
    private TextField telephoness;
    @FXML
    private Label nombre;
    @FXML
    private Label garcon;
    @FXML
    private Label file;
    @FXML
    private AnchorPane pare;
 
   
  
  
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         actualiser();
        clicedTable();
        rechercheTextField();
        NombreGarcons();
        NombreFille();
        NombreGenrale();
    }    
//=======================une liste pour lenom ============================
    ObservableList<Eleves> list = FXCollections.observableArrayList();
    
   //======================base de donnes=================
    Connection con = null;
    public ObservableList<Eleves> select()
    {  
         ObservableList<Eleves> liste = FXCollections.observableArrayList();
        try{
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
         Statement s = (Statement) con.createStatement();
           
           ResultSet rs = s.executeQuery("select Nom,Postnom,Prenom, Genre, Adresse,dates,telephone  from sixiem");
           
           while (rs.next()) {               
               liste.addAll(new Eleves(rs.getString("Nom"), rs.getString("Postnom"), rs.getString("Prenom"), rs.getString("Genre"),rs.getString("Adresse"), rs.getString("dates"),rs.getString("telephone")));
           }
          	
								

           System.out.println("Connecter avec succer!!");
           con.close();
           
           
       }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return liste;
    }
     //la methode d'inscription
     @FXML
    private void getinscription(ActionEvent event) {
         Stage s = new Stage();
        try{
               Parent root = FXMLLoader.load(getClass().getResource("/fxml/menu6.fxml"));
               s.setScene(new Scene(root));
               s.setResizable(false);
               s.show();
               
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
     //clike pour selectionner un element
    public void clicedTable()
    {
         tableaux.setOnMouseClicked(new EventHandler<MouseEvent>() {
             
             @Override
             public void handle(MouseEvent e) {
                
                Eleves el = tableaux.getItems().get(tableaux.getSelectionModel().getSelectedIndex());
                noms.setText(el.getNoms());
                postnoms.setText(el.getPostnoms());
                prenoms.setText(el.getPrennoms());
                genres.setText(el.getGenres());
                adressss.setText(el.getAdresses());
                telephoness.setText(el.getTelephone());
                
                noms.setVisible(true);
                postnoms.setVisible(true);
                prenoms.setVisible(true);
                genres.setVisible(true);
                adressss.setVisible(true);
                telephoness.setVisible(true);
               
                
             }
         });
    }

    @FXML
    private void getdeletes(ActionEvent event) {
        
        {
            try {
                String sr = "DELETE FROM sixiem WHERE Nom=?";
                Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
                PreparedStatement pst = con.prepareStatement(sr);
                
                    pst.setString(1, noms.getText());
                   int execute = pst.executeUpdate();
                if(execute == 1)
                {
                    clear();
                    con.close();
                    actualiser();
                    rechercheTextField();
                }
                   
                
                
            
            
            } catch (SQLException ex) {
                Logger.getLogger(TabledebaseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        NombreGarcons();
        NombreFille();
        NombreGenrale();
    }
     @FXML
    private void actualiser() {
         nom.setCellValueFactory(new PropertyValueFactory<Eleves, String> ("noms"));
        postnom.setCellValueFactory(new PropertyValueFactory<Eleves, String> ("postnoms"));
        prenom.setCellValueFactory(new PropertyValueFactory<Eleves, String> ("prennoms"));
        Genre.setCellValueFactory(new PropertyValueFactory<Eleves, String> ("genres"));
        Adresse.setCellValueFactory(new PropertyValueFactory<Eleves, String> ("Adresses"));
        Date.setCellValueFactory(new PropertyValueFactory<Eleves, String> ("date"));
        tellephone.setCellValueFactory(new PropertyValueFactory<Eleves, String> ("telephone"));
        affiche1.setCellValueFactory(new PropertyValueFactory<Eleves, String> ("btn"));
      
        list =  select();
        tableaux.setItems(list);
        NombreGarcons();
        NombreFille();
        NombreGenrale();
    }
  
    @FXML
    private void getmodifier(ActionEvent event) {
        String btn = genres.getText();
           String sql ="update sixiem set Nom=?,Postnom=?,Prenom=? ,Genre=?,Adresse=?,telephone=? where Nom=?";
    if(btn.equals("F") || btn.equals("M") || btn.equals("m") || btn.equals("f")){
         try {
         Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
         PreparedStatement pst = con.prepareStatement(sql);
             
         pst.setString(1, noms.getText());
         pst.setString(2, postnoms.getText());
         pst.setString(3, prenoms.getText());
         pst.setString(4,genres.getText());
         pst.setString(5, adressss.getText());
         
      
         pst.setString(6, telephoness.getText());
         pst.setString(7, noms.getText());
        boolean execute = pst.execute();
            clear();
            con.close();
            actualiser();
            rechercheTextField();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        NombreGarcons();
        NombreFille();
        NombreGenrale();
 }
    }
      //renvoie a zero tout
    private void clear() {

          noms.setVisible(false);
                postnoms.setVisible(false);
                prenoms.setVisible(false);
                genres.setVisible(false);
                adressss.setVisible(false);
                telephoness.setVisible(false);
    }
     //cette methode fait un filter de recherche dans la table a partire d'une zone de text
    private void rechercheTextField()
  {
       FilteredList<Eleves> eleve = new FilteredList<>(list, b->true);
      
        filter.textProperty().addListener((observable,oldvalue,newValue)->{
            eleve.setPredicate((Eleves elves) ->{
                if(newValue == null || newValue.isEmpty())
            {
               return true;
            }
                String lower = newValue.toLowerCase();
                if(elves.getNoms().toLowerCase().indexOf(lower) != -1)
                   {
                        
                         return true;
                        }
                else if(elves.getPostnoms().indexOf(lower) != -1)
                {
                    return true;
                }
                 else if(elves.getPrennoms().indexOf(lower) != -1)
                {
                    return true;
                }
                 else if(elves.getTelephone().indexOf(lower) != -1)
                {
                    return true;
                }
                      else if(elves.getAdresses().indexOf(lower) != -1)
                {
                    return true;
                } 
                 else if(elves.getDate().indexOf(lower) != -1)
                {
                    return true;
                }
                 else
                return false;
            }
            );
            
        });
        
        
        SortedList<Eleves> sorte = new SortedList<>(eleve);
        
        sorte.comparatorProperty().bind(tableaux.comparatorProperty());
        
        tableaux.setItems(sorte);
        
  }

    //selection les nombres de garcons dans la base de donnee et nous renvoie un nombre entier
    public void NombreGarcons()
    {
        String sql = "select count(*) from sixiem where Genre='M'";
        try{
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
         PreparedStatement s =  con.prepareStatement(sql);
           
           ResultSet rs = s.executeQuery();
           if(rs.next()){
               String count = rs.getString("count(*)");
               garcon.setText(count);
           }
           
         
     
           con.close();

       }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
     //selection les nombres de fille dans la base de donnee et nous renvoie un nombre entier
     public void NombreFille()
    {
         String sql = "select count(*) from sixiem where Genre='F'";
        try{
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
         PreparedStatement s =  con.prepareStatement(sql);
           
           ResultSet rs = s.executeQuery();
           if(rs.next()){
               String count = rs.getString("count(*)");
               file.setText(count);
           }
           
         
     
           con.close();

       }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
      //selection les nombres generale dans la base de donnee et nous renvoie un nombre entier
      public void NombreGenrale()
    {
         String sql = "select count(*) from sixiem";
        try{
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
         PreparedStatement s =  con.prepareStatement(sql);
           
           ResultSet rs = s.executeQuery();
           if(rs.next()){
               String count = rs.getString("count(*)");
               nombre.setText(count);
           }
           
         
     
           con.close();

       }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
     /*
      affiche les identites d'une entite lorsqu'on  click sur le bouton afficher
   et la fonction imprimer sous fornat pdf la liste ou le tableau


*/
          FileChooser files = new FileChooser();
          
    @FXML
    private void afficherInfo(MouseEvent event) {
     try{  
         
           String sql = "select Nom,Postnom,Prenom from sixiem";
        
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
             PreparedStatement s =  con.prepareStatement(sql);   
            String chemin = "E:\\essaiepdf\\Sixiem.pdf";  
            Document doc = new  Document();
           PdfWriter.getInstance(doc, new FileOutputStream(chemin));
           doc.open();
           Paragraph par = new Paragraph("Liste des Eleves de Sixiem");
           doc.add(par);
           doc.add(new Paragraph("-------------------------------------"));
           
              doc.add(new Paragraph(" "));
              doc.add(new Paragraph(" "));
              doc.add(new Paragraph(" "));
              
              //la creation de la table 
              PdfPTable tables = new PdfPTable(3);
              //creation d'une cellule dans les tables
              PdfPCell cel = new PdfPCell(new Phrase("Nom",FontFactory.getFont("Comic Sans MS",12)));
              cel.setHorizontalAlignment(Element.ALIGN_CENTER);
              cel.setBackgroundColor(BaseColor.ORANGE);
              tables.addCell(cel);
              
               cel = new PdfPCell(new Phrase("Post-Nom",FontFactory.getFont("Comic Sans MS",12)));
               cel.setHorizontalAlignment(Element.ALIGN_CENTER);
               cel.setBackgroundColor(BaseColor.ORANGE);
               tables.addCell(cel);
               
               cel = new PdfPCell(new Phrase("Prenom",FontFactory.getFont("Comic Sans MS",12)));
               cel.setHorizontalAlignment(Element.ALIGN_CENTER);
               cel.setBackgroundColor(BaseColor.ORANGE);
               tables.addCell(cel);
               
              tables.setHeaderRows(1);
              tables.setWidthPercentage(100);
              
               ResultSet rs = s.executeQuery();
               int count = 0;
           while(rs.next()){
               
              tables.addCell(rs.getString("Nom").toString());
              tables.addCell(rs.getString("Postnom").toString());
              tables.addCell(rs.getString("Prenom").toString());  
           }
               doc.add(tables); 
           
           
             con.close();
             doc.close();
             Desktop.getDesktop().open(new File(chemin));
      }catch(Exception e)
        {
            System.err.println(e);
        }
       
    } 

    @FXML
    private void exporter(ActionEvent event) {
         try{ 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
           Statement st = (Statement) con.createStatement();
           ResultSet r = st.executeQuery("select Nom,Postnom,Prenom,Genre,Adresse,Date,telephone from sixiem");
          
     XSSFWorkbook book = new XSSFWorkbook();
     XSSFSheet sheet = book.createSheet("Ideniter");
     XSSFRow row = sheet.createRow(0);
    row.createCell(0).setCellValue("Nom");
    row.createCell(1).setCellValue("PostNom");
    row.createCell(2).setCellValue("preNom");
    row.createCell(3).setCellValue("Genere");
    row.createCell(4).setCellValue("Adresse");
    row.createCell(5).setCellValue("Date");
    row.createCell(6).setCellValue("Telephone");
    int id= 1;
    while(r.next())
    {
            XSSFRow rows = sheet.createRow(id);
                rows.createCell(0).setCellValue(r.getString("Nom"));
                rows.createCell(1).setCellValue(r.getString("Postnom"));
                rows.createCell(2).setCellValue(r.getString("Prenom"));
                rows.createCell(3).setCellValue(r.getString("Genre"));
                rows.createCell(4).setCellValue(r.getString("Adresse"));
                rows.createCell(5).setCellValue(r.getString("Date"));
                rows.createCell(6).setCellValue(r.getString("telephone"));
            id++;
    }
  
                 FileOutputStream file = new FileOutputStream("E:\\essaiepdf\\registre_6em.xlsx");
                 book.write(file);
                 file.close();
              System.out.println("connecter"); 
              System.out.println("fichier exporter"); 
                 
      }catch(Exception e)
      {
          System.err.println(e);
      }
    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
           pare.getScene().getWindow().hide();
           Stage s = new Stage();

             Parent root = FXMLLoader.load(getClass().getResource("/fxml/Aceuil.fxml"));
             s.setScene(new Scene(root));
             s.setResizable(false);
             s.show();
        
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
