package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Viticulteur {
    private int id_vit;

    public Viticulteur() { }

    public int getId_clt() {
        return id_vit;
    }

    public void setId_clt(int id_clt) {
        this.id_vit = id_clt;
    }

    public static long insert(long id) throws SQLException {
        CONNECTION conn = new CONNECTION();

        String sql;
        sql = "insert into Viticulteur(id_pers) VALUES (?)";
        PreparedStatement pt = conn.avoirconnection().prepareStatement(sql);

        pt.setLong(1,id);
        pt.executeUpdate();

        long gen_id = pt.getGeneratedKeys().getLong("id_pers");

        return gen_id;
    }
}
