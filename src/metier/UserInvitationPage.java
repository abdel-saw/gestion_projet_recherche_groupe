package metier;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.*;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserInvitationPage extends JFrame {

    public UserInvitationPage(String Username) {
    	this.usrname = Username ;
    	 body = new JPanel();
         Header = new JPanel();
         LOGO = new JLabel();
         userIcon = new JLabel();
         usr_name_lab = new JLabel();
         Menu = new JPanel();
         Home1 = new JButton();
         Messages = new JButton();
         Projects = new JButton();
         Requests = new JButton();
         Agenda = new JButton();
         Invitation = new JButton();
         deconnexion = new JButton();
         DashBord = new JPanel();
         inv_lab = new JLabel();
         jScrollPane1 = new JScrollPane();
         inv_table = new JTable();
         jScrollPane2 = new JScrollPane();
         join_req_table = new JTable();
         proj_join_lab = new JLabel();

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

         usr_name_lab.setFont(new Font("Segoe UI Black", 3, 14)); 
         usr_name_lab.setForeground(new Color(255, 255, 255));
         usr_name_lab.setIcon(new ImageIcon(getClass().getResource("assets/icons8-user-30.png"))); 
         usr_name_lab.setText(usrname);

         GroupLayout HeaderLayout = new GroupLayout(Header);
         Header.setLayout(HeaderLayout);
         HeaderLayout.setHorizontalGroup(
             HeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGroup(HeaderLayout.createSequentialGroup()
                 .addGap(67, 67, 67)
                 .addComponent(LOGO, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                 .addGap(608, 608, 608)
                 .addComponent(usr_name_lab, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
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
                         .addComponent(usr_name_lab)))
                 .addContainerGap())
         );

         body.add(Header, BorderLayout.NORTH);

         Menu.setBackground(new Color(255, 255, 255));
         Menu.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
         Menu.setPreferredSize(new Dimension(180, 427));
         Menu.setLayout(new GridLayout(9, 0));

         Home1.setFont(new Font("Segoe UI", 1, 14)); 
         Home1.setBackground(new Color(255, 255, 255));
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
         Agenda.setBackground(new Color(255, 255, 255));
         Agenda.setForeground(new Color(153, 0, 204));
         Agenda.setText("Agenda");
         Agenda.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
         Agenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
         Agenda.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent evt) {
                 AgendaActionPerformed(evt);
             }
         });
         Menu.add(Agenda);

         Invitation.setBackground(new Color(153, 0, 204));
         Invitation.setFont(new Font("Segoe UI", 1, 14)); 
         Invitation.setForeground(new Color(255, 255, 255));
         Invitation.setText("Invitation");
         Invitation.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(153, 0, 204)));
         Invitation.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent evt)
 			{
 				InvitationActionPerformed(evt);
 			}
 		});
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

         inv_lab.setFont(new Font("Segoe UI Black", 3, 18)); 
         inv_lab.setForeground(new Color(153, 0, 204));
         inv_lab.setIcon(new ImageIcon(getClass().getResource("assets/invitation.png"))); 
         inv_lab.setText("Invitation table");

         jScrollPane1.setBackground(new Color(255, 255, 255));

         inv_table.setModel(new DefaultTableModel(
                 new Object [][] {
                     {"Idir", "Site_Builder", "Site_Builder", "10/05/2024"},
                     {"Zakariae", "Online_Rent_car", "Online_Rent Car_adm", "12/05/2024"},
                     {"Arnaud", "Blochain_for_vote", "Blockchain_for_vote_adm", "12/05/2024"},
                     {"Abdel", "AI_impact", "AI_impact", "10/05/2024"},
                     
                     
                 },
                 new String [] {
                     "Send by", "Project name", "Groupe", "date"
                 }
             ) {
                 Class[] types = new Class [] {
                     java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                 };
                 boolean[] canEdit = new boolean [] {
                     false, false, false, false
                 };

                 public Class getColumnClass(int columnIndex) {
                     return types [columnIndex];
                 }

                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                 }
             });
             inv_table.getTableHeader().setReorderingAllowed(false);
             inv_table.addMouseListener(new MouseAdapter() {
                 public void mouseClicked(MouseEvent evt) {
                     inv_tableMouseClicked(evt);
                 }
                 public void mouseEntered(MouseEvent evt) {
                     inv_tableMouseEntered(evt);
                 }
             });

         jScrollPane1.setViewportView(inv_table);
         inv_table.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

         jScrollPane2.setBackground(new Color(255, 255, 255));

         join_req_table.setModel(new DefaultTableModel(
             new Object [][] {
            	 {"E_com_platform", "E_com_platform", "pending", "12/05/2024"},
            	 {"Architecture_nouvelle", "Architecture_nouvelle_adm","refused", "10/05/2024"},
            	 {"Farm_investment", "Farm_investement", "pending","09/05/2024"},
            	 {"Mode_and_Art", "Model_and_Art_adm", "accepted", "10/05/2024"},
                 
             },
             new String [] {
                 "Relative project ", "Groupe", "state", "date"
             }
         ) {
             Class[] types = new Class [] {
                 java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
             };
             boolean[] canEdit = new boolean [] {
                 false, false, false, false
             };

             public Class getColumnClass(int columnIndex) {
                 return types [columnIndex];
             }

             public boolean isCellEditable(int rowIndex, int columnIndex) {
                 return canEdit [columnIndex];
             }
         });
         join_req_table.getTableHeader().setReorderingAllowed(false);
         join_req_table.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent evt) {
                 join_req_tableMouseClicked(evt);
             }
             public void mouseEntered(MouseEvent evt) {
                 join_req_tableMouseEntered(evt);
             }
         });
         jScrollPane2.setViewportView(join_req_table);
         join_req_table.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

         proj_join_lab.setFont(new Font("Segoe UI Black", 3, 18)); 
         proj_join_lab.setForeground(new Color(153, 0, 204));
         proj_join_lab.setIcon(new ImageIcon(getClass().getResource("assets/invitation.png"))); 
         proj_join_lab.setText("Project joining request");

         GroupLayout DashBordLayout = new GroupLayout(DashBord);
         DashBord.setLayout(DashBordLayout);
         DashBordLayout.setHorizontalGroup(
             DashBordLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGroup(GroupLayout.Alignment.TRAILING, DashBordLayout.createSequentialGroup()
                 .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addGroup(DashBordLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                     .addGroup(GroupLayout.Alignment.TRAILING, DashBordLayout.createSequentialGroup()
                         .addComponent(inv_lab, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                         .addGap(188, 188, 188))
                     .addGroup(GroupLayout.Alignment.TRAILING, DashBordLayout.createSequentialGroup()
                         .addComponent(proj_join_lab, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                         .addGap(182, 182, 182))))
             .addGroup(DashBordLayout.createSequentialGroup()
                 .addGroup(DashBordLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                     .addGroup(DashBordLayout.createSequentialGroup()
                         .addGap(46, 46, 46)
                         .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE))
                     .addGroup(DashBordLayout.createSequentialGroup()
                         .addGap(56, 56, 56)
                         .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)))
                 .addContainerGap(69, Short.MAX_VALUE))
         );
         DashBordLayout.setVerticalGroup(
             DashBordLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGroup(DashBordLayout.createSequentialGroup()
                 .addGap(15, 15, 15)
                 .addComponent(inv_lab, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                 .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                 .addGap(27, 27, 27)
                 .addComponent(proj_join_lab)
                 .addGap(18, 18, 18)
                 .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(16, Short.MAX_VALUE))
         );

         body.add(DashBord, BorderLayout.CENTER);

         getContentPane().add(body, BorderLayout.CENTER);

         pack();
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
    private void inv_tableMouseClicked(MouseEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void inv_tableMouseEntered(MouseEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void join_req_tableMouseClicked(MouseEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void join_req_tableMouseEntered(MouseEvent evt) {                                            
        // TODO add your handling code here:
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
    private JPanel body;
    private JButton deconnexion;
    private JButton Invitation;
    private JLabel usr_name_lab;
    private JLabel inv_lab;
    private JLabel proj_join_lab;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable inv_table;
    private JTable join_req_table;
    private JLabel userIcon;
    protected String usrname ;
                      
    
  /*  public static void main (String args[])
    {
    	UserInvitationPage ursinv = new UserInvitationPage("test");
    	ursinv.setVisible(true);
    }*/
}