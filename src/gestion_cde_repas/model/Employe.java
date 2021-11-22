package gestion_cde_repas.model;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Employe extends Personne{
    private int id_emp;
    private String poste;

    public Employe() { }

    public Employe(int id_pers, String nom, String prenom, String adresse, String telephone, int id_emp, String poste) {
        super(id_pers, nom, prenom, adresse, telephone);
        this.id_emp = id_emp;
        this.poste = poste;
    }

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    
    
    public static long insert(long id_pers, String poste, String username, String pass) throws SQLException {
        CONNECTION conn = new CONNECTION();

        String sql;
        sql = "insert into employe(id_pers, poste, username, password) VALUES (?,?,?,?)";
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setLong(1,id_pers);
        ps.setString(2,poste);
        ps.setString(3,username);
        ps.setString(4,pass);

        int res = ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            long id = generatedKeys.getLong(1);
            
            return id;
        }
        
        return 0;
    }
    
    
    
    public static boolean chekUser(String username, String password){
        CONNECTION conn=new CONNECTION();
        
        try{
            String query="Select poste From employe Where username='"+username+"' And password='"+password+"' ";
            PreparedStatement ps = conn.avoirconnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String post=rs.getString("poste");
                System.out.println(post);

                if("Admin".equals(post))
                {
                    return true;
                }
                else
                {return false;}
            }
            else{return false;}
            
            
            
            
                      
        }
        catch(SQLException | HeadlessException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
            return false;
        }
    }
    
    
    
    
}
