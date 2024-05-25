package metier;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UsersPage extends JFrame {
	Connection conn = Utilitaire.getConnection();
	private String username;
	
	DefaultTableModel model;
    public UsersPage(String username) {
    	this.username = username;
        GridBagConstraints gridBagConstraints;

        body = new JPanel();
        Header = new JPanel();
        LOGO = new JLabel();
        Username = new JLabel();
        jLabel1 = new JLabel();
        Menu = new JPanel();
        Home1 = new JButton();
        Messages = new JButton();
        Users = new JButton();
        Projects = new JButton();
        Requests = new JButton();
        deconnexion = new JButton();
        Contenu = new JPanel();
        barContenu = new JPanel();
        h1Bar = new JLabel();
        recherche = new JTextField();
        rechercheButton = new JButton();
        jScrollPane1 = new JScrollPane();
        UserTable = new JTable();
        supprimeButton = new JButton();
        consulteButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jScrollPane1.setForeground(new Color(102,0,204));
        body.setBackground(new Color(255, 255, 255));
        body.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(153,0,204)));
        body.setLayout(new BorderLayout());

        Header.setBackground(new Color(153, 0, 204));
        Header.setLayout(new GridBagLayout());

        LOGO.setFont(new Font("Montserrat Black", 3, 24));
        LOGO.setForeground(new Color(255, 255, 255));
        LOGO.setText("P4P");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(0, 65, 0, 0);
        Header.add(LOGO, gridBagConstraints);

        Username.setFont(new Font("Segoe UI", 1, 14)); 
        Username.setForeground(new Color(255, 255, 255));
        Username.setHorizontalAlignment(SwingConstants.CENTER);
        Username.setText(username + "-adm");
        Username.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Username.setHorizontalTextPosition(SwingConstants.CENTER);
        Username.setIconTextGap(1);
        Username.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                UsernameMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(0, 6, 0, 51);
        Header.add(Username, gridBagConstraints);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setIcon(new ImageIcon(getClass().getResource("assets/icons8-user-30.png"))); 
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(0, 625, 0, 0);
        Header.add(jLabel1, gridBagConstraints);

        body.add(Header, BorderLayout.NORTH);

        Menu.setBackground(new Color(255, 255, 255));
        Menu.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Menu.setPreferredSize(new Dimension(180, 427));
        Menu.setLayout(new GridLayout(9, 0));

        Home1.setBackground(Color.white);
        Home1.setFont(new Font("Segoe UI", 1, 14));
        Home1.setForeground(new Color(153, 0, 204));
        Home1.setText("Home");
        Home1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        Home1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Home1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Home1ActionPerformed(evt);
            }
        });
        Menu.add(Home1);

        Users.setFont(new Font("Segoe UI", 1, 14)); 
        Users.setForeground(Color.white);
        Users.setText("Users");
        Users.setBackground(new Color(153, 0, 204));
        Users.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Users.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Users.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UsersActionPerformed(evt);
            }
        });
        Menu.add(Users);

        Projects.setFont(new Font("Segoe UI", 1, 14)); 
        Projects.setForeground(new Color(153, 0, 204));
        Projects.setText("Projects");
        Projects.setBackground(Color.white);
        Projects.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Projects.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Projects.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ProjectsActionPerformed(evt);
            }
        });
        Menu.add(Projects);

        Requests.setFont(new Font("Segoe UI", 1, 14));
        Requests.setForeground(new Color(153, 0, 204));
        Requests.setText("Requests");
        Requests.setBackground(Color.white);
        Requests.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Requests.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Requests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RequestsActionPerformed(evt);
            }
        });
        Menu.add(Requests);
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
        

        

        body.add(Menu, BorderLayout.WEST);

