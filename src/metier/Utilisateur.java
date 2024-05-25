package metier;

import java.sql.*;
import java.util.Vector;

public class Utilisateur {
	int idUser;
	String username;
	String passwd;
	String email;
	String fullname;
	public Utilisateur(int idUser, String username, String passwd, String email, String fullname) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.passwd = passwd;
		this.email = email;
		this.fullname = fullname;
	}
        public Utilisateur(){
            this(0,"","","","");
        }
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullname;
	}
	public void setFullName(String fullname) {
		this.fullname = fullname;
	}
	
	
	public void affiche() {
		System.out.println(idUser +" \t "+ username +" \t " + " \t " + email + " \t " + fullname);
	}
        Connection conn = Utilitaire.getConnection();
        public Vector<Utilisateur> displayUsers() {
            Vector<Utilisateur> vetu = new Vector<Utilisateur>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
			while (rs.next()) {
				//(int idUser, String username, String passwd, String email, String name)
                            vetu.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			} 
		} catch (Exception e) {
			System.out.println("Exception : "+ e);
		}
		return vetu;
	}

}
