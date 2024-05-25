package metier;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;


public class ReceivedInvitationPage extends JFrame {

    /**
     * Creates new form ReceivedInvitationPage
     */
    public ReceivedInvitationPage() {
        msg_shw_pan = new JPanel();
        accept_button = new JButton();
        refuse_button = new JButton();
        ScrollPane = new JScrollPane();
        TextArea = new JTextArea();
        proj_nam_lab = new JLabel();
        is_private_lab = new JLabel();
        descript_lab = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        msg_shw_pan.setBackground(new Color(204, 204, 255));
        msg_shw_pan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, 
        		new Color(153, 0, 204)), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 0, 12), new Color(153, 0, 204))); // NOI18N

        accept_button.setBackground(new Color(153, 0, 204));
        accept_button.setFont(new Font("Segoe UI Black", 1, 12)); // NOI18N
        accept_button.setForeground(new Color(255, 255, 255));
        accept_button.setText("accept");
        accept_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                accept_buttonActionPerformed(evt);
            }
        });

        refuse_button.setBackground(new Color(153, 0, 204));
        refuse_button.setFont(new Font("Segoe UI Black", 1, 12)); // NOI18N
        refuse_button.setForeground(new Color(255, 255, 255));
        refuse_button.setText("refuse");
        refuse_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                refuse_buttonActionPerformed(evt);
            }
        });

        TextArea.setBackground(new Color(242, 242, 242));
        TextArea.setEditable(false);
        TextArea.setLineWrap(true);
        TextArea.setColumns(20);
        TextArea.setRows(5);
        ScrollPane.setViewportView(TextArea);

        proj_nam_lab.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        proj_nam_lab.setText("Project name :");

        is_private_lab.setFont(new Font("Segoe UI Black", 1, 14)); // NOI18N
        is_private_lab.setText("Private");

        descript_lab.setFont(new Font("Segoe UI Black", 1, 14)); // NOI18N
        descript_lab.setText("Description");

        GroupLayout msg_shw_panLayout = new GroupLayout(msg_shw_pan);
        msg_shw_pan.setLayout(msg_shw_panLayout);
        msg_shw_panLayout.setHorizontalGroup(
            msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(msg_shw_panLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(accept_button)
                .addGap(302, 302, 302)
                .addComponent(refuse_button)
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
                    .addComponent(refuse_button)
                    .addComponent(accept_button))
                .addGap(32, 32, 32))
        );

        getContentPane().add(msg_shw_pan, BorderLayout.WEST);

        pack();
    }

                         
                           

    private void accept_buttonActionPerformed(ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void refuse_buttonActionPerformed(ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    

                      
    private JScrollPane ScrollPane;
    private JTextArea TextArea;
    private JLabel descript_lab;
    private JButton refuse_button;
    private JLabel is_private_lab;
    private JPanel msg_shw_pan;
    private JButton accept_button;
    private JLabel proj_nam_lab;
    
    
    public static void main (String args[])
    {
    	ReceivedInvitationPage rsqp = new ReceivedInvitationPage();
    	rsqp.setVisible(true);
    }
                      
}