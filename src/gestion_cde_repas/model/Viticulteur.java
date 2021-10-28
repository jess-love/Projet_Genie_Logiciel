package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Viticulteur extends Personne {
    private int id_vit;

    public Viticulteur(){}
    
    public Viticulteur(int id_pers,  String nom, String prenom, String adresse, String telephone, int id_vit)
    {   
        super(id_pers, nom, prenom, adresse, telephone);
        this.id_vit=id_vit;
    }

    public int getId_Vit() {
        return id_vit;
    }

    public void setId_Vit(int id) {
        this.id_vit = id;
    }

    public static long insert(long id) throws SQLException {
        CONNECTION conn = new CONNECTION();

        String sql;
        sql = "insert into Viticulteur(id_pers) VALUES (?)";
        PreparedStatement pt = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pt.setLong(1,id);
        pt.executeUpdate();

        ResultSet generatedKeys = pt.getGeneratedKeys();
        if(generatedKeys.next()){
            long id_gen = generatedKeys.getLong(1);
            
            return id_gen;
        }
        
        return 0;
    }
}
