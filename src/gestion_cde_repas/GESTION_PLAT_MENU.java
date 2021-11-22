package gestion_cde_repas;


import gestion_cde_repas.model.Plat;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GESTION_PLAT_MENU extends javax.swing.JFrame {
    DefaultTableModel model=new DefaultTableModel();
    List<String> list=new ArrayList<String>();
    
    public GESTION_PLAT_MENU() {
        initComponents();
        setIconImage();
        this.setLocationRelativeTo(null);
 
        model.addColumn("Nom plat");
        
     
               
        categorie_plat.addItemListener((ItemEvent e) -> {
        if(e.getStateChange()==ItemEvent.SELECTED)
        {
        String item= e.getItem().toString(); 
        Fillcombo_1(item);
        }
        });
        Fillcombo_Plat();
        Fillcombo_Categorie_Plat();


               
        
       ajouter.addActionListener((ActionEvent e) -> {
            
        model.addRow(
                    new Object[]{
                       
                    nom_plat.getSelectedItem()
                        
                    }
            );
        });
  
        tab_plat_menu.setModel(model);
    
    }

 
    @SuppressWarnings("unchecked")
    
    private void Fillcombo_Categorie_Plat() 
        {
            try
                {
                    List<Plat> plats = Plat.getNames_Categorie();
                    
                    plats.forEach(plat -> { 
                    String CatName = plat.getNom_Categorie();
                    categorie_plat.addItem(CatName); 
                    }); 
                   
                }
            catch(Exception e)
           {
            System.err.println(e);
           }

        }
        
    
    
     private void Fillcombo_Plat() 
        {
            try
                {
                    List<Plat> plats = Plat.getNames_Plat();
                    
                    plats.forEach(plat -> { 
                    String CatName = plat.getNom_Plat();
                    nom_plat.addItem(CatName); 
                    }); 
                   
                }
            catch(Exception e)
           {
            System.err.println(e);
           }

        }
     
     
     
      private void Fillcombo_1(String cat) 
    {
            try
                {   
                    nom_plat.removeAllItems();
                    List<Plat> plats = Plat.getNames_Plat_Per_Categorie(cat);
                    
                    plats.forEach(plat -> { 
                    String PlatName = plat.getNom_Plat() + " (" +plat.getId_Plat() +")"  ;
                    nom_plat.addItem(PlatName); 
                        
                    }); 
                   
                }
            catch(Exception e)
           {
            System.err.println(e);
           }
    }
    
     
      

        private void deplace(int i)
                
    {
        try
        {   
           
            nom_plat.setSelectedItem(model.getValueAt(i,0).toString());           
            
        } 
        catch(Exception e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"erreur de deplacement"+e.getLocalizedMessage());
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        valider = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nom_plat = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_plat_menu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        categorie_plat = new javax.swing.JComboBox<>();
        ajouter = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        valider.setBackground(new java.awt.Color(255, 255, 255));
        valider.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        valider.setForeground(new java.awt.Color(127, 19, 19));
        valider.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\check.png")); // NOI18N
        valider.setText("Valider");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });
        jPanel1.add(valider, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 200, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 19, 19));
        jLabel2.setText("Categorie plat");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 30));

        nom_plat.setForeground(new java.awt.Color(127, 19, 19));
        nom_plat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nom_platMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nom_platMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nom_platMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nom_platMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nom_platMouseReleased(evt);
            }
        });
        jPanel1.add(nom_plat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 200, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 19, 19));
        jLabel4.setText("Nom plat");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 100, 30));

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 255, 255), null, new java.awt.Color(102, 255, 255)));

        tab_plat_menu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19), new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19)));
        tab_plat_menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        tab_plat_menu.setSelectionBackground(new java.awt.Color(225, 243, 255));
        tab_plat_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_plat_menuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_plat_menu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 340, 150));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 19, 19));
        jLabel1.setText("Menu Plat");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 210, -1));

        categorie_plat.setForeground(new java.awt.Color(127, 19, 19));
        jPanel1.add(categorie_plat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 200, 30));

        ajouter.setBackground(new java.awt.Color(255, 255, 255));
        ajouter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ajouter.setForeground(new java.awt.Color(127, 19, 19));
        ajouter.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\add-icon.png")); // NOI18N
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });
        jPanel1.add(ajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 200, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(127, 19, 19));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\supprimer.png")); // NOI18N
        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 200, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(127, 19, 19));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\home.png")); // NOI18N
        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed

        for(int i=0; i<tab_plat_menu.getRowCount(); i++)
        {
            list.add((String) tab_plat_menu.getModel().getValueAt(i,0));
            System.out.println(list.get(list.size()-1));
        }

        for (int i=0; i<list.size(); i++)
        {

            try
            {
                String txt= list.get(i);
                String id = txt.substring(txt.indexOf("(")+1,txt.indexOf(")"));
                long id_p= Long.parseLong(id);
                System.out.println(id);

                
                long id_menu_1= GESTION_MENU.id_dernier_menu;
                long id_menu_2=GESTION_MENU.id_menu;
                if(id_menu_1 !=0 )
                {
                    long id_not_used= Plat.insert_plat_menu(id_p, id_menu_1);
                }
                else
                {
                     long id_not_used= Plat.insert_plat_menu(id_p, id_menu_2);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(GESTION_BOISSON_MENU.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        JOptionPane.showMessageDialog(null,"Ce menu plat a bien ete ajoute");

    }//GEN-LAST:event_validerActionPerformed

    private void nom_platMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nom_platMouseClicked

    }//GEN-LAST:event_nom_platMouseClicked

    private void nom_platMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nom_platMouseEntered

    }//GEN-LAST:event_nom_platMouseEntered

    private void nom_platMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nom_platMouseExited

    }//GEN-LAST:event_nom_platMouseExited

    private void nom_platMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nom_platMousePressed

    }//GEN-LAST:event_nom_platMousePressed

    private void nom_platMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nom_platMouseReleased

    }//GEN-LAST:event_nom_platMouseReleased

    private void tab_plat_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_plat_menuMouseClicked
        int i;
        i = tab_plat_menu.getSelectedRow();
        deplace(i);
    }//GEN-LAST:event_tab_plat_menuMouseClicked

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed

      //  System.out.println(list.get(list.size()-1));

    }//GEN-LAST:event_ajouterActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // vérifier d'abord la ligne sélectionnée
        if(tab_plat_menu.getSelectedRow() != -1)
        {
            model.removeRow(tab_plat_menu.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Suppression terminee");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        GESTION_MENU Info;
        Info = new GESTION_MENU();
        Info.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GESTION_PLAT_MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GESTION_PLAT_MENU().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JComboBox<String> categorie_plat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> nom_plat;
    private javax.swing.JTable tab_plat_menu;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables

     private void setIconImage() {
      try{
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
      } catch(Exception e)
                {
                     System.err.println(e);
                }
    }

}
