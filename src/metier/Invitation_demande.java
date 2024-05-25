package metier;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Invitation_demande extends javax.swing.JFrame {
	private int iduser;
	private String username;

    Connection conn = Utilitaire.getConnection();
    public Invitation_demande(int iduser, String username) {
    	this.iduser = iduser;
    	this.username = username;
        
        java.awt.GridBagConstraints gridBagConstraints;

        body = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        LOGO = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        userIcon = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        Home1 = new javax.swing.JButton();
        Messages = new javax.swing.JButton();
        Projects = new javax.swing.JButton();
        Requests = new javax.swing.JButton();
        Agenda = new javax.swing.JButton();
        Invitations = new javax.swing.JButton();
        deconnexion = new JButton();
        Contenu = new javax.swing.JPanel();
        request = new javax.swing.JButton();
        Invitation = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        InvitationList = new javax.swing.JTable();
        AcceptButton = new javax.swing.JButton();
        RefuseButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestsList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        Header.setBackground(new java.awt.Color(153, 0, 204));
        Header.setLayout(new java.awt.GridBagLayout());

        LOGO.setFont(new java.awt.Font("Montserrat Black", 3, 24)); // NOI18N
        LOGO.setForeground(new java.awt.Color(255, 255, 255));
        LOGO.setText("P4P");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 67, 10, 0);
        Header.add(LOGO, gridBagConstraints);

        Username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username.setText(username);
        Username.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Username.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Username.setIconTextGap(1);
        Username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsernameMouseClicked(evt);
            }
        });
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 10, 49);
        Header.add(Username, gridBagConstraints);

        userIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/icons8-user-30.png"))); // NOI18N
        userIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 623, 10, 0);
        Header.add(userIcon, gridBagConstraints);

        body.add(Header, java.awt.BorderLayout.NORTH);

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        Menu.setPreferredSize(new java.awt.Dimension(180, 427));
        Menu.setLayout(new java.awt.GridLayout(9, 0));

        Home1.setBackground(Color.white);
        Home1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Home1.setForeground(new java.awt.Color(153, 0, 204));
        Home1.setBackground(Color.white);
        Home1.setText("Home");
        Home1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Home1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home1ActionPerformed(evt);
            }
        });
        
        Menu.add(Home1);


        Projects.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Projects.setForeground(new java.awt.Color(153, 0, 204));
        Projects.setBackground(Color.white);
        Projects.setText("Projects");
        Projects.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        Projects.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Projects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectsActionPerformed(evt);
            }
        });
        
        Menu.add(Projects);
        
        Messages.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Messages.setForeground(new java.awt.Color(153, 0, 204));
        Messages.setBackground(Color.white);
        Messages.setText("Messages");
        Messages.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        Messages.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Messages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messagesActionPerformed(evt);
            }
        });
        
        Menu.add(Messages);

        Requests.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Requests.setForeground(new java.awt.Color(153, 0, 204));
        Requests.setBackground(Color.white);
        Requests.setText("Requests");
        Requests.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        Requests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Requests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestsActionPerformed(evt);
            }
        });
        
        Menu.add(Requests);

        Agenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Agenda.setForeground(new java.awt.Color(153, 0, 204));
        Agenda.setBackground(Color.white);
        Agenda.setText("Agenda");
        Agenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        Agenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendaActionPerformed(evt);
            }
        });
        
        Menu.add(Agenda);

        Invitations.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Invitations.setForeground(Color.white);
        Invitations.setBackground(new java.awt.Color(153, 0, 204));
        Invitations.setText("Invitations");
        Invitations.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        Invitations.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Invitations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invitationsActionPerformed(evt);
            }
        });
        
        Menu.add(Invitations);
        
        deconnexion.setFont(new Font("Segoe UI", 1, 14)); 
        deconnexion.setForeground(new Color(153, 0, 204));
        deconnexion.setText("Se_deconnecter");
        deconnexion.setBackground(Color.white);
        deconnexion.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        deconnexion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deconnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deconnexionActionPerformed(evt);
            }
        });
        Menu.add(deconnexion);

        body.add(Menu, java.awt.BorderLayout.WEST);

        Contenu.setBackground(new java.awt.Color(255, 255, 255));
        Contenu.setLayout(new java.awt.GridBagLayout());

        request.setBackground(new java.awt.Color(0, 0, 204));
        request.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        request.setForeground(new java.awt.Color(255, 255, 255));
        request.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/icons8-code-fork-30 (1).png"))); // NOI18N
        request.setText("Requests");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 0, 0);
        Contenu.add(request, gridBagConstraints);
        request.addActionListener(e -> {
        	jScrollPane1.setVisible(false);
        	jScrollPane2.setVisible(true);
        	AcceptButton.setVisible(false);
        	RefuseButton.setVisible(false);
            
        });
        Invitation.setBackground(new java.awt.Color(0, 0, 204));
        Invitation.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Invitation.setForeground(new java.awt.Color(255, 255, 255));
        Invitation.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/icons8-invite-30.png"))); // NOI18N
        Invitation.setText("Invitation");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 98, 0, 0);
        Contenu.add(Invitation, gridBagConstraints);
        Invitation.addActionListener(e -> {
        	jScrollPane1.setVisible(true);
        	jScrollPane2.setVisible(false);
        	AcceptButton.setVisible(true);
        	RefuseButton.setVisible(true);
            
        });
        InvitationList.setAutoCreateRowSorter(true);
        InvitationList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        String[] columnInvitation = {"Invitation_Id","idgroupe", "Username", "Project", "invitation date"};

        Object[][] dataInvitation = {
        };
        DefaultTableModel model = new DefaultTableModel(dataInvitation, columnInvitation) {
        	public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Object[]> invitations = getInvitations(username);
        if(invitations != null) {
	        for(Object[] o : invitations) {
	        	model.addRow(o);
	        }
        }
        
        InvitationList.setModel(model);
        InvitationList.setSize(500, 250);
        InvitationList.setGridColor(Color.LIGHT_GRAY);
        InvitationList.setRowHeight(40);
        InvitationList.setSelectionBackground(new Color(153, 204, 0));
        InvitationList.setSelectionForeground(new Color(255, 255, 255));
        InvitationList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(InvitationList);
        InvitationList.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 604;
        gridBagConstraints.ipady = 290;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 80, 0, 83);
        Contenu.add(jScrollPane1, gridBagConstraints);

        AcceptButton.setBackground(new java.awt.Color(0, 204, 51));
        AcceptButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AcceptButton.setForeground(new java.awt.Color(255, 255, 255));
        AcceptButton.setText("Accept");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 240, 59, 0);
        Contenu.add(AcceptButton, gridBagConstraints);
        AcceptButton.addActionListener(e -> {
            int selectedRow = InvitationList.getSelectedRow();
            

         // Vérifiez que la sélection est valide
         if (selectedRow >= 0) {
             // Récupération de l'invitationId (supposons que c'est la première colonne)
             Integer invitationId = (Integer) InvitationList.getValueAt(selectedRow, 0);
                updateInvitationStatus(invitationId,"Accepted", (Integer) InvitationList.getValueAt(selectedRow, 1));
                
            }
        });

        RefuseButton.setBackground(new java.awt.Color(255, 0, 0));
        RefuseButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        RefuseButton.setForeground(new java.awt.Color(255, 255, 255));
        RefuseButton.setText("Refuse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 36, 0, 0);
        Contenu.add(RefuseButton, gridBagConstraints);
        RefuseButton.addActionListener(e -> {
            int selectedRow = InvitationList.getSelectedRow();
            if (selectedRow >= 0) {
                // Récupération de l'invitationId (supposons que c'est la première colonne)
                Integer invitationId = (Integer) InvitationList.getValueAt(selectedRow, 0);
                   updateInvitationStatus(invitationId,"Refused", 0);
               }
           });
        requestsList.setAutoCreateRowSorter(true);
        requestsList.setFont(new java.awt.Font("Segoe UI", 0, 14));
        String[] columnDemande= {"Request_Id", "Username", "Project name", "Request date","State"};
//Object[] row = {rs.getInt("Invitation_Id"), rs.getString("host"),rs.getString("nom_Projet"),rs.getString("date"), rs.getString("etat")};
        Object[][] dataDemande = {
        };
        DefaultTableModel modell = new DefaultTableModel(dataDemande, columnDemande) {
        	public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Object[]> requests = getRequests(username);
        if(requests != null) {
	        for(Object[] o : requests) {
	        	modell.addRow(o);
	        }
        }
        requestsList.setModel(modell);
        requestsList.setToolTipText("");
        requestsList.setColumnSelectionAllowed(true);
        requestsList.setEnabled(false);
        requestsList.setGridColor(new java.awt.Color(204, 204, 204));
        requestsList.setRowHeight(40);
        requestsList.setSelectionBackground(new java.awt.Color(153, 204, 0));
        requestsList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        requestsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        requestsList.setShowHorizontalLines(true);
        jScrollPane2.setViewportView(requestsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 604;
        gridBagConstraints.ipady = 290;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 80, 0, 83);
        Contenu.add(jScrollPane2, gridBagConstraints);

        body.add(Contenu, java.awt.BorderLayout.CENTER);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
    }
    
    
    
    public ArrayList<Object[]> getInvitations(String username) {
    	
    	ArrayList<Object[]> invitations = new ArrayList<>();
    	try {
    		PreparedStatement s = conn.prepareStatement("SELECT Invitation_Id,host,idgroupe, nom_Projet,date FROM invitation_demande where etat = 'Pending' AND type = 'invitation' AND user = ?");
    		s.setString(1, username);
    		ResultSet rs = s.executeQuery();
    		while(rs.next()) {
    			Object[] row = {rs.getInt("Invitation_Id"),rs.getInt("idgroupe"), rs.getString("host"),rs.getString("nom_Projet"),rs.getString("date")};
    			invitations.add(row);
    		}
    		return invitations;
    	}catch(SQLException s) {
    		System.out.println(s.getMessage());
    	}
    	return null;
    }
public ArrayList<Object[]> getRequests(String username) {
    	
    	ArrayList<Object[]> requests = new ArrayList<>();
    	try {
    		PreparedStatement s = conn.prepareStatement("SELECT * FROM invitation_demande where type = 'demande' AND user = ?");
    		s.setString(1, username);
    		ResultSet rs = s.executeQuery();
    		while(rs.next()) {
    			Object[] row = {rs.getInt("Invitation_Id"), rs.getString("host"),rs.getString("nom_Projet"),rs.getString("date"), rs.getString("etat")};
    			requests.add(row);
    		}
    		return requests;
    	}catch(SQLException s) {
    		System.out.println(s.getMessage());
    	}
    	return null;
    }
    
    
    public void refreshTable() {
        try {
            // Étape 1: Récupérer les nouvelles données de la base de données
            ArrayList<Object[]> invitations = getInvitations(username);

            // Étape 2: Vider les données actuelles du modèle
            DefaultTableModel model = (DefaultTableModel) InvitationList.getModel();
            model.setRowCount(0);

            // Étape 3: Ajouter les nouvelles données au modèle
            for (Object[] invitation : invitations) {
                model.addRow(invitation);
            }

            // La table est automatiquement rafraîchie par Swing quand le modèle change
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error refreshing the table data.");
        }
    }
    
    
    void updateInvitationStatus(int invitationId, String status, int idgroupe) {
        try {
            conn.setAutoCommit(false);

            // Temporarily disable foreign key checks
            Statement disableFK = conn.createStatement();
            disableFK.execute("SET FOREIGN_KEY_CHECKS = 0");

            // Update the invitation status
            PreparedStatement pstmt = conn.prepareStatement("UPDATE invitation_demande SET etat = ? WHERE invitation_id = ?");
            pstmt.setString(1, status);
            pstmt.setInt(2, invitationId);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                int selectedRow = InvitationList.getSelectedRow();
                if (selectedRow != -1) {
                    // Remove the row from the table model, not from the table itself
                    ((DefaultTableModel) InvitationList.getModel()).removeRow(InvitationList.convertRowIndexToModel(selectedRow));
                }
                refreshTable();
            }

            if (status.equalsIgnoreCase("accepted")) {
                    PreparedStatement pstmt2 = conn.prepareStatement("INSERT INTO UTILISATEUR_GROUPE(idUtilisateur, idGroupe) VALUES(?, ?)");
                    pstmt2.setInt(1, this.iduser);
                    pstmt2.setInt(2, idgroupe);
                    pstmt2.executeUpdate();
                
            }

            // Re-enable foreign key checks
            Statement enableFK = conn.createStatement();
            enableFK.execute("SET FOREIGN_KEY_CHECKS = 1");

            conn.commit();
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("Rollback failed: " + rollbackEx.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException autoCommitEx) {
                System.out.println("Failed to set auto-commit: " + autoCommitEx.getMessage());
            }
        }
    }

    private void home1ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
    	HomePageUser pf = new HomePageUser(iduser, username);
    	pf.setVisible(true);
    	pf.setLocationRelativeTo(null);
    	pf.setSize(1050, 650);
    	this.setVisible(false);
		
	}

	private void agendaActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		UserAgendaPage pf = new UserAgendaPage(iduser, username);
    	pf.setVisible(true);
    	pf.setLocationRelativeTo(null);
    	pf.setSize(1050, 650);
    	this.setVisible(false);
		
	}

	private void messagesActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		UserMessagePage pf = new UserMessagePage(iduser, username);
    	pf.setVisible(true);
    	pf.setLocationRelativeTo(null);
    	pf.setSize(1050, 650);
    	this.setVisible(false);
		
	}

	private void requestsActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		UserRequests pf = new UserRequests(iduser, username);
    	pf.setVisible(true);
    	pf.setLocationRelativeTo(null);
    	pf.setSize(1050, 650);
    	this.setVisible(false);
		
	}

	private void invitationsActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		Invitation_demande inv = new Invitation_demande(iduser, username);
    	inv.setVisible(true);
    	inv.setLocationRelativeTo(null);
    	inv.setSize(1050, 650);
    	this.setVisible(false);
		
	}
    
    private void projectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectsActionPerformed
    	System.out.println("in homepageuser "+ iduser +" "+ username);
    	Projects prs = new Projects(iduser, username);
    	prs.setSize(1050, 650);
    	prs.setLocationRelativeTo(null);
    	prs.setVisible(true);
    	this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_projectsActionPerformed
    private void UsernameMouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    	System.out.println("in homepageuser "+ iduser +" "+ username);
    	Profile pf = new Profile(iduser, username);
    	pf.setVisible(true);
    	pf.setLocationRelativeTo(null);
    	pf.setSize(1050, 650);
    } 
    
    private void deconnexionActionPerformed(ActionEvent evt) {                                            
    	 Window wdws = SwingUtilities.getWindowAncestor(deconnexion);
         if(wdws != null)
         {
        	verifieDeconnexion vd = new verifieDeconnexion(wdws);
      		vd.setLocationRelativeTo(null);
         	vd.setVisible(true);
         	vd.setSize(400, 300);
         }
    }  
    
    
    
    
    public static void main(String args[]) {
            	Invitation_demande i = new Invitation_demande(24, "zakariae_zemat");
            	i.setVisible(true);
            	i.setSize(1050,650);
                i.setLocationRelativeTo(null);
            
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AcceptButton;
    private javax.swing.JButton Agenda;
    private javax.swing.JPanel Contenu;
    private javax.swing.JPanel Header;
    private javax.swing.JButton Home1;
    private javax.swing.JButton Invitation;
    private javax.swing.JTable InvitationList;
    private javax.swing.JButton Invitations;
    private javax.swing.JLabel LOGO;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton Messages;
    private javax.swing.JButton Projects;
    private JButton deconnexion;
    private javax.swing.JButton RefuseButton;
    private javax.swing.JButton Requests;
    private javax.swing.JLabel Username;
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton request;
    private javax.swing.JTable requestsList;
    private javax.swing.JLabel userIcon;
    // End of variables declaration                   
}

