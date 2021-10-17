package gestion_cde_repas;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GESTION_PERSONNE extends javax.swing.JFrame {
    
    CONNECTION conn=new CONNECTION();
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
           stm=conn.avoirconnection().createStatement();
           ResultSet Rs = stm.executeQuery("Select * from personne Order by id_pers");   //la nou pran eleman nan tab la nou mete yo nan tablo a
           while (Rs.next())
           {
               
               model.addRow(new Object[] { Rs.getString("id_pers"), Rs.getString("nom"), Rs.getString("prenom"), Rs.getString("adresse"),  Rs.getString("telephone")});
           }
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
           stm=conn.avoirconnection().createStatement();
           ResultSet Rs = stm.executeQuery("Select * from personne Order by id_pers");   //la nou pran eleman nan tab la nou mete yo nan tablo a
           while (Rs.next())
           {
               
               model.addRow(new Object[] { Rs.getString("id_pers"), Rs.getString("nom"), Rs.getString("prenom"), Rs.getString("adresse"),  Rs.getString("telephone")});
               nom.setText("");
               prenom.setText("");
               adr.setText("");
               tlf.setText("");
           }
           
        } catch(SQLException | HeadlessException e)
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combo.setForeground(new java.awt.Color(0, 0, 102));
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Client", "Viticulteur" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        jPanel1.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 200, 30));

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 255, 255), null, new java.awt.Color(102, 255, 255)));

        tab_pers.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 204), new java.awt.Color(51, 204, 255), new java.awt.Color(51, 0, 204), new java.awt.Color(51, 204, 255)));
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
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("Telephone");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 153));
        jLabel3.setText("Prenom");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 153));
        jLabel4.setText("Adresse");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 30));

        rech.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rech.setForeground(new java.awt.Color(51, 0, 102));
        rech.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 255), new java.awt.Color(51, 0, 102), new java.awt.Color(0, 153, 255), new java.awt.Color(51, 0, 102)));
        rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechActionPerformed(evt);
            }
        });
        jPanel1.add(rech, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 430, 30));

        prenom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenom.setForeground(new java.awt.Color(51, 0, 102));
        prenom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 0, 153), new java.awt.Color(51, 0, 153), null));
        prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomActionPerformed(evt);
            }
        });
        jPanel1.add(prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 200, -1));

        adr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adr.setForeground(new java.awt.Color(51, 0, 102));
        adr.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 0, 153), new java.awt.Color(51, 0, 153), null));
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
        jButton2.setForeground(new java.awt.Color(51, 0, 102));
        jButton2.setText("Ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 200, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 0, 102));
        jButton4.setText("Rechercher");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 140, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 0, 102));
        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 100, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 153));
        jLabel5.setText("Nom");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 30));

        nom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom.setForeground(new java.awt.Color(51, 0, 102));
        nom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 0, 153), new java.awt.Color(51, 0, 153), null));
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 200, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 0, 102));
        jButton5.setText("Modifier");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 110, 30));

        tlf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tlf.setForeground(new java.awt.Color(51, 0, 102));
        tlf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 0, 153), new java.awt.Color(51, 0, 153), null));
        tlf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tlfActionPerformed(evt);
            }
        });
        jPanel1.add(tlf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 200, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 0, 102));
        jButton6.setText("Actualiser");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        try
        {
             
        }
        catch(Exception e)
        {System.err.println(e);}

        
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
              adr.getText().length()==0 && supprimer.getText().length()==0 )
            {
                JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs SVP!");
            } 
         
            else
                {
                    String sql;
                        sql = "insert into personne(nom, prenom, adresse, telephone) VALUES (?,?,?,?)";
                        PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);

                        ps.setString(1,nom.getText());
                        ps.setString(2,prenom.getText());
                        ps.setString(3,adr.getText());
                        ps.setString(4,tlf.getText());
                        ps.execute();
                        
                        stm=conn.avoirconnection().createStatement();
                        ResultSet Rs = stm.executeQuery("Select id_pers from personne Where nom='"+nom.getText()+"' And prenom= '"+prenom.getText()+"' And adresse= '"+adr.getText()+"' And telephone= '"+tlf.getText()+"' ");
                        Rs.next();
                        int id=  Rs.getInt("id_pers");
                        
                        if(combo.getSelectedItem()=="Client")
                        {
                            String sqll = "insert into client(id_pers) VALUES (?)";
                            PreparedStatement pt = conn.avoirconnection().prepareStatement(sqll);
                            
                            pt.setInt(1,id);
                            pt.execute();
                        }
                        else if(combo.getSelectedItem()=="Viticulteur")
                        {
                            String sqll = "insert into Viticulteur(id_pers) VALUES (?)";
                            PreparedStatement pt = conn.avoirconnection().prepareStatement(sqll);
                            
                            pt.setInt(1,id);
                            pt.execute();
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
                Rs=stm.executeQuery("Select * From personne Where  CONCAT(nom, prenom, adresse, telephone) LIKE '%' '"+rech.getText()+"' '%'");
            }
            while(Rs.next())
            {

                Object[] etudiant= {Rs.getInt(1), Rs.getString(2), Rs.getString(3), Rs.getString(4), Rs.getString(5)};
                model.addRow(etudiant);
            }
            if(model.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(null, "Il y a aucune personne correspondant dans le tableau stock");
            }
            
            else
            {
                int i=0; deplace(i);
            }
                 
        }
             
             
            else
            {
                JOptionPane.showMessageDialog(null,"Veuiller remplir le champs en-dessous du bouton rechercher avec le nom de l'article que vous voulez rechercher SVP!!!");
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
 
            if(JOptionPane.showConfirmDialog(null, "Attention! Voulez-vous vraiment supprimer cete personne?", "Suppimer personne", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
            
            {
                
                stm.executeUpdate("Delete From personne Where id_pers="+supprimer.getText());
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

                    String sql = "UPDATE personne set nom= '"+nom.getText()+"', prenom= '"+prenom.getText()+"', adresse= '"+adr.getText()+"', telephone= '"+tlf.getText()+"'  WHERE id_pers= "+supprimer.getText() ;
                    PreparedStatement ps = conn.avoirconnection().prepareStatement(sql);
                    ps.execute();
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
