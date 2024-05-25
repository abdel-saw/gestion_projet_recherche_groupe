package metier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SignUp extends JFrame {
    Connection conn = Utilitaire.getConnection();
    String username;
    //HomePageUser hmu = new HomePageUser(getId(username),username);
    
    public SignUp() {
        java.awt.GridBagConstraints gridBagConstraints;
        JPanel body = new JPanel();
        JPanel Right = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel FirstName = new JLabel();
        JTextField FirstNameField = new JTextField();
        JLabel LastName = new JLabel();
        JTextField LastNameField = new JTextField();
        JLabel Username = new JLabel();
        JTextField UsernameField = new JTextField();
        JLabel Email = new JLabel();
        JTextField EmailField = new JTextField();
        JLabel Password = new JLabel();
        JPasswordField PasswordField = new JPasswordField();
        JLabel ConfirmPassword = new JLabel();
        JPasswordField ConfirmPasswordField = new JPasswordField();
        JButton SignInButton = new JButton();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JPanel Left = new JPanel();
        JLabel Image = new JLabel();
        JLabel jLabel7 = new JLabel();
        
        username = UsernameField.getText();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1050, 650));
        
        Right.setBackground(new java.awt.Color(153, 0, 204));
        Right.setForeground(new java.awt.Color(255, 255, 255));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));
        Right.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Sign Up");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 43, 0, 0);
        Right.add(jLabel1, gridBagConstraints);

        FirstName.setFont(new java.awt.Font("Roboto Light", 1, 14));
        FirstName.setForeground(new java.awt.Color(255, 255, 255));
        FirstName.setText("First Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 30, 0, 0);
        Right.add(FirstName, gridBagConstraints);

        FirstNameField.setBackground(new java.awt.Color(153, 0, 204));
        FirstNameField.setForeground(new java.awt.Color(255, 255, 255));
        FirstNameField.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 216;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 30, 0, 0);
        Right.add(FirstNameField, gridBagConstraints);

        LastName.setFont(new java.awt.Font("Roboto Light", 1, 14));
        LastName.setForeground(new java.awt.Color(255, 255, 255));
        LastName.setText("Last Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 30, 0, 0);
        Right.add(LastName, gridBagConstraints);

        LastNameField.setBackground(new java.awt.Color(153, 0, 204));
        LastNameField.setForeground(new java.awt.Color(255, 255, 255));
        LastNameField.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 216;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 30, 0, 0);
        Right.add(LastNameField, gridBagConstraints);

        Username.setFont(new java.awt.Font("Roboto Light", 1, 14));
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        Right.add(Username, gridBagConstraints);

        UsernameField.setBackground(new java.awt.Color(153, 0, 204));
        UsernameField.setForeground(new java.awt.Color(255, 255, 255));
        UsernameField.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 216;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 30, 0, 0);
        Right.add(UsernameField, gridBagConstraints);

        Email.setFont(new java.awt.Font("Roboto Light", 1, 14));
        Email.setForeground(new java.awt.Color(255, 255, 255));
        Email.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        Right.add(Email, gridBagConstraints);

        EmailField.setBackground(new java.awt.Color(153, 0, 204));
        EmailField.setForeground(new java.awt.Color(255, 255, 255));
        EmailField.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 216;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        Right.add(EmailField, gridBagConstraints);

        Password.setFont(new java.awt.Font("Roboto Light", 1, 14));
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 30, 0, 0);
        Right.add(Password, gridBagConstraints);

        PasswordField.setBackground(new java.awt.Color(153, 0, 204));
        PasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        PasswordField.setForeground(new java.awt.Color(255, 255, 255));
        PasswordField.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 216;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 30, 0, 0);
        Right.add(PasswordField, gridBagConstraints);

        ConfirmPassword.setFont(new java.awt.Font("Roboto Light", 1, 14));
        ConfirmPassword.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmPassword.setText("Confirm Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 30, 0, 0);
        Right.add(ConfirmPassword, gridBagConstraints);

        ConfirmPasswordField.setBackground(new java.awt.Color(153, 0, 204));
        ConfirmPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        ConfirmPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmPasswordField.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 216;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 30, 0, 0);
        Right.add(ConfirmPasswordField, gridBagConstraints);

        SignInButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        SignInButton.setForeground(new java.awt.Color(153, 0, 204));
        SignInButton.setText("SIGN UP");
        SignInButton.setBackground(Color.white);
        SignInButton.setPreferredSize(new java.awt.Dimension(300, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 218;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 20, 40);
        Right.add(SignInButton, gridBagConstraints);

        SignInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = FirstNameField.getText();
                String lastName = LastNameField.getText();
                String username = UsernameField.getText();
                String email = EmailField.getText();
                char[] passwordChars = PasswordField.getPassword();
                String password = new String(passwordChars);
                char[] passwordcfChars = ConfirmPasswordField.getPassword();
                String confirmPassword = new String(passwordcfChars);
                

                if (username.equals("") || password.equals("") || confirmPassword.equals("") || firstName.equals("") || lastName.equals("") || email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter all of your information !!", "Missing Information", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    if (!password.equals(confirmPassword)) {
                        JOptionPane.showMessageDialog(null, "Please enter the same password !!", "Invalid Information", JOptionPane.ERROR_MESSAGE);
                        ConfirmPassword.setText("");
                        return;
                    } else {
                        int id = userExists(username);
                        if (id > 0) {
                            JOptionPane.showMessageDialog(null, "Username already exists, please use another !!", "Invalid Information", JOptionPane.ERROR_MESSAGE);
                            return;
                        } else {
                            SigningUp(username, password, email, firstName, lastName);
                            
                            HomePageUser hmu = new HomePageUser(getId(username),username);
                            hmu.setVisible(true);
                            hmu.setLocationRelativeTo(null);
                            hmu.setSize(1050, 650);
                        }
                    }
                }

                try {
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM utilisateur");
                    rs.last();
                    int id = rs.getInt(1);
                } catch (Exception ex) {
                    System.out.println("Exception :" + ex);
                }
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe Script", 0, 12));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("______________________________________________________________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 30, 0, 0);
        Right.add(jLabel2, gridBagConstraints);
        
        jLabel7.setFont(new java.awt.Font("Segoe Script", 0, 12));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("______________________________________________________________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 30, 0, 0);
        Right.add(jLabel7, gridBagConstraints);


        jLabel3.setFont(new java.awt.Font("Segoe Script", 0, 12));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("______________________________________________________________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 30, 0, 0);
        Right.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe Script", 0, 12));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("______________________________________________________________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 30, 0, 0);
        Right.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Segoe Script", 0, 12));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("______________________________________________________________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 30, 0, 0);
        Right.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Segoe Script", 0, 12));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("______________________________________________________________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 30, 0, 0);
        Right.add(jLabel6, gridBagConstraints);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setLayout(new java.awt.GridBagLayout());

        Image.setIcon(new ImageIcon(getClass().getResource("assets/6333204 (1).jpg")));
        Image.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -39;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 36, 160, 42);
        Left.add(Image, gridBagConstraints);

        body.setLayout(new GridLayout(1, 2));
        body.add(Right);
        body.add(Left);
        this.setLayout(new BorderLayout());
        add(body, BorderLayout.CENTER);

        pack();
    }
    
    
    
    private void SigningUp(String username, String passwd, String email, String firstName, String lastName) {
        ajouterUser(username, passwd, email, firstName, lastName);
        this.setVisible(false);
    }

    public void ajouterUser(String username, String passwd, String email, String firstName, String lastName) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO utilisateur (username, mot_de_passe, email, prenom, nom) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, passwd);
            ps.setString(3, email);
            ps.setString(4, firstName);
            ps.setString(5, lastName);

            ps.executeUpdate();
            System.out.println("User added successfully!");
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }
    public int getId(String username) {
    	try {
            PreparedStatement ps = conn.prepareStatement("SELECT idutilisateur FROM utilisateur WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    	return 0;
    }
    public int userExists(String username) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM utilisateur WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        return 0;
    }
    

}