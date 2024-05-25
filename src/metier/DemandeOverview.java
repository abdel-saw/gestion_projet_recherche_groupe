package metier;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.Date;

//import java.lang.*;
import javax.swing.*;
import javax.swing.border.Border;

public class DemandeOverview extends JFrame {
	int id;
	String type;
	boolean withButtons;
	Connection conn = Utilitaire.getConnection();
	private Object[] fetchDemandesPopUp(){
    	
		
    	try {
    		
            PreparedStatement pstmt = conn.prepareStatement("SELECT nom_court_projet, description_projet, date_demande, projet_is_public, IdGroupe, IdProjet, nom_long_projet, theme_projet, type, idUtilisateur FROM DEMANDE WHERE IdDemande = ?");
            pstmt.setInt(1, this.id);
            ResultSet rs = pstmt.executeQuery();

            
            if (rs.next()) {
            	Object[] demande = {
                    	rs.getString(1),//nom_court
                    	rs.getString(2),//description
                        rs.getDate(3),//date_demande
                        rs.getInt(4),//isPublic
                        rs.getInt(5),//IdGroupe
                        rs.getInt(6),//IdProjet
                        rs.getString(7),//nom_long
                        rs.getString(8),//theme
                        rs.getString(9),//type
                        rs.getInt(10)//idUser
                        
                    };
                    
                
                return demande;
                
            	
            }
        } catch (Exception e) {
                        System.out.println("Exception : "+ e);
        }
        
		return null;
    }
	
    
    public DemandeOverview(int id, String type, boolean withButtons) {
    	this.withButtons= withButtons;
    	this.id = id;
    	this.type = type;
    	Object[] demande = fetchDemandesPopUp();
        GridBagConstraints gridBagConstraints;

        jPanel1 = new JPanel();
        //datedesc = new JLabel();
        projectName = new JLabel();
        projectEtat = new JLabel();
        rfuseButton = new JButton();
        acceptButton = new JButton();
        h1Description = new JLabel();
        date = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jPanel1, BorderLayout.CENTER); 
        jPanel1.setBackground(new Color(250, 251, 255));
        
        jPanel1.setPreferredSize(new Dimension(499, 394));
        jPanel1.setLayout(new GridBagLayout());
        getContentPane().add(jPanel1, BorderLayout.CENTER);
        
        String name = (String) demande[0];
        Date date_dm = (Date)demande[2];
        boolean isPublic = (int) demande[3] == 1 ? true : false;
        
        
        // Format the Date object as a string
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(date_dm);
        
        // Create a JLabel and set the formatted date string as its text
        JLabel dateLabel = new JLabel(formattedDate);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font if desired
        
        // Add the JLabel to the frame
        
        
        dateLabel.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dateLabel.setVerticalAlignment(SwingConstants.TOP);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 152;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(20, 10, 0, 0);
        jPanel1.add(dateLabel, gridBagConstraints);

        projectName.setFont(new Font("Segoe UI", 1, 15)); 
        projectName.setForeground(new Color(51, 0, 204));
        projectName.setHorizontalAlignment(SwingConstants.LEFT);
        
        projectName.setText("Project name :  "+ name);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 233;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(40, 30, 0, 0);
        jPanel1.add(projectName, gridBagConstraints);
        
