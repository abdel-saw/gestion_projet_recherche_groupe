package metier;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HomePage extends JFrame {
    private JLabel Username;
    public HomePage() {
        GridBagConstraints gridBagConstraints;
        JPanel body = new JPanel();
        JPanel Header = new JPanel();
        JLabel LOGO = new JLabel();
        JLabel Username = new JLabel();
        JLabel jLabel1 = new JLabel();
        JPanel Menu = new JPanel();
        JButton Agenda = new JButton();
        JButton Home1 = new JButton();
        JButton Messages = new JButton();
        JButton Projects = new JButton();
        JButton Requests = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 500));

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
        Username.setText("Username_XXXXX");
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
        gridBagConstraints.gridy = 4;
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
        Requests.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 119;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        Menu.add(Requests, gridBagConstraints);

        body.add(Menu, BorderLayout.WEST);

        getContentPane().add(body, BorderLayout.CENTER);

        pack();
    }
    
    public void setUsername(String name){
        Username.setText(name);
    }

                                   
    public static void main(String args[]) {
        
        new HomePage().setVisible(true);
    }

                       
}
