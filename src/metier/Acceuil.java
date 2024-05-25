package metier;

import java.awt.Color;
import java.awt.Dimension;

public class Acceuil extends javax.swing.JFrame {
	LoginForm loginForm = new LoginForm();
	
    public Acceuil() {
        
        java.awt.GridBagConstraints gridBagConstraints;

        body = new javax.swing.JPanel();
        photo = new javax.swing.JLabel();
        signIn = new javax.swing.JButton();
        signUpButton = new javax.swing.JButton();
        welcome = new javax.swing.JLabel();
        p4p = new javax.swing.JLabel();
        slogan = new javax.swing.JLabel();
        aboutUsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.GridBagLayout());

        photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/img.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.ipadx = -20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(80, 10, 127, 0);
        body.add(photo, gridBagConstraints);

        signIn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        signIn.setForeground(new java.awt.Color(178, 34, 34));
        signIn.setText("Sign in");
        signIn.setBackground(Color.white);
        signIn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 34, 34), 2));
        signIn.addActionListener(e -> {
        	
        	loginForm.setVisible(true);
        	this.setVisible(false);
        	loginForm.setLocationRelativeTo(null);
            
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 5);
        body.add(signIn, gridBagConstraints);

        signUpButton.setBackground(new java.awt.Color(178, 34, 34));
        signUpButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(255, 255, 255));
        signUpButton.setText("Sign up");
        signUpButton.setToolTipText("");
        signUpButton.addActionListener(e -> {
        	SignUp signUp = new SignUp();
        	signUp.setVisible(true);
        	this.setVisible(false);
        	signUp.setLocationRelativeTo(null);
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 210, 0, 0);
        body.add(signUpButton, gridBagConstraints);

        welcome.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        welcome.setForeground(new java.awt.Color(0, 0, 90));
        welcome.setText("Welcome to");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(120, 30, 0, 0);
        body.add(welcome, gridBagConstraints);

        p4p.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        p4p.setForeground(new java.awt.Color(178, 34, 34));
        p4p.setText("P4P");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = -14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(130, 150, 0, 0);
        body.add(p4p, gridBagConstraints);

        
        
        slogan.setFont(new java.awt.Font("Segoe UI", 0, 18));
        slogan.setForeground(new java.awt.Color(0, 0, 90));
        slogan.setText("<html>Your ultimate project management solution<br> for seamless collaboration and efficient <br>project tracking.</html>");
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 0;
        //gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 54;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        body.add(slogan, gridBagConstraints);
        

        aboutUsButton.setBackground(new java.awt.Color(178, 34, 34));
        aboutUsButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        aboutUsButton.setForeground(new java.awt.Color(255, 255, 255));
        aboutUsButton.setText("About us");
        aboutUsButton.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        aboutUsButton.addActionListener(e -> {
        	AboutUs aboutUs = new AboutUs();
        	aboutUs.setVisible(true);
        	aboutUs.setSize(1050, 650);
        	aboutUs.setLocationRelativeTo(null);
        });
        body.add(aboutUsButton, gridBagConstraints);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton aboutUsButton;
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel p4p;
    private javax.swing.JLabel photo;
    private javax.swing.JButton signIn;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel slogan;
    private javax.swing.JLabel welcome;
    // End of variables declaration                   
}
