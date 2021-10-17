package gestion_cde_repas.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CARTE {
    private final SimpleIntegerProperty id_carte;
    private final SimpleStringProperty categorie;

    public  CARTE()
    {
        this.id_carte = new SimpleIntegerProperty();
        this.categorie = new SimpleStringProperty();

    }
    
    public int getId() {
        return id_carte.get();
    }

    public void setId(int id) {
        this.id_carte.set(id);
    }
    
    
        public String getCategorie() {
        return categorie.get();
    }

    public void setCategorie(String id) {
        this.categorie.set(id);
    }



}
