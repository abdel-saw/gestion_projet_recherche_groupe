package metier;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;

 
public class RessourcesPage extends javax.swing.JFrame {
			
			private Info info;
   
    public RessourcesPage(Info info) {
    	
            java.awt.GridBagConstraints gridBagConstraints;
            this.info = info;
            /*
            project_name = proj_name ;
            username_var = username ;
            this.date = date ;
            this.Description = Descript ;
            this.iduser = iduser;
            this.username = username;
            this.NomCourt = NomCourt;*/

            body = new javax.swing.JPanel();
            header = new javax.swing.JPanel();
            P4P = new javax.swing.JLabel();
            Username = new javax.swing.JLabel();
            contenu = new javax.swing.JPanel();
            membres = new javax.swing.JButton();
            Agenda = new javax.swing.JButton();
            ressources = new javax.swing.JButton();
            about = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            Ressources_Projet = new javax.swing.JTree();
            adhesion = new javax.swing.JButton();

           

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            body.setBackground(new java.awt.Color(255, 255, 255));
            body.setLayout(new java.awt.BorderLayout());

            


            header.setBackground(new java.awt.Color(153, 0, 204));
            header.setLayout(new java.awt.GridBagLayout());

            P4P.setBackground(new java.awt.Color(255, 255, 255));
            P4P.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
            P4P.setForeground(new java.awt.Color(255, 255, 255));
            P4P.setText("P4P");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridheight = 2;
            gridBagConstraints.ipady = 18;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new java.awt.Insets(0, 90, 0, 0);
            header.add(P4P, gridBagConstraints);

            Username.setBackground(new java.awt.Color(255, 255, 255));
            Username.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
            Username.setForeground(new java.awt.Color(255, 255, 255));
            Username.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/icons8-user-30.png"))); // NOI18N
            Username.setText(info.getUsername());
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.ipadx = 80;
            gridBagConstraints.ipady = -2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new java.awt.Insets(10, 556, 0, 22);
            header.add(Username, gridBagConstraints);

            body.add(header, java.awt.BorderLayout.PAGE_START);

            contenu.setBackground(new java.awt.Color(255, 255, 255));
            contenu.setLayout(new java.awt.GridBagLayout());

            membres.setBackground(new java.awt.Color(153, 0, 204));
            membres.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
            membres.setForeground(new java.awt.Color(255, 255, 255));
            membres.setText("Membres");
            membres.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    membresActionPerformed(evt);
                }
            });
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.ipadx = 24;
            gridBagConstraints.ipady = 32;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
            contenu.add(membres, gridBagConstraints);

            Agenda.setBackground(new java.awt.Color(153, 0, 204));
            Agenda.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
            Agenda.setForeground(new java.awt.Color(255, 255, 255));
            Agenda.setText("Agenda");
            Agenda.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AgendaActionPerformed(evt);
                }
            });
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.ipadx = 13;
            gridBagConstraints.ipady = 32;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
            contenu.add(Agenda, gridBagConstraints);

            ressources.setBackground(new java.awt.Color(153, 0, 204));
            ressources.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
            ressources.setForeground(new java.awt.Color(255, 255, 255));
            ressources.setText("Ressources");
            ressources.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ressourcesActionPerformed(evt);
                }
            });
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.ipadx = 8;
            gridBagConstraints.ipady = 32;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
            contenu.add(ressources, gridBagConstraints);

            about.setBackground(new java.awt.Color(153, 0, 204));
            about.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
            about.setForeground(new java.awt.Color(255, 255, 255));
            about.setText("About");
            about.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    aboutActionPerformed(evt);
                }
            });
            
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.ipadx = 30;
            gridBagConstraints.ipady = 32;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
            contenu.add(about, gridBagConstraints);

            
            // Création du nœud racine
			DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Ressources du projet");
			// Création des nœuds pour src et web
			DefaultMutableTreeNode srcNode = new DefaultMutableTreeNode("src");
			DefaultMutableTreeNode webNode = new DefaultMutableTreeNode("web");
			//request
			//String sqlProjId = "SELECT IdProjet FROM projet WHERE nom_long = ?";
			String sqlSrc = "SELECT titre , extension from document WHERE Document_type = 'src' AND IdProjet = ?";
			String sqlWeb = "SELECT titre , extension from document WHERE Document_type = 'web' AND IdProjet = ?";
			
            
			
				
			
				
			
			// Ajout des fichiers src
			try 
			{
				PreparedStatement statementSrc = con.prepareStatement(sqlSrc);
				statementSrc.setInt(1, info.getIdprojetAboutPage());
			    ResultSet resultSetSrc = statementSrc.executeQuery();
			        while (resultSetSrc.next()) {
			            String fileName = resultSetSrc.getString("titre");
			            String exten = resultSetSrc.getString("extension");
			            srcNode.add(new DefaultMutableTreeNode(fileName+"."+exten));
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			    
			

			// Ajout des fichiers web
			try 
			{
				PreparedStatement statementWeb = con.prepareStatement(sqlWeb);
				statementWeb.setInt(1, info.getIdprojetAboutPage());
			    ResultSet resultSetWeb = statementWeb.executeQuery();
			        while (resultSetWeb.next()) {
			            String fileName = resultSetWeb.getString("titre");
			            String exten = resultSetWeb.getString("extension");
			            webNode.add(new DefaultMutableTreeNode(fileName+"."+exten));
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}

			// Ajout des nœuds src et web au nœud racine
			rootNode.add(srcNode);
			rootNode.add(webNode);

			// Création du modèle d'arbre et mise à jour de l'UI
			Ressources_Projet.setModel(new javax.swing.tree.DefaultTreeModel(rootNode));
            jScrollPane1.setViewportView(Ressources_Projet);
        

            Ressources_Projet.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        int row = Ressources_Projet.getClosestRowForLocation(e.getX(), e.getY());
                        Ressources_Projet.setSelectionRow(row);
                        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) Ressources_Projet.getLastSelectedPathComponent();
                        if (selectedNode != null) {
                            JPopupMenu popupMenu = new JPopupMenu();
                            
                            // Vérifiez si le nœud sélectionné est "src" ou "web"
                            if (selectedNode.toString().equals("src") || selectedNode.toString().equals("web")) {
                                JMenuItem addItem = new JMenuItem("Ajouter un nouveau fichier");
                                addItem.addActionListener(actionEvent -> {
                                    new DocumentAddPage(project_name, proj_id, selectedNode.toString()).setVisible(true);
                                });
                                popupMenu.add(addItem);
                            } else if (!selectedNode.isRoot() && (selectedNode.getParent().toString().equals("src") || selectedNode.getParent().toString().equals("web"))) {
                                // Les options "Supprimer" et "Ouvrir" sont disponibles pour les sous-fichiers de "src" ou "web"
                                JMenuItem deleteItem = new JMenuItem("Supprimer");
                                deleteItem.addActionListener(actionEvent -> {
                                    // Appeler la fonction qui supprime le fichier dans la base de données
                                    deleteFileFromDatabase(selectedNode.toString());
                                });
                                popupMenu.add(deleteItem);
                                
                                JMenuItem openItem = new JMenuItem("Ouvrir");
                                openItem.addActionListener(actionEvent -> {
                                    // Appeler la fonction qui ouvre le fichier
                                    openFile(selectedNode.toString());
                                });
                                popupMenu.add(openItem);
                                
                                JMenuItem downloadItem = new JMenuItem("Télécharger");
                                downloadItem.addActionListener(actionEvent -> {
                                    // Call the function that handles file download
                                    downloadFile(selectedNode.toString());
                                });
                                popupMenu.add(downloadItem);
                            }
                            
                            popupMenu.show(Ressources_Projet, e.getX(), e.getY());
                        }
                    }
                }

                
                
             // Function to open the file
                private void openFile(String fileName) {
                    try {
                        // Retrieve the file from the database
                        File fileToOpen = getFileFromDatabase(fileName);
                        if (fileToOpen != null) {
                            Desktop.getDesktop().open(fileToOpen);
                        } else {
                            // Handle the case where the file is not found or cannot be retrieved
                            JOptionPane.showMessageDialog(null, "Le fichier n'a pas pu être récupéré de la base de données.");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                // Function to download the file
                private void downloadFile(String fileName) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Choisissez un emplacement pour enregistrer le fichier");
                    int userSelection = fileChooser.showSaveDialog(null);
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        // Retrieve the file from the database
                        File fileToDownload = getFileFromDatabase(fileName);
                        if (fileToDownload != null) {
                            // Implement the logic to save the file to the chosen location
                            try {
                                Files.copy(fileToDownload.toPath(), fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                JOptionPane.showMessageDialog(null, "Le fichier a été téléchargé avec succès.");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            // Handle the case where the file is not found or cannot be retrieved
                            JOptionPane.showMessageDialog(null, "Le fichier n'a pas pu être récupéré de la base de données.");
                        }
                    }
                }

                private File getFileFromDatabase(String fileName) {
                    File file = null;
                    PreparedStatement pstmt = null;
                    ResultSet rs = null;
                    InputStream input = null;
                    FileOutputStream output = null;

                    try {
                        String sql = "SELECT contenu FROM document WHERE titre = ? AND IdProjet = ?";
                        pstmt = con.prepareStatement(sql);
                        pstmt.setString(1, fileName.substring(0, fileName.lastIndexOf(".")));
                        pstmt.setInt(2, proj_id);
                        rs = pstmt.executeQuery();

                        if (rs.next()) {
                            Blob blob = rs.getBlob("contenu");
                            input = blob.getBinaryStream();
                            
                            // Create a temporary file to store the blob content
                            file = File.createTempFile("downloaded_", fileName);
                            output = new FileOutputStream(file);

                            byte[] buffer = new byte[4096];
                            int bytesRead = -1;
                            while ((bytesRead = input.read(buffer)) != -1) {
                                output.write(buffer, 0, bytesRead);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        // Close resources
                        try {
                            if (output != null) output.close();
                            if (input != null) input.close();
                            if (rs != null) rs.close();
                            if (pstmt != null) pstmt.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return file;
                }

				private void deleteFileFromDatabase(String title) {
					
					try 
					{
						PreparedStatement ps = con.prepareStatement("DELETE FROM document WHERE titre = ? and IdProjet = ?");
						ps.setString(1, title.substring(0, title.lastIndexOf(".")));
						ps.setInt(2,proj_id);
						ps.executeUpdate();
						
					}catch (Exception e)
					{
						System.out.println(e);
					}
					JOptionPane.showMessageDialog(null, "Document has been deleted ", "Notif", JOptionPane.ERROR_MESSAGE);
                   
				}
            });
            
            

            
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridwidth = 6;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.ipadx = 814;
            gridBagConstraints.ipady = 344;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            gridBagConstraints.insets = new java.awt.Insets(20, 20, 18, 0);
            contenu.add(jScrollPane1, gridBagConstraints);

            adhesion.setBackground(new java.awt.Color(153, 0, 204));
            adhesion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
            adhesion.setForeground(new java.awt.Color(255, 255, 255));
            adhesion.setText("Adhésion");
            adhesion.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    adhesionActionPerformed(evt);
                }
            });
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.ipadx = 24;
            gridBagConstraints.ipady = 32;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
            contenu.add(adhesion, gridBagConstraints);

            body.add(contenu, java.awt.BorderLayout.CENTER);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
            );

            pack();
    }

 
    private void membresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membresActionPerformed
        MembersPage mp = new MembersPage(info);
        mp.RemplirTable(info.getNom_court());
        mp.setVisible(true);
        mp.setSize(1900, 1000);
        mp.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_membresActionPerformed

    private void ressourcesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ressourcesActionPerformed
    	RessourcesPage rsp = new RessourcesPage(info);
        rsp.setVisible(true);
        rsp.setLocationRelativeTo(null);
        rsp.setSize(950, 550);
        this.setVisible(false);
    }//GEN-LAST:event_ressourcesActionPerformed

   

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
    	AboutPage rsp = new AboutPage(info);
        rsp.setVisible(true);
        rsp.setLocationRelativeTo(null);
        rsp.setSize(950, 550);
        this.setVisible(false);
    }//GEN-LAST:event_aboutActionPerformed

    

    private void adhesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adhesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adhesionActionPerformed

    private void AgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaActionPerformed
        AgendaPage ag = new AgendaPage(info);
        ag.RemplirTable(info.getIdprojetAboutPage());
        ag.setLocationRelativeTo(null);
        ag.setVisible(true);
        ag.setSize(950, 550);
        this.setVisible(false);
    }//GEN-LAST:event_AgendaActionPerformed

    
    private javax.swing.JButton Agenda;
    private javax.swing.JLabel P4P;
    private javax.swing.JTree Ressources_Projet;
    private javax.swing.JLabel Username;
    private javax.swing.JButton about;
    private javax.swing.JButton adhesion;
    private javax.swing.JPanel body;
    private javax.swing.JPanel contenu;
    private javax.swing.JPanel header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton membres;
    private javax.swing.JButton ressources;
    protected static String project_name ;
    protected static String username_var ;
    protected String date ;
    protected String Description ;
    protected int proj_id ;
    public static Connection con = Utilitaire.getConnection();
   
}