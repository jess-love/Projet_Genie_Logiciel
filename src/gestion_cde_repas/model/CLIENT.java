package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CLIENT extends PERSONNE {
    private int id_clt;

    public CLIENT() { }

    public CLIENT(int id_pers, String nom, String prenom, String adresse, String telephone, int id_clt) {
        super(id_pers, nom, prenom, adresse, telephone);
        this.id_clt = id_clt;
    }

    public int getId_clt() {
        return id_clt;
    }

    public void setId_clt(int id_clt) {
        this.id_clt = id_clt;
    }

    public static long insert(long id) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql;
        sql = "insert into client(id_pers) VALUES (?)";
        PreparedStatement pt = conn.avoirconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pt.setLong(1,id);
        pt.executeUpdate();

        long gen_id = pt.getGeneratedKeys().getLong("id_pers");

        return gen_id;
    }
}

