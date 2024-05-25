package metier;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AjoutAdministrateurPage extends javax.swing.JFrame {

    Connection conn = Utilitaire.getConnection();

    private javax.swing.JLabel FormulaireAjout;
    private javax.swing.JLabel P4P;
    private javax.swing.JLabel Username;
    private javax.swing.JButton Valider;
    private javax.swing.JPanel background_formulaire;
    private javax.swing.JPanel barre_FormulaireCreation;
    private javax.swing.JPanel body;
    private javax.swing.JTextField Champ_username;
    private javax.swing.JTextField champ_nom;
    private javax.swing.JTextField champ_prenom;
    private javax.swing.JPanel contenu;
    private javax.swing.JPanel header;
    private javax.swing.JLabel username;
    private javax.swing.JLabel nom;
    private javax.swing.JLabel prenom;

    static String NomCourt;
    private String usrname;
    
    public AjoutAdministrateurPage(String usrname, String nomCourt) {
        NomCourt = nomCourt;
        this.usrname = usrname;
        
        java.awt.GridBagConstraints gridBagConstraints;

        body = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        P4P = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        contenu = new javax.swing.JPanel();
        barre_FormulaireCreation = new javax.swing.JPanel();
        FormulaireAjout = new javax.swing.JLabel();
        background_formulaire = new javax.swing.JPanel();
        username = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        prenom = new javax.swing.JLabel();
        Champ_username = new javax.swing.JTextField();
        champ_nom = new javax.swing.JTextField();
        champ_prenom = new javax.swing.JTextField();
        Valider = new javax.swing.JButton();

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
        Username.setText(usrname);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 576, 0, 2);
        header.add(Username, gridBagConstraints);

        body.add(header, java.awt.BorderLayout.PAGE_START);

        contenu.setBackground(new java.awt.Color(255, 255, 255));
        contenu.setLayout(new java.awt.GridBagLayout());

        barre_FormulaireCreation.setBackground(new java.awt.Color(102, 0, 204));
        barre_FormulaireCreation.setLayout(new java.awt.GridBagLayout());

        FormulaireAjout.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        FormulaireAjout.setForeground(new java.awt.Color(255, 255, 255));
        FormulaireAjout.setText("FORMULAIRE D'AJOUT D'UN NOUVEAU MEMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 75;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 160, 27, 180);
        barre_FormulaireCreation.add(FormulaireAjout, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        contenu.add(barre_FormulaireCreation, gridBagConstraints);

        background_formulaire.setBackground(new java.awt.Color(153, 0, 204));
        background_formulaire.setLayout(new java.awt.GridBagLayout());

        username.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Username");
        username.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 0, 0);
        background_formulaire.add(username, gridBagConstraints);

        nom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nom.setForeground(new java.awt.Color(255, 255, 255));
        nom.setText("Nom");
        nom.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 58;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 40, 0, 0);
        background_formulaire.add(nom, gridBagConstraints);

        prenom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        prenom.setForeground(new java.awt.Color(255, 255, 255));
        prenom.setText("Prenom");
        prenom.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 40, 0, 0);
        background_formulaire.add(prenom, gridBagConstraints);

        Champ_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 326;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 100, 0, 330);
        background_formulaire.add(Champ_username, gridBagConstraints);

        champ_nom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 326;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 100, 0, 330);
        background_formulaire.add(champ_nom, gridBagConstraints);

        champ_prenom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 326;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 100, 0, 330);
        background_formulaire.add(champ_prenom, gridBagConstraints);

        Valider.setBackground(new java.awt.Color(102, 0, 204));
        Valider.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Valider.setForeground(new java.awt.Color(255, 255, 255));
        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 240, 20, 0);
        background_formulaire.add(Valider, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 10, 86, 0);
        contenu.add(background_formulaire, gridBagConstraints);

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }

    
    int cp = 0;
    int cp1 = 0;
    Object id1;
    Object id2;
    Object id3;
    ResultSet rs;
    ResultSet rs1;
    ResultSet rs2;
    DefaultTableModel tableModel = new DefaultTableModel();
    DefaultTableModel tableMode2 = new DefaultTableModel();
    DefaultTableModel tableMode3 = new DefaultTableModel();
    DefaultTableModel tableMode4 = new DefaultTableModel();
    ResultSet rs3;
    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {
        try {

           PreparedStatement ps = conn.prepareStatement("SELECT username, nom, prenom FROM utilisateur WHERE idUtilisateur IN (SELECT IdUtilisateur FROM utilisateur_groupe WHERE IdGroupe IN (SELECT IdGroupe FROM groupe WHERE nom_groupe LIKE ?))");
           ps.setString(1, NomCourt+"-adm");
           rs = ps.executeQuery();

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

                PreparedStatement ps3 = conn.prepareStatement("SELECT IdGroupe FROM groupe WHERE nom_groupe LIKE ?");
                 ps3.setString(1, NomCourt+"-adm");
                 rs2 = ps3.executeQuery();

                 // Récupérez les métadonnées du ResultSet (noms de colonnes)
           int col = rs2.getMetaData().getColumnCount();
           for (int i = 1; i <= col; i++) {
               tableMode3.addColumn(rs2.getMetaData().getColumnName(i));
           }



           // Ajoutez les données du ResultSet au modèle de table
             while (rs2.next()) {
               Object[] rowData = new Object[col];
               for (int i = 1; i <= col; i++) {
                   rowData[i - 1] = rs2.getObject(i);
               }
               tableMode3.addRow(rowData);
                }

                id2 = tableMode3.getValueAt(0,0);


            
                for (int c = 0; c < tableModel.getRowCount(); c++) {

                    if ((Champ_username.getText().equals(tableModel.getValueAt(c, 0))) && (champ_nom.getText().equals(tableModel.getValueAt(c, 1))) && (champ_prenom.getText().equals(tableModel.getValueAt(c, 2)))) {
                        cp++;
                        break;
                    }
                }
                if(cp == 1)
                {
                    JOptionPane.showMessageDialog(null, "L'utilisateur est déjà un administrateur simple du projet!!", "Incorrect Information", JOptionPane.ERROR_MESSAGE);

                }
                else{
                    
                    PreparedStatement ps1 = conn.prepareStatement("SELECT IdUtilisateur, username, nom, prenom FROM utilisateur");
                    rs1 = ps1.executeQuery();
         
                    // Récupérez les métadonnées du ResultSet (noms de colonnes)
                    int column = rs1.getMetaData().getColumnCount();
                    for (int j = 1; j <= column; j++) {
                        tableMode2.addColumn(rs1.getMetaData().getColumnName(j));
                    }
         
                    // Ajoutez les données du ResultSet au modèle de table
                      while (rs1.next()) {
                        Object[] rowData1 = new Object[column];
                        for (int K = 1; K <= column; K++) {
                            rowData1[K - 1] = rs1.getObject(K);
                        }
                        tableMode2.addRow(rowData1);
                         }
                         for (int c = 0; c < tableMode2.getRowCount(); c++) {

                            if ((Champ_username.getText().equals(tableMode2.getValueAt(c, 1))) && (champ_nom.getText().equals(tableMode2.getValueAt(c, 2))) && (champ_prenom.getText().equals(tableMode2.getValueAt(c, 3)))) {
                                cp1++;
                                id1 = tableMode2.getValueAt(c, 0);
                                break;
                            }
                        }
                        if(cp1 == 1)
                        {
                            System.out.println("jeee");
                            PreparedStatement ps6 = conn.prepareStatement("SELECT IdProjet FROM projet WHERE nom_court = ?");
                            ps6.setString(1, NomCourt);
                            rs3 = ps6.executeQuery();
                            // Récupérez les métadonnées du ResultSet (noms de colonnes)
                                 int co = rs3.getMetaData().getColumnCount();
                                  for (int j = 1; j <= co; j++) {
                                tableMode4.addColumn(rs3.getMetaData().getColumnName(j));
                                     }
         
                            // Ajoutez les données du ResultSet au modèle de table
                                 while (rs3.next()) {
                                    Object[] rowData1 = new Object[co];
                                         for (int K = 1; K <= co; K++) {
                                         rowData1[K - 1] = rs3.getObject(K);
                                                 }
                                        tableMode4.addRow(rowData1);
                                     }
                            id3 = tableMode4.getValueAt(0, 0);

                            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO invitation_demande(host, user, IdGroupe, IdProjet, nom_Projet, date, etat, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                            ps2.setString(1, "ff");
                            ps2.setString(2, Champ_username.getText());
                            ps2.setObject(3, id2);
                            ps2.setObject(4, id3);
                            ps2.setString(5, NomCourt+"-adm");
                            ps.setDate(6, Date.valueOf(LocalDate.now()));
                            ps2.setString(7, "Pending");
                            ps2.setString(8, "invitation");
                            ps2.executeUpdate();
                            
                            JOptionPane.showMessageDialog(null, "Invitation envoyée avec succès!!", "Success", JOptionPane.INFORMATION_MESSAGE);

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Cet utilisateur n'a pas un compte sur la plateforme!!", "erreur", JOptionPane.ERROR_MESSAGE);

                        }
                }
            }
            catch (Exception e) {
           System.out.println("Exception :" + e);
             }
    }

    public static void main(String args[]) {
        
                //new AjoutMembrePage().setVisible(true);
            }
    
}
