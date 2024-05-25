package metier;
import javax.swing.*;

import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;


public class MessageReplyPage extends JFrame {

   
    public MessageReplyPage(String sender , String receiver , String project_name) {
    	  msg_shw_pan = new JPanel();
          jScrollPane1 = new JScrollPane();
          text_area = new JTextArea();
          enter_msg_label = new JLabel();
          send_button = new JButton();
          discard_button = new JButton();
          this.sender = sender ;
          this.receiver = receiver ;
          this.project_name = project_name ;

          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

          msg_shw_pan.setBackground(new Color(204, 204, 255));
          msg_shw_pan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, 
          		new Color(153, 0, 204)), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 0, 12), new Color(153, 0, 204))); 

          text_area.setBackground(new Color(242, 242, 242));
          text_area.setColumns(20);
          text_area.setRows(5);
          text_area.setLineWrap(true);
          text_area.setBorder(new MatteBorder(null));
          jScrollPane1.setViewportView(text_area);

          enter_msg_label.setBackground(new Color(255, 255, 255));
          enter_msg_label.setFont(new Font("Segoe UI Black", 1, 14)); 
          enter_msg_label.setText("Enter your message below");

          send_button.setBackground(new Color(153, 0, 204));
          send_button.setFont(new Font("Segoe UI Black", 1, 12)); 
          send_button.setForeground(new Color(255, 255, 255));
          send_button.setText("Send");
          send_button.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                  send_buttonActionPerformed(evt);
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

          GroupLayout msg_shw_panLayout = new GroupLayout(msg_shw_pan);
          msg_shw_pan.setLayout(msg_shw_panLayout);
          msg_shw_panLayout.setHorizontalGroup(
              msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(msg_shw_panLayout.createSequentialGroup()
                  .addGap(90, 90, 90)
                  .addGroup(msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                      .addGroup(msg_shw_panLayout.createSequentialGroup()
                          .addComponent(send_button)
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                          .addComponent(discard_button))
                      .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE))
                  .addContainerGap(96, Short.MAX_VALUE))
              .addGroup(GroupLayout.Alignment.TRAILING, msg_shw_panLayout.createSequentialGroup()
                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(enter_msg_label, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
                  .addGap(119, 119, 119))
          );
          msg_shw_panLayout.setVerticalGroup(
              msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(msg_shw_panLayout.createSequentialGroup()
                  .addGap(33, 33, 33)
                  .addComponent(enter_msg_label)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                  .addGroup(msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(discard_button)
                      .addComponent(send_button))
                  .addGap(32, 32, 32))
          );

          getContentPane().add(msg_shw_pan, BorderLayout.WEST);

          pack();
    }

                            
                       

    private void send_buttonActionPerformed(ActionEvent evt) {                                            
        
    	try 
    	{
    		PreparedStatement ps1 = con.prepareStatement("SELECT IdUtilisateur FROM utilisateur WHERE username = ?");
    		ps1.setString(1, sender);
    		PreparedStatement ps2 = con.prepareStatement("SELECT IdUtilisateur FROM utilisateur WHERE username = ?");
    		ps2.setString(1, receiver);
    		PreparedStatement ps3 = con.prepareStatement("SELECT IdProjet FROM projet WHERE nom_long = ?");
    		ps3.setString(1, project_name);
    		ResultSet rs1 = ps1.executeQuery();
    		ResultSet rs2 = ps2.executeQuery();
    		ResultSet rs3 = ps3.executeQuery();
    		rs1.next();
    		rs2.next();
    		rs3.next();
    		String texte = text_area.getText();
    		Date date_envoi = new Date(System.currentTimeMillis());
    		Time heure_envoi = new Time(System.currentTimeMillis());
    		
    		Statement stmt1 = con.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    		ResultSet rs_stmt1 = stmt1.executeQuery("SELECT * FROM message");
    		rs_stmt1.moveToInsertRow();
    		rs_stmt1.updateInt("idSender",rs2.getInt(1));
    		rs_stmt1.updateInt("idReceiver",rs1.getInt(1));
    		rs_stmt1.updateDate("date_envoi",date_envoi);
    		rs_stmt1.updateTime("heure_envoi", heure_envoi);
    		rs_stmt1.updateString("contenu", texte);
    		rs_stmt1.updateInt("idProjet",rs3.getInt(1));
    		rs_stmt1.insertRow();
    		
    	}
    	catch (Exception e)
    	{
    		
    		JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    	}
    	
    	JOptionPane.showMessageDialog(null, "Message send", "Notif", JOptionPane.ERROR_MESSAGE);
    	Window win = SwingUtilities.getWindowAncestor(send_button);
    	win.dispose();
    }                                           

    private void discard_buttonActionPerformed(ActionEvent evt) {                                               
        Window win = SwingUtilities.getWindowAncestor(discard_button);
        win.dispose();
    }                                              

    

                       
    private JButton discard_button;
    private JLabel enter_msg_label;
    private JScrollPane jScrollPane1;
    private JPanel msg_shw_pan;
    private JButton send_button;
    private JTextArea text_area;
    protected String sender ;
    protected String receiver ;
    protected String project_name ;
    public static Connection con = Utilitaire.getConnection();
    
                   
    
    public static void main (String args[])
    {
    	/*MessageReplyPage msgrep = new MessageReplyPage();
    	msgrep.setVisible(true);*/
    }
}