
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnexion {
    
  static  Connection con = null;
   static String local ="jdbc:mysql://localhost/gestion";
   static  String root = "root";
   static  String pass = "";
    public static Connection conneDb()
    {
        try{
            
         Connection con = DriverManager.getConnection(local,root,pass);
            System.out.println("connexion reussite");
            con.close();
            return con;
            
        }catch(Exception ex)
            
        {
            ex.printStackTrace();
            
            System.out.println("connexion echouer");
            return null;
        }
        
    }
    
}
