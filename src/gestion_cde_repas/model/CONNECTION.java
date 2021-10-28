package gestion_cde_repas.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CONNECTION {
  
     Connection conn;
     
      public CONNECTION()
    {
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
          System.err.println(e); //pour afficher l'erreur
        }

        
        try
        {
          conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_commandes_repas","root",""); //Mysqlp@ssw0rd
        } 
        catch(SQLException e)
        {
            System.err.println(e);
        }

    }
    
    public Connection avoirconnection()
    {
        return conn;
    
    }

    PreparedStatement prepareStatement(String sql3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
