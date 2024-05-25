package metier;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class VerifierSupprissionCompte extends JFrame {

    private int userId;
    Connection conn = Utilitaire.getConnection();

    public VerifierSupprissionCompte(int userId) {
        this.userId = userId;

        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setLayout(new GridBagLayout());

        jLabel1.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new Color(0, 0, 102));
        jLabel1.setText("Vous voulez vraiment supprimer cet utilisateur ?");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(20, 20, 0, 8);
        jPanel1.add(jLabel1, gridBagConstraints);

        jButton1.setBackground(new Color(255, 0, 0));
        jButton1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("Oui");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 100, 27, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        jLabel2.setIcon(new ImageIcon(getClass().getResource("assets/pngwing.com (1).png"))); // NOI18N
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 110, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        getContentPane().add(jPanel1, BorderLayout.CENTER);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser(userId);
                dispose();
            }
        });

        pack();
    }

    private void deleteUser(int userId) {
        try {
            conn.setAutoCommit(false);

            

            // Suppression des enregistrements associés de la table utilisateur_groupe
            String deleteUserGroupQuery = "DELETE FROM utilisateur_groupe WHERE IdUtilisateur = ?";
            try (PreparedStatement ps = conn.prepareStatement(deleteUserGroupQuery)) {
                ps.setInt(1, userId);
                ps.executeUpdate();
            }

            // Suppression des enregistrements associés de la table invitation_demande
            String deleteInvitationDemandeQuery = "DELETE FROM invitation_demande WHERE host = ? OR user = ?";
            try (PreparedStatement ps = conn.prepareStatement(deleteInvitationDemandeQuery)) {
                String username = getUsernameById(userId);
                ps.setString(1, username);
                ps.setString(2, username);
                ps.executeUpdate();
            }

            // Suppression des enregistrements associés de la table message
            String deleteMessageQuery = "DELETE FROM message WHERE idSender = ?";
            try (PreparedStatement ps = conn.prepareStatement(deleteMessageQuery)) {
                ps.setInt(1, userId);
                ps.executeUpdate();
            }
         // Suppression de l'utilisateur de la table utilisateur
            String deleteUserQuery = "DELETE FROM utilisateur WHERE IdUtilisateur = ?";
            try (PreparedStatement ps = conn.prepareStatement(deleteUserQuery)) {
                ps.setInt(1, userId);
                ps.executeUpdate();
            }

            conn.commit();
            JOptionPane.showMessageDialog(this, "Utilisateur supprimé avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Erreur lors de la suppression de l'utilisateur.", "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException autoCommitEx) {
                autoCommitEx.printStackTrace();
            }
        }
    }

    private String getUsernameById(int userId) {
        String query = "SELECT username FROM utilisateur WHERE IdUtilisateur = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]) {
        new VerifierSupprissionCompte(1).setVisible(true);
    }

    // Variables declaration - do not modify
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    // End of variables declaration
}
