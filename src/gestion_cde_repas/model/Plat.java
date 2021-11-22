package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Plat {
    private int id_plat, id_categorie;
    private String nom_plat, nom_categorie;
    private double prix;
    
    public  Plat(){}
    
    public  Plat(int id_plat, int id_categorie, String nom_plat, String nom_categorie, double prix)
    {
        this.id_plat = id_plat;
        this.id_categorie = id_categorie;
        this.nom_plat = nom_plat;

    }
    
    public int getId_Plat() {
        return id_plat;
    }

    public void setId_Plat(int id) {
        this.id_plat= id;
    }
    
    
        public int getId_Categorie() {
        return id_categorie;
    }

    public void setId_Categorie(int id) {
        this.id_categorie=id;
    }
    
    
        public String getNom_Plat() {
        return nom_plat;
    }

    public void setNom_Plat(String nom) {
        this.nom_plat = nom;
    }
    
        public String getNom_Categorie() {
        return nom_categorie;
    }

    public void setNom_Categorie(String nom) {
        this.nom_categorie = nom;
    }
    
        public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix=prix;
    }

    
    
        public static List<Plat> getAllOrderById(){
        CONNECTION conn=new CONNECTION();
        Statement stm;
        ResultSet Rs;

        try
        {
            stm=conn.avoirconnection().createStatement();
            Rs = stm.executeQuery("Select id_plat, nom_categorie, nom_plat, prix from categorie, plat where plat.id_categorie=categorie.id_categorie order by id_plat ");

            List<Plat> plats = new ArrayList<>();

            while (Rs.next())
            {
                Plat plat = new Plat();

                plat.setId_Plat(Rs.getInt("id_plat"));
                plat.setNom_Categorie(Rs.getString("nom_categorie"));
                plat.setNom_Plat(Rs.getString("nom_plat"));
                plat.setPrix(Rs.getDouble("prix"));
                

                plats.add(plat);
            }

            return plats;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    
        public static long insert(long id_categorie, String nom_plat, double prix) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql;
        sql = "insert into plat(id_categorie, nom_plat, prix) VALUES (?,?,?)";
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setLong(1,id_categorie);
        ps.setString(2,nom_plat);
        ps.setDouble(3,prix);
        

        int res = ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            long id = generatedKeys.getLong(1);
            
            return id;
        }
        
        return 0;
    }

        
        
        public static long insert_plat_menu(long id_plat, long id_menu) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql;
        sql = "insert into plat_menu(id_plat, id_menu) VALUES (?,?)";
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setLong(1,id_plat);
        ps.setLong(2,id_menu);
      

        int res = ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            long id = generatedKeys.getLong(1);
            
            return id;
        }
        
        return 0;
    }
        
        
        
        
        
        public static List<Plat> search(String keywords) throws SQLException {
        CONNECTION conn = new CONNECTION();
        ResultSet Rs;
        String sql = "Select id_plat, nom_categorie, nom_plat, prix From plat, categorie Where plat.id_categorie=categorie.id_categorie and CONCAT(nom_plat, nom_categorie, prix) LIKE '%' '"+keywords+"' '%'";

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        Rs = ps.executeQuery();
        
        List<Plat> plats = new ArrayList<>();

        while (Rs.next())
        {
            Plat plat = new Plat();

            plat.setId_Plat(Rs.getInt("id_plat"));
            plat.setNom_Categorie(Rs.getString("nom_categorie"));
            plat.setNom_Plat(Rs.getString("nom_plat"));
            plat.setPrix(Rs.getDouble("prix"));
           
            

            plats.add(plat);
        }

        return plats;
    }
        
         
         
         
        public static int delete(long id_plat) throws SQLException {
        
        CONNECTION conn=new CONNECTION();
        
        String sql = "Delete From plat Where id_plat="+id_plat;

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        int res = ps.executeUpdate();

        return res;
    }

    
    
        public static int update(long id_plat, String nom_plat, double prix) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql = "UPDATE plat set  nom_plat= '"+nom_plat+"',  prix= '"+prix+"'  WHERE id_plat= "+id_plat;
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);
        int res = ps.executeUpdate();

        return res;
    }

    
    
        public static List<Plat> getNames() throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select nom_categorie from categorie";
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();

        List<Plat> plats = new ArrayList<>();

        while (Rs.next())
        {
            Plat plat = new Plat();

            plat.setNom_Categorie(Rs.getString("nom_categorie"));
            

            plats.add(plat);
        }

        return plats;
    }
    
    
    
    
    
    
        public static long getId_particulier(String nom_categorie) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select id_categorie from categorie where nom_categorie='"+nom_categorie+"'  ";
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();

        Rs.next();
        long id=Rs.getLong("id_categorie");
 
        return id;
    }
        
    
        
        
        public static List<Plat> getNames_Categorie() throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select  * from categorie";
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();

        List<Plat> plats = new ArrayList<>();

        while (Rs.next())
        {
            Plat plat = new Plat();

            plat.setNom_Categorie(Rs.getString("nom_categorie"));
         
            plats.add(plat);
        }

        return plats;
    }
        
        //*************************************************************************
        
        public static List<Plat> getNames_Plat() throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select * from plat";
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();

        List<Plat> plats = new ArrayList<>();

        while (Rs.next())
        {
            Plat plat = new Plat();

            plat.setNom_Plat(Rs.getString("nom_plat"));
         
            plats.add(plat);
        }

        return plats;
    }
        
        
        
        
        
        
        public static List<Plat> getNames_Plat_Per_Categorie(String nom_categorie) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String requete=" Select id_categorie From categorie Where nom_categorie= '"+nom_categorie+"' " ;
        PreparedStatement psy = conn.avoirconnection().prepareStatement(requete);
        ResultSet rst = psy.executeQuery(); 
        rst.next();
        int idcat=  rst.getInt("id_categorie");  
        String sql=" select nom_plat, id_plat From plat Where id_categorie='"+idcat+"' "; 
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Plat> plats = new ArrayList<>();

        while (rs.next())
        {
            Plat plat = new Plat();

            plat.setNom_Plat(rs.getString("nom_plat"));
            plat.setId_Plat(rs.getInt("id_plat"));
         
            plats.add(plat);
        }

        return plats;
    }
        
        
        
        
        
}
