package metier;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class AgendaPage extends javax.swing.JFrame {
	Connection conn = Utilitaire.getConnection();

    /**
     * Creates new form AgendaPage
     */
	private int iduser;
	private String username;
	private String NomCourt;
	private Info info;
	
    public AgendaPage(Info info) {
		this.info = info;
        
        java.awt.GridBagConstraints gridBagConstraints;

        body = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        P4P = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        contenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AgendaTable = new javax.swing.JTable();
        ressources = new javax.swing.JButton();
        about = new javax.swing.JButton();
        Agenda = new javax.swing.JButton();
        membres = new javax.swing.JButton();
        adhesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        

        header.setBackground(new java.awt.Color(153, 0, 204));
        header.setLayout(new java.awt.GridBagLayout());

        P4P.setBackground(new java.awt.Color(255, 255, 255));
        P4P.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
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
        Username.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/icons8-user-30.png"))); // NOI18N
        Username.setText(info.getUsername());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 596, 0, 12);
        header.add(Username, gridBagConstraints);

        body.add(header, java.awt.BorderLayout.PAGE_START);

        contenu.setBackground(new java.awt.Color(255, 255, 255));
        contenu.setLayout(new java.awt.GridBagLayout());

        AgendaTable.setAutoCreateRowSorter(true);
        AgendaTable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AgendaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "titre_evenement", "description_evenement", "date", "heure"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        AgendaTable.setToolTipText("");
        AgendaTable.setColumnSelectionAllowed(true);
        AgendaTable.setEnabled(false);
        AgendaTable.setGridColor(new java.awt.Color(204, 204, 204));
        AgendaTable.setRowHeight(40);
        AgendaTable.setSelectionBackground(new java.awt.Color(153, 204, 0));
        AgendaTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        AgendaTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        AgendaTable.setShowGrid(false);
        AgendaTable.setShowHorizontalLines(true);
        AgendaTable.setShowVerticalLines(true);
        jScrollPane1.setViewportView(AgendaTable);
        AgendaTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 824;
        gridBagConstraints.ipady = 380;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 0);
        contenu.add(jScrollPane1, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        contenu.add(about, gridBagConstraints);

        Agenda.setBackground(new java.awt.Color(153, 0, 204));
        Agenda.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Agenda.setForeground(new java.awt.Color(255, 255, 255));
        Agenda.setText("Agenda");
        Agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendaActionPerformed(evt);
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
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
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

        body.add(contenu, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void agendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaActionPerformed
        AgendaPage ag = new AgendaPage(info);
        ag.RemplirTable(info.getIdprojetAboutPage());
        ag.setVisible(true);
        ag.setSize(950, 550);
        this.setVisible(false);
    }
    //ResultSet rs;
    DefaultTableModel tableModel = new DefaultTableModel();
    public void RemplirTable(int idprojet) {

        try {

           PreparedStatement ps = conn.prepareStatement("SELECT date, heure, titre_evenement, description_evenement FROM evenement WHERE idProjet=?");
           ps.setInt(1, idprojet);
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
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agenda;
    private javax.swing.JTable AgendaTable;
    private javax.swing.JLabel P4P;
    private javax.swing.JLabel Username;
    private javax.swing.JButton about;
    private javax.swing.JButton adhesion;
    private javax.swing.JPanel body;
    private javax.swing.JPanel contenu;
    private javax.swing.JPanel header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton membres;
    private javax.swing.JButton ressources;
    // End of variables declaration//GEN-END:variables
}
