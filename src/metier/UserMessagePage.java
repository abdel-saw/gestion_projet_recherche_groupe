package metier;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.table.*;
public class UserMessagePage extends JFrame {
	private int iduser;

    
    public UserMessagePage(int iduser, String username) {
        GridBagConstraints gridBagConstraints;
        this.usrname_var = username ;
        this.iduser = iduser;

        body = new JPanel();
        Header = new JPanel();
        LOGO = new JLabel();
        userIcon = new JLabel();
        usrname = new JLabel();
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
        message_table = new JTable();
       

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

        usrname.setFont(new Font("Segoe UI Black", 3, 14)); 
        usrname.setForeground(new Color(255, 255, 255));
        usrname.setIcon(new ImageIcon(getClass().getResource("assets/icons8-user-30.png"))); 
        usrname.setText(usrname_var);

        GroupLayout HeaderLayout = new GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(LOGO, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addGap(608, 608, 608)
                .addComponent(usrname, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(usrname)))
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

        Messages.setBackground(new Color(153, 0, 204));
        Messages.setFont(new Font("Segoe UI", 1, 14)); 
        Messages.setForeground(new Color(255, 255, 255));
        Messages.setText("Messages");
        Messages.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Messages.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Messages.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MessagesActionPerformed(evt);
            }
        });
        Menu.add(Messages);
        
        Requests.setFont(new Font("Segoe UI", 1, 14)); 
        Requests.setForeground(new Color(153, 0, 204));
        Requests.setBackground(new Color(255, 255, 255));
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
        deconnexion.setText("Se_deconnecter");
        deconnexion.setBackground(new Color(255, 255, 255));
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
        jLabel3.setIcon(new ImageIcon(getClass().getResource("assets/mail.png"))); 
        jLabel3.setText("WELCOME TO YOUR MESSAGE BOX");

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

        public Vector<UserMessage> getUserMessage() {
            Vector<UserMessage> ursmsglst = new Vector<UserMessage>();
            try {
                PreparedStatement ps1 = con.prepareStatement("SELECT IdUtilisateur FROM utilisateur WHERE username = ?");
                ps1.setString(1, usrname_var);
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) { // Assurez-vous d'avoir un résultat avant de continuer
                    int idUtilisateur = rs1.getInt("IdUtilisateur");
                    PreparedStatement ps2 = con.prepareStatement("SELECT idSender, date_envoi, heure_envoi, contenu, idProjet FROM message WHERE idReceiver = ?");
                    ps2.setInt(1, idUtilisateur);
                    ResultSet rs2 = ps2.executeQuery();

                    while (rs2.next()) {
                        int idSender = rs2.getInt("idSender");
                        Date dateEnvoi = rs2.getDate("date_envoi");
                        Time heureEnvoi = rs2.getTime("heure_envoi");
                        String contenu = rs2.getString("contenu");
                        int idProjet = rs2.getInt("idProjet");

                        PreparedStatement ps3 = con.prepareStatement("SELECT username FROM utilisateur WHERE IdUtilisateur = ?");
                        ps3.setInt(1, idSender);
                        ResultSet rs3 = ps3.executeQuery();
                        rs3.next(); // Récupère le nom d'utilisateur de l'expéditeur

                        PreparedStatement ps4 = con.prepareStatement("SELECT nom_long FROM projet WHERE IdProjet = ?");
                        ps4.setInt(1, idProjet);
                        ResultSet rs4 = ps4.executeQuery();
                        rs4.next(); // Récupère le nom du projet

                        ursmsglst.add(new UserMessage(rs3.getString("username"), dateEnvoi, heureEnvoi, contenu, rs4.getString("nom_long")));
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            return ursmsglst;
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        public void initialiserTable() {
            // Définissez le modèle de table avec les données récupérées
        	
            DefaultTableModel model = new DefaultTableModel(new Object[]{"Expéditeur", "Date d'envoi", "Heure d'envoi", "Projet"}, 0) {
                Class[] types = new Class[]{
                        java.lang.String.class, java.sql.Date.class, java.sql.Time.class, java.lang.String.class
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

            user_message_list = getUserMessage();
            
            for (UserMessage m : user_message_list) {
                model.addRow(new Object[]{m.getSender(), m.getDate_envoi(), m.getHeure_envoie(), m.getGroupe_name()});
            }

            message_table.setModel(model);
            message_table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    int row = message_table.rowAtPoint(evt.getPoint());
                    if (row >= 0) {
                        String contenu = user_message_list.get(row).getContent();
                        String sender = user_message_list.get(row).getSender();
                        String project_name = user_message_list.get(row).getGroupe_name();
                        new MessageShowPage(contenu,sender,usrname_var,project_name).setVisible(true);
                    }
                }
            });
            
            jScrollPane1.setViewportView(message_table);
        }
                             
  

        private void Home1ActionPerformed(ActionEvent evt) {                                      
            HomePageUser nwusp = new HomePageUser(iduser, usrname_var);
            nwusp.setVisible(true);
            nwusp.setLocationRelativeTo(null);
            nwusp.setSize(1050, 650);
            Window win = SwingUtilities.getWindowAncestor(Home1);
            win.dispose();
        }                                     

        private void MessagesActionPerformed(ActionEvent evt) {                                         
            UserMessagePage usrmsgp = new UserMessagePage(iduser, usrname_var);
            usrmsgp.setVisible(true);
            usrmsgp.setSize(1050, 650);
            usrmsgp.setLocationRelativeTo(null);
           
            Window win = SwingUtilities.getWindowAncestor(Messages);
            win.dispose();
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

        private void ProjectsActionPerformed(ActionEvent evt) {                                         
            Projects pp = new Projects(iduser, usrname_var);
            pp.setVisible(true);
            pp.setSize(1050, 650);
            pp.setLocationRelativeTo(null);
            Window win =SwingUtilities.getWindowAncestor(Projects);
            win.dispose();
        }                                        

        private void RequestsActionPerformed(ActionEvent evt) {                                         
        	UserRequests usrmsgp = new UserRequests(iduser, usrname_var);
            usrmsgp.setVisible(true);
            usrmsgp.setSize(1050, 650);
            usrmsgp.setLocationRelativeTo(null);
            Window win = SwingUtilities.getWindowAncestor(Requests);
            win.dispose();
        }                                        

        private void AgendaActionPerformed(ActionEvent evt) {    
        	
            UserAgendaPage usrp = new UserAgendaPage(iduser, usrname_var);
            usrp.setVisible(true);
            usrp.setSize(1050, 650);
            usrp.setLocationRelativeTo(null);
            Window win = SwingUtilities.getWindowAncestor(Agenda);
            win.dispose();
            
            
        } 
        private void InvitationActionPerformed(ActionEvent evt)
        {
        	Invitation_demande usr_inv_page = new Invitation_demande(iduser, usrname_var);
            usr_inv_page.setVisible(true);
            usr_inv_page.setLocationRelativeTo(null);
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
    private JLabel usrname;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JTable message_table;
    private JLabel userIcon;
    protected String usrname_var ;
    protected Vector<UserMessage> user_message_list ;
    public static Connection con = Utilitaire.getConnection();
    
    public static void main (String args[])
    {
    	UserMessagePage usr = new UserMessagePage(8, "yasser_moujtahid");
    	usr.setVisible(true);
    }
                      
    
}