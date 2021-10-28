package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Carte_vin extends Boisson{
    
    private int id_cart_vin,  id_vit;
    private String date_achat;
    private double prix_achat, prix_vente;
  
    public  Carte_vin(){}
            
    public  Carte_vin(int id_cart_vin, int id_vit, String date_achat, double prix_achat, double prix_vente )
    {
        this.id_cart_vin = id_cart_vin;
        this.id_vit = id_vit;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.date_achat = date_achat;

    }

    
        public int getId_Cart_Vin() {
        return id_cart_vin;
    }

    public void setId_Cart_Vin(int id) {
        this.id_cart_vin=id;
    }
    

    
        public int getId_Vit() {
        return id_vit;
    }

    public void setId_Vit(int id) {
        this.id_vit=id;
    }
    


    public Double getPrix_Achat() {
        return prix_achat;
    }

    public void setPrix_Achat(double nom) {
        this.prix_achat=nom;
    }
    
    
        public Double getPrix_Vente() {
        return prix_vente;
    }

    public void setPrix_Vente(double nom) {
        this.prix_vente=nom;
    }

    
    public String getDate() {
        return date_achat;
    }
      

    public void setDate(String adr) {
        this.date_achat=adr;
    }

    
    
    
     public static List<Carte_vin> getAllOrderById(){
        CONNECTION conn=new CONNECTION();
        Statement stm;
        ResultSet Rs;

        try
        {
            stm=conn.avoirconnection().createStatement();
            Rs = stm.executeQuery("Select id_cart_vin, nom_categorie, nom_plat, prix from categorie, plat where plat.id_categorie=categorie.id_categorie order by id_plat ");

            List<Carte_vin> carte_vins = new ArrayList<>();

            while (Rs.next())
            {
                Carte_vin carte_vin = new Carte_vin();

                carte_vin.setId_Cart_Vin(Rs.getInt("id_cart_vin"));
                
                

                carte_vins.add(carte_vin);
            }

            return carte_vins;
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
        
        
    
   
    
    
    
}
