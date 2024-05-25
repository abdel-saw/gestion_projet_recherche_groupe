/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

/**
 *
 * @author IDIR
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Locale;
import javax.swing.*;
import javax.swing.border.Border;

public class LoginForm extends JFrame {
    Connection conn = Utilitaire.getConnection();
                         
    public LoginForm() {
        GridBagConstraints gridBagConstraints;

        JPanel Right = new JPanel();
        JLabel jLabel2 = new JLabel();
        JLabel image = new JLabel();
        JPanel Form = new JPanel();
        JLabel Loginh1 = new JLabel();
        JLabel Usernameh1 = new JLabel();
        JLabel Usernameline = new JLabel();
        JLabel Passwordh1 = new JLabel();
        JLabel Passwordline = new JLabel();
        JLabel Usernameicon = new JLabel();
        JLabel PasswordIcon = new JLabel();
        JLabel PasswordForget = new JLabel();
        JButton LoignButton = new JButton();
        JLabel requestCreateAccount = new JLabel();
        JLabel SignUph = new JLabel();
        JTextField jTextField3 = new JTextField();
        JPasswordField jPasswordField1 = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setPreferredSize(new Dimension(1050, 650));
        getContentPane().setLayout(new GridLayout());

        Right.setBackground(new Color(255, 255, 255));

        image.setIcon(new ImageIcon(getClass().getResource("assets/—Pngtree—purple gradient multi-terminal login data_5045244 (1).png")));
        

        Right.setBackground(new Color(255, 255, 255));
        Right.setLayout(new GridBagLayout());
        Right.add(image);

        getContentPane().add(Right);

        Form.setBackground(new Color(153, 0, 204));
        Form.setLayout(new GridBagLayout());

        Loginh1.setFont(new Font("Palatino Linotype", 1, 33)); 
        Loginh1.setForeground(new Color(255, 255, 255));
        Loginh1.setHorizontalAlignment(SwingConstants.CENTER);
        Loginh1.setText("Login");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(57, 125, 0, 0);
        Form.add(Loginh1, gridBagConstraints);

        Usernameh1.setFont(new Font("Segoe UI", 0, 14));
        Usernameh1.setForeground(new Color(255, 255, 255));
        Usernameh1.setText("Username");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 49;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 43, 0, 0);
        Form.add(Usernameh1, gridBagConstraints);

        Usernameline.setFont(new Font("Segoe Script", 0, 14));
        Usernameline.setForeground(new Color(255, 255, 255));
        Usernameline.setText("_________________________________________");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 43, 0, 0);
        Form.add(Usernameline, gridBagConstraints);

        Passwordh1.setFont(new Font("Segoe UI", 0, 14));
        Passwordh1.setForeground(new Color(255, 255, 255));
        Passwordh1.setText("Password");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 43, 0, 0);
        Form.add(Passwordh1, gridBagConstraints);

        Passwordline.setFont(new Font("Segoe Script", 0, 14));
        Passwordline.setForeground(new Color(255, 255, 255));
        Passwordline.setText("_________________________________________");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 43, 0, 0);
        Form.add(Passwordline, gridBagConstraints);

        Usernameicon.setIcon(new ImageIcon(getClass().getResource("assets/icons8-user-30.png")));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(3, 16, 0, 30);
        Form.add(Usernameicon, gridBagConstraints);

        PasswordIcon.setIcon(new ImageIcon(getClass().getResource("assets/icons8-lock-30.png"))); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(41, 16, 0, 30);
        Form.add(PasswordIcon, gridBagConstraints);

        PasswordForget.setFont(new Font("Segoe UI", 0, 13));
        PasswordForget.setForeground(new Color(255, 255, 255));
        PasswordForget.setHorizontalAlignment(SwingConstants.CENTER);
        PasswordForget.setText("Forget Password?");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 137, 0, 0);
        Form.add(PasswordForget, gridBagConstraints);

        LoignButton.setFont(new Font("Segoe UI", 1, 14));
        LoignButton.setForeground(new Color(153, 0, 204));
        LoignButton.setText("LOGIN");
        LoignButton.setBorder(null);
        LoignButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LoignButton.setBackground(Color.white);
        LoignButton.setBorder(null);
        LoignButton.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                LoignButton.setBackground(new Color(153, 0, 204));
                LoignButton.setForeground(Color.white);
                Border whiteBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
                LoignButton.setBorder(whiteBorder);
            }

            
            public void mouseExited(MouseEvent e) {
                LoignButton.setBackground(Color.white);
                LoignButton.setForeground(new Color(153, 0, 204));
                LoignButton.setBorder(null);
            }
        });
        LoignButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the text from jTextField3
                
                String username = jTextField3.getText();
                char[] passwordChars = jPasswordField1.getPassword();
                String password = new String(passwordChars); 
                if(username.equals("") || password.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter your username and password !!", "Missing Information", JOptionPane.ERROR_MESSAGE);
                }else{
                	if (username.endsWith("-adm")) {
                		String adminUsername = username.substring(0, username.length() - 4);
                	    authenticateAdminLogin(adminUsername, password);
                    System.out.println("Admin login successful.");
                    }else if(username.equalsIgnoreCase("guest") && password.equalsIgnoreCase("guest")){
                    	System.out.println("Guest login successful");
                    	connectGuest(username);
                    	
                    }
                    else {
                    	authenticateUserLogin(username, password);
                    	System.out.println("User login successful.");
                    }
                }
            }
        });
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 21;
        gridBagConstraints.ipadx = 229;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 51, 0, 0);
        Form.add(LoignButton, gridBagConstraints);

        requestCreateAccount.setFont(new Font("Segoe UI", 0, 13));
        requestCreateAccount.setForeground(new Color(255, 255, 255));
        requestCreateAccount.setText("Don't have an account?");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 92, 58, 0);
        Form.add(requestCreateAccount, gridBagConstraints);

        SignUph.setFont(new Font("Segoe UI", 0, 13));
        SignUph.setForeground(new Color(255, 255, 255));
        SignUph.setText("Sign up");
        SignUph.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 12, 58, 0);
        Form.add(SignUph, gridBagConstraints);
        SignUph.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // sending to the signUp page after clicking 'signup'    
                popUpSignUp();
            }
        });

        jTextField3.setBackground(new Color(153, 0, 204));
        jTextField3.setBorder(null);
        jTextField3.setForeground(Color.white);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(37, 50, 0, 0);
        Form.add(jTextField3, gridBagConstraints);

        jPasswordField1.setBackground(new Color(153, 0, 204));
        jPasswordField1.setBorder(null);
        jPasswordField1.setForeground(Color.white);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(32, 50, 0, 0);
        Form.add(jPasswordField1, gridBagConstraints);

        getContentPane().add(Form);

        pack();
    }  
    public void popUpSignUp(){
        SignUp su = new SignUp();
        this.setVisible(false);
        su.setVisible(true);
        su.setLocationRelativeTo(null);
    }
    public void authenticateUserLogin(String username, String passwd) {
        try {
            // Enable auto-commit if it was disabled
            //conn.setAutoCommit(true);

            // Disable foreign key constraints temporarily
            Statement stmt = conn.createStatement();
            stmt.execute("SET FOREIGN_KEY_CHECKS=0");

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM UTILISATEUR WHERE username = ? AND mot_de_passe = ?");
            ps.setString(1, username);
            ps.setString(2, passwd);
            PreparedStatement ps2 = conn.prepareStatement("UPDATE UTILISATEUR SET derniere_date_connexion = CURRENT_TIMESTAMP WHERE username = ?");
            ps2.setString(1, username);
            int rowsAffected = ps2.executeUpdate();

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // if exists
                HomePageUser hp = new HomePageUser(this.getId(username), username);
                hp.setSize(1050, 650);
                hp.setVisible(true);
                hp.setLocationRelativeTo(null);
                this.setVisible(false);
            } else {
                // if not
                JOptionPane.showMessageDialog(null, "Incorrect username or password", "Incorrect Information", JOptionPane.ERROR_MESSAGE);
            }

            // Re-enable foreign key constraints
            stmt.execute("SET FOREIGN_KEY_CHECKS=1");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void authenticateAdminLogin(String username, String passwd) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ADMINISTRATEUR_PLATEFORME WHERE identifiant_connexion = ? AND mot_de_passe = ?");
            ps.setString(1, username);
            ps.setString(2, passwd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // if exists
                //HomePage hp = new HomePage(/*new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5))*/);
                
                HomePageAdmin hmu = new HomePageAdmin(username);//!!!!!!!!!!!!!!!!!homePageAdmin_platform
                hmu.setSize(1050, 650);
                hmu.setVisible(true);
                hmu.setLocationRelativeTo(null);
                this.setVisible(false);
                
 
            }else{
                // if not
                JOptionPane.showMessageDialog(null, "Incorrect username or password", "Incorrect Information", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        
	}
    public void connectGuest(String username) {
    	Guest gp = new Guest(username);
    	gp.setVisible(true);
    	this.setVisible(false);
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
                                        

}
