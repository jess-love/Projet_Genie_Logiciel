package gestion_cde_repas.model;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PERSONNE {
    private final SimpleIntegerProperty id_pers, telephone;
    private final SimpleStringProperty nom, prenom, adresse;
    
    public  PERSONNE()
    {
        this.id_pers = new SimpleIntegerProperty();
        this.nom = new SimpleStringProperty();
        this.prenom = new SimpleStringProperty();
        this.adresse = new SimpleStringProperty();
        this.telephone = new SimpleIntegerProperty();
    }
    
    public int getId() {
        return id_pers.get();
    }

    public void setId(int id) {
        this.id_pers.set(id);
    }


    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }
    
        public String getPrenom() {
        return prenom.get();
    }

    public void setPrenom(String pr) {
        this.prenom.set(pr);
    }
    
            public String getAdresse() {
        return adresse.get();
    }

    public void setAdresse(String adr) {
        this.adresse.set(adr);
    }


}
