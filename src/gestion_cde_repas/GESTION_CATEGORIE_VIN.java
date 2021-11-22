package gestion_cde_repas;

import gestion_cde_repas.model.Boisson;
import gestion_cde_repas.model.Carte_vin;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GESTION_CATEGORIE_VIN extends javax.swing.JFrame {
     DefaultTableModel model=new DefaultTableModel();

    public GESTION_CATEGORIE_VIN() {
        initComponents();
        setIconImage();
        Fillcombo();
        this.setLocationRelativeTo(null);
        
        
        
          
        model.addColumn("Id");
        model.addColumn("Nom vin");
        model.addColumn("Prix achat");
        model.addColumn("Prix vente"); 
        model.addColumn("Date achat"); 
        model.addColumn("Millesime"); 
        
        
        
         try
        {
            List<Carte_vin> vin = Carte_vin.getAllOrderById();

            vin.forEach(vins -> {
                model.addRow(new Object[] {
                        vins.getId_Cart_Vin(),
                        vins.getNom_Boisson(),
                        vins.getPrix_Achat(),
                        vins.getPrix_Vente(),
                        vins.getDate(),
                        vins.getMillesime(),
                       
                });
            });
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        tab_vin.setModel(model);
    }


    @SuppressWarnings("unchecked")
    
    
    private void Fillcombo() 
        {
            try
                {
                    List<Carte_vin> vins = Carte_vin.getNames_Viticulteur();
                    
                    vins.forEach(vin -> { 
                        String nom_vit = vin.getNom() + " " + vin.getPrenom();
                        viticulteur.addItem(nom_vit); 
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

           List<Carte_vin> vin = Carte_vin.getAllOrderById();

            vin.forEach(vins -> {
                model.addRow(new Object[] {
                        vins.getId_Cart_Vin(),
                        vins.getNom_Boisson(),
                        vins.getPrix_Achat(),
                        vins.getPrix_Vente(),
                        vins.getDate(),
                        vins.getMillesime(),
                       
                });
            });

                nom_vin.setText("");
                viticulteur.setSelectedItem("");
                prix_vente.setText("");
                prix_achat.setText("");
                date_achat.setDate(null);
                millesime.setDate(null);
           

    } catch(HeadlessException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_vin = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        rech = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        prix_vente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nom_vin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        supprimer = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        viticulteur = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        date_achat = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        millesime = new com.toedter.calendar.JDateChooser();
        prix_achat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 255, 255), null, new java.awt.Color(102, 255, 255)));

        tab_vin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19), new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19)));
        tab_vin.setModel(new javax.swing.table.DefaultTableModel(
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
        tab_vin.setSelectionBackground(new java.awt.Color(225, 243, 255));
        tab_vin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_vinMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_vin);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 650, 130));

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
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 130, 30));

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
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 130, 30));

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
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 130, 30));

        rech.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rech.setForeground(new java.awt.Color(51, 0, 102));
        rech.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19), new java.awt.Color(255, 102, 102), new java.awt.Color(127, 19, 19)));
        rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechActionPerformed(evt);
            }
        });
        jPanel1.add(rech, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 470, 30));

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
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 170, 30));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 640, 520, 30));

        prix_vente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prix_vente.setForeground(new java.awt.Color(127, 19, 19));
        prix_vente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(127, 19, 19), new java.awt.Color(127, 19, 19), null));
        prix_vente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prix_venteActionPerformed(evt);
            }
        });
        jPanel1.add(prix_vente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 520, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 19, 19));
        jLabel2.setText("Choisir viticulteur");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 130, 30));

        nom_vin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom_vin.setForeground(new java.awt.Color(127, 19, 19));
        nom_vin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(127, 19, 19), new java.awt.Color(127, 19, 19), null));
        nom_vin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_vinActionPerformed(evt);
            }
        });
        jPanel1.add(nom_vin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 520, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 19, 19));
        jLabel3.setText("Date achat");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 240, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 19, 19));
        jLabel4.setText("Nom vin");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 120, 30));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, 30));

        jPanel1.add(viticulteur, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 520, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 19, 19));
        jLabel5.setText("Prix achat");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 240, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(127, 19, 19));
        jLabel6.setText("Prix vente");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 240, 30));

        date_achat.setForeground(new java.awt.Color(127, 19, 19));
        jPanel1.add(date_achat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 520, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(127, 19, 19));
        jLabel7.setText("Millesime");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 240, 30));

        millesime.setForeground(new java.awt.Color(127, 19, 19));
        jPanel1.add(millesime, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, 520, 30));

        prix_achat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prix_achat.setForeground(new java.awt.Color(127, 19, 19));
        prix_achat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(127, 19, 19), new java.awt.Color(127, 19, 19), null));
        prix_achat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prix_achatActionPerformed(evt);
            }
        });
        jPanel1.add(prix_achat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 520, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 19, 19));
        jLabel1.setText("Vin");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_vinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_vinMouseClicked
//        int i;
//        i = tab_boisson.getSelectedRow();
//        deplace(i);
    }//GEN-LAST:event_tab_vinMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        affiche();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        try
