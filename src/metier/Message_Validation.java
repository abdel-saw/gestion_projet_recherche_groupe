package metier;



public class Message_Validation extends javax.swing.JFrame {

private javax.swing.JLabel Ajouter_succes;
 private javax.swing.JLabel FormulaireAjout;
 private javax.swing.JPanel Menu;
 private javax.swing.JLabel P4P;
 private javax.swing.JLabel Username;
 private javax.swing.JButton Valider;
 private javax.swing.JButton agenda;
 private javax.swing.JPanel background_formulaire;
 private javax.swing.JPanel barre_FormulaireCreation;
 private javax.swing.JPanel body;
 private javax.swing.JTextField champNom_court;
 private javax.swing.JTextField champNom_long;
 private javax.swing.JTextField champ_theme;
 private javax.swing.JPanel contenu;
 private javax.swing.JPanel header;
 private javax.swing.JButton invitation;
 private javax.swing.JButton menu;
 private javax.swing.JButton messages;
 private javax.swing.JLabel nom_court;
 private javax.swing.JLabel nom_long;
 private javax.swing.JButton projects;
 private javax.swing.JButton requests;
 private javax.swing.JButton se_deconnecter;
 private javax.swing.JLabel theme;

 static String texte ;

    public Message_Validation(String string) {
        texte = string;
        initComponents();
    }

    
    
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        body = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        messages = new javax.swing.JButton();
        requests = new javax.swing.JButton();
        menu = new javax.swing.JButton();
        agenda = new javax.swing.JButton();
        projects = new javax.swing.JButton();
        invitation = new javax.swing.JButton();
        se_deconnecter = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        P4P = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        contenu = new javax.swing.JPanel();
        barre_FormulaireCreation = new javax.swing.JPanel();
        FormulaireAjout = new javax.swing.JLabel();
        background_formulaire = new javax.swing.JPanel();
        nom_court = new javax.swing.JLabel();
        nom_long = new javax.swing.JLabel();
        theme = new javax.swing.JLabel();
        champNom_court = new javax.swing.JTextField();
        champNom_long = new javax.swing.JTextField();
        champ_theme = new javax.swing.JTextField();
        Valider = new javax.swing.JButton();
        Ajouter_succes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.GridBagLayout());

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 204), 1, true));
        Menu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Menu.setLayout(new java.awt.GridBagLayout());

        messages.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        messages.setForeground(new java.awt.Color(153, 0, 204));
        messages.setText("Messages");
        messages.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        messages.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messagesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 82;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        Menu.add(messages, gridBagConstraints);

        requests.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        requests.setForeground(new java.awt.Color(153, 0, 204));
        requests.setText("Requests");
        requests.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        requests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        requests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 86;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        Menu.add(requests, gridBagConstraints);

        menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menu.setForeground(new java.awt.Color(153, 0, 204));
        menu.setText("Menu");
        menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 109;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 2, 0, 0);
        Menu.add(menu, gridBagConstraints);

        agenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        agenda.setForeground(new java.awt.Color(153, 0, 204));
        agenda.setText("Agenda");
        agenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        agenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 95;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        Menu.add(agenda, gridBagConstraints);

        projects.setBackground(new java.awt.Color(153, 0, 204));
        projects.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        projects.setForeground(new java.awt.Color(255, 255, 255));
        projects.setText("Projects");
        projects.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        projects.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        projects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        Menu.add(projects, gridBagConstraints);

        invitation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        invitation.setForeground(new java.awt.Color(153, 0, 204));
        invitation.setText("Invitation");
        invitation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        invitation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invitation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invitationActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 82;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 1, 0, 0);
        Menu.add(invitation, gridBagConstraints);

        se_deconnecter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        se_deconnecter.setForeground(new java.awt.Color(153, 0, 204));
        se_deconnecter.setText("se_deconnecter");
        se_deconnecter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        se_deconnecter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        se_deconnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                se_deconnecterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 43;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 26, 0);
        Menu.add(se_deconnecter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        body.add(Menu, gridBagConstraints);

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
        Username.setText("Username_xxxx");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 576, 0, 2);
        header.add(Username, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 132;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        body.add(header, gridBagConstraints);

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
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        contenu.add(barre_FormulaireCreation, gridBagConstraints);

        background_formulaire.setBackground(new java.awt.Color(153, 0, 204));
        background_formulaire.setLayout(new java.awt.GridBagLayout());

        nom_court.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nom_court.setForeground(new java.awt.Color(255, 255, 255));
        nom_court.setText("Username");
        nom_court.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 0, 0);
        background_formulaire.add(nom_court, gridBagConstraints);

        nom_long.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nom_long.setForeground(new java.awt.Color(255, 255, 255));
        nom_long.setText("Nom");
        nom_long.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 58;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 40, 0, 0);
        background_formulaire.add(nom_long, gridBagConstraints);

        theme.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        theme.setForeground(new java.awt.Color(255, 255, 255));
        theme.setText("Prenom");
        theme.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 40, 0, 0);
        background_formulaire.add(theme, gridBagConstraints);

        champNom_court.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        champNom_court.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champNom_courtActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 326;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 100, 0, 330);
        background_formulaire.add(champNom_court, gridBagConstraints);

        champNom_long.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        champNom_long.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champNom_longActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 326;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 100, 0, 330);
        background_formulaire.add(champNom_long, gridBagConstraints);

        champ_theme.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        champ_theme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champ_themeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 326;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 100, 0, 330);
        background_formulaire.add(champ_theme, gridBagConstraints);

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
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 10, 0, 0);
        contenu.add(background_formulaire, gridBagConstraints);

        Ajouter_succes.setBackground(new java.awt.Color(255, 255, 255));
        Ajouter_succes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Ajouter_succes.setForeground(new java.awt.Color(204, 0, 0));
        Ajouter_succes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Ajouter_succes.setText(texte);
        Ajouter_succes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 135;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 210, 60, 0);
        contenu.add(Ajouter_succes, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        body.add(contenu, gridBagConstraints);

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
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void messagesActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void requestsActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void projectsActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void invitationActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void se_deconnecterActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void champNom_courtActionPerformed(java.awt.event.ActionEvent evt) {
        
    }


    private void champNom_longActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void champ_themeActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {
   
    }


   
    public void RemplirTexte(String s)
    {
        
    }

    public static void main(String args[]) {
       
                // new Message_Validation().setVisible(true);
            }

}
