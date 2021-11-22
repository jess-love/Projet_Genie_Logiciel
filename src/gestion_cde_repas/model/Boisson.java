package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Boisson  {

    public static Object getId_fam_boisson() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int id_boisson, id_fam_boisson;
    private String designation, nom_fam_boisson, nom_menu;
    private double prix;
  
    public  Boisson(){ }

        public Boisson(int id_boisson, int id_fam_boisson, String nom_fam_boisson, String nom_menu, String designation, double prix) {
        
        this.id_boisson = id_boisson;
        this.id_fam_boisson = id_fam_boisson;
        this.nom_menu = nom_menu;
        this.designation = designation;
        this.prix = prix;
        this.nom_fam_boisson = nom_fam_boisson;

    }
    
      public int getId_boisson() {
        return id_boisson;
    }

public void setId_boisson(int id_boisson) {
        this.id_boisson = id_boisson;
    }
    
    
        public int getId_fam_boissons() {
        return id_fam_boisson;
    }

    
    
    public void setId_fam_boissons(int id_fam_boisson) {
        this.id_fam_boisson=id_fam_boisson;
    }


    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation=designation;
    }

    
        public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix=prix;
    }
    
    
        public String getNom_fam_boisson() {
        return nom_fam_boisson;
    }
        
        public void setNom_fam_boisson(String nom_fam_boisson ) {
        this.nom_fam_boisson= nom_fam_boisson;
    }
      
        
        
            
        public String getNom_Menu() {
        return nom_menu;
    }
        
        public void setNom_Menu(String nom_menu ) {
        this.nom_menu= nom_menu;
    }
        
        

    
    
        public static List<Boisson> getAll(){
        CONNECTION conn=new CONNECTION();
        Statement stm;
        ResultSet Rs;

        try
        {
            stm=conn.avoirconnection().createStatement();
            Rs = stm.executeQuery("Select * from boisson");

            List<Boisson> boisson = new ArrayList<>();

            while (Rs.next())
            {
                Boisson boissons = new Boisson();

                boissons.setId_boisson(Rs.getInt("id_boisson"));
                boissons.setId_fam_boissons(Rs.getInt("id_fam_boisson"));
                boissons.setDesignation(Rs.getString("designation"));
                boissons.setPrix(Rs.getDouble("prix"));
                

                boisson.add(boissons);
            }

            return boisson;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }

        
     
        
        public static List<Boisson> getAllOrderByIdBoisson(){
        CONNECTION conn=new CONNECTION();
        Statement stm;
        ResultSet Rs;

        try
        {
            stm=conn.avoirconnection().createStatement();
            Rs = stm.executeQuery("Select id_boisson, nom_fam_boisson, designation, prix from boisson, famille_boisson where famille_boisson.id_fam_boisson=boisson.id_fam_boisson Order by id_boisson");

            List<Boisson> boissons = new ArrayList<>();

            while (Rs.next())
            {
                Boisson boisson = new Boisson();

                boisson.setId_boisson(Rs.getInt("id_boisson"));
                boisson.setNom_fam_boisson(Rs.getString("nom_fam_boisson"));
                boisson.setDesignation(Rs.getString("designation"));
                boisson.setPrix(Rs.getDouble("prix"));
                

                boissons.add(boisson);
                
            }

            return boissons;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
        
        
    
            

             
             
             
        public static long insert(long id_fam_boisson, String designation, double prix) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql;
        sql = "insert into boisson(id_fam_boisson, designation, prix) VALUES (?,?,?)";
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setLong(1,id_fam_boisson);
        ps.setString(2,designation);
        ps.setDouble(3,prix);
        

        int res = ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            long id = generatedKeys.getLong(1);
            
            return id;
        }
        
        return 0;
    }
        
        
        
        //*********************************************************************************************************
        public static long insert_boisson_menu(long id_boisson, long id_menu) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql;
        sql = "insert into boisson_menu(id_boisson, id_menu) VALUES (?,?)";
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setLong(1,id_boisson);
        ps.setLong(2,id_menu);
      

        int res = ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            long id = generatedKeys.getLong(1);
            
            return id;
        }
        
        return 0;
    }
        
     
               
        public static List<Boisson> search_boisson(String keywords) throws SQLException {
        CONNECTION conn = new CONNECTION();
        ResultSet Rs;
        String sql = "Select id_boisson, nom_fam_boisson, designation, prix From boisson, famille_boisson Where boisson.id_fam_boisson=famille_boisson.id_fam_boisson And  CONCAT(nom_fam_boisson, designation, prix) LIKE '%' '"+keywords+"' '%'";

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        Rs = ps.executeQuery();
        
        List<Boisson> boisson = new ArrayList<>();

        while (Rs.next())
        {
            Boisson boissons = new Boisson();

                boissons.setId_boisson(Rs.getInt("id_boisson"));
                boissons.setNom_fam_boisson(Rs.getString("nom_fam_boisson"));
                boissons.setDesignation(Rs.getString("designation"));
                boissons.setPrix(Rs.getDouble("prix"));
                

                boisson.add(boissons);
            }

            return boisson;
    }
        
        
        
        
        
        public static long getId_particulier(String nom_fam_boisson) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select id_fam_boisson from famille_boisson where nom_fam_boisson='"+nom_fam_boisson+"'  ";
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();

        Rs.next();
        long id=Rs.getLong("id_fam_boisson");
 
        return id;
    }
        
        //***************************************************************************************************
        public static long getId_particulier_boisson(String designation) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select id_boisson from boisson where designation='"+designation+"'  ";
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();

        Rs.next();
        long id=Rs.getLong("id_boisson");
 
        return id;
    }
                 
         

        public static int update(long id_boisson, String designation, double prix) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql = "UPDATE boisson set  designation= '"+designation+"', prix= '"+prix+"'  WHERE id_boisson= "+id_boisson;
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);
        int res = ps.executeUpdate();

        return res;
    }
        
        
        
        public static int delete(long id_boisson) throws SQLException {
        
        CONNECTION conn=new CONNECTION();
        
        String sql = "Delete From boisson Where id_boisson="+id_boisson;

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        int res = ps.executeUpdate();

        return res;
    }
        
        
     
        
        public static List<Boisson> getNames_Fam_Boisson() throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select  * from famille_boisson";
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();

        List<Boisson> boissons = new ArrayList<>();

        while (Rs.next())
        {
            Boisson boisson = new Boisson();

            boisson.setNom_fam_boisson(Rs.getString("nom_fam_boisson"));
         
            boissons.add(boisson);
        }

        return boissons;
    }
        
        //*************************************************************************
        
        public static List<Boisson> getNames_Boisson() throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select * from boisson";
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();

        List<Boisson> boissons = new ArrayList<>();

        while (Rs.next())
        {
            Boisson boisson = new Boisson();

            boisson.setDesignation(Rs.getString("designation"));
         
            boissons.add(boisson);
        }

        return boissons;
    }
        
        
        
        
        
        
        public static List<Boisson> getNames_Boisson_Per_Famille(String famibwason) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String requete=" Select id_fam_boisson From famille_boisson Where nom_fam_boisson= '"+famibwason+"' " ;
        PreparedStatement psy = conn.avoirconnection().prepareStatement(requete);
        ResultSet rst = psy.executeQuery(); 
        rst.next();
        int idfam=  rst.getInt("id_fam_boisson");  
        String sql=" select designation, id_boisson From boisson Where id_fam_boisson='"+idfam+"' "; 
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Boisson> boissons = new ArrayList<>();

        while (rs.next())
        {
            Boisson boisson = new Boisson();

            boisson.setDesignation(rs.getString("designation"));
            boisson.setId_boisson(rs.getInt("id_boisson"));
         
            boissons.add(boisson);
        }

        return boissons;
    }
        
        
        
      
        
         
        public static long getList_Id_Boisson(String designation) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select id_boisson from boisson where designation=" +designation;
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();


        Rs.next();
        long id=Rs.getInt("id_boisson");
  

        return id;
    }
        
        
        
        

            
}
