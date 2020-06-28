package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

	private static final String URL = "jdbc:mariadb://localhost:3307/FreeTech?allowMultiQueries=true";
	private static final String USER = "root";
<<<<<<< HEAD
	private static final String PASS = "F3rnanda!";
=======
	private static final String PASS = "blackout";
>>>>>>> 16615cee59dc0f6f9a1747dd6ea266e7a95fe19f
	
	public DaoFactory() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			System.out.println("Conectado ao banco de dados!");
			return DriverManager.getConnection(URL , USER , PASS);
		}catch (SQLException s) {
			throw new RuntimeException(s);
		}
		
	}
	

	
}
