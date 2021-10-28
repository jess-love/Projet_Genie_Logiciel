package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private int id_tab, numero;
    private String nom_tab;
    
  
    public  Table(){ }

        public Table(int id_tab, int numero, String nom_tab) {
        
        this.id_tab = id_tab;
        this.numero = numero;
        this.nom_tab=nom_tab;

    }
    
      public int getId_Tab() {
        return id_tab;
    }

public void setId_Tab(int id_tab) {
        this.id_tab= id_tab;
    }

      public int getNumero() {
        return numero;
    }

public void setNumero(int numero) {
        this.numero= numero;
    }

public String getNom_Tab() {
        return nom_tab;
    }

    public void setNom_Tab(String nom_tab) {
        this.nom_tab = nom_tab;
    }



        public static List<Table> getAllOrderById() throws SQLException {
        CONNECTION conn=new CONNECTION();
        Statement stm;
        ResultSet Rs;

        try
        {   
            stm=conn.avoirconnection().createStatement();
            Rs = stm.executeQuery("Select * From tab Order By id_tab");

            List<Table> tables = new ArrayList<>();

            while (Rs.next())
            {
                Table table = new Table();

                table.setId_Tab(Rs.getInt("id_tab"));
                table.setNumero(Rs.getInt("numero"));
                table.setNom_Tab(Rs.getString("nom_tab"));
                
                tables.add(table);
                
            }

            return tables;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
        
        
        
        public static long insert(long no, String nom_tab) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql;
        sql = "insert into tab(numero, nom_tab) VALUES (?,?)";
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setLong(1,no);
        ps.setString(2,nom_tab);

        int res = ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            long id = generatedKeys.getLong(1);
            
            return id;
        }
        
        return 0;
    }
        
        
        
         
        public static int delete(long id_tab) throws SQLException {
        
        CONNECTION conn=new CONNECTION();
        
        String sql = "Delete From tab Where id_tab="+id_tab;

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        int res = ps.executeUpdate();

        return res;
    }
        
        
        
        
        
        
        
        public static List<Table> search(String keywords) throws SQLException {
        CONNECTION conn = new CONNECTION();
        ResultSet Rs;
        String sql = "Select * from tab where CONCAT(numero, nom_tab) LIKE '%' '"+keywords+"' '%'";

        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        Rs = ps.executeQuery();
        
        List<Table> table = new ArrayList<>();

        while (Rs.next())
        {
            Table tables = new Table();

                tables.setId_Tab(Rs.getInt("id_tab"));
                tables.setNumero(Rs.getInt("numero"));
                tables.setNom_Tab(Rs.getString("nom_tab"));

                

                table.add(tables);
            }

            return table;
    }
    
}
