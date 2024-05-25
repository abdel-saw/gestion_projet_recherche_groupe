package metier;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProjectsList extends JFrame {
    Connection conn = Utilitaire.getConnection();
    TableProjetList tableProjets;
    DefaultTableModel model;
    private String username;
    

    public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public ProjectsList(String username) {
    	this.username = username;
        GridBagConstraints gridBagConstraints;
        tableProjets = new TableProjetList(this);
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
        Agenda = new JButton();
        deconnexion = new JButton();
        Contenu = new JPanel();
        barContenu = new JPanel();
        h1Bar = new JLabel();
        recherche = new JTextField();
        rechercheButton = new JButton();
        jScrollPane1 = new JScrollPane();
        UserTable = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jScrollPane1.setForeground(new Color(102, 0, 204));
        body.setBackground(new Color(255, 255, 255));
        body.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(153, 0, 204)));
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
        Users.setForeground(new Color(153, 0, 204));
        Users.setText("Users");
        Users.setBackground(Color.white);
        Users.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Users.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Users.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UsersActionPerformed(evt);
            }
        });
        Menu.add(Users);

        Projects.setFont(new Font("Segoe UI", 1, 14));
        Projects.setForeground(Color.white);
        Projects.setText("Projects");
        Projects.setBackground(new Color(153, 0, 204));
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
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(30, 0, 30, 20);
        barContenu.add(rechercheButton, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -10;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 15, 0, 10);
        Contenu.add(barContenu, gridBagConstraints);

        tableProjets.setFont(new Font("Segoe UI", 0, 14));
        tableProjets.setPreferredSize(new Dimension(720, 400));
        tableProjets.setForeground(new Color(0, 0, 0));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 20, 20, 20);
        Contenu.add(tableProjets, gridBagConstraints);

        body.add(Contenu, BorderLayout.CENTER);

        getContentPane().add(body, BorderLayout.CENTER);

        pack();
 
        // Action listener for search button
        rechercheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = recherche.getText();
                tableProjets.updateTableModel(searchText);
                recherche.setText("");
            }
        });
    }
    private void UsernameMouseClicked(MouseEvent evt) {
    	Profile pl= new Profile(username);
    	pl.setVisible(true);
    	pl.setLocationRelativeTo(null);
        
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
        ProjectsList Usrpg = new ProjectsList("oubeza_idir");
        Usrpg.setVisible(true);
        Usrpg.setSize(1050, 650);
    }

    // Variables declaration - do not modify
    private JButton Agenda;
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
    // End of variables declaration
}
