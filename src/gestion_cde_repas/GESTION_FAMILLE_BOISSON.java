package gestion_cde_repas;
//import gestion_cde_repas.model.CONNECTION;
import gestion_cde_repas.model.Famille_boisson;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GESTION_FAMILLE_BOISSON extends javax.swing.JFrame {
    DefaultTableModel model=new DefaultTableModel();
  

    public GESTION_FAMILLE_BOISSON() {
        initComponents();
        setIconImage();
        this.setLocationRelativeTo(null);
        
        model.addColumn("Numero"); 
        model.addColumn("Nom famille");

        try
        {
            List<Famille_boisson> famille_boissons = Famille_boisson.getAllOrderById();

            famille_boissons.forEach(familleBoisson -> {
                model.addRow(new Object[] { familleBoisson.getId_fam_boisson(), familleBoisson.getNom_fam_boisson() });
            });
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        tab_fam_boisson.setModel(model);
    }

 
    @SuppressWarnings("unchecked")
    
     private void affiche()
    {
        try
        {
           model.setRowCount(0);
            List<Famille_boisson> famille_boissons = Famille_boisson.getAllOrderById();

            famille_boissons.forEach(familleBoisson -> {
                    model.addRow(new Object[] { 
                    familleBoisson.getId_fam_boisson(), 
                    familleBoisson.getNom_fam_boisson() });
            });
           nom.setText("");
           rech.setText("");
           supprimer.setText("");
           
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
            nom.setText(model.getValueAt(i,1).toString());

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
        tab_fam_boisson = new javax.swing.JTable();
        rech = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        nom = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        supprimer = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 255, 255), null, new java.awt.Color(102, 255, 255)));

        tab_fam_boisson.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(153, 0, 0), new java.awt.Color(255, 102, 102), new java.awt.Color(153, 0, 0)));
        tab_fam_boisson.setModel(new javax.swing.table.DefaultTableModel(
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
        tab_fam_boisson.setSelectionBackground(new java.awt.Color(225, 243, 255));
        tab_fam_boisson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_fam_boissonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_fam_boisson);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 470, 240));

        rech.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rech.setForeground(new java.awt.Color(153, 0, 0));
        rech.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(153, 0, 0), new java.awt.Color(255, 102, 102), new java.awt.Color(153, 0, 0)));
        rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechActionPerformed(evt);
            }
        });
        jPanel1.add(rech, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 330, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(153, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\rechercher.png")); // NOI18N
        jButton4.setText("Rechercher");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 30));

        nom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom.setForeground(new java.awt.Color(153, 0, 0));
        nom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 0, 0), new java.awt.Color(153, 0, 0), null));
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 370, 30));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 370, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Nom");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 40, 30));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(153, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\refresh.png")); // NOI18N
        jButton6.setText("Actualiser");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 110, 30));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\upcoming-work.png")); // NOI18N
        jButton5.setText("Modifier");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 110, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\supprimer.png")); // NOI18N
        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, 30));

        supprimer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        supprimer.setForeground(new java.awt.Color(51, 0, 102));
        supprimer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 0, 153), new java.awt.Color(51, 0, 153), null));
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });
        jPanel1.add(supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 0, 20));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\home.png")); // NOI18N
        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 100, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Famille Boisson");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 190, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_fam_boissonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_fam_boissonMouseClicked
        int i;
        i = tab_fam_boisson.getSelectedRow();
        deplace(i);
    }//GEN-LAST:event_tab_fam_boissonMouseClicked

    private void rechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try
        {
            model.setRowCount(0);
            if(rech.getText().length()!=0)
            {
                List<Famille_boisson> famille_boissons = Famille_boisson.search(rech.getText());

                famille_boissons.forEach(familleBoisson -> {
                    Object[] etudiant= { familleBoisson.getId_fam_boisson(), familleBoisson.getNom_fam_boisson() };
                    model.addRow(etudiant);
                });

                if(model.getRowCount()==0)
                {
                    JOptionPane.showMessageDialog(null, "Il y a aucune famille de boisson correspondant dans le tableau");
                }

                else
                {
                    int i=0; deplace(i); 
                }

            }

            else
            {
                JOptionPane.showMessageDialog(null,"Veuiller remplir le champs du bouton rechercher SVP!!!");
                affiche();
            }

        }
        catch(SQLException | HeadlessException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
            if(nom.getText().length()==0  )
            {
                JOptionPane.showMessageDialog(null,"Veuillez remplir le champ nom SVP!");
            }

            else
            {
                 Famille_boisson.insert(nom.getText());
                
               
                JOptionPane.showMessageDialog(null,"Cette famille a bien ete ajoute");
                nom.setText("");
                affiche();
            }

        }

        catch(SQLException | HeadlessException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        affiche();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try
        {    if(supprimer.getText().length()==0)
            {JOptionPane.showMessageDialog(null,"Veuillez rechercher l'element a modifier dans le tableau et presser sur la ligne correspondante dans le tableau");} else{

                if(JOptionPane.showConfirmDialog(null,"Confirmer la modification", "Modification", JOptionPane.YES_NO_OPTION)== JOptionPane.OK_OPTION)
                {
                    Famille_boisson.update(Integer.parseInt(supprimer.getText()), nom.getText());
                    affiche();
                }
            } }
            catch(HeadlessException | SQLException e)
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
                if(JOptionPane.showConfirmDialog(null, "Attention! Voulez-vous vraiment supprimer cette famille?", "Suppimer personne", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)

                {
                    Famille_boisson.delete(Integer.parseInt(supprimer.getText()));
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
            new GESTION_FAMILLE_BOISSON().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField rech;
    private javax.swing.JTextField supprimer;
    private javax.swing.JTable tab_fam_boisson;
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
