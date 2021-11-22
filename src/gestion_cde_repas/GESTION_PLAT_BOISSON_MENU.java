package gestion_cde_repas;

import gestion_cde_repas.model.Boisson;
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

public class GESTION_PLAT_BOISSON_MENU extends javax.swing.JFrame {
    DefaultTableModel model=new DefaultTableModel();
    public static long id_dernier_menu;
    public static long id_menu;
    List<String> list=new ArrayList<String>();
    List<String> list_boisson=new ArrayList<String>();
    List<String> list_plat=new ArrayList<String>();
     

  
    public GESTION_PLAT_BOISSON_MENU() {
        initComponents();
        setIconImage();
        this.setLocationRelativeTo(null);
        
        model.addColumn("Nom boisson et plat");
 
                
        nom_fam_boisson.addItemListener((ItemEvent e) -> {
        if(e.getStateChange()==ItemEvent.SELECTED)
        {
        String item= e.getItem().toString(); 
        Fillcombo_2(item);
        }
        });
        Fillcombo_Boisson();
        Fillcombo_Famille_Boisson();


        categorie_plat.addItemListener((ItemEvent e) -> {
        if(e.getStateChange()==ItemEvent.SELECTED)
        {
        String item= e.getItem().toString(); 
        Fillcombo_1(item);
        }
        });
        Fillcombo_Plat();
        Fillcombo_Categorie_Plat();
//        System.out.println(list.get(list_boisson.size()-1));
//        System.out.println("wi mw la");
//        System.out.println(list.get(list_plat.size()-1));
        
       ajouter_boisson.addActionListener((ActionEvent e) -> {
            
        model.addRow(
                    new Object[]{
                    
                    nom_boisson.getSelectedItem(),
                    list_boisson.add(nom_boisson.getSelectedItem().toString())
                    
                    
                    }
            );
        });
  
        tab_boisson_plat_menu.setModel(model);
        
        
        ajouter_plat.addActionListener((ActionEvent e) -> {
            
        model.addRow(
                    new Object[]{
                    nom_plat.getSelectedItem(),
                    list_plat.add(nom_plat.getSelectedItem().toString())
                    
                    }
            );
        });
  
        tab_boisson_plat_menu.setModel(model);
        
        

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
    
      
       private void Fillcombo_Famille_Boisson() 
        {
            try
                {
                    List<Boisson> boissons = Boisson.getNames_Fam_Boisson();
                    
                    boissons.forEach(boisson -> { 
                    String FamBoissonName = boisson.getNom_fam_boisson();
                    nom_fam_boisson.addItem(FamBoissonName); 
                    }); 
                   
                }
            catch(Exception e)
           {
            System.err.println(e);
           }

        }
        
    
    
     private void Fillcombo_Boisson() 
        {
            try
                {
                    List<Boisson> boissons = Boisson.getNames_Boisson();
                    
                    boissons.forEach(boisson -> { 
                    String FamBoissonName = boisson.getDesignation();
                    nom_boisson.addItem(FamBoissonName); 
                    }); 
                   
                }
            catch(Exception e)
           {
            System.err.println(e);
           }

        }
     
     
     
      private void Fillcombo_2(String famibwason) 
    {
            try
                {   
                    nom_boisson.removeAllItems();
                    List<Boisson> boissons = Boisson.getNames_Boisson_Per_Famille(famibwason);
                    
                    boissons.forEach(boisson -> { 
                    //String BoissonName = boisson.getDesignation();
                    String BoissonName = boisson.getDesignation() + " (" +boisson.getId_boisson() +")"  ;
                    nom_boisson.addItem(BoissonName); 
                        
                    }); 
                   
                }
            catch(Exception e)
           {
            System.err.println(e);
           }
    }
    
     

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        valider = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nom_boisson = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_boisson_plat_menu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nom_fam_boisson = new javax.swing.JComboBox<>();
        ajouter_plat = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nom_plat = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        categorie_plat = new javax.swing.JComboBox<>();
        ajouter_boisson = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jPanel1.add(valider, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 200, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 19, 19));
        jLabel2.setText("Famille boisson");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        nom_boisson.setForeground(new java.awt.Color(127, 19, 19));
        jPanel1.add(nom_boisson, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 200, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 19, 19));
        jLabel4.setText("Nom boisson");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 255, 255), null, new java.awt.Color(102, 255, 255)));

        tab_boisson_plat_menu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19), new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19)));
        tab_boisson_plat_menu.setModel(new javax.swing.table.DefaultTableModel(
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
        tab_boisson_plat_menu.setSelectionBackground(new java.awt.Color(225, 243, 255));
        jScrollPane1.setViewportView(tab_boisson_plat_menu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 430, 150));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 19, 19));
        jLabel1.setText("Menu Boisson-Plat");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 350, -1));

        nom_fam_boisson.setForeground(new java.awt.Color(127, 19, 19));
        jPanel1.add(nom_fam_boisson, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 200, 30));

        ajouter_plat.setBackground(new java.awt.Color(255, 255, 255));
        ajouter_plat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ajouter_plat.setForeground(new java.awt.Color(127, 19, 19));
        ajouter_plat.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\add-icon.png")); // NOI18N
        ajouter_plat.setText("Ajouter");
        ajouter_plat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter_platActionPerformed(evt);
            }
        });
        jPanel1.add(ajouter_plat, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 200, 30));

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
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 200, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 19, 19));
        jLabel3.setText("Categorie plat");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, -1, 30));

        nom_plat.setForeground(new java.awt.Color(127, 19, 19));
        jPanel1.add(nom_plat, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 200, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 19, 19));
        jLabel5.setText("Nom plat");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 100, 30));

        categorie_plat.setForeground(new java.awt.Color(127, 19, 19));
        jPanel1.add(categorie_plat, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 200, 30));

        ajouter_boisson.setBackground(new java.awt.Color(255, 255, 255));
        ajouter_boisson.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ajouter_boisson.setForeground(new java.awt.Color(127, 19, 19));
        ajouter_boisson.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\add-icon.png")); // NOI18N
        ajouter_boisson.setText("Ajouter");
        ajouter_boisson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter_boissonActionPerformed(evt);
            }
        });
        jPanel1.add(ajouter_boisson, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 200, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(127, 19, 19));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\home.png")); // NOI18N
        jButton2.setText("Retour");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajouter_platActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter_platActionPerformed
    //  System.out.println(list.get(list_plat.size()-1));
    }//GEN-LAST:event_ajouter_platActionPerformed

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed
         for(int i=0; i<tab_boisson_plat_menu.getRowCount(); i++)
        {
            list.add((String) tab_boisson_plat_menu.getModel().getValueAt(i,0));
          //  System.out.println(list.get(list.size()-1));
        }

        for (int i=0; i<list_plat.size(); i++)
        {

            try
            {
                String txt= list_plat.get(i);
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
        
        
        for (int i=0; i<list_boisson.size(); i++)
        {

            try
            {
                String txt= list_boisson.get(i);
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
                     long id_not_used= Boisson.insert_boisson_menu(id_p, id_menu_2);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(GESTION_BOISSON_MENU.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        

        JOptionPane.showMessageDialog(null,"Ce menu plat et boisson a bien ete ajoute");

    }//GEN-LAST:event_validerActionPerformed

    private void ajouter_boissonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter_boissonActionPerformed
//        System.out.println(list.get(list_boisson.size()-1));
    }//GEN-LAST:event_ajouter_boissonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(tab_boisson_plat_menu.getSelectedRow() != -1)
        {
            // supprimer la ligne sélectionnée du modèle de table
            model.removeRow(tab_boisson_plat_menu.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Suppression terminee");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        MENU Info;
        Info = new MENU();
        Info.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GESTION_PLAT_BOISSON_MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GESTION_PLAT_BOISSON_MENU().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter_boisson;
    private javax.swing.JButton ajouter_plat;
    private javax.swing.JComboBox<String> categorie_plat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> nom_boisson;
    private javax.swing.JComboBox<String> nom_fam_boisson;
    private javax.swing.JComboBox<String> nom_plat;
    private javax.swing.JTable tab_boisson_plat_menu;
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
