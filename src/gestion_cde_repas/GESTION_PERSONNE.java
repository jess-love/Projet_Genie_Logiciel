package gestion_cde_repas;
import gestion_cde_repas.model.Client;
import gestion_cde_repas.model.Personne;
import gestion_cde_repas.model.Viticulteur;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GESTION_PERSONNE extends javax.swing.JFrame {
    
    
    Statement stm;
    ResultSet Rs;
    DefaultTableModel model=new DefaultTableModel();
    
    public GESTION_PERSONNE() {
        initComponents();
        setIconImage();
        this.setLocationRelativeTo(null);
        
        
        model.addColumn("Id");
        model.addColumn("Nom");
        model.addColumn("Prenom");  
        model.addColumn("Adresse"); 
        model.addColumn("Telephone");

       
        try
        {
            List<Personne> personnes = Personne.getAllOrderById();

            personnes.forEach(personne -> {
                model.addRow(new Object[] {
                        personne.getId_pers(),
                        personne.getNom(),
                        personne.getPrenom(),
                        personne.getAdresse(),
                        personne.getTelephone()
                });
            });
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        tab_pers.setModel(model);
        
    }

 
    @SuppressWarnings("unchecked")
    
    
     private void affiche()
    {
        try
        {
           model.setRowCount(0);

            List<Personne> personnes = Personne.getAllOrderById();

            personnes.forEach(personne -> {
                model.addRow(new Object[] {
                        personne.getId_pers(),
                        personne.getNom(),
                        personne.getPrenom(),
                        personne.getAdresse(),
                        personne.getTelephone()
                });

                nom.setText("");
                prenom.setText("");
                adr.setText("");
                tlf.setText("");
                supprimer.setText("");
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
            
            nom.setText(model.getValueAt(i,1).toString());
            prenom.setText(model.getValueAt(i,2).toString());
            adr.setText(model.getValueAt(i,3).toString());
            tlf.setText(model.getValueAt(i,4).toString());
            supprimer.setText(model.getValueAt(i,0).toString());
             
 
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
        combo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_pers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rech = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        adr = new javax.swing.JTextField();
        supprimer = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        tlf = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combo.setForeground(new java.awt.Color(127, 19, 19));
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employe", "Viticulteur" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        jPanel1.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 200, 30));

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 255, 255), null, new java.awt.Color(102, 255, 255)));

        tab_pers.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(127, 19, 19), new java.awt.Color(255, 153, 153), new java.awt.Color(127, 19, 19), new java.awt.Color(255, 153, 153)));
        tab_pers.setModel(new javax.swing.table.DefaultTableModel(
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
        tab_pers.setSelectionBackground(new java.awt.Color(225, 243, 255));
        tab_pers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_persMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_pers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 580, 180));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 19, 19));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\phone1.png")); // NOI18N
        jLabel1.setText("Telephone");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 19, 19));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\nom.png")); // NOI18N
        jLabel3.setText("Prenom");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 19, 19));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\adresse.png")); // NOI18N
        jLabel4.setText("Adresse");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 40));

        rech.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rech.setForeground(new java.awt.Color(127, 19, 19));
        rech.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 153), new java.awt.Color(154, 42, 48), new java.awt.Color(255, 153, 153), new java.awt.Color(154, 42, 48)));
        rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechActionPerformed(evt);
            }
        });
        jPanel1.add(rech, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 430, 30));

        prenom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenom.setForeground(new java.awt.Color(127, 19, 19));
        prenom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(154, 42, 48), new java.awt.Color(154, 42, 48), null));
        prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomActionPerformed(evt);
            }
        });
        jPanel1.add(prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 200, -1));

        adr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adr.setForeground(new java.awt.Color(127, 19, 19));
        adr.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(154, 42, 48), new java.awt.Color(154, 42, 48), null));
        adr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adrActionPerformed(evt);
            }
        });
        jPanel1.add(adr, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 200, -1));

        supprimer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        supprimer.setForeground(new java.awt.Color(255, 255, 255));
        supprimer.setBorder(null);
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });
        jPanel1.add(supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 60, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(127, 19, 19));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\check.png")); // NOI18N
        jButton2.setText("Valider");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 200, 30));

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
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 140, 30));

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
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 130, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 19, 19));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\nom.png")); // NOI18N
        jLabel5.setText("Nom");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 40));

        nom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom.setForeground(new java.awt.Color(127, 19, 19));
        nom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(154, 42, 48), new java.awt.Color(154, 42, 48), null));
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 200, -1));

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
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 110, 30));

        tlf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tlf.setForeground(new java.awt.Color(127, 19, 19));
        tlf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(154, 42, 48), new java.awt.Color(154, 42, 48), null));
        tlf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tlfActionPerformed(evt);
            }
        });
        jPanel1.add(tlf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 200, -1));

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
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 110, 30));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(127, 19, 19));
        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\home.png")); // NOI18N
        jButton7.setText("Retour");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed

        
    }//GEN-LAST:event_comboActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supprimerActionPerformed

    private void rechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechActionPerformed

    private void prenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomActionPerformed

    private void adrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adrActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try
        {
            if(nom.getText().length()==0 && prenom.getText().length()==0 && 
              adr.getText().length()==0 && tlf.getText().length()==0 )
            {
                JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs SVP!");
            } 
         
            else
                {
                    long id_pers = Personne.insert(nom.getText(), prenom.getText(), adr.getText(), tlf.getText());

                    if(combo.getSelectedItem()=="Viticulteur")
                    {
                        Viticulteur.insert(id_pers);
                    }

                    JOptionPane.showMessageDialog(null,"Cette personne a bien ete ajoute");
                    nom.setText("");
                    prenom.setText("");
                    adr.getText();
                    tlf.setText("");
                    affiche();
                }

        }

        catch(SQLException | HeadlessException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                try
        {           
            model.setRowCount(0); 
             if(rech.getText().length()!=0)
        {
            {
                List<Personne> personnes = Personne.search(rech.getText());

                personnes.forEach(personne -> {
                    model.addRow(new Object[] {
                            personne.getId_pers(),
                            personne.getNom(),
                            personne.getPrenom(),
                            personne.getAdresse(),
                            personne.getTelephone()
                    });
                });
            }

            if(model.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(null, "Il y a aucune personne correspondant dans le tableau ");
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

    private void tab_persMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_persMouseClicked
         int i;
        i = tab_pers.getSelectedRow();
        deplace(i); 
    }//GEN-LAST:event_tab_persMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           try
        {   
            if(supprimer.getText().length()==0)
            {JOptionPane.showMessageDialog(null,"Veuillez rechercher l'element a supprimer dans le tableau et presser sur la ligne correspondante dans le tableau");} 
        else
           {
 
            if(JOptionPane.showConfirmDialog(null, "Attention! Voulez-vous vraiment supprimer cette personne?", "Suppimer personne", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
            
            {
                
                Personne.delete(Long.parseLong(supprimer.getText()));
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

    private void tlfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tlfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tlfActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       try
        {    if(supprimer.getText().length()==0)
            {JOptionPane.showMessageDialog(null,"Veuillez rechercher l'element a modifier dans le tableau et presser sur la ligne correspondante dans le tableau");} else{

                if(JOptionPane.showConfirmDialog(null,"Confirmer la modification", "Modification", JOptionPane.YES_NO_OPTION)== JOptionPane.OK_OPTION)
                {
                    int res = Personne.update(Long.parseLong(supprimer.getText()), nom.getText(), prenom.getText(), adr.getText(), tlf.getText());

                    affiche();
                }
            } }
            catch(HeadlessException | SQLException e)
            {
                JOptionPane.showMessageDialog(null,"erreur de modification" +e.getMessage());
                System.err.println(e);
            }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        affiche();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        setVisible(false);
        MENU Info;
        Info = new MENU();
        Info.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed


    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> {
            new GESTION_PERSONNE().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adr;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField prenom;
    private javax.swing.JTextField rech;
    private javax.swing.JTextField supprimer;
    private javax.swing.JTable tab_pers;
    private javax.swing.JTextField tlf;
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
