/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbens
 */
public class Famille_boisson {
    private int id_fam_boisson;
    private String nom_fam_boisson;

    public Famille_boisson(int id_fam_boisson, String nom_fam_boisson) {
        this.id_fam_boisson = id_fam_boisson;
        this.nom_fam_boisson = nom_fam_boisson;
    }

    public Famille_boisson() { }

    public int getId_fam_boisson() {
        return id_fam_boisson;
    }

    public void setId_fam_boisson(int id_fam_boisson) {
        this.id_fam_boisson = id_fam_boisson;
    }

    public String getNom_fam_boisson() {
        return nom_fam_boisson;
    }

    public void setNom_fam_boisson(String nom_fam_boisson) {
        this.nom_fam_boisson = nom_fam_boisson;
    }

    public static List<Famille_boisson> getAllOrderById(){
        CONNECTION conn=new CONNECTION();
        Statement stm;
        ResultSet Rs;

        try
        {
            stm=conn.avoirconnection().createStatement();
            Rs = stm.executeQuery("Select * from famille_boisson Order by id_fam_boisson");

            List<Famille_boisson> famille_boissons = new ArrayList<>();

            while (Rs.next())
            {
                Famille_boisson famille_boisson = new Famille_boisson();

                famille_boisson.setId_fam_boisson(Rs.getInt("id_fam_boisson"));
                famille_boisson.setNom_fam_boisson(Rs.getString("nom_fam_boisson"));

                famille_boissons.add(famille_boisson);
            }

            return famille_boissons;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }

    public static List<Famille_boisson> search(String keywords) throws SQLException {
        Statement stm = null;
        ResultSet Rs;

        Rs=stm.executeQuery("Select * From famille_boisson Where  CONCAT(nom_fam_boisson) LIKE '%' '"+keywords+"' '%'");

        List<Famille_boisson> famille_boissons = new ArrayList<>();

        while (Rs.next())
        {
            Famille_boisson famille_boisson = new Famille_boisson();

            famille_boisson.setId_fam_boisson(Rs.getInt("id_fam_boisson"));
            famille_boisson.setNom_fam_boisson(Rs.getString("nom_fam_boisson"));

            famille_boissons.add(famille_boisson);
        }

        return famille_boissons;
    }

    public static long insert(String nom) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql;
        sql = "insert into famille_boisson(nom_fam_boisson) VALUES (?)";
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1,nom);

        int res = ps.executeUpdate();
        
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            long id = generatedKeys.getLong(1);
            
            return id;
        }
        
        return 0;
    }

    public static int update(long id_fam, String nom) throws SQLException {
        CONNECTION conn=new CONNECTION();
        ResultSet Rs;

        String sql = "UPDATE famille_boisson set nom_fam_boisson= '"+nom+"'  WHERE id_fam_boisson = "+id_fam;
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);
        int res = ps.executeUpdate();

        return res;
    }

    public static int delete(long id_fam) throws SQLException {
        CONNECTION conn=new CONNECTION();
        
        String sql = "Delete From famille_boisson Where id_fam_boisson="+id_fam;

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        int res = ps.executeUpdate();

        return res;
    }
}
