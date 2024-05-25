package metier;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class DocumentAddPage extends JFrame {

   
    public DocumentAddPage(String proj_name , int id_proj,String type_doc) {
    	content = new JPanel();
        title_label = new JLabel();
        extension_label = new JLabel();
        file_choose_label = new JLabel();
        title_area = new JTextField();
        extension_area = new JTextField();
        select_file_button = new JButton();
        add_file_button = new JButton();
        discard_button = new JButton();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        content.setBackground(new Color(204, 204, 255));

        title_label.setFont(new Font("Segoe UI Black", 1, 12)); 
        title_label.setText("Titre :");

        extension_label.setFont(new Font("Segoe UI Black", 1, 12)); 
        extension_label.setText("Extension :");

        file_choose_label.setFont(new Font("Segoe UI Black", 1, 12)); 
        file_choose_label.setText("choisir le fichier ");

        title_area.setText("doc title");
        title_area.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                title_areaActionPerformed(evt);
            }
        });

        extension_area.setText("doc extension");
        extension_area.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                extension_areaActionPerformed(evt);
            }
        });

        select_file_button.setText("Select file");
        select_file_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                     selectedFile = fileChooser.getSelectedFile();
                   
                }
            }
        });


        add_file_button.setText("Add file");
        

        add_file_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Récupérez les informations du constructeur
                String title = title_area.getText();
                String extension = extension_area.getText();
                // Assurez-vous que selectedFile n'est pas null et qu'il a été sélectionné
                if (selectedFile != null) {
                    
                    try 
                    {		
                    	String sql = "INSERT INTO document (titre, contenu, IdProjet, extension, Document_type) VALUES (?, ?, ?, ?,?)";
                    		PreparedStatement pstmt = conn.prepareStatement(sql); 
                            pstmt.setString(1, title);
                            pstmt.setBlob(2, new FileInputStream(selectedFile));
                            pstmt.setInt(3, id_proj);
                            pstmt.setString(4, extension);
                            pstmt.setString(5,type_doc);
                            pstmt.executeUpdate();
        			}
                     catch (Exception e) {
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Document has been added ", "Notif", JOptionPane.ERROR_MESSAGE);
                    Window win = SwingUtilities.getWindowAncestor(add_file_button);
                    win.dispose();
                }
            }
        });


        discard_button.setText("Discard");
        discard_button.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent evt) {
    	        dispose(); 
    	    }
    	});

        jLabel1.setBackground(new Color(204, 204, 255));
        jLabel1.setForeground(new Color(51, 0, 51));
        jLabel1.setText("ADD NEW FILE TO PROJECT :"+proj_name);
        jLabel1.setToolTipText("");

        GroupLayout contentLayout = new GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(file_choose_label, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(add_file_button, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                        .addComponent(discard_button, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(select_file_button, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentLayout.createSequentialGroup()
                            .addComponent(title_label, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(title_area, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentLayout.createSequentialGroup()
                            .addComponent(extension_label, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(extension_area, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(title_area, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(title_label))
                .addGap(60, 60, 60)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(extension_area, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(extension_label))
                .addGap(65, 65, 65)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(select_file_button)
                    .addComponent(file_choose_label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(discard_button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_file_button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        getContentPane().add(content, BorderLayout.CENTER);

        pack();
    }
                       
                           

    private void title_areaActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void extension_areaActionPerformed(ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

   public static void main (String args)
   {
	   
   }
   
   


                       
    private JButton add_file_button;
    private JPanel content;
    private JButton discard_button;
    private JTextField extension_area;
    private JLabel extension_label;
    private JLabel file_choose_label;
    private JLabel jLabel1;
    private JButton select_file_button;
    private JTextField title_area;
    private JLabel title_label;
    private File selectedFile; 
    public static Connection conn = Utilitaire.getConnection();
                      
}

