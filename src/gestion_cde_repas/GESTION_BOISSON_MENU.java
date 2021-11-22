package gestion_cde_repas;

import gestion_cde_repas.model.Boisson;
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


public class GESTION_BOISSON_MENU extends javax.swing.JFrame {
    DefaultTableModel model=new DefaultTableModel();
    List<String> list=new ArrayList<String>();

 

    public GESTION_BOISSON_MENU() {
        initComponents();
        setIconImage();
        this.setLocationRelativeTo(null);
        

        model.addColumn("Nom boisson");
        
     
               
        nom_fam_boisson.addItemListener((ItemEvent e) -> {
        if(e.getStateChange()==ItemEvent.SELECTED)
        {
        String item= e.getItem().toString(); 
        Fillcombo_1(item);
        }
        });
        Fillcombo_Boisson();
        Fillcombo_Famille_Boisson();


        
        
        
       ajouter.addActionListener((ActionEvent e) -> {
            
        model.addRow(
                    new Object[]{
                       
                    nom_boisson.getSelectedItem()
                        
                    }
            );
        });
  
        tab_boisson_menu.setModel(model);
    
        

        
    }

    @SuppressWarnings("unchecked")
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
     
     
     
      private void Fillcombo_1(String famibwason) 
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
    
     

      

        private void deplace(int i)
                
    {
        try
        {   
           
            nom_boisson.setSelectedItem(model.getValueAt(i,0).toString());
            
            
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
        nom_boisson = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_boisson_menu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nom_fam_boisson = new javax.swing.JComboBox<>();
        ajouter = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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
        jLabel2.setText("Famille boisson");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 30));

        nom_boisson.setForeground(new java.awt.Color(127, 19, 19));
        nom_boisson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nom_boissonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nom_boissonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nom_boissonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nom_boissonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nom_boissonMouseReleased(evt);
            }
        });
        jPanel1.add(nom_boisson, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 200, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 19, 19));
        jLabel4.setText("Nom boisson");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 255, 255), null, new java.awt.Color(102, 255, 255)));

        tab_boisson_menu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19), new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19)));
        tab_boisson_menu.setModel(new javax.swing.table.DefaultTableModel(
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
        tab_boisson_menu.setSelectionBackground(new java.awt.Color(225, 243, 255));
        tab_boisson_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_boisson_menuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_boisson_menu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 340, 150));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 19, 19));
        jLabel1.setText("Menu Boisson");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 260, -1));

        nom_fam_boisson.setForeground(new java.awt.Color(127, 19, 19));
        jPanel1.add(nom_fam_boisson, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 200, 30));

        ajouter.setBackground(new java.awt.Color(255, 255, 255));
        ajouter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ajouter.setForeground(new java.awt.Color(127, 19, 19));
        ajouter.setIcon(new javax.swing.ImageIcon("C:\\Users\\Getro_BUISSERETH\\Documents\\NetBeansProjects\\GESTION_CDE_REPAS\\img\\plus.png")); // NOI18N
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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed
       

        for(int i=0; i<tab_boisson_menu.getRowCount(); i++)
             {
                  list.add((String) tab_boisson_menu.getModel().getValueAt(i,0));
                   System.out.println(list.get(list.size()-1));
             }
         
            
            for (int i=0; i<list.size(); i++)
            {
                
            try 
            {
                String txt= list.get(i);
                String id = txt.substring(txt.indexOf("(")+1,txt.indexOf(")"));
                long id_b= Long.parseLong(id);
                
                System.out.println(id_b);
                long id_menu_1= GESTION_MENU.id_dernier_menu;
                long id_menu_2=GESTION_MENU.id_menu;
                if(id_menu_1 !=0 )
                {
                long id_not_used= Boisson.insert_boisson_menu(id_b, id_menu_1);
                }
                else
                {
                     long id_not_used= Boisson.insert_boisson_menu(id_b, id_menu_2);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(GESTION_BOISSON_MENU.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
            }

            JOptionPane.showMessageDialog(null,"Ce menu boisson a bien ete ajoute");
         
            
           
        
    }//GEN-LAST:event_validerActionPerformed

    private void tab_boisson_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_boisson_menuMouseClicked
        int i;
        i = tab_boisson_menu.getSelectedRow();
        deplace(i);
    }//GEN-LAST:event_tab_boisson_menuMouseClicked

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed



    }//GEN-LAST:event_ajouterActionPerformed

    private void nom_boissonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nom_boissonMouseClicked

        
    }//GEN-LAST:event_nom_boissonMouseClicked

    private void nom_boissonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nom_boissonMousePressed
              

    }//GEN-LAST:event_nom_boissonMousePressed

    private void nom_boissonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nom_boissonMouseEntered

    }//GEN-LAST:event_nom_boissonMouseEntered

    private void nom_boissonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nom_boissonMouseReleased

    }//GEN-LAST:event_nom_boissonMouseReleased

    private void nom_boissonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nom_boissonMouseExited

    }//GEN-LAST:event_nom_boissonMouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
            // vérifier d'abord la ligne sélectionnée
            if(tab_boisson_menu.getSelectedRow() != -1) 
            {
               // supprimer la ligne sélectionnée du modèle de table
               model.removeRow(tab_boisson_menu.getSelectedRow());
               JOptionPane.showMessageDialog(null, "Suppression terminee");
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        GESTION_MENU Info;
        Info = new GESTION_MENU();
        Info.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

 
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new GESTION_BOISSON_MENU().setVisible(true);
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> nom_boisson;
    private javax.swing.JComboBox<String> nom_fam_boisson;
    private javax.swing.JTable tab_boisson_menu;
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
