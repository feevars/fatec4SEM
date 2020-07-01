package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

	private static final String URL = "jdbc:mariadb://localhost:3307/FreeTech?allowMultiQueries=true";
	private static final String USER = "root";
<<<<<<< HEAD
	private static final String PASS = "blackout";
=======
	private static final String PASS = "root";
>>>>>>> 4f84e2de181e53756c16c01ca8838d3156e12eca
	
	public DaoFactory() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(URL , USER , PASS);
		}catch (SQLException s) {
			throw new RuntimeException(s);
		}
		
	}
	

	
}
