package metier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class HomePageAdmin extends JFrame {
	
	Connection conn = Utilitaire.getConnection();
	private String username;
	private JProgressBar ARprogress;
    private JLabel AcceptedRequests;
    private JButton deconnexion;
    private JProgressBar ClosedProgress;
    private JLabel Closedprojects;
    private JPanel DashBord;
    private JPanel DemandesStatis;
    private JLabel EnabledPr;
    private JProgressBar EnabledProgress;
    private JLabel H1DemSt;
    private JLabel H1ProjectsSt;
    private JLabel H1ProjetProgress;
    private JLabel H1UserSt;
    private JPanel Header;
    private JButton Home1;
    private JLabel IconDSt;
    private JLabel IconPSt;
    private JLabel IconUSt;
    private JLabel LOGO;
    private JPanel Menu;
    private JButton Messages;
    private JProgressBar PRprogress;
    private JLabel PendingRequests;
    private JButton Projects;
    private JPanel ProjectsStatis;
    private JProgressBar RRprogress;
    private JLabel RejectedRequests;
    private JButton Requests;
    private JPanel UserStatis;
    private JLabel Username;
    private JButton Users;
    private JPanel body;
    private JLabel nbrDemandes;
    private JLabel nbrProjects;
    private JLabel nbrUsers;
    private JPanel projectStaticsProgress;
    private JPanel requestStaticsProgress;
    private JLabel requestStaticsh1;
    private JLabel userIcon;
    public HomePageAdmin(String username) {
    	
    	
        GridBagConstraints gridBagConstraints;
        this.username = username;
        
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
        deconnexion = new JButton();
        DashBord = new JPanel(); 
        UserStatis = new JPanel();
        IconUSt = new JLabel();
        H1UserSt = new JLabel();
        nbrUsers = new JLabel();
        ProjectsStatis = new JPanel();
        H1ProjectsSt = new JLabel();
        nbrProjects = new JLabel();
        IconPSt = new JLabel();
        DemandesStatis = new JPanel();
        H1DemSt = new JLabel();
        nbrDemandes = new JLabel();
        IconDSt = new JLabel();
        projectStaticsProgress = new JPanel();
        EnabledPr = new JLabel();
        H1ProjetProgress = new JLabel();
        EnabledProgress = new JProgressBar();
        Closedprojects = new JLabel();
        ClosedProgress = new JProgressBar();
        requestStaticsProgress = new JPanel();
        requestStaticsh1 = new JLabel();
        AcceptedRequests = new JLabel();
        ARprogress = new JProgressBar();
        RejectedRequests = new JLabel();
        RRprogress = new JProgressBar();
        PendingRequests = new JLabel();
        PRprogress = new JProgressBar();
        
        nbrUsers.setText(getNnbUsers());;
        nbrProjects.setText(getNnbProjet());
        nbrDemandes.setText(getNnbDemande());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1050, 650));
        body.setBackground(new Color(255, 255, 255));
        body.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(153,0,204)));
        body.setLayout(new BorderLayout());

        Header.setBackground(new java.awt.Color(153, 0, 204));
        Header.setLayout(new java.awt.GridBagLayout());

        LOGO.setFont(new java.awt.Font("Montserrat Black", 3, 24)); // NOI18N
        LOGO.setForeground(new java.awt.Color(255, 255, 255));
        LOGO.setText("P4P");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 65, 0, 0);
        Header.add(LOGO, gridBagConstraints);

        Username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username.setText(username + "-adm");
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
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 51);
        Header.add(Username, gridBagConstraints);

        userIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/icons8-user-30.png")));
        userIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 625, 0, 0);
        Header.add(userIcon, gridBagConstraints);

        body.add(Header, BorderLayout.NORTH);

        Menu.setBackground(new Color(255, 255, 255));
        Menu.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Menu.setPreferredSize(new Dimension(180, 427));
        Menu.setLayout(new GridLayout(8, 0));

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

        Users.setFont(new Font("Segoe UI", 1, 14)); 
        Users.setBackground(Color.white);
        Users.setForeground(new Color(153, 0, 204));
        Users.setText("Users");
        Users.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Users.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Users.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UsersActionPerformed(evt);
            }
        });
        Menu.add(Users);

        Projects.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        Projects.setForeground(new Color(153, 0, 204));
        Projects.setBackground(Color.white);
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
        Requests.setBackground(Color.white);
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
        DashBord.setLayout(new GridBagLayout());

        UserStatis.setBackground(new Color(102, 0, 204));
        UserStatis.setLayout(new GridBagLayout());

        IconUSt.setIcon(new ImageIcon(getClass().getResource("assets/icons8-user-30.png"))); // NOI18N
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 28, 0, 0);
        UserStatis.add(IconUSt, gridBagConstraints);

        H1UserSt.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        H1UserSt.setForeground(new Color(255, 255, 255));
        H1UserSt.setText("Users");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 7, 0, 30);
        UserStatis.add(H1UserSt, gridBagConstraints);

        nbrUsers.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        nbrUsers.setForeground(new Color(255, 255, 255));
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(17, 25, 11, 0);
        UserStatis.add(nbrUsers, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(35, 30, 0, 0);
        DashBord.add(UserStatis, gridBagConstraints);

        ProjectsStatis.setBackground(new Color(102, 0, 204));
        ProjectsStatis.setLayout(new GridBagLayout());

        H1ProjectsSt.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        H1ProjectsSt.setForeground(new Color(255, 255, 255));
        H1ProjectsSt.setText("Projects");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 62, 0, 14);
        ProjectsStatis.add(H1ProjectsSt, gridBagConstraints);

        nbrProjects.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        nbrProjects.setForeground(new Color(255, 255, 255));
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(17, 25, 11, 0);
        ProjectsStatis.add(nbrProjects, gridBagConstraints);

        IconPSt.setIcon(new ImageIcon(getClass().getResource("assets/icons8-project-30.png"))); // NOI18N
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 28, 0, 0);
        ProjectsStatis.add(IconPSt, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(35, 45, 0, 0);
        DashBord.add(ProjectsStatis, gridBagConstraints);

        DemandesStatis.setBackground(new Color(102, 0, 204));
        DemandesStatis.setLayout(new GridBagLayout());

        H1DemSt.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        H1DemSt.setForeground(new Color(255, 255, 255));
        H1DemSt.setText("Requests");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 53, 0, 10);
        DemandesStatis.add(H1DemSt, gridBagConstraints);

        nbrDemandes.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        nbrDemandes.setForeground(new Color(255, 255, 255));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(17, 25, 10, 0);
        DemandesStatis.add(nbrDemandes, gridBagConstraints);

        IconDSt.setIcon(new ImageIcon(getClass().getResource("assets/icons8-code-fork-30 (1).png"))); // NOI18N
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 28, 0, 0);
        DemandesStatis.add(IconDSt, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(35, 45, 0, 23);
        DashBord.add(DemandesStatis, gridBagConstraints);

        projectStaticsProgress.setBackground(new Color(102, 0, 204));
        projectStaticsProgress.setLayout(new GridBagLayout());

        EnabledPr.setFont(new Font("Segoe UI", 1, 16));
        EnabledPr.setForeground(new Color(255, 255, 255));
        EnabledPr.setText("Enabled Projects");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 27, 0, 0);
        projectStaticsProgress.add(EnabledPr, gridBagConstraints);

        H1ProjetProgress.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        H1ProjetProgress.setForeground(new Color(255, 255, 255));
        H1ProjetProgress.setText("Projects Statistics");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(15, 62, 0, 0);
        projectStaticsProgress.add(H1ProjetProgress, gridBagConstraints);

        EnabledProgress.setBackground(new Color(255, 255, 255));
        EnabledProgress.setForeground(new Color(34,133,225));
        EnabledProgress.setValue(0);
        EnabledProgress.setStringPainted(true);
        EnabledProgress.setString(this.getNbrProjet_Par_Etat("Enabled"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 213;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(16, 37, 0, 30);
        projectStaticsProgress.add(EnabledProgress, gridBagConstraints);

        Closedprojects.setFont(new Font("Segoe UI", 1, 16));
        Closedprojects.setForeground(new Color(255, 255, 255));
        Closedprojects.setText("Closed projects");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 27, 0, 0);
        projectStaticsProgress.add(Closedprojects, gridBagConstraints);

        ClosedProgress.setBackground(new Color(255, 255, 255));
        ClosedProgress.setForeground(new Color(34,133,225));
        ClosedProgress.setValue(0);
        ClosedProgress.setStringPainted(true);
        ClosedProgress.setString(getNbrProjet_Par_Etat("Closed"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 213;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 37, 52, 30);
        projectStaticsProgress.add(ClosedProgress, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(30, 70, 64, 0);
        DashBord.add(projectStaticsProgress, gridBagConstraints);

        requestStaticsProgress.setBackground(new Color(102, 0, 204));
        requestStaticsProgress.setLayout(new GridBagLayout());

        requestStaticsh1.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        requestStaticsh1.setForeground(new Color(255, 255, 255));
        requestStaticsh1.setText("Requests Statistics");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 59, 0, 0);
        requestStaticsProgress.add(requestStaticsh1, gridBagConstraints);

        AcceptedRequests.setFont(new Font("Segoe UI", 1, 16));
        AcceptedRequests.setForeground(new Color(255, 255, 255));
        AcceptedRequests.setText("Accepted  Requests");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(4, 28, 0, 0);
        requestStaticsProgress.add(AcceptedRequests, gridBagConstraints);

        ARprogress.setBackground(new Color(255, 255, 255));
        ARprogress.setSize(140, 5);
        ARprogress.setValue(0);
        ARprogress.setStringPainted(true);;
        ARprogress.setForeground(new Color(34,133,225));
        ARprogress.setString(this.getNbrD_Par_Etat("Accepted"));
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 213;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 42, 0, 25);
        requestStaticsProgress.add(ARprogress, gridBagConstraints);

        RejectedRequests.setFont(new Font("Segoe UI", 1, 16));
        RejectedRequests.setForeground(new Color(255, 255, 255));
        RejectedRequests.setText("Rejected Requests");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 28, 0, 0);
        requestStaticsProgress.add(RejectedRequests, gridBagConstraints);

        RRprogress.setBackground(new Color(255, 255, 255));
        RRprogress.setSize(140, 5);
        RRprogress.setValue(0);
        RRprogress.setStringPainted(true);
        RRprogress.setForeground(new Color(34,133,225));
        RRprogress.setString(this.getNbrD_Par_Etat("Refused"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 213;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 42, 0, 25);
        requestStaticsProgress.add(RRprogress, gridBagConstraints);

        PendingRequests.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
        PendingRequests.setForeground(new Color(255, 255, 255));
        PendingRequests.setText("Pending Requests");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 28, 0, 0);
        requestStaticsProgress.add(PendingRequests, gridBagConstraints);

        PRprogress.setBackground(new Color(255, 255, 255));
        PRprogress.setSize(140, 5);
        PRprogress.setValue(0);
        PRprogress.setStringPainted(true);
        PRprogress.setForeground(new Color(34,133,225));
        PRprogress.setString(this.getNbrD_Par_Etat("Pending"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 213;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 42, 23, 25);
        requestStaticsProgress.add(PRprogress, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(30, 70, 64, 0);
        DashBord.add(requestStaticsProgress, gridBagConstraints);

        body.add(DashBord, BorderLayout.CENTER);

        getContentPane().add(body, BorderLayout.CENTER);
        double Arprog = getProgressDemandes("Accepted");
        double Prprog = getProgressDemandes("Pending");
        double Rrprog = getProgressDemandes("Refused");
        double ap = getProgressProjet("Closed");
        double ep = getProgressProjet("Enabled");
        Timer timer = new Timer(1, e -> {
            if (ARprogress.getValue() < Arprog) {
            	ARprogress.setValue(ARprogress.getValue() + 1);
            }
            if (PRprogress.getValue() < Prprog) {
            	PRprogress.setValue(PRprogress.getValue() + 1);
            }
            if (RRprogress.getValue() < Rrprog) {
            	RRprogress.setValue(RRprogress.getValue() + 1);
            }
            if (ClosedProgress.getValue() < ap) {
            	ClosedProgress.setValue(ClosedProgress.getValue() + 1);
            }
            if (EnabledProgress.getValue() < ep) {
            	EnabledProgress.setValue(EnabledProgress.getValue() + 1);
            }
            if (ARprogress.getValue() >= Arprog && PRprogress.getValue() >= Prprog && RRprogress.getValue() >= Rrprog && ClosedProgress.getValue() >= ap && EnabledProgress.getValue() >= ep) {
                ((Timer) e.getSource()).stop();
            }
        });

        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {
                timer.start();
            }

            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                timer.stop();
            }
        });
    }
    private void UsernameMouseClicked(MouseEvent evt) {
    	Profile pl= new Profile(username);
    	pl.setSize(800, 500);
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

	public String getNnbUsers() {
    	try {
    		String requete = "SELECT COUNT(*)AS nbrUsers FROM utilisateur";
    		Statement s = conn.createStatement();
    		ResultSet rs = s.executeQuery(requete);
    		if(rs.next()) {
    			return rs.getString("nbrUsers");
    		}
    	}catch(SQLException s) {
    		System.out.println(s.getMessage());
    	}
		return null;
    }
    
    public String getNnbProjet() {
    	try {
    		String requete = "SELECT COUNT(*)AS nbrProjet FROM projet";
    		Statement s = conn.createStatement();
    		ResultSet rs = s.executeQuery(requete);
    		if(rs.next()) {
    			return rs.getString("nbrProjet");
    		}
    	}catch(SQLException s) {
    		System.out.println(s.getMessage());
    	}
		return null;
    }
    
    public String getNnbDemande() {
    	try {
    		String requete = "SELECT COUNT(*) AS nbrDemandes FROM demande";
    		Statement s = conn.createStatement();
    		ResultSet rs = s.executeQuery(requete);
    		if(rs.next()) {
    			return rs.getString("nbrDemandes");
    		}
    	}catch(SQLException s) {
    		System.out.println(s.getMessage());
    	}
		return null;
    }
    public double getProgressProjet(String etat) {
    	try {
    		PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) * 100.0 / (SELECT COUNT(*) FROM projet) AS pourcentage FROM projet WHERE etat = ?");
    		ps.setString(1, etat);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			return rs.getDouble("pourcentage");
    		}
    		}catch(SQLException s) {
    			System.out.println(s.getMessage());
    		}
    	return 0;
    }
    
    public double getProgressDemandes(String etat) {
    	try {
    		PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) * 100.0 / (SELECT COUNT(*) FROM demande) AS pourcentageD FROM demande WHERE etat = ?");
    		ps.setString(1, etat);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			return rs.getDouble(("pourcentageD"));
    		}
    		}catch(SQLException s) {
    			System.out.println(s.getMessage());
    		}
    	return 0;
    }
    
    public void animateProgressBar(JProgressBar jp,Timer timer) {
    	double progressValue = 0;
                 progressValue+=1.0;
                 jp.setValue((int)progressValue);
                 if (progressValue >= jp.getValue()) {
                     timer.stop();
                 }              
}
    public String getNbrProjet_Par_Etat(String etat) {
    	String query = "SELECT COUNT(*) AS nbrP FROM projet WHERE etat = ?";
    	try {
    		PreparedStatement ps = conn.prepareStatement(query);
    		ps.setString(1, etat);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			return rs.getString("nbrP");
    		}
    		
    	}catch(SQLException s) {
    		System.out.println(s.getMessage());
    	}
    	return null;
    }
    public String getNbrD_Par_Etat(String etat) {
    	String query = "SELECT COUNT(*) AS nbrD FROM demande WHERE etat = ?";
    	try {
    		PreparedStatement ps = conn.prepareStatement(query);
    		ps.setString(1, etat);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			return rs.getString("nbrD");
    		}
    		
    	}catch(SQLException s) {
    		System.out.println(s.getMessage());
    	}
    	return null;
    }

    public static void main(String args[]) {
        HomePageAdmin p = new HomePageAdmin("oubeza_idir");
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        p.setSize(1050, 650);
    }
}
