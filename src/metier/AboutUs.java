package metier;
import javax.swing.*;
import java.awt.*;
public class AboutUs extends JFrame {
	private JLabel aboutUs;
    private JTextArea aboutUsp;
    private JPanel body;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JScrollPane jScrollPane1;
    private JLabel ourTeam;
    private JLabel pictures; 
    public AboutUs() {
        
        GridBagConstraints gridBagConstraints;

        body = new JPanel();
        ourTeam = new JLabel();
        jScrollPane1 = new JScrollPane();
        aboutUsp = new JTextArea();
        aboutUs = new JLabel();
        pictures = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        body.setBackground(Color.white);
        body.setLayout(new GridBagLayout());

        ourTeam.setFont(new Font("Segoe UI", 1, 24)); 
        ourTeam.setForeground(new Color(153, 0, 0));
        ourTeam.setText("Our Team");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 140, 0, 0);
        body.add(ourTeam, gridBagConstraints);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setFont(new Font("Segoe UI", 0, 14)); 

        aboutUsp.setEditable(false);
        aboutUsp.setBackground(Color.white);
        aboutUsp.setFont(new Font("Segoe UI", 0, 16)); 
        aboutUsp.setLineWrap(true);
        aboutUsp.setText("Welcome to our project management platform, designed to streamline collaboration, organization, and tracking of projects within your team. Our system enables you to create, modify, and track projects with an intuitive interface, efficiently organize tasks and resources to achieve your goals, and collaborate in real-time with colleagues through integrated communication features like instant messaging and real-time notifications. You can easily manage users and groups, assign roles and permissions to control access to various project sections, and monitor resource allocation to ensure every project has the necessary tools and personnel for success. Additionally, our integrated calendar helps you plan tasks and events, keeping you organized and on schedule. Gain valuable insights with our reporting and analytics tools to measure performance and identify areas for improvement. Designed to be flexible and adaptable, our platform suits both small projects and large-scale initiatives. Join us and discover how our project management system can transform your way of working.");
        aboutUsp.setWrapStyleWord(true);
        aboutUsp.setDisabledTextColor(new Color(0, 0, 51));
        aboutUsp.setEnabled(false);
        jScrollPane1.setViewportView(aboutUsp);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 916;
        gridBagConstraints.ipady = 206;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(0, 70, 0, 63);
        body.add(jScrollPane1, gridBagConstraints);

        aboutUs.setFont(new Font("Segoe UI", 1, 24)); 
        aboutUs.setForeground(new Color(153, 0, 0));
        aboutUs.setText("About us");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(20, 150, 0, 0);
        body.add(aboutUs, gridBagConstraints);

        pictures.setIcon(new ImageIcon(getClass().getResource("Design sans titre (2).png"))); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = -170;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(0, 180, 0, 0);
        body.add(pictures, gridBagConstraints);

        jLabel1.setFont(new Font("Segoe UI", 1, 14)); 
        jLabel1.setForeground(new Color(102, 0, 0));
        jLabel1.setText("Arnaud Ulrich TOE");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 40, 50, 0);
        body.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new Font("Segoe UI", 1, 14)); 
        jLabel2.setForeground(new Color(102, 0, 0));
        jLabel2.setText("ZEMAT Zakariae");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 210, 50, 0);
        body.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new Font("Segoe UI", 1, 14)); 
        jLabel3.setForeground(new Color(102, 0, 0));
        jLabel3.setText("OUBEZA Idir");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 70, 50, 0);
        body.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new Font("Segoe UI", 1, 14)); 
        jLabel4.setForeground(new Color(102, 0, 0));
        jLabel4.setText("SAWADOGO Abdel");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 50, 50, 0);
        body.add(jLabel4, gridBagConstraints);

        getContentPane().add(body, BorderLayout.CENTER);

        pack();
    }

                        
                  
}
