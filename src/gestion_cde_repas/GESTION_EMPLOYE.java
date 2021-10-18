package gestion_cde_repas;
import gestion_cde_repas.model.CONNECTION;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class GESTION_EMPLOYE extends javax.swing.JFrame {
    CONNECTION conn=new CONNECTION();
    Statement stm;
    ResultSet Rs;
    DefaultTableModel model=new DefaultTableModel();

    public GESTION_EMPLOYE() {
        initComponents();
        setIconImage();
        this.setLocationRelativeTo(null);
        Fillcombo_2();
    }


    @SuppressWarnings("unchecked")
     private void Fillcombo_2() //pour reccuperer la famille de l'article dans la table familleart et le mettre dans la liste item
    {
              try
            {
                 String mysql="select nom, prenom from personne";
                 PreparedStatement pst = conn.avoirconnection().prepareStatement(mysql);
                 ResultSet rs2 = pst.executeQuery();
                 while(rs2.next())
                 {
                     String famiy2=rs2.getString("nom") + " " +rs2.getString("prenom");
                     
                     nom_prenom_emp.addItem(famiy2);
          
                 }
            }
               catch(Exception e)
       {
        System.err.println(e);
       }
              
              
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        nom_prenom_emp = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dip = new javax.swing.JTextField();
        post = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 153));
        jLabel5.setText("Nom");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 153));
        jLabel6.setText("Diplome");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, 30));

        nom_prenom_emp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nom_prenom_emp.setForeground(new java.awt.Color(0, 0, 102));
        nom_prenom_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_prenom_empActionPerformed(evt);
            }
        });
        jPanel1.add(nom_prenom_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 270, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 153));
        jLabel7.setText("Nom et Prenom");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 153));
        jLabel8.setText("Poste");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, 30));

        dip.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dip.setForeground(new java.awt.Color(51, 0, 102));
        dip.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 0, 153), new java.awt.Color(51, 0, 153), null));
        dip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dipMouseClicked(evt);
            }
        });
        dip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dipActionPerformed(evt);
            }
        });
        jPanel1.add(dip, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 270, 30));

        post.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        post.setForeground(new java.awt.Color(51, 0, 102));
        post.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 0, 153), new java.awt.Color(51, 0, 153), null));
        post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postActionPerformed(evt);
            }
        });
        jPanel1.add(post, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 270, 30));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 0, 102));
        jButton6.setText("Valider");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 110, 30));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(51, 0, 102));
        jButton7.setText("Ajouter");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nom_prenom_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_prenom_empActionPerformed
        try
        {

        }
        catch(Exception e)
        {System.err.println(e);}

    }//GEN-LAST:event_nom_prenom_empActionPerformed

    private void dipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dipActionPerformed
//       diplome.add(dip.getText());
//       System.out.println(diplome.get(diplome.size()-1));
    }//GEN-LAST:event_dipActionPerformed

    private void postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postActionPerformed

    private void dipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dipMouseClicked
       diplome.add(dip.getText());
       System.out.println(diplome.get(diplome.size()-1));
    }//GEN-LAST:event_dipMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    
    }//GEN-LAST:event_jButton7ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new GESTION_EMPLOYE().setVisible(true);
        });
    }
    
    
    
    public static ArrayList diplome= new ArrayList <String> ();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dip;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JComboBox<String> nom_prenom_emp;
    private javax.swing.JTextField post;
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
