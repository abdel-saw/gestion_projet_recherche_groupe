package metier;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GuestPage extends JFrame {
    private JPanel body = new JPanel();
    private JPanel Header = new JPanel();
    private JLabel LOGO = new JLabel();
    private JLabel Username = new JLabel();
    private JLabel jLabel1 = new JLabel();
    private JPanel Menu = new JPanel();
    private JButton Agenda = new JButton();
    private JButton Home1 = new JButton();
    private JButton Messages = new JButton();
    private JButton Projects = new JButton();
    private JButton Requests = new JButton();
    private JButton deconnexion = new JButton();
    
    public GuestPage(String username) {
        GridBagConstraints gridBagConstraints;
        
        TableWithButtonPanel mainTable = new TableWithButtonPanel(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1050, 650));
        setLocationRelativeTo(null);

        body.setBackground(new Color(255, 255, 255));
        body.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(153,0,204)));
        body.setLayout(new BorderLayout());

        Header.setBackground(new Color(153, 0, 204));

        LOGO.setFont(new Font("Montserrat Black", 3, 24));
        LOGO.setForeground(new Color(255, 255, 255));
        LOGO.setText("P4P");

        Username.setFont(new Font("Segoe UI", 1, 14));
        Username.setForeground(new Color(255, 255, 255));
        Username.setHorizontalAlignment(SwingConstants.CENTER);
        Username.setText(username);
        Username.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Username.setHorizontalTextPosition(SwingConstants.CENTER);
        Username.setIconTextGap(1);
        

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setIcon(new ImageIcon(getClass().getResource("assets/icons8-user-30.png")));
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);

        GroupLayout HeaderLayout = new GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(LOGO, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addGap(625, 625, 625)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Username)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(LOGO, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            .addComponent(Username, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        );

        body.add(Header, BorderLayout.NORTH);
        
        
        /////////////////////////////////////////////////////////////////////////////////
        mainTable.setBackground(new Color(255, 255, 255));
        mainTable.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        
        
        body.add(mainTable, BorderLayout.CENTER);

        Menu.setBackground(new Color(255, 255, 255));
        Menu.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Menu.setPreferredSize(new Dimension(180, 427));
        Menu.setLayout(new GridBagLayout());

        Agenda.setFont(new Font("Segoe UI", 1, 14));
        Agenda.setForeground(new Color(153, 0, 204));
        Agenda.setText("Agenda");
        Agenda.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Agenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Agenda.setBackground(new Color(255, 255, 255));
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 126;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(0, 0, 192, 0);
        Menu.add(Agenda, gridBagConstraints);

        Home1.setBackground(new Color(153, 0, 204));
        Home1.setFont(new Font("Segoe UI", 1, 14));
        Home1.setForeground(new Color(255, 255, 255));
        Home1.setText("Home");
        Home1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        Home1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 137;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        Menu.add(Home1, gridBagConstraints);

        Messages.setFont(new Font("Segoe UI", 1, 14));
        Messages.setBackground(new Color(255, 255, 255));
        Messages.setForeground(new Color(153, 0, 204));
        Messages.setText("Messages");
        Messages.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Messages.setCursor(new Cursor(Cursor.HAND_CURSOR));
        

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        Menu.add(Messages, gridBagConstraints);

        Projects.setFont(new Font("Segoe UI", 1, 14));
        Projects.setBackground(new Color(255, 255, 255));
        Projects.setForeground(new Color(153, 0, 204));
        Projects.setText("Projects");
        Projects.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Projects.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        /*
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        Menu.add(Projects, gridBagConstraints);

        Requests.setFont(new Font("Segoe UI", 1, 14));
        Requests.setBackground(new Color(255, 255, 255));
        Requests.setForeground(new Color(153, 0, 204));
        Requests.setText("Requests");
        Requests.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 204)));
        Requests.setCursor(new Cursor(Cursor.HAND_CURSOR));*/
        
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        
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
        
        Menu.add(deconnexion, gridBagConstraints);
        

        body.add(Menu, BorderLayout.WEST);

        getContentPane().add(body, BorderLayout.CENTER);

        pack();
    }
    
    public void setUsername(String name){
        Username.setText(name);
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
        
        GuestPage gp = new GuestPage("guest");
        gp.setVisible(true);
        gp.setLocationRelativeTo(null);
    }

                       
}
