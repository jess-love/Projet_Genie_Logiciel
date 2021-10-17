package gestion_cde_repas.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CARTE_VIN extends BOISSON{
    
    private final SimpleIntegerProperty id_cart_vin,  id_vit;
    private final SimpleStringProperty date_achat;
    private final SimpleDoubleProperty prix_achat, prix_vente;
  
    public  CARTE_VIN()
    {
        this.id_cart_vin = new SimpleIntegerProperty();
        this.id_vit = new SimpleIntegerProperty();
        this.prix_achat = new SimpleDoubleProperty();
        this.prix_vente = new SimpleDoubleProperty();
        this.date_achat = new SimpleStringProperty();

    }

    
        public int getId_cart_vin() {
        return id_cart_vin.get();
    }

    public void setId_cart_vin(int id) {
        this.id_cart_vin.set(id);
    }
    

    
        public int getId_Vit() {
        return id_vit.get();
    }

    public void setId_Vit(int id) {
        this.id_vit.set(id);
    }
    


    public Double getPrix_achat() {
        return prix_achat.get();
    }

    public void setPrix_achat(Double nom) {
        this.prix_achat.set(nom);
    }
    
    
        public Double getPrix_vente() {
        return prix_vente.get();
    }

    public void setPrix_vente(Double nom) {
        this.prix_vente.set(nom);
    }

    
//    public String getAdresse() {
//        return date_achat.get();
//    }
      

    public void setAdresse(String adr) {
        this.date_achat.set(adr);
    }

}
