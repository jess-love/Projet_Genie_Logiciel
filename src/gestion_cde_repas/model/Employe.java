package gestion_cde_repas.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employe extends personne{
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

    public static long insert(long id_pers, String poste) throws SQLException {
        CONNECTION conn = new CONNECTION();

        String sql;
        sql = "insert into employe(id_pers, poste) VALUES (?,?)";
        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

        ps.setLong(1,id_pers);
        ps.setString(2,poste);

        int res = ps.executeUpdate();

        long id = ps.getGeneratedKeys().getLong("id_emp");

        return id;
    }
}
