package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Categorie {
        private int id_categorie;
        private  String nom_categorie;
    
        public  Categorie(){ }

        public Categorie(int id_categorie, String nom_categorie) {
        
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
    }
        
        
        
        public int getId_Categorie() {
        return id_categorie;
    }

public void setId_Categorie(int id_cat) {
        this.id_categorie= id_cat;
    }

        public String getNom_Categorie() {
        return nom_categorie;
    }

public void setNom_Categorie(String nom_cat) {
        this.nom_categorie = nom_cat;
    }


    
        public static List<Categorie> getAllOrderById_Cat() throws SQLException {
        CONNECTION conn=new CONNECTION();
        Statement stm;
        ResultSet Rs;

        try
        {   
            stm=conn.avoirconnection().createStatement();
            Rs = stm.executeQuery("Select * From categorie Order By id_categorie");

            List<Categorie> categories = new ArrayList<>();

            while (Rs.next())
            {
                Categorie categorie = new Categorie();

                categorie.setId_Categorie(Rs.getInt("id_categorie"));
                categorie.setNom_Categorie(Rs.getString("nom_categorie"));

                categories.add(categorie);
                
            }

            return categories;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    

        
        
        public static long insert(String nom_categorie) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql;
        sql = "insert into categorie(nom_categorie) VALUES (?)";
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1,nom_categorie);

        int res = ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            long id = generatedKeys.getLong(1);
            
            return id;
        }
        
        return 0;
    }
        
      
        
        
        
                 
        public static int delete(long id_categorie) throws SQLException {
        
        CONNECTION conn=new CONNECTION();
        
        String sql = "Delete From categorie Where id_categorie="+id_categorie;

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        int res = ps.executeUpdate();

        return res;
    }
        


        
        public static List<Categorie> search(String keywords) throws SQLException {
        CONNECTION conn = new CONNECTION();
        ResultSet Rs;
        String sql = "Select * from categorie where CONCAT(id_categorie, nom_categorie) LIKE '%' '"+keywords+"' '%'";

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        Rs = ps.executeQuery();
        
        List<Categorie> categories = new ArrayList<>();

        while (Rs.next())
        {
            Categorie categorie = new Categorie();

                categorie.setId_Categorie(Rs.getInt("id_categorie"));
                categorie.setNom_Categorie(Rs.getString("nom_categorie"));

                categories.add(categorie);
            }

            return categories;
    }
        
      
        
        
            


    
    
        public static int update( long id_categorie, String nom_categorie) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql = "UPDATE categorie set nom_categorie= '"+nom_categorie+"' where id_categorie = "+id_categorie;
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);
        int res = ps.executeUpdate();

        return res;
    }
    
    
}
