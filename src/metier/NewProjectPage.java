package metier;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.sql.*;

import javax.swing.JOptionPane;

/**
 *
 * @author PC MAROC
 */
public class NewProjectPage extends javax.swing.JFrame {

    private javax.swing.JLabel FormulaireCreation;
    private javax.swing.JLabel P4P;
    private javax.swing.JCheckBox Prive;
    private javax.swing.JCheckBox Public;
    private javax.swing.JLabel Username;
    private javax.swing.JPanel background_formulaire;
    private javax.swing.JPanel barre_FormulaireCreation;
    private javax.swing.JPanel body;
    private javax.swing.JTextArea champDescription;
    private javax.swing.JTextField champNom_court;
    private javax.swing.JTextField champNom_long;
    private javax.swing.JTextField champ_theme;
    private javax.swing.JTextField champ_type;
    private javax.swing.JPanel contenu;
    private javax.swing.JLabel description;
    private javax.swing.JButton envoyer;
    private javax.swing.JPanel header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nom_court;
    private javax.swing.JLabel nom_long;
    private javax.swing.JLabel public_prive;
    private javax.swing.JLabel theme;
    private javax.swing.JLabel type;
    Connection conn = Utilitaire.getConnection();
    private int iduser;
    private String usrname;
   
    
    public NewProjectPage(int iduser, String usrname) {
    	this.iduser= iduser;
    	this.usrname = usrname;
        
        java.awt.GridBagConstraints gridBagConstraints;

        body = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        P4P = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        contenu = new javax.swing.JPanel();
        barre_FormulaireCreation = new javax.swing.JPanel();
        FormulaireCreation = new javax.swing.JLabel();
        background_formulaire = new javax.swing.JPanel();
        public_prive = new javax.swing.JLabel();
        nom_court = new javax.swing.JLabel();
        nom_long = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        theme = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        Prive = new javax.swing.JCheckBox();
        Public = new javax.swing.JCheckBox();
        champNom_court = new javax.swing.JTextField();
        champNom_long = new javax.swing.JTextField();
        champ_theme = new javax.swing.JTextField();
        champ_type = new javax.swing.JTextField();
        envoyer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        champDescription = new javax.swing.JTextArea();

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

        

        body.add(header, java.awt.BorderLayout.PAGE_START);

        contenu.setBackground(new java.awt.Color(255, 255, 255));
        contenu.setLayout(new java.awt.GridBagLayout());

        barre_FormulaireCreation.setBackground(new java.awt.Color(102, 0, 204));
        barre_FormulaireCreation.setLayout(new java.awt.GridBagLayout());

        FormulaireCreation.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        FormulaireCreation.setForeground(new java.awt.Color(255, 255, 255));
        FormulaireCreation.setText("FORMULAIRE DE CREATION D'UN NOUVEAU PROJET");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 110, 18, 100);
        barre_FormulaireCreation.add(FormulaireCreation, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        contenu.add(barre_FormulaireCreation, gridBagConstraints);

        background_formulaire.setBackground(new java.awt.Color(153, 0, 204));
        background_formulaire.setLayout(new java.awt.GridBagLayout());

        public_prive.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        public_prive.setForeground(new java.awt.Color(255, 255, 255));
        public_prive.setText("public ou privé");
        public_prive.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 40, 0, 0);
        background_formulaire.add(public_prive, gridBagConstraints);

        nom_court.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nom_court.setForeground(new java.awt.Color(255, 255, 255));
        nom_court.setText("Nom court");
        nom_court.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 0, 0);
        background_formulaire.add(nom_court, gridBagConstraints);

        nom_long.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nom_long.setForeground(new java.awt.Color(255, 255, 255));
        nom_long.setText("Nom long");
        nom_long.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 40, 0, 0);
        background_formulaire.add(nom_long, gridBagConstraints);

        description.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        description.setForeground(new java.awt.Color(255, 255, 255));
        description.setText("Description");
        description.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 40, 0, 0);
        background_formulaire.add(description, gridBagConstraints);

        theme.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        theme.setForeground(new java.awt.Color(255, 255, 255));
        theme.setText("Thème");
        theme.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 40, 0, 0);
        background_formulaire.add(theme, gridBagConstraints);

        type.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        type.setForeground(new java.awt.Color(255, 255, 255));
        type.setText("Type");
        type.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 40, 0, 0);
        background_formulaire.add(type, gridBagConstraints);

        Prive.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Prive.setForeground(new java.awt.Color(255, 255, 255));
        Prive.setText("Privé");
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 40, 0, 0);
        background_formulaire.add(Prive, gridBagConstraints);

        Public.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Public.setForeground(new java.awt.Color(255, 255, 255));
        Public.setText("Public");
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 60, 0, 0);
        background_formulaire.add(Public, gridBagConstraints);

        champNom_court.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 326;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 60, 0, 110);
        background_formulaire.add(champNom_court, gridBagConstraints);

        champNom_long.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 326;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 60, 0, 110);
        background_formulaire.add(champNom_long, gridBagConstraints);

        champ_theme.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 326;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 60, 0, 110);
        background_formulaire.add(champ_theme, gridBagConstraints);

        champ_type.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 326;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 60, 0, 110);
        background_formulaire.add(champ_type, gridBagConstraints);

        envoyer.setBackground(new java.awt.Color(102, 0, 204));
        envoyer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        envoyer.setForeground(new java.awt.Color(255, 255, 255));
        envoyer.setText("Envoyer");
        envoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                envoyerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 110, 10, 0);
        background_formulaire.add(envoyer, gridBagConstraints);

        champDescription.setColumns(20);
        champDescription.setLineWrap(true);
        champDescription.setRows(5);
        jScrollPane1.setViewportView(champDescription);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 374;
        gridBagConstraints.ipady = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(60, 60, 0, 110);
        background_formulaire.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 2, 0);
        contenu.add(background_formulaire, gridBagConstraints);

        body.add(contenu, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pack();
    }

    

    private void envoyerActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("your_database_url", "username", "password");

            // Disable auto-commit
            conn.setAutoCommit(false);

            // SQL query to insert a new demand
            String sql = "INSERT INTO demande (IdDemande, IdUtilisateur, username, nom_court_projet, nom_long_projet, description_projet, theme_projet, projet_is_public, etat, IdProjet, type, date_demande, IdGroupe) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'Pending', ?, 'creation', current_timestamp(), ?)";

            // Prepare statement
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setNull(1, java.sql.Types.INTEGER); // IdDemande
            pstmt.setNull(2, iduser); // IdUtilisateur
            pstmt.setString(3, usrname); // username
            pstmt.setString(4, champNom_court.getText()); // nom_court_projet
            pstmt.setString(5, champNom_long.getText()); // nom_long_projet
            pstmt.setString(6, champDescription.getText()); // description_projet
            pstmt.setString(7, champ_theme.getText()); // theme_projet
            pstmt.setBoolean(8, Public.isSelected()); // projet_is_public
            pstmt.setNull(9, java.sql.Types.INTEGER); // IdProjet
            pstmt.setNull(10, java.sql.Types.INTEGER); // IdGroupe

            // Execute update
            int rowsAffected = pstmt.executeUpdate();

            // Commit transaction
            conn.commit();

            // Check if insertion was successful
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Demande created successfully!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                // Rollback transaction in case of error
                conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                // Re-enable auto-commit
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


        public static void main(String args[]) {
      
                new NewProjectPage(9, "oubeza_idir").setVisible(true);
            }

}