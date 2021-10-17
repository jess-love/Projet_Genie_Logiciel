package gestion_cde_repas.model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class DIPLOME {
        private final SimpleIntegerProperty id_dip;
        private final SimpleStringProperty lib;

    public  DIPLOME()
    {
        this.id_dip = new SimpleIntegerProperty();
        this.lib = new SimpleStringProperty();
        

    }
    
    public int getId_dip() {
        return id_dip.get();
    }

    public void setId_dip(int id) {
        this.id_dip.set(id);
    }
//    
//        public int getLibelle() {
//        return lib.get();
//    }

//    public void setLibelle(int id) {
//        this.lib.set(id);
//    }
//    
}
