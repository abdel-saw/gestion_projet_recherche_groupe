package metier;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.*;

public class HomePageUser extends javax.swing.JFrame {
    Connection conn = Utilitaire.getConnection();
    private int iduser;
    private String username;
    JButton deconnexion = new JButton();
    
    
    public Vector<Integer> fetchProjectsForUser(String searchQuery) {
    	
        Vector<Integer> projectIds = new Vector<>();
        
        try {
        	String query = "SELECT IdProjet, nom_court, theme, type, etat, isPublic FROM projet";
            if (searchQuery != null && !searchQuery.isEmpty()) {
                query += " WHERE nom_court LIKE ?";
            }
            PreparedStatement ps = conn.prepareStatement(query);

            if (searchQuery != null && !searchQuery.isEmpty()) {
                String searchPattern = "%" + searchQuery + "%";
                ps.setString(1, searchPattern);
            }

            ResultSet rs = ps.executeQuery();	
            while (rs.next()) {
					projectIds.add(rs.getInt("IdProjet"));
				} 
            
        } catch (SQLException e) {
            System.out.println("Exception: " + e);
        }

        return projectIds;
    }




    public HomePageUser(int iduser, String username) {
    	this.username = username;
    	this.iduser = iduser;
    	this.last_con_date = Instant.now();
        java.awt.GridBagConstraints gridBagConstraints;
        tableProjets = new TableProjetList(this);

        body = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        LOGO = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        userIcon = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        Home1 = new javax.swing.JButton();
        Projects = new javax.swing.JButton();
        Messages = new javax.swing.JButton();
        Requests = new javax.swing.JButton();
        Invitations = new javax.swing.JButton();
        Agenda = new javax.swing.JButton();
        jLabel1 = new JLabel();
        DashBord = new JPanel();
        last_connexion_date = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jScrollPane1 = new JScrollPane();
        activity_table = new JTable();
        Contenu = new javax.swing.JPanel();
        barContenu = new JPanel();
        h1Bar = new JLabel();
        recherche = new JTextField();
        rechercheButton = new JButton();
        JScrollPane scrollPane = new JScrollPane(Contenu);
        
        Contenu.setLayout(new BorderLayout());
        Contenu.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Panel for the project panels
        JPanel projectsPanel = new JPanel(new GridLayout(0, 3, 30, 30));
        projectsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        projectsPanel.setBackground(Color.white);
        Vector<Integer> idprojets = fetchProjectsForUser(recherche.getText());
        for (int id : idprojets) {
            JPanel projectPanel = createProjectPanel(id);
            projectsPanel.add(projectPanel);
        }

        //Contenu.add(labelPanel, BorderLayout.NORTH);
        Contenu.add(projectsPanel, BorderLayout.CENTER);
        barContenu.setBackground(new Color(102, 0, 204));
        barContenu.setLayout(new GridBagLayout());

        h1Bar.setFont(new Font("Segoe UI", 1, 24));
        h1Bar.setForeground(new Color(255, 255, 255));
        h1Bar.setText("Projects list");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(20, 30, 30, 0);
        barContenu.add(h1Bar, gridBagConstraints);

        recherche.setHorizontalAlignment(JTextField.LEFT);
        recherche.setBorder(null);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(30, 337, 30, 0);
        barContenu.add(recherche, gridBagConstraints);

        rechercheButton.setBackground(new Color(153, 204, 0));
        rechercheButton.setFont(new Font("Segoe UI", 1, 12));
        rechercheButton.setForeground(new Color(255, 255, 255));
        rechercheButton.setText("Rechercher");
        rechercheButton.setBorder(null);
        rechercheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! look here !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            	// i want to clear the projectsPanel before resetting the displayed projects
            	projectsPanel.removeAll(); // Clear the projectsPanel
                projectsPanel.revalidate(); // Revalidate the panel to update the UI
                projectsPanel.repaint(); // Repaint the panel to reflect the changes

                Vector<Integer> idprojets = fetchProjectsForUser(recherche.getText());
                for (int id : idprojets) {
                    JPanel projectPanel = createProjectPanel(id);
                    projectsPanel.add(projectPanel);
                }

                projectsPanel.revalidate(); // Revalidate the panel again to add the new components
                projectsPanel.repaint(); // Repaint the panel again to reflect the changes
            
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(30, 0, 30, 20);
        barContenu.add(rechercheButton, gridBagConstraints);

        /*
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -10;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 15, 0, 10);*/
        Contenu.add(barContenu, BorderLayout.NORTH);
        
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

        Home1.setBackground(new java.awt.Color(153, 0, 204));
        Home1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Home1.setForeground(Color.white);
        Home1.setText("Home");
        Home1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Home1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home1ActionPerformed(evt);
            }
        });

        Menu.add(Home1);

        Projects.setFont(new java.awt.Font("Segoe UI", 1, 14));
        Projects.setBackground(Color.white);
        Projects.setForeground(new java.awt.Color(153, 0, 204));
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
        Messages.setText("Messages");
        Messages.setBackground(Color.white);
        Messages.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        Messages.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Messages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messagesActionPerformed(evt);
            }

        });

        Menu.add(Messages);

        Requests.setFont(new java.awt.Font("Segoe UI", 1, 14));
        Requests.setBackground(Color.white);
        Requests.setForeground(new java.awt.Color(153, 0, 204));
        Requests.setText("Requests");
        Requests.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        Requests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Requests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestsActionPerformed(evt);
            }
        });

        Menu.add(Requests);

        Invitations.setFont(new java.awt.Font("Segoe UI", 1, 14));
        Invitations.setBackground(Color.white);
        Invitations.setForeground(new java.awt.Color(153, 0, 204));
        Invitations.setText("Invitations");
        Invitations.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        Invitations.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Invitations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invitationsActionPerformed(evt);
            }
        });

        Menu.add(Invitations);

        Agenda.setFont(new java.awt.Font("Segoe UI", 1, 14));
        Agenda.setBackground(Color.white);
        Agenda.setForeground(new java.awt.Color(153, 0, 204));
        Agenda.setText("Agenda");
        Agenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        Agenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendaActionPerformed(evt);
            }
        });

        Menu.add(Agenda);
        
        deconnexion.setFont(new Font("Segoe UI", 1, 14)); 
        deconnexion.setBackground(new Color(255, 255, 255));
        deconnexion.setForeground(new Color(153, 0, 204));
        deconnexion.setText("Se_deconnecter");
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

        body.add(scrollPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
    }

    private JPanel createProjectPanel(int id) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setPreferredSize(new Dimension(225, 285)); // Set preferred size to accommodate additional label

        // Add padding inside the panel and retain the original border
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 2), // External visible border
            BorderFactory.createEmptyBorder(10, 15, 10, 15) // Inner padding
        ));

        JLabel projectName = new JLabel("Project Name");
        projectName.setFont(new Font("Segoe UI", 1, 16));
        projectName.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(projectName, BorderLayout.NORTH);
        panel.setBackground(Color.white);

        JTextArea projectDescription = new JTextArea();
        projectDescription.setBackground(new java.awt.Color(255, 255, 255));
        projectDescription.setEditable(false);
        projectDescription.setWrapStyleWord(true);
        projectDescription.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(projectDescription);
        panel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBorder(null);

        // Create a panel for the privacy label and the button
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBackground(Color.white);

        JLabel projectPrivacy = new JLabel("Privacy: ");
        projectPrivacy.setFont(new Font("Segoe UI", 0, 14));
        projectPrivacy.setHorizontalAlignment(SwingConstants.CENTER);
        projectPrivacy.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.white, 2), // External visible border
                BorderFactory.createEmptyBorder(5, 15, 5, 15) // Inner padding
            ));

        southPanel.add(projectPrivacy, BorderLayout.NORTH);
        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add padding around the south panel

        JButton ButtonSeeMore = new JButton();
        ButtonSeeMore.setBackground(new java.awt.Color(0, 51, 204));
        ButtonSeeMore.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonSeeMore.setForeground(new java.awt.Color(255, 255, 255));
        ButtonSeeMore.setText("See more >");
        
        //AboutPage(int iduser, String nom_long, String description, String date, int idprojetAboutPage, String nom_court,String username)
        southPanel.add(ButtonSeeMore, BorderLayout.SOUTH);

        panel.add(southPanel, BorderLayout.SOUTH);

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM PROJET WHERE IDPROJET = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                projectName.setText(rs.getString("nom_court")); // Use the correct column name
                projectDescription.setText(rs.getString("description")); // Use the correct column name
                boolean isPublic = rs.getBoolean("isPublic");
                projectPrivacy.setText("Privacy: " + (isPublic ? "Public" : "Private"));
                ButtonSeeMore.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        try {
							AboutPage ap = new AboutPage(new Info(iduser, rs.getString("nom_long"), rs.getString("description"), rs.getString("date_creation"), rs.getInt("idprojet"), rs.getString("nom_court"), username));
							ap.setVisible(true);
							ap.setSize(950, 550);
							ap.setLocationRelativeTo(null);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return panel;
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

    public static void main(String args[]) {
    	System.out.println("i'm in the main function");
        HomePageUser p = new HomePageUser(9,"oubeza_idir");
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        p.setSize(1050, 650);
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
    // Variables declaration - do not modify                     
    private javax.swing.JButton Agenda;
    private javax.swing.JPanel Contenu;
    private javax.swing.JPanel Header;
    private javax.swing.JButton Home1;
    private javax.swing.JButton Invitations;
    private javax.swing.JLabel LOGO;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton Messages;
    private javax.swing.JButton Projects;
    private javax.swing.JButton Requests;
    private javax.swing.JLabel Username;
    private javax.swing.JPanel body;
    private javax.swing.JLabel userIcon;
    
    private TableProjetList tableProjets;
       
    private JPanel DashBord;
    private JTable activity_table;
    /*private JButton deconnexion;
    private JButton Invitation;*/
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JLabel last_connexion_date;
    protected Instant last_con_date ;
    private JPanel barContenu;
    private JLabel h1Bar;
    private JTextField recherche;
    private JButton rechercheButton;
    // protected static String usrname ; 

    // End of variables declaration 
}
