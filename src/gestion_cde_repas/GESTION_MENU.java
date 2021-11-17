
package gestion_cde_repas;

import gestion_cde_repas.model.Menu;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GESTION_MENU extends javax.swing.JFrame {
    DefaultTableModel model=new DefaultTableModel();
    public static long id_dernier_menu;

    public GESTION_MENU() {
        initComponents();
        
        model.addColumn("Id");
        model.addColumn("Nom du menu");
        model.addColumn("Rabais");
  


       
        try
        {
            List<Menu> menus = Menu.getAllOrderById();

            menus.forEach(menu -> {
                model.addRow(new Object[] {
                        menu.getId_Menu(),
                        menu.getNom_Menu(),
                        menu.getRabais(),
                        
                       
                });
            });
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        menu.setModel(model);
        
        
        
    }//check.isSelected()


    @SuppressWarnings("unchecked")
    
    private void affiche()
    {
        try
        {
           model.setRowCount(0);
           List<Menu> menus = Menu.getAllOrderById();

            menus.forEach(menu -> {
                model.addRow(new Object[] {
                        menu.getId_Menu(),
                        menu.getNom_Menu(),
                        menu.getRabais(),
                        
                       
                });

                nom_menu.setText("");
                rabais.setText("");
                //supprimer.setText("");
               // rech.setText("");
             
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
           // supprimer.setText(model.getValueAt(i,0).toString());
            nom_menu.setText(model.getValueAt(i,1).toString());
            rabais.setText(model.getValueAt(i,2).toString());
            //prix.setText(model.getValueAt(i,3).toString());
            
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
        nom_menu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rabais = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menu = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 153));
        jLabel4.setText("Nom du menu");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 120, 30));

        nom_menu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom_menu.setForeground(new java.awt.Color(51, 0, 102));
        nom_menu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 0, 153), new java.awt.Color(51, 0, 153), null));
        nom_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_menuActionPerformed(evt);
            }
        });
        jPanel1.add(nom_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 380, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 153));
        jLabel5.setText("Prix rabais");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 120, 30));

        rabais.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rabais.setForeground(new java.awt.Color(51, 0, 102));
        rabais.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 0, 153), new java.awt.Color(51, 0, 153), null));
        rabais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rabaisActionPerformed(evt);
            }
        });
        jPanel1.add(rabais, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 380, 30));

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(51, 0, 102));
        jCheckBox2.setText("Plat et Boisson");
        jCheckBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 102), 2));
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 120, -1));

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(51, 0, 102));
        jCheckBox3.setText("Plat");
        jCheckBox3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 102), 2));
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 100, -1));

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(51, 0, 102));
        jCheckBox4.setText("Boisson");
        jCheckBox4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 102), 2));
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 100, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("Creer Menu");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 255, 255), null, new java.awt.Color(102, 255, 255)));

        menu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 204), new java.awt.Color(51, 204, 255), new java.awt.Color(51, 0, 204), new java.awt.Color(51, 204, 255)));
        menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        menu.setSelectionBackground(new java.awt.Color(225, 243, 255));
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(menu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 630, 140));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 0, 102));
        jButton2.setText("Ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 380, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nom_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_menuActionPerformed

    private void rabaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rabaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rabaisActionPerformed

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        int i;
        i = menu.getSelectedRow();
        deplace(i);
    }//GEN-LAST:event_menuMouseClicked

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
                setVisible(false);
                GESTION_BOISSON_MENU Info;
                Info = new GESTION_BOISSON_MENU();
                Info.setVisible(true);
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
                setVisible(false);
                GESTION_PLAT_MENU Info;
                Info = new GESTION_PLAT_MENU();
                Info.setVisible(true);
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
            if(nom_menu.getText().length()==0 )
            {
                JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs SVP!");
            }

            else
            {
                double pri=Double.parseDouble(rabais.getText());  
                id_dernier_menu = Menu.insert(nom_menu.getText(), pri );

                JOptionPane.showMessageDialog(null,"Ce menu a bien ete ajoute");
                nom_menu.setText("");
                rabais.setText("");
               
                affiche();
            }

        }

        catch(SQLException | HeadlessException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
                setVisible(false);
                GESTION_PLAT_BOISSON_MENU Info;
                Info = new GESTION_PLAT_BOISSON_MENU();
                Info.setVisible(true);
    }//GEN-LAST:event_jCheckBox2ActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GESTION_MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new GESTION_MENU().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable menu;
    private javax.swing.JTextField nom_menu;
    private javax.swing.JTextField rabais;
    // End of variables declaration//GEN-END:variables
}
