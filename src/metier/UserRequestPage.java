package metier;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;


public class UserRequestPage extends JFrame {

        public UserRequestPage(String username) {
        	 java.awt.GridBagConstraints gridBagConstraints;
        	 this.username_var = username;

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
             jLabel3 = new JLabel();
             jScrollPane1 = new JScrollPane();
             request_table = new JTable();

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
             jLabel1.setText(username_var);

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

             Home1.setFont(new Font("Segoe UI", 1, 14)); 
             Home1.setForeground(new Color(153, 0, 204));
             Home1.setBackground(new Color(255, 255, 255));
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
             Messages.setForeground(new Color(153, 0, 204));
             Messages.setBackground(new Color(255, 255, 255));
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
             Projects.setForeground(new Color(153, 0, 204));
             Projects.setBackground(new Color(255, 255, 255));
             Projects.setText("Projects");
             Projects.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
             Projects.setCursor(new Cursor(Cursor.HAND_CURSOR));
             Projects.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent evt) {
                     ProjectsActionPerformed(evt);
                 }
             });
             Menu.add(Projects);

             Requests.setBackground(new Color(153, 0, 204));
             Requests.setFont(new Font("Segoe UI", 1, 14)); 
             Requests.setForeground(new Color(255, 255, 255));
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
             Invitation.setForeground(new Color(153, 0, 204));
             Invitation.setBackground(new Color(255, 255, 255));
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
             deconnexion.setForeground(new Color(153, 0, 204));
             deconnexion.setBackground(new Color(255, 255, 255));
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

             jLabel3.setFont(new Font("Segoe UI Black", 3, 18)); 
             jLabel3.setForeground(new Color(153, 0, 204));
             jLabel3.setIcon(new ImageIcon(getClass().getResource("assets/request.png"))); 
             jLabel3.setText("REQUEST TABLE");

             jScrollPane1.setBackground(new Color(255, 255, 255));

             

             GroupLayout DashBordLayout = new GroupLayout(DashBord);
             DashBord.setLayout(DashBordLayout);
             DashBordLayout.setHorizontalGroup(
                 DashBordLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                 .addGroup(DashBordLayout.createSequentialGroup()
                     .addGroup(DashBordLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                         .addGroup(DashBordLayout.createSequentialGroup()
                             .addGap(157, 157, 157)
                             .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE))
                         .addGroup(DashBordLayout.createSequentialGroup()
                             .addGap(41, 41, 41)
                             .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)))
                     .addContainerGap(72, Short.MAX_VALUE))
             );
             DashBordLayout.setVerticalGroup(
                 DashBordLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                 .addGroup(DashBordLayout.createSequentialGroup()
                     .addGap(31, 31, 31)
                     .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                     .addGap(53, 53, 53)
                     .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                     .addContainerGap(222, Short.MAX_VALUE))
             );

             body.add(DashBord, BorderLayout.CENTER);

             getContentPane().add(body, BorderLayout.CENTER);

           pack();
           initialiserTable();
    }
                         
        public Vector<UserRequest> getUserRequest() {
            Vector<UserRequest> usr_req_list = new Vector<UserRequest>();
            try {
                PreparedStatement ps1 = con.prepareStatement("SELECT IdUtilisateur FROM utilisateur WHERE username = ?");
                ps1.setString(1, username_var);
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) { // Assurez-vous d'avoir un résultat avant de continuer
                    int idUtilisateur = rs1.getInt("IdUtilisateur");
                    PreparedStatement ps2 = con.prepareStatement("SELECT nom_long_projet, description_projet, projet_is_public, etat, type, date_demande FROM demande WHERE IdUtilisateur = ?");
                    ps2.setInt(1, idUtilisateur);
                    ResultSet rs2 = ps2.executeQuery();

                    while (rs2.next())
                    {
                        usr_req_list.add(new UserRequest(rs2.getString("nom_long_projet"), rs2.getString("description_projet"), rs2.getBoolean("projet_is_public"), rs2.getDate("date_demande"), rs2.getString("type"),rs2.getString("etat")));
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            return usr_req_list;
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        public void initialiserTable() {
            // Définissez le modèle de table avec les données récupérées
        	
            DefaultTableModel model = new DefaultTableModel(new Object[]{"project name", "type", "state", "date"}, 0) {
                Class[] types = new Class[]{
                        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.sql.Date.class
                };
                boolean[] canEdit = new boolean[]{
                        false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };

            user_request_list = getUserRequest();
            
            for (UserRequest r : user_request_list) {
                model.addRow(new Object[]{r.getNom_long(), r.getType(), r.getEtat(),r.getDate()});
            }

            request_table.setModel(model);
            request_table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    int row = request_table.rowAtPoint(evt.getPoint());
                    if (row >= 0) {
                        String contenu = user_request_list.get(row).getDescription();
                        String proj_name = user_request_list.get(row).getNom_long();
                        String proj_type = user_request_list.get(row).getType();
                        new RequestShowPage(contenu,proj_name,proj_type).setVisible(true);
                    }
                }
            });
            
            jScrollPane1.setViewportView(request_table);
        }

        private void Home1ActionPerformed(ActionEvent evt) {                                      
            UserPage nwusp = new UserPage(username_var);
            nwusp.setVisible(true);
            Window win = SwingUtilities.getWindowAncestor(Home1);
            win.dispose();
        }                                     

        private void MessagesActionPerformed(ActionEvent evt) {                                         
            UserMessagePage usrmsgp = new UserMessagePage(username_var);
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
        	UserRequestPage usrmsgp = new UserRequestPage(username_var);
            usrmsgp.setVisible(true);
            Window win = SwingUtilities.getWindowAncestor(Requests);
            win.dispose();
        }                                        

        private void AgendaActionPerformed(ActionEvent evt) {                                       
            // TODO add your handling code here:
        } 
        private void InvitationActionPerformed(ActionEvent evt)
        {
        	UserInvitationPage usr_inv_page = new UserInvitationPage(username_var);
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
    private JPanel body;
    private JButton deconnexion;
    private JButton Invitation;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JTable request_table;
    private JLabel userIcon;
    protected String username_var ;
    protected Vector<UserRequest> user_request_list ;
    public static Connection con = Utilitaire.getConnection();
    
    public static void main (String args[])
    {
    	new UserRequestPage ("yasser_moujtahid").setVisible(true); 
    }
    
 
                     
}