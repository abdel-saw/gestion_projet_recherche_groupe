package metier;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.*;
import java.util.Date;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
public class UserPage extends JFrame {

    public UserPage(String username) {
 	     GridBagConstraints gridBagConstraints;
 	     this.usrname = username ;
 	     this.last_con_date = getLastConDate();

 	        body = new JPanel();
 	        Header = new JPanel();
 	        LOGO = new JLabel();
 	        userIcon = new JLabel();
 	        jLabel1 = new JLabel();
 	        Menu = new JPanel();
 	        Home1 = new JButton();
 	        Messages = new JButton();
 	        Projects = new JButton();
 	        Requests = new JButton();
 	        Agenda = new JButton();
 	        Invitation = new JButton();
 	        deconnexion = new JButton();
 	        DashBord = new JPanel();
 	        last_connexion_date = new JLabel();
 	        jLabel2 = new JLabel();
 	        jLabel3 = new JLabel();
 	        jScrollPane1 = new JScrollPane();
 	        activity_table = new JTable();
 	        

 	        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

 	        body.setBackground(new Color(255, 255, 255));
 	        body.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(153,0,204)));
 	        body.setLayout(new BorderLayout());

 	        Header.setBackground(new Color(153, 0, 204));
 	        Header.setPreferredSize(new Dimension(963, 50));

 	        LOGO.setFont(new Font("Montserrat Black", 3, 24)); 
 	        LOGO.setForeground(new Color(255, 255, 255));
 	        LOGO.setText("P4P");

 	        userIcon.setHorizontalAlignment(SwingConstants.CENTER);
 	        userIcon.setHorizontalTextPosition(SwingConstants.CENTER);

 	        jLabel1.setFont(new Font("Segoe UI Black", 3, 14)); 
 	        jLabel1.setForeground(new Color(255, 255, 255));
 	        jLabel1.setIcon(new ImageIcon(getClass().getResource("assets/icons8-user-30.png"))); 
 	        jLabel1.setText(usrname);

 	        GroupLayout HeaderLayout = new GroupLayout(Header);
 	        Header.setLayout(HeaderLayout);
 	        HeaderLayout.setHorizontalGroup(
 	            HeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
 	            .addGroup(HeaderLayout.createSequentialGroup()
 	                .addGap(67, 67, 67)
 	                .addComponent(LOGO, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
 	                .addGap(608, 608, 608)
 	                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
 	                .addGap(26, 26, 26)
 	                .addComponent(userIcon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
 	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
 	        );
 	        HeaderLayout.setVerticalGroup(
 	            HeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
 	            .addGroup(HeaderLayout.createSequentialGroup()
 	                .addGroup(HeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
 	                    .addGroup(HeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
 	                        .addComponent(userIcon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
 	                        .addComponent(LOGO, GroupLayout.Alignment.TRAILING))
 	                    .addGroup(HeaderLayout.createSequentialGroup()
 	                        .addContainerGap()
 	                        .addComponent(jLabel1)))
 	                .addContainerGap())
 	        );

 	        body.add(Header, BorderLayout.NORTH);

 	        Menu.setBackground(new Color(255, 255, 255));
 	        Menu.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
 	        Menu.setPreferredSize(new Dimension(180, 427));
 	        Menu.setLayout(new GridLayout(9, 0));

 	        Home1.setBackground(new Color(153, 0, 204));
 	        Home1.setFont(new Font("Segoe UI", 1, 14)); 
 	        Home1.setForeground(new Color(255, 255, 255));
 	        Home1.setText("Home");
 	        Home1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
 	        Home1.setCursor(new Cursor(Cursor.HAND_CURSOR));
 	        Home1.addActionListener(new ActionListener() {
 	            public void actionPerformed(ActionEvent evt) {
 	                Home1ActionPerformed(evt);
 	            }
 	        });
 	        Menu.add(Home1);

 	        Messages.setFont(new Font("Segoe UI", 1, 14)); 
 	        Messages.setBackground(new Color(255, 255, 255));
 	        Messages.setForeground(new Color(153, 0, 204));
 	        Messages.setText("Messages");
 	        Messages.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
 	        Messages.setCursor(new Cursor(Cursor.HAND_CURSOR));
 	        Messages.addActionListener(new ActionListener() {
 	            public void actionPerformed(ActionEvent evt) {
 	                MessagesActionPerformed(evt);
 	            }
 	        });
 	        Menu.add(Messages);

 	        Projects.setFont(new Font("Segoe UI", 1, 14)); 
 	        Projects.setBackground(new Color(255, 255, 255));
 	        Projects.setForeground(new Color(153, 0, 204));
 	        Projects.setText("Projects");
 	        Projects.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
 	        Projects.setCursor(new Cursor(Cursor.HAND_CURSOR));
 	        Projects.addActionListener(new ActionListener() {
 	            public void actionPerformed(ActionEvent evt) {
 	                ProjectsActionPerformed(evt);
 	            }
 	        });
 	        Menu.add(Projects);

 	        Requests.setFont(new Font("Segoe UI", 1, 14)); 
 	        Requests.setBackground(new Color(255, 255, 255));
 	        Requests.setForeground(new Color(153, 0, 204));
 	        Requests.setText("Requests");
 	        Requests.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
 	        Requests.setCursor(new Cursor(Cursor.HAND_CURSOR));
 	        Requests.addActionListener(new ActionListener() {
 	            public void actionPerformed(ActionEvent evt) {
 	                RequestsActionPerformed(evt);
 	            }
 	        });
 	        Menu.add(Requests);

 	        Agenda.setFont(new Font("Segoe UI", 1, 14)); 
 	        Agenda.setForeground(new Color(153, 0, 204));
 	        Agenda.setBackground(new Color(255, 255, 255));
 	        Agenda.setText("Agenda");
 	        Agenda.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
 	        Agenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
 	        Agenda.addActionListener(new ActionListener() {
 	            public void actionPerformed(ActionEvent evt) {
 	                AgendaActionPerformed(evt);
 	            }
 	        });
 	        Menu.add(Agenda);

 	        Invitation.setFont(new Font("Segoe UI", 1, 14)); 
 	        Invitation.setBackground(new Color(255, 255, 255));
 	        Invitation.setForeground(new Color(153, 0, 204));
 	        Invitation.setText("Invitation");
 	        Invitation.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(153, 0, 204)));
 	        Invitation.addActionListener(new ActionListener()
 	        		{
 	        			public void actionPerformed(ActionEvent evt)
 	        			{
 	        				InvitationActionPerformed(evt);
 	        			}
 	        		}
 	        	);
 	        
 	        Menu.add(Invitation);

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

 	        DashBord.setBackground(new Color(255, 255, 255));
 	        
 	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());

 	        last_connexion_date.setText("Last connexion date :" +last_con_date);

 	        jLabel3.setFont(new Font("Segoe UI Black", 3, 18)); 
 	        jLabel3.setForeground(new Color(153, 0, 204));
 	        jLabel3.setText("Your recent activities");

 	        jScrollPane1.setBackground(new Color(255, 255, 255));

 	        activity_table.setModel(new DefaultTableModel(
 	            new Object [][] {
 	                {"envoi d'un message a Zakariae","15/05/2024","14h05"},
 	                {"téléchargement d'un fichier du projet Site Builder","14/05/2024","18h00"},
 	                {"ajout évènement dans votre agenda","13/05/2024","13h05"},
 	                {"dépot de fichier pour le projet Site Builder","13/05/2024","00h05"},
 	                {"demande de création de nouveau projet","12/05/2024","17h30"},
 	                {"demande cloture projet Online Car Rent","12/05/2024","16h02"},
 	                {"retrait participant au projet site Builder","11/05/2024","13h05"},
 	                {"envoi d'un message à Idir","10/05/2024","14h05"},
 	            },
 	            new String [] {
 	                "Description", "Date", "Time"
 	            }
 	        ) {
 	            Class[] types = new Class [] {
 	                java.lang.String.class, java.lang.String.class, java.lang.String.class
 	            };
 	            boolean[] canEdit = new boolean [] {
 	                false, false, false
 	            };

 	            public Class getColumnClass(int columnIndex) {
 	                return types [columnIndex];
 	            }

 	            public boolean isCellEditable(int rowIndex, int columnIndex) {
 	                return canEdit [columnIndex];
 	            }
 	        });
 	        activity_table.setColumnSelectionAllowed(true);
 	        jScrollPane1.setViewportView(activity_table);
 	        activity_table.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

 	        GroupLayout DashBordLayout = new GroupLayout(DashBord);
 	        DashBord.setLayout(DashBordLayout);
 	        DashBordLayout.setHorizontalGroup(
 	            DashBordLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
 	            .addGroup(DashBordLayout.createSequentialGroup()
 	                .addGroup(DashBordLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
 	                    .addGroup(DashBordLayout.createSequentialGroup()
 	                        .addGap(37, 37, 37)
 	                        .addComponent(last_connexion_date, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
 	                        .addGap(80, 80, 80)
 	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
 	                    .addGroup(DashBordLayout.createSequentialGroup()
 	                        .addGap(212, 212, 212)
 	                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
 	                    .addGroup(DashBordLayout.createSequentialGroup()
 	                        .addGap(75, 75, 75)
 	                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE)))
 	                .addContainerGap(101, Short.MAX_VALUE))
 	        );
 	        DashBordLayout.setVerticalGroup(
 	            DashBordLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
 	            .addGroup(DashBordLayout.createSequentialGroup()
 	                .addGap(28, 28, 28)
 	                .addGroup(DashBordLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
 	                    .addComponent(last_connexion_date, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
 	                    .addComponent(jLabel2))
 	                .addGap(18, 18, 18)
 	                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
 	                .addGap(47, 47, 47)
 	                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
 	                .addContainerGap(200, Short.MAX_VALUE))
 	        );

 	        body.add(DashBord, BorderLayout.CENTER);

 	        getContentPane().add(body, BorderLayout.CENTER);

 	        pack();
 	        
 	       
 	      
 }
    
    Instant getLastConDate()
    {
 	   Instant lst_con_dat = null ;
    	try
    	{
    		PreparedStatement ps1 = con.prepareStatement("SELECT derniere_date_connexion FROM utilisateur WHERE username = ?");
    		ps1.setString(1, usrname);
    		ResultSet rs1 = ps1.executeQuery();
    		if(rs1.next())
    		{
    			 lst_con_dat = rs1.getTimestamp(1).toInstant();
    		}
    	}
    	catch (Exception e)
    	{
    		JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    	}
    	return lst_con_dat;
    }
    
  
    
                          
                       

 private void Home1ActionPerformed(ActionEvent evt) {                                      
     UserPage nwusp = new UserPage(usrname);
     nwusp.setVisible(true);
     Window win = SwingUtilities.getWindowAncestor(Home1);
     win.dispose();
 }                                     

 private void MessagesActionPerformed(ActionEvent evt) {                                         
     UserMessagePage usrmsgp = new UserMessagePage(usrname);
     usrmsgp.setVisible(true);
     Window win = SwingUtilities.getWindowAncestor(Messages);
     win.dispose();
 }                                        

 private void deconnexionActionPerformed(ActionEvent evt) {                                            
 	 Window wdws = SwingUtilities.getWindowAncestor(deconnexion);
      if(wdws != null)
      {
      	wdws.dispose();
      	LoginForm usrmsgp = new LoginForm();
        usrmsgp.setVisible(true);
      }
 }                                           

 private void ProjectsActionPerformed(ActionEvent evt) {                                         
     // TODO add your handling code here:
 }                                        

 private void RequestsActionPerformed(ActionEvent evt) {                                         
 	UserRequestPage usrmsgp = new UserRequestPage(usrname);
     usrmsgp.setVisible(true);
     Window win = SwingUtilities.getWindowAncestor(Requests);
     win.dispose();
 }                                        

 private void AgendaActionPerformed(ActionEvent evt) {                                       
     // TODO add your handling code here:
 } 
 private void InvitationActionPerformed(ActionEvent evt)
 {
 	UserInvitationPage usr_inv_page = new UserInvitationPage(usrname);
     usr_inv_page.setVisible(true);
     Window win = SwingUtilities.getWindowAncestor(Invitation);
     win.dispose();
 }
 
 


                   
 private JButton Agenda;
 private JPanel DashBord;
 private JPanel Header;
 private JButton Home1;
 private JLabel LOGO;
 private JPanel Menu;
 private JButton Messages;
 private JButton Projects;
 private JButton Requests;
 private JTable activity_table;
 private JPanel body;
 private JButton deconnexion;
 private JButton Invitation;
 private JLabel jLabel1;
 private JLabel jLabel2;
 private JLabel jLabel3;
 private JScrollPane jScrollPane1;
 private JLabel last_connexion_date;
 private JLabel userIcon;
 protected Instant last_con_date ;
 protected static String usrname ; 
 Connection con = Utilitaire.getConnection();
 
                  
 public static void main (String args[])
 {
 	UserPage nwusp = new UserPage("yasser_moujtahid");
     nwusp.setVisible(true);
 }
}