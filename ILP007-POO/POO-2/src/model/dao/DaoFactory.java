package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

	private static final String URL = "jdbc:mariadb://localhost/FreeTech?allowMultiQueries=true";
	private static final String USER = "root";
<<<<<<< HEAD
	private static final String PASS = "root";
=======

	private static final String PASS = "F3rnanda!";

>>>>>>> 14ac76dc7346e0c635cd8ad0b53f5830ff6a50ad
	
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
