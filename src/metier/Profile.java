package metier;

import java.awt.Dimension;
import java.sql.*;

public class Profile extends javax.swing.JFrame {
	private int iduser;
	private String usrname;
    TableProjets tableProjets;
    Connection conn = Utilitaire.getConnection();
    public Profile(int iduser, String usrname) {
    	this.iduser = iduser;
    	this.usrname = usrname;
        java.awt.GridBagConstraints gridBagConstraints;

        body = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        LOGO = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        userIcon = new javax.swing.JLabel();
        Contenu = new javax.swing.JPanel();
        lastseenValue = new javax.swing.JLabel();
        iconUser = new javax.swing.JLabel();
        fullename = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        lastseen = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        emailValue = new javax.swing.JLabel();
        Projects = new javax.swing.JLabel();
        tableProjets = new TableProjets(iduser);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new Dimension(1050, 650));

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
        Username.setText(usrname);
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

        Contenu.setBackground(new java.awt.Color(255, 255, 255));
        Contenu.setLayout(new java.awt.GridBagLayout());

        

        iconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/icons8-user-profile-100.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        Contenu.add(iconUser, gridBagConstraints);

        fullename.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fullename.setForeground(new java.awt.Color(0, 0, 102));
        fullename.setText("Fulle_NameXXXXX");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 20, 0, 432);
        Contenu.add(fullename, gridBagConstraints);

        username.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        username.setForeground(new java.awt.Color(153, 153, 153));
        username.setText(usrname);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 71;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 20, 0, 432);
        Contenu.add(username, gridBagConstraints);

        

        email.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        email.setForeground(new java.awt.Color(0, 0, 102));
        email.setText("Email :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 39;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 80, 0, 0);
        Contenu.add(email, gridBagConstraints);

        emailValue.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        emailValue.setForeground(new java.awt.Color(153, 153, 153));
        emailValue.setText("emailXXXXX@XXXXXX.com");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 88;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        Contenu.add(emailValue, gridBagConstraints);

        if (iduser != 0) {
        	lastseen.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
            lastseen.setForeground(new java.awt.Color(0, 0, 102));
            lastseen.setText("Last seen :");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.ipadx = 13;
            gridBagConstraints.ipady = 18;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new java.awt.Insets(0, 80, 0, 0);
            Contenu.add(lastseen, gridBagConstraints);
            
            lastseenValue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            lastseenValue.setForeground(new java.awt.Color(153, 153, 153));
            lastseenValue.setText("dateDerniereconnexion");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.ipadx = 103;
            gridBagConstraints.ipady = 20;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            Contenu.add(lastseenValue, gridBagConstraints);
            
	        Projects.setFont(new java.awt.Font("Segoe UI", 1, 16)); 
	        Projects.setForeground(new java.awt.Color(0, 0, 102));
	        Projects.setText("Projects :");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 4;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(20, 80, 10, 0);
	        Contenu.add(Projects, gridBagConstraints);

			tableProjets.setFont(new java.awt.Font("Segoe UI", 0, 14));
			tableProjets.setPreferredSize(new Dimension(800, 300)); // Adjusted to fit within the frame
			tableProjets.setForeground(new java.awt.Color(0, 0, 0));
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 5;
			gridBagConstraints.gridwidth = 7; // Adjust as necessary
			gridBagConstraints.gridheight = 1; // Added to ensure correct positioning
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new java.awt.Insets(10, 80, 20, 80); // Adjust the insets to properly position the table
			Contenu.add(tableProjets, gridBagConstraints);
		}
		body.add(Contenu, java.awt.BorderLayout.CENTER);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);
        fetchUserData(usrname);
        pack();
    }
    public Profile(String username) {
    	this(0, username + "-adm");
    }
    

    private void UsernameMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }
    
    
    private void fetchUserData(String usrname) {
    	
        try {
        	
            if (usrname.endsWith("-adm")) {
            	String query = "SELECT nom, prenom, identifiant_connexion, email FROM administrateur_plateforme WHERE identifiant_connexion = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				String adminUsername = usrname.substring(0, usrname.length() - 4);
				ps.setString(1, adminUsername);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					fullename.setText(rs.getString("nom") + " " + rs.getString("prenom"));
					username.setText(rs.getString("identifiant_connexion"));
					emailValue.setText(rs.getString("email"));
					//lastseenValue.setText(rs.getString("derniere_date_connexion"));
				} 
				
			}else {
				String query = "SELECT nom, prenom, username, email, derniere_date_connexion FROM utilisateur WHERE username = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, usrname);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					fullename.setText(rs.getString("nom") + " " + rs.getString("prenom"));
					username.setText(rs.getString("username"));
					emailValue.setText(rs.getString("email"));
					lastseenValue.setText(rs.getString("derniere_date_connexion"));
				} 
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Profile pf= new Profile(9, "oubeza_idir");
                pf.setSize(new Dimension(1050, 650));
                pf.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel Contenu;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel LOGO;
    private javax.swing.JLabel Projects;
    private javax.swing.JLabel Username;
    private javax.swing.JPanel body;
    private javax.swing.JLabel email;
    private javax.swing.JLabel emailValue;
    private javax.swing.JLabel fullename;
    private javax.swing.JLabel iconUser;
    private javax.swing.JLabel lastseen;
    private javax.swing.JLabel lastseenValue;
    private javax.swing.JLabel userIcon;
    private javax.swing.JLabel username;
    // End of variables declaration
}
