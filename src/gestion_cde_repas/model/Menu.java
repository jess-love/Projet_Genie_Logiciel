package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Menu {
    private int id_menu;
    private String nom_menu;
    private double rabais;
    
    public  Menu(){}
    
    public  Menu(int id_menu, String nom_menu, double rabais)
    {
        this.id_menu=id_menu;
        this.nom_menu=nom_menu;
        this.rabais=rabais;
    }
    
        public int getId_Menu() {
        return id_menu;
    }

    public void setId_Menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public String getNom_Menu() {
        return nom_menu;
    }

    public void setNom_Menu(String nom) {
        this.nom_menu = nom;
    }
    
          public double getRabais() {
        return rabais;
    }

    public void setRabais(double rabais) {
        this.rabais = rabais;
    }
    
    
        public static List<Menu> getAllOrderById(){
        CONNECTION conn=new CONNECTION();
        Statement stm;
        ResultSet Rs;

        try
        {
            stm=conn.avoirconnection().createStatement();
            Rs = stm.executeQuery("Select * from menu Order by id_menu");

            List<Menu> menus = new ArrayList<>();

            while (Rs.next())
            {
                Menu menu = new Menu();

                menu.setId_Menu(Rs.getInt("id_menu"));
                menu.setNom_Menu(Rs.getString("nom_menu"));
                menu.setRabais(Rs.getDouble("rabais"));
         

                menus.add(menu);
            }

            return menus;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
        
    
        
        
        public static long insert( String nom_menu, double rabais) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql;
        sql = "insert into menu(nom_menu, rabais) VALUES (?,?)";
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1,nom_menu);
        ps.setDouble(2,rabais);
     

        int res = ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            long id = generatedKeys.getLong(1);
            
            return id;
        }
        
        return 0;
    }
        
        
        
    
}
