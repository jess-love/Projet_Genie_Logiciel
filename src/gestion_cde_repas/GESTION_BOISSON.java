package gestion_cde_repas;
import gestion_cde_repas.model.Boisson;


import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GESTION_BOISSON extends javax.swing.JFrame {
        
    DefaultTableModel model=new DefaultTableModel();
    public static long id_fam_boiss=0;
    

    public GESTION_BOISSON() {
        initComponents();
        setIconImage();
        Fillcombo();
        this.setLocationRelativeTo(null);
        
        
        
          
        model.addColumn("Id");
        model.addColumn("Nom famille boisson");
        model.addColumn("Nom boisson");
        model.addColumn("Prix");  


       
        try
        {
            List<Boisson> boissons = Boisson.getAllOrderByIdBoisson();

            boissons.forEach(boisson -> {
                model.addRow(new Object[] {
                        boisson.getId_boisson(),
                        boisson.getNom_fam_boisson(),
                        boisson.getDesignation(),
                        boisson.getPrix(),
                       
                });
            });
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        tab_boisson.setModel(model);
        
        
        nom_fam_boisson.addItemListener((ItemEvent e) -> {
        if(e.getStateChange()==ItemEvent.SELECTED)
        {
        String item= e.getItem().toString(); 
        if("Vin".equals(item))
        {                              
            try {
                long id_fam_boisson = Boisson.getId_particulier(item);
                id_fam_boiss=id_fam_boisson;
                setVisible(false);
                GESTION_CATEGORIE_VIN Info;
                Info = new GESTION_CATEGORIE_VIN();
                Info.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(GESTION_BOISSON.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        }
        
        });
        
     
        
    }

    @SuppressWarnings("unchecked")


     private void Fillcombo() 
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
        
     
    
    
    
    
     private void affiche()
    {
        try
        {
           model.setRowCount(0);

          List<Boisson> boissons = Boisson.getAllOrderByIdBoisson();
          
          boissons.forEach(boisson -> {
                model.addRow(new Object[] {
                        boisson.getId_boisson(),
                        boisson.getNom_fam_boisson(),
                        boisson.getDesignation(),
                        boisson.getPrix(),
                       
                });

                nom_boisson.setText("");
                nom_fam_boisson.setSelectedItem("");
                prix.setText("");
                rech.setText("");
             
            });

        } catch(HeadlessException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 
    }
     
 //*************************************************************************************
     
     
         private void deplace(int i)
                
    {
        try
        {   
            supprimer.setText(model.getValueAt(i,0).toString());
            nom_fam_boisson.setSelectedItem(model.getValueAt(i,1).toString());
            nom_boisson.setText(model.getValueAt(i,2).toString());
            prix.setText(model.getValueAt(i,3).toString());
            
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_boisson = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        rech = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nom_boisson = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        prix = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nom_fam_boisson = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        supprimer = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 255, 255), null, new java.awt.Color(102, 255, 255)));

        tab_boisson.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19), new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19)));
        tab_boisson.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tab_boisson.setSelectionBackground(new java.awt.Color(225, 243, 255));
        tab_boisson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_boissonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_boisson);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 510, 250));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(127, 19, 19));
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\refresh.png")); // NOI18N
        jButton6.setText("Actualiser");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 110, 30));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(127, 19, 19));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\upcoming-work.png")); // NOI18N
        jButton5.setText("Modifier");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 130, 30));

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
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 130, 30));

        rech.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rech.setForeground(new java.awt.Color(127, 19, 19));
        rech.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19), new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19)));
        rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechActionPerformed(evt);
            }
        });
        jPanel1.add(rech, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 360, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(127, 19, 19));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\rechercher.png")); // NOI18N
        jButton4.setText("Rechercher");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 140, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(127, 19, 19));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\add-icon.png")); // NOI18N
        jButton2.setText("Ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 610, 380, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 19, 19));
        jLabel1.setText("Boisson");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 200, 50));

        nom_boisson.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom_boisson.setForeground(new java.awt.Color(127, 19, 19));
        nom_boisson.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(127, 19, 19), new java.awt.Color(127, 19, 19), null));
        nom_boisson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_boissonActionPerformed(evt);
            }
        });
        jPanel1.add(nom_boisson, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 380, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 19, 19));
        jLabel2.setText("Famille boisson");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 110, 30));

        prix.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prix.setForeground(new java.awt.Color(127, 19, 19));
        prix.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(127, 19, 19), new java.awt.Color(127, 19, 19), null));
        prix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prixActionPerformed(evt);
            }
        });
        jPanel1.add(prix, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 380, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 19, 19));
        jLabel3.setText("Prix");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 100, 30));

        nom_fam_boisson.setForeground(new java.awt.Color(127, 19, 19));
        jPanel1.add(nom_fam_boisson, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 380, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 19, 19));
        jLabel4.setText("Nom boisson");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 100, 30));

        supprimer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        supprimer.setForeground(new java.awt.Color(51, 0, 102));
        supprimer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 0, 153), new java.awt.Color(51, 0, 153), null));
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });
        jPanel1.add(supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 0, 30));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_boissonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_boissonMouseClicked
        int i;
        i = tab_boisson.getSelectedRow();
        deplace(i);
    }//GEN-LAST:event_tab_boissonMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        affiche();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try
        {    if(supprimer.getText().length()==0)
            {JOptionPane.showMessageDialog(null,"Veuillez rechercher l'element a modifier dans le tableau et presser sur la ligne correspondante dans le tableau");} else{

                if(JOptionPane.showConfirmDialog(null,"Confirmer la modification", "Modification", JOptionPane.YES_NO_OPTION)== JOptionPane.OK_OPTION)
                {   
                    double pri=Double.parseDouble(prix.getText());
                    int res = Boisson.update(Long.parseLong(supprimer.getText()), nom_boisson.getText(), pri );

                    affiche();
                }
            } }
            catch(HeadlessException | NumberFormatException | SQLException  e)
            {
                JOptionPane.showMessageDialog(null,"erreur de modification" +e.getMessage());
                System.err.println(e);
            }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try
        {
            if(supprimer.getText().length()==0)
            {JOptionPane.showMessageDialog(null,"Veuillez rechercher l'element a supprimer dans le tableau et presser sur la ligne correspondante dans le tableau");}
            else
            {

                if(JOptionPane.showConfirmDialog(null, "Attention! Voulez-vous vraiment supprimer ce boisson?", "Suppimer boisson", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)

                {

                    Boisson.delete(Long.parseLong(supprimer.getText()));
                    affiche();
                }

            }

        }
        catch(SQLException | HeadlessException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void rechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try
        {
            model.setRowCount(0);
            if(rech.getText().length()!=0)
            {
                {
                    List<Boisson> boissons = Boisson.search_boisson(rech.getText());

                    boissons.forEach(Boissons -> {
                        model.addRow(new Object[] {
                        Boissons.getId_boisson(),
                        Boissons.getNom_fam_boisson(),
                        Boissons.getDesignation(),
                        Boissons.getPrix(),
                        });
                    });
                }

                if(model.getRowCount()==0)
                {
                    JOptionPane.showMessageDialog(null, "Il y a aucun boisson correspondant dans le tableau ");
                }

                else
                {
                    int i=0;
                    deplace(i);
                }

            }

            else
            {
                JOptionPane.showMessageDialog(null,"Veuiller remplir le champs a cote du bouton rechercher avec le nom de l'article que vous voulez rechercher SVP!!!");
                affiche();
            }

        }
        catch(SQLException | HeadlessException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
            if(nom_boisson.getText().length()==0  && prix.getText().length()==0  )
            {
                JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs SVP!");
            }

            else
            {   
                
            String nom_fam= nom_fam_boisson.getSelectedItem().toString();   
            long id_fam_boisson = Boisson.getId_particulier(nom_fam);
            double pri=Double.parseDouble(prix.getText());  

            long id_boisson = Boisson.insert(id_fam_boisson, nom_boisson.getText(), pri);

            JOptionPane.showMessageDialog(null,"Ce boisson a bien ete ajoute");

                nom_boisson.setText("");
                nom_fam_boisson.setSelectedItem("");
                prix.setText("");
                affiche();
            }

        }

        catch(SQLException | HeadlessException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void nom_boissonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_boissonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_boissonActionPerformed

    private void prixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prixActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supprimerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                setVisible(false);
                MENU Info;
                Info = new MENU();
                Info.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

  
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new GESTION_BOISSON().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nom_boisson;
    private javax.swing.JComboBox<String> nom_fam_boisson;
    private javax.swing.JTextField prix;
    private javax.swing.JTextField rech;
    private javax.swing.JTextField supprimer;
    private javax.swing.JTable tab_boisson;
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
