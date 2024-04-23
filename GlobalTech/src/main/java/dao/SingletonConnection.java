package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

	private static Connection connection;
	
	/*
	 * un bloc static qui crée la connection une seule fois
	 */
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_globaltech", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * un getter qui renvoi l'objet connection instancié une seule fois
	 */
	public static Connection getConnection()
	{
		return connection;
	}
}
