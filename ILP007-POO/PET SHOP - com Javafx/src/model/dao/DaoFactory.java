package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

	private static final String URL = "jdbc:mariadb://localhost/FreeTech?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "F3rnanda!";
	
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
