package gestion_cde_repas.model;
import javafx.beans.property.SimpleIntegerProperty;

public class BOISSON_MENU {
    private final SimpleIntegerProperty id_boisson, id_menu;

    public  BOISSON_MENU()
    {
        this.id_boisson = new SimpleIntegerProperty();
        this.id_menu = new SimpleIntegerProperty();

    }
    
    public int getId() {
        return id_boisson.get();
    }

    public void setId(int id) {
        this.id_boisson.set(id);
    }
    
    
        public int getId_Menu() {
        return id_menu.get();
    }

    public void setId_Menu(int id) {
        this.id_menu.set(id);
    }



}