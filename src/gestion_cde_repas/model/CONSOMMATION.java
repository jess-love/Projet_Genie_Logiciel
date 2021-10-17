package gestion_cde_repas.model;
import javafx.beans.property.SimpleIntegerProperty;

public class CONSOMMATION {
    private final SimpleIntegerProperty id_cde, id_menu, id_plat, id_boisson;
   
  
    public  CONSOMMATION()
    {
        this.id_cde = new SimpleIntegerProperty();
        this.id_menu = new SimpleIntegerProperty();
        this.id_plat = new SimpleIntegerProperty();
        this.id_boisson = new SimpleIntegerProperty();

    }
    
        public int getId() {
        return id_cde.get();
    }

    public void setId(int id) {
        this.id_cde.set(id);
    }
    
    public int getId_Boisson() {
        return id_boisson.get();
    }

    public void setId_Boisson(int id) {
        this.id_boisson.set(id);
    }
    
    
        public int getId_Plat() {
        return id_plat.get();
    }

    public void setId_Plat(int id) {
        this.id_plat.set(id);
    }
    
            public int getId_Menu() {
        return id_menu.get();
    }

    public void setId_Menu(int id) {
        this.id_menu.set(id);
    }




}

