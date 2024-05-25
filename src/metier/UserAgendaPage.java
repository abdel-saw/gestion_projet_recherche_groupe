package metier;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

public class UserAgendaPage extends javax.swing.JFrame {

   
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel P4P;
    private javax.swing.JTable UserAgendaTable;
    private javax.swing.JLabel Username;
    private javax.swing.JButton se_deconnecter;
    private javax.swing.JButton agenda;
    private javax.swing.JPanel body;
    private javax.swing.JPanel contenu;
    private javax.swing.JPanel header;
    private javax.swing.JButton invitation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menu;
    private javax.swing.JButton messages;
    private javax.swing.JButton projects;
    private javax.swing.JButton requests;
   static String user_name ;
   private int iduser;


    public UserAgendaPage(int iduser, String username) {
        
        java.awt.GridBagConstraints gridBagConstraints;
        user_name = username ;
        this.iduser = iduser;

        body = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        messages = new javax.swing.JButton();
        requests = new javax.swing.JButton();
        menu = new javax.swing.JButton();
        projects = new javax.swing.JButton();
        agenda = new javax.swing.JButton();
        se_deconnecter = new javax.swing.JButton();
        invitation = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        P4P = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        contenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserAgendaTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 204), 1, true));
        Menu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Menu.setLayout(new java.awt.GridBagLayout());

        messages.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        messages.setForeground(new java.awt.Color(153, 0, 204));
        messages.setBackground(Color.white);
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
        gridBagConstraints.ipadx = 82;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Menu.add(messages, gridBagConstraints);

        requests.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        requests.setForeground(new java.awt.Color(153, 0, 204));
        requests.setBackground(Color.white);
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
        gridBagConstraints.ipadx = 86;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Menu.add(requests, gridBagConstraints);

        menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menu.setForeground(new java.awt.Color(153, 0, 204));
        menu.setBackground(Color.white);
        menu.setText("Home ");
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
        gridBagConstraints.ipadx = 109;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        Menu.add(menu, gridBagConstraints);

        projects.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        projects.setForeground(new java.awt.Color(153, 0, 204));
        projects.setBackground(Color.white);
        projects.setText("Projects");
        projects.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        projects.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        projects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Menu.add(projects, gridBagConstraints);

        se_deconnecter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        se_deconnecter.setForeground(new java.awt.Color(153, 0, 204));
        se_deconnecter.setBackground(Color.white);
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
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 43;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(64, 0, 40, 0);
        Menu.add(se_deconnecter, gridBagConstraints);

        agenda.setBackground(new java.awt.Color(153, 0, 204));
        agenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        agenda.setForeground(new java.awt.Color(255, 255, 255));
        agenda.setText("Agenda");
        agenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        agenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 95;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Menu.add(agenda, gridBagConstraints);

        invitation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        invitation.setForeground(new java.awt.Color(153, 0, 204));
        invitation.setBackground(Color.white);
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
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 82;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 53, 0);
        Menu.add(invitation, gridBagConstraints);

        body.add(Menu, java.awt.BorderLayout.LINE_START);

        header.setBackground(new java.awt.Color(153, 0, 204));
        header.setLayout(new java.awt.GridBagLayout());

        P4P.setBackground(new java.awt.Color(255, 255, 255));
        P4P.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        P4P.setForeground(Color.white);
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
        Username.setText(username);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 516, 0, 2);
        header.add(Username, gridBagConstraints);

        body.add(header, java.awt.BorderLayout.PAGE_START);

        contenu.setBackground(new java.awt.Color(255, 255, 255));
        contenu.setLayout(new java.awt.GridBagLayout());

        UserAgendaTable.setAutoCreateRowSorter(true);
        UserAgendaTable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UserAgendaTable.setModel(new javax.swing.table.DefaultTableModel(
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
            @SuppressWarnings("rawtypes")
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            @SuppressWarnings("rawtypes")
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        UserAgendaTable.setToolTipText("");
        UserAgendaTable.setColumnSelectionAllowed(true);
        UserAgendaTable.setEnabled(false);
        UserAgendaTable.setGridColor(new java.awt.Color(204, 204, 204));
        UserAgendaTable.setRowHeight(40);
        UserAgendaTable.setSelectionBackground(new java.awt.Color(153, 204, 0));
        UserAgendaTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        UserAgendaTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        UserAgendaTable.setShowHorizontalLines(true);
        UserAgendaTable.setShowVerticalLines(true);
        jScrollPane1.setViewportView(UserAgendaTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 764;
        gridBagConstraints.ipady = 450;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 0);
        contenu.add(jScrollPane1, gridBagConstraints);

        body.add(contenu, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuActionPerformed(ActionEvent evt) {                                      
        HomePageUser nwusp = new HomePageUser(iduser, user_name);
        nwusp.setVisible(true);
        nwusp.setSize(1050, 650);
        nwusp.setLocationRelativeTo(null);
        Window win = SwingUtilities.getWindowAncestor(menu);
        win.dispose();
    }                                     

    private void messagesActionPerformed(ActionEvent evt) {                                         
        UserMessagePage usrmsgp = new UserMessagePage(iduser, user_name);
        usrmsgp.setVisible(true);
        usrmsgp.setSize(1050, 650);
        usrmsgp.setLocationRelativeTo(null);
        Window win = SwingUtilities.getWindowAncestor(messages);
        win.dispose();
    }                                        

    private void se_deconnecterActionPerformed(ActionEvent evt) {                                            
      	 Window wdws = SwingUtilities.getWindowAncestor(se_deconnecter);
           if(wdws != null)
           {
          	verifieDeconnexion vd = new verifieDeconnexion(wdws);
        	vd.setLocationRelativeTo(null);
           	vd.setVisible(true);
           	vd.setSize(400, 300);
           }
      }                                        

    private void projectsActionPerformed(ActionEvent evt) {                                         
        Projects pp = new Projects(iduser, user_name);
        pp.setVisible(true);
        pp.setSize(1050, 650);
        pp.setLocationRelativeTo(null);
        Window win =SwingUtilities.getWindowAncestor(projects);
        win.dispose();
    }                                        

    private void requestsActionPerformed(ActionEvent evt) {                                         
    	UserRequests usrmsgp = new UserRequests(iduser, user_name);
        usrmsgp.setVisible(true);
        usrmsgp.setSize(1050, 650);
        usrmsgp.setLocationRelativeTo(null);
        Window win = SwingUtilities.getWindowAncestor(requests);
        win.dispose();
    }                                        

    private void agendaActionPerformed(ActionEvent evt) {                                       
        UserAgendaPage usrp= new UserAgendaPage(iduser, user_name);
        usrp.setVisible(true);
        usrp.setSize(1050, 650);
        usrp.setLocationRelativeTo(null);
        Window win = SwingUtilities.getWindowAncestor(agenda);
        win.dispose();
        
        
    } 
    private void invitationActionPerformed(ActionEvent evt)
    {
    	Invitation_demande usr_inv_page = new Invitation_demande(iduser, user_name);
        usr_inv_page.setVisible(true);
        usr_inv_page.setSize(1050, 650);
        usr_inv_page.setLocationRelativeTo(null);
        Window win = SwingUtilities.getWindowAncestor(invitation);
        win.dispose();
    }
    
    
}