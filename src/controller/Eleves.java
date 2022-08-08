
package controller;

import javafx.scene.control.Button;
import javafx.scene.image.Image;


public class Eleves {
    
    private String noms;
    private String postnoms;
    private String prennoms;
    private String genres;
    private String Adresses;
//    private String image;
    private String date;
    private String telephone;
    private Button btn;

   

 
//constructeur par defaut
    Eleves() {
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNoms() {
        return noms;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public String getPostnoms() {
        return postnoms;
    }

    public void setPostnoms(String postnoms) {
        this.postnoms = postnoms;
    }

    public String getPrennoms() {
        return prennoms;
    }

    public void setPrennoms(String prennoms) {
        this.prennoms = prennoms;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getAdresses() {
        return Adresses;
    }

    public void setAdresses(String Adresses) {
        this.Adresses = Adresses;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public Eleves(String noms, String postnoms, String prennoms, String genres, String Adresses,String date,String telephone) {
        this.noms = noms;
        this.postnoms = postnoms;
        this.prennoms = prennoms;
        this.genres = genres;
        this.Adresses = Adresses;
        this.telephone =  telephone;
        this.date = date;
        this.btn = new Button("Affiche");
    }
    
    public void bouton()
    {

    }
    
}
