package metier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class verifieDeconnexion extends JFrame {
	                  
    private JButton buttonAccept;
    private JPanel jPanel1;
    private JLabel pic;
    private JLabel question; 
    public verifieDeconnexion(Window wdws) {
        
        GridBagConstraints gridBagConstraints;

        jPanel1 = new JPanel();
        question = new JLabel();
        buttonAccept = new JButton();
        pic = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setLayout(new GridBagLayout());

        question.setFont(new Font("Segoe UI", 1, 16));
        question.setForeground(new Color(0, 0, 102));
        question.setText("you really want to log out?");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(30, 100, 0, 93);
        jPanel1.add(question, gridBagConstraints);

        buttonAccept.setBackground(new Color(255, 0, 0));
        buttonAccept.setFont(new Font("Segoe UI", 1, 18)); 
        buttonAccept.setForeground(new Color(255, 255, 255));
        buttonAccept.setText("Yes");
        buttonAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Window windw = SwingUtilities.getWindowAncestor(buttonAccept);
            	wdws.dispose();
            	LoginForm usrmsgp = new LoginForm();
               	usrmsgp.setLocationRelativeTo(null);
                usrmsgp.setVisible(true);
                windw.dispose();
                
            }
        });
        /*
         * 
         */
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(30, 150, 40, 0);
        jPanel1.add(buttonAccept, gridBagConstraints);

        pic.setIcon(new ImageIcon(getClass().getResource("assets/pngwing.com (1).png"))); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(28, 150, 0, 0);
        jPanel1.add(pic, gridBagConstraints);

        getContentPane().add(jPanel1, BorderLayout.CENTER);

        pack();
    }
    public static void main(String[] agrs) {
    	/*verifieDeconnexion vd = new verifieDeconnexion();
    	vd.setVisible(true);
    	vd.setSize(400, 300);*/
    }

                   
}
