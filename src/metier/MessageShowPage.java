package metier;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

public class MessageShowPage extends JFrame {

    
    public MessageShowPage(String content , String sender , String receiver,String project_name) {
        msg_shw_pan = new JPanel();
        reply_button = new JButton();
        close_button = new JButton();
        ScrollPane = new JScrollPane();
        TextArea = new JTextArea();
        this.sender = sender ;
        this.receiver = receiver ;
        this.project_name = project_name; 
       

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        msg_shw_pan.setBackground(new Color(204, 204, 255));
        msg_shw_pan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(153, 0, 204)), "",
        		TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 0, 12), new Color(153, 0, 204)));

        reply_button.setBackground(new Color(153, 0, 204));
        reply_button.setFont(new Font("Segoe UI Black", 1, 12)); 
        reply_button.setForeground(new Color(255, 255, 255));
        reply_button.setText("Reply");
        reply_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                reply_buttonActionPerformed(evt);
            }
        });

        close_button.setBackground(new Color(153, 0, 204));
        close_button.setFont(new Font("Segoe UI Black", 1, 12)); 
        close_button.setForeground(new Color(255, 255, 255));
        close_button.setText("close");
        close_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                close_buttonActionPerformed(evt);
            }
        });

        TextArea.setBackground(new Color(242, 242, 242));
        TextArea.setColumns(20);
        TextArea.setRows(5);
        TextArea.setEditable(false);
        TextArea.setText(content);
        TextArea.setLineWrap(true);
        ScrollPane.setViewportView(TextArea);

        GroupLayout msg_shw_panLayout = new GroupLayout(msg_shw_pan);
        msg_shw_pan.setLayout(msg_shw_panLayout);
        msg_shw_panLayout.setHorizontalGroup(
            msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(msg_shw_panLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(msg_shw_panLayout.createSequentialGroup()
                        .addComponent(reply_button)
                        .addGap(356, 356, 356)
                        .addComponent(close_button))
                    .addComponent(ScrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        msg_shw_panLayout.setVerticalGroup(
            msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(msg_shw_panLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(ScrollPane, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(msg_shw_panLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(close_button)
                    .addComponent(reply_button))
                .addGap(32, 32, 32))
        );

        getContentPane().add(msg_shw_pan, BorderLayout.WEST);

        pack();
    }

                            
                          

    private void reply_buttonActionPerformed(ActionEvent evt) {                                            
        new MessageReplyPage(sender,receiver,project_name).setVisible(true);
    }                                           

    private void close_buttonActionPerformed(ActionEvent evt) {                                               
        Window win = SwingUtilities.getWindowAncestor(close_button);
        win.dispose();
    }                                              

    
    

                      
    private JButton close_button;
    private JScrollPane ScrollPane;
    private JTextArea TextArea;
    private JPanel msg_shw_pan;
    private JButton reply_button;
    protected static String content ;
    protected String sender ;
    protected String receiver ;
    protected String project_name ;
                
  /*  public static void main(String args[])
    {
    	MessageShowPage msgshpan = new MessageShowPage(content);
    	msgshpan.setVisible(true);
    }*/
}