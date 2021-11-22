package gestion_cde_repas;

import gestion_cde_repas.model.Table;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GESTION_TABLE extends javax.swing.JFrame {
    DefaultTableModel model=new DefaultTableModel();
 
    public GESTION_TABLE() {
        initComponents();
        setIconImage();
        
        this.setLocationRelativeTo(null);
        
        model.addColumn("Id");
        model.addColumn("Numero table");
        model.addColumn("Type table");

       
        try
        {
            List<Table> tables = Table.getAllOrderById();

            tables.forEach(table -> {
                model.addRow(new Object[] {
                        table.getId_Tab(),
                        table.getNumero(),
                        table.getNom_Tab(),

                       
                });
            });
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        tab_table.setModel(model);
        
    }

    @SuppressWarnings("unchecked")
    
    private void affiche() throws SQLException
    {
        try
        {
           model.setRowCount(0);

           List<Table> tables = Table.getAllOrderById();

            tables.forEach(table -> {
                model.addRow(new Object[] {
                        table.getId_Tab(),
                        table.getNumero(),
                        table.getNom_Tab(),
                });

                numero_table.setText("");
                supprimer.setText("");
          
             
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
            numero_table.setText(model.getValueAt(i,1).toString());
            nom_tab.setSelectedItem(model.getValueAt(i,2).toString());
            
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
        jLabel4 = new javax.swing.JLabel();
        supprimer = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_table = new javax.swing.JTable();
        numero_table = new javax.swing.JTextField();
        rech = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        nom_tab = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Type table");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 120, -1));

        supprimer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        supprimer.setForeground(new java.awt.Color(51, 0, 102));
        supprimer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 0, 153), new java.awt.Color(51, 0, 153), null));
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });
        jPanel1.add(supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 0, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\check.png")); // NOI18N
        jButton2.setText("Valider");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 310, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(135, 19, 19));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\supprimer.png")); // NOI18N
        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 140, 30));

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 255, 255), null, new java.awt.Color(102, 255, 255)));

        tab_table.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(131, 11, 11), new java.awt.Color(255, 102, 102), new java.awt.Color(131, 11, 11)));
        tab_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tab_table.setSelectionBackground(new java.awt.Color(135, 208, 233));
        tab_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 440, 190));

        numero_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numero_table.setForeground(new java.awt.Color(255, 102, 102));
        numero_table.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102), null));
        numero_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numero_tableActionPerformed(evt);
            }
        });
        jPanel1.add(numero_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 310, 30));

        rech.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rech.setForeground(new java.awt.Color(51, 0, 102));
        rech.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(131, 11, 11), new java.awt.Color(255, 102, 102), new java.awt.Color(131, 11, 11), new java.awt.Color(255, 102, 102)));
        rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechActionPerformed(evt);
            }
        });
        jPanel1.add(rech, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 290, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(135, 19, 19));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\rechercher.png")); // NOI18N
        jButton4.setText("Rechercher");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, 30));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(135, 19, 19));
        jButton6.setText("Actualiser");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 110, 30));

        nom_tab.setForeground(new java.awt.Color(153, 0, 0));
        nom_tab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standard", "VIP" }));
        nom_tab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_tabActionPerformed(evt);
            }
        });
        jPanel1.add(nom_tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 310, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Numero table");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 120, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(135, 19, 19));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\home.png")); // NOI18N
        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 110, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 19, 19));
        jLabel1.setText("Table");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        MENU Info;
        Info = new MENU();
        Info.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            affiche();
        } catch (SQLException ex) {
            Logger.getLogger(GESTION_TABLE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try
        {
            model.setRowCount(0);
            if(rech.getText().length()!=0)
            {
                {
                    List<Table> table = Table.search(rech.getText());

                    table.forEach(tables -> {
                        model.addRow(new Object[] {
                            tables.getId_Tab(),
                            tables.getNumero(),
                            tables.getNom_Tab(),
                        });
                    });
                }

                if(model.getRowCount()==0)
                {
                    JOptionPane.showMessageDialog(null, "Il y a aucun numero de table correspondant dans le tableau ");
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

    private void rechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechActionPerformed

    private void numero_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numero_tableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numero_tableActionPerformed

    private void tab_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_tableMouseClicked
        int i;
        i = tab_table.getSelectedRow();
        deplace(i);
    }//GEN-LAST:event_tab_tableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try
        {
            if(supprimer.getText().length()==0)
            {JOptionPane.showMessageDialog(null,"Veuillez rechercher l'element a supprimer dans le tableau et presser sur la ligne correspondante dans le tableau");}
            else
            {

                if(JOptionPane.showConfirmDialog(null, "Attention! Voulez-vous vraiment supprimer cette table?", "Suppimer boisson", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)

                {

                    Table.delete(Long.parseLong(supprimer.getText()));
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
            if(numero_table.getText().length()==0   )
            {
                JOptionPane.showMessageDialog(null,"Veuillez remplir le champs numero table SVP!");
            }

            else
            {

                long no_tab=Long.parseLong(numero_table.getText());
                long id_tab = Table.insert(no_tab,nom_tab.getSelectedItem().toString());

                JOptionPane.showMessageDialog(null,"Ce numero de table a bien ete ajoute");

                numero_table.setText("");
                nom_tab.getSelectedItem();
                affiche();

            }

        }

        catch(HeadlessException | NumberFormatException | SQLException  e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supprimerActionPerformed

    private void nom_tabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_tabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_tabActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GESTION_TABLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new GESTION_TABLE().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> nom_tab;
    private javax.swing.JTextField numero_table;
    private javax.swing.JTextField rech;
    private javax.swing.JTextField supprimer;
    private javax.swing.JTable tab_table;
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
