package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class personne {
    private int id_pers;
    private String nom, prenom, adresse, telephone;

    public personne(){ }
    public personne(int id_pers, String nom, String prenom, String adresse, String telephone) {
        this.id_pers = id_pers;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public int getId_pers() {
        return id_pers;
    }

    public void setId_pers(int id_pers) {
        this.id_pers = id_pers;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public static List<personne> getAll(){
        CONNECTION conn=new CONNECTION();
        Statement stm;
        ResultSet Rs;

        try
        {
            stm=conn.avoirconnection().createStatement();
            Rs = stm.executeQuery("Select * from personne");

            List<personne> personnes = new ArrayList<>();

            while (Rs.next())
            {
                personne personne = new personne();

                personne.setId_pers(Rs.getInt("id_pers"));
                personne.setNom(Rs.getString("nom"));
                personne.setPrenom(Rs.getString("prenom"));
                personne.setAdresse(Rs.getString("adresse"));
                personne.setTelephone(Rs.getString("telephone"));

                personnes.add(personne);
            }

            return personnes;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }

    public static List<personne> getAllOrderById(){
        CONNECTION conn=new CONNECTION();
        Statement stm;
        ResultSet Rs;

        try
        {
            stm=conn.avoirconnection().createStatement();
            Rs = stm.executeQuery("Select * from personne Order by id_pers");

            List<personne> personnes = new ArrayList<>();

            while (Rs.next())
            {
                personne personne = new personne();

                personne.setId_pers(Rs.getInt("id_pers"));
                personne.setNom(Rs.getString("nom"));
                personne.setPrenom(Rs.getString("prenom"));
                personne.setAdresse(Rs.getString("adresse"));
                personne.setTelephone(Rs.getString("telephone"));

                personnes.add(personne);
            }

            return personnes;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }

    public static long insert(String nom, String prenom, String adresse, String telephone) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql;
        sql = "insert into personne(nom, prenom, adresse, telephone) VALUES (?,?,?,?)";
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1,nom);
        ps.setString(2,prenom);
        ps.setString(3,adresse);
        ps.setString(4,telephone);

        int res = ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            long id = generatedKeys.getLong(1);
            
            return id;
        }
        
        return 0;
    }

    public static List<PERSONNE> search(String keywords) throws SQLException {
        CONNECTION conn = new CONNECTION();
        ResultSet Rs;
        String sql = "Select * From personne Where  CONCAT(nom, prenom, adresse, telephone) LIKE '%' '"+keywords+"' '%'";

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        Rs = ps.executeQuery();
        
        List<PERSONNE> personnes = new ArrayList<>();

        while (Rs.next())
        {
            personne personne = new personne();

            personne.setId_pers(Rs.getInt("id_pers"));
            personne.setNom(Rs.getString("nom"));
            personne.setPrenom(Rs.getString("prenom"));
            personne.setAdresse(Rs.getString("adresse"));
            personne.setTelephone(Rs.getString("telephone"));

            personnes.add(personne);
        }

        return personnes;
    }

    public static int delete(long id_pers) throws SQLException {
        
        CONNECTION conn=new CONNECTION();
        
        String sql = "Delete From personne Where id_pers="+id_pers;

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        int res = ps.executeUpdate();

        return res;
    }

    public static int update(long id_pers, String nom, String prenom, String adresse, String telephone) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql = "UPDATE personne set nom= '"+nom+"', prenom= '"+prenom+"', adresse= '"+adresse+"', telephone= '"+telephone+"'  WHERE id_pers= "+id_pers;
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);
        int res = ps.executeUpdate();

        return res;
    }

    public static List<personne> getNames() throws SQLException {
        CONNECTION conn=new CONNECTION();

        String mysql="select id_pers, nom, prenom from personne";
        PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
        ResultSet Rs = pst.executeQuery();

        List<personne> personnes = new ArrayList<>();

        while (Rs.next())
        {
            personne personne = new personne();

            personne.setNom(Rs.getString("nom"));
            personne.setPrenom(Rs.getString("prenom"));

            personnes.add(personne);
        }

        return personnes;
    }
}
