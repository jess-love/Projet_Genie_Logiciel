package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Carte_vin extends Boisson{
    
    private int id_cart_vin,  id_vit, id_boisson;
    private String date_achat, nom_boisson, millesime, nom, prenom;
    private double prix_achat, prix_vente;
  
    public  Carte_vin(){}
            
    public  Carte_vin(int id_cart_vin, int id_vit, int id_boisson, String nom_boisson, String nom, String prenom, String date_achat, double prix_achat, double prix_vente )
    {
        this.id_cart_vin = id_cart_vin;
        this.id_vit = id_vit;
        this.nom_boisson = nom_boisson;
        this.nom = nom;
        this.prenom = prenom;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.date_achat = date_achat;
         this.millesime = millesime;

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
    
        public int getId_Boisson() {
        return id_boisson;
    }

    public void setId_Boisson(int id) {
        this.id_boisson=id;
    }
    
    
    public String getNom_Boisson() {
        return nom_boisson;
    }

    public void setNom_Boisson(String id) {
        this.nom_boisson=id;
    }
    
        public String getNom() {
        return nom;
    }

    public void setNom(String id) {
        this.nom=id;
    }
    
            public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String id) {
        this.prenom=id;
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
    
    
        public String getMillesime() {
        return millesime;
    }
      

    public void setMillesime(String adr) {
        this.millesime=adr;
    }

    
    
    
     public static List<Carte_vin> getAllOrderById(){
        CONNECTION conn=new CONNECTION();
        Statement stm;
        ResultSet Rs;

        try
        {
            stm=conn.avoirconnection().createStatement();
            Rs = stm.executeQuery("Select id_cart_vin, designation, prix_achat, prix_vente, date_achat, millesime from carte_vin, boisson where boisson.id_boisson=carte_vin.id_boisson order by id_cart_vin ");

            List<Carte_vin> vins = new ArrayList<>();

            while (Rs.next())
            {
                Carte_vin vin = new Carte_vin();

                vin.setId_Cart_Vin(Rs.getInt("id_cart_vin"));
                vin.setNom_Boisson(Rs.getString("designation"));
                vin.setPrix_Achat(Rs.getDouble("prix_achat"));
                vin.setPrix_Vente(Rs.getDouble("prix_vente"));
                vin.setDate(Rs.getString("date_achat"));
                vin.setMillesime(Rs.getString("millesime"));
                
                

                vins.add(vin);
            }

            return vins;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    
        public static long insert_vin(long id_boisson, long id_vit, double prix_achat, double prix_vente, String date_achat, String millesime) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql;
        sql = "insert into carte_vin( id_boisson, id_vit, prix_achat, prix_vente, date_achat, millesime) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        
        
        
        ps.setLong(1,id_boisson);
        ps.setLong(2,id_vit);
        ps.setDouble(3,prix_achat);
        ps.setDouble(4,prix_vente);
        ps.setString(5,date_achat);
        ps.setString(6,millesime);
        

        int res = ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            long id = generatedKeys.getLong(1);
            
            return id;
        }
        
        return 0;
    }
        
        
         
        
        
        
        public static List<Carte_vin> search(String keywords) throws SQLException {
        CONNECTION conn = new CONNECTION();
        ResultSet Rs;
        String sql = "Select id_cart_vin, designation,nom, prenom, prix_achat, prix_vente, date_achat, millesime From carte_vin, viticulteur, personne, boisson Where carte_vin.id_boisson=boisson.id_boisson and viticulteur.id_pers=personne.id_pers and carte_vin.id_vit=viticulteur.id_vit CONCAT(designation, nom, prenom, prix_achat, prix_vente, date_achat, millesime) LIKE '%' '"+keywords+"' '%'";

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        Rs = ps.executeQuery();
        
        List<Carte_vin> vins = new ArrayList<>();

        while (Rs.next())
        {
            Carte_vin vin = new Carte_vin();

            vin.setId_Cart_Vin(Rs.getInt("id_cart_vin"));
            vin.setNom_Boisson(Rs.getString("designation"));
            vin.setNom(Rs.getString("nom"));
            vin.setPrenom(Rs.getString("prenom"));
            vin.setPrix_Achat(Rs.getDouble("prix_achat"));
            vin.setPrix_Vente(Rs.getDouble("prix_vente"));
            vin.setDate(Rs.getString("date_achat"));
            vin.setMillesime(Rs.getString("millesime"));
           
            

            vins.add(vin);
        }

        return vins;
    }
        
         
         
         
        public static int delete(long id_vin) throws SQLException {
        
        CONNECTION conn=new CONNECTION();
        
        String sql = "Delete From carte_vin Where id_cart_vin="+id_vin;

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        int res = ps.executeUpdate();

        return res;
    }

    
    
    public static int update(long id_cart_vin, long  id_boisson, long id_vit, double prix_achat, double prix_vente, String millesime ) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql = "UPDATE carte_vin set  id_boisson= '"+id_boisson+"',  id_vit= '"+id_vit+"',  prix_achat= '"+prix_achat+"',  prix_vente= '"+prix_vente+"',  millesime= '"+millesime+"'  WHERE id_cart_vin= "+id_cart_vin;
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);
        int res = ps.executeUpdate();

        return res;
    }

    
    
    public static List<Carte_vin> getNames_Viticulteur() throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select nom, prenom from personne, viticulteur where viticulteur.id_pers=personne.id_pers";
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();

        List<Carte_vin> vins = new ArrayList<>();

        while (Rs.next())
        {
            Carte_vin vin = new Carte_vin();

            vin.setNom(Rs.getString("nom"));
            vin.setPrenom(Rs.getString("prenom"));
            

            vins.add(vin);
        }

        return vins;
    }
    
    
    
    
        public static List<Carte_vin> getNames_Boiss() throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select designation from carte_vin, boisson where carte_vin.id_boisson=boisson.id_boisson";
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();

        List<Carte_vin> vins = new ArrayList<>();

        while (Rs.next())
        {
            Carte_vin vin = new Carte_vin();

            vin.setNom_Boisson(Rs.getString("designation"));
       
            

            vins.add(vin);
        }

        return vins;
    }
    
    
    
    
    
        public static long getId_particulier(String nom, String prenom) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select id_vit from personne, viticulteur where personne.id_pers=viticulteur.id_pers and nom='"+nom+"' and prenom='"+prenom+"'   ";
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();

        Rs.next();
        long id=Rs.getLong("id_vit");
 
        return id;
    }
        
        
    
   
    
    
    
}
