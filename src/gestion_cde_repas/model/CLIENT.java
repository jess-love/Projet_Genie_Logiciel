package gestion_cde_repas.model;
import javafx.beans.property.SimpleIntegerProperty;

public class CLIENT extends PERSONNE {
    private final SimpleIntegerProperty id_clt;

    public  CLIENT()
    {
        this.id_clt = new SimpleIntegerProperty();
        

    }
    
    public int getId_Clt() {
        return id_clt.get();
    }

    public void setId_Clt(int id) {
        this.id_clt.set(id);
    }
    



}