Contenu.setBackground(new Color(255, 255, 255));
        
        Contenu.setLayout(new GridBagLayout());
        
        barContenu.setBackground(new Color(102, 0, 204));
        barContenu.setLayout(new GridBagLayout());
        barContenu.setPreferredSize(new Dimension(700,50));
        h1Bar.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        h1Bar.setForeground(new Color(255, 255, 255));
        h1Bar.setText("Users list");
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
        rechercheButton.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        rechercheButton.setForeground(new Color(255, 255, 255));
        rechercheButton.setText("Rechrecher");
        rechercheButton.setBorder(null);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(30, 0, 30, 25);
        barContenu.add(rechercheButton, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -10;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 50, 0, 10);
        Contenu.add(barContenu, gridBagConstraints);

        
        
        
        
       UserTable.setAutoCreateRowSorter(true);
        UserTable.setFont(new Font("Segoe UI", 1, 12));

        
        String[] columnNames = {"Username", "Email", "Full name" , "Last Login date"};

        Object[][] data = {
            {"abdel_sawadogo","abdel@example.com", "abdel sawadogo", "2024-05-22 02:30:38"}
        };
        ArrayList<Object[]> users = getUsers();
        
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        	public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for(Object[] o : users) {
        	model.addRow(o);
        }
        
        rechercheButton.addActionListener(e -> updateTableWithSearch());

        Home1.addActionListener(e -> refreshUserTable());
        
        UserTable.setModel(model);
        UserTable.setGridColor(Color.LIGHT_GRAY);
        UserTable.setRowHeight(40);
        UserTable.setSelectionBackground(new Color(153, 204, 0));
        UserTable.setSelectionForeground(new Color(255, 255, 255));
        UserTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(UserTable);
        UserTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 694;
        gridBagConstraints.ipady = 320;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 21, 1, 0);
        Contenu.add(jScrollPane1, gridBagConstraints);

        consulteButton.setBackground(new java.awt.Color(102, 102, 255));
        consulteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/view.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 9, 0, 5);
        Contenu.add(consulteButton, gridBagConstraints);
        consulteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = UserTable.getSelectedRow();
                if (selectedRow != -1) {
                    String username = (String) UserTable.getValueAt(selectedRow, 0);
                    int userId = getUserIdByUsername(username);
                    Profile profile = new Profile(userId, username);
                    profile.setVisible(true);
                    profile.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur à consulter.", "Avertissement", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        supprimeButton.setBackground(new java.awt.Color(255, 102, 102));
        
        supprimeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/icons8-x-30.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = -7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 9, 0, 5);
        Contenu.add(supprimeButton, gridBagConstraints);
        supprimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = UserTable.getSelectedRow();
                if (selectedRow != -1) {
                    String username = (String) UserTable.getValueAt(selectedRow, 0);
                    int userId = getUserIdByUsername(username);
                    VerifierSupprissionCompte verification = new VerifierSupprissionCompte(userId);
                    verification.setVisible(true);
                    verification.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur à supprimer.", "Avertissement", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        body.add(Contenu, BorderLayout.CENTER);

        getContentPane().add(body, BorderLayout.CENTER);

        pack();
    
}
    private void UsernameMouseClicked(MouseEvent evt) {
    	Profile pl= new Profile(username);
    	pl.setSize(1050, 650);
    	pl.setLocationRelativeTo(null);
    	pl.setVisible(true);
        
    }

    private void Home1ActionPerformed(ActionEvent evt) {
    	HomePageAdmin pl= new HomePageAdmin(username);
    	pl.setSize(1050, 650);
    	pl.setVisible(true);
    	pl.setLocationRelativeTo(null);
    	this.setVisible(false);
        
    }


    private void UsersActionPerformed(ActionEvent evt) {
    	UsersPage usp= new UsersPage(username);
    	usp.setSize(1050, 650);
    	usp.setVisible(true);
    	usp.setLocationRelativeTo(null);
    	this.setVisible(false);
    }

    private void ProjectsActionPerformed(ActionEvent evt) {
    	
    	ProjectsList pl= new ProjectsList(username);
    	pl.setSize(1050, 650);
    	pl.setVisible(true);
    	pl.setLocationRelativeTo(null);
    	this.setVisible(false);
    }

    private void RequestsActionPerformed(ActionEvent evt) {
        
    	
    	Requests rq= new Requests(username);
    	rq.setSize(1050, 650);
    	rq.setVisible(true);
    	rq.setLocationRelativeTo(null);
    	this.setVisible(false);
    }
    public ArrayList<Object[]> getUsers() {
    	String query = "SELECT username,email,nom,prenom,derniere_date_connexion FROM utilisateur";
    	ArrayList<Object[]> users = new ArrayList<>();
    	try {
    		Statement s = conn.createStatement();
    		ResultSet rs = s.executeQuery(query);
    		while(rs.next()) {
    			Object[] row = {rs.getString("username"),rs.getString("email"),rs.getString("nom")+" "+rs.getString("prenom"),rs.getString("derniere_date_connexion")};
    			users.add(row);
    		}
    		return users;
    	}catch(SQLException s) {
    		System.out.println(s.getMessage());
    	}
    	return null;
    }
    
    
    private void updateTableWithSearch() {
        String searchQuery = recherche.getText().trim();
        ArrayList<Object[]> users = getUsers(searchQuery);
        DefaultTableModel model = (DefaultTableModel) UserTable.getModel();
        model.setRowCount(0);
        for (Object[] user : users) {
            model.addRow(user);
        }
        recherche.setText("");
    }

    private void refreshUserTable() {
        ArrayList<Object[]> users = getUsers(""); 
        DefaultTableModel model = (DefaultTableModel) UserTable.getModel();
        model.setRowCount(0);
        for (Object[] user : users) {
            model.addRow(user);
        }
    }


    public ArrayList<Object[]> getUsers(String usernameSearch) {
        String query = "SELECT username, email, nom, prenom, derniere_date_connexion FROM utilisateur WHERE username LIKE ?";
        ArrayList<Object[]> users = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + usernameSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] row = {
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("nom") + " " + rs.getString("prenom"),
                    rs.getString("derniere_date_connexion")
                };
                users.add(row);
            }
            return users;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error accessing database: " + e.getMessage(),
                                          "Database Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    private int getUserIdByUsername(String username) {
        String query = "SELECT IdUtilisateur FROM utilisateur WHERE username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("IdUtilisateur");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Indique une erreur ou utilisateur non trouvé
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
		UsersPage Usrpg = new UsersPage("oubeza_idir");
        Usrpg.setVisible(true);
        Usrpg.setSize(1050, 650);
    }
    

                      
    private JButton deconnexion;
    private JPanel Contenu;
    private JPanel Header;
    private JButton Home1;
    private JLabel LOGO;
    private JPanel Menu;
    private JButton Messages;
    private JButton Projects;
    private JButton Requests;
    private JTable UserTable;
    private JLabel Username;
    private JButton Users;
    private JPanel barContenu;
    private JPanel body;
    private JLabel h1Bar;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTextField recherche;
    private JButton rechercheButton;
    private JButton supprimeButton;
    private JButton consulteButton;
                     

}

