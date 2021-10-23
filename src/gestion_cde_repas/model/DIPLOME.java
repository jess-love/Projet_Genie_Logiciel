package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DIPLOME {
    private int id_dip;
    private String lib;

    public DIPLOME(int id_dip, String lib) {
        this.id_dip = id_dip;
        this.lib = lib;
    }

    public DIPLOME() {  }

    public int getId_dip() {
        return id_dip;
    }

    public void setId_dip(int id_dip) {
        this.id_dip = id_dip;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public static long insert(long id_emp, String libelle) throws SQLException {
        CONNECTION conn=new CONNECTION();

        String sql;
        sql = "insert into diplome(id_emp, libelle) VALUES (?,?)";
        PreparedStatement pt = conn.avoirconnection().prepareStatement(sql);

        pt.setLong(1,id_emp);
        pt.setString(2,libelle);

        int res = pt.executeUpdate();

        long gen_id = pt.getGeneratedKeys().getLong("id_pers");

        return gen_id;
    }
}
