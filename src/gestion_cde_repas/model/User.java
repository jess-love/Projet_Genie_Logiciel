package gestion_cde_repas.model;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rbens
 */
public class User {
    private int id_pers;
    private String username;
    private String password;
    
    public User(){}
    
    public User(int id, String username, String password){
        this.id_pers = id;
        this.username = username;
        this.password = password;
    }
    
    public static boolean chekUser(String username, String password){
        CONNECTION conn=new CONNECTION();
        
        try{
            String query="Select * From employe Where username='"+username+"' And password='"+password+"' ";
            PreparedStatement ps = conn.avoirconnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs.next(); 
            
//            if(rs.next()){
//                return true;
//            }            
        }
        catch(SQLException | HeadlessException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
            return false;
        }
    }
}
