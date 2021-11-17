import javax.swing.*;
 
public class Main {
 
    public static void main(String[] args) {
        //crée un frame
        final JFrame frame = new JFrame("Exemple de JTable");
 
        //En-têtes pour JTable 
        String[] columns = new String[] {
            "Id",
            "Nom", 
            "Adresse", 
            "Taux horaire", 
            "A temps partiel"
        };
        //données pour JTable dans un tableau 2D
        Object[][] data = new Object[][] {
            {1, "Thomas", "Paris", 20.0, true },
            {2, "Jean", "Marseille", 50.0, false },
            {3, "Yohan", "Lyon", 30.0, true },
            {4, "Emily", "Toulouse", 60.0, false },
            {5, "Alex", "Nice", 10.0, false },
        };
 
        //crée un JTable avec des données
        JTable table = new JTable(data, columns);
    
    
        JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);
    
        //ajouter la table au frame
        frame.getContentPane().add(scroll);
    
        System.out.println("Nombre de lignes = "+table.getRowCount());
        System.out.println("Nombre de colonnes = "+table.getColumnCount());
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 180);
        frame.setVisible(true);
    }
}