        projectEtat.setFont(new Font("Segoe UI", 1, 17)); 
        projectEtat.setForeground(new Color(153, 204, 0));
        
        
        if((int)demande[3] == 1) {
        	projectEtat.setText("Public");
        }else {
        	projectEtat.setText("Private");
        	
        }
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(40, 60, 0, 10);
        jPanel1.add(projectEtat, gridBagConstraints);

        
        rfuseButton.setBackground(new Color(255, 51, 51));
///////////////////////////////////////////////////////////
        if(type.equalsIgnoreCase("closure") && projectEtat.getText().equalsIgnoreCase("Private")) {
        	rfuseButton.setEnabled(false);//disable the button

        }
        rfuseButton.setFont(new Font("Segoe UI", 1, 18)); 
        rfuseButton.setForeground(new Color(255, 255, 255));
        rfuseButton.setText("Refuse");
        rfuseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rfuseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                rfuseButtonActionPerformed(evt, (int)demande[5],(int) demande[4], name);
                //rfuseButtonActionPerformed(ActionEvent evt, int idProjet, int idGroupe, String nom)
                
            }
        });
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(20, 50, 14, 0);
        jPanel1.add(rfuseButton, gridBagConstraints);

    
        acceptButton.setBackground(new Color(102, 255, 102));
        acceptButton.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        acceptButton.setForeground(new Color(255, 255, 255));
        acceptButton.setText("Accept");
        acceptButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        acceptButton.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                acceptButtonActionPerformed(evt, (int) demande[9], (int)demande[5],(int) demande[4], name, (String)demande[6], (String) demande[1], (String) demande[7], (String) demande[8], isPublic);
            }//int idUser, int idProjet, int idGroupe, String nom, String nom_long, String description, String theme, String type, boolean isPublic
            /*
             * rs.getString(1),//nom_court
                	rs.getString(2),//description
                    rs.getDate(3),//date_demande
                    rs.getInt(4),//isPublic
                    rs.getInt(5),//IdGroupe
                    rs.getInt(6),//IdProjet
                    rs.getString(7),//nom_long
                    rs.getString(8),//theme
                    rs.getString(9)//type
             */
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(20, 20, 14, 0);
        jPanel1.add(acceptButton, gridBagConstraints);

        
        h1Description.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        h1Description.setForeground(new Color(51, 0, 204));
        h1Description.setHorizontalAlignment(SwingConstants.LEFT);
        h1Description.setText("Description :");
        h1Description.setVerticalAlignment(SwingConstants.TOP);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(15, 30, 0, 0);
        jPanel1.add(h1Description, gridBagConstraints);

        date.setFont(new Font("Segoe UI", 1, 15));
        date.setForeground(new Color(51, 0, 204));
        date.setHorizontalAlignment(SwingConstants.LEFT);
        
        date.setText("Date :");
        date.setVerticalAlignment(SwingConstants.TOP);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(15, 30, 0, 0);
        jPanel1.add(date, gridBagConstraints);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setFont(new Font("Segoe UI", 0, 14)); 

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new Color(248, 255, 255));
        jTextArea1.setFont(new Font("Segoe UI", 0, 13));
        jTextArea1.setLineWrap(true);
        String descp = (String) demande[1];
        jTextArea1.setText(descp);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setDisabledTextColor(new Color(0, 0, 51));
        
        jScrollPane1.setViewportView(jTextArea1);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 416;
        gridBagConstraints.ipady = 146;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 30, 0, 20);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        getContentPane().add(jPanel1);
        if(!this.withButtons){
        	acceptButton.setEnabled(false);
        	rfuseButton.setEnabled(false);
        	acceptButton.setVisible(false);
        }

        pack();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void rfuseButtonActionPerformed(ActionEvent evt, int idProjet, int idGroupe, String nom) {
    	//update the state(etat) of the demande from pending into Refused
    	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! don't forget to add the conditioning on if the type is closure or creation
    	// if it's creation then you directly refuse the demande
    	// if it's closure -> private can't refuse
    	// if it's closure -> public can refuse, but destroy the list of members and admins and the 2groups in the table groupe and user_group
    	try {
	    	if(!projectEtat.getText().equalsIgnoreCase("Private") || !type.equalsIgnoreCase("closure")) {//admin can't refuse the closure of a private project
	        	if (type.equalsIgnoreCase("creation")) {
					try {//create a function that contains the part below so that the update is not done untill the all the modification are done

						PreparedStatement pstmt = conn.prepareStatement("UPDATE DEMANDE SET etat = ? WHERE IdDemande = ?");
						pstmt.setObject(1, "Refused");
						pstmt.setInt(2, this.id);
						int et = pstmt.executeUpdate();
						if (et >= 1) {
							System.out.println("the status update has been done succesfuly");

						} else {
							System.out.println(et + "lines affected!");
							JOptionPane.showMessageDialog(null, "0 lines affected!", "Action unsuccesful",
									JOptionPane.ERROR_MESSAGE);
							Window window = SwingUtilities.getWindowAncestor((Component) evt.getSource());
							if (window != null) {
								window.dispose();
							}
							return;
						}
					} catch (Exception e) {
						System.out.println("Exception : " + e);
						JOptionPane.showMessageDialog(null, "Exception : " + e, " DataBase Connection Error",
								JOptionPane.ERROR_MESSAGE);
						Window window = SwingUtilities.getWindowAncestor((Component) evt.getSource());
						if (window != null) {
							window.dispose();
						}
						return;
					} 
				}else if(type.equalsIgnoreCase("closure")) {
	        		//destroy the relationships of admins and members with there groups, then also the group (line ine db) itself, but not the project
	        		closePublicProjectRefuse(idProjet, idGroupe);
	        		JOptionPane.showMessageDialog(null, "the update has been done succesfuly", "Action conformation", JOptionPane.OK_OPTION);
                    Window window = SwingUtilities.getWindowAncestor((Component) evt.getSource());
                    if (window != null) {
                        window.dispose();
                    }
	        	}
	    	}
	    	
	    	//JOptionPane.showMessageDialog(null, "Incorrect username or password", "Action conformation", JOptionPane.OK_OPTION);
	    	
    	} catch (Exception e) { 
    		e.printStackTrace();
	    	JOptionPane.showMessageDialog(null, "Exception : "+ e, " DataBase Connection Error", JOptionPane.ERROR_MESSAGE);
	        //this.setVisible(false);
	        Window window = SwingUtilities.getWindowAncestor((Component) evt.getSource());
	        if (window != null) {
	            window.dispose();
	        }
    	}
    }
    //-----------------------------------------
    private void closePublicProjectRefuse(int idProjet, int idGroupe) {
        try {
            System.out.println("I'm in closePublicProjectRefuse");
            if (idProjet <= 0 || idGroupe <= 0 ) {
                System.out.println("Invalid parameters provided.");
                return;
            }

            // Désactiver l'auto-commit
            conn.setAutoCommit(false);

            // Désactiver temporairement les contraintes de clés étrangères
            Statement stmt = conn.createStatement();
            stmt.execute("SET FOREIGN_KEY_CHECKS = 0;");
            
            // Opérations de mise à jour et suppression
            PreparedStatement pstmt = conn.prepareStatement("UPDATE DEMANDE SET etat = ? WHERE IdDemande = ?");
            PreparedStatement pstmt2 = conn.prepareStatement("DELETE FROM GROUPE WHERE IdGroupe = ? OR IdGroupe = ?");
            PreparedStatement pstmt3 = conn.prepareStatement("DELETE FROM UTILISATEUR_GROUPE WHERE IdGroupe = ? OR IdGroupe = ?");
            PreparedStatement pstmt4 = conn.prepareStatement("UPDATE PROJET SET etat = 'Closed' WHERE IdProjet = ?");
            
            pstmt.setObject(1, "Refused");
            pstmt.setInt(2, this.id);
            
            pstmt2.setInt(1, idGroupe - 1);
            pstmt2.setInt(2, idGroupe);
            
            pstmt3.setInt(1, idGroupe - 1);
            pstmt3.setInt(2, idGroupe);
            
            pstmt4.setInt(1, idProjet);
            
            int et = pstmt.executeUpdate() + pstmt2.executeUpdate() + pstmt3.executeUpdate(); 
            int updt = pstmt4.executeUpdate();
            
            if (et + updt >= 4) {
                System.out.println("The delete has been done successfully; " + et + " lines affected!");
            } else {
                System.out.println(et + " lines affected!");
            }
            
            // Réactiver les contraintes de clés étrangères
            stmt.execute("SET FOREIGN_KEY_CHECKS = 1;");
            
            // Commit des transactions
            conn.commit();
            pstmt2.close();
            pstmt3.close();
            pstmt4.close();
        } catch (Exception e) {
            try {
                // Rollback en cas d'erreur
                conn.rollback();
            } catch (SQLException se) {
                System.out.println("Rollback exception: " + se);
            }
            System.out.println("Exception: " + e);
        } finally {
            try {
                // Réactiver l'auto-commit
                conn.setAutoCommit(true);
            } catch (SQLException se) {
                System.out.println("Auto-commit exception: " + se);
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////-
    private void acceptButtonActionPerformed(ActionEvent evt,int idUser, int idProjet, int idGroupe, String nom_court, String nom_long, String description, String theme, String type, boolean isPublic) {
    	//update the state(etat) of the demande from pending into Accepted
    	//create the project with information provided by the user(demander) 
    		//idprojet (auto_inc), etc du columns
    	//create 2 groups (admins, and members) and the userid that demanded as the first admin for the group/project that means adding the relationship between this iduser and the idgroup(admin)
    	//ps: idadmin = idmember +(-) 1;
    	//if it's closure -> public destroy everything the project line, 2 groupe lines(grpadmin, grpmember), all the realtionships lines in group_utilisateur(DELETE * FROM UTIL_GRP WHERE IDGROUP= idgrp_admin and (+-1)idgrp_membre
    	//if it's creation -> public and private (no condition) the only diff is in the insert line (etat: private ou public)

    	if(type.equalsIgnoreCase("closure")) {
        	//if it's closure -> public destroy everything the project line, 2 groupe lines(grpadmin, grpmember),
    		//all the realtionships lines in group_utilisateur(DELETE * FROM UTIL_GRP WHERE IDGROUP= idgrp_admin and (+-1)idgrp_membre;
    		//and all the ressource related to idprojet
    		closeProjectAccept(idProjet,idGroupe, nom_court);
    		JOptionPane.showMessageDialog(null, "the project was closed succesfuly", "Action conformation", JOptionPane.OK_OPTION);
            Window window = SwingUtilities.getWindowAncestor((Component) evt.getSource());
            if (window != null) {
                window.dispose();
            }
    	}else if(type.equalsIgnoreCase("creation")) {
    		createProject(idUser, nom_court, nom_long, description, theme, type, isPublic);
    		
    		JOptionPane.showMessageDialog(null, "the project was created succesfuly", "Action conformation", JOptionPane.OK_OPTION);
            Window window = SwingUtilities.getWindowAncestor((Component) evt.getSource());
            if (window != null) {
                window.dispose();
            }
    	}
    	
    }
    //-----------------------------------------
    private void createProject(int idUser, String nom_court, String nom_long, String description, String theme, String type, boolean isPublic) {
        try {
            conn.setAutoCommit(false); // Démarrer la transaction

            // Désactiver les contraintes de clés étrangères
            PreparedStatement disableFK = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
            disableFK.executeUpdate();

            // Préparer les instructions SQL
            
                PreparedStatement pstmt = conn.prepareStatement("UPDATE DEMANDE SET etat = ? WHERE IdDemande = ?");   
            PreparedStatement pstmt1 = conn.prepareStatement("INSERT INTO PROJET(nom_court, nom_long, description, isPublic, theme, type, etat) VALUES(?, ?, ?, ?, ?, ?, 'Enabled')");
            PreparedStatement pstmt2 = conn.prepareStatement("INSERT INTO GROUPE(nom_groupe) VALUES (?)");
            PreparedStatement pstmt3 = conn.prepareStatement("INSERT INTO GROUPE(nom_groupe) VALUES (?)");
            PreparedStatement pstmt4 = conn.prepareStatement("INSERT INTO UTILISATEUR_GROUPE(idUtilisateur, idGroupe) VALUES(?, (SELECT idGroupe FROM GROUPE WHERE nom_groupe = ?))");
            PreparedStatement pstmt6 = conn.prepareStatement("SELECT idProjet FROM PROJET WHERE nom_court = ?");

            // Définir les paramètres pour les instructions SQL
            
            pstmt.setObject(1,"Accepted");
            pstmt.setInt(2, this.id);  
            pstmt1.setString(1, nom_court);
            pstmt1.setString(2, nom_long);
            pstmt1.setString(3, description);
            pstmt1.setBoolean(4, isPublic);
            pstmt1.setString(5, theme);
            pstmt1.setString(6, type);

            pstmt2.setString(1, nom_court);
            pstmt3.setString(1, nom_court + "-adm");

            pstmt4.setInt(1, idUser);
            pstmt4.setString(2, nom_court + "-adm");

            // Exécuter les instructions SQL
            int et =pstmt.executeUpdate() +  pstmt1.executeUpdate() + pstmt2.executeUpdate() + pstmt3.executeUpdate() + pstmt4.executeUpdate();

            pstmt6.setString(1, nom_court);
            ResultSet rs = pstmt6.executeQuery();
            if (rs.next()) {
                int idProjet = rs.getInt(1);

                PreparedStatement pstmt5 = conn.prepareStatement("INSERT INTO EVENEMENT (titre_evenement, description_evenement, idProjet) VALUES ('creation', 'creation du projet', ?)");
                PreparedStatement pstmt7 = conn.prepareStatement("UPDATE DEMANDE SET IdProjet = ? WHERE IdDemande = ?");
                pstmt7.setInt(1, idProjet);
                pstmt7.setInt(2, id);
                pstmt5.setInt(1, idProjet);
                pstmt7.executeUpdate();
                et += pstmt5.executeUpdate();
            }

            // Réactiver les contraintes de clés étrangères
            PreparedStatement enableFK = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=1;");
            enableFK.executeUpdate();

            // Valider la transaction si tout est réussi
            if (et > 0) {
                conn.commit();
                pstmt1.close();
                pstmt2.close();
                pstmt3.close();
                pstmt4.close();
                pstmt6.close();
                System.out.println("The update(creation) has been done successfully");
            } else {
                conn.rollback();
                System.out.println("Creation of the project was not fully done");
            }
        } catch (Exception e) {
            try {
                // Annuler la transaction en cas d'exception
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Exception during rollback: " + ex);
            }
            System.out.println("Exception: " + e);
        } finally {
            try {
                // Réinitialiser le mode de commit automatique
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                System.out.println("Exception during setting auto commit: " + ex);
            }
        }
    }

    //-----------------------------------------
    private void closeProjectAccept(int idProjet, int idGroupe, String nom_court) {
        try {
            if (idProjet <= 0 || idGroupe <= 0 || nom_court == null || nom_court.isEmpty()) {
                System.out.println("Invalid parameters provided.");
                return;
            }

            // Désactiver l'auto-commit
            conn.setAutoCommit(false);

            // Désactiver temporairement les contraintes de clés étrangères
            Statement stmt = conn.createStatement();
            stmt.execute("SET FOREIGN_KEY_CHECKS = 0;");
            
            // Opérations de suppression
            PreparedStatement pstmt = conn.prepareStatement("UPDATE DEMANDE SET etat = ? WHERE IdDemande = ?"); 
            PreparedStatement pstmt1 = conn.prepareStatement("DELETE FROM PROJET WHERE idProjet = ?");
            PreparedStatement pstmt2 = conn.prepareStatement("DELETE FROM GROUPE WHERE idGroupe = ? OR idGroupe = ?");
            PreparedStatement pstmt3 = conn.prepareStatement("DELETE FROM UTILISATEUR_GROUPE WHERE idGroupe = ? OR idGroupe = ?");
            PreparedStatement pstmt4 = conn.prepareStatement("DELETE FROM EVENEMENT WHERE idProjet = ?");
            PreparedStatement pstmt5 = conn.prepareStatement("DELETE FROM MESSAGE WHERE idProjet = ?");
            PreparedStatement pstmt6 = conn.prepareStatement("DELETE FROM DOCUMENT WHERE idProjet = ?");
            pstmt.setObject(1,"Accepted");
            pstmt.setInt(2, this.id);  
            pstmt1.setInt(1, idProjet);
            pstmt2.setInt(1, idGroupe);
            pstmt2.setInt(2, idGroupe - 1);
            pstmt3.setInt(1, idGroupe);
            pstmt3.setInt(2, idGroupe - 1);
            pstmt4.setInt(1, idProjet);
            pstmt5.setInt(1, idProjet);
            pstmt6.setInt(1, idProjet);

            int totalAffected = pstmt.executeUpdate() + pstmt4.executeUpdate() + pstmt5.executeUpdate() + pstmt6.executeUpdate() + pstmt3.executeUpdate() + pstmt2.executeUpdate() + pstmt1.executeUpdate();
            
            if (totalAffected >= 7) {
                System.out.println("All statements executed successfully.");
            } else {
                System.out.println("Some statements failed. Total affected rows: " + totalAffected);
            }
            
            // Réactiver les contraintes de clés étrangères
            stmt.execute("SET FOREIGN_KEY_CHECKS = 1;");
            
            // Commit des transactions
            conn.commit();
            pstmt1.close();
            pstmt2.close();
            pstmt3.close();
            pstmt4.close();
            pstmt5.close();
            pstmt6.close();
        } catch (Exception e) {
            try {
                // Rollback en cas d'erreur
                conn.rollback();
            } catch (SQLException se) {
                System.out.println("Rollback exception: " + se);
            }
            System.out.println("Exception: " + e);
        } finally {
            try {
                // Réactiver l'auto-commit
                conn.setAutoCommit(true);
            } catch (SQLException se) {
                System.out.println("Auto-commit exception: " + se);
            }
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String args[]) {
        new DemandeOverview(1,"",true).setVisible(true);
    }

    public JButton getAcceptButton() {
		return acceptButton;
	}


	public void setAcceptButton(JButton acceptButton) {
		this.acceptButton = acceptButton;
	}
	public void setAcceptVisible(boolean etat) {
		this.acceptButton.setVisible(etat);
	}
	public void setRefuseVisible(boolean etat) {
		this.rfuseButton.setVisible(etat);
	}

	public JButton getRfuseButton() {
		return rfuseButton;
	}


	public void setRfuseButton(JButton rfuseButton) {
		this.rfuseButton = rfuseButton;
	}

	// Variables declaration - do not modify                     
    private JButton acceptButton;
    private JLabel date;
    private JLabel datedesc;
    private JLabel h1Description;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JLabel projectEtat;
    private JLabel projectName;
    private JButton rfuseButton;
    // End of variables declaration                   
}
