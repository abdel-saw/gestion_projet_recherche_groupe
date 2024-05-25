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

public class Guest extends javax.swing.JFrame {
    Connection conn = Utilitaire.getConnection();
    private String username;
    
    
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




    public Guest(String username) {
    	this.username = username;
    	this.last_con_date = Instant.now();
        java.awt.GridBagConstraints gridBagConstraints;

        body = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        LOGO = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        userIcon = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        Home1 = new javax.swing.JButton();
        SignUp = new javax.swing.JButton();

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
        Home1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        Home1.setForeground(Color.white);
        Home1.setText("Home");
        Home1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Home1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Menu.add(Home1);

        SignUp.setFont(new java.awt.Font("Segoe UI", 1, 14));
        SignUp.setBackground(Color.white);
        SignUp.setForeground(new java.awt.Color(153, 0, 204));
        SignUp.setText("SignUp");
        SignUp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 204)));
        SignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	SignUpAction(evt);
            }
        });
        

        Menu.add(SignUp);

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
//////////////////////////////////////////////////////////////////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
							AboutPage ap = new AboutPage(new Info(0, rs.getString("nom_long"), rs.getString("description"), rs.getString("date_creation"), rs.getInt("idprojet"), rs.getString("nom_court"), username));
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



    // Variables declaration - do not modify  
    private javax.swing.JPanel Contenu;
    private javax.swing.JPanel Header;
    private javax.swing.JButton Home1;
    private javax.swing.JLabel LOGO;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton SignUp;
    private javax.swing.JLabel Username;
    private javax.swing.JPanel body;
    private javax.swing.JLabel userIcon;

    /*private JButton deconnexion;
    private JButton Invitation;*/
    protected Instant last_con_date ;
    private JPanel barContenu;
    private JLabel h1Bar;
    private JTextField recherche;
    private JButton rechercheButton;
    // protected static String usrname ; 
    private JButton deconnexion = new JButton();

    // End of variables declaration 
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
    private void SignUpAction(ActionEvent evt) {
	    SignUp sp = new SignUp();
	    sp.setVisible(true);
	    this.setVisible(false);
	    sp.setLocationRelativeTo(null);
    }
 public static void main(String args[]) {
        
        Guest gp = new Guest("guest");
        gp.setVisible(true);
        gp.setLocationRelativeTo(null);
        gp.setSize(1050, 650);
    }
}