//        {    if(supprimer.getText().length()==0)
//            {JOptionPane.showMessageDialog(null,"Veuillez rechercher l'element a modifier dans le tableau et presser sur la ligne correspondante dans le tableau");} else{
//
//                if(JOptionPane.showConfirmDialog(null,"Confirmer la modification", "Modification", JOptionPane.YES_NO_OPTION)== JOptionPane.OK_OPTION)
//            {
//                SimpleDateFormat dateFormat_1 = new SimpleDateFormat("yyyy-MM-dd");
//                String d_achat = dateFormat_1.format(date_achat.getDate());
//                System.out.println(d_achat);
//                
//                SimpleDateFormat dateFormat_2 = new SimpleDateFormat("yyyy-MM-dd");
//                String millesim = dateFormat_2.format(millesime.getDate());
//                System.out.println(millesim);
//                                              
//                String nom_boisson= nom_vin.getText();
//                double pri_achat= Double.parseDouble(prix_achat.getText());
//                double pri_vent= Double.parseDouble(prix_vente.getText());
//                
//                String txt= viticulteur.getSelectedItem().toString();
//                int index=txt.indexOf(" ");                                         //bout sa yo ou a deside si w toujou bzw yo
//                String nom= txt.substring(0,index);       
//                String prenom= txt.substring(index+1);   
//                long id_vit = Carte_vin.getId_particulier(nom, prenom);
//                
//                long id_fam_boisson =GESTION_BOISSON.id_fam_boiss;
//                System.out.println(id_fam_boisson);
//                long id_boisson=Boisson.insert(id_fam_boisson,nom_boisson,pri_vent); 
//                
//                
//                int res = Boisson.update(Long.parseLong(supprimer.getText()), id_boisson, id_vit, pri_achat, pri_vent,millesim );
//
//                    affiche();
//                }
//            } }
//            catch(HeadlessException | NumberFormatException | SQLException  e)
//            {
//                JOptionPane.showMessageDialog(null,"erreur de modification" +e.getMessage());
//                System.err.println(e);
//            }
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

                    Carte_vin.delete(Long.parseLong(supprimer.getText()));
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
//        try
//        {
//            model.setRowCount(0);
//            if(rech.getText().length()!=0)
//            {
//                {
//                    List<Boisson> boissons = Boisson.search_boisson(rech.getText());
//
//                    boissons.forEach(Boissons -> {
//                        model.addRow(new Object[] {
//                            Boissons.getId_boisson(),
//                            Boissons.getNom_fam_boisson(),
//                            Boissons.getDesignation(),
//                            Boissons.getPrix(),
//                        });
//                    });
//                }
//
//                if(model.getRowCount()==0)
//                {
//                    JOptionPane.showMessageDialog(null, "Il y a aucun boisson correspondant dans le tableau ");
//                }
//
//                else
//                {
//                    int i=0;
//                    deplace(i);
//                }
//
//            }
//
//            else
//            {
//                JOptionPane.showMessageDialog(null,"Veuiller remplir le champs a cote du bouton rechercher avec le nom de l'article que vous voulez rechercher SVP!!!");
//                affiche();
//            }
//
//        }
//        catch(SQLException | HeadlessException e)
//        {
//            System.err.println(e);
//            JOptionPane.showMessageDialog(null,e.getMessage());
//        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
            if(nom_vin.getText().length()==0  && prix_achat.getText().length()==0 
               && prix_vente.getText().length()==0 && "".equals(date_achat.getDate().toString())
                && "".equals(millesime.getDate().toString()))
            {
                JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs SVP!");
            }

            else
            {
                SimpleDateFormat dateFormat_1 = new SimpleDateFormat("yyyy-MM-dd");
                String d_achat = dateFormat_1.format(date_achat.getDate());
                System.out.println(d_achat);
                
                SimpleDateFormat dateFormat_2 = new SimpleDateFormat("yyyy-MM-dd");
                String millesim = dateFormat_2.format(millesime.getDate());
                System.out.println(millesim);
                                              
                String nom_boisson= nom_vin.getText();
                double pri_achat= Double.parseDouble(prix_achat.getText());
                double pri_vent= Double.parseDouble(prix_vente.getText());
                
                String txt= viticulteur.getSelectedItem().toString();
                int index=txt.indexOf(" ");                                         //bout sa yo ou a deside si w toujou bzw yo
                String nom= txt.substring(0,index);       
                String prenom= txt.substring(index+1);   
                System.out.println(nom);
                System.out.println(prenom);
                long id_vit = Carte_vin.getId_particulier(nom, prenom);
                System.out.println(id_vit);

                System.out.println("weee wiiiiiiiiiii");
                long id_fam_boisson =GESTION_BOISSON.id_fam_boiss;
                System.out.println(id_fam_boisson);
                long id_boisson=Boisson.insert(id_fam_boisson,nom_boisson,pri_vent); 
                System.out.println("weee");
                System.out.println(id_boisson);
                
                long id_cart_vin = Carte_vin.insert_vin(id_boisson, id_vit, pri_achat, pri_vent, d_achat, millesim);

                JOptionPane.showMessageDialog(null,"Ce vin a bien ete ajoute");

                nom_vin.setText("");
                viticulteur.setSelectedItem("");
                prix_vente.setText("");
                prix_achat.setText("");
                date_achat.setDate(null);
                millesime.setDate(null);
                affiche();
            }

        }

        catch(SQLException | HeadlessException e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void prix_venteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prix_venteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prix_venteActionPerformed

    private void nom_vinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_vinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_vinActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supprimerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        GESTION_BOISSON Info;
        Info = new GESTION_BOISSON();
        Info.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void prix_achatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prix_achatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prix_achatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GESTION_CATEGORIE_VIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GESTION_CATEGORIE_VIN().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date_achat;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser millesime;
    private javax.swing.JTextField nom_vin;
    private javax.swing.JTextField prix_achat;
    private javax.swing.JTextField prix_vente;
    private javax.swing.JTextField rech;
    private javax.swing.JTextField supprimer;
    private javax.swing.JTable tab_vin;
    private javax.swing.JComboBox<String> viticulteur;
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
