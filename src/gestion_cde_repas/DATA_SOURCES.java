package gestion_cde_repas;
import static com.sun.glass.ui.Cursor.setVisible;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DATA_SOURCES {
    
    CONNECTION conn=new CONNECTION();
    Statement stm;
    ResultSet Rs;
    public String user;
    public String password;
    
   
    
    public  void login(String user, String password) throws SQLException
    {
            this.user= user;
            this.password=password;
            String query="Select * From connexion Where username='"+user+"' And password='"+password+"' ";
            PreparedStatement ps = conn.avoirconnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                setVisible(false);
                MENU Info;
                Info = new MENU();
                Info.setVisible(true);

            } else

            {
                JOptionPane.showMessageDialog(null, " Username Or Password are Invalid ");
            }    
 
            
    }
}
