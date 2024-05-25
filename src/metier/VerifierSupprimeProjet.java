package metier;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
//import java.lang.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author zakar
 */
public class VerifierSupprimeProjet extends javax.swing.JFrame {
	Connection conn = Utilitaire.getConnection();

    /**
     * Creates new form VerifierSupprimeProjet
     */
    public VerifierSupprimeProjet(int idProjet) {
        
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Do you really want to delete this project?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 17, 0, 11);
        jPanel1.add(jLabel1, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton1.setText("Yes");
        JFrame ButtonContainer = this;
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                acceptButtonActionPerformed(evt, idProjet);
                ButtonContainer.dispose();
            }
            
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 100, 23, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void acceptButtonActionPerformed(ActionEvent evt, int idProjet) {
        try {
            if (idProjet <= 0) {
                System.out.println("Invalid parameters provided.");
                return;
            }

            // Désactiver l'auto-commit
            conn.setAutoCommit(false);

            // Désactiver temporairement les contraintes de clés étrangères
            Statement stmt = conn.createStatement();
            stmt.execute("SET FOREIGN_KEY_CHECKS = 0;");

            PreparedStatement pstmt0 = conn.prepareStatement("SELECT idGroupe FROM GROUPE WHERE nom_groupe = (SELECT nom_court FROM PROJET WHERE IdProjet = ?)");
            pstmt0.setInt(1, idProjet);
            ResultSet rs = pstmt0.executeQuery();
            if (!rs.next()) {
                System.out.println("No group found for the given project.");
                return;
            }
            int idGroupe = rs.getInt(1);

            PreparedStatement pstmt1 = conn.prepareStatement("DELETE FROM PROJET WHERE idProjet = ?");
            PreparedStatement pstmt2 = conn.prepareStatement("DELETE FROM GROUPE WHERE idGroupe = ? OR idGroupe = ?");
            PreparedStatement pstmt3 = conn.prepareStatement("DELETE FROM UTILISATEUR_GROUPE WHERE idGroupe = ? OR idGroupe = ?");
            PreparedStatement pstmt4 = conn.prepareStatement("DELETE FROM EVENEMENT WHERE idProjet = ?");
            PreparedStatement pstmt5 = conn.prepareStatement("DELETE FROM MESSAGE WHERE idProjet = ?");
            PreparedStatement pstmt6 = conn.prepareStatement("DELETE FROM DOCUMENT WHERE idProjet = ?");
            PreparedStatement pstmt7 = conn.prepareStatement("DELETE FROM DEMANDE WHERE idProjet = ?");

            pstmt1.setInt(1, idProjet);
            pstmt2.setInt(1, idGroupe);
            pstmt2.setInt(2, idGroupe + 1);
            pstmt3.setInt(1, idGroupe);
            pstmt3.setInt(2, idGroupe + 1);
            pstmt4.setInt(1, idProjet);
            pstmt5.setInt(1, idProjet);
            pstmt6.setInt(1, idProjet);
            pstmt7.setInt(1, idProjet);

            int totalAffected = pstmt7.executeUpdate() + pstmt4.executeUpdate() + pstmt5.executeUpdate() + pstmt6.executeUpdate() + pstmt3.executeUpdate() + pstmt2.executeUpdate() + pstmt1.executeUpdate();

            if (totalAffected >= 5) {
                System.out.println("All statements executed successfully.");
            } else {
                System.out.println("Some statements failed. Total affected rows: " + totalAffected);
            }

            // Réactiver les contraintes de clés étrangères
            stmt.execute("SET FOREIGN_KEY_CHECKS = 1;");

            // Commit des transactions
            conn.commit();

            rs.close();
            pstmt0.close();
            pstmt1.close();
            pstmt2.close();
            pstmt3.close();
            pstmt4.close();
            pstmt5.close();
            pstmt6.close();
            pstmt7.close();
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


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerifierSupprimeProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerifierSupprimeProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerifierSupprimeProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerifierSupprimeProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
