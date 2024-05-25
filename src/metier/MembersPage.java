package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class MembersPage extends javax.swing.JFrame {

     Connection conn = Utilitaire.getConnection();

    private javax.swing.JButton Agenda;
    private javax.swing.JTable MembersTable;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel P4P;
    private javax.swing.JLabel Username;
    private javax.swing.JButton about;
    private javax.swing.JButton agenda;
    private javax.swing.JButton ajouter_administrateur;
    private javax.swing.JButton ajouter_membre_simple;
    private javax.swing.JPanel barreAjouterMembre;
    private javax.swing.JPanel body;
    private javax.swing.JPanel contenu;
    private javax.swing.JPanel header;
    private javax.swing.JButton adhesion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton membres;
    private javax.swing.JButton ressources;
    private Info info;

    
    public MembersPage(Info info) {
    	this.info = info;
    	
    	
        java.awt.GridBagConstraints gridBagConstraints;

        body = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        agenda = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        P4P = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        contenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MembersTable = new javax.swing.JTable();
        about = new javax.swing.JButton();
        ressources = new javax.swing.JButton();
        Agenda = new javax.swing.JButton();
        membres = new javax.swing.JButton();
        adhesion = new javax.swing.JButton();
        barreAjouterMembre = new javax.swing.JPanel();
        ajouter_administrateur = new javax.swing.JButton();
        ajouter_membre_simple = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        

        header.setBackground(new java.awt.Color(153, 0, 204));
        header.setLayout(new java.awt.GridBagLayout());

        P4P.setBackground(new java.awt.Color(255, 255, 255));
        P4P.setFont(new java.awt.Font("Segoe UI", 3, 24));    
        P4P.setForeground(new java.awt.Color(255, 255, 255));
        P4P.setText("P4P");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 90, 0, 0);
        header.add(P4P, gridBagConstraints);

        Username.setBackground(new java.awt.Color(255, 255, 255));
        Username.setFont(new java.awt.Font("Segoe UI", 1, 24));    
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/icons8-user-30.png")));    
        Username.setText(info.getUsername());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 566, 0, 12);
        header.add(Username, gridBagConstraints);

        body.add(header, java.awt.BorderLayout.PAGE_START);

        contenu.setBackground(new java.awt.Color(255, 255, 255));
        contenu.setLayout(new java.awt.GridBagLayout());

        MembersTable.setAutoCreateRowSorter(true);
        MembersTable.setFont(new java.awt.Font("Segoe UI", 1, 18));    
        MembersTable.setModel(tableModel);
        MembersTable.setToolTipText("");
        MembersTable.setColumnSelectionAllowed(true);
        MembersTable.setEnabled(false);
        MembersTable.setGridColor(new java.awt.Color(204, 204, 204));
        MembersTable.setRowHeight(40);
        MembersTable.setSelectionBackground(new java.awt.Color(153, 204, 0));
        MembersTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        MembersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        MembersTable.setShowHorizontalLines(true);
        MembersTable.setShowVerticalLines(true);
        jScrollPane1.setViewportView(MembersTable);
        MembersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1193;
        gridBagConstraints.ipady = 342;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 1);
        contenu.add(jScrollPane1, gridBagConstraints);

        about.setBackground(new java.awt.Color(153, 0, 204));
        about.setFont(new java.awt.Font("Segoe UI", 1, 24));    
        about.setForeground(new java.awt.Color(255, 255, 255));
        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        contenu.add(about, gridBagConstraints);

        ressources.setBackground(new java.awt.Color(153, 0, 204));
        ressources.setFont(new java.awt.Font("Segoe UI", 1, 24));    
        ressources.setForeground(new java.awt.Color(255, 255, 255));
        ressources.setText("Ressources");
        ressources.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ressourcesActionPerformed(evt);
            }
        });
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 100, 0, 0);
        contenu.add(ressources, gridBagConstraints);

        Agenda.setBackground(new java.awt.Color(153, 0, 204));
        Agenda.setFont(new java.awt.Font("Segoe UI", 1, 24));    
        Agenda.setForeground(new java.awt.Color(255, 255, 255));
        Agenda.setText("Agenda");
        Agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 110, 0, 0);
        contenu.add(Agenda, gridBagConstraints);

        membres.setBackground(new java.awt.Color(153, 0, 204));
        membres.setFont(new java.awt.Font("Segoe UI", 1, 24));    
        membres.setForeground(new java.awt.Color(255, 255, 255));
        membres.setText("Membres");
        membres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membresActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 0);
        contenu.add(membres, gridBagConstraints);
        
        
        adhesion.setBackground(new java.awt.Color(153, 0, 204));
        adhesion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        adhesion.setForeground(new java.awt.Color(255, 255, 255));
        adhesion.setText("Adhésion");
        adhesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adhesionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        contenu.add(adhesion, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 100, 0, 0);

        barreAjouterMembre.setBackground(new java.awt.Color(153, 0, 204));
        barreAjouterMembre.setLayout(new java.awt.GridBagLayout());

        ajouter_administrateur.setFont(new java.awt.Font("Segoe UI", 1, 14));    
        ajouter_administrateur.setForeground(new java.awt.Color(153, 0, 204));
        ajouter_administrateur.setText("Invitation pour administrateur");
        ajouter_administrateur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        ajouter_administrateur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ajouter_administrateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter_administrateurActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 340, 20, 259);
        barreAjouterMembre.add(ajouter_administrateur, gridBagConstraints);

        ajouter_membre_simple.setFont(new java.awt.Font("Segoe UI", 1, 14));    
        ajouter_membre_simple.setForeground(new java.awt.Color(153, 0, 204));
        ajouter_membre_simple.setText("Invitation pour membre simple");
        ajouter_membre_simple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        ajouter_membre_simple.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ajouter_membre_simple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter_membre_simpleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 230, 20, 0);
        barreAjouterMembre.add(ajouter_membre_simple, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 33, 1);
        contenu.add(barreAjouterMembre, gridBagConstraints);

        body.add(contenu, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );

        pack();
    }

    private void membresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membresActionPerformed
        MembersPage mp = new MembersPage(info);
        mp.RemplirTable(info.getNom_court());
        mp.setVisible(true);
        mp.setSize(1900, 1000);
        mp.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_membresActionPerformed

    private void ressourcesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ressourcesActionPerformed
    	RessourcesPage rsp = new RessourcesPage(info);
        rsp.setVisible(true);
        rsp.setLocationRelativeTo(null);
        rsp.setSize(950, 550);
        this.setVisible(false);
    }//GEN-LAST:event_ressourcesActionPerformed

   

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
    	AboutPage rsp = new AboutPage(info);
        rsp.setVisible(true);
        rsp.setLocationRelativeTo(null);
        rsp.setSize(950, 550);
        this.setVisible(false);
    }//GEN-LAST:event_aboutActionPerformed

    

    private void adhesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adhesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adhesionActionPerformed

    private void AgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaActionPerformed
        AgendaPage ag = new AgendaPage(info);
        ag.RemplirTable(info.getIdprojetAboutPage());
        ag.setVisible(true);
        ag.setLocationRelativeTo(null);
        ag.setSize(950, 550);
        this.setVisible(false);
    }



    static String NomCourt;

    private void ajouter_administrateurActionPerformed(java.awt.event.ActionEvent evt) {
        AjoutAdministrateurPage admp = new AjoutAdministrateurPage(info.getUsername(), info.getNom_court());
        admp.setVisible(true);
        admp.setSize(950, 600);
        admp.setLocationRelativeTo(null);
    }
    

    private void ajouter_membre_simpleActionPerformed(java.awt.event.ActionEvent evt) {
        AjoutMembreSimplePage amsp = new AjoutMembreSimplePage(info.getIduser(), info.getUsername(), info.getNom_court());
        amsp.setVisible(true);
        amsp.setSize(950, 600);
        amsp.setLocationRelativeTo(null);
    }

    
    DefaultTableModel tableModel = new DefaultTableModel();
    public void RemplirTable(String nomCourt) {

        info.setNom_court(nomCourt);


        try {

           PreparedStatement ps = conn.prepareStatement("SELECT nom, prenom, email FROM utilisateur WHERE idUtilisateur IN (SELECT IdUtilisateur FROM utilisateur_groupe WHERE IdGroupe IN (SELECT IdGroupe FROM groupe WHERE nom_groupe LIKE ?))");
           ps.setString(1, nomCourt+"%");
           ResultSet rs = ps.executeQuery();

           // Récupérez les métadonnées du ResultSet (noms de colonnes)
           int columnCount = rs.getMetaData().getColumnCount();
           for (int i = 1; i <= columnCount; i++) {
               tableModel.addColumn(rs.getMetaData().getColumnName(i));
           }

           // Ajoutez les données du ResultSet au modèle de table
           while (rs.next()) {
               Object[] rowData = new Object[columnCount];
               for (int i = 1; i <= columnCount; i++) {
                   rowData[i - 1] = rs.getObject(i);
               }
               tableModel.addRow(rowData);
           }

           }


        catch (Exception e) {
           System.out.println("Exception :" + e);
       }
       
      
   }

    
    public static void main(String args[]) {
        

            }

}
