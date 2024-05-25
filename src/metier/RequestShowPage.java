package metier;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*
;
public class RequestShowPage extends JFrame {

    /**
     * Creates new form RequestShowPage
     */
    public RequestShowPage( String description , String proj_name , String type) {
        msg_shw_pan = new JPanel();
        ok_button = new JButton();
        discard_button = new JButton();
        ScrollPane = new JScrollPane();
        TextArea = new JTextArea();
        proj_nam_lab = new JLabel();
        is_private_lab = new JLabel();
        descript_lab = new JLabel();
        this.proj_name_var = proj_name ;

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        msg_shw_pan.setBackground(new Color(204, 204, 255));
        msg_shw_pan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, 
        		new Color(153, 0, 204)), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 0, 12), new Color(153, 0, 204))); 

        ok_button.setBackground(new Color(153, 0, 204));
        ok_button.setFont(new Font("Segoe UI Black", 1, 12)); 
        ok_button.setForeground(new Color(255, 255, 255));
        ok_button.setText("ok");
        ok_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ok_buttonActionPerformed(evt);
            }
        });

        discard_button.setBackground(new Color(153, 0, 204));
        discard_button.setFont(new Font("Segoe UI Black", 1, 12)); 
        discard_button.setForeground(new Color(255, 255, 255));
        discard_button.setText("discard");
        discard_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                discard_buttonActionPerformed(evt);
            }
        });

        TextArea.setBackground(new Color(242, 242, 242));
        TextArea.setEditable(false);
        TextArea.setLineWrap(true);
        TextArea.setColumns(20);
        TextArea.setRows(5);
        ScrollPane.setViewportView(TextArea);
        TextArea.setText(description);

        proj_nam_lab.setFont(new Font("Segoe UI", 1, 14)); 
        proj_nam_lab.setText("Project name :");

        is_private_lab.setFont(new Font("Segoe UI Black", 1, 14)); 
        is_private_lab.setText("Type: "+ type);

        descript_lab.setFont(new Font("Segoe UI Black", 1, 14)); 
        descript_lab.setText("Description");

        GroupLayout msg_shw_panLayout = new GroupLayout(msg_shw_pan);
        msg_shw_pan.setLayout(msg_shw_panLayout);
        msg_shw_panLayout.setHorizontalGroup(
            msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(msg_shw_panLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(ok_button)
                .addGap(302, 302, 302)
                .addComponent(discard_button)
                .addContainerGap(113, Short.MAX_VALUE))
            .addGroup(msg_shw_panLayout.createSequentialGroup()
                .addGroup(msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(msg_shw_panLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ScrollPane, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.LEADING, msg_shw_panLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(msg_shw_panLayout.createSequentialGroup()
                                .addComponent(descript_lab, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(msg_shw_panLayout.createSequentialGroup()
                                .addComponent(proj_nam_lab, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(is_private_lab, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        msg_shw_panLayout.setVerticalGroup(
            msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(msg_shw_panLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(proj_nam_lab)
                    .addComponent(is_private_lab))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(descript_lab)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(discard_button)
                    .addComponent(ok_button))
                .addGap(32, 32, 32))
        );

        getContentPane().add(msg_shw_pan, BorderLayout.WEST);

        pack();
    }

                         
                           

    private void ok_buttonActionPerformed(ActionEvent evt) { 
        Window win =  SwingUtilities.getWindowAncestor(ok_button);
        win.dispose();
        
    }                                         

    private void discard_buttonActionPerformed(ActionEvent evt) {      
    	
        try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	try 
    	{
    		PreparedStatement ps = con.prepareStatement("DELETE FROM demande WHERE nom_long_projet = ?");
    		ps.setString(1, proj_name_var);
    		ps.executeUpdate();
    		con.commit();
    	}
    	catch (Exception e)
    	{

    		JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    	}
    	
    	JOptionPane.showMessageDialog(null, "Request discard", "Notif", JOptionPane.ERROR_MESSAGE);
    	Window win = SwingUtilities.getWindowAncestor(discard_button);
    	win.dispose();
    }                                              

    

                      
    private JScrollPane ScrollPane;
    private JTextArea TextArea;
    private JLabel descript_lab;
    private JButton discard_button;
    private JLabel is_private_lab;
    private JPanel msg_shw_pan;
    private JButton ok_button;
    private JLabel proj_nam_lab;
    protected String proj_name_var;
    public static Connection con = Utilitaire.getConnection();
    
                      
}