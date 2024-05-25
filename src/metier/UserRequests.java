package metier;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
import java.util.*;

  

/**
 *
 * @author IDIR
 */
public class UserRequests extends JFrame {
	private int iduser; 
	private String username;
	Connection conn = Utilitaire.getConnection();
    
    public UserRequests(int iduser, String username) {
    	this.iduser =iduser;
        this.username = username;
        GridBagConstraints gridBagConstraints;

        body = new JPanel();
        Header = new JPanel();
        LOGO = new JLabel();
        Username = new JLabel();
        userIcon = new JLabel();
        Menu = new JPanel();
        Home1 = new JButton();
        Messages = new JButton();
        Users = new JButton();
        Projects = new JButton();
        Requests = new JButton();
        Agenda = new JButton();
        Invitations = new JButton();
        deconnexion = new JButton();
        Contenu = new JPanel();
        ReviewedRequests = new JButton();
        newRequests = new JButton();
        tablePanel = new TableButtonPanelUser(this, this.iduser);
        jScrollPane1 = new JScrollPane();
        jTable1 = tablePanel.getTable();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        body.setBackground(new Color(255, 255, 255));
        body.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(153,0,204)));
        body.setLayout(new BorderLayout());

        Header.setBackground(new Color(153, 0, 204));
        Header.setPreferredSize(new Dimension(963, 50));
        Header.setLayout(new GridBagLayout());

        LOGO.setFont(new Font("Montserrat Black", 3, 24));
        LOGO.setForeground(new Color(255, 255, 255));
        LOGO.setText("P4P");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 67, 10, 0);
        Header.add(LOGO, gridBagConstraints);

        Username.setFont(new Font("Segoe UI", 1, 14));
        Username.setForeground(new Color(255, 255, 255));
        Username.setHorizontalAlignment(SwingConstants.CENTER);
        Username.setText(username);
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
        gridBagConstraints.insets = new Insets(0, 6, 10, 49);
        Header.add(Username, gridBagConstraints);

        userIcon.setHorizontalAlignment(SwingConstants.CENTER);
        userIcon.setIcon(new ImageIcon(getClass().getResource("assets/icons8-user-30.png"))); 
        userIcon.setHorizontalTextPosition(SwingConstants.CENTER);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(0, 623, 10, 0);
        Header.add(userIcon, gridBagConstraints);

        body.add(Header, BorderLayout.NORTH);

        Menu.setBackground(new Color(255, 255, 255));
        Menu.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Menu.setPreferredSize(new Dimension(180, 427));
        Menu.setLayout(new GridLayout(9, 0));

        Home1.setBackground(Color.WHITE);
        Home1.setFont(new Font("Segoe UI", 1, 14)); 
        Home1.setForeground(new Color(153, 0, 204));
        Home1.setText("Home");
        Home1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        Home1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Home1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                home1ActionPerformed(evt);
            }
        });
        Menu.add(Home1);

        


        Projects.setBackground(Color.WHITE);
        Projects.setFont(new Font("Segoe UI", 1, 14));
        Projects.setForeground(new Color(153, 0, 204));
        Projects.setText("Projects");
        Projects.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Projects.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Projects.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                projectsActionPerformed(evt);
            }
        });
        Menu.add(Projects);
        
        Messages.setBackground(Color.WHITE);
        Messages.setFont(new Font("Segoe UI", 1, 14));
        Messages.setForeground(new Color(153, 0, 204));
        Messages.setText("Messages");
        Messages.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Messages.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Messages.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                messagesActionPerformed(evt);
            }
        });
        Menu.add(Messages);

        Requests.setBackground(new Color(153, 0, 204));
        Requests.setFont(new Font("Segoe UI", 1, 14));
        Requests.setForeground(Color.WHITE);
        Requests.setText("Requests");
        Requests.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Requests.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Requests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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
	      

        body.add(Menu, BorderLayout.WEST);

        Contenu.setBackground(new Color(255, 255, 255));
        Contenu.setLayout(new GridBagLayout());

        ReviewedRequests.setBackground(new Color(0, 0, 204));
        ReviewedRequests.setFont(new Font("Segoe UI", 1, 13)); 
        ReviewedRequests.setForeground(new Color(255, 255, 255));
        ReviewedRequests.setIcon(new ImageIcon(getClass().getResource("assets/icons8-todo-list-32.png"))); 
        ReviewedRequests.setText("Reviewed Requests");
        ReviewedRequests.setHorizontalAlignment(SwingConstants.LEFT);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(26, 40, 0, 0);
        ReviewedRequests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ReviewedRqActionPerformed(evt);
            }
        });
        Contenu.add(ReviewedRequests, gridBagConstraints);

        newRequests.setBackground(new Color(0, 0, 204));
        newRequests.setFont(new Font("Segoe UI", 1, 13)); 
        newRequests.setForeground(new Color(255, 255, 255));
        newRequests.setIcon(new ImageIcon(getClass().getResource("assets/icons8-code-fork-30 (1).png"))); 
        newRequests.setText("Pending Requests");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(26, 85, 0, 0);
        newRequests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NewRqActionPerformed(evt);
            }
        });
        Contenu.add(newRequests, gridBagConstraints);
        
        Vector<Object[]> pendemandes = tablePanel.fetchDemandesUser();
        jScrollPane1.setViewportView(jTable1);

        String[] columns = {"Id_demande", "username", "nom_project", "theme", "Date", "Type", "etat"};
        // Create a table model with button column
        Object[][] data = {
            };
        Vector<Object[]> demandes = tablePanel.fetchDemandesReviewdUser();//= tablePanel.fetchDemandesAccepeted();
        
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make only the button column editable/////////////////////////////////////////////////////-!!!!!!!!!!!!!!!!!!!!!!///
            }
            @Override
            public Object getValueAt(int row, int column) {
                Object value = super.getValueAt(row, column);
                // Check if it's column 6 and modify text color based on cell content
                if (column == 6) {
                    String cellValue = String.valueOf(value);
                    if (cellValue.equalsIgnoreCase("refused")) {
                        // Set text color to red and make it bold
                        return "<html><font color='red'><b>" + cellValue + "</b></font></html>";
                    } else if (cellValue.equalsIgnoreCase("accepted")) {
                        // Set text color to green and make it bold
                        return "<html><font color='green'><b>" + cellValue + "</b></font></html>";
                    }
                }
                return value;
            }
        };
        
        for(Object[] o : demandes) {
        	model.addRow(o);
    	}

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 744;
        gridBagConstraints.ipady = 407;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(16, 10, 22, 13);
        Contenu.add(jScrollPane1, gridBagConstraints);
        
        
        jTable2.setModel(model);
        jTable2.setGridColor(Color.LIGHT_GRAY);
        jTable2.setRowHeight(40);
        jTable2.setSelectionBackground(new Color(153, 204, 0));
        jTable2.setSelectionForeground(new Color(255, 255, 255));
        jTable2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable2.setShowVerticalLines(true);
        jScrollPane2.setViewportView(jTable2);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 744;
        gridBagConstraints.ipady = 407;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(16, 10, 22, 13);
        
        Contenu.add(jScrollPane2, gridBagConstraints);

        body.add(Contenu, BorderLayout.CENTER);

        getContentPane().add(body, BorderLayout.CENTER);

        pack();
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
         	wdws.dispose();
         	LoginForm usrmsgp = new LoginForm();
           usrmsgp.setVisible(true);
           usrmsgp.setLocationRelativeTo(null);
         }
    }  
    private void ReviewedRqActionPerformed(ActionEvent evt) {
    	jScrollPane1.setVisible(false);
    	jScrollPane2.setVisible(true);
    	
    }
    private void NewRqActionPerformed(ActionEvent evt) {
    	jScrollPane2.setVisible(false);
    	jScrollPane1.setVisible(true);
    	
    }
    

   
    public static void main(String args[]) {
       
        
        

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	UserRequests rq = new UserRequests(9, "oubeza_idir");
            	rq.setSize(1050, 650);
            	rq.setVisible(true);
            }
        });
    }

    public int getId() {
		return iduser;
	}


	public void setId(int iduser) {
		this.iduser = iduser;
	}

    private JButton Agenda;
    private JPanel Contenu;
    private JPanel Header;
    private JButton Home1;
    private JLabel LOGO;
    private JPanel Menu;
    private JButton Messages;
    private JButton Projects;
    private JButton Requests;
    private JButton ReviewedRequests;
    private JLabel Username;
    private JButton Users;
    private JButton Invitations;
    private JPanel body;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    private TableButtonPanelUser tablePanel;
    private JTable jTable2;
    private JButton newRequests;
    private JLabel userIcon;
    private JButton deconnexion ;

}
