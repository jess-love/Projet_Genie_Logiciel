package gestion_cde_repas.model;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Commande {
    private final SimpleIntegerProperty id_cde, id_emp, id_tab;
    private final SimpleStringProperty date;

  
    public  Commande()
    {
        this.id_cde = new SimpleIntegerProperty();
        this.id_emp = new SimpleIntegerProperty();
        this.id_tab = new SimpleIntegerProperty();
        this.date = new SimpleStringProperty();
        


    }
    
    public int getId() {
        return id_cde.get();
    }

    public void setId(int id) {
        this.id_cde.set(id);
    }
    
    
        public int getId_Emp() {
        return id_emp.get();
    }

    public void setId_Emp(int id) {
        this.id_emp.set(id);
    }

    
        public int getId_Tab() {
        return id_tab.get();
    }

    public void setId_Tab(int id) {
        this.id_tab.set(id);
    }

    
    public String getDate() {
        return date.get();
    }

    public void setDate(String nom) {
        this.date.set(nom);
    }

    

}

