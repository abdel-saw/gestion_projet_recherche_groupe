package metier;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.SwingUtilities;

public class AboutPage extends javax.swing.JFrame {

   Connection conn = Utilitaire.getConnection();

     private javax.swing.JButton Agenda;
     private javax.swing.JLabel DateDeCreation;
     private javax.swing.JLabel DescriptionDuProjet;
     private javax.swing.JPanel Menu;
     private javax.swing.JLabel NomLongProjet;
     private javax.swing.JLabel P4P1;
     private javax.swing.JLabel TitreDateDeCreation;
     private javax.swing.JButton se_deconnecter;
     private javax.swing.JLabel TitreDescriptionDuProjet;
     private javax.swing.JLabel TitreNomLongProjet;
     private javax.swing.JLabel Username;
     private javax.swing.JButton about;
     private javax.swing.JButton adhesion;
     private javax.swing.JButton agenda;
     private javax.swing.JPanel body;
     private javax.swing.JPanel contenu;
     private javax.swing.JPanel header;
     private javax.swing.JButton invitation;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JButton membres;
     private javax.swing.JButton menu;
     private javax.swing.JButton messages;
     private javax.swing.JButton projects;
     private javax.swing.JButton requests;
     private javax.swing.JButton ressources;
    
     static int idprojet;
     static String nomCourt;
     static String username ;
     static String date_var ;
     static String descript ;
     static String nom_long_var ;
     private int iduser;
     private Info info;
     
     
     

    public AboutPage(Info info) {
        //initComponents(info.getNom_long(), info.getDescription(), info.getDate(), info.getUsername());
        this.info = info;

        java.awt.GridBagConstraints gridBagConstraints;

        body = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        menu = new javax.swing.JButton();
        requests = new javax.swing.JButton();
        agenda = new javax.swing.JButton();
        messages = new javax.swing.JButton();
        projects = new javax.swing.JButton();
        invitation = new javax.swing.JButton();
        se_deconnecter = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        Username = new javax.swing.JLabel();
        P4P1 = new javax.swing.JLabel();
        contenu = new javax.swing.JPanel();
        membres = new javax.swing.JButton();
        Agenda = new javax.swing.JButton();
        ressources = new javax.swing.JButton();
        about = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TitreDateDeCreation = new javax.swing.JLabel();
        TitreNomLongProjet = new javax.swing.JLabel();
        DateDeCreation = new javax.swing.JLabel();
        DescriptionDuProjet = new javax.swing.JLabel();
        TitreDescriptionDuProjet = new javax.swing.JLabel();
        NomLongProjet = new javax.swing.JLabel();
        adhesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());
//////////////////////////////////////////////////////////////////
        header.setBackground(new java.awt.Color(153, 0, 204));
        header.setLayout(new java.awt.GridBagLayout());

        Username.setBackground(new java.awt.Color(255, 255, 255));
        Username.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/icons8-user-30.png"))); // NOI18N
        Username.setText(info.getUsername());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 556, 0, 12);
        header.add(Username, gridBagConstraints);

        P4P1.setBackground(new java.awt.Color(255, 255, 255));
        P4P1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        P4P1.setForeground(new java.awt.Color(255, 255, 255));
        P4P1.setText("P4P");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 90, 0, 0);
        header.add(P4P1, gridBagConstraints);

        body.add(header, java.awt.BorderLayout.PAGE_START);

        contenu.setBackground(new java.awt.Color(255, 255, 255));
        contenu.setLayout(new java.awt.GridBagLayout());

        membres.setBackground(new java.awt.Color(153, 0, 204));
        membres.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
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
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        contenu.add(membres, gridBagConstraints);

        Agenda.setBackground(new java.awt.Color(153, 0, 204));
        Agenda.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
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
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        contenu.add(Agenda, gridBagConstraints);

        ressources.setBackground(new java.awt.Color(153, 0, 204));
        ressources.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
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
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        contenu.add(ressources, gridBagConstraints);

        about.setBackground(new java.awt.Color(153, 0, 204));
        about.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
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
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        contenu.add(about, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        TitreDateDeCreation.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TitreDateDeCreation.setForeground(new java.awt.Color(51, 51, 255));
        TitreDateDeCreation.setText("Date de création :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 50, 0);
        jPanel1.add(TitreDateDeCreation, gridBagConstraints);

        TitreNomLongProjet.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TitreNomLongProjet.setForeground(new java.awt.Color(51, 51, 255));
        TitreNomLongProjet.setText("Nom long du projet :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jPanel1.add(TitreNomLongProjet, gridBagConstraints);

        DateDeCreation.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DateDeCreation.setText(info.getDate());
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 146;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        jPanel1.add(DateDeCreation, gridBagConstraints);

        DescriptionDuProjet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DescriptionDuProjet.setText(info.getDescription());
        DescriptionDuProjet.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 337;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 20, 0, 0);
        jPanel1.add(DescriptionDuProjet, gridBagConstraints);

        TitreDescriptionDuProjet.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TitreDescriptionDuProjet.setForeground(new java.awt.Color(51, 51, 255));
        TitreDescriptionDuProjet.setText("Description du projet :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jPanel1.add(TitreDescriptionDuProjet, gridBagConstraints);

        NomLongProjet.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NomLongProjet.setText(info.getNom_long());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 456;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 40);
        jPanel1.add(NomLongProjet, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 30, 15, 0);
        contenu.add(jPanel1, gridBagConstraints);
        
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
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        ag.setSize(950, 550);
        this.setVisible(false);
    }//GEN-LAST:event_AgendaActionPerformed

   

    
   
}