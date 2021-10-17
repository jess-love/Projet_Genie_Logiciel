package gestion_cde_repas.model;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BOISSON {
    private final SimpleIntegerProperty id_boisson, id_fam_boisson;
    private final SimpleStringProperty designation;
    private final SimpleDoubleProperty prix;
  
    public  BOISSON()
    {
        this.id_boisson = new SimpleIntegerProperty();
        this.id_fam_boisson = new SimpleIntegerProperty();
        this.designation = new SimpleStringProperty();
        this.prix = new SimpleDoubleProperty();

    }
    
    public int getId() {
        return id_boisson.get();
    }

    public void setId(int id) {
        this.id_boisson.set(id);
    }
    
    
        public int getId_Fam_Boisson() {
        return id_fam_boisson.get();
    }

    public void setId_Fam_Boisson(int id) {
        this.id_fam_boisson.set(id);
    }


    public String getNom() {
        return designation.get();
    }

    public void setNom(String nom) {
        this.designation.set(nom);
    }

    
            public Double getAdresse() {
        return prix.get();
    }

    public void setAdresse(Double adr) {
        this.prix.set(adr);
    }

}
