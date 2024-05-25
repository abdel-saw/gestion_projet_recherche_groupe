package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Vector;

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! will not be used in the future !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Operateur {
	Vector<Utilisateur> vetu = new Vector<Utilisateur>();
	Connection conn = Utilitaire.getConnection();

	public Vector<Utilisateur> displayUsers() {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
			while (rs.next()) {
				//(int idUser, String username, String passwd, String email, String name, String prenom)
                            vetu.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			} 
		} catch (Exception e) {
			System.out.println("Exception : "+ e);
		}
		return vetu;
	}
	//-------------------------------------------
	public void ajouterUser(String username, String passwd, String email, String name, String surname) {
	    try {
	        PreparedStatement ps = conn.prepareStatement("INSERT INTO USERS (username, passwd, email, name, surname) VALUES (?, ?, ?, ?, ?)");
	        ps.setString(1, username);
	        ps.setString(2, passwd);
	        ps.setString(3, email);
	        ps.setString(4, name);
	        ps.setString(5, surname);
	        
	        ps.executeUpdate();
	        System.out.println("User added successfully!");
	        
	    } catch (Exception e) {
	        System.out.println("Exception : " + e);
	    }
	}
        //----------------------------------------------
    public boolean userExists(String username) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        return false;
    }
    //--------------------------------------------------
 	//-------------------------------------------
	/*public Abonnement retournerAbonnement(int numAb) {
		int idCl;
		Client cl;
		Abonnement ab;
		Vector<Facture> lesfactures = new Vector<Facture>();
		AbonnementGSM abGSM;
		AbonnementFixe abFixe;
		try {
			// Selectionner l'abonnement qui a ce numéro
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ABONNEMENT WHERE NUM_AB=?");
			ps.setInt(1, numAb);
			ResultSet rs = ps.executeQuery();
			// Positionner le curseur sur le premier ligne
			rs.next();
			idCl = rs.getInt(5);
			// Selectionner les informations du client propriataire de cet abonnement
			PreparedStatement ps1 = conn.prepareStatement("SELECT *FROM CLIENT WHERE ID_CLIENT=?");
			ps1.setInt(1, idCl);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			
			
		}catch(Exception e){
			System.out.println("Exception :"+e);
			
		}
		return null;
	}
	// Ajouter un client
	public void ajouterClient(int id, String nom, String email, String tel, String ville) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO CLIENT (ID_CLIENT, NOM, EMAIL, TEL, VILLE)");
			ps.setInt(1, id);
			ps.setString(2, nom);
			ps.setString(3, email);
			ps.setString(4, tel);
			ps.setString(5, ville);
			ps.executeUpdate();
			ps.close();
			conn.close();

		}catch(Exception e) {
			System.out.println("Exception : "+ e);
		}
	}
	// Régler une facture
	public void reglerFacture(int num, String date, double montant, boolean reglee) {
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE  (ID_CLIENT, NOM, EMAIL, TEL, VILLE)");
			ps.setInt(1, num);
			ps.setString(2, date);
			ps.setDouble(3, montant);
			ps.setBoolean(4, reglee);
			ps.executeUpdate();
			ps.close();
			conn.close();

		}catch(Exception e) {
			System.out.println("Exception : "+ e);
		}
	
	}*/
}