package metier;

import java.sql.*;

public class Utilitaire {
	private static Connection conn;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/projectmanagement";
			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("vous avez été bien connecté avec la base de donnée Demo!!");
			}catch(Exception e) {
			System.out.println("Erreur lors du charggement de Driver:" + e);
		}
	}
	public static Connection getConnection()
	{
		return conn;
	}
}